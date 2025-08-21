package br.com.cotiinformatica.domain.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;

public record MovimentacaoResponse(
		UUID id,
		String nome,
		@Schema(type = "string", example = "2025-08-20", description = "yyyy-MM-dd")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		LocalDate data,
		Double valor,
		String tipo,
		UUID categoriaID) {}
