function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Categoria/Form/'+row.idCategoria+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarCategoria"  aria-hidden="true" idCategoria="'+row.idCategoria+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a href=""><span idEntity="'+row.idCategoria+'" nameEntity="Categoria" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaCategorias").bootstrapTable({
		url: BASE_URL + "Categoria/Listar"     
	})	
	
})