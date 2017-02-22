package br.com.bluefisc.model.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.bluefisc.model.enums.SituacaoCliente;
import br.com.bluefisc.model.validators.ValidaCPF;

@Entity
@Table(name = "cliente")
public class Cliente extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idCliente;
	
	@ManyToOne
	@JoinColumn(name="idPlano", referencedColumnName="idPlano")
	private Plano plano;
	
	public Integer sequencia;	
	
	@Enumerated(EnumType.STRING)
	private SituacaoCliente situacao;
	
	@NotBlank(message = "O campo nome não pode estar vazio")
	private String nome;
	
	private String sobrenome;
	
	@ValidaCPF
	private String numeroCpf;
	
	private String numeroRg;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar dataNascimento;	
	
	private Integer idade;
	
	private String sexo;

	private String email;
	
	@Column(length=25) 
	private String telefone;
	
	@Column(length=25)
	private String celular;
	
	private String rua;
	
	private Integer numeroResidencial;
	
	private String bairro;
	
	private String complemento;
	
	private String municipio;
	
	@Column(length=2)
	private String estado;
	
	private String cep;
	
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="idUsuario", referencedColumnName="idUsuario")
	private Usuario usuario;

	
	public Cliente() {}
	public Cliente(Integer idCliente, String nome, String sobrenome, String numeroCpf, String numeroRg,
			Calendar dataNascimento, Integer idade, String sexo, String email, String receberEmailFaltaMedicamento,
			String telefone, String celular, String rua, Integer numeroResidencial, String bairro, String complemento,
			String municipio, String estado, String cep, Plano plano, Integer sequencia, SituacaoCliente situacao, Usuario usuario) {
		this.idCliente = idCliente;
		this.sequencia = sequencia;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numeroCpf = numeroCpf;
		this.numeroRg = numeroRg;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.rua = rua;
		this.numeroResidencial = numeroResidencial;
		this.bairro = bairro;
		this.complemento = complemento;
		this.municipio = municipio;
		this.estado = estado;
		this.cep = cep;
		this.plano = plano;
		this.situacao = situacao;
		this.usuario = usuario;
	}



	@Override
	public Integer getId() {
		return this.idCliente;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public Integer getSequencia() {
		return sequencia;
	}
	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}		

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNumeroCpf() {
		return numeroCpf;
	}
	public void setNumeroCpf(String numeroCpf) {
		this.numeroCpf = numeroCpf;
	}
	public String getNumeroRg() {
		return numeroRg;
	}
	public void setNumeroRg(String numeroRg) {
		this.numeroRg = numeroRg;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumeroResidencial() {
		return numeroResidencial;
	}
	public void setNumeroResidencial(Integer numeroResidencial) {
		this.numeroResidencial = numeroResidencial;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Plano getPlano() {
		return plano;
	}
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	public SituacaoCliente getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoCliente situacao) {
		this.situacao = situacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}