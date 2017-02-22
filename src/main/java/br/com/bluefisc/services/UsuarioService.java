package br.com.bluefisc.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluefisc.model.dao.interfaces.UsuarioDaoInterface;
import br.com.bluefisc.model.entity.Role;
import br.com.bluefisc.model.entity.Usuario;
import br.com.bluefisc.services.interfaces.UsuarioServiceInterface;

@Service
@Transactional
public class UsuarioService implements UsuarioServiceInterface, UserDetailsService {

	@Autowired
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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		entity.setSenha(encoder.encode(entity.getSenha()));
		return usuarioDao.save(entity);
	}

	@Override
	public void update(Usuario entity) {
		
		Usuario usuario2 = usuarioDao.findById(entity.getId());
		//Se não foi digitado uma nova senha na tela, mantem a mesma
		if(entity.getSenha().isEmpty()){
			entity.setSenha(usuario2.getSenha());
		}else{
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			entity.setSenha(encoder.encode(entity.getSenha()));
		}				
		entity.setPermissoes(usuario2.getPermissoes());
		usuarioDao.update(entity);
	}

	@Override
	public void delete(Usuario entity) {
		usuarioDao.delete(entity);
	}

	@Override
	public Usuario saveUsuarioCliente(Usuario usuario) {		
		usuario.setPermissoes(Arrays.asList(new Role("ROLE_CLIENTE")));
		usuario = save(usuario);
		return usuario;
	}
}
