<%@ include file="../layout/Cabecalho.jsp" %>

<h2 class="page-header">Cadastro de Medicamento</h2>

<form:form servletRelativeAction="/Medicamento/Form/Processar" commandName="medicamento" method="post">
		
		<div class="row">
			<div class="form-group col-lg-1 col-md-1">
				<label for="idMedicamento">Código:</label>
				<input value="${medicamento.idMedicamento}" disabled type="text" class="form-control">      				     
				<input name="idMedicamento" value="${medicamento.idMedicamento}" type="hidden" id="idMedicamento" >
			</div>
		</div> <!-- Row -->

		<div class="row">
			<div class="form-group col-lg-12 col-md-12">
				<label for="descricaoComercial">Descrição Comercial:</label>
				<input autofocus="autofocus" name="descricaoComercial" required="required" value="${medicamento.descricaoComercial}" type="text" class="form-control" id="descricaoComercial">
				<span class="help-block"><form:errors path="descricaoComercial"/></span>				
			</div>
		</div>
		<div class="row">	
			<div class="form-group col-lg-5 col-md-5">
				<label for="basic-url">Princípio ativo</label>
				<div class="input-group">				  
				  <input class="form-control idPesqEntidade" idPesqEntidade="PrincipioAtivo" nomeEntidade="PrincipioAtivo" name="principioAtivo.idPrincipioAtivo" required="required" type="text" aria-describedby="basic-addon3" id="idPrincipioAtivo"  value="${medicamento.principioAtivo.idPrincipioAtivo}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="PrincipioAtivo" nomeEntidade="PrincipioAtivo">${medicamento.principioAtivo.descricao}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="principioAtivo" /></span>			
			</div>	  			
			
			<div class="form-group col-lg-5 col-md-5">
				<label for="basic-url">Categoria</label>
				<div class="input-group">				  
				  <input class="form-control idPesqEntidade" idPesqEntidade="Categoria" nomeEntidade="Categoria" name="categoria.idCategoria" type="text"  aria-describedby="basic-addon3" id="basic-url"  value="${medicamento.categoria.idCategoria}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Categoria" nomeEntidade="Categoria">${medicamento.categoria.descricao}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="categoria" /></span>			
			</div>				
		</div> <!-- Row -->		
		
		

		<div class="row">
			<div class="col-md-12 column">
			
		        <div id="toolbar">
		            <div class="form-inline" role="form">
		                <div class="form-group">
		        			<label>Apresentações:</label>
		                </div>
		            </div>
		        </div>
			
				<table class="table table-striped table-hover" id="tabConsultaApresentacoes" 			
					data-search="true"
					data-toolbar="#toolbar"
					data-show-toggle="true"
					data-show-columns="true"
					data-show-export="true"                       
					data-pagination="true">                    			
					<thead>
						<tr>
							<th data-field="idApresentacao">
								id
							</th>
							<th data-field="descricao">
								Descrição
							</th>					
						
							<th data-field="unidadeMedidaEstoque.descricao">
								Unid medida de estoque	
							</th>

							<th data-field="unidadeMedidaAdministracao.descricao">
								Unid medida de administracao	
							</th>
						
							<th data-formatter="ExibeOpcoes">
								Ações
							</th>						
						</tr>
					</thead>
					<tbody>				                  
					</tbody>
				</table>
				
				<div id="idTotalLinhas" class="fixed-table-pagination" style="display: block;">
					<div class="pull-left pagination-detail">
						<span class="pagination-info">Exibindo 0 até 0 de 0 linhas</span>
					</div>
				</div>			
				<div id="idTotalLinhas" class="clearfix"></div>				
				
				<input type="hidden" name="formApresentacao" size="1" id="formApresentacao">
				<a href="<% out.println(request.getContextPath()); %>/Apresentacao/Form/"${medicamento.idMedicamento}>
					<button class="btn btn-primary" id="btnFormApresentacao">
						<span class="glyphicon glyphicon-plus" style=""></span> Adicionar Novo
					</button>
				</a>    				
				
			</div> <!-- Coluna 12 -->           
		</div><!-- Row -->		
								
	    <div class="row">        
	        <div class="col-md-12 col-lg-12" id="divBotoesForm">            
	            <button id="btnSalvarForm" type="submit" class="btn btn-primary">
	            	<span class="glyphicon glyphicon-floppy-disk" style=""></span> Salvar
	            </button>
				<button class="btn btn-warning" id="btnCancelarAlteracoes">
					<span class="glyphicon glyphicon-remove" style=""></span> Cancelar
				</button>   	            
	        </div>	  
	    </div>  <!-- Row botões -->
		  
</form:form>
            
<%@ include file="../layout/Rodape.jsp" %>            

<%@ include file="../../../../resourses/adm/html/pesqEntidade.jsp" %>    