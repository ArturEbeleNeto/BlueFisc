<%@ include file="../layout/Cabecalho.jsp" %>

<h2>Consulta de Medicamentos</h2>

<div class="row">

	<div class="col-md-12 column">
		<table class="table table-striped table-hover" id="tabConsultaMedicamentos" 			
			data-height="470"
			data-search="true"
			data-toolbar="#toolbar"
			data-show-toggle="true"
			data-show-columns="true"
			data-show-export="true"                       
			data-pagination="true">                    			
			<thead>
				<tr>
					<th data-field="idMedicamento">
						Código
					</th>
					<th data-field="descricaoComercial">
						Descrição comercial
					</th>
					<th data-field="principioAtivo.descricao">
						Princípio ativo
					</th>					
				
					<th data-field="categoria.descricao">
						Categoria	
					</th>
				
					<th data-formatter="ExibeOpcoes">
						Ações
					</th>						
				</tr>
			</thead>
			<tbody>				                  
			</tbody>
		</table>
		
	</div> <!-- Coluna 12 -->           
</div><!-- Row -->

<div class="row">        
	<div class="col-md-12 col-lg-12" id="divBotoesForm">
		<a href="<%=Base_url%>Medicamento/Form">
			<button class="btn btn-primary">
				<span class="glyphicon glyphicon-plus"></span> Adicionar Novo
			</button>
		</a>    
	</div> <!-- Coluna 12 -->
</div> <!-- Row -->

<%@ include file="../layout/Rodape.jsp" %>