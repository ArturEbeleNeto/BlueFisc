function ExibeOpcoes(value, row) {
    Texto = ''  
    Texto += '<a href="'+BASE_URL+'Pagamento/Form/'+row.idParcela+'" target="_blank"><span class="glyphicon glyphicon-usd" aria-hidden="true" idParcela="'+row.idParcela+'"></span></a>'
    Texto += ' '
    Texto += '<a href="'+BASE_URL+'Pagamento/Parcela/'+row.idParcela+'" target="_blank"><span class="glyphicon glyphicon-th-list" aria-hidden="true" idParcela="'+row.idParcela+'"></span></a>'       
    Texto += ' '
    Texto += '<a href="'+BASE_URL+'Parcela/Form/'+row.idoso.idIdoso+'/'+row.idParcela+'" target="_blank"><span class="glyphicon glyphicon-search" aria-hidden="true" idParcela="'+row.idParcela+'"></span></a>'	
    return Texto
}

$(function(){  	

	buscaDados()
	
	function buscaDados(){
		
        $('#frmConsultaParcelas').ajaxForm({ 
                dataType: "json",

                success: function(responseText, statusText, xhr, $form){
                	$("#tabConsultaParcelas").bootstrapTable('destroy')
                	$("#tabConsultaParcelas").bootstrapTable({
                		data: responseText
                	})
                },
                error: function(request, status, error) {
                    alert('erro: '+ error);
                }            
        }).submit()
        
	}
	
	$('#btnFiltrarParcelas').on('click',function(e){	
		e.preventDefault()
		buscaDados()
	})
	 
})