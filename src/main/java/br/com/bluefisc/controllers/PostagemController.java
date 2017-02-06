package br.com.bluefisc.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bluefisc.factories.interfaces.EntityFactoryInterface;
import br.com.bluefisc.model.components.Retorno;
import br.com.bluefisc.model.entity.Postagem;
import br.com.bluefisc.services.interfaces.PostagemServiceInterface;

@Controller
@RequestMapping("/Adm/Postagem")
public class PostagemController {
	
	@Autowired
	private PostagemServiceInterface postagemService;
	@Autowired
	private EntityFactoryInterface<Postagem> postagemFactory;
	@Autowired
	private MessageSource messageSource;	
	
	private String controller = "adm/postagem";
	
	
	@RequestMapping("/Consulta")
	public String consulta() {	      
		return controller+"/ConsultaPostagem";
	}
	
	
	
	@RequestMapping("/Form/{idPostagem}")
	public String form(Model mv,@PathVariable("idPostagem") Integer idPostagem) {
		Postagem postagem = postagemService.findById(idPostagem);				
		mv.addAttribute("postagem", postagem);				
		return controller+"/FormPostagem";		
	}
	
	@RequestMapping("/Form")
	public String formEditar(Model mv) {				
		Postagem postagem = postagemFactory.getEntity();
		mv.addAttribute("postagem", postagem);
		return controller+"/FormPostagem";		
	}
	
		  
	@RequestMapping("/Form/Processar")
	public String Incluir(@Valid Postagem postagem,BindingResult result, Model model){
						
		if(result.hasErrors()) {
		    model.addAttribute("postagem", postagem);
		    return controller+"/FormPostagem";
	  	}				
		
		if(postagemService.findById(postagem.getId()) == null){		
			postagemService.save(postagem);
		}else{		
			postagemService.update(postagem);
		}				
		
		return "redirect:/Adm/Postagem/Consulta/";
	}
	
 	@RequestMapping("/Excluir/{idEntity}")
	@ResponseBody
	public Retorno Excluir(@PathVariable("idEntity") Integer idEntity){
		Retorno retorno = new Retorno();		
		Postagem entity = postagemService.findById(idEntity);
		try{		
			postagemService.delete(entity);
		}catch (Exception e) {
			retorno.setErroGeral(messageSource.getMessage("erros.exclusao.jaReferenciado", new Object[]{}, Locale.getDefault()));
			return retorno;
		}
		return retorno;
	}
	
	@RequestMapping("/Listar")
	@ResponseBody
	public List<Postagem> Listar(){
		return postagemService.findAll();		  
	}	

	@RequestMapping("/getPostagem/{idPostagem}")
	@ResponseBody
	public Postagem getPostagem(@PathVariable("idPostagem") Integer idPostagem){
		return postagemService.findById(idPostagem);
	}	
	
}
