package br.com.bluefisc.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@JsonBackReference
	@OneToMany(mappedBy="categoriaPostagem")
	private List<Postagem> postagens;

	private String caminhoIcone;
	
	public CategoriaPostagem(){};	
	public CategoriaPostagem(Integer idCategoriaPostagem, String descricao, String caminhoIcone, List<Postagem> postagens) {
		this.idCategoriaPostagem = idCategoriaPostagem;
		this.descricao = descricao;
		this.caminhoIcone = caminhoIcone;
		this.postagens = postagens;
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
	public List<Postagem> getPostagens() {
		return postagens;
	}
	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}
}
