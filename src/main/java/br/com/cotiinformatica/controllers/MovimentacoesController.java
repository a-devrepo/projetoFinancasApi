package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.dtos.MovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.MovimentacaoResponse;
import br.com.cotiinformatica.domain.services.MovimentacaoService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/movimentacoes")
public class MovimentacoesController {

	private MovimentacaoService movimentacaoService;

	public MovimentacoesController(MovimentacaoService movimentacaoService) {
		this.movimentacaoService = movimentacaoService;
	}

	@PostMapping
	public ResponseEntity<MovimentacaoResponse> post(@RequestBody MovimentacaoRequest request, HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = movimentacaoService.criarMovimentacao(request, usuarioId);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MovimentacaoResponse> put(@PathVariable UUID id, @RequestBody MovimentacaoRequest request) {
		var response = movimentacaoService.alterarMovimentacao(id, request, null);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		var response = movimentacaoService.excluirMovimentacao(id, null);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<MovimentacaoResponse>> getAll() {
		var response = movimentacaoService.consultarMovimentacoes(null);
		return ResponseEntity.ok(response);
	}
}
