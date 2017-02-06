package br.com.bluefisc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.bluefisc.model.entity.Usuario;
import br.com.bluefisc.services.interfaces.UsuarioServiceInterface;

@Controller
@RequestMapping("/Adm/Usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceInterface usuarioService;
	
	@RequestMapping("/Listar")
	@ResponseBody
	public List<Usuario> Listar(){
		return usuarioService.findAll();		  
	}	

	@RequestMapping("/getUsuario/{idEntity}")
	@ResponseBody
	public Usuario getUsuario(@PathVariable("idEntity") Integer idEntity){
		return usuarioService.findById(idEntity);
	}	
	
}
