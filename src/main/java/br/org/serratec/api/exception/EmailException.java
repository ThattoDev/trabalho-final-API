package br.org.serratec.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

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
