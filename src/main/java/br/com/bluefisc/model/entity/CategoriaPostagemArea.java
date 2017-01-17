package br.com.bluefisc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categoriaPostagemArea")
public class CategoriaPostagemArea extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idCategoriaPostagemArea;

	@ManyToOne
	@NotNull
	private Area area;
	
	@ManyToOne
	@NotNull
	private CategoriaPostagem categoriaPostagem;

	
	public CategoriaPostagemArea() {
		super();
	}
	public CategoriaPostagemArea(Integer idCategoriaPostagemArea, Area area, CategoriaPostagem categoriaPostagem) {
		super();
		this.idCategoriaPostagemArea = idCategoriaPostagemArea;
		this.area = area;
		this.categoriaPostagem = categoriaPostagem;
	}

	@Override
	public Integer getId() {
		return this.idCategoriaPostagemArea;
	}
	
	
	public Integer getIdCategoriaPostagemArea() {
		return idCategoriaPostagemArea;
	}
	public void setIdCategoriaPostagemArea(Integer idCategoriaPostagemArea) {
		this.idCategoriaPostagemArea = idCategoriaPostagemArea;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public CategoriaPostagem getCategoriaPostagem() {
		return categoriaPostagem;
	}
	public void setCategoriaPostagem(CategoriaPostagem categoriaPostagem) {
		this.categoriaPostagem = categoriaPostagem;
	}
}
