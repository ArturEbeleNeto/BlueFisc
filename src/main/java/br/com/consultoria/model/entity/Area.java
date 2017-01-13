package br.com.consultoria.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "area")
public class Area extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idArea;

	@NotEmpty
	@Column(length=50,nullable=false)
	private String descricao;

	@NotEmpty
	private String caminhoIcone;
	
	public Area(){};	
	public Area(Integer idArea, String descricao, String caminhoIcone) {
		super();
		this.idArea = idArea;
		this.descricao = descricao;
		this.setCaminhoIcone(caminhoIcone);
	}
	
	
	@Override
	public Integer getId() {
		return this.idArea;
	}
	

	public Integer getIdArea() {
		return idArea;
	}
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCaminhoIcone() {
		return caminhoIcone;
	}
	public void setCaminhoIcone(String caminhoIcone) {
		this.caminhoIcone = caminhoIcone;
	}
}
