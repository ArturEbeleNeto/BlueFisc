function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Apresentacao/Form/'+row.medicamento.idMedicamento +'/'+row.idApresentacao+'"><span class="glyphicon glyphicon-pencil"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idApresentacao+'" nameEntity="Apresentacao" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	var idMedicamento = $('#idMedicamento').val()
	
	$('#btnFormApresentacao').on('click', function(e){
		$("#formApresentacao").val("1")
	})
	
	$('#btnCancelarAlteracoes').on('click', function(e){
		e.preventDefault()
		if(confirm('Tem certeza que deseja cancelar ?')){
			window.location.replace(BASE_URL + "Medicamento/Cancelar/" + idMedicamento)
		}
	})
	
	if(idMedicamento > 0){
		$("#tabConsultaApresentacoes").bootstrapTable({		
			url: BASE_URL + "Apresentacao/Listar/" + idMedicamento		
		})	
	}else{
		$("#tabConsultaApresentacoes").bootstrapTable()		
	}
			
	
	$("#tabConsultaApresentacoes").on('post-body.bs.table', function(e){
		$('#idTotalLinhas').remove()
	})
	
	
})