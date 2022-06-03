package br.org.serratec.api.exception;

public class RecursoNotFoundException extends RuntimeException {

	/**
	 * 
	 */

	private static final long serialVersionUID = 8123904912372332780L;
	
    public RecursoNotFoundException() {
        super("Recurso não encontrado ou inválido!");
    }

    public RecursoNotFoundException(String mensagem) {
        super(mensagem);
    }

}
