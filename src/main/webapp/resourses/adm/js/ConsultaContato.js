function ExibeOpcoes(value, row) {      	
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Contato/Form/'+IdIdosoFicha+'/'+row.idContato+'"><span class="glyphicon glyphicon-pencil"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idContato+'" nameEntity="Contato" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	IdIdosoFicha = $("IdIdosoFicha").attr("Valor")
	
	$("#tabConsultaContatos").bootstrapTable({
		url: BASE_URL + "Contato/Listar?idIdoso="+IdIdosoFicha     
	})	
		
	$('#tabConsultaContatos').bootstrapTable('refresh');
	
})