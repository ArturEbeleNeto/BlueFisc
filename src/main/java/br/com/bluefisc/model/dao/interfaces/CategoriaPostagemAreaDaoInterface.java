package br.com.bluefisc.model.dao.interfaces;

import java.util.List;

import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagemArea;

public interface CategoriaPostagemAreaDaoInterface extends BasicDaoInterface<CategoriaPostagemArea>{
	
	List<CategoriaPostagemArea> listarPorArea(Area area);
	
}