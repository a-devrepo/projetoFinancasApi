package br.com.cotiinformatica.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.dtos.MovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.MovimentacaoResponse;
import br.com.cotiinformatica.domain.entities.Movimentacao;
import br.com.cotiinformatica.domain.enums.TipoMovimentacao;
import br.com.cotiinformatica.domain.exceptions.CategoriaNaoEncontradaException;
import br.com.cotiinformatica.domain.exceptions.MovimentacaoNaoEncontradaException;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import br.com.cotiinformatica.repositories.MovimentacaoRepository;


@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {

	private MovimentacaoRepository movimentacaoRepository;
	private CategoriaRepository categoriaRepository;

	public MovimentacaoServiceImpl(MovimentacaoRepository repository, CategoriaRepository categoriaRepository) {
		this.movimentacaoRepository = repository;
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public MovimentacaoResponse criarMovimentacao(MovimentacaoRequest request, UUID usuarioId) {

		if (!categoriaRepository.existsById(request.categoriaId())) {
			throw new CategoriaNaoEncontradaException();
		}

		var movimentacao = new Movimentacao();

		movimentacao.setId(UUID.randomUUID());
		movimentacao.setNome(request.nome());
		movimentacao.setData(request.data());
		movimentacao.setValor(request.valor());
		movimentacao.setTipo(TipoMovimentacao.valueOf(request.tipo()));
		movimentacao.setUsuarioId(usuarioId);
		movimentacao.setCategoria(categoriaRepository.findById(request.categoriaId()).get());

		movimentacaoRepository.save(movimentacao);

		return toResponse(movimentacao);
	}

	@Override
	public MovimentacaoResponse alterarMovimentacao(UUID id, MovimentacaoRequest request, UUID usuarioId) {

		if (!movimentacaoRepository.existsById(id)) {
			throw new MovimentacaoNaoEncontradaException();
		}

		if (!categoriaRepository.existsById(request.categoriaId())) {
			throw new CategoriaNaoEncontradaException();
		}

		var movimentacao = new Movimentacao();

		movimentacao.setNome(request.nome());
		movimentacao.setData(request.data());
		movimentacao.setValor(request.valor());
		movimentacao.setTipo(TipoMovimentacao.valueOf(request.tipo()));
		movimentacao.setUsuarioId(usuarioId);
		movimentacao.setCategoria(categoriaRepository.findById(request.categoriaId()).get());

		movimentacaoRepository.save(movimentacao);

		return toResponse(movimentacao);
	}

	@Override
	public MovimentacaoResponse excluirMovimentacao(UUID id, UUID usuarioId) {

		if (!movimentacaoRepository.existsById(id)) {
			throw new MovimentacaoNaoEncontradaException();
		}

		var movimentacao = movimentacaoRepository.findById(id).get();
		movimentacaoRepository.delete(movimentacao);

		return toResponse(movimentacao);
	}

	@Override
	public List<MovimentacaoResponse> consultarMovimentacoes(UUID usuarioId) {
		return movimentacaoRepository.findAllByUsuarioId(usuarioId).stream().map(m -> toResponse(m)).toList();
	}

	@Override
	public MovimentacaoResponse obterPorId(UUID id, UUID usuarioId) {

		if (!movimentacaoRepository.existsById(id)) {
			throw new MovimentacaoNaoEncontradaException();
		}

		var movimentacao = movimentacaoRepository.findById(id).get();

		return toResponse(movimentacao);
	}

	private MovimentacaoResponse toResponse(Movimentacao movimentacao) {
		return new MovimentacaoResponse(movimentacao.getId(), movimentacao.getNome(), movimentacao.getData(),
				movimentacao.getValor(), movimentacao.getTipo().name(), movimentacao.getCategoria().getId());
	}
}
