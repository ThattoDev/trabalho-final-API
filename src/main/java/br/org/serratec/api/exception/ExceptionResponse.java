package br.org.serratec.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	private HttpStatus status;
	private String mensagem;
	private LocalDateTime dataHora;
	
	public ExceptionResponse(HttpStatus status, String mensagem, LocalDateTime dataHora) {
		super();
		this.status = status;
		this.mensagem = mensagem;
		this.dataHora = dataHora;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
}
