package br.com.bluefisc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteController {

	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("redirect:/Inicio");
		return mv;
	}
	
	@RequestMapping("/Inicio")
	public ModelAndView inicio(){
		ModelAndView mv = new ModelAndView("site/index");
		return mv;
	}
	
	@RequestMapping("/QuemSomos")
	public ModelAndView quemSomos(){
		ModelAndView mv = new ModelAndView("site/quemSomos");
		return mv;
	}	
	
	@RequestMapping("/Servicos")
	public ModelAndView servicos(){
		ModelAndView mv = new ModelAndView("site/servicos");
		return mv;
	}
	
	@RequestMapping("/Contato")
	public ModelAndView contato(){
		ModelAndView mv = new ModelAndView("site/contato");
		return mv;
	}					
	
	@RequestMapping("/Cadastro")
	public ModelAndView cadastro(){
		ModelAndView mv = new ModelAndView("site/cadastro");
		return mv;
	}		
}
