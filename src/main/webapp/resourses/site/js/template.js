jQuery(document).ready(function($) {

	$(".headroom").headroom({
		"tolerance": 20,
		"offset": 50,
		"classes": {
			"initial": "animated",
			"pinned": "slideDown",
			"unpinned": "slideUp"
		}
	});
	
	var liActive = $('liActive').attr('val')
	$('.li'+liActive).addClass('active')
	
	$('#tabConsultas').bootstrapTable()
	
	$('.celula').on('click', function(e){
		window.location.replace($(this).attr('href'))
	})
	
	$('.chamaPostagem').on('click', function(e){
		window.location.replace($(this).attr('href'))
	})
});