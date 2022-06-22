package br.org.serratec.api.dto;

import java.time.LocalDate;

import br.org.serratec.api.model.Categoria;
import br.org.serratec.api.model.Produto;

public class ProdutoResponseDTO {
	
	
	private Long idProduto;
	private String nomeProduto;
	private Double custo;
	private Double precoUnitario;
	private String descricaoProduto;
	private Integer quantidadeEstoque;
	private Categoria categoria;
	private LocalDate dataCadastro;
	
	public ProdutoResponseDTO() {}

	public ProdutoResponseDTO(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nomeProduto = produto.getNomeProduto();
		this.custo = produto.getCusto();
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

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}
	
}
