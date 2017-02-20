function ExibeOpcoes(value, row) {      	
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Cliente/Form/'+row.idCliente+'"><span class="glyphicon glyphicon-pencil"></span></a>'
    Texto+= ' '  
    Texto+= '<a><span idEntity="'+row.idCliente+'" nameEntity="Cliente" callBack="buscaDados()" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

function buscaDados(){
	
    $('#frmConsultaClientes').ajaxForm({ 
            dataType: "json",

            success: function(responseText, statusText, xhr, $form){
            	$("#tabConsultaClientes").bootstrapTable('destroy')
            	$("#tabConsultaClientes").bootstrapTable({
            		data: responseText
            	})
            },
            error: function(request, status, error) {
                alert('erro: '+ error);
            }            
    }).submit()
}

$(function(){  		

	buscaDados()

	$('#txtSituacao').on('change', function(e){
		buscaDados()
	})
	
})