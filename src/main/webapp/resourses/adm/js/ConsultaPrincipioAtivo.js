function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'PrincipioAtivo/Form/'+row.idPrincipioAtivo+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarPrincipioAtivo"  aria-hidden="true" idPrincipioAtivo="'+row.idPrincipioAtivo+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idPrincipioAtivo+'" nameEntity="PrincipioAtivo" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaPrincipioAtivos").bootstrapTable({
		url: BASE_URL + "PrincipioAtivo/Listar"     
	})	
	
})