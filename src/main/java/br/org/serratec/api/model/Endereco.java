package br.org.serratec.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idendereco")
	private Long idendereco;
	
	@Column(name = "cep")  
	private String cep;
	
	@NotBlank(message = "rua vazia")  
	@Size(max = 50, message = "Preencha a rua!")
	@Column(name = "rua", nullable = false)  
	private String logradouro;
	
	@NotBlank(message = "bairro vazio")  
	@Size(max = 50, message = "Preencha o bairro!")
	@Column(name = "bairro", nullable = false)  
	private String bairro;
	
	@NotBlank(message = "cidade vazio")  
	@Size(max = 50, message = "Preencha a cidade!")
	@Column(name = "localidade", nullable = false)  
	private String localidade;
	
	@NotBlank(message = "uf vazia")  
	@Size(max = 5, message = "Preencha a uf!")
	@Column(name = "uf", nullable = false)  
	private String uf;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco( String cep,
			@NotBlank(message = "rua vazia") @Size(max = 50, message = "Preencha a rua!") String logradouro,
			@NotBlank(message = "bairro vazio") @Size(max = 50, message = "Preencha o bairro!") String bairro,
			@NotBlank(message = "cidade vazio") @Size(max = 50, message = "Preencha a cidade!") String localidade,
			@NotBlank(message = "uf vazia") @Size(max = 5, message = "Preencha a uf!") String uf) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}

	public Long getIdendereco() {
		return idendereco;
	}

	public void setIdendereco(Long idendereco) {
		this.idendereco = idendereco;
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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
}
