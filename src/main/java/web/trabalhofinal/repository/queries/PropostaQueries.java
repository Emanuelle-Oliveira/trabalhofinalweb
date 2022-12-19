package web.trabalhofinal.repository.queries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.Proposta;
import web.trabalhofinal.model.filter.PropostaFilter;

public interface PropostaQueries {

	Page<Proposta> pesquisar(PropostaFilter filtro, Pageable pageable, Post post);
	
}
