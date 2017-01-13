function ExibeOpcoes(value, row) {      	
    Texto = ''
    Texto+= '<a href="'+BASE_URL+'ConsultaMedica/Visualizar/'+row.idConsultaMedica+'?idIdoso='+IdIdosoFicha+'"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span></a>  '
    return Texto
}

$(function(){  		
	
	IdIdosoFicha = $("idIdosoFicha").attr("Valor")
	
	$("#tabConsultaConsultaMedica").bootstrapTable({
		url: BASE_URL + "ConsultaMedica/ListarPorIdoso/" + IdIdosoFicha
	});
	
})