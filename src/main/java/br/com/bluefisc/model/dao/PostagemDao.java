package br.com.bluefisc.model.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bluefisc.model.dao.interfaces.PostagemDaoInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagem;
import br.com.bluefisc.model.entity.Postagem;

@Repository
@Transactional
public class PostagemDao extends BasicDao<Postagem> implements PostagemDaoInterface{

	@SuppressWarnings("unchecked")
	@Override
	public List<Postagem> listarPorAreaECategoria(Area area, CategoriaPostagem categoriaPostagem) {
		String sql = "SELECT postagem FROM Postagem postagem WHERE postagem.area = :area AND postagem.categoriaPostagem = :categoriaPostagem";
		Query query = entityManager.createQuery(sql);
		query.setParameter("area", area);
		query.setParameter("categoriaPostagem", categoriaPostagem);
		return query.getResultList();
	}
	
}