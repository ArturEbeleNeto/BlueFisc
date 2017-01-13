function ExibeOpcoes(value, row) {   
    Texto = ''
    Texto += '<a href="'+BASE_URL+'Parcela/Form/'+row.idoso.idIdoso+'/'+row.idParcela+'"><span class="glyphicon glyphicon-list-alt link-Editar"  id="lnkEditarParcela"  aria-hidden="true" idParcela="'+row.idParcela+'"></span></a>'
    Texto += ' '  
    	
    if(row.situacao == "FORMACAO"){
    	Texto+= '<a><span idEntity="'+row.idParcela+'" nameEntity="Parcela" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>'
        Texto += ' '    	
    }
    	
    return Texto
}


$(function(){  		
	
	IdIdosoFicha = $("IdIdosoFicha").attr("Valor")
	url = BASE_URL + 'Parcela/ListarPorIdoso/' + IdIdosoFicha
	$("#tabConsultaParcelas").bootstrapTable({
		url: url
	})

})