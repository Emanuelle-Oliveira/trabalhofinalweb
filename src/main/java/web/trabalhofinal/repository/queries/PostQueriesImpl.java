package web.trabalhofinal.repository.queries;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import web.trabalhofinal.model.Ej;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.Status;
import web.trabalhofinal.model.filter.PostFilter;
import web.trabalhofinal.repository.pagination.PaginacaoUtil;

public class PostQueriesImpl implements PostQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Post> pesquisar(PostFilter filtro, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
		Root<Post> post = criteriaQuery.from(Post.class);
		post.fetch("cliente",JoinType.INNER);
		TypedQuery<Post> typedQuery;
		List<Predicate> predicateList = new ArrayList<>();

		predicateList.add(builder.equal(post.<Status>get("status"), Status.ATIVO));
				
		Predicate[] predArray = new Predicate[predicateList.size()];
		predicateList.toArray(predArray);

		criteriaQuery.select(post).where(predArray);
		
		PaginacaoUtil.prepararOrdem(post, criteriaQuery, builder, pageable);
		
		typedQuery = manager.createQuery(criteriaQuery);
						
		PaginacaoUtil.prepararIntervalo(typedQuery, pageable);
		
		List<Post> posts = typedQuery.getResultList();
		
		long totalposts = PaginacaoUtil.getTotalRegistros(post, predArray, builder, manager);
		Page<Post> page = new PageImpl<>(posts, pageable, totalposts); 
		
		return page;
	}

}
