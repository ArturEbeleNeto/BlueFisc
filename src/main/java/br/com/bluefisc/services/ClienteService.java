package br.com.bluefisc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluefisc.model.dao.interfaces.ClienteDaoInterface;
import br.com.bluefisc.model.entity.Cliente;
import br.com.bluefisc.model.entity.Usuario;
import br.com.bluefisc.services.interfaces.ClienteServiceInterface;
import br.com.bluefisc.services.interfaces.UsuarioServiceInterface;

@Service
@Transactional
public class ClienteService implements ClienteServiceInterface {

	@Autowired
	private ClienteDaoInterface clienteDao;
	@Autowired
	private UsuarioServiceInterface usuarioDao;
		
	@Override
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	public Cliente findById(Integer pk) {
		return clienteDao.findById(pk);
	}

	@Override
	public Cliente save(Cliente entity) {		
		Usuario usuario = entity.getUsuario();
		usuario.setCliente(entity);
		usuarioDao.saveUsuarioCliente(usuario);		
		return clienteDao.save(entity);
	}

	@Override
	public void update(Cliente entity) {
		Usuario usuario = entity.getUsuario();
		usuario.setCliente(entity);
		usuarioDao.update(usuario);
		clienteDao.update(entity);
	}

	@Override
	public void delete(Cliente entity) {
		clienteDao.delete(entity);
	}
	
}
