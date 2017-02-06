package br.com.bluefisc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluefisc.model.dao.interfaces.AreaDaoInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.services.interfaces.AreaServiceInterface;

@Service
@Transactional
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
