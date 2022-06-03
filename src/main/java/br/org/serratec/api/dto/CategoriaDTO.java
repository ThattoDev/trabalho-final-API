package br.org.serratec.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.org.serratec.api.model.Categoria;

public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "nome vazio")  
	@Size(max = 40)
	private String nomeCategoria;
	
	@Size(max = 100)
	private String descricaoCategoria;
	
	

	public CategoriaDTO() {}

	public CategoriaDTO(Categoria categoria) {
		this.nomeCategoria = categoria.getNomeCategoria();
		this.descricaoCategoria = categoria.getDescricaoCategoria();
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
}
