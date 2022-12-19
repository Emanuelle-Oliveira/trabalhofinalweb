package web.trabalhofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.trabalhofinal.model.Proposta;
import web.trabalhofinal.repository.PropostaRepository;

@Service
public class PropostaService {
	
	@Autowired
	private PropostaRepository propostaRepository;

	@Transactional
	public void salvar(Proposta proposta) {
		propostaRepository.save(proposta);
	}
}
