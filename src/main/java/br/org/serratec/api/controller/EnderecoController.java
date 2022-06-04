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


@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> listar() {
		return ResponseEntity.ok(enderecoService.listar());
	}
	
	@PostMapping("/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> inserir(@Valid @RequestBody EnderecoInserirDTO endereco) {
		return ResponseEntity.ok(enderecoService.inserir(endereco));
	}
	
	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoDTO> buscarPorCep(@RequestParam(value = "cep") String cep) {
		return ResponseEntity.ok(enderecoService.buscarPorCep(cep));
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
		if (enderecoService.buscarPorId(id) != null) {
			enderecoService.deletarPorId(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}