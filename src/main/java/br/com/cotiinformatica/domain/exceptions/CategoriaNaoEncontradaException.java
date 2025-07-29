package br.com.cotiinformatica.domain.exceptions;

public class CategoriaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Categoria não encontrada. Verifique o ID informado.";
	}
}
