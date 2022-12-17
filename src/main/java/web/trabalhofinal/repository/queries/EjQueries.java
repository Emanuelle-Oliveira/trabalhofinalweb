package web.trabalhofinal.repository.queries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import web.trabalhofinal.model.Ej;
import web.trabalhofinal.model.filter.EjFilter;

public interface EjQueries {

	Page<Ej> pesquisar(EjFilter filtro, Pageable pageable);
	
}
