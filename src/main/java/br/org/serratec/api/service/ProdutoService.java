package br.org.serratec.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.api.dto.ProdutoInserirDTO;
import br.org.serratec.api.dto.ProdutoResponseDTO;
import br.org.serratec.api.model.Produto;
import br.org.serratec.api.repository.ProdutoRepository;
import javassist.NotFoundException;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	public ProdutoResponseDTO inserirProduto(ProdutoInserirDTO dto) {
		Produto produto = new Produto();
		produto.setNomeProduto(dto.getNomeProduto());
		produto.setCusto(dto.getCusto());
		produto.setPrecoUnitario(dto.getPrecoUnitario());
		produto.setDescricaoProduto(dto.getDescricaoProduto());
		produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		produto.setCategoria(dto.getCategoria());
		produto.setDataCadastro(LocalDate.now());
		
		produtoRepository.saveAndFlush(produto);
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
	
	public Optional<ProdutoResponseDTO> listarPorId(Long id) throws NotFoundException {
		Optional<Produto> produto = produtoRepository.findById(id);
		Optional<ProdutoResponseDTO> produtoDTO = Optional.ofNullable(new ProdutoResponseDTO(produto.get()));
		
		if (produto.isPresent()) {
			return produtoDTO;
		}
		throw new NotFoundException("Id");
	}
	
	public ProdutoResponseDTO editar(ProdutoInserirDTO produto, Long id) throws NotFoundException {
		if(produtoRepository.existsById(id)) {
			Optional<Produto> prod = produtoRepository.findById(id);
			prod.get().setNomeProduto(produto.getNomeProduto());
			prod.get().setCusto(produto.getCusto());
			prod.get().setPrecoUnitario(produto.getPrecoUnitario());
			prod.get().setDescricaoProduto(produto.getDescricaoProduto());
			prod.get().setQuantidadeEstoque(produto.getQuantidadeEstoque());
			prod.get().setCategoria(produto.getCategoria());
			
			produtoRepository.save(prod.get());
			return new ProdutoResponseDTO(prod.get());
		}
		throw new NotFoundException("Id");
	}
	
	public void deletar(Long id) throws NotFoundException {
		if (produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
		}
		throw new NotFoundException("Id");
	}
	
}
