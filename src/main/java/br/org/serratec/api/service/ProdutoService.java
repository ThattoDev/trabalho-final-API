package br.org.serratec.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
