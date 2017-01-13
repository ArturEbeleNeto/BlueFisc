$(function(){  		

	var idMedicamento = $('#idMedicamento').val()
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		window.location.replace(BASE_URL + "Medicamento/Form/" +idMedicamento)		
	})
   
    
})