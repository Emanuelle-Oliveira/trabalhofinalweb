package web.trabalhofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.trabalhofinal.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

}
