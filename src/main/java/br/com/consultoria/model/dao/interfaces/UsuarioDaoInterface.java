package br.com.consultoria.model.dao.interfaces;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.consultoria.model.entity.Usuario;

public interface UsuarioDaoInterface extends BasicDaoInterface<Usuario> {
	
	public Usuario loadUserByUsername(String usuario) throws UsernameNotFoundException;

}