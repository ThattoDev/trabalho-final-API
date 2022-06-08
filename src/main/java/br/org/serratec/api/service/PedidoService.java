package br.org.serratec.api.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.org.serratec.api.dto.PedidoDTO;
import br.org.serratec.api.model.Pedido;
import br.org.serratec.api.repository.PedidoRepository;
import javassist.NotFoundException;
import br.org.serratec.api.dto.PedidoInserirDTO;



@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository; 
	
	public List<PedidoDTO> listar() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoDTO> pedidosDTO = new ArrayList<>();
		for(Pedido p: pedidos) {
			PedidoDTO pedidoDTO = new PedidoDTO(p);
			pedidosDTO.add(pedidoDTO);
		}
		//return pedidoDTO;
		return pedidos.stream().map(p-> new PedidoDTO(p)).collect(Collectors.toList());
	}
	
	public Optional<PedidoDTO> obterPorId(Long id) throws NotFoundException {

        Optional<Pedido> pedido = pedidoRepository.findById(id);

        if (pedido.isPresent()) {

            return Optional.ofNullable(new PedidoDTO(pedido.get()));
        }
        throw new NotFoundException("id");
    }
	
	public PedidoDTO inserir(PedidoInserirDTO pedidos) {		
		Pedido pedido = new Pedido();
		pedido.setDtEmissao(LocalDate.now());
		pedido.setDtEnvio(LocalDate.now().plusDays(3));
		pedido.setDtEntrega(LocalDate.now().plusDays(10));
		pedido.setStatus("Status: em andamento");
		pedido.setCliente(pedidos.getCliente());

		pedidoRepository.save(pedido);
		return new PedidoDTO(pedido);
	}
	

	
	
	public PedidoDTO atualizarPorId(Long id, PedidoInserirDTO pedidoInserirDTO) {
		if (pedidoRepository.existsById(id)) {
			Pedido pedido = new Pedido();
			pedido.setId(id);
			pedido.setDtEmissao(LocalDate.now());
			pedido.setDtEnvio(LocalDate.now().plusDays(3));
			pedido.setDtEntrega(LocalDate.now().plusDays(10));
			if (pedidoRepository.getById(id).getDtEntrega().isBefore(LocalDate.now())) {
				pedido.setStatus("Status: finalizado");
			}else {
				pedido.setStatus("Status: em andamento");
			}
			pedido.setCliente(pedido.getCliente());
			pedidoRepository.saveAndFlush(pedido);

			PedidoDTO pedidoDto = new PedidoDTO(pedido);

			return pedidoDto;
		}
		return null;
	}

	public void deletarPorId(Long id) {
		if (pedidoRepository.existsById(id)) {
			pedidoRepository.deleteById(id);
		}
	}

	
}
