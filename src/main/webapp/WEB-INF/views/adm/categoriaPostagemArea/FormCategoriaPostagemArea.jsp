<%@ include file="../layout/Cabecalho.jsp" %>

<h2 class="page-header">Cadastro de Categorias da Área</h2>

<form:form servletRelativeAction="/Adm/CategoriaPostagemArea/Form/Processar" commandName="categoriaPostagemArea" method="post">
		
		<input type="hidden" name="idCategoriaPostagemArea" value="${categoriaPostagemArea.idCategoriaPostagemArea}">
		<input type="hidden" id="idArea" name="area.idArea" value="${categoriaPostagemArea.area.idArea}">
		
		<div class="row">		
			<div class="form-group col-lg-10 col-md-10">
				<label for="basic-url">Área:</label>
				<div class="input-group">				  
				  <input class="form-control idPesqEntidade" required="required" disabled="disabled" idPesqEntidade="Area" nomeEntidade="Area" aria-describedby="basic-addon3"  value="${categoriaPostagemArea.area.idArea}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Area" nomeEntidade="Area">${categoriaPostagemArea.area.descricao}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="area" /></span>			
			</div>							
		</div>

		<div class="row">		
			<div class="form-group col-lg-10 col-md-10">
				<label for="basic-url">Categoria de Postagem:</label>
				<div class="input-group">				  
				  <input autofocus="autofocus" class="form-control idPesqEntidade" required="required" idPesqEntidade="CategoriaPostagem" nomeEntidade="CategoriaPostagem" name="categoriaPostagem.idCategoriaPostagem" aria-describedby="basic-addon3" id="idCategoriaPostagem"  value="${categoriaPostagemArea.categoriaPostagem.idCategoriaPostagem}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="CategoriaPostagem" nomeEntidade="CategoriaPostagem">${categoriaPostagemArea.categoriaPostagem.descricao}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="categoriaPostagem" /></span>			
			</div>							
		</div>
						
	    <div class="row">        
	        <div class="col-md-12 col-lg-12" id="divBotoesForm">            
	            <button id="btnSalvarForm" type="submit" class="btn btn-primary">
	            	<span class="glyphicon glyphicon-floppy-disk"></span> Salvar
	            </button>
				<button class="btn btn-warning" id="btnCancelarAlteracoes">
					<span class="glyphicon glyphicon-remove"></span> Cancelar
				</button>   	            
	        </div>	  
	    </div>  <!-- Row botões -->
		  
</form:form>
            
<%@ include file="../layout/Rodape.jsp" %>            

<%@ include file="../../../../resourses/adm/html/pesqEntidade.jsp" %>    