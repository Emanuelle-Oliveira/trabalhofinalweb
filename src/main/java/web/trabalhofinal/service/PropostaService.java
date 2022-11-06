package web.trabalhofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.trabalhofinal.repository.PropostaRepository;

@Service
public class PropostaService {
	
	@Autowired
	private PropostaRepository propostaRepository;

}
