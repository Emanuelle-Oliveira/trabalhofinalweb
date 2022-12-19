package web.trabalhofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.trabalhofinal.model.Post;
import web.trabalhofinal.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Transactional
	public void salvar(Post post) {
		postRepository.save(post);
	}
	
	@Transactional
	public void atualizar(Post post) {
		postRepository.save(post);
	}
}
