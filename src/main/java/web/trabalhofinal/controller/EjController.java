package web.trabalhofinal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.trabalhofinal.model.Ej;
import web.trabalhofinal.model.Status;
import web.trabalhofinal.model.filter.EjFilter;
import web.trabalhofinal.pagination.PageWrapper;
import web.trabalhofinal.repository.UsuarioRepository;
import web.trabalhofinal.service.EjService;

@Controller
@RequestMapping("/ej")
public class EjController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EjService ejService;

	@GetMapping("/abrircadastrar")
	public String abrirCadastrar(Ej ej) {
		return "ej/cadastrar";
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Ej ej) {
		ejService.salvar(ej);
		return "ej/cadastrar";
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
		ejService.atualizar(ej);
		return "redirect:/ej/abrirpesquisar";
	}

	@PostMapping("/remover")
	public String remover(Ej ej) {
		ej.setStatus(Status.INATIVO);
		ejService.atualizar(ej);
		return "redirect:/ej/abrirpesquisar";
	}

}
