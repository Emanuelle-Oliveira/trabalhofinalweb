package web.trabalhofinal.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.trabalhofinal.model.Cliente;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.repository.PostRepository;
import web.trabalhofinal.repository.UsuarioRepository;
import web.trabalhofinal.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostService postService;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/abrircadastrar")
	public String abrirCadastrar(Post post) {
		return "post/cadastrar";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Post post) {
		Cliente cliente = new Cliente();
		cliente.setNome("teste");
		usuarioRepository.save(cliente);
		LocalDateTime agora = LocalDateTime.now();
		post.setCliente(cliente);
		post.setDataHora(agora);
		postService.salvar(post);
		return "post/cadastrar";
	}

}
