package br.org.serratec.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.api.dto.ProdutoInserirDTO;
import br.org.serratec.api.dto.ProdutoResponseDTO;
import br.org.serratec.api.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;
	
	@PostMapping("/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Inserir produto", notes = "Inserção")
	@ApiResponses(value = { 
		@ApiResponse(code = 201, message = "Ok (o produto foi inserido)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public ProdutoResponseDTO inserir(@Valid @RequestBody ProdutoInserirDTO dto) {
		ProdutoResponseDTO produtoDTO = produtoService.inserirProduto(dto);
		return produtoDTO;
	}
	
	@GetMapping
	@ApiOperation(value = "Listar todas os produtos", notes = "Listagem")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok (a listagem foi feita)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public ResponseEntity<List<ProdutoResponseDTO>> listar() {
		List<ProdutoResponseDTO> produtoDTO = produtoService.listar();
		return ResponseEntity.ok(produtoDTO);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar o produto por id", notes = "Listagem por id")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok (o produto do id informado foi retornado)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public ResponseEntity<ProdutoResponseDTO> listarId(@PathVariable Long id) throws NotFoundException {
		Optional<ProdutoResponseDTO> produtoDTO = produtoService.listarPorId(id);
		
		if(produtoDTO != null) {
			return ResponseEntity.ok(produtoDTO.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Editar um produto por id", notes = "Edição")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok (a edição do produto foi feita)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public ResponseEntity<Object> editar(@Valid @RequestBody ProdutoInserirDTO produtoDTO, @PathVariable Long id) throws NotFoundException {
		if(produtoService.editar(produtoDTO, id) != null) {
			return ResponseEntity.ok(produtoDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar o produto por id", notes = "Exclusão")
	@ApiResponses(value = { 
		@ApiResponse(code = 204, message = "Nenhum resultado (a exclusão do produto foi feita, não tem nenhum conteúdo para retornar)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public ResponseEntity<Void> deletar(@PathVariable Long id) throws NotFoundException {
		if(produtoService.listarPorId(id) != null) {
			produtoService.deletar(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.notFound().build();
	}
	
}