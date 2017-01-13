$(function(){  		

	idMedicamento = $('#idMedicamento').val()
	
	idApresentacao = $('#idApresentacao').val()
	
	if(!idMedicamento > 0){
		$('#idApresentacao').attr( "disabled", true )
	}
	
	$('#idMedicamento').on('change', function(){
		idMedicamento = $('#idMedicamento').val()
		if(idMedicamento > 0){			
			$('#idApresentacao').val('')
			$('span[nomeEntidade="Apresentacao"]').html('')
			$('#idApresentacao').attr( "disabled", false)
			$('#idApresentacao').focus()
		}else{
			$('#idApresentacao').val('')
			$('span[nomeEntidade="Apresentacao"]').html('')			
			$('#idApresentacao').attr( "disabled", true )
			$('#quantidade').focus()
		}		
	})	
	
	var idFichaMedicamento = $('#idFichaMedicamento').val()
	var IdIdosoFicha = $("IdIdosoFicha").attr("Valor")
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		window.location.replace(BASE_URL + "FichaMedicamento/Form/"+IdIdosoFicha+"/" +idFichaMedicamento)
	})	
	
	
	
	$('#btnMarcarTodos').on('click', function(e){
	    $('.chkDiaSemana').each(function () {
	        this.checked = true;
	    });
	})
	
	$('#btnDesmarcarTodos').on('click', function(e){
	    $('.chkDiaSemana').each(function () {
	        this.checked = false;
	    });
	})	
})