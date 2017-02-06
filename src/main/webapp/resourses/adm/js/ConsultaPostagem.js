function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Postagem/Form/'+row.idPostagem+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarPostagem"  aria-hidden="true" idPostagem="'+row.idPostagem+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a href=""><span idEntity="'+row.idPostagem+'" nameEntity="Postagem" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabPostagem").bootstrapTable({
        url: BASE_URL + "Postagem/Listar"  
	})	
	 
	$('#btnAdicionarPostagem').on('click', function(e){
		e.preventDefault()                
		window.location.replace(BASE_URL + "Postagem/Form")	 		
	})	
	
	$('#btnBuscarEstoque').on('click', function(e){
		e.preventDefault()
		
		var idIdoso = $('#idIdoso').val()
		if(!idIdoso > 0){
			idIdoso = 0
		}
		
		var idMedicamento = $('#idMedicamento').val()
		if(!idMedicamento  > 0){
			idMedicamento  = 0
		}
		
		$("#tabEstoque").bootstrapTable('refresh',{url: BASE_URL + "Estoque/ListarPorIdosoEMedicamento/"+idIdoso+"/"+idMedicamento})
	})	
	
})