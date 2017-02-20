package br.com.bluefisc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluefisc.model.dao.interfaces.ClienteDaoInterface;
import br.com.bluefisc.model.entity.Cliente;
import br.com.bluefisc.services.interfaces.ClienteServiceInterface;

@Service
@Transactional
public class ClienteService implements ClienteServiceInterface {

	@Autowired
	private ClienteDaoInterface clienteDao;
		
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
		return clienteDao.save(entity);
	}

	@Override
	public void update(Cliente entity) {
		clienteDao.update(entity);
	}

	@Override
	public void delete(Cliente entity) {
		clienteDao.delete(entity);
	}
}
