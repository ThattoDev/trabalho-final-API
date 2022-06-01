package br.org.serratec.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.org.serratec.api.dto.ProdutoInserirDTO;
import br.org.serratec.api.dto.ProdutoResponseDTO;
import br.org.serratec.api.model.Produto;
import br.org.serratec.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	public ProdutoResponseDTO inserirProduto(ProdutoInserirDTO dto) {
		Produto produto = new Produto();
		produto.setNmproduto(dto.getNmproduto());
		produto.setCusto(dto.getCusto());
		produto.setPreco_unit(dto.getPreco_unit());
		produto.setDescricao_prod(dto.getDescricao_prod());
		produto.setQtd_estoque(dto.getQtd_estoque());
		produto.setCategoria(dto.getCategoria());
		
		produtoRepository.save(produto);
		return new ProdutoResponseDTO(produto);
	}
	
	public List<ProdutoResponseDTO> listar() {
		List<ProdutoResponseDTO> listProdutosDTO = new ArrayList<ProdutoResponseDTO>();
		List<Produto> produto = produtoRepository.findAll();
		
		for (Produto prod : produto) {
			ProdutoResponseDTO produtoDTO = new ProdutoResponseDTO(prod);
			listProdutosDTO.add(produtoDTO);
		}
		return listProdutosDTO;
	}
	
	public Optional<ProdutoResponseDTO> listarPorId(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		Optional<ProdutoResponseDTO> produtoDTO = Optional.ofNullable(new ProdutoResponseDTO(produto.get()));
		
		if (produto.isPresent()) {
			return produtoDTO;
		}
		return null;
	}
	
	public ProdutoResponseDTO editar(ProdutoInserirDTO produto, Long id) {
		if(produtoRepository.existsById(id)) {
			Produto prod = new Produto();
			prod.setNmproduto(produto.getNmproduto());
			produto.setCusto(produto.getCusto());
			produto.setPreco_unit(produto.getPreco_unit());
			produto.setDescricao_prod(produto.getDescricao_prod());
			produto.setQtd_estoque(produto.getQtd_estoque());
			produto.setCategoria(produto.getCategoria());
			
			return new ProdutoResponseDTO(prod);
		}
		
		return null;
	}
	
}
