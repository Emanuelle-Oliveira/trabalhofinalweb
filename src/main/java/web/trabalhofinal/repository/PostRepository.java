package web.trabalhofinal.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.trabalhofinal.model.Categoria;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.model.Status;
import web.trabalhofinal.repository.queries.PostQueries;

public interface PostRepository extends JpaRepository <Post, Long>, PostQueries{

	List<Post> findByCategoriaAndStatus(Categoria categoria, Status ativo, Pageable paginacao);

	List<Post> findByStatus(Status ativo, Pageable paginacao);

	@Query("select p from Post as p where id_cliente = :idCliente and status = 'ATIVO'")
	List<Post> findByClienteAndStatus(@Param("idCliente")Long idCliente, PageRequest paginacao);

}
