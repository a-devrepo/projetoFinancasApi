package br.com.cotiinformatica.handlers;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.cotiinformatica.domain.exceptions.CategoriaNaoEncontradaException;
import br.com.cotiinformatica.domain.exceptions.MovimentacaoNaoEncontradaException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CategoriaNaoEncontradaException.class)
	public ResponseEntity<Object> handleCategoriaNaoEncontrada(CategoriaNaoEncontradaException ex) {
		return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MovimentacaoNaoEncontradaException.class)
	public ResponseEntity<Object> handleMovimentacaoNaoEncontrada(MovimentacaoNaoEncontradaException ex) {
		return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<Object> buildResponse(String message, HttpStatus status) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", Instant.now());
		body.put("status", status.value());
		body.put("error", status.getReasonPhrase());
		body.put("message", message);

		return new ResponseEntity<>(body, status);
	}
}
