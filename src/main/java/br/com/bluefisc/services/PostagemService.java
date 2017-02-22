package br.com.bluefisc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluefisc.model.dao.interfaces.PostagemDaoInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagem;
import br.com.bluefisc.model.entity.Postagem;
import br.com.bluefisc.services.interfaces.PostagemServiceInterface;

@Service
@Transactional
public class PostagemService implements PostagemServiceInterface {

	@Autowired
	private PostagemDaoInterface postagemDao;

	@Override
	public List<Postagem> findAll() {
		return postagemDao.findAll();
	}

	@Override
	public Postagem findById(Integer pk) {
		return postagemDao.findById(pk);
	}

	@Override
	public Postagem save(Postagem entity) {
		return postagemDao.save(entity);
	}

	@Override
	public void update(Postagem entity) {
		postagemDao.update(entity);
	}

	@Override
	public void delete(Postagem entity) {
		postagemDao.delete(entity);
	}

	@Override
	public List<Postagem> listarPorAreaECategoria(Area area, CategoriaPostagem categoriaPostagem) {
		return postagemDao.listarPorAreaECategoria(area, categoriaPostagem);
	}
}
