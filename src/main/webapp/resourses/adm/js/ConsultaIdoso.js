function ExibeOpcoes(value, row) {      	
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Idoso/DadosPessoais/'+row.idIdoso+'"><span class="glyphicon glyphicon-pencil"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idIdoso+'" nameEntity="Idoso" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		

	buscaDados()
	
	function buscaDados(){
        $('#frmConsultaIdosos').ajaxForm({ 
                dataType: "json",

                success: function(responseText, statusText, xhr, $form){
                	$("#tabConsultaIdosos").bootstrapTable('destroy')
                	$("#tabConsultaIdosos").bootstrapTable({
                		data: responseText
                	})
                },
                error: function(request, status, error) {
                    alert('erro: '+ error);
                }            
        }).submit()
	}

	$('#txtSituacao').on('change', function(e){
		buscaDados()
	})
	
})