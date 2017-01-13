$(function(){  		
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		
		url = BASE_URL + "Instituicao/Form"
		if(confirm('Tem certeza que deseja cancelar ?')){
			window.location.replace(url)
		}			
	})
	
	function aplicaMascaraTelefone(elemento){
	   if($(elemento).val().length == 15){ // Celular com 9 dígitos + 2 dígitos DDD e 4 da máscara
	      $(elemento).mask('(00) 00000-0009');
	   } else {
	      $(elemento).mask('(00) 0000-00009');
	   }
	}
	
	elemento = $('#txtTelefone') 
	aplicaMascaraTelefone(elemento)
	$('#txtTelefone').blur(function(event) {
		aplicaMascaraTelefone($('#txtTelefone'))
	});
	
	elemento = $('#txtCelular') 
	aplicaMascaraTelefone(elemento)
	$('#txtCelular').blur(function(event) {
		aplicaMascaraTelefone($('#txtCelular'))
	});	
	
})