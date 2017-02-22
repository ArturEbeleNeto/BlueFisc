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
import br.com.bluefisc.model.entity.Cliente;
import br.com.bluefisc.model.entity.Usuario;
import br.com.bluefisc.services.interfaces.ClienteServiceInterface;

@Controller
@RequestMapping("/Adm/Cliente")
public class ClienteController {
	
	@Autowired
	private ClienteServiceInterface clienteService;

	@Autowired
	private MessageSource messageSource;	
	
	private String controller = "adm/cliente";
	
	
	@RequestMapping("/Consulta")
	public String consulta() {	      
		return controller+"/ConsultaClientes";
	}
	
	@RequestMapping("/Form/{idCliente}")
	public String form(Model mv,@PathVariable("idCliente") Integer idCliente) {
		Cliente cliente = clienteService.findById(idCliente);
		
		Usuario usuario = cliente.getUsuario();
		usuario.setSenha("");
		usuario.setConfirmacaoSenha("");
		cliente.setUsuario(usuario);
		
		mv.addAttribute("cliente", cliente);				
		return controller+"/FormCliente";		
	}
	
	@RequestMapping("/Form")
	public String formEditar(Model mv) {				
		Cliente cliente = new Cliente();	
		mv.addAttribute("cliente", cliente);
		return controller+"/FormCliente";		
	}
	
		  
	@RequestMapping("/Form/Processar")
	public String Incluir(@Valid Cliente cliente, BindingResult result,Model model){
			
		model.addAttribute("cliente", cliente);
		
		Usuario usuario = cliente.getUsuario();
		if(usuario.getUsuario().isEmpty()){
			result.rejectValue("usuario.usuario", "", "Campo obrigatório");
		}else{
			if(usuario.getUsuario().length() < 5){
				result.rejectValue("usuario.usuario", "", "O usuário deve conter no mínimo 5 caracteres");
			}
		}
		if(usuario.getId() == null){
			if(usuario.getSenha().isEmpty()){			
				result.rejectValue("usuario.senha", "", "Senha obrigatória");
			}
		}		
		if( ! usuario.getSenha().equals(usuario.getConfirmacaoSenha())){
			result.rejectValue("usuario.confirmacaoSenha", "", "As senhas não conferem");
		}
		
		if(result.hasErrors()) {    
		    return controller+"/FormCliente";
	  	}	
		
		if(clienteService.findById(cliente.getIdCliente()) == null){		
			clienteService.save(cliente);
		}else{		
			clienteService.update(cliente);
		}				
		
		return "redirect:/Adm/Cliente/Consulta";			
	}
	
 	@RequestMapping("/Excluir/{idEntity}")
	@ResponseBody
	public Retorno Excluir(@PathVariable("idEntity") Integer idEntity){
		Retorno retorno = new Retorno();		
		Cliente entity = clienteService.findById(idEntity);
		try{	
			clienteService.delete(entity);
		}catch (Exception e) {
			retorno.setErroGeral(messageSource.getMessage("erros.exclusao.jaReferenciado", new Object[]{}, Locale.getDefault()));
			return retorno;
		}
		return retorno;
	}
	
	@RequestMapping("/Listar")
	@ResponseBody
	public List<Cliente> Listar(){
		return clienteService.findAll();		  
	}	

	@RequestMapping("/getCliente/{idCliente}")
	@ResponseBody
	public Cliente getCliente(@PathVariable("idCliente") Integer idCliente){
		return clienteService.findById(idCliente);
	}	
	
}
