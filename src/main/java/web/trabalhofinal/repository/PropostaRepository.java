package web.trabalhofinal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.trabalhofinal.model.Proposta;
import web.trabalhofinal.repository.queries.PropostaQueries;

public interface PropostaRepository extends JpaRepository <Proposta, Long>, PropostaQueries{
	
	@Query("select p from Proposta as p where id_post = :idPost and status = 'ATIVO'")
	List<Proposta> findByPostAndStatus(@Param("idPost")Long idPost);
}
