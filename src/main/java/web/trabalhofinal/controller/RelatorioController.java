package web.trabalhofinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import web.trabalhofinal.service.RelatorioService;

@Controller
public class RelatorioController {

	private static final Logger logger = LoggerFactory.getLogger(RelatorioController.class);

	@Autowired
	private RelatorioService relatorioService;

	@GetMapping("/relatorio")
	public ResponseEntity<byte[]> gerarRelatorio() {
		logger.trace("Entrou em gerarRelatorio");
		byte[] relatorio = relatorioService.gerarRelatorio();

		logger.debug("Relatório gerado");
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Relatorio.pdf").body(relatorio);
	}

}
