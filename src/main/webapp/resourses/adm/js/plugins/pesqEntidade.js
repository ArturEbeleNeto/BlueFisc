function buscaEntidade(campo){
	
	var idEntidade = $(campo).val()
	var Entidade = $(campo).attr('nomeEntidade')
	var idPesqEntidade = $(campo).attr('idPesqEntidade')
	
	var campoFiltro = $(campo).attr('idCampoFiltro')
	var filtro = $('#'+campoFiltro).val()
	
	var url = BASE_URL + Entidade + "/get" + Entidade + "/" + idEntidade
	if(filtro > 0){
		url = url + '/' + filtro
	}
	
    $.ajax({
        url : url,
        dataType : "json",
        success : function(data){ 
			        	if(data.id > 0){
			        		$('.descricaoPesqEntidade[idPesqEntidade = "'+idPesqEntidade+'"]').html(data.descricao)
			        		$(this).val(data.id)
			        	}
			        },
		error: function(XMLHttpRequest, textStatus, errorThrown){
					$('.descricaoPesqEntidade[idPesqEntidade = "'+idPesqEntidade+'"]').html('')
		    		$(campo).val('')
    				alert('Registro não encontrado')
    				$(campo).focus()
    			} 
    });				
}


$(function(){ 
	
	var focusField	
    var $table = $('#tablePesqEntidade');
	
	
	
    $('#modalTablePesqEntidade').on('shown.bs.modal', function () {
    	
    	campoFiltro = $(focusField).attr('idCampoFiltro')
    	filtro = $('#'+campoFiltro).val()
    	url = BASE_URL + $(focusField).attr('nomeEntidade') + '/Listar'
    	if(filtro > 0){
    		url = url + '/' + filtro
    	}    	
    	
    	$table.bootstrapTable('refresh', {url: url}, 'resetView');
    });

    $('#modalTablePesqEntidade').on('dbl-click-row.bs.table', function (row, $element) {
    	$('.descricaoPesqEntidade[idPesqEntidade = "'+$(focusField).attr('idPesqEntidade')+'"]').html($element.descricao)
    	$(focusField).val($element.id)
        $("#btnFechaModal").trigger('click');
    	$(focusField).trigger('change');
    });
        
    //F8 - 119
    $('.idPesqEntidade').bind('keyup',function(e){  
    	$table.bootstrapTable('destroy')
    	if (e.which == 119){    		
    		focusField = $(this)
    		$table.bootstrapTable()
    		$("#btnChamaModal").trigger('click');
    	}
    });
        
    $('.idPesqEntidade').on('blur',function(e){
    	if($(this).val() != ''){
    		buscaEntidade(this)
    	}else{
    		$('.descricaoPesqEntidade[idPesqEntidade = "'+$(this).attr('idPesqEntidade')+'"]').html('')
    	}
    })	
    
    $('.idPesqEntidade').trigger('blur')
	
})