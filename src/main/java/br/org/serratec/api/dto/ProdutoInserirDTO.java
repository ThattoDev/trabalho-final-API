package br.org.serratec.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.org.serratec.api.model.Categoria;
import br.org.serratec.api.model.Produto;

public class ProdutoInserirDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "nome vazio")  
	@Size(max = 40)
	private String nomeProduto;
	
	@NotNull(message = "custo vazio")
	@DecimalMin(value = "1", message = "O valor do produto não pode ser menor que R${value}.0")
	private BigDecimal custo;
	
	@NotNull(message = "preço vazio")  
	@DecimalMin(value = "1", message = "O valor do produto não pode ser menor que R${value}.0")	
	private BigDecimal precoUnitario;
	
	@Size(max = 100)
	private String descricaoProduto;
	
	@NotNull(message = "quantidade vazia")  
	@Min(1)
	private Integer quantidadeEstoque;
	
	private Categoria categoria;
	

	public ProdutoInserirDTO() {}

	public ProdutoInserirDTO(Produto produto) {
		this.nomeProduto = produto.getNomeProduto();   
		this.custo = produto.getCusto();
		this.precoUnitario = produto.getPrecoUnitario();
		this.descricaoProduto = produto.getDescricaoProduto();
		this.quantidadeEstoque = produto.getQuantidadeEstoque();
		this.categoria = produto.getCategoria();
	}

	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
