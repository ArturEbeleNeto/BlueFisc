function ExibeOpcoes(value, row) {       
    Texto = ''
    Texto = '<a href="'+BASE_URL+'Produto/Form/'+row.idProduto+'"><span class="glyphicon glyphicon-pencil link-Editar"  id="lnkEditarProduto"  aria-hidden="true" idProduto="'+row.idProduto+'"></span></a>'
    Texto+= ' '  
    Texto+= '<a href=""><span idEntity="'+row.idProduto+'" nameEntity="Produto" class="lnkExcluirRegistro glyphicon glyphicon-remove"></span></a>' 
    return Texto
}

$(function(){  		
	
	$("#tabConsultaProdutos").bootstrapTable({
		url: BASE_URL + "Produto/Listar"     
	})	
	
})