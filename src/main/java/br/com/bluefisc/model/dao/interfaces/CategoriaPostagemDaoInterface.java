package br.com.bluefisc.model.dao.interfaces;

import java.util.List;

import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagem;

public interface CategoriaPostagemDaoInterface extends BasicDaoInterface<CategoriaPostagem>{
	
	List<CategoriaPostagem> listarPorAreaDoPlanoDoCliente(Area area);
	
}