package br.org.serratec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
