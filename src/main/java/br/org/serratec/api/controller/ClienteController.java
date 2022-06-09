package br.org.serratec.api.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.api.service.ClienteService;
import br.org.serratec.api.dto.ClienteInserirDTO;
import br.org.serratec.api.exception.CpfException;
import br.org.serratec.api.exception.EmailException;
import br.org.serratec.api.exception.UsernameException;
import br.org.serratec.api.dto.ClienteDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ApiOperation(value = "Listar todos os clientes", notes = "Listagem de clientes")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Retorna todos os clientes"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<List<ClienteDTO>> listar() {
		return ResponseEntity.ok(clienteService.listar());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Obter cliente por ID", notes = "Busca de um cliente pelo nº do ID")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Retorna um cliente"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<ClienteDTO> obterPorId(@PathVariable Long id) throws NotFoundException {
		if (clienteService.buscarId(id) != null) {
			return ResponseEntity.ok(clienteService.buscarId(id));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{cpf}")
	@ApiOperation(value = "Obter cliente por CPF", notes = "Busca de um cliente pelo nº do CPF")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Retorna um cliente"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<ClienteDTO> obterPorCpf(@RequestParam String cpf) {
		if (clienteService.buscarCpf(cpf) != null) {
			return ResponseEntity.ok(clienteService.buscarCpf(cpf));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{email}")
	@ApiOperation(value = "Obter cliente por email", notes = "Busca de um cliente pelo email")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Retorna um cliente"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<ClienteDTO> obterPorEmail(@RequestParam String email) {
		if (clienteService.buscarEmail(email) != null) {
			return ResponseEntity.ok(clienteService.buscarEmail(email));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Adicionar um cliente", notes = "Inserção de um cliente")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Insere um cliente"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<Object> inserir(@Valid @RequestBody ClienteInserirDTO clienteInserirDto) {
		try {
			ClienteDTO clienteDto = clienteService.inserir(clienteInserirDto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(clienteDto.getId())
					.toUri();
			return ResponseEntity.created(uri).body(clienteDto); 
		} catch (EmailException | UsernameException | CpfException | IOException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar um cliente por ID", notes = "Atualização de um cliente pelo nº do ID")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Atualiza um cliente"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<Object> atualizarPorId(@PathVariable Long id,
			@Valid @RequestBody ClienteInserirDTO clienteInserirDto) throws NotFoundException {
		try {
			if (clienteService.atualizarPorId(id, clienteInserirDto) != null) {
				return ResponseEntity.ok(clienteInserirDto);
			}
		} catch (IOException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cpf}")
	@ApiOperation(value = "Deletar um cliente por CPF", notes = "Exclusão de um cliente pelo nº do CPF")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Deleta um cliente"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<Void> deletarPorCpf(@RequestParam(value = "cpf") String cpf) {
		if (clienteService.buscarCpf(cpf) != null) {
			clienteService.deletarPorCpf(cpf);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar um cliente por ID", notes = "Deleção de um cliente pelo nº do ID")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Deleta um cliente"),
		@ApiResponse(code = 401, message = "Erro de autenticação"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<Void> deletarPorId(@PathVariable Long id) throws NotFoundException  {
		if (clienteService.buscarId(id) != null) {
			clienteService.deletarPorId(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.notFound().build();
	}
		
}