$(function(){  		
	
	var idEstoqueMedicamento = $('#idEstoqueMedicamento').val()
	var idApresentacao = $('#idApresentacao').val()
	var idIdoso = $('#idIdoso').val()
	
	$("#tabEstoqueLote").bootstrapTable({
        url: BASE_URL + "EstoqueLote/ListarPorEstoque/"+ idEstoqueMedicamento  
	})	

	$("#tabMovimentacao").bootstrapTable({
        url: BASE_URL + "MovimentacaoEstoque/ListarPorApresentacaoEIdoso/"+ idApresentacao+"/"+idIdoso  
	})		
	
})