package br.com.cotiinformatica.domain.services;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.domain.dtos.MovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.MovimentacaoResponse;

public interface MovimentacaoService {

	MovimentacaoResponse criarMovimentacao(MovimentacaoRequest request, UUID usuarioId);

	MovimentacaoResponse alterarMovimentacao(UUID id, MovimentacaoRequest request, UUID usuarioId);

	MovimentacaoResponse excluirMovimentacao(UUID id, UUID usuarioId);

	List<MovimentacaoResponse> consultarMovimentacoes(UUID usuarioId);

	MovimentacaoResponse obterPorId(UUID id, UUID usuarioId);
}
