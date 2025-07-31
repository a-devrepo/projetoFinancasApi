package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.components.JwtComponent;
import br.com.cotiinformatica.domain.dtos.CategoriaRequest;
import br.com.cotiinformatica.domain.dtos.CategoriaResponse;
import br.com.cotiinformatica.domain.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/categorias")
@Tag(name = "Controle de categorias", description = "Serviços para gerenciamento de categorias.")
@SecurityRequirement(name = "bearerAuth") 
public class CategoriasController {

	private CategoriaService categoriaService;

	public CategoriasController(CategoriaService categoriaService, JwtComponent jwtComponent) {
		this.categoriaService = categoriaService;
	}

	@PostMapping
	@Operation(
	    summary = "Cadastro de categorias",
	    description = "Cadastra uma nova categoria no sistema"
	)
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
	    description = "Dados da categoria a ser cadastrada",
	    required = true,
	    content = @Content(
	        mediaType = "application/json",
	        schema = @Schema(implementation = CategoriaRequest.class)
	    )
	)
	public ResponseEntity<CategoriaResponse> post(@RequestBody CategoriaRequest categoriaRequest,
			HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = categoriaService.criarCategoria(categoriaRequest, usuarioId);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	@Operation(summary = "Listar categorias", description = "Retorna todas as categorias cadastradas pelo usuário autenticado")
	public ResponseEntity<List<CategoriaResponse>> getAll(HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = categoriaService.consultarCategorias(usuarioId);
		return ResponseEntity.ok(response);
	}
}
