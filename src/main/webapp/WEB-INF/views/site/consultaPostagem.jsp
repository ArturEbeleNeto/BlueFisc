	<%@ include file="../../../WEB-INF/views/site/layout/cabecalho.jsp"%>

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="<%=Base_url%>Inicio">Início</a></li>
			<li><a href="<%=Base_url%>AreaCliente">Área do cliente</a></li>
			<li><a href="<%=Base_url%>AreaCliente/Area/${postagem.area.idArea}">${postagem.area.descricao}</a></li>
			<li><a href="<%=Base_url%>AreaCliente/Area/${postagem.area.idArea}/Postagem/${postagem.idPostagem}">${postagem.titulo}</a></li>
		</ol>

		<div class="bs-docs-section">
			
			<h1 class="page-header">${postagem.titulo}</h1> 
			
			<p class="lead">${postagem.subTitulo}</p>
			
			${postagem.textoFormatado}

		</div>
		
	</div>	<!-- /container -->
	

	<%@ include file="../../../WEB-INF/views/site/layout/rodape.jsp"%>