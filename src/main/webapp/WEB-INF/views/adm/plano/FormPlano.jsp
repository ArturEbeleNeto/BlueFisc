<%@ include file="../layout/Cabecalho.jsp" %>

<h2 class="page-header">Cadastro de Plano</h2>

<form:form servletRelativeAction="/Adm/Plano/Form/Processar" commandName="plano" method="post">
		
		<div class="row">
			<div class="form-group col-lg-1 col-md-1">
				<label for="idPlano">Código:</label>
				<input value="${plano.idPlano}" disabled type="text" class="form-control">      				     
				<input name="idPlano" value="${plano.idPlano}" type="hidden" id="idPlano" >
			</div>
		</div> <!-- Row -->

		<div class="row">
			<div class="form-group col-lg-12 col-md-12">
				<label for="descricao">Descrição:</label>
				<input autofocus="autofocus" name="descricao" required="required" value="${plano.descricao}" type="text" class="form-control" id="descricao">
				<span class="help-block"><form:errors path="descricao"/></span>				
			</div>
		</div>		

		<div class="row">
		
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 column">
			
		        <div id="toolbar">
		            <div class="form-inline" role="form">
		                <div class="form-group">
		        			<label>Áreas:</label>
		                </div>
		            </div>
		        </div>
			
				<table class="table table-striped table-hover" id="tabConsultaAreaPlanos" 			
					data-search="true"
					data-toolbar="#toolbar"
					data-show-toggle="true"
					data-show-columns="true"
					data-show-export="true"                       
					data-pagination="true">                    			
					<thead>
						<tr>
							<th data-field="idArea">
								id Area
							</th>
							<th data-field="descricao">
								Descrição
							</th>					
						
							<th data-formatter="ExibeOpcoesCategoriaPostagem">
								Ações
							</th>						
						</tr>
					</thead>
					<tbody>				                  
					</tbody>
				</table>
				
				<div class="fixed-table-pagination TotalLinhas" style="display: block;">
					<div class="pull-left pagination-detail">
						<span class="pagination-info">Exibindo 0 até 0 de 0 linhas</span>
					</div>
				</div>			
				<div id="idTotalLinhas" class="clearfix"></div>				
				
				<a href="<% out.println(request.getContextPath()); %>Adm/CategoriaPostagemPlano/Form/"${plano.idPlano}>
					<button class="btn btn-primary btnSubForm">
						<span class="glyphicon glyphicon-plus"></span> Adicionar Novo
					</button>
				</a>    				
				
			</div> <!-- Coluna 1 -->
			           
		</div><!-- Row -->		
								
		<input type="hidden" name="goSubForm" size="1" id="goSubForm">						
								
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