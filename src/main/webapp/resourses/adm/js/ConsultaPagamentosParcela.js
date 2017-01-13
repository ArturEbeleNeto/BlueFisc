function ExibeOpcoes(value, row) {
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Pagamento/Form/'+ row.parcela.idParcela +'/'+row.idPagamento+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarPagamento"  aria-hidden="true" idPagamento="'+row.idPagamento+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a href="'+BASE_URL+'Pagamento/Excluir/'+row.idPagamento+'"><span class="glyphicon glyphicon-remove link-Excluir" id="lnkExcluirPagamento" aria-hidden="true" idPagamento="'+row.idPagamento+'"></span></a>' 
    return Texto
}

$(function(){  		
	
	idParcela = $('#idParcela').val()
	
	$('#btnFormPagamentoParcela').on('click', function(e){
		window.location.replace(BASE_URL + "Pagamento/Form/"+idParcela)
	})	
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		window.location.replace(BASE_URL + "Parcela/Consulta")
	})	
	
	$("#tabConsultaPagamentosParcela").bootstrapTable({
		url: BASE_URL + "Pagamento/ListarPorParcela/"+idParcela
	})	

	$("#tabConsultaPagamentosParcela").on('post-body.bs.table', function(e){
		$('#idTotalLinhas').remove()
	})

})