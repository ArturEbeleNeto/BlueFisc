package br.com.bluefisc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "postagem")
public class Postagem extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idPostagem;

	@NotEmpty
	@Column(length=250,nullable=false)
	private String titulo;

	@NotEmpty
	@Column(length=500,nullable=false)
	private String subTitulo;
		
	private String caminhoImagem;
	
	@NotEmpty
	@Column(length=20000,nullable=false)
	private String textoFormatado;
	
	@NotEmpty
	@Column(length=20000,nullable=false)
	private String textoLimpo;
			
	
	public Postagem(){};
	public Postagem(Integer idPostagem, String titulo, String subTitulo, String caminhoImagem, String textoFormatado,
			String textoLimpo) {
		this.idPostagem = idPostagem;
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.caminhoImagem = caminhoImagem;
		this.textoFormatado = textoFormatado;
		this.textoLimpo = textoLimpo;
	}


	@Override
	public Integer getId() {
		return this.idPostagem;
	}
	public Integer getIdPostagem() {
		return idPostagem;
	}
	public void setIdPostagem(Integer idPostagem) {
		this.idPostagem = idPostagem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubTitulo() {
		return subTitulo;
	}
	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	public String getTextoFormatado() {
		return textoFormatado;
	}
	public void setTextoFormatado(String textoFormatado) {
		this.textoFormatado = textoFormatado;
	}
	public String getTextoLimpo() {
		return textoLimpo;
	}
	public void setTextoLimpo(String textoLimpo) {
		this.textoLimpo = textoLimpo;
	}
}
