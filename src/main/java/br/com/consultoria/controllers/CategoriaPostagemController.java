package br.com.consultoria.controllers;

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

import br.com.consultoria.model.components.Retorno;
import br.com.consultoria.model.entity.CategoriaPostagem;
import br.com.consultoria.services.interfaces.CategoriaPostagemServiceInterface;

@Controller
@RequestMapping("/Adm/CategoriaPostagem")
public class CategoriaPostagemController {
	
	@Autowired
	private CategoriaPostagemServiceInterface categoriaPostagemService;
	@Autowired
	private MessageSource messageSource;	
	
	private String controller = "adm/categoriaPostagem";
	
	@RequestMapping("/Consulta")
	public String consulta() {	      
		return controller+"/ConsultaCategoriaPostagens";
	}
	
	@RequestMapping("/Form/{idCategoriaPostagem}")
	public String form(Model mv,@PathVariable("idCategoriaPostagem") Integer idCategoriaPostagem) {
		CategoriaPostagem categoriaPostagem = categoriaPostagemService.findById(idCategoriaPostagem);				
		mv.addAttribute("categoriaPostagem", categoriaPostagem);				
		return controller+"/FormCategoriaPostagem";		
	}
	
	@RequestMapping("/Form")
	public String formEditar(Model mv) {				
		CategoriaPostagem categoriaPostagem = new CategoriaPostagem();	
		mv.addAttribute("categoriaPostagem", categoriaPostagem);
		return controller+"/FormCategoriaPostagem";		
	}
	
		  
	@RequestMapping("/Form/Processar")
	public String Incluir(@Valid CategoriaPostagem categoriaPostagem,BindingResult result, Boolean goSubForm,Model model){
						
		if(result.hasErrors()) {
			System.out.println("Tem erro " + result.getAllErrors());
		    model.addAttribute("categoriaPostagem", categoriaPostagem);
		    return controller+"/FormCategoriaPostagem";
	  	}				
		
		if(categoriaPostagemService.findById(categoriaPostagem.getIdCategoriaPostagem()) == null){		
			categoriaPostagemService.save(categoriaPostagem);
		}else{		
			categoriaPostagemService.update(categoriaPostagem);
		}				
		
		String retorno = "";
		if(goSubForm == null){
			retorno = "redirect:/Adm/CategoriaPostagem/Consulta";			
		}else{
			retorno = "redirect:/Adm/Apresentacao/Form/" + categoriaPostagem.getIdCategoriaPostagem();
		}

		return retorno;			
	}
	
 	@RequestMapping("/Excluir/{idEntity}")
	@ResponseBody
	public Retorno Excluir(@PathVariable("idEntity") Integer idEntity){
		Retorno retorno = new Retorno();		
		CategoriaPostagem entity = categoriaPostagemService.findById(idEntity);
		try{
	/*		List<Apresentacao> lista = apresentacaoService.listarPorCategoriaPostagem(entity.getIdCategoriaPostagem());
			for (Apresentacao apresentacao : lista) {
				apresentacaoService.delete(apresentacao);
			}*/			
			categoriaPostagemService.delete(entity);
		}catch (Exception e) {
			retorno.setErroGeral(messageSource.getMessage("erros.exclusao.jaReferenciado", new Object[]{}, Locale.getDefault()));
			return retorno;
		}
		return retorno;
	}
	
	@RequestMapping("/Listar")
	@ResponseBody
	public List<CategoriaPostagem> Listar(){
		return categoriaPostagemService.findAll();		  
	}	

	@RequestMapping("/getCategoriaPostagem/{idCategoriaPostagem}")
	@ResponseBody
	public CategoriaPostagem getCategoriaPostagem(@PathVariable("idCategoriaPostagem") Integer idCategoriaPostagem){
		return categoriaPostagemService.findById(idCategoriaPostagem);
	}	
	
}
