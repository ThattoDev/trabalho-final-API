package br.org.serratec.api.exception;

public class RecursoBadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7750664044469676164L;


    public RecursoBadRequestException() {
        super("O parâmetro inserido é inválido");
    }

    public RecursoBadRequestException(String mensagem) {
        super(mensagem);
    }

}
