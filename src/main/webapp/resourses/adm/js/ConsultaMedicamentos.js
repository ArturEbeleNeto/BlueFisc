function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Medicamento/Form/'+row.idMedicamento+'"><span class="glyphicon glyphicon-pencil"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idMedicamento+'" nameEntity="Medicamento" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaMedicamentos").bootstrapTable({
		url: BASE_URL + "Medicamento/Listar"     
	})	
	
})