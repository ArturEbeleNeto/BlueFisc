package br.com.bluefisc.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity  
@Table(name = "postagem") 
public class Postagem extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idPostagem;

	@NotNull
	@ManyToOne
	@JoinColumn(name="idArea", referencedColumnName="idArea")
	private Area area;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="idCategoriaPostagem", referencedColumnName="idCategoriaPostagem")
	private CategoriaPostagem categoriaPostagem;	
	
	@NotEmpty
	@Column(length=250,nullable=false)
	private String titulo;

	@NotEmpty
	@Column(length=500,nullable=false)
	private String subTitulo;
			
	private String caminhoImagem;
	
	@NotEmpty
	@Column(columnDefinition="TEXT NOT NULL")
	private String textoFormatado;
	
	@Column(columnDefinition="TEXT NOT NULL")
	private String textoLimpo;
			
	@ManyToOne
	@JoinColumn(name="idUsuario", referencedColumnName="idUsuario")
	private Usuario usuario;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar dataPublicacao;
	
	public Postagem(){};
	public Postagem(Integer idPostagem, String titulo, String subTitulo, String caminhoImagem, String textoFormatado,
			String textoLimpo, Usuario usuario, Calendar dataPublicacao, Area area, CategoriaPostagem categoriaPostagem) {
		this.area = area;
		this.categoriaPostagem = categoriaPostagem;
		this.idPostagem = idPostagem;
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.caminhoImagem = caminhoImagem;
		this.textoFormatado = textoFormatado;
		this.textoLimpo = textoLimpo;
		this.usuario = usuario;
		this.dataPublicacao = dataPublicacao;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
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
