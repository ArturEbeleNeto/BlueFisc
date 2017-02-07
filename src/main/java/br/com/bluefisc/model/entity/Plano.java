package br.com.bluefisc.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity  
@Table(name = "plano") 
public class Plano extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idPlano;

	@NotEmpty
	@Column(length=250,nullable=false)
	private String descricao;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
	    name="area_plano",
	    joinColumns= @JoinColumn(name="idPlano", referencedColumnName="idPlano"),
	    inverseJoinColumns= @JoinColumn(name="idArea", referencedColumnName="idArea")
    )
	@JsonBackReference
	private List<Area> areas;
	
	public Plano(){};
	public Plano(Integer idPlano, String descricao, String caminhoImagem, List<Area> areas) {
		this.idPlano = idPlano;
		this.descricao = descricao;
		this.areas = areas;
	}
	
	public void deleteArea(Area area){
		this.areas.remove(area);
	}
	public void addArea(Area area){
		this.areas.add(area);
	}

	@Override
	public Integer getId() {
		return this.idPlano;
	}
	public Integer getIdPlano() {
		return idPlano;
	}
	public void setIdPlano(Integer idPlano) {
		this.idPlano = idPlano;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Area> getAreas() {
		return areas;
	}
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	
}
