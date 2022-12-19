package web.trabalhofinal.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.trabalhofinal.model.Cliente;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.filter.PostFilter;
import web.trabalhofinal.pagination.PageWrapper;
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
	public String cadastrar(Post post, Principal principal, Model model) {
		LocalDateTime agora = LocalDateTime.now();
		post.setDataHora(agora);
		Cliente cliente = usuarioRepository.findByEmail(principal.getName());
		
		post.setCliente(cliente);
		postService.salvar(post);
		return "redirect:/post/listar";
	}

	@GetMapping("/listar")
	public String listar(PostFilter filtro, Model model,
			@PageableDefault(size = 5) @SortDefault(sort = "dataHora", direction = Sort.Direction.DESC) Pageable pageable,
			HttpServletRequest request) {
		Page<Post> pagina = postRepository.pesquisar(filtro, pageable);
		PageWrapper<Post> paginaWrapper = new PageWrapper<>(pagina, request);
		model.addAttribute("pagina", paginaWrapper);
		return "post/listar";
	}

}
