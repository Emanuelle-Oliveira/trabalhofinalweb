package web.trabalhofinal.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.trabalhofinal.model.Categoria;
import web.trabalhofinal.model.Cliente;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.Status;
import web.trabalhofinal.repository.PostRepository;

@RestController
@RequestMapping("/api/post")
public class PostRest {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("buscar")
	public List<Post> buscarTodosPosts() {
		Sort sort = Sort.by("dataHora").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		return postRepository.findByStatus(Status.ATIVO, paginacao);
	}
	
	@GetMapping("buscar/categoria")
	public List<Post> buscarPorCategoria(Categoria categoria) {
		categoria = Categoria.QUIMICA;
		Sort sort = Sort.by("dataHora").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		return postRepository.findByCategoriaAndStatus(categoria, Status.ATIVO, paginacao);
	}
	
	@GetMapping("buscar/cliente")
	public List<Post> buscarPorCliente(Cliente cliente) {
		//Long idCliente = cliente.getId();
		Long idCliente = (long) 1;
		Sort sort = Sort.by("dataHora").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		return postRepository.findByClienteAndStatus(idCliente, paginacao);
	}

}
