package br.org.serratec.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.api.dto.EnderecoDTO;
import br.org.serratec.api.dto.EnderecoInserirDTO;
import br.org.serratec.api.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	@ApiOperation(value = "Listar enderecos", notes = "Listagem de enderecos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os enderecos"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Recurso proibido"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<List<EnderecoDTO>> listar() {
		return ResponseEntity.ok(enderecoService.listar());
	}
	
	@PostMapping("/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Adicionar endereço", notes = "Inserção de endereço")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Insere um endereço"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Recurso proibido"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<Object> inserir(@Valid @RequestBody EnderecoInserirDTO endereco) {
		return ResponseEntity.ok(enderecoService.inserir(endereco));
	}
	
	@GetMapping("/{cep}")

	@ApiOperation(value = "Buscar endereço pelo CEP", notes = "Busca um endereço pelo CEP")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Insere um endereço"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Recurso proibido"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 500, message = "Erro de servidor") })
	
	public ResponseEntity<EnderecoDTO> buscarPorCep(@PathVariable String cep) {
		return ResponseEntity.ok(enderecoService.buscarPorCep(cep));
	}
	
	@DeleteMapping("/deletar/{id}")
	@ApiOperation(value = "Deletar um endereço pelo id.", notes = "Deleta um endereço usando o id.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Deleta um endereço"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Recurso proibido"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 500, message = "Erro de servidor") })
	public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
		if (enderecoService.buscarPorId(id) != null) {
			enderecoService.deletarPorId(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.notFound().build();
	}	
}