package web.trabalhofinal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.trabalhofinal.model.Status;
import web.trabalhofinal.model.Usuario;
import web.trabalhofinal.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("buscar")
	public List<Usuario> buscar() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("buscar/cliente")
	public List<Usuario> buscarCliente() {
		return usuarioRepository.findClientesAtivos();
	}
	
	@GetMapping("buscar/ej")
	public List<Usuario> buscarEj() {
		return usuarioRepository.findEjsAtivas();
	}

}
