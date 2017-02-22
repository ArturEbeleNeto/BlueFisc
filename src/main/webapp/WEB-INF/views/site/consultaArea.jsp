	<%@ include file="../../../WEB-INF/views/site/layout/cabecalho.jsp"%>

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="<%=Base_url%>Inicio">Início</a></li>
			<li><a href="<%=Base_url%>AreaCliente">Área do cliente</a></li>
			<li><a href="<%=Base_url%>AreaCliente/Area/${area.idArea}">${area.descricao}</a></li>
		</ol>

		<div class="row">
			
			
			<c:forEach items="${categorias}" var="categoria">
	
				<p class="text" style="font-size: 20px;background-color:;  margin-top: 30px">${categoria.descricao}:</p>
				<div class="list-group">
				
					<c:forEach items="${categoria.postagens}" var="postagem">
						<a href="<%=Base_url%>AreaCliente/Area/${area.idArea}/Postagem/${postagem.idPostagem}" class="list-group-item">
						  	<h4 class="list-group-item-heading">${postagem.titulo}</h4>
						  	<p class="list-group-item-text">${postagem.subTitulo}</p>   
						</a>				
					</c:forEach>
					
				</div>						
			</c:forEach>						
						     

			
			
		

		</div>
	</div>	<!-- /container -->
	

	<%@ include file="../../../WEB-INF/views/site/layout/rodape.jsp"%>