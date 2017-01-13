$(function(){  		

	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		window.location.replace(BASE_URL + "Estoque/Consulta")
	})

	idMedicamento = $('#idMedicamento').val()
	
	idApresentacao = $('#idApresentacao').val()	
	
	if(!idMedicamento > 0){ 
		$('#idApresentacao').attr( "disabled", true )
	}	
	
	$('#idMedicamento').on('change', function(){
		idMedicamento = $('#idMedicamento').val()

			$('#idApresentacao').val('')
			$('span[nomeEntidade="Apresentacao"]').html('')
			$('#unidadeMedida').html('')
			$('#unidadeMedida').val('')
		
		if(idMedicamento > 0){			
			$('#idApresentacao').attr( "disabled", false)
			$('#idApresentacao').focus()
		}else{
			$('#idApresentacao').attr( "disabled", true )
			$('#quantidade').focus()
		}		
	})	
	
	$('#idApresentacao').on('change', function(){
		buscaUnidadeMedidas()
	})
	
	function buscaUnidadeMedidas(){
		$('#unidadeMedida').html('')
		$('#unidadeMedida').val('')			
	
		var idApresentacao = $('#idApresentacao').val()
		var idMedicamento = $('#idMedicamento').val()
		var url = BASE_URL + "Apresentacao/getApresentacao/" + idApresentacao + "/" + idMedicamento
		
		if (idApresentacao > 0){
		    $.ajax({
		        url : url,
		        dataType : "json",
		        success : function(data){ 
					        	if(data.id > 0){
					        		$('#unidadeMedida').html('<option value="'+ data.unidadeMedidaEstoque.idUnidadeMedida +'">'+ data.unidadeMedidaEstoque.descricao +'</option>')
					        		if (data.unidadeMedidaEstoque.idUnidadeMedida != data.unidadeMedidaAdministracao.idUnidadeMedida){
					        			$('#unidadeMedida').append('<option value="'+ data.unidadeMedidaAdministracao.idUnidadeMedida +'">'+ data.unidadeMedidaAdministracao.descricao +'</option>')
					        		}
					        	}else{
									$('#unidadeMedida').html('')
									$('#unidadeMedida').val('')						        		
					        	}
					        },
				error: function(XMLHttpRequest, textStatus, errorThrown){
					$('#unidadeMedida').html('')
					$('#unidadeMedida').val('')	
		    			} 			        
		    });
		}		
	}
	
	
	buscaUnidadeMedidas()
})