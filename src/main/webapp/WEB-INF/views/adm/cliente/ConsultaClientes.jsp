<%@ include file="../layout/Cabecalho.jsp" %>

<h2>Consulta de Clientes</h2>

<div class="row">

	<div class="form-inline" id="toolbar">
		<form:form id="frmConsultaClientes" servletRelativeAction="/Adm/Cliente/Listar" commandName="consultaCliente" method="post">
			<label for="txtSituacao">Situação:</label>
			<select class="form-control" name="situacao" id="txtSituacao">
				<option value="A">Ativos</option>
				<option value="I">Inativos</option>
				<option value="">Todos</option>
			</select>
		</form:form>
	</div>

	<div class="col-md-12 column">
		<table class="table table-striped table-hover" id="tabConsultaClientes"
			data-height="470"
			data-search="true"
			data-toolbar="#toolbar"
			data-show-toggle="true"
			data-show-columns="true"
			data-show-export="true"                       
			data-pagination="true">                  			
			<thead>
				<tr>
					<th data-field="id">
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

<div class="row">        
	<div class="col-md-12 col-lg-12" id="divBotoesForm">
		<a href="<%=Base_url%>Adm/Cliente/Form">
			<button class="btn btn-primary">
				<span class="glyphicon glyphicon-plus"></span> Adicionar Novo
			</button>
		</a>    
	</div> <!-- Coluna 12 -->
</div> <!-- Row -->

<%@ include file="../layout/Rodape.jsp" %>