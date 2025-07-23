package br.com.cotiinformatica.domain.services;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.CategoriaRequest;
import br.com.cotiinformatica.domain.dtos.CategoriaResponse;

public interface CategoriaService {

	CategoriaResponse criarCategoria(CategoriaRequest request, UUID usuarioId);

	List<CategoriaResponse> consultarCategorias(UUID usuarioId);
}
