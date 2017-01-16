function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Area/Form/'+row.idArea+'"><span class="glyphicon glyphicon-pencil"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idArea+'" nameEntity="Area" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaAreas").bootstrapTable({
		url: BASE_URL + "Area/Listar"     
	})	
	     
})