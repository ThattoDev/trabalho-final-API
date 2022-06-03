package br.org.serratec.api.dto;

import java.io.Serializable;

import br.org.serratec.api.model.PedidoItem;
import br.org.serratec.api.model.Pedido;
import br.org.serratec.api.model.Produto;

public class PedidoItemInserirDTO{

	private Pedido pedido;
	private Produto produto;
	private Integer quantidade;

	public PedidoItemInserirDTO() {

	}

	public PedidoItemInserirDTO(PedidoItem pedidoItem) {
		this.pedido = pedidoItem.getPedido();
		this.produto = pedidoItem.getProduto();
		this.quantidade = pedidoItem.getQuantidade();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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

}
