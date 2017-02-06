package br.com.bluefisc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

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

	private String caminhoImagem;
	
	
	public Plano(){};
	public Plano(Integer idPlano, String descricao, String caminhoImagem) {
		this.idPlano = idPlano;
		this.descricao = descricao;
		this.caminhoImagem = caminhoImagem;
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

	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
}
