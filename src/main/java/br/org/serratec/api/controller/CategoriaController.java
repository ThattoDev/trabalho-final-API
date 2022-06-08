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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Inserir categoria", notes = "Inserção")
	@ApiResponses(value = { 
		@ApiResponse(code = 201, message = "Ok (a categoria foi inserida)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public Categoria inserir(@Valid @RequestBody CategoriaDTO dto) {
		return categoriaService.inserir(dto);
	}
	
	@GetMapping
	@ApiOperation(value = "Listar todas as categorias", notes = "Listagem")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok (a listagem foi feita)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> categoriaList = categoriaService.listar();
		return ResponseEntity.ok(categoriaList);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar a categoria por id", notes = "Listagem por id")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok (a categoria do id informado foi retornada)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public ResponseEntity<Categoria> listarPorId(@PathVariable Long id) throws NotFoundException {
		Categoria categoria = categoriaService.listarPorId(id);
		if(categoria != null) {
			return ResponseEntity.ok(categoria);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}") 
	@ApiOperation(value = "Editar uma categoria por id", notes = "Edição")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Ok (a edição da categoria foi feita)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public ResponseEntity<Object> editar(@Valid @RequestBody CategoriaDTO categoriaDTO, @PathVariable Long id) throws NotFoundException {
		if(categoriaService.editar(categoriaDTO, id) != null) {
			return ResponseEntity.ok(categoriaDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar a categoria por id", notes = "Exclusão")
	@ApiResponses(value = { 
		@ApiResponse(code = 204, message = "Nenhum resultado (a exclusão da categoria foi feita, não tem nenhum conteúdo para retornar)"),
		@ApiResponse(code = 400, message = "Dados inválidos"),		
		@ApiResponse(code = 401, message = "Erro de autenticação/Não autorizado"),
		@ApiResponse(code = 403, message = "Recurso proibido"),
		@ApiResponse(code = 404, message = "Recurso não encontrado"),
		@ApiResponse(code = 500, message = "Erro de servidor/Método não permitido") })
	public ResponseEntity<Void> deletar(@PathVariable Long id) throws NotFoundException {
		if(categoriaService.listarPorId(id) != null) {
			categoriaService.deletar(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.notFound().build();
	}
	
}