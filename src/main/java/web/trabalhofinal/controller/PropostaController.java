package web.trabalhofinal.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

import web.trabalhofinal.model.Ej;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.Proposta;
import web.trabalhofinal.model.Usuario;
import web.trabalhofinal.model.filter.PropostaFilter;
import web.trabalhofinal.pagination.PageWrapper;
import web.trabalhofinal.repository.PropostaRepository;
import web.trabalhofinal.repository.UsuarioRepository;
import web.trabalhofinal.service.PropostaService;

@Controller
@RequestMapping("/proposta")
public class PropostaController {

	@Autowired
	private PropostaRepository propostaRepository;

	@Autowired
	private PropostaService propostaService;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/abrircadastrar")
	public String abrirCadastrar(Proposta proposta, Post post) {
		return "proposta/cadastrar";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Proposta proposta, Principal principal, Model model, Post post) {
		LocalDateTime agora = LocalDateTime.now();
		proposta.setDataHora(agora);
		proposta.setPost(post);
		Ej ej = usuarioRepository.findEjByEmail(principal.getName());
		proposta.setEj(ej);
		propostaService.salvar(proposta);
		return "redirect:/post/listar";
	}
	
	@GetMapping("/listar")
	public String listar(PropostaFilter filtro, Model model, @PageableDefault(size = 10) 
	@SortDefault(sort = "dataHora", direction = Sort.Direction.ASC) Pageable pageable,
			HttpServletRequest request, Proposta proposta, Post post) {
				
		Page<Proposta> pagina = propostaRepository.pesquisar(filtro, pageable, post);
		PageWrapper<Proposta> paginaWrapper = new PageWrapper<>(pagina, request);
		model.addAttribute("pagina", paginaWrapper);
		
		return "/proposta/listar";
	}
	

}
