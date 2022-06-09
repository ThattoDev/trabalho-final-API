package br.org.serratec.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleIdException(Exception exception) {
		ExceptionResponse erro = new ExceptionResponse(HttpStatus.NOT_FOUND, "ID não encontrado",
				LocalDateTime.now());
		return new ResponseEntity(erro, HttpStatus.NOT_FOUND);
	}
	
}
