function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Plano/Form/'+row.idPlano+'"><span class="glyphicon glyphicon-pencil"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idPlano+'" nameEntity="Plano" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaPlanos").bootstrapTable({
		url: BASE_URL + "Plano/Listar"     
	})	
	     
})