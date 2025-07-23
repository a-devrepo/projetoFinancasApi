package br.com.cotiinformatica.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.dtos.CategoriaRequest;
import br.com.cotiinformatica.domain.dtos.CategoriaResponse;
import br.com.cotiinformatica.domain.entities.Categoria;
import br.com.cotiinformatica.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaRepository categoriaRepository;

	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public CategoriaResponse criarCategoria(CategoriaRequest request, UUID usuarioId) {

		var categoria = new Categoria();
		categoria.setId(UUID.randomUUID());
		categoria.setNome(request.nome());
		categoria.setUsuarioId(usuarioId);
		categoriaRepository.save(categoria);
		return new CategoriaResponse(categoria.getId(), categoria.getNome());
	}

	@Override
	public List<CategoriaResponse> consultarCategorias(UUID usuarioId) {

		var categorias = categoriaRepository.findAllByUsuarioId(usuarioId);

		var response = new ArrayList<CategoriaResponse>();

		for (var item : categorias) {
			response.add(new CategoriaResponse(item.getId(), item.getNome()));
		}
		return response;
	}

}
