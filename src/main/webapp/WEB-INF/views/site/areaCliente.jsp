	<%@ include file="../../../WEB-INF/views/site/layout/cabecalho.jsp"%>

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="<%=Base_url%>Inicio">Início</a></li>
			<li><a href="<%=Base_url%>AreaCliente">Área do cliente</a></li>
			<liActive val="AreaCliente"></liActive>
		</ol>

		<div class="row">
			
			
<p class="text" style="font-size: 20px;background-color:;  margin-top: 30px">Áreas:</p>

<div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12" >
	
		<c:forEach items="${areas}" var="area">
		
			<div class="celula col-lg-2 col-md-4 col-sm-6 col-xs-12" href="<%=Base_url%>AreaCliente/Area/${area.idArea}">
				<span class="glyphicon glyphicon-search" aria-hidden=true></span>
				<span class=glyphicon-class>${area.descricao}</span>
			</div>
					
		</c:forEach>						
			     
	</div>
</div>
			
			
			
			
			
<div class="row">
	<div class="col-md-12 column">
	
		<p class="text" style="font-size: 20px;  margin-top: 50px">Consultas:</p>
	
		<div class="form-inline" id="toolbar">
			<form:form id="frmConsultaIdosos" servletRelativeAction="/Idoso/Filtrar" commandName="consultaIdoso" method="post">
				<label for="txtSituacao">Situação:</label>
				<select class="form-control" name="situacao" id="txtSituacao">
					<option value="ES">Não respondidas</option>
					<option value="AV">Respondidas</option>
					<option selected value="IN">Todas</option>
				</select>
			</form:form>
		</div>

	
		<table class="table table-striped table-hover" id="tabConsultas" 
			data-height="470"
			data-search="true"
			data-toolbar="#toolbar"
			data-show-toggle="true"
			data-show-columns="true"
			data-show-export="true"                       
			data-pagination="true">                  			
			<thead>
				<tr>
					<th data-field="idIdoso">
						Código
					</th>
					<th data-field="nome">
						Nome
					</th>
					<th data-field="sobrenome">
						Sobre Nome
					</th>
					<th data-field="dataNascimento" data-formatter="FormataData">
						Data Nascimento
					</th>
					<th data-field="idade">
						Idade	
					</th>
					<th data-field="numeroCpf">
						CPF
					</th>
					<th data-field="numeroRg">
						RG
					</th>
					<th data-formatter="ExibeOpcoes">
						Ações
					</th>						
				</tr>
			</thead>
                    			
		</table>
		
	</div> <!-- Coluna 12 -->           
</div><!-- Row -->			
			

		</div>
	</div>	<!-- /container -->
	

	<%@ include file="../../../WEB-INF/views/site/layout/rodape.jsp"%>