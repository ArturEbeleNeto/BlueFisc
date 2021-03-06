package br.com.bluefisc.model.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "usuario")	
public class Usuario extends BaseEntity implements UserDetails{

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@NotBlank
	@Length(min=5, message="O usuário deve ter pelo menos 5 caracteres")
	private String usuario;

	@NotBlank
	private String senha;	
	
	@Transient
	private String confirmacaoSenha;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="idCliente", referencedColumnName="idCliente")
	private Cliente cliente;

	@OneToMany(fetch=FetchType.EAGER)
	private List<Role> permissoes = new ArrayList<Role>();
	
	
	public Usuario() {}
	public Usuario(Integer idUsuario, String usuario, String senha,String confirmacaoSenha, Cliente cliente) {
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.senha = senha;
		this.senha = confirmacaoSenha;
		this.cliente = cliente;
	}
	
	public String getNome(){
		return cliente.getNome();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissoes;
	}	
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.usuario;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}	
	@Override
	public Integer getId() {
		return this.idUsuario;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}
	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}
	public List<Role> getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(List<Role> permissoes) {
		this.permissoes = permissoes;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}