package web.trabalhofinal.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	public List<Usuario> buscarTodosUsuarios() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("buscar/cliente")
	public List<Usuario> buscarClientes() {
		return usuarioRepository.findClientesAtivos();
	}
	
	/*@GetMapping("buscar/ej")
	public List<Usuario> buscarEjs() {
		Sort sort = Sort.by("nome").ascending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		return usuarioRepository.findEjsAtivas(paginacao);
	}*/
	
	@GetMapping("buscar/id")
	public Optional<Usuario> buscarUsuarioId(Long id) {
		id = (long) 5;
		return usuarioRepository.findById(id);
	}

}
