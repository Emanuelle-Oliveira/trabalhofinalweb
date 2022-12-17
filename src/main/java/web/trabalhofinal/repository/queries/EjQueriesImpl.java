package web.trabalhofinal.repository.queries;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import web.trabalhofinal.model.Ej;
import web.trabalhofinal.model.Status;
import web.trabalhofinal.model.filter.EjFilter;
import web.trabalhofinal.repository.pagination.PaginacaoUtil;

public class EjQueriesImpl implements EjQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Ej> pesquisar(EjFilter filtro, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Ej> criteriaQuery = 	builder.createQuery(Ej.class);
		Root<Ej> ej = criteriaQuery.from(Ej.class);
		TypedQuery<Ej> typedQuery;
		List<Predicate> predicateList = new ArrayList<>();

		if (filtro.getId() != null) {
			predicateList.add(builder.equal(ej.<Long>get("id"), filtro.getId()));
		}
		if (StringUtils.hasText(filtro.getNome())) {
			predicateList.add(builder.like(
										builder.lower(ej.<String>get("nome")),
										"%" + filtro.getNome().toLowerCase() + "%"));
		}
		if (StringUtils.hasText(filtro.getEmail())) {
			predicateList.add(builder.like(
										builder.lower(ej.<String>get("email")),
										"%" + filtro.getEmail().toLowerCase() + "%"));
		}
		if (StringUtils.hasText(filtro.getTelefone())) {
			predicateList.add(builder.like(
										builder.lower(ej.<String>get("telefone")),
										"%" + filtro.getTelefone().toLowerCase() + "%"));
		}
		if (StringUtils.hasText(filtro.getCidade())) {
			predicateList.add(builder.like(
										builder.lower(ej.<String>get("cidade")),
										"%" + filtro.getCidade().toLowerCase() + "%"));
		}
		if (filtro.getUf() != null) {
			predicateList.add(builder.equal(ej.<String>get("uf"), filtro.getUf()));
		}
		if (StringUtils.hasText(filtro.getCnpj())) {
			predicateList.add(builder.like(
										builder.lower(ej.<String>get("cnpj")),
										"%" + filtro.getCnpj().toLowerCase() + "%"));
		}
		if (filtro.getCategoria() != null) {
			predicateList.add(builder.equal(ej.<String>get("categoria"), filtro.getCategoria()));
		}

		predicateList.add(builder.equal(ej.<Status>get("status"), Status.ATIVO));
				
		Predicate[] predArray = new Predicate[predicateList.size()];
		predicateList.toArray(predArray);

		criteriaQuery.select(ej).where(predArray);
		
		PaginacaoUtil.prepararOrdem(ej, criteriaQuery, builder, pageable);
		
		typedQuery = manager.createQuery(criteriaQuery);
						
		PaginacaoUtil.prepararIntervalo(typedQuery, pageable);
		
		List<Ej> ejs = typedQuery.getResultList();
		
		long totalEjs = PaginacaoUtil.getTotalRegistros(ej, predArray, builder, manager);
		Page<Ej> page = new PageImpl<>(ejs, pageable, totalEjs); 
		
		return page;
	}

}
