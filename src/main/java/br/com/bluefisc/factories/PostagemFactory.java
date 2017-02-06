package br.com.bluefisc.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bluefisc.factories.interfaces.EntityFactoryInterface;
import br.com.bluefisc.model.entity.Postagem;
import br.com.bluefisc.services.interfaces.PostagemServiceInterface;
import br.com.bluefisc.util.Util;

@Component
public class PostagemFactory implements EntityFactoryInterface<Postagem> {

	@Autowired
	private PostagemServiceInterface postagemService;
	
	@Override
	public Postagem getEntity(Postagem entity) {
		entity = (Postagem) postagemService.findById(entity.getId());
		if(entity == null){
			entity = getEntity();
		}	
		return entity;
	}

	@Override
	public Postagem getEntity(Integer id) {
		Postagem entity = new Postagem();
		entity.setIdPostagem(id);
		return getEntity(entity);
	}

	@Override
	public Postagem getEntity() {
		Postagem entity = new Postagem();
		entity.setDataPublicacao(Util.getDataAtual());
		entity.setUsuario(Util.getUsuarioAtual());
		return entity;
	}

}
