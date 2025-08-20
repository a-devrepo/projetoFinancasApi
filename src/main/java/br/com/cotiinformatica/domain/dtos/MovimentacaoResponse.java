package br.com.cotiinformatica.domain.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

public record MovimentacaoResponse(
		UUID id,
		String nome,
		@Schema(type = "string", example = "20/08/2025", description = "dd/MM/yyyy")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		LocalDate data,
		Double valor,
		String tipo,
		UUID categoriaID) {}
