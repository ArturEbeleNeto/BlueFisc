package br.com.bluefisc.model.dao.interfaces;

import java.util.List;

import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagem;
import br.com.bluefisc.model.entity.Postagem;

public interface PostagemDaoInterface extends BasicDaoInterface<Postagem> {
	
	List<Postagem> listarPorAreaECategoria(Area area, CategoriaPostagem categoriaPostagem);	
	
}