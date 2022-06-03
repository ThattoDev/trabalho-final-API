package br.org.serratec.api.dto;

import java.util.List;

import br.org.serratec.api.model.Cliente;
import br.org.serratec.api.model.Endereco;


public class ClienteInserirDTO {
	
	private String nome;
	private String cpf;
	private String telefone;
	private String usuario;
	private String email;
	private String senha;
	private String nrendereco;
	private String complemento;
	private Endereco endereco;
	
	
	public ClienteInserirDTO(Cliente cliente) {
		super();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.usuario = cliente.getUsuario();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.nrendereco = cliente.getNrendereco();
		this.complemento = cliente.getComplemento();
		this.endereco = cliente.getEndereco();
		
	}
	
	public ClienteInserirDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNrendereco() {
		return nrendereco;
	}

	public void setNrendereco(String nrendereco) {
		this.nrendereco = nrendereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	


	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
