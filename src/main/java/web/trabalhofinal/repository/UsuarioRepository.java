package web.trabalhofinal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import web.trabalhofinal.model.Cliente;
import web.trabalhofinal.model.Usuario;
import web.trabalhofinal.repository.queries.EjQueries;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>, EjQueries{

	@Query(value = "SELECT * FROM usuario AS u WHERE u.status = 'ATIVO' AND u.tipo_usuario = 'cliente'", nativeQuery = true)
	List<Usuario> findClientesAtivos();
	
	@Query(value = "SELECT * FROM usuario AS u WHERE u.status = 'ATIVO' AND u.tipo_usuario = 'ej'", nativeQuery = true)
	List<Usuario> findEjsAtivas(Pageable paginacao);
	

	@Query("select u from Usuario u where u.email = :email")
	Cliente findByEmail(@Param("email")String email);
}
