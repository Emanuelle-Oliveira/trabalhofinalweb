package web.trabalhofinal.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.trabalhofinal.model.Proposta;

public interface PropostaRepository extends JpaRepository <Proposta, Long>{
	
	@Query("select p from Proposta as p where id_post = :idPost and status = 'ATIVO'")
	List<Proposta> findByPostAndStatus(@Param("idPost")Long idPost, PageRequest paginacao);
}
