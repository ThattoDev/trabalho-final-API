package br.org.serratec.api.exception;

import java.time.LocalDate;

public class ErrorMessage {

	private String titulo;
	private String status;
	private LocalDate dtErro;
	private String mensagem;
	
	public ErrorMessage(String titulo, String status, String mensagem) {
		super();
		this.titulo = titulo;
		this.status = status;
		this.dtErro = LocalDate.now();
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDtErro() {
		return dtErro;
	}

	public void setDtErro(LocalDate dtErro) {
		this.dtErro = dtErro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
