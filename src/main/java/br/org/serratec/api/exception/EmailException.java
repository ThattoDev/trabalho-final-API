package br.org.serratec.api.exception;

public class EmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailException(String descricao) {
		super(descricao);
	}

	public EmailException() {
		super("Email inválido!");
	}

}
