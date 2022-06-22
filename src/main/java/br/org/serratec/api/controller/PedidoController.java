package br.org.serratec.api.controller;

//import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import br.com.senai.dto.UsuarioDTO;
//import br.com.senai.exception.EmailException;
import br.org.serratec.api.dto.PedidoDTO;
import br.org.serratec.api.service.PedidoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import br.org.serratec.api.dto.PedidoInserirDTO;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
		@Autowired
		private PedidoService pedidoService;
		
		@GetMapping
		@ApiOperation(value = "Listar pedidos", notes = "Listagem de pedidos")
		@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna todos os pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro de servidor") })
		public ResponseEntity<List<PedidoDTO>> listar() {
			List<PedidoDTO> pedidos = pedidoService.listar();
			return ResponseEntity.ok(pedidos);
		}
		
		@GetMapping("/{id}")
		@ApiOperation(value = "Buscar um  pedido por ID", notes = "Busca de pedido por ID")
		@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Retorna um pedido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro de servidor") })
		public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id) throws NotFoundException {
			if (pedidoService.obterPorId(id) != null) {
				return ResponseEntity.ok(pedidoService.obterPorId(id).get());
			}
			return ResponseEntity.notFound().build();
		}
		
		@PostMapping("/adicionar")
		@ApiOperation(value = "Adicionar um pedido", notes = "Cadastro")
		@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Cadastra um pedido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro de servidor") })
		public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoInserirDTO pedido) {
			return new  ResponseEntity<>(pedidoService.inserir(pedido), HttpStatus.CREATED);
		}
		
		@PutMapping("{id}")
		@ApiOperation(value = "Atualizar um pedido", notes = "Atualização de um pedido")
		@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Atualiza um pedido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro de servidor") })
		public ResponseEntity<Object> atualizarPorId(@PathVariable(name = "id") Long id, @Valid @RequestBody PedidoInserirDTO pedido) throws NotFoundException {
			if (pedidoService.atualizarPorId(id, pedido) != null) {
			return ResponseEntity.ok(pedido);
			}
			return ResponseEntity.notFound().build();
		}
		
		@DeleteMapping("{id}")
		@ApiOperation(value = "Deletar um pedido", notes = "Exclusão de um pedido")
		@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Deleta um pedido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Recurso proibido"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 500, message = "Erro de servidor") })
		public ResponseEntity<Void> deletarPorId(@PathVariable Long id) throws NotFoundException {
			if (pedidoService.obterPorId(id) != null) {
				pedidoService.deletarPorId(id);
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			return ResponseEntity.notFound().build();
		}
			
}