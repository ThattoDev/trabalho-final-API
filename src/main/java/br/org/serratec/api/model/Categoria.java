package br.org.serratec.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long idcategoria;
	
	@NotBlank(message = "nome vazio")  
	@Size(max = 40, message = "Preencha a descrição!")
	@Column(name = "nmproduto", nullable = false)  
	private String nmcategoria;
	
	@Size(max = 100, message = "Preencha a descrição!")
	@Column(name = "descricao_categ")  
	private String descricao_categ;

	
	public Categoria() {
		super();
	}

	public Categoria(Long idcategoria,
			@NotBlank(message = "nome vazio") @Size(max = 40, message = "Preencha a descrição!") String nmcategoria,
			@Size(max = 100, message = "Preencha a descrição!") String descricao_categ) {
		super();
		this.idcategoria = idcategoria;
		this.nmcategoria = nmcategoria;
		this.descricao_categ = descricao_categ;
	}

	public Long getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNmcategoria() {
		return nmcategoria;
	}

	public void setNmcategoria(String nmcategoria) {
		this.nmcategoria = nmcategoria;
	}

	public String getDescricao_categ() {
		return descricao_categ;
	}

	public void setDescricao_categ(String descricao_categ) {
		this.descricao_categ = descricao_categ;
	}
}
