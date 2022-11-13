package web.trabalhofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.trabalhofinal.model.Ej;
import web.trabalhofinal.repository.UsuarioRepository;
import web.trabalhofinal.service.UsuarioService;

@Controller
@RequestMapping("/ej")
public class EjController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/abrircadastrar")
	public String abrirCadastrar(Ej ej) {
		return "ej/cadastrar";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Ej ej) {
		usuarioRepository.save(ej);
		return "ej/cadastrar";
	}
	
	@GetMapping("/abrirpesquisar")
	public String abrirPesquisar(Ej ej) {
		return "ej/pesquisar";
	}
}
