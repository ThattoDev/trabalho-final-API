package br.org.serratec.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.org.serratec.api.model.Categoria;
import br.org.serratec.api.model.Produto;

public class ProdutoInserirDTO {
	@NotBlank(message = "nome vazio")  
	@Size(max = 40)
	private String nmproduto;
	
	@NotBlank(message = "custo vazio") 
	@DecimalMin(value = "1", message = "O valor do produto não pode ser menor que R${value}.0")
	private BigDecimal custo;
	
	@NotBlank(message = "preço vazio")  
	@DecimalMin(value = "1", message = "O valor do produto não pode ser menor que R${value}.0")	
	private BigDecimal preco_unit;
	
	@Size(max = 100)
	private String descricao_prod;
	
	@NotBlank(message = "quantidade vazia")  
	@Min(1)
	private Integer qtd_estoque;
	
	private Categoria categoria;
	

	public ProdutoInserirDTO() {}

	public ProdutoInserirDTO(Produto produto) {
		this.nmproduto = produto.getNmproduto();
		this.custo = produto.getCusto();
		this.preco_unit = produto.getPreco_unit();
		this.descricao_prod = produto.getDescricao_prod();
		this.qtd_estoque = produto.getQtd_estoque();
		this.categoria = produto.getCategoria();
		produto.setDatacadastro(LocalDate.now());
	}

	public String getNmproduto() {
		return nmproduto;
	}

	public void setNmproduto(String nmproduto) {
		this.nmproduto = nmproduto;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
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
