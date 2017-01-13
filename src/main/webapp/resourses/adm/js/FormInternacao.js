$(function(){  		
	
	controlaMotivoSaida()
	
	$('#motivoSaida').on('change', function(e){
		controlaMotivoSaida()
	})
	
	function controlaMotivoSaida(){
		if($('#motivoSaida').val() == 'T'){
			$('#outroMotivo').show()
		}else{
			$('#outroMotivo').hide()
		}		
	}
	
})