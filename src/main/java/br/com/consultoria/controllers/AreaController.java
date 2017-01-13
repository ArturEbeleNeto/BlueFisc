package br.com.consultoria.controllers;

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

import br.com.consultoria.model.components.Retorno;
import br.com.consultoria.model.entity.Area;
import br.com.consultoria.services.interfaces.AreaServiceInterface;

@Controller
@RequestMapping("/Adm/Area")
public class AreaController {
	
	@Autowired
	private AreaServiceInterface areaService;

	@Autowired
	private MessageSource messageSource;	
	
	private String controller = "area";
	
	
	@RequestMapping("/Consulta")
	public String consulta() {	      
		return controller+"/ConsultaAreas";
	}
	
	@RequestMapping("/Form/{idArea}")
	public String form(Model mv,@PathVariable("idArea") Integer idArea) {
		Area area = areaService.findById(idArea);				
		mv.addAttribute("area", area);				
		return controller+"/FormArea";		
	}
	
	@RequestMapping("/Form")
	public String formEditar(Model mv) {				
		Area area = new Area();	
		mv.addAttribute("area", area);
		return controller+"/FormArea";		
	}
	
		  
	@RequestMapping("/Form/Processar")
	public String Incluir(@Valid Area area,BindingResult result, Boolean formApresentacao,Model model){
						
		if(result.hasErrors()) {					   
		    model.addAttribute("area", area);
		    return controller+"/FormArea";
	  	}				
		
		if(areaService.findById(area.getIdArea()) == null){		
			areaService.save(area);
		}else{		
			areaService.update(area);
		}				
		
		String retorno = "";
		if(formApresentacao == null){
			retorno = "redirect:/Area/Consulta";			
		}else{
			retorno = "redirect:/Apresentacao/Form/" + area.getIdArea();
		}
		
		return retorno;			
	}
	
	
	@RequestMapping("/Cancelar/")
	public String Cancelar2(){
		return "redirect:/Area/Consulta";
	}
		
	
 	@RequestMapping("/Excluir/{idEntity}")
	@ResponseBody
	public Retorno Excluir(@PathVariable("idEntity") Integer idEntity){
		Retorno retorno = new Retorno();		
		Area entity = areaService.findById(idEntity);
		try{
	/*		List<Apresentacao> lista = apresentacaoService.listarPorArea(entity.getIdArea());
			for (Apresentacao apresentacao : lista) {
				apresentacaoService.delete(apresentacao);
			}*/			
			areaService.delete(entity);
		}catch (Exception e) {
			retorno.setErroGeral(messageSource.getMessage("erros.exclusao.jaReferenciado", new Object[]{}, Locale.getDefault()));
			return retorno;
		}
		return retorno;
	}
	
	@RequestMapping("/Listar")
	@ResponseBody
	public List<Area> Listar(){
		return areaService.findAll();		  
	}	

	@RequestMapping("/getArea/{idArea}")
	@ResponseBody
	public Area getArea(@PathVariable("idArea") Integer idArea){
		return areaService.findById(idArea);
	}	
	
}
