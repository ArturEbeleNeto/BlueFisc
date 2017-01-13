$(function(){  		
	
	IdIdosoFicha = $("IdIdosoFicha").attr("Valor")
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		if(confirm('Tem certeza que deseja cancelar ?')){
			window.location.replace(BASE_URL + "ConsultaMedica/Consulta/" +IdIdosoFicha)
		}
	})
	
	
	
	
	$('#idMedico').on('change', function(){
		buscaEspecialidade()
	})
	
	function buscaEspecialidade(){
		$('#tipo').val('')			
	
		var idMedico = $('#idMedico').val()
		var url = BASE_URL + "Medico/getMedico/" + idMedico
		
		if (idMedico > 0){
		    $.ajax({
		        url : url,
		        dataType : "json",
		        success : function(data){ 
					        	if(data.idMedico > 0){
					        		$('#tipo').val(data.especialidadeMedica)
					        		//$('#tipo').attr('disabled', 'disabled')
					        	}else{
									$('#tipo').val('')						        		
					        	}
					        },
				error: function(XMLHttpRequest, textStatus, errorThrown){
					$('#tipo').val('')	
		    	}
					        
		    });
		}		
	}

})