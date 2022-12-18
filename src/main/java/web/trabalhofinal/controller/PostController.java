package web.trabalhofinal.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.repository.PostRepository;
import web.trabalhofinal.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private PostService postService;
	
	@GetMapping("/abrircadastrar")
	public String abrirCadastrar(Post post) {
		return "post/cadastrar";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Post post) {
		LocalDateTime agora = LocalDateTime.now();
		post.setDataHora(agora);
		postService.salvar(post);
		return "post/cadastrar";
	}

}
