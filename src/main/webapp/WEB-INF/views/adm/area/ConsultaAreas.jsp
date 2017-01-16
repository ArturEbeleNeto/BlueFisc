<%@ include file="../layout/Cabecalho.jsp" %>

<h2>Consulta de Areas</h2>

<div class="row">

	<div class="col-md-12 column">
		<table class="table table-striped table-hover" id="tabConsultaAreas" 			
			data-height="470"
			data-search="true"
			data-toolbar="#toolbar"
			data-show-toggle="true"
			data-show-columns="true"
			data-show-export="true"                       
			data-pagination="true">                    			
			<thead>
				<tr>
					<th data-field="idArea">
						ID
					</th>
					<th data-field="caminhoLogo">
						�cone
					</th>					
					<th data-field="descricao">
						Descri��o
					</th>
				
					<th data-formatter="ExibeOpcoes">
						A��es
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
		<a href="<%=Base_url%>Adm/Area/Form">
			<button class="btn btn-primary">
				<span class="glyphicon glyphicon-plus"></span> Adicionar
			</button>
		</a>    
	</div> <!-- Coluna 12 -->
</div> <!-- Row -->

<%@ include file="../layout/Rodape.jsp" %>