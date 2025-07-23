package br.com.cotiinformatica.domain.services;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.MovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.MovimentacaoResponse;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import br.com.cotiinformatica.repositories.MovimentacaoRepository;

public class MovimentacaoServiceImpl implements MovimentacaoService {

	private MovimentacaoRepository movimentacaoRepository;
	private CategoriaRepository categoriaRepository;

	public MovimentacaoServiceImpl(MovimentacaoRepository repository, CategoriaRepository categoriaRepository) {
		this.movimentacaoRepository = repository;
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public MovimentacaoResponse criarMovimentacao(MovimentacaoRequest request, UUID usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovimentacaoResponse alterarMovimentacao(UUID id, MovimentacaoRequest request, UUID usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovimentacaoResponse excluirMovimentacao(UUID id, UUID usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovimentacaoResponse> consultarMovimentacoes(UUID usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovimentacaoResponse obterPorId(UUID id, UUID usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
