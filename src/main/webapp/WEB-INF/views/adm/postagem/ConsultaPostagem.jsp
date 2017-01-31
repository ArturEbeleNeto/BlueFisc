<%@ include file="../layout/Cabecalho.jsp" %>

<h2>Consulta de estoques</h2>

<div class="row">
	<div class="col-md-12">
			
		<form id="formConsultaPostagem" name="formConsultaPostagem" action="#" method="post">
		
			<div class="row">
										
				<div class="form-group col-lg-6 col-md-6">
					<label for="basic-url">Idoso:</label>
					<div class="input-group">				  
					  <input autofocus="autofocus" class="form-control idPesqEntidade" idPesqEntidade="Idoso" nomeEntidade="Idoso" aria-describedby="basic-addon3" id="idIdoso">				  
					  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Idoso" nomeEntidade="Idoso"></span>				  		
					</div>		
				</div>							
							
				<div class="form-group col-lg-6 col-md-6">
					<label for="basic-url">Medicamento:</label>
					<div class="input-group">				  
					  <input class="form-control idPesqEntidade" idPesqEntidade="Medicamento" nomeEntidade="Medicamento" aria-describedby="basic-addon3" id="idMedicamento">				  
					  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Medicamento" nomeEntidade="Medicamento"></span>				  		
					</div>		
				</div>							
			</div>		
									
		    <div class="row">          
		        <div class="col-md-12 col-lg-12">            
		            <button id="btnBuscarEstoque" type="submit" class="btn btn-success">
		            	<span class="glyphicon glyphicon-random"></span>  Buscar
		            </button>
		        </div>	  
		    </div>  <!-- Row botões -->
		    
		</form>  		
	</div>
</div>
			 
<br>	
			 
<div class="row">
	<div class="col-md-12">
		    		
		<table id="tabEstoque" class="table table-hover"> 						                  
			<thead>
				<tr>
					<th class="hidden" data-field="idEstoqueMedicamento">ID</th>
								
					<th data-field="idoso.nome" data-valign="middle">
						Nome
					</th>					
					<th data-field="apresentacao.medicamento.descricaoComercial">
						Medicamento
					</th>
					<th data-field="apresentacao.descricao">
						Apresentação
					</th>
					<th data-field="quantidadeAdministracao">
						Qtde estoque
					</th>
					<th data-field="apresentacao.unidadeMedidaAdministracao.descricao">
						Unidade de estoque
					</th>
					<th data-formatter="ExibeOpcoes">
						Opções
					</th>						
				</tr>
			</thead>
			
			<tbody>																														
			</tbody>
		</table>
								
	</div>		
</div> <!-- Coluna 12 -->   

<br>
     
<div class="row">        
    <div class="col-md-12 col-lg-12" id="divBotoesForm">            
        <button id="btnMovimentarEstoque" type="submit" class="btn btn-primary">
        	<span class="glyphicon glyphicon-plus"></span>  Novo lançamento
        </button>
    </div>	  
</div>  <!-- Row botões -->     

<div class="row" hidden="">        
	<div class="col-md-12 col-lg-12" id="divBotoesForm">
		<a href="#">
			<button class="btn btn-primary">
				<span class="glyphicon glyphicon-print" style=""></span> Imprimir
			</button>
		</a>    
	</div>
</div>

<%@ include file="../layout/Rodape.jsp" %>
<%@ include file="../../../../resourses/adm/html/pesqEntidade.jsp" %>    