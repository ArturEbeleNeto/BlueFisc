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
	public String Incluir(@Valid Cliente cliente,BindingResult result, Boolean goSubForm,Model model){
						
		if(result.hasErrors()) {
		    model.addAttribute("cliente", cliente);
		    return controller+"/FormCliente";
	  	}				
		
		if(clienteService.findById(cliente.getIdCliente()) == null){		
			clienteService.save(cliente);
		}else{		
			clienteService.update(cliente);
		}				
		
		String retorno = "";
		if(goSubForm == null){
			retorno = "redirect:/Adm/Cliente/Consulta";			
		}else{
			retorno = "redirect:/Adm/CategoriaPostagemCliente/Form/" + cliente.getIdCliente();
		}

		return retorno;			
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
