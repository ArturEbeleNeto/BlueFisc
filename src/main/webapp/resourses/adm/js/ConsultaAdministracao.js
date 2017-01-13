function rowStyle(row, index) {
	
	dataAtual = new Date()
	dataAdministracao = new Date(row.dataPrevista)
	horarioAdministracao = criarDataComFuso(row.itemFichaMedicamento.horario)
	
	if(dataAdministracao.getFullYear() < dataAtual.getFullYear()){
		return {classes: 'danger'}
	}
	if(dataAdministracao.getMonth() < dataAtual.getMonth()){
		return {classes: 'danger'}
	}
	
	if(dataAdministracao.getDate() < dataAtual.getDate()){
		return {classes: 'danger'}
	}
	
	if(dataAdministracao.getDate() == dataAtual.getDate()){ 
		if(horarioAdministracao.getHours() < dataAtual.getHours()){
			return {classes: 'warning'}
		}
		if(horarioAdministracao.getHours() == dataAtual.getHours()){
			if(horarioAdministracao.getMinutes() < dataAtual.getMinutes()){
				return {classes: 'warning'}
			}
		}
	}
			
	return {}
	
}

$(function(){  		
	
	$("#tabAdministracaoMedicamentos").bootstrapTable({
        clickToSelect: true,
        selectItemName:"lista",
        idField: "idAdministracao",
        url: BASE_URL + "Administracao/ListarPendentes"  
	})	
	
	$('#btnFiltrarAdministracao').on('click',function(e){
		
		e.preventDefault()
		
		var data = $('#DataFiltro').val()
		if (!data > 0){
			data = 0
		}
		var horarioInicial = $('#HorarioInicialFiltro').val()
		if(!horarioInicial > 0){
			horarioInicial = 0
		}
		var horarioFinal = $('#HorarioFinalFiltro').val()
		if(!horarioFinal > 0){
			horarioFinal = 0
		}
		
		var url = BASE_URL + "Administracao/FiltrarAdministracoes/"+data+"/"+horarioInicial+"/"+horarioFinal
		
		$("#tabAdministracaoMedicamentos").bootstrapTable('refresh',{url: url})			
	})
	 
	$('#btnBaixarMedicamentos').on('click', function(e){
		
		if(!confirm('Tem certeza que deseja realizar a administração dos medicamentos selecionados ?')){
			e.preventDefault()
		}		
	})
})