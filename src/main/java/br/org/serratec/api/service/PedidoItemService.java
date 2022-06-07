package br.org.serratec.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.api.dto.PedidoItemDTO;
import br.org.serratec.api.dto.PedidoItemInserirDTO;
import br.org.serratec.api.model.PedidoItem;
import br.org.serratec.api.model.Produto;
import br.org.serratec.api.repository.PedidoItemRepository;
import br.org.serratec.api.repository.ProdutoRepository;
import javassist.NotFoundException;

@Service
public class PedidoItemService {

	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<PedidoItemDTO> listar() {
		List<PedidoItemDTO> itemPedidosDto = new ArrayList<PedidoItemDTO>();
		List<PedidoItem> itensPedidos = pedidoItemRepository.findAll();

		for (PedidoItem pedidoItem : itensPedidos) {
			PedidoItemDTO itemPedidoDto = new PedidoItemDTO(pedidoItem);
			itemPedidosDto.add(itemPedidoDto);
		}
		return itemPedidosDto;
	}
	
	public Optional<PedidoItemDTO> obterPorId(Long id) throws NotFoundException {

        //RETIREI O OPTIONALDO DTO, AVALIAR SE É CERTO
        Optional<PedidoItem> itemPedido = pedidoItemRepository.findById(id);


        if (itemPedido.isPresent()) {

            return Optional.ofNullable(new PedidoItemDTO(itemPedido.get()));
        }
        throw new NotFoundException("id");
    }
	public PedidoItemDTO inserir(PedidoItemInserirDTO pedidoItemInserirDTO) {
		PedidoItem pedidoItem = new PedidoItem();
		pedidoItem.setPedido(pedidoItemInserirDTO.getPedido());
		pedidoItem.setProduto(pedidoItemInserirDTO.getProduto());
		pedidoItem.setQuantidade(pedidoItemInserirDTO.getQuantidade());
		//PERGUNTAR SE TEM QUE FAZER UM INSTACIAMENTO DO PEDIDO AQUI
		Optional<Produto> produto = produtoRepository.findById(pedidoItemInserirDTO.getProduto().getIdProduto());
		pedidoItem.setPrecoVenda(produto.get().getPrecoUnitario());
		pedidoItem.setSubTotal(pedidoItem.getSubTotal());
		pedidoItemRepository.saveAndFlush(pedidoItem);

		return new PedidoItemDTO(pedidoItem);
	}

	public PedidoItemDTO atualizarPorId(Long id, PedidoItemInserirDTO pedidoItemDTO) {
		if (pedidoItemRepository.existsById(id)) {
			PedidoItem pedidoItem = new PedidoItem();
			pedidoItem.setId(id);
			pedidoItem.setPedido(pedidoItemDTO.getPedido());
			pedidoItem.setProduto(pedidoItemDTO.getProduto());
			pedidoItem.setQuantidade(pedidoItemDTO.getQuantidade());
			pedidoItem.setPrecoVenda(pedidoItemDTO.getProduto().getPrecoUnitario());
			pedidoItem.setSubTotal(pedidoItem.getSubTotal());
			pedidoItemRepository.saveAndFlush(pedidoItem);

			return new PedidoItemDTO(pedidoItem);
		}
		return null;
	}

	public void deletarPorId(Long id) {
		if (pedidoItemRepository.existsById(id)) {
			pedidoItemRepository.deleteById(id);
		}
	}
}
