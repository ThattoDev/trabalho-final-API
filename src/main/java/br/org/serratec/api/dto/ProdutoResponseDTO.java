package br.org.serratec.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.org.serratec.api.model.Categoria;
import br.org.serratec.api.model.Produto;

public class ProdutoResponseDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idProduto;
	private String nomeProduto;	
	private BigDecimal precoUnitario;
	private String descricaoProduto;
	private Integer quantidadeEstoque;
	private Categoria categoria;
	private LocalDate dataCadastro;
	
	public ProdutoResponseDTO() {}

	public ProdutoResponseDTO(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nomeProduto = produto.getNomeProduto();
		this.precoUnitario = produto.getPrecoUnitario();
		this.descricaoProduto = produto.getDescricaoProduto();
		this.quantidadeEstoque = produto.getQuantidadeEstoque();
		this.categoria = produto.getCategoria();
		this.dataCadastro = produto.getDataCadastro();
	}

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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
