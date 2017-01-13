package br.com.consultoria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.consultoria.model.dao.interfaces.AreaDaoInterface;
import br.com.consultoria.model.entity.Area;
import br.com.consultoria.services.interfaces.AreaServiceInterface;

@Service
public class AreaService implements AreaServiceInterface {

	@Autowired
	private AreaDaoInterface areaDao;

	@Override
	public List<Area> findAll() {
		return areaDao.findAll();
	}

	@Override
	public Area findById(Integer pk) {
		return areaDao.findById(pk);
	}

	@Override
	public Area save(Area entity) {
		return areaDao.save(entity);
	}

	@Override
	public void update(Area entity) {
		areaDao.update(entity);
	}

	@Override
	public void delete(Area entity) {
		areaDao.delete(entity);
	}
}
