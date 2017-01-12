package br.com.consultoria.model.dao.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.consultoria.model.entity.Usuario;

public interface UsuarioDaoInterface {

	public List<Usuario> findAll();

	public Usuario findById(Integer pk);

	public Usuario save(Usuario entity);

	public void update(Usuario entity);

	public void delete(Usuario entity);
	
	public void saveOrUpdate(Usuario entity);	
	
	public Usuario loadUserByUsername(String usuario) throws UsernameNotFoundException;

}