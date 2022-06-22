package br.org.serratec.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.api.dto.PedidoItemDTO;
import br.org.serratec.api.dto.PedidoItemInserirDTO;
import br.org.serratec.api.service.PedidoItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;

@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
@RequestMapping("/api/pedidoitens")
public class PedidoItemController {

	@Autowired
	private PedidoItemService pedidoItemService;
	
	@GetMapping
	@CrossOrigin
	@ApiOperation(value = "Listar itens de pedidos", notes = "Listagem de itens")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Retorna todos os itens de todos os pedidos"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<List<PedidoItemDTO>> listar() {
		return ResponseEntity.ok(pedidoItemService.listar());
	}
	
	@GetMapping("/{id}")
	@CrossOrigin
	@ApiOperation(value = "Buscar um item de um pedido por ID", notes = "Busca de um item pedido por ID")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Retorna um item pedido"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<PedidoItemDTO> buscarPorId(@PathVariable Long id) throws NotFoundException {
		if (pedidoItemService.obterPorId(id) != null) {
			return ResponseEntity.ok(pedidoItemService.obterPorId(id).get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/adicionar")
	@CrossOrigin
	@ApiOperation(value = "Adicionar um item de pedido", notes = "Cadastro de um item de pedido")
	@ApiResponses(value = { 
		@ApiResponse(code = 201, message = "Cadastra um item de pedido"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoItemInserirDTO itemPed) {
		return new ResponseEntity<>(pedidoItemService.inserir(itemPed), HttpStatus.CREATED);
	}
	
	@PutMapping("/atualizar/{id}")
	@CrossOrigin
	@ApiOperation(value = "Atualizar um item de pedido", notes = "Atualização de um item de pedido")
	@ApiResponses(value = { 
		@ApiResponse(code = 201, message = "Atualiza um item de pedido"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<Object> atualizarPorId(@PathVariable(name = "id") Long id, @Valid @RequestBody PedidoItemInserirDTO itemPed) throws NotFoundException {
		if (pedidoItemService.atualizarPorId(id, itemPed) != null) {
		return ResponseEntity.ok(itemPed);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/deletar/{id}")
	@CrossOrigin
	@ApiOperation(value = "Deletar um item de pedido", notes = "Exclusão de um item de pedido")
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Deleta um item de pedido"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<Void> deletarPorId(@PathVariable Long id) throws NotFoundException {
		if (pedidoItemService.obterPorId(id) != null) {
			pedidoItemService.deletarPorId(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.notFound().build();
	}
}
