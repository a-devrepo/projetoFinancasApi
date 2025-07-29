package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.dtos.CategoriaRequest;
import br.com.cotiinformatica.domain.dtos.CategoriaResponse;
import br.com.cotiinformatica.domain.services.CategoriaService;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasController {

	private CategoriaService categoriaService;

	public CategoriasController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping
	public ResponseEntity<CategoriaResponse> post(@RequestBody CategoriaRequest request) {
		var response = categoriaService.criarCategoria(request, null);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaResponse>> getAll() {
		var response = categoriaService.consultarCategorias(null);
		return ResponseEntity.ok(response);
	}
}
