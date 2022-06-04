package br.org.serratec.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.api.dto.CategoriaDTO;
import br.org.serratec.api.model.Categoria;
import br.org.serratec.api.repository.CategoriaRepository;
import javassist.NotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria inserir(CategoriaDTO categoriaDTO) {
		Categoria categoria = new Categoria();
		categoria.setNomeCategoria(categoriaDTO.getNomeCategoria());
		categoria.setDescricaoCategoria(categoriaDTO.getDescricaoCategoria());	
		
		return categoriaRepository.save(categoria); 
	}
	
	public List<Categoria> listar() {
		return categoriaRepository.findAll(); 
	}
	
	public Categoria listarPorId(Long id) throws NotFoundException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		}
		throw new NotFoundException("Id");
	}
	
	public Categoria editar(CategoriaDTO categoriaDTO, Long id) throws NotFoundException {
		if(categoriaRepository.existsById(id)) {
			Optional<Categoria> categoria = categoriaRepository.findById(id);
			categoria.get().setNomeCategoria(categoriaDTO.getNomeCategoria());
			categoria.get().setDescricaoCategoria(categoriaDTO.getDescricaoCategoria());
			
			return categoriaRepository.save(categoria.get());
		}
		throw new NotFoundException("Id");
	}
	
	public void deletar(Long id) throws NotFoundException {
		if(categoriaRepository.existsById(id)) {
			categoriaRepository.deleteById(id);
		}
		throw new NotFoundException("Id");
	}
	
}
