function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Medico/Form/'+row.idMedico+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarMedico"  aria-hidden="true" idMedico="'+row.idMedico+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a href=""><span idEntity="'+row.idMedico+'" nameEntity="Medico" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaMedicos").bootstrapTable({
		url: BASE_URL + "Medico/Listar"     
	})	
	
})