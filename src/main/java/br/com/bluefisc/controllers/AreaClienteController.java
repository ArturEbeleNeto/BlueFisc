package br.com.bluefisc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.bluefisc.model.entity.Area;
import br.com.bluefisc.model.entity.CategoriaPostagem;
import br.com.bluefisc.model.entity.Postagem;
import br.com.bluefisc.services.interfaces.AreaServiceInterface;
import br.com.bluefisc.services.interfaces.CategoriaPostagemServiceInterface;
import br.com.bluefisc.services.interfaces.PostagemServiceInterface;

@Controller
@RequestMapping("/AreaCliente")
public class AreaClienteController {			
	
	@Autowired
	private AreaServiceInterface areaService;
	@Autowired
	private CategoriaPostagemServiceInterface categoriaPostagemService;
	@Autowired
	private PostagemServiceInterface postagemService;
	@RequestMapping()
	public ModelAndView areaCliente(){
		ModelAndView mv = new ModelAndView("site/areaCliente");
		List<Area> areas = areaService.listarPorPlanoDoCliente();
		mv.addObject("areas", areas);
		return mv;
	}
	
	@RequestMapping("/Area/{idArea}")
	public ModelAndView area(Area area){
		ModelAndView mv = new ModelAndView("site/consultaArea");
		area = areaService.findById(area.getId());
		List<CategoriaPostagem> categorias = categoriaPostagemService.listarPorAreaDoPlanoDoCliente(area);
		mv.addObject("categorias", categorias);
		mv.addObject("area", area);
		return mv;
	}	
	
	@RequestMapping("/Area/{idArea}/Postagem/{idPostagem}")
	public ModelAndView postagem(Postagem postagem){
		ModelAndView mv = new ModelAndView("site/consultaPostagem");
		postagem = postagemService.findById(postagem.getId());
		mv.addObject("postagem", postagem);
		return mv;
	}		
}
