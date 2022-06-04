package br.org.serratec.api.dto;

import br.org.serratec.api.model.Endereco;

public class EnderecoDTO {
	private String cep;
	private String logradouro;
	private String localidade;
	private String uf;
	private String bairro;

	public EnderecoDTO() {

	}

	public EnderecoDTO(Endereco endereco) {
		
		this.cep = endereco.getCep();
		this.logradouro = endereco.getLogradouro();
		this.localidade = endereco.getLocalidade();
		this.uf = endereco.getUf();
		this.bairro = endereco.getBairro();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
