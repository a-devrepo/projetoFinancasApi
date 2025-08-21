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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/movimentacoes")
@Tag(name = "Controle de movimentações", description = "Serviços para gerenciamento de movimentações.")
@SecurityRequirement(name = "bearerAuth")
public class MovimentacoesController {

	private MovimentacaoService movimentacaoService;

	public MovimentacoesController(MovimentacaoService movimentacaoService) {
		this.movimentacaoService = movimentacaoService;
	}

	@Operation(
			summary = "Cadastro de movimentações", 
			description = "Cadastra uma nova movimentação no sistema", 
			responses = {
			@ApiResponse(responseCode = "200", description = "Movimentação cadastrada com sucesso", 
					content = @Content(schema = @Schema(implementation = MovimentacaoResponse.class))),
			@ApiResponse(responseCode = "404", description = "Categoria não encontrada. Verifique o ID informado"
			, content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content) })
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados da movimentação a ser cadastrada", 
	required = true, content = @Content(mediaType = "application/json", 
	schema = @Schema(implementation = MovimentacaoRequest.class)))
	@PostMapping
	public ResponseEntity<MovimentacaoResponse> post(@RequestBody MovimentacaoRequest request,
			HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = movimentacaoService.criarMovimentacao(request, usuarioId);
		return ResponseEntity.ok(response);
	}

	@Operation(
			summary = "Atualização de movimentação", 
			description = "Altera os dados de uma movimentação existente", 
			responses = {
			@ApiResponse(responseCode = "200", description = "Movimentação atualizada com sucesso", 
					content = @Content(schema = @Schema(implementation = MovimentacaoResponse.class))),
			@ApiResponse(responseCode = "404", description = "Categoria não encontrada. Verifique o ID informado"
			, content = @Content),
			@ApiResponse(responseCode = "404", description = "Movimentação não encontrada. Verifique o ID informado",
			content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content) })
	@PutMapping("/{id}")
	public ResponseEntity<MovimentacaoResponse> put(
			@Parameter(description = "ID da movimentação a ser alterada", required = true) @PathVariable UUID id,
			@RequestBody MovimentacaoRequest request, HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = movimentacaoService.alterarMovimentacao(id, request, usuarioId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = "Exclusão de movimentação", 
			description = "Remove uma movimentação do sistema", 
			responses = {
			@ApiResponse(responseCode = "200", description = "Movimentação excluída com sucesso"),
			@ApiResponse(responseCode = "404", description = "Movimentação não encontrada. Verifique o ID informado", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content) })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(
			@Parameter(description = "ID da movimentação a ser excluída", required = true) @PathVariable UUID id,
			HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = movimentacaoService.excluirMovimentacao(id, usuarioId);
		return ResponseEntity.ok(response);
	}

	@Operation(
			summary = "Consulta de movimentações", 
			description = "Retorna a lista de movimentações cadastradas", 
			responses = {
			@ApiResponse(responseCode = "200", 
					description = "Lista de movimentações retornada com sucesso", 
					content = @Content(schema = @Schema(implementation = MovimentacaoResponse.class))),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),})
	@GetMapping
	public ResponseEntity<List<MovimentacaoResponse>> getAll(HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = movimentacaoService.consultarMovimentacoes(usuarioId);
		return ResponseEntity.ok(response);
	}
	
	@Operation(
			summary = "Consulta de movimentação", 
			description = "Retorna a movimentação cadastrada", 
			responses = {
			@ApiResponse(responseCode = "200", 
					description = "Movimentação retornada com sucesso", 
					content = @Content(schema = @Schema(implementation = MovimentacaoResponse.class))),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Movimentação não encontrada. Verifique o ID informado", content = @Content)})
	@GetMapping("/{id}")
	public ResponseEntity<MovimentacaoResponse> findById(@Parameter(
			description = "ID da movimentação a ser consultada", required = true) @PathVariable UUID id
			,HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = movimentacaoService.obterPorId(id, usuarioId);
		return ResponseEntity.ok(response);
	}
}