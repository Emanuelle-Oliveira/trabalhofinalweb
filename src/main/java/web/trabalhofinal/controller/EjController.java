package web.trabalhofinal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.trabalhofinal.model.Cliente;
import web.trabalhofinal.model.Ej;
import web.trabalhofinal.model.Papel;
import web.trabalhofinal.model.Status;
import web.trabalhofinal.model.filter.EjFilter;
import web.trabalhofinal.pagination.PageWrapper;
import web.trabalhofinal.repository.PapelRepository;
import web.trabalhofinal.repository.UsuarioRepository;
import web.trabalhofinal.service.EjService;

@Controller
@RequestMapping("/ej")
public class EjController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PapelRepository papelRepository;

	@Autowired
	private EjService ejService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/abrircadastrar")
	public String abrirCadastrar(Ej ej) {
		/*Usuario adm = new Usuario();
		adm.setEmail("manu@gmail.com");
		adm.setNome("Manu");
		adm.setSenha("12345");
		adm.setSenha(passwordEncoder.encode(adm.getSenha()));
		usuarioRepository.save(adm);
		
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
		*/
		return "ej/cadastrar";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Ej ej) {
		Papel papel = papelRepository.findByNome("ROLE_EJ");
		ej.adicionarPapel(papel);
		ej.setSenha(passwordEncoder.encode(ej.getSenha()));
		ej.setAtivo(true);
		ejService.salvar(ej);
		return "redirect:/ej/pesquisar";
	}

	@GetMapping("/abrirpesquisar")
	public String abrirPesquisar(Ej ej) {
		return "ej/pesquisar";
	}

	@GetMapping("/pesquisar")
	public String pesquisar(EjFilter filtro, Model model,
			@PageableDefault(size = 5) @SortDefault(sort = "nome", direction = Sort.Direction.ASC) Pageable pageable,
			HttpServletRequest request) {
		Page<Ej> pagina = usuarioRepository.pesquisar(filtro, pageable);
		PageWrapper<Ej> paginaWrapper = new PageWrapper<>(pagina, request);
		model.addAttribute("pagina", paginaWrapper);
		return "ej/listar";
	}

	@PostMapping("/abriratualizar")
	public String abrirAtualizar(Ej ej) {
		return "ej/atualizar";
	}

	@PostMapping("/atualizar")
	public String atualizar(Ej ej) {
		ej.setSenha(passwordEncoder.encode(ej.getSenha()));
		ejService.atualizar(ej);
		return "redirect:/ej/pesquisar";
	}

	@PostMapping("/remover")
	public String remover(Ej ej) {
		ej.setStatus(Status.INATIVO);
		ej.setAtivo(false);
		ejService.atualizar(ej);
		return "redirect:/ej/pesquisar";
	}
	
	@PostMapping("/abrirvisualizar")
	public String abrirVisualizar(Ej ej) {
		return "ej/visualizar";
	}

}
