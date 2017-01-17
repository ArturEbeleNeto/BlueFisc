package br.com.bluefisc.model.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bluefisc.model.dao.interfaces.CategoriaPostagemAreaDaoInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagemArea;

@Repository
@Transactional
public class CategoriaPostagemAreaDao extends BasicDao<CategoriaPostagemArea> implements CategoriaPostagemAreaDaoInterface{

	@Override
	public List<CategoriaPostagemArea> listarPorArea(Area area) { 
		String query = "FROM CategoriaPostagemArea cpa WHERE cpa.area = :area";
		TypedQuery<CategoriaPostagemArea> cpa = entityManager.createQuery(query, CategoriaPostagemArea.class);
		cpa.setParameter("area", area);
		return cpa.getResultList(); 
	}
	
	
	
}