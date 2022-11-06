package web.trabalhofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.trabalhofinal.model.Post;

public interface PostRepository extends JpaRepository <Post, Long>{

}
