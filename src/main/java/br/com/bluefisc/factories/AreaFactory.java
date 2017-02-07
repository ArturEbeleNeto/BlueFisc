package br.com.bluefisc.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluefisc.factories.interfaces.EntityFactoryInterface;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.services.interfaces.AreaServiceInterface;

@Component
public class AreaFactory implements EntityFactoryInterface<Area> {

	@Autowired
	private AreaServiceInterface areaService;
	
	@Override
	public Area getEntity(Area entity) {
		entity = (Area) areaService.findById(entity.getId());
		if(entity == null){
			entity = getEntity();
		}	
		return entity;
	}

	@Override
	public Area getEntity(Integer id) {
		Area entity = new Area();
		entity.setIdArea(id);
		return getEntity(entity);
	}

	@Override
	public Area getEntity() {
		Area entity = new Area();
		return entity;
	}

}
