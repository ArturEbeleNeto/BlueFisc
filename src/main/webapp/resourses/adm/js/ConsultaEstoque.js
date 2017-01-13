function ExibeOpcoes(value, row) {       
    Texto = ''	
    Texto+= '<a href="'+BASE_URL+'Estoque/DetalheEstoque/'+row.idEstoqueMedicamento+'"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span></a>  '
	//Texto+= '<a><span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></a>  '
	//Texto+= '<a><span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span></a>'
    return Texto
}

$(function(){  		
	
	$("#tabEstoque").bootstrapTable({
        clickToSelect: true,
        selectItemName:"lista",
        idField: "idEstoqueMedicamento",
        url: BASE_URL + "Estoque/Listar"  
	})	
	 
	$('#btnMovimentarEstoque').on('click', function(e){
		e.preventDefault()                
		window.location.replace(BASE_URL + "Estoque/MovimentarEstoque")	 		
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