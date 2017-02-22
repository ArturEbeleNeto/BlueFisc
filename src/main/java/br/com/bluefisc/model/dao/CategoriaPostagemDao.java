package br.com.bluefisc.model.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bluefisc.model.dao.interfaces.CategoriaPostagemDaoInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagem;

@Repository
@Transactional
public class CategoriaPostagemDao extends BasicDao<CategoriaPostagem> implements CategoriaPostagemDaoInterface{

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoriaPostagem> listarPorAreaDoPlanoDoCliente(Area area) {
		String sql = "SELECT cpa.categoriaPostagem FROM CategoriaPostagemArea cpa WHERE cpa.area = :area";
		Query query = entityManager.createQuery(sql);
		query.setParameter("area", area);
		return query.getResultList();
	}
}