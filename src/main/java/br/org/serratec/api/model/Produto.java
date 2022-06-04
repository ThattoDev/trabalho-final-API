package br.org.serratec.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;            
	
	@Column(name = "nome")  
	private String nomeProduto;
	
	@Column(name = "custo") 
	private Double custo;
	
 
	@Column(name = "preco_unitario") 	
	private Double precoUnitario;
	 
	@Column(name = "descricao")  
	private String descricaoProduto;
	

	@Column(name = "quantidade") 
	private Integer quantidadeEstoque;
	
	@Column(name = "data_cadastro")  
	private LocalDate dataCadastro;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	

	
	public Produto() {}

	/*public Produto(Long idProduto, String nomeProduto, BigDecimal custo, BigDecimal precoUnitario,
			String descricaoProduto, Integer quantidadeEstoque, LocalDate dataCadastro, Categoria categoria) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.custo = custo;
		this.precoUnitario = precoUnitario;
		this.descricaoProduto = descricaoProduto;
		this.quantidadeEstoque = quantidadeEstoque;
		this.dataCadastro = LocalDate.now();
		this.categoria = categoria;
	}*/

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
