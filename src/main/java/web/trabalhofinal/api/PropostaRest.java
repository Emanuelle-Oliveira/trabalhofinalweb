package web.trabalhofinal.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.trabalhofinal.model.Cliente;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.Proposta;
import web.trabalhofinal.repository.PropostaRepository;

@RestController
@RequestMapping("/api/proposta")
public class PropostaRest {
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@GetMapping("buscar")
	public List<Proposta> buscar() {
		return propostaRepository.findAll();
	}
	
/*	@GetMapping("buscar/post")
	public List<Proposta> buscarPorPost(Post post) {
		//Long idPost = post.getId();
		Long idPost = (long) 10;
		Sort sort = Sort.by("dataHora").ascending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		return propostaRepository.findByPostAndStatus(idPost, paginacao);
	}*/
}
