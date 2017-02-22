package br.com.bluefisc.model.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bluefisc.model.dao.interfaces.AreaDaoInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.util.Util;

@Repository
@Transactional
public class AreaDao extends BasicDao<Area> implements AreaDaoInterface{

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> listarPorPlanoDoCliente() {
		String sql = "SELECT cliente.plano.areas FROM Cliente cliente WHERE cliente = :cliente";
		Query query = entityManager.createQuery(sql);
		query.setParameter("cliente", Util.getUsuarioAtual().getCliente());
		return query.getResultList();
	}

}