package br.com.bluefisc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/AreaCliente")
public class AreaClienteController {			
	
	@RequestMapping()
	public ModelAndView areaCliente(){
		ModelAndView mv = new ModelAndView("site/areaCliente");
		return mv;
	}
	
}
