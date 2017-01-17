package br.com.bluefisc.services;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.bluefisc.model.dao.interfaces.UsuarioDaoInterface;
import br.com.bluefisc.model.entity.Usuario;
import br.com.bluefisc.services.interfaces.UsuarioServiceInterface;

public class UsuarioService implements UsuarioServiceInterface {

	private UsuarioDaoInterface usuarioDao;
	
	@Override
	public Usuario loadUserByUsername(String usuario) throws UsernameNotFoundException {
		return usuarioDao.loadUserByUsername(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	@Override
	public Usuario findById(Integer pk) {
		return usuarioDao.findById(pk);
	}

	@Override
	public Usuario save(Usuario entity) {
		return usuarioDao.save(entity);
	}

	@Override
	public void update(Usuario entity) {
		usuarioDao.update(entity);
	}

	@Override
	public void delete(Usuario entity) {
		usuarioDao.delete(entity);
	}
}