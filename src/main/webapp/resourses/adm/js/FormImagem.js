$(function(){  		

	var IdIdosoFicha = $("IdIdosoFicha").attr("Valor")
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		window.location.replace(BASE_URL + "Idoso/DadosPessoais/"+IdIdosoFicha)
	})	
	
})