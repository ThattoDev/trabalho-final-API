package br.org.serratec.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long id;
	
	@NotBlank(message = "campo nome vazio")  
//	@Size(max = 80, message = "Preencha o nome!")
	@Column(name = "nome", nullable = false)  
	private String nome;
	
	@NotBlank(message = "campo cpf vazio")  
//	@Size(max = 20, message = "Preencha o cpf!")
	@Column(name = "cpf", nullable = false)  
	private String cpf;
	
	@Column(name = "telefone", nullable = false) 
	private String telefone;
	
	@NotBlank(message = "campo usuario vazio")  
//	@Size(max = 20, message = "Preencha o usuario!")
	@Column(name = "usuario", nullable = false)
	private String usuario;
	
	@NotBlank(message = "campo email vazio")  
//	@Size(max = 20, message = "Preencha o email!")
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotBlank(message = "campo senha vazio")  
//	@Size(max = 200, message = "Preencha a senha!")
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "nr_endereco", nullable = false)
	private String nrendereco;
	@Column(name = "complemento", nullable = false)
	private String complemento;

	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Pedido> pedidos;
	
	
	public Cliente() {
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
