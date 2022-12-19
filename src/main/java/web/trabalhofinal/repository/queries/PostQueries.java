package web.trabalhofinal.repository.queries;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.filter.PostFilter;

public interface PostQueries {

	Page<Post> pesquisar(PostFilter filtro, Pageable pageable);
	
}
