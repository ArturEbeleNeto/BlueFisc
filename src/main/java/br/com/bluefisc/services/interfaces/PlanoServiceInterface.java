package br.com.bluefisc.services.interfaces;

import java.util.List;

import br.com.bluefisc.model.dao.interfaces.PlanoDaoInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.Plano;

public interface PlanoServiceInterface extends PlanoDaoInterface {
	
	public List<Area> listarAreasPorPlano(Plano plano);

	public Plano deleteAreaFromPlano(Plano plano, Area area);

	public void adicionarAreaNoPlano(Plano plano, Area area);
	
}