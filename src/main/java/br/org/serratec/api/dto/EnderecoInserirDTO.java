package br.org.serratec.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.org.serratec.api.model.Endereco;

public class EnderecoInserirDTO {

	@NotBlank
//	@Size(max = 9)
	private String cep;

	public EnderecoInserirDTO() {

	}

	public EnderecoInserirDTO(Endereco endereco) {
		this.cep = endereco.getCep();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
