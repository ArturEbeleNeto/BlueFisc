function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Usuario/Form/'+row.idUsuario+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarUsuario"  aria-hidden="true" idUsuario="'+row.idUsuario+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idUsuario+'" nameEntity="Usuario" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaUsuarios").bootstrapTable({
		url: BASE_URL + "Usuario/Listar"     
	})	
	
})