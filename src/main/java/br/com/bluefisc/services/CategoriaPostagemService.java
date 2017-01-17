package br.com.bluefisc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bluefisc.model.dao.interfaces.CategoriaPostagemDaoInterface;
import br.com.bluefisc.model.entity.CategoriaPostagem;
import br.com.bluefisc.services.interfaces.CategoriaPostagemServiceInterface;

@Service
public class CategoriaPostagemService implements CategoriaPostagemServiceInterface {

	@Autowired
	private CategoriaPostagemDaoInterface categoriaPostagemDao;

	@Override
	public List<CategoriaPostagem> findAll() {
		return categoriaPostagemDao.findAll();
	}

	@Override
	public CategoriaPostagem findById(Integer pk) {
		return categoriaPostagemDao.findById(pk);
	}

	@Override
	public CategoriaPostagem save(CategoriaPostagem entity) {
		return categoriaPostagemDao.save(entity);
	}

	@Override
	public void update(CategoriaPostagem entity) {
		categoriaPostagemDao.update(entity);
	}

	@Override
	public void delete(CategoriaPostagem entity) {
		categoriaPostagemDao.delete(entity);
	}
}
