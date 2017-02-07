package br.com.bluefisc.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	private String caminhoIcone;
	
	@ManyToMany (mappedBy="areas", fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<Plano> planos;	
	
	public Area(){};	
	public Area(Integer idArea, String descricao, String caminhoIcone, List<Plano> planos) {
		this.idArea = idArea;
		this.descricao = descricao;
		this.caminhoIcone = caminhoIcone;
		this.planos = planos;
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
	public List<Plano> getPlanos() {
		return planos;
	}
	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}
}
