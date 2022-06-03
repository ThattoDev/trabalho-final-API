package br.org.serratec.api.dto;

import br.org.serratec.api.model.PedidoItem;
import br.org.serratec.api.model.Produto;

public class PedidoItemDTO {

	private Produto produto;
	private Integer quantidade;
	private Float precoVenda;
	private Double subTotal;

	public PedidoItemDTO() {
		
	}
	
	public PedidoItemDTO(PedidoItem pedidoItem) {
		
		this.produto = pedidoItem.getProduto();
		this.quantidade = pedidoItem.getQuantidade();
		this.precoVenda = pedidoItem.getPrecoVenda();
		this.subTotal = pedidoItem.getSubTotal();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

}
