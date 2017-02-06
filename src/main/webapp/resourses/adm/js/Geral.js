var BASE_URL = window.location.protocol + '//' + window.location.host + '/';
var paths = window.location.pathname.split("/")
if (paths[1] == 'BlueFisc'){
	BASE_URL = BASE_URL + 'BlueFisc/'
}
if (paths[2] == 'Adm'){
	BASE_URL = BASE_URL + 'Adm/'
}

function calculaIdade(nascimento) {
	var hoje = new Date()	
	
	var array_data = nascimento.split("-") 
	var nascimento = new Date(array_data[0], array_data[1]-1, array_data[2])
	
    var diferencaAnos = hoje.getFullYear() - nascimento.getFullYear();
    if ( new Date(hoje.getFullYear(), hoje.getMonth(), hoje.getDate()) < 
         new Date(hoje.getFullYear(), nascimento.getMonth(), nascimento.getDate()) )
        diferencaAnos--;
    return diferencaAnos;
}

function FormataDecimal(value, row){
	if(value == null){
		return '0,00'
	}

	
	var int = parseInt(value.toFixed(2).toString().replace(/[^\d]+/g, ''));
	var tmp = int + '';
	tmp = tmp.replace(/([0-9]{2})$/g, ",$1");
	if (tmp.length > 6)
	tmp = tmp.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");

	if(value < 0){
		tmp = '-'+tmp
	}	
	
	return tmp;

	
}

function FormataData(Data){
	if(Data == null){
		return Data
	}
	var formattedDate = new Date(Data)
	
	var d = formattedDate.getDate();    
	if(d < 10){    	    
		d = "0"+d
	}
	var m =  formattedDate.getMonth();
	m += 1;  // JavaScript months are 0-11
	if(m < 10){
		m = "0"+m
	}
	var y = formattedDate.getFullYear();
	Data =  d + "/" + m + "/" + y
	return Data
}

function FormataDataMes(Data){
	if(Data == null){
		return Data
	}
	var formattedDate = new Date(Data)
	
	var d = formattedDate.getDate();    
	var m =  formattedDate.getMonth();
	m += 1;  // JavaScript months are 0-11
	if(m < 10){
		m = "0"+m
	}
	var y = formattedDate.getFullYear();
	Data =  m + "/" + y
	return Data
}

function criarDataComFuso(date) {
	
	var fuso = -3
	
	if (date == null){
		data = new Date();
	}else{
		data = new Date(date);
	}
	
	utc = data.getTime() + (data.getTimezoneOffset() * 60000);
	formattedTime = new Date(utc + (3600000*fuso));	
	return formattedTime
}

function FormataHora(Hora){
	if(Hora == null){
		return Hora
	}

	formattedTime = criarDataComFuso(Hora)
	
	var h = formattedTime.getHours()
	if(h < 10){    	    
		h = "0"+h
	}
	var m =  formattedTime.getMinutes();
	if(m < 10){
		m = "0"+m
	}
	Time =  h + ":" + m 
	return Time
}

function FormataBoolean(valor){
	if(valor == null){
		return ''
	}
	if(valor == false){
		return ''
	}	
	if(valor == true){
		return 'X'
	}	
	return valor
}

$(function(){ 
	
	//Máscaras padrões de campos
	$('.mskCpf').mask('999.999.999-99');
	$('.mskCnpj').mask('99.999.999/9999-99');
	$('.mskCep').mask('99999-999');
	$('.mskMoney').mask('000.000.000.000.000,00', {reverse: true});
			
	
	///--------------CODIGO PARA EXCLUSÃO DE REGISTROS --------------------------
	$('table').on('click', '.lnkExcluirRegistro', function(e){
		e.preventDefault()    
		
        var idEntity = $(this).attr('idEntity')
        var nomeEntity = $(this).attr('nameEntity')
        
        if (confirm('Tem certeza que deseja excluir este registro?')){
            $.ajax({
            	url: BASE_URL + nomeEntity+'/Excluir/'+idEntity,
            	dataType : "json",
            	success: function(e) {
            		if (e.seSucesso == '1'){
            			
            			//Gamby
            			if(nomeEntity == 'Postagem'){
            				nomeEntity = 'Postagen'
            			}
            			     
            			$('#tabConsulta'+nomeEntity+'s').bootstrapTable('refresh')
            		}else{
            			alert('Não foi possível excluir o registro selecionado. \n'
    	    			     +'Motivo: '+ e.erroGeral)
            		}
            	}           
            })
        }         		
	})	
	///---------------------------------------------------------------------
	
	//Adiciona a classe responsável por deixar os campos com erros em vermelho
	$('.help-block').each(function(){
		if ($(this).html()!= ''){			
			$(this).parent().addClass('has-error')
		}
	})	
	
	
	 $('input').keypress(function(e){
	    /* 
	     * verifica se o evento é Keycode (para IE e outros browsers)
	     * se não for pega o evento Which (Firefox)
	    */
	   var tecla = (e.keyCode?e.keyCode:e.which);
	   
	   /* verifica se a tecla pressionada foi o ENTER */
	   if(tecla == 13){
	       /* guarda o seletor do campo que foi pressionado Enter */
	       campo =  $('input');
	       /* pega o indice do elemento*/
	       indice = campo.index(this);
	       /*soma mais um ao indice e verifica se não é null
	        *se não for é porque existe outro elemento
	       */
	      if(campo[indice+1] != null){
	         /* adiciona mais 1 no valor do indice */
	         proximo = campo[indice + 1];
	         /* passa o foco para o proximo elemento */
	         proximo.focus();
	      }
	      
	      /* impede o sumbit caso esteja dentro de um form */
	      e.preventDefault(e);
	      return false;	      
	      
	   }

	})	
	
})