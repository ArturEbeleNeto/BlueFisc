function ExibeOpcoesCategoriaPostagem(value, row) {       
    Texto = ''
    Texto+= '<a><span idEntity="'+row.idArea+'" nameEntity="Plano" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

var idPlano

$(function(){  		
	
	idPlano = $('#idPlano').val()
	
	//Indica para o controller que não é para salvar e abrir o form de caastro do sub item
	$('.btnSubForm').on('click', function(e){
		$("#goSubForm").val("1")
	})
	
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		if(confirm('Tem certeza que deseja cancelar ?')){
			window.location.replace(BASE_URL + "Plano/Consulta")
		}
	})
	
	
	if(idPlano > 0){
		$("#tabConsultaAreaPlanos").bootstrapTable({
	        selectItemName:"area",
	        idField: "idArea",
			url: BASE_URL + "AreaPlano/ListarPorPlano/" + idPlano		
		})	
	}else{
		$("#tabConsultaAreaPlanos").bootstrapTable()		 	
	}
			
	
	$(".table").on('post-body.bs.table', function(e){
		$('.TotalLinhas').remove()
	})
	
	
})