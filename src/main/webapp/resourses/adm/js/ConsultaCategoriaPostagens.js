function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'CategoriaPostagem/Form/'+row.idCategoriaPostagem+'"><span class="glyphicon glyphicon-pencil"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idCategoriaPostagem+'" nameEntity="CategoriaPostagem" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaCategoriaPostagens").bootstrapTable({
		url: BASE_URL + "CategoriaPostagem/Listar"     
	})	
	     
})