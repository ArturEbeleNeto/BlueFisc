$(function(){  		
	
	$("#tabProblemasAdministracao").bootstrapTable({
        clickToSelect: true,
        selectItemName:"lista",
        idField: "idAdministracao",
        url: BASE_URL + "ProblemaAdministracao/Listar"  
	})	
	 
})