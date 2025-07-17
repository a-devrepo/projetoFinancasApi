package br.com.cotiinformatica.domain.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.cotiinformatica.domain.enums.TipoMovimentacao;
import lombok.Data;

@Data
@Document(collection = "movimentacoes")
public class Movimentacao {

	@Id
	private UUID id;
	private String nome;
	private LocalDate data;
	private Double valor;
	private TipoMovimentacao tipo;
	private UUID usuarioId;

	@DBRef
	private Categoria categoria;
}
