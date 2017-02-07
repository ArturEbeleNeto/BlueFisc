package br.com.bluefisc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bluefisc.model.components.Retorno;
import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.Plano;
import br.com.bluefisc.services.interfaces.PlanoServiceInterface;

@Controller
@RequestMapping("/Adm/AreaPlano")
public class AreaPlanoController {
	
	@Autowired
	private PlanoServiceInterface planoService;

	private String controller = "adm/areaPlano";
	
	
	@RequestMapping("/Form/{idPlano}/{idArea}")
	public String formEditar(Model mv,Plano plano,Area area) {
		plano = planoService.findById(plano.getId());				
		mv.addAttribute("plano", plano);				
		return controller+"/FormAreaPlano";		
	}
	
	@RequestMapping("/Form/{idPlano}")
	public String form(Model mv, Plano plano) {				
		plano = planoService.findById(plano.getId());	
		mv.addAttribute("plano", plano);
		return controller+"/FormAreaPlano";		
	}
	
		  
	@RequestMapping("/Form/Processar")
	public String Incluir(Plano plano, Area area, Model model){				
		
		planoService.adicionarAreaNoPlano(plano, area);
		
		String retorno = "redirect:/Adm/Plano/Form/" + plano.getId();

		return retorno;			
	}
	
 	@RequestMapping("/Excluir/{idPlano}/{idArea}")
	@ResponseBody
	public Retorno Excluir(Plano plano, Area area){
		Retorno retorno = new Retorno();		
		planoService.deleteAreaFromPlano(plano, area);
		return retorno;
	}
	
	@RequestMapping("/ListarPorPlano/{idPlano}")
	@ResponseBody
	public List<Area> listarPorPlano(Plano plano){
		return planoService.listarAreasPorPlano(plano);		  
	}		
	
}