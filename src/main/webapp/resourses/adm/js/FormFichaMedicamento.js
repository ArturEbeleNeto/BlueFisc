function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'ItemFichaMedicamento/Form/'+ row.fichaMedicamento.idFichaMedicamento +'/'+row.idItemFichaMedicamento+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarItemFichaMedicamento"  aria-hidden="true" idItemFichaMedicamento="'+row.idItemFichaMedicamento +'"></span></a>'
    Texto+= ' '  
    Texto+= '<a href="'+BASE_URL+'ItemFichaMedicamento/Excluir/'+row.idItemFichaMedicamento+'"><span class="glyphicon glyphicon-remove link-Excluir" id="lnkExcluirItemFichaMedicamento" aria-hidden="true" idItemFichaMedicamento="'+row.idItemFichaMedicamento+'"></span></a>' 
    return Texto
}

$(function(){  		
	
	var idFichaMedicamento = $('#idFichaMedicamento').val()
	var IdIdosoFicha = $("IdIdosoFicha").attr("Valor")
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		if(confirm('Tem certeza que deseja cancelar a criação da nova ficha?')){
			window.location.replace(BASE_URL + "FichaMedicamento/"+IdIdosoFicha )
		}			
	})
	
	$('#btnFormItemFichaMedicamento').on('click', function(e){
		$("#formItemFichaMedicamento").val("1")
	})

	
	$("#tabConsultaItensFichaMedicamento").bootstrapTable({
		url: BASE_URL + "ItemFichaMedicamento/Listar/" + idFichaMedicamento
	})	
			
	
	$("#tabConsultaItensFichaMedicamento").on('post-body.bs.table', function(e){
		$('#idTotalLinhas').remove()
	})
	
	$('#dataAbertura').on('blur', function(e){
		var array_data = $(this).val().split("-") 
		var dataAbertura = new Date(array_data[0], array_data[1]-1, array_data[2])
		$('#dataVencimento').val(dataAbertura.addMonths(6).toString('yyyy-MM-dd'))
	})
		
})