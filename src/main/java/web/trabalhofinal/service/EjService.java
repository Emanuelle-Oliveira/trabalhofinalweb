package web.trabalhofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.trabalhofinal.model.Ej;
import web.trabalhofinal.repository.UsuarioRepository;

@Service
public class EjService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public void salvar(Ej ej) {
		usuarioRepository.save(ej);
	}
	
	@Transactional
	public void atualizar(Ej ej) {
		usuarioRepository.save(ej);
	}
	
}
