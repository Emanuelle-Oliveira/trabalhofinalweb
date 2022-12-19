package web.trabalhofinal.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.trabalhofinal.model.Ej;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.Proposta;
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

}
