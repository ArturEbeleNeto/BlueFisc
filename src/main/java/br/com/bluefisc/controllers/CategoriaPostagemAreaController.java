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

import br.com.bluefisc.model.components.Retorno;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagemArea;
import br.com.bluefisc.services.interfaces.AreaServiceInterface;
import br.com.bluefisc.services.interfaces.CategoriaPostagemAreaServiceInterface;

@Controller
@RequestMapping("/Adm/CategoriaPostagemArea")
public class CategoriaPostagemAreaController {
	
	@Autowired
	private CategoriaPostagemAreaServiceInterface categoriaPostagemAreaService;
	@Autowired
	private AreaServiceInterface areaService;
	@Autowired
	private MessageSource messageSource;	
	
	private String controller = "adm/categoriaPostagemArea";
	
	
	@RequestMapping("/Form/{idArea}/{idCategoriaPostagemArea}")
	public String formEditar(Model mv,Area area, CategoriaPostagemArea categoriaPostagemArea) {
		categoriaPostagemArea = categoriaPostagemAreaService.findById(categoriaPostagemArea.getId());				
		mv.addAttribute("categoriaPostagemArea", categoriaPostagemArea);				
		return controller+"/FormCategoriaPostagemArea";		
	}
	
	@RequestMapping("/Form/{idArea}")
	public String form(Model mv, Area area) {				
		CategoriaPostagemArea categoriaPostagemArea = new CategoriaPostagemArea();
		categoriaPostagemArea.setArea(areaService.findById(area.getId()));
		mv.addAttribute("categoriaPostagemArea", categoriaPostagemArea);
		return controller+"/FormCategoriaPostagemArea";		
	}
	
		  
	@RequestMapping("/Form/Processar")
	public String Incluir(@Valid CategoriaPostagemArea categoriaPostagemArea,BindingResult result,Model model){
						
		if(result.hasErrors()) {
			System.out.println("Tem erro " + result.getAllErrors());
		    model.addAttribute("categoriaPostagemArea", categoriaPostagemArea);
		    return controller+"/FormCategoriaPostagemArea";
	  	}				
		
		if(categoriaPostagemAreaService.findById(categoriaPostagemArea.getIdCategoriaPostagemArea()) == null){		
			categoriaPostagemAreaService.save(categoriaPostagemArea);
		}else{		
			categoriaPostagemAreaService.update(categoriaPostagemArea);
		}				
		
		String retorno = "redirect:/Adm/Area/Form/" + categoriaPostagemArea.getArea().getId();

		return retorno;			
	}
	
 	@RequestMapping("/Excluir/{idEntity}")
	@ResponseBody
	public Retorno Excluir(@PathVariable("idEntity") Integer idEntity){
		Retorno retorno = new Retorno();		
		CategoriaPostagemArea entity = categoriaPostagemAreaService.findById(idEntity);
		try{
	/*		List<Apresentacao> lista = apresentacaoService.listarPorCategoriaPostagemArea(entity.getIdCategoriaPostagemArea());
			for (Apresentacao apresentacao : lista) {
				apresentacaoService.delete(apresentacao);
			}*/			
			categoriaPostagemAreaService.delete(entity);
		}catch (Exception e) {
			retorno.setErroGeral(messageSource.getMessage("erros.exclusao.jaReferenciado", new Object[]{}, Locale.getDefault()));
			return retorno;
		}
		return retorno;
	}
	
	@RequestMapping("/Listar")
	@ResponseBody
	public List<CategoriaPostagemArea> listar(){
		return categoriaPostagemAreaService.findAll();		  
	}	

	@RequestMapping("/ListarPorArea/{idArea}")
	@ResponseBody
	public List<CategoriaPostagemArea> listarPorArea(Area area){
		return categoriaPostagemAreaService.listarPorArea(area);		  
	}		
	
	@RequestMapping("/getCategoriaPostagemArea/{idCategoriaPostagemArea}")
	@ResponseBody
	public CategoriaPostagemArea getCategoriaPostagemArea(@PathVariable("idCategoriaPostagemArea") Integer idCategoriaPostagemArea){
		return categoriaPostagemAreaService.findById(idCategoriaPostagemArea);
	}	
	
}