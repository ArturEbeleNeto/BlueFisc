<%@ include file="../../../WEB-INF/views/adm/layout/Cabecalho.jsp"%>

<%@ include file="../../../WEB-INF/views/adm/layout/Rodape.jsp"%>
<!-- Teste git -->

<script type="text/javascript">
	$('.celula').on('click', function(e){
		window.open($(this).attr('href'))
	})
</script>
