$(function(){  		
	

	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		if(confirm('Tem certeza que deseja cancelar ?')){
			window.location.replace(BASE_URL + "Postagem/Consulta")
		}
	})
	
	$('#btnSalvarForm').on('click', function(e){
		$('#formPostagem').submit()
	})
	
})