package br.com.bluefisc.services.interfaces;

import br.com.bluefisc.model.dao.interfaces.UsuarioDaoInterface;
import br.com.bluefisc.model.entity.Usuario;

public interface UsuarioServiceInterface extends UsuarioDaoInterface {

	public Usuario saveUsuarioCliente(Usuario usuario);
	
}