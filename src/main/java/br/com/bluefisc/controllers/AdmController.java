package br.com.bluefisc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Adm")
public class AdmController {
	
	@RequestMapping({"/",""})
	public String adm() {	      
		return "adm/index";
	}
	
}
