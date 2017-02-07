package br.com.bluefisc.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluefisc.factories.interfaces.EntityFactoryInterface;
import br.com.bluefisc.model.entity.Plano;
import br.com.bluefisc.services.interfaces.PlanoServiceInterface;

@Component
public class PlanoFactory implements EntityFactoryInterface<Plano> {

	@Autowired
	private PlanoServiceInterface planoService;
	
	@Override
	public Plano getEntity(Plano entity) {
		entity = (Plano) planoService.findById(entity.getId());
		if(entity == null){
			entity = getEntity();
		}	
		return entity;
	}

	@Override
	public Plano getEntity(Integer id) {
		Plano entity = new Plano();
		entity.setIdPlano(id);
		return getEntity(entity);
	}

	@Override
	public Plano getEntity() {
		Plano entity = new Plano();
		return entity;
	}

}
