package br.com.bluefisc.model.dao.interfaces;

import java.util.List;

import br.com.bluefisc.model.entity.Area;

public interface AreaDaoInterface extends BasicDaoInterface<Area> {
	
	public List<Area> listarPorPlanoDoCliente();
	
}