package br.org.serratec.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.org.serratec.api.model.Cliente;
import br.org.serratec.api.model.PedidoItem;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;
	
	
	@DateTimeFormat
	@Column(name = "data_emissao")
	private LocalDate dtEmissao;
	
	
	@DateTimeFormat
	@Column(name = "data_entrega")
	private LocalDate dtEntrega;
	
	
	@DateTimeFormat
	@Column(name = "data_envio")
	private LocalDate dtEnvio;
	
	@Transient
	@Column(name = "valor_total")
	private Double vlTotal;
	
	@Size
	@NotBlank(message = "Preencha o status do pedido")
	@Column(name = "status_pedido")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pedido")
	private List<PedidoItem> pedidoItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<PedidoItem> getPedidoItem() {
		return pedidoItem;
	}

	public void setPedidoItem(List<PedidoItem> pedidoItem) {
		this.pedidoItem = pedidoItem;
	}
	
	public Double getVlTotal() {
		vlTotal = 0.0;
		for (PedidoItem item : pedidoItem) {
			vlTotal += item.getSubTotal();
		}
		return vlTotal;
	}
	
	
	
	
}
