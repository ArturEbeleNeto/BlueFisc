package br.com.consultoria.controllers;

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
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/QuemSomos")
	public ModelAndView quemSomos(){
		ModelAndView mv = new ModelAndView("quemSomos");
		return mv;
	}	
	
	@RequestMapping("/Servicos")
	public ModelAndView servicos(){
		ModelAndView mv = new ModelAndView("servicos");
		return mv;
	}
	
	@RequestMapping("/AreaCliente")
	public ModelAndView areaCliente(){
		ModelAndView mv = new ModelAndView("areaCliente");
		return mv;
	}
	
	@RequestMapping("/Contato")
	public ModelAndView contato(){
		ModelAndView mv = new ModelAndView("contato");
		return mv;
	}				
	
	@RequestMapping("/Login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}	
	
	@RequestMapping("/Cadastro")
	public ModelAndView cadastro(){
		ModelAndView mv = new ModelAndView("cadastro");
		return mv;
	}		
}
