package br.com.consultoria.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import br.com.consultoria.model.dao.interfaces.BasicDaoInterface;
import br.com.consultoria.model.dao.interfaces.UsuarioDaoInterface;
import br.com.consultoria.model.entity.Usuario;

@Repository
@Transactional
public class UsuarioDao extends BasicDao<Usuario, Integer> implements UserDetailsService, BasicDaoInterface<Usuario>, UsuarioDaoInterface{

	@Override
	public Usuario loadUserByUsername(String usuario) throws UsernameNotFoundException {
		List<Usuario> usuarios = new ArrayList<Usuario>(); 
		String query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario";
		usuarios = this.entityManager.createQuery(query, Usuario.class).setParameter("usuario", usuario).getResultList();
		if(usuarios.isEmpty()){
			throw new UsernameNotFoundException("Usuário "+usuario+" não encontrado");			
		}
		return usuarios.get(0);
	}
	
	@Override
	public Usuario save(Usuario entity) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(entity.getUsername());
		entity.setSenha(encodedPassword);
		return super.save(entity);
	}
}