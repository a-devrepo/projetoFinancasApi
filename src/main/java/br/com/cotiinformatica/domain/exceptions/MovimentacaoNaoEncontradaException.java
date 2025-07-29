package br.com.cotiinformatica.domain.exceptions;

public class MovimentacaoNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Movimentação não encontrada. Verifique o ID informado.";
	}
}

