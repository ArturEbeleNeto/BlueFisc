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
import br.com.bluefisc.model.entity.Plano;
import br.com.bluefisc.services.interfaces.PlanoServiceInterface;

@Controller
@RequestMapping("/Adm/Plano")
public class PlanoController {
	
	@Autowired
	private PlanoServiceInterface planoService;
	@Autowired
	private EntityFactoryInterface<Plano> planoFactory;

	@Autowired
	private MessageSource messageSource;	
	
	private String controller = "adm/plano";
	
	
	@RequestMapping("/Consulta")
	public String consulta() {	      
		return controller+"/ConsultaPlanos";
	}
	
	@RequestMapping("/Form/{idPlano}")
	public String form(Model mv,@PathVariable("idPlano") Integer idPlano) {
		Plano plano = planoService.findById(idPlano);				
		mv.addAttribute("plano", plano);				
		return controller+"/FormPlano";		
	}
	
	@RequestMapping("/Form")
	public String formEditar(Model mv) {				
		Plano plano = planoFactory.getEntity();	
		mv.addAttribute("plano", plano);
		return controller+"/FormPlano";		
	}
	
		  
	@RequestMapping("/Form/Processar")
	public String Incluir(@Valid Plano plano,BindingResult result, Boolean goSubForm,Model model){
						
		if(result.hasErrors()) {
		    model.addAttribute("plano", plano);
		    return controller+"/FormPlano";
	  	}				
		
		if(planoService.findById(plano.getIdPlano()) == null){		
			planoService.save(plano);
		}else{		
			planoService.update(plano);
		}				
		
		System.out.println(plano);
		
		String retorno = "";
		if(goSubForm == null){
			retorno = "redirect:/Adm/Plano/Consulta";			
		}else{
			retorno = "redirect:/Adm/AreaPlano/Form/" + plano.getIdPlano();
		}

		return retorno;			
	}
	
 	@RequestMapping("/Excluir/{idEntity}")
	@ResponseBody
	public Retorno Excluir(@PathVariable("idEntity") Integer idEntity){
		Retorno retorno = new Retorno();		
		Plano entity = planoService.findById(idEntity);
		try{
	/*		List<AreaPlano> lista = areaPlanoService.listarPorPlano(entity.getIdPlano());
			for (AreaPlano areaPlano: lista) {
				areaPlanoService.delete(areaPlano);
			}*/			
			planoService.delete(entity);
		}catch (Exception e) {
			retorno.setErroGeral(messageSource.getMessage("erros.exclusao.jaReferenciado", new Object[]{}, Locale.getDefault()));
			return retorno;
		}
		return retorno;
	}
	
	@RequestMapping("/Listar")
	@ResponseBody
	public List<Plano> Listar(){
		return planoService.findAll();		  
	}	

	@RequestMapping("/getPlano/{idPlano}")
	@ResponseBody
	public Plano getPlano(@PathVariable("idPlano") Integer idPlano){
		return planoService.findById(idPlano);
	}	
	
}
