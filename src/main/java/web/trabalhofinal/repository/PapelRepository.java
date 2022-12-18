package web.trabalhofinal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import web.trabalhofinal.model.Papel;

public interface PapelRepository extends JpaRepository <Papel, Long>{
	
	Papel findByNome(String nome);
}
