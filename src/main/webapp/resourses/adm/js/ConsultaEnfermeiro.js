function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Enfermeiro/Form/'+row.idEnfermeiro+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarEnfermeiro"  aria-hidden="true" idEnfermeiro="'+row.idEnfermeiro+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idEnfermeiro+'" nameEntity="Enfermeiro" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaEnfermeiros").bootstrapTable({
		url: BASE_URL + "Enfermeiro/Listar"     
	})	
	
})