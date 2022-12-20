package web.trabalhofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.trabalhofinal.model.Cliente;
import web.trabalhofinal.model.Usuario;
import web.trabalhofinal.repository.PapelRepository;
import web.trabalhofinal.repository.UsuarioRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/cadastrar")
	public String cadastrar() {
		Usuario adm1 = new Usuario();
		adm1.setEmail("manu@gmail.com");
		adm1.setNome("Manu");
		adm1.setAtivo(true);
		adm1.setSenha("12345");
		adm1.setSenha(passwordEncoder.encode(adm1.getSenha()));
		usuarioRepository.save(adm1);
		
		Usuario adm2 = new Usuario();
		adm2.setEmail("darla@gmail.com");
		adm2.setNome("Darla");
		adm2.setAtivo(true);
		adm2.setSenha("12345");
		adm2.setSenha(passwordEncoder.encode(adm2.getSenha()));
		usuarioRepository.save(adm2);
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Maria Silva");
		cliente1.setEmail("maria@gmail.com");
		cliente1.setTelefone("(33)91111-1111");
		cliente1.setCpf("111.111.111-11");
		cliente1.setAtivo(true);
		cliente1.setSenha("12345");
		cliente1.setSenha(passwordEncoder.encode(cliente1.getSenha()));
		usuarioRepository.save(cliente1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("João Pereira");
		cliente2.setEmail("joao@gmail.com");
		cliente2.setTelefone("(33)92222-2222");
		cliente2.setCpf("222.222.222-22");
		cliente2.setAtivo(true);
		cliente2.setSenha("12345");
		cliente2.setSenha(passwordEncoder.encode(cliente2.getSenha()));
		usuarioRepository.save(cliente2);
		
		Cliente cliente3 = new Cliente();
		cliente3.setNome("Luana Souza");
		cliente3.setEmail("luana@gmail.com");
		cliente3.setTelefone("(33)93333-3333");
		cliente3.setCpf("333.333.333-33");
		cliente3.setAtivo(true);
		cliente3.setSenha("12345");
		cliente3.setSenha(passwordEncoder.encode(cliente3.getSenha()));
		usuarioRepository.save(cliente3);
		
		return "index";
	}
}
