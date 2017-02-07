$(function(){  		
	
	var idPlano = $('#idPlano').val()
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		if(confirm('Tem certeza que deseja cancelar ?')){
			window.location.replace(BASE_URL + "Plano/Form/" + idPlano)
		}
	})
		
})