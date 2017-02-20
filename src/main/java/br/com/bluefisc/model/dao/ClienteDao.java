package br.com.bluefisc.model.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bluefisc.model.dao.interfaces.ClienteDaoInterface;
import br.com.bluefisc.model.entity.Cliente;

@Repository
@Transactional
public class ClienteDao extends BasicDao<Cliente> implements ClienteDaoInterface{	}