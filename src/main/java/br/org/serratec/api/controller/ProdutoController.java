package br.org.serratec.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.api.dto.ProdutoInserirDTO;
import br.org.serratec.api.dto.ProdutoResponseDTO;
import br.org.serratec.api.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Object> inserir(@Valid @RequestBody ProdutoInserirDTO dto) {
		ProdutoResponseDTO produtoDTO =  produtoService.inserirProduto(dto);
		return ResponseEntity.ok(produtoDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> listar() {
		List<ProdutoResponseDTO> produtoDTO = produtoService.listar();
		return ResponseEntity.ok(produtoDTO);
	}
	
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody ProdutoInserirDTO produtoDTO, @PathVariable Long id) {
		if(produtoService.editar(produtoDTO, id) != null) {
			return ResponseEntity.ok(produtoDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
}
