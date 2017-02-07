package br.com.bluefisc.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluefisc.factories.interfaces.EntityFactoryInterface;
import br.com.bluefisc.model.entity.CategoriaPostagem;
import br.com.bluefisc.services.interfaces.CategoriaPostagemServiceInterface;

@Component
public class CategoriaPostagemFactory implements EntityFactoryInterface<CategoriaPostagem> {

	@Autowired
	private CategoriaPostagemServiceInterface categoriaPostagemService;
	
	@Override
	public CategoriaPostagem getEntity(CategoriaPostagem entity) {
		entity = (CategoriaPostagem) categoriaPostagemService.findById(entity.getId());
		if(entity == null){
			entity = getEntity();
		}	
		return entity;
	}

	@Override
	public CategoriaPostagem getEntity(Integer id) {
		CategoriaPostagem entity = new CategoriaPostagem();
		entity.setIdCategoriaPostagem(id);
		return getEntity(entity);
	}

	@Override
	public CategoriaPostagem getEntity() {
		CategoriaPostagem entity = new CategoriaPostagem();
		return entity;
	}

}
