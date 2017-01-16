function ExibeOpcoesCategoriaPostagem(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Adm/CategoriaPostagem/Form/'+row.idArea +'/'+row.idCategoriaPostagem+'"><span class="glyphicon glyphicon-pencil"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idCategoriaPostagem+'" nameEntity="CategoriaPostagem" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	var idArea = $('#idArea').val()
	
	//Indica para o controller que não é para salvar e abrir o form de caastro do sub item
	$('.btnSubForm').on('click', function(e){
		$("#goSubForm").val("1")
	})
	
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		if(confirm('Tem certeza que deseja cancelar pooora ?')){
			window.location.replace(BASE_URL + "Area/Consulta")
		}
	})
	
	
	if(idArea > 0){
		$("#tabConsultaCategoriaPostagens").bootstrapTable({		
			url: BASE_URL + "CategoriaPostagem/Listar/" + idArea		
		})	
		$("#tabConsultaAplicativos").bootstrapTable({		
			url: BASE_URL + "CategoriaPostagem/Listar/" + idArea		
		})			
	}else{
		$("#tabConsultaCategoriaPostagens").bootstrapTable()		 
		$("#tabConsultaAplicativos").bootstrapTable()	
	}
			
	
	$(".table").on('post-body.bs.table', function(e){
		$('.TotalLinhas').remove()
	})
	
	
})