$(function(){  		

	  $("#ulSubMedicamentos").on("hide.bs.collapse", function(){		
		    $("#liMedicamentos > a > span").removeClass('glyphicon-collapse-down').addClass('glyphicon-collapse-up')
	  });
		
	  $("#ulSubMedicamentos").on("show.bs.collapse", function(){
		    $("#liMedicamentos > a >span").removeClass('glyphicon-collapse-up').addClass('glyphicon-collapse-down')
	  });	

	  $("#ulSubEvolucoes").on("hide.bs.collapse", function(){		
		    $("#liEvolucoes > a > span").removeClass('glyphicon-collapse-down').addClass('glyphicon-collapse-up')
	  });
		
	  $("#ulSubEvolucoes").on("show.bs.collapse", function(){
		    $("#liEvolucoes > a >span").removeClass('glyphicon-collapse-up').addClass('glyphicon-collapse-down')
	  });		  
	  	  
	  var itemMenu = $("itemMenu").attr("item")
	  $("#li"+itemMenu).addClass('active')
	  
	  
	  $('.placeholder img').on('click', function(e){
			e.preventDefault()			 
			var idIdoso = $("IdIdosoFicha").attr("Valor")
			if (idIdoso > 0){  
				window.location.replace(BASE_URL + 'Idoso/Imagem/'+idIdoso)
			}
	  })
	  
})