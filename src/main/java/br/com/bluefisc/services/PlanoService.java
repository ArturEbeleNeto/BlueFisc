package br.com.bluefisc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluefisc.factories.interfaces.EntityFactoryInterface;
import br.com.bluefisc.model.dao.interfaces.PlanoDaoInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.Plano;
import br.com.bluefisc.services.interfaces.PlanoServiceInterface;

@Service
@Transactional
public class PlanoService implements PlanoServiceInterface {

	@Autowired
	private PlanoDaoInterface planoDao;
	@Autowired
	private EntityFactoryInterface<Plano> planoFactory;
	@Autowired
	private EntityFactoryInterface<Area> areaFactory;
		

	@Override
	public List<Plano> findAll() {
		return planoDao.findAll();
	}

	@Override
	public Plano findById(Integer pk) {
		return planoDao.findById(pk);
	}

	@Override
	public Plano save(Plano entity) {
		return planoDao.save(entity);
	}

	@Override
	public void update(Plano entity) {
		entity.setAreas(listarAreasPorPlano(entity));
		planoDao.update(entity);
	}

	@Override
	public void delete(Plano entity) {
		planoDao.delete(entity);
	}

	@Override
	public List<Area> listarAreasPorPlano(Plano plano) {
		plano = findById(plano.getId());
		return plano.getAreas();
	}

	
	@Override
	public Plano deleteAreaFromPlano(Plano plano, Area area) {
		plano = findById(plano.getId());
		plano.deleteArea(area);
		return plano;
	}

	@Override
	public void adicionarAreaNoPlano(Plano plano, Area area) {
		plano = planoFactory.getEntity(plano);
		area  = areaFactory.getEntity(area);
		plano.addArea(area);
	}
}
