package web.trabalhofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.trabalhofinal.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

}
