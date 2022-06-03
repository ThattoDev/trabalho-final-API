package br.org.serratec.api.controller;

//import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import br.org.serratec.api.dto.PedidoInserirDTO;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
		@Autowired
		private PedidoService pedidoService;
		
		@GetMapping
		public ResponseEntity<List<PedidoDTO>> listar() {
			List<PedidoDTO> pedidos = pedidoService.listar();
			return ResponseEntity.ok(pedidos);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id) {
			if (pedidoService.obterPorId(id) != null) {
				return ResponseEntity.ok(pedidoService.obterPorId(id).get());
			}
			return ResponseEntity.notFound().build();
		}
		
		@PostMapping
		public ResponseEntity<Object> inserir(@Valid @RequestBody PedidoInserirDTO pedido) {
			return ResponseEntity.ok(pedidoService.inserir(pedido));
		}
		
		@PutMapping("{id}")
		public ResponseEntity<Object> atualizarPorId(@PathVariable(name = "id") Long id, @Valid @RequestBody PedidoInserirDTO pedido) {
			if (pedidoService.atualizarPorId(id, pedido) != null) {
			return ResponseEntity.ok(pedido);
			}
			return ResponseEntity.notFound().build();
		}
		
		@DeleteMapping("{id}")
		public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
			if (pedidoService.obterPorId(id) != null) {
				pedidoService.deletarPorId(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		}
		
		
}
