<%@ include file="../layout/Cabecalho.jsp" %>

<h2>Consulta de estoques</h2>

<div class="row">
	<div class="col-md-12">
			
		<form id="formConsultaPostagem" name="formConsultaPostagem" action="#" method="post">
		
			<div class="row">
										
				<div class="form-group col-lg-6 col-md-6">
					<label for="basic-url">Área:</label>
					<div class="input-group">				  
					  <input autofocus="autofocus" class="form-control idPesqEntidade" idPesqEntidade="Area" nomeEntidade="Area" aria-describedby="basic-addon3" id="idArea">				  
					  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Area" nomeEntidade="Area"></span>				  		
					</div>		
				</div>							
							
				<div class="form-group col-lg-6 col-md-6">
					<label for="basic-url">Categoria:</label>
					<div class="input-group">				  
					  <input class="form-control idPesqEntidade" idPesqEntidade="CategoriaPostagem" nomeEntidade="CategoriaPostagem" aria-describedby="basic-addon3" id="idCategoriaPostagem">				  
					  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="CategoriaPostagem" nomeEntidade="CategoriaPostagem"></span>	
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
		    		
		<table id="tabPostagem" class="table table-hover"> 						                  
			<thead>
				<tr>
					<th class="hidden" data-field="idPostagem">ID</th>
								
					<th data-field="titulo">
						Título
					</th>					
					<th data-field="subTitulo">
						Subtítulo
					</th>
					<th data-field="usuario.nome">
						Autor
					</th>
					<th data-field="dataPublicacao" data-formatter="FormataData">
						Data Publicação
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
        <button id="btnAdicionarPostagem" type="submit" class="btn btn-primary">
        	<span class="glyphicon glyphicon-plus"></span>  Nova Postagem
        </button>
    </div>	  
</div>  <!-- Row botões -->     

<%@ include file="../layout/Rodape.jsp" %>
<%@ include file="../../../../resourses/adm/html/pesqEntidade.jsp" %>    