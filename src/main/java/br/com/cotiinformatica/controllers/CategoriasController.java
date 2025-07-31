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
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasController {

	private CategoriaService categoriaService;

	public CategoriasController(CategoriaService categoriaService, JwtComponent jwtComponent) {
		this.categoriaService = categoriaService;
	}

	@PostMapping
	public ResponseEntity<CategoriaResponse> post(@RequestBody CategoriaRequest categoriaRequest, HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = categoriaService.criarCategoria(categoriaRequest, usuarioId);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaResponse>> getAll(HttpServletRequest httpRequest) {
		var usuarioId = (UUID) httpRequest.getAttribute("userId");
		var response = categoriaService.consultarCategorias(usuarioId);
		return ResponseEntity.ok(response);
	}
}
