package web.trabalhofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import web.trabalhofinal.repository.UsuarioRepository;
import web.trabalhofinal.service.EjService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EjService usuarioService;
}
