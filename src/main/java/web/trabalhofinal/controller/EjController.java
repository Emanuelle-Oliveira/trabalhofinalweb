package web.trabalhofinal.controller;

import java.util.List;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.trabalhofinal.model.Ej;
import web.trabalhofinal.model.Papel;
import web.trabalhofinal.model.Status;
import web.trabalhofinal.model.Usuario;
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
		usuarioRepository.save(adm);*/
		return "ej/cadastrar";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Ej ej) {
		Papel papel = papelRepository.findByNome("ROLE_EJ");
		ej.adicionarPapel(papel);
		ej.setSenha(passwordEncoder.encode(ej.getSenha()));
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
