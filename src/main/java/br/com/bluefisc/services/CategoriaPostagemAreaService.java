package br.com.bluefisc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluefisc.model.dao.interfaces.CategoriaPostagemAreaDaoInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagemArea;
import br.com.bluefisc.services.interfaces.CategoriaPostagemAreaServiceInterface;

@Service
@Transactional
public class CategoriaPostagemAreaService implements CategoriaPostagemAreaServiceInterface {

	@Autowired
	private CategoriaPostagemAreaDaoInterface categoriaPostagemAreaDao;

	@Override
	public List<CategoriaPostagemArea> findAll() {
		return categoriaPostagemAreaDao.findAll();
	}

	@Override
	public CategoriaPostagemArea findById(Integer pk) {
		return categoriaPostagemAreaDao.findById(pk);
	}

	@Override
	public CategoriaPostagemArea save(CategoriaPostagemArea entity) {
		return categoriaPostagemAreaDao.save(entity);
	}

	@Override
	public void update(CategoriaPostagemArea entity) {
		categoriaPostagemAreaDao.update(entity);
	}

	@Override
	public void delete(CategoriaPostagemArea entity) {
		categoriaPostagemAreaDao.delete(entity);
	}

	@Override
	public List<CategoriaPostagemArea> listarPorArea(Area area) {
		return categoriaPostagemAreaDao.listarPorArea(area);
	}
}
