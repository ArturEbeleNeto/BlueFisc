$(function(){  		
		
	$('#txtDataNascimento').on('blur', function(e){
		$('#txtIdade').val(calculaIdade($(this).val()))
	})
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		if(confirm('Tem certeza que deseja cancelar ?')){
			window.location.replace(BASE_URL + "Cliente/Consulta")
		}
	})	
	
})