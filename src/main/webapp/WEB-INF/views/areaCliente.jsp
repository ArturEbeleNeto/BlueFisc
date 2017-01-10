	<%@ include file="../../WEB-INF/views/layout/cabecalho.jsp"%>

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="<%=Base_url%>Inicio">Início</a></li>
			<li><a href="<%=Base_url%>AreaCliente">Área do cliente</a></li>
			<liActive val="AreaCliente"></liActive>
		</ol>

		<div class="row">
			
			
<p class="text" style="font-size: 20px;background-color:;  margin-top: 60px">Categorias:</p>

<div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12" >
	
		<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Idoso/Consulta">
			<span class="glyphicon glyphicon-search" aria-hidden=true></span>
			<span class=glyphicon-class>Consultar Idosos</span>
		</div>	
	
		<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Idoso/DadosPessoais">
			<span class="glyphicon glyphicon-plus" aria-hidden=true></span>
			<span class=glyphicon-class>Cadastrar Idoso</span>
		</div>
		
		<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12"  href="<%=Base_url%>Medicamento/Consulta">
			<span class="glyphicon glyphicon-search" aria-hidden=true></span>
			<span class=glyphicon-class>Consultar Medicamentos</span>
		</div>
			
		<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Medicamento/Form">
			<span class="glyphicon glyphicon-plus" aria-hidden=true></span>
			<span class=glyphicon-class>Cadastrar Medicamento</span>
		</div>
			
		<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Estoque/Consulta">
			<span class="glyphicon glyphicon-search" aria-hidden=true></span>
			<span class=glyphicon-class>Consultar Estoque</span>
		</div>
		
		<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Estoque/MovimentarEstoque">
			<span class="glyphicon glyphicon-sort" aria-hidden=true></span>
			<span class=glyphicon-class>Movimentação de estoque</span>
		</div>
		
	 	<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Administracao/Consulta">
	 		<span class="glyphicon glyphicon-check" aria-hidden=true></span> 
			<span class=glyphicon-class>Administrar Medicamentos</span>
		</div>
		
		<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Administracao/Programar">  
			<span class="glyphicon glyphicon-calendar" aria-hidden=true></span>
			<span class=glyphicon-class>Programar Administrações</span>
		</div>
			
		<c:if test="${tipoUsuario == 'ADMINISTRADOR'}">
			<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Parcela/Consulta">
				<span class="glyphicon glyphicon-search" aria-hidden=true></span>
				<span class=glyphicon-class>Consultar Parcelas</span>
			</div>
			
			<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Parcela/Gerar">
				<span class="glyphicon glyphicon-usd" aria-hidden=true></span>
				<span class=glyphicon-class>Gerar Parcelas</span>
			</div>
		</c:if>
		
		<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Usuario/AlterarSenha">
			<span class="glyphicon glyphicon-refresh" aria-hidden=true></span>
			<span class=glyphicon-class>Alterar Senha</span>
		</div>
		
		<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>Enfermeiro/Consulta">
			<span class="glyphicon glyphicon-search" aria-hidden=true></span>
			<span class=glyphicon-class>Consultar Enfermeiras</span>
		</div>						
			     
	</div>
</div>
			
			

		</div>
	</div>	<!-- /container -->
	

	<%@ include file="../../WEB-INF/views/layout/rodape.jsp"%>