package br.org.serratec.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.org.serratec.api.model.Cliente;
import br.org.serratec.api.model.Pedido;
import br.org.serratec.api.dto.PedidoItemDTO;

public class PedidoDTO {
	private Long id;
	private LocalDate dtEmissao;
	private LocalDate dtEntrega;
	private LocalDate dtEnvio;
	private Float vlTotal;
	private String status;
	private Cliente cliente;
	private List<PedidoItemDTO> pedidoItem;
	
	public PedidoDTO(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.dtEmissao = pedido.getDtEmissao();
		this.dtEntrega = pedido.getDtEntrega();
		this.dtEnvio = pedido.getDtEnvio();
		this.status = pedido.getStatus();
		this.cliente = pedido.getCliente();
		if (pedido.getPedidoItem() != null) {
			this.pedidoItem = pedido.getPedidoItem().stream().map(pi -> new PedidoItemDTO(pi))
				.collect(Collectors.toList());
			this.vlTotal = pedido.getVlTotal();
		}	
	}

	public LocalDate getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(LocalDate dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public LocalDate getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(LocalDate dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public LocalDate getDtEnvio() {
		return dtEnvio;
	}

	public void setDtEnvio(LocalDate dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	public Float getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(Float vlTotal) {
		this.vlTotal = vlTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
	
	
	
}
