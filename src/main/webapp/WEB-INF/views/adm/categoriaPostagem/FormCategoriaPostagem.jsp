<%@ include file="../layout/Cabecalho.jsp" %>

<h2 class="page-header">Cadastro de Categorias de Postagens</h2>

<form:form servletRelativeAction="/Adm/CategoriaPostagem/Form/Processar" commandName="categoriaPostagem" method="post">
		
		<div class="row">
			<div class="form-group col-lg-1 col-md-1">
				<label for="idCategoriaPostagem">Código:</label>
				<input value="${categoriaPostagem.idCategoriaPostagem}" disabled type="text" class="form-control">      				     
				<input name="idCategoriaPostagem" value="${categoriaPostagem.idCategoriaPostagem}" type="hidden" id="idCategoriaPostagem" >
			</div>
		</div> <!-- Row -->

		<div class="row">
			<div class="form-group col-lg-12 col-md-12">
				<label for="descricao">Descrição:</label>
				<input autofocus="autofocus" name="descricao" required="required" value="${categoriaPostagem.descricao}" type="text" class="form-control" id="descricao">
				<span class="help-block"><form:errors path="descricao"/></span>				
			</div>
		</div>		
						
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