package br.com.bluefisc.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluefisc.factories.interfaces.EntityFactoryInterface;
import br.com.bluefisc.model.entity.Usuario;
import br.com.bluefisc.services.interfaces.UsuarioServiceInterface;

@Component
public class UsuarioFactory implements EntityFactoryInterface<Usuario> {

	@Autowired
	private UsuarioServiceInterface usuarioService;
	
	@Override
	public Usuario getEntity(Usuario entity) {
		entity = (Usuario) usuarioService.findById(entity.getId());
		if(entity == null){
			entity = getEntity();
		}	
		return entity;
	}

	@Override
	public Usuario getEntity(Integer id) {
		Usuario entity = new Usuario();
		entity.setIdUsuario(id);
		return getEntity(entity);
	}

	@Override
	public Usuario getEntity() {
		Usuario entity = new Usuario();
		return entity;
	}

}
