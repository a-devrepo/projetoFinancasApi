package br.com.cotiinformatica.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cotiinformatica.domain.entities.Movimentacao;

public interface MovimentacaoRepository extends MongoRepository<Movimentacao, UUID> {
	List<Movimentacao> findAllByUsuarioId(UUID usuarioId);
}
