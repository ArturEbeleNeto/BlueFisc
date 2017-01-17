package br.com.bluefisc.model.dao.interfaces;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.bluefisc.model.entity.Usuario;

public interface UsuarioDaoInterface extends BasicDaoInterface<Usuario> {
	
	public Usuario loadUserByUsername(String usuario) throws UsernameNotFoundException;

}