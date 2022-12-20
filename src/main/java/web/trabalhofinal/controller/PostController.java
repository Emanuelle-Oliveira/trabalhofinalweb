package web.trabalhofinal.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.trabalhofinal.model.Cliente;
import web.trabalhofinal.model.Ej;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.Proposta;
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
	public String cadastrar(@Valid Post post, BindingResult resultado, Principal principal, Model model) {
		
		if(resultado.hasErrors()) {
			return "post/cadastrar";
		}else {
			LocalDateTime agora = LocalDateTime.now();
			post.setDataHora(agora);
			Cliente cliente = usuarioRepository.findClienteByEmail(principal.getName());
			
			post.setCliente(cliente);
			postService.salvar(post);
			return "redirect:/post/listar";
		}
	}
	
	@GetMapping("/abrirlistar")
	public String abrirListar(Proposta proposta, Model model) {
		
		List<Cliente> cliente = usuarioRepository.findClientesAtivos();
		model.addAttribute("cliente", cliente);
		
		return "post/listar";
	}

	@GetMapping("/listar")
	public String listar(PostFilter filtro, Model model,
			@PageableDefault(size = 5) @SortDefault(sort = "dataHora", direction = Sort.Direction.DESC) Pageable pageable,
			HttpServletRequest request, Proposta proposta, Principal principal) {

		model.addAttribute("principal", principal);
		
		List<Cliente> cliente = usuarioRepository.findClientesAtivos();
		model.addAttribute("cliente", cliente);
		
		Page<Post> pagina = postRepository.pesquisar(filtro, pageable);
		PageWrapper<Post> paginaWrapper = new PageWrapper<>(pagina, request);
		model.addAttribute("pagina", paginaWrapper);

		List<Post> posts = postRepository.findAll();
		model.addAttribute("posts", posts);
		
		List<Ej> ej = usuarioRepository.findEjsAtivas();
		model.addAttribute("ej", ej);
		
		return "post/listar";
	}
	
	@GetMapping("/abriratualizar")
	public String abrirAtualizar(Proposta proposta, Post post, Model model) {

		model.addAttribute("propostaEscolhida", post.getPropostaEscolhida().getId());
		
		return "post/atualizar";
	}
	
	@PostMapping("/atualizar")
	public String atualizar(Proposta proposta, Model model, Post post) {
		
		Post post2 = postRepository.findPostById((post.getId()));
		
		post2.setPropostaEscolhida(post.getPropostaEscolhida());
		post2.getPropostaEscolhida().setId(post.getPropostaEscolhida().getId());
			
		postService.atualizar(post2);
		return "redirect:/post/listar";
	}

}
