package br.org.serratec.api.dto;

import java.util.List;

import br.org.serratec.api.model.Cliente;
import br.org.serratec.api.model.Endereco;
import br.org.serratec.api.model.Pedido;

public class ClienteDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String usuario;
	private String email;
	private String nrendereco;
	private String complemento;
	private String url;
	private Endereco endereco;
	private List<Pedido> pedidos;
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.usuario = cliente.getUsuario();
		this.email = cliente.getEmail();
		this.nrendereco = cliente.getNrendereco();
		this.complemento = cliente.getComplemento();
		this.url = cliente.getUrl();
		this.endereco = cliente.getEndereco();
		this.pedidos = cliente.getPedidos();
	}
	
	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
	
	
