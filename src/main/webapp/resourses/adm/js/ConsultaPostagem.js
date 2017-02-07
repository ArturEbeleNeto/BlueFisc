function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Postagem/Form/'+row.idPostagem+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarPostagem"  aria-hidden="true" idPostagem="'+row.idPostagem+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a href=""><span idEntity="'+row.idPostagem+'" nameEntity="Postagem" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaPostagens").bootstrapTable({
        url: BASE_URL + "Postagem/Listar"  
	})	
	 
	$('#btnAdicionarPostagem').on('click', function(e){
		e.preventDefault()                
		window.location.replace(BASE_URL + "Postagem/Form")	 		
	})	
	
	$('#btnBuscarPostagens').on('click', function(e){
		e.preventDefault()
		
		var idArea = $('#idArea').val()
		if(!idArea > 0){
			idArea = 0
		}
		
		var idCategoria = $('#idCategoria').val()
		if(!idCategoria  > 0){
			idCategoria  = 0
		}
		
		$("#tabConsultaPostagens").bootstrapTable('refresh',{url: BASE_URL + "Postagem/ListarPorAreaECategoria/"+idArea+"/"+idCategoria})
	})	
	
})