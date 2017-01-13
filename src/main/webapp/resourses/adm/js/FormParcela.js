function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'ItemParcela/Form/'+ row.parcela.idParcela +'/'+row.idItemParcela+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarItemParcela"  aria-hidden="true" idItemParcela="'+row.idItemPArcela+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idItemParcela+'" nameEntity="ItemParcela" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	var idParcela = $('#idParcela').val()
	var idIdoso   = $("#idIdoso").val()
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		if(confirm('Tem certeza que deseja cancelar ?')){
			window.location.replace(BASE_URL + "Parcela/Idoso/" +idIdoso)
		}
	})	
	
	$("#tabConsultaItemParcelas").bootstrapTable({
		url: BASE_URL + "ItemParcela/ListarPorParcela/"+idParcela
	})	
	
	$("#tabConsultaItemParcelas").on('post-body.bs.table', function(e){
		$('#idTotalLinhas').remove()
	})
		
	$('#btnFormItemParcela').on('click', function(e){
		$("#formItemParcela").val("1")
	})
})