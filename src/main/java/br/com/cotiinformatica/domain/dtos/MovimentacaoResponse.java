package br.com.cotiinformatica.domain.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record MovimentacaoResponse(
		UUID id,
		String nome,
		LocalDate data,
		Double valor,
		String tipo,
		UUID categoriaID) {}
