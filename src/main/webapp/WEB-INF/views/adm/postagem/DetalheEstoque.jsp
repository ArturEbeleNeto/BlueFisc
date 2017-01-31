<%@ include file="../layout/Cabecalho.jsp" %>

<h2>Detalhe do estoques</h2>

<div class="row">
	<div class="col-md-12">
		<div class="row">
									
			<input hidden="hidden" id="idEstoqueMedicamento" value="${estoqueMedicamento.id}">						
									
			<div class="form-group col-lg-6 col-md-6">
				<label for="basic-url">Idoso:</label>
				<div class="input-group">				  
				  <input class="form-control" disabled="disabled" aria-describedby="basic-addon3" id="idIdoso" value="${estoqueMedicamento.idoso.idIdoso}">				  
				  <span class="input-group-addon descricaoPesqEntidade">${estoqueMedicamento.idoso.nome}</span>				  		
				</div>		
			</div>							
						
			<div class="form-group col-lg-6 col-md-6">
				<label for="basic-url">Medicamento:</label>
				<div class="input-group">				  
				  <input class="form-control" disabled="disabled" aria-describedby="basic-addon3" id="idMedicamento" value="${estoqueMedicamento.apresentacao.medicamento.idMedicamento}">				  
				  <span class="input-group-addon descricaoPesqEntidade">${estoqueMedicamento.apresentacao.medicamento.descricao}</span>				  		
				</div>		
			</div>
					
			<div class="form-group col-lg-6 col-md-6">
				<label for="basic-url">Apresentação:</label>
				<div class="input-group">				  
				  <input class="form-control" disabled="disabled" aria-describedby="basic-addon3" id="idApresentacao" value="${estoqueMedicamento.apresentacao.idApresentacao}">				  
				  <span class="input-group-addon descricaoPesqEntidade">${estoqueMedicamento.apresentacao.descricao}</span>				  		
				</div>		
			</div>
			
			<div class="form-group col-lg-3 col-md-3">
				<label for="basic-url">Quantidade Estoque:</label> <!-- type="number" step="0.01" -->
				<input class="form-control mskMoney" disabled="disabled" id="quantidadeAtual" value="${estoqueMedicamento.quantidadeAtual}">				  				  		
			</div>			
			<div class="form-group col-lg-3 col-md-3">
				<label for="basic-url">Unidade:</label>
				<div class="input-group">				  
				  <input class="form-control" aria-describedby="basic-addon3" disabled="disabled" id="idUnidade" value="${estoqueMedicamento.apresentacao.unidadeMedidaEstoque.idUnidadeMedida}">				  
				  <span class="input-group-addon descricaoPesqEntidade">${estoqueMedicamento.apresentacao.unidadeMedidaEstoque.descricao}</span>				  		
				</div>		
			</div>														

			<div class="form-group col-lg-3 col-md-3">
				<label for="basic-url">Quantidade Administração:</label>
				<input class="form-control mskMoney" disabled="disabled" id="quantidadeAdministracao" value="${estoqueMedicamento.quantidadeAdministracao}">				  				  		
			</div>			
			<div class="form-group col-lg-3 col-md-3">
				<label for="basic-url">Unidade:</label>
				<div class="input-group">				  
				  <input class="form-control" aria-describedby="basic-addon3" disabled="disabled" id="idUnidadeAdministracao" value="${estoqueMedicamento.apresentacao.unidadeMedidaEstoque.idUnidadeMedida}">				  
				  <span class="input-group-addon descricaoPesqEntidade">${estoqueMedicamento.apresentacao.unidadeMedidaAdministracao.descricao}</span>				  		
				</div>		
			</div>	
										
		</div>		
	</div>
</div>

<div class="row">
	<div class="col-sm-12 col-md-12">
	
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#pnlEstoqueLote" aria-controls="pnlEstoqueLote" role="tab" data-toggle="tab">Lotes</a></li>
					<li role="presentation"><a href="#pnlMovimentacoes" aria-controls="pnlMovimentacoes" role="tab" data-toggle="tab">Movimentações</a></li>
				</ul>
			</div>
		</div>		
		
		<!-- Tab panes -->
		<div class="tab-content">	
	
			<div role="tabpanel" class="tab-pane active" id="pnlEstoqueLote">		
				<div class="row">
					<div class="form-group col-lg-12 col-md-12">
					
						<table id="tabEstoqueLote"  class="table table-hover"
													data-show-toggle="true"
													data-show-columns="true"
													data-show-export="true"                       
													data-pagination="true"> 						                  
							<thead>
								<tr>
									<th class="hidden" data-field="idEstoqueLote">ID</th>
									
									<th data-field="referenciaLote">
										Referencia
									</th>										
									<th data-field="dataVencimento" data-formatter="FormataData">
										vencimento
									</th>		
									<th data-field="quantidadeAdministracao" data-formatter="FormataDecimal">
										Qtde estoque
									</th>
									<th data-field="estoqueMedicamento.apresentacao.unidadeMedidaAdministracao.descricao">
										Unidade de estoque
									</th>
									<!--<th data-formatter="ExibeOpcoesLotes">
										Opções
									</th>-->						
								</tr>
							</thead>
							
							<tbody>																														
							</tbody>
						</table>
					
					</div>
				</div>
			</div><!-- Div painel estoque lotes -->
			
			
			<div role="tabpanel" class="tab-pane" id="pnlMovimentacoes">
				<div class="row">
					<div class="form-group col-lg-12 col-md-12">

						<table id="tabMovimentacao" class="table table-hover" 		
													data-show-toggle="true"
													data-show-columns="true"
													data-show-export="true"                       
													data-pagination="true">  						                  
							<thead>
								<tr>
									<th class="hidden" data-field="idMovimentacaoEstoque">ID</th>
																	
									<th data-field="tipoMovimento">
										Tipo
									</th>		
									<th data-field="quantidadeAdministracao" data-formatter="FormataDecimal">
										Quantidade
									</th>
									<th data-field="apresentacao.unidadeMedidaAdministracao.descricao">
										Unidade
									</th>									
									<th data-field="dataMovimento" data-formatter="FormataData">
										Data
									</th>
									<th data-field="horarioMovimento" data-formatter="FormataHora">
										Horario
									</th>
									
									<th data-field="usuarioMovimento.nome">
										Usuário
									</th>
								
								</tr>
							</thead>
							
							<tbody>																														
							</tbody>
						</table>

						
					</div>				
				</div>
			</div> <!-- Div painel movimentacões -->

						
		</div> <!-- tab-content -->
			
	</div>
</div>

<div class="row">        
	<div class="col-md-12 col-lg-12" id="divBotoesForm">
		<a href="<%=Base_url%>Estoque/Consulta">
			<button class="btn btn-warning">
				<span class="glyphicon glyphicon-arrow-left"></span> Voltar
			</button>
		</a>    
	</div>
</div>

<%@ include file="../layout/Rodape.jsp" %>
<%@ include file="../../../../resourses/adm/html/pesqEntidade.jsp" %>      	