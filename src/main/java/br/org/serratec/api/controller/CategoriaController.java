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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.api.dto.CategoriaDTO;
import br.org.serratec.api.model.Categoria;
import br.org.serratec.api.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria inserir(@Valid @RequestBody CategoriaDTO dto) {
		return categoriaService.inserir(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> categoriaList = categoriaService.listar();
		return ResponseEntity.ok(categoriaList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> listarPorId(@PathVariable Long id) {
		Categoria categoria = categoriaService.listarPorId(id);
		if(categoria != null) {
			return ResponseEntity.ok(categoria);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<Object> editar(@Valid @RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id) {
		if(categoriaService.editar(categoriaDTO, id) != null) {
			return ResponseEntity.ok(categoriaDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if(categoriaService.listarPorId(id) != null) {
			categoriaService.deletar(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}

