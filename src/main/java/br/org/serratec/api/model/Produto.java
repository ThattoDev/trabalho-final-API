package br.org.serratec.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproduto")
	private Long idproduto;
	
	@NotBlank(message = "nome vazio")  
	@Size(max = 40)
	@Column(name = "nmproduto", nullable = false)  
	private String nmproduto;
	
	@NotBlank(message = "custo vazio")  
	@Column(name = "custo", nullable = false) 
	@DecimalMin(value = "1", message = "O valor do produto não pode ser menor que R${value}.0")	
	private Float custo;
	
	@NotBlank(message = "preço vazio")  
	@Column(name = "preco_unit", nullable = false) 
	@DecimalMin(value = "1", message = "O valor do produto não pode ser menor que R${value}.0")	
	private Float preco_unit;
	 
	@Size(max = 100)
	@Column(name = "descricao_prod")  
	private String descricao_prod;
	
	@NotBlank(message = "quantidade vazia")  
	@Column(name = "qtd_estoque", nullable = false) 
	@Min(1)
	private Integer qtd_estoque;
	
	@Column(name = "datacadastro", nullable = false)  
	private LocalDate datacadastro;
	
	@OneToMany
	@JoinColumn(name = "idcategoria")
	private Categoria categoria;
	

	
	public Produto() {}

	public Produto(Long idproduto,
			@NotBlank(message = "nome vazio") @Size(max = 40, message = "Preencha o nome!") String nmproduto,
			@NotBlank(message = "custo vazio") Float custo,
			@NotBlank(message = "preço vazio") Float preco_unit,
			@Size(max = 100, message = "Preencha a descrição!") String descricao_prod,
			@NotBlank(message = "quantidade vazia") Integer qtd_estoque, LocalDate datacadastro, Categoria categoria) {
		this.idproduto = idproduto;
		this.nmproduto = nmproduto;
		this.custo = custo;
		this.preco_unit = preco_unit;
		this.descricao_prod = descricao_prod;
		this.qtd_estoque = qtd_estoque;
		this.datacadastro = datacadastro;
		this.categoria = categoria;
	}


	public Long getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}

	public String getNmproduto() {
		return nmproduto;
	}

	public void setNmproduto(String nmproduto) {
		this.nmproduto = nmproduto;
	}

	public Float getCusto() {
		return custo;
	}

	public void setCusto(Float custo) {
		this.custo = custo;
	}

	public Float getPreco_unit() {
		return preco_unit;
	}

	public void setPreco_unit(Float preco_unit) {
		this.preco_unit = preco_unit;
	}

	public String getDescricao_prod() {
		return descricao_prod;
	}

	public void setDescricao_prod(String descricao_prod) {
		this.descricao_prod = descricao_prod;
	}

	public Integer getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(Integer qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public LocalDate getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(LocalDate datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
