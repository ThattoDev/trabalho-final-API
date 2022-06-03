package br.org.serratec.api.dto;

import java.math.BigDecimal;

import br.org.serratec.api.model.Categoria;
import br.org.serratec.api.model.Produto;

public class ProdutoResponseDTO {
	private Long id;
	private String nmproduto;	
	private BigDecimal preco_unit;
	private String descricao_prod;
	private Integer qtd_estoque;
	private Categoria categoria;
	
	public ProdutoResponseDTO() {}

	public ProdutoResponseDTO(Produto produto) {
		this.id = produto.getId();
		this.nmproduto = produto.getNmproduto();
		this.preco_unit = produto.getPreco_unit();
		this.descricao_prod = produto.getDescricao_prod();
		this.qtd_estoque = produto.getQtd_estoque();
		this.categoria = produto.getCategoria();
	}

	public Long getIdproduto() {
		return id;
	}

	public void setIdproduto(Long id) {
		this.id = id;
	}

	public String getNmproduto() {
		return nmproduto;
	}

	public void setNmproduto(String nmproduto) {
		this.nmproduto = nmproduto;
	}

	public BigDecimal getPreco_unit() {
		return preco_unit;
	}

	public void setPreco_unit(BigDecimal preco_unit) {
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
