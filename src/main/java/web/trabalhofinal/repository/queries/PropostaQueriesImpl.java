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

import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.Proposta;
import web.trabalhofinal.model.Status;
import web.trabalhofinal.model.filter.PropostaFilter;
import web.trabalhofinal.repository.pagination.PaginacaoUtil;

public class PropostaQueriesImpl implements PropostaQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Proposta> pesquisar(PropostaFilter filtro, Pageable pageable, Post post) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Proposta> criteriaQuery = builder.createQuery(Proposta.class);
		Root<Proposta> proposta = criteriaQuery.from(Proposta.class);
		proposta.fetch("ej",JoinType.INNER);
		TypedQuery<Proposta> typedQuery;
		List<Predicate> predicateList = new ArrayList<>();

		predicateList.add(builder.equal(proposta.<Status>get("status"), Status.ATIVO));
		
		predicateList.add(builder.equal(proposta.<Post>get("post").<Long>get("id"), post.getId()));
		
				
		Predicate[] predArray = new Predicate[predicateList.size()];
		predicateList.toArray(predArray);

		criteriaQuery.select(proposta).where(predArray);
		
		PaginacaoUtil.prepararOrdem(proposta, criteriaQuery, builder, pageable);
		
		typedQuery = manager.createQuery(criteriaQuery);
						
		PaginacaoUtil.prepararIntervalo(typedQuery, pageable);
		
		List<Proposta> propostas = typedQuery.getResultList();
		
		long totalpropostas = PaginacaoUtil.getTotalRegistros(proposta, predArray, builder, manager);
		Page<Proposta> page = new PageImpl<>(propostas, pageable, totalpropostas); 
		
		return page;
	}

}
