$(function(){  		
	
	var IdIdosoFicha = $("IdIdosoFicha").attr("Valor")
	var IdParcela = $("#idParcela").val()   
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		window.location.replace(BASE_URL + "Parcela/Form/"+IdIdosoFicha+"/" + IdParcela)
	})	

	$('#tipoCobranca').on('change',function(e){
		controlaRowDatas()
	})
	
	controlaRowDatas()
	
	function controlaRowDatas(){
		if($('#tipoCobranca').val() == 'PERIODICA'){
			$('#rowDatas').show()
		}else{
			$('#rowDatas').hide()
		}
	}
	
	$('#idProduto').on('change', function(){
		buscaPrecoPadrao()
	})
	
	function buscaPrecoPadrao(){

		$('#valorUnitario').val(0)			
	
		var idProduto = $('#idProduto').val()
		
		var url = BASE_URL + "Produto/getProduto/" + idProduto
		
		if (idProduto > 0){	
		    $.ajax({
		        url : url,
		        dataType : "json",
		        success : function(data){
		        	if(data.id > 0){
		        		$('#valorUnitario').val(data.valorPadrao)
		        	}else{
						$('#valorUnitario').val(0)						        		
		        	}
		        },
				error: function(XMLHttpRequest, textStatus, errorThrown){
					alert('Erro buscando o preço unitário do produto. Por favor, digite-o manualmente.')
					$('#valorUnitario').val(0)	
		    	} 			        
		    });
		}		
	}
		
})