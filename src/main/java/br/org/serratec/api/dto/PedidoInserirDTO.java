package br.org.serratec.api.dto;

import br.org.serratec.api.model.Cliente;
import br.org.serratec.api.model.Pedido;

public class PedidoInserirDTO {
		
private Cliente cliente;
	
	public PedidoInserirDTO() {

	}
	
	public PedidoInserirDTO(Pedido pedido) { 
		this.cliente = pedido.getCliente();
		
	}
	
	public Cliente getCliente() {
		return cliente;
		
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		
	}
}
