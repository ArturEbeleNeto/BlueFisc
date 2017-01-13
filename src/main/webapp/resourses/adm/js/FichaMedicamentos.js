
$(function(){
    
	IdIdosoFicha = $("IdIdosoFicha").attr("Valor")
	
    $('#tabFichaMedicamento').bootstrapTable({
        url: BASE_URL + "FichaMedicamento/Listar/" + IdIdosoFicha                
    }).on('click-row.bs.table', function(e, row, $element){
    		var index = $($element).attr('data-index')    
	        $('.info').removeClass('info')
            $($element).addClass('info')  
            AtualizaItensFichaMedicamento()
    }).on('load-error.bs.table', function(e,row, $element){
        $('#tabFichaMedicamento').bootstrapTable('hideLoading')
    })
    AtualizaFichaMedicamento()
    
    

    function BuscaLinhaSelecionada(){ 
		var Dados = $('#tabFichaMedicamento').bootstrapTable('getData')
		if(Dados.length){
			var index = $('#tabFichaMedicamento tr[class="info"]').attr('data-index')		
			return Dados[index]
		}else{
			return null
		}
    }
    function BuscaIdFichaMedicamento(){ 
		return BuscaLinhaSelecionada().idFichaMedicamento
    }
    
	
    function AtualizaFichaMedicamento(){
        $('#tabFichaMedicamento').bootstrapTable('destroy')
        $('#tabFichaMedicamento').bootstrapTable({ 
        	url: BASE_URL + "FichaMedicamento/Listar/" + IdIdosoFicha  
        }).on('post-body.bs.table', function(e){
	        $('.info').removeClass('info')
	        $('#tabFichaMedicamento tr[data-index=0]').addClass('info')            
           AtualizaItensFichaMedicamento()
            
            
            //Habilita ou desabilita o botão duplicar ficha atual
        	$('#btnDuplicarFichaAtual').attr('disabled', 'disabled')
        	var Dados = $('#tabFichaMedicamento').bootstrapTable('getData')
        	for(x = 0; x < Dados.length; x++){        		
        		var linha = Dados[x]
        		if(linha.situacao == 'ATUAL'){
        			$('#btnDuplicarFichaAtual').removeAttr('disabled')
        			break
        		}        		
        	}
	        //------------------------------------------
            
    	})         
    }
    
    function AtualizaItensFichaMedicamento(){
    	
    	var LinhaSel = BuscaLinhaSelecionada() 
    	if(LinhaSel != null){
    		ControlaBotoes(LinhaSel.situacao)
	    		
	        $('#tabItensFichaMedicamento').bootstrapTable('destroy')
	        $('#tabItensFichaMedicamento').bootstrapTable({
	        	url: BASE_URL + 'ItemFichaMedicamento/Listar/'+ LinhaSel.idFichaMedicamento
	        })    		    	
    	}else{
    		ControlaBotoes(null)
    	}
    	

    }
    
    function ControlaBotoes(situacao){
    	
    	switch (situacao) {
		case 'ATUAL':
			$('#btnEncerrarFicha').removeAttr('disabled')
			$('#btnEditarFicha').removeAttr('disabled')
			break;
			
		default:
			$('#btnEncerrarFicha').attr('disabled', 'disabled')			
			$('#btnEditarFicha').attr('disabled', 'disabled')
			break;
		}    		    	
    	
    }
    
    
    $('#btnCriarNovaFicha').on('click', function(e){
		e.preventDefault()                
		window.location.replace(BASE_URL + "FichaMedicamento/Form/" + IdIdosoFicha)	    	
    })
    
    $('#btnDuplicarFichaAtual').on('click', function(e){
		e.preventDefault()                
		window.location.replace(BASE_URL + "FichaMedicamento/Duplicar/" + IdIdosoFicha)	    	
    })    
    
    $('#btnEncerrarFicha').on('click', function(e){
		e.preventDefault()                
		window.location.replace(BASE_URL + "FichaMedicamento/Encerrar/" + BuscaIdFichaMedicamento())	    	
    })

    $('#btnEditarFicha').on('click', function(e){
		e.preventDefault()
		window.location.replace(BASE_URL + "FichaMedicamento/Form/" + IdIdosoFicha + "/" + BuscaIdFichaMedicamento())	    	
    })
    
})