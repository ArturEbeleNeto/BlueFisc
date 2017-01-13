$(function(){  		
	
	$('.help-block').each(function(){
		if ($(this).html()!= ''){
			$(this).parent().addClass('has-error')
		}
	})
			
})