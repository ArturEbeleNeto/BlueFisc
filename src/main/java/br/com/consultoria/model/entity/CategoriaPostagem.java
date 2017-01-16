package br.com.consultoria.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "categoriaPostagem")
public class CategoriaPostagem extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idCategoriaPostagem;

	@NotEmpty
	@Column(length=50,nullable=false)
	private String descricao;

	private String caminhoIcone;
	
	public CategoriaPostagem(){};	
	public CategoriaPostagem(Integer idCategoriaPostagem, String descricao, String caminhoIcone) {
		super();
		this.idCategoriaPostagem = idCategoriaPostagem;
		this.descricao = descricao;
		this.setCaminhoIcone(caminhoIcone);
	}
	
	
	@Override
	public Integer getId() {
		return this.idCategoriaPostagem;
	}
	

	public Integer getIdCategoriaPostagem() {
		return idCategoriaPostagem;
	}
	public void setIdCategoriaPostagem(Integer idCategoriaPostagem) {
		this.idCategoriaPostagem = idCategoriaPostagem;
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
