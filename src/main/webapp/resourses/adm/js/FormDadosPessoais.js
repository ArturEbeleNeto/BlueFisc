$(function(){  		
		
	$('#txtDataNascimento').on('blur', function(e){
		$('#txtIdade').val(calculaIdade($(this).val()))
	})
	
})