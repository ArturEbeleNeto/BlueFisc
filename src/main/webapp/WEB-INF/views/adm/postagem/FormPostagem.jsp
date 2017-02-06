<%@ include file="../layout/Cabecalho.jsp" %>

<h2 class="page-header">Postagem</h2>

<form:form servletRelativeAction="/Adm/Postagem/Form/Processar" commandName="postagem" method="post">
				
		<input name="idPostagem" value="${postagem.idPostagem}"  class="hidden" id="idPostagem" >				
							
		<div class="row">	
			<div class="form-group col-lg-12 col-md-12">
				<label for="idTitulo">Título:</label>
				<input name="titulo" autofocus="autofocus" required="required" value="${postagem.titulo}"  class="form-control" id="idTitulo" >
				<span class="help-block"><form:errors path="titulo"/></span>				
			</div>																					
		</div>	
		
		<div class="row">	
			<div class="form-group col-lg-12 col-md-12">
				<label for="idSubTitulo">Subtítulo:</label>
				<input name="subTitulo" required="required" value="${postagem.subTitulo}"  class="form-control" id="idSubTitulo" >
				<span class="help-block"><form:errors path="subTitulo"/></span>
			</div>																							
		</div>			

		<div class="row">		
			<div class="form-group col-lg-7 col-md-7">
				<label for="basic-url">Autor:</label>
				<div class="input-group">				  
				  <input class="form-control idPesqEntidade" idPesqEntidade="Usuario" nomeEntidade="Usuario" name="usuario.idUsuario" required="required" aria-describedby="basic-addon3" id="idUsuario"  value="${postagem.usuario.idUsuario}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Usuario" nomeEntidade="Usuario">${postagem.usuario.nome}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="usuario" /></span>			
			</div>		
			<div class="form-group col-lg-2 col-md-2">
				<label for="idDataPublicacao">Data Publicação:</label>
				<fmt:formatDate var="dataPublicacao" value="${postagem.dataPublicacao.time}" pattern="yyyy-MM-dd"/>	 		
				<input name="dataPublicacao" required="required" value="${dataPublicacao}" type="date" class="form-control" id="idDataPublicacao" >
				<span class="help-block"><form:errors path="dataPublicacao"/></span>
			</div>	
		</div>															
								
		<div class="row">	
			<div class="form-group col-lg-12 col-md-12">
				<label for="idTextoFormatado">Texto:</label>
				<textarea id="idTextoFormatado" name="textoFormatado" required="required" class="form-control" rows="10">${postagem.textoFormatado}</textarea>
				<span class="help-block"><form:errors path="textoFormatado"/></span>
			</div>																							
		</div>	
								
	    <div class="row">        
	        <div class="col-md-12 col-lg-12" id="divBotoesForm">            
	            <button id="btnSalvarForm" type="submit" class="btn btn-primary">
	            	<span class="glyphicon glyphicon-floppy-disk"></span> Salvar
	            </button>
				<button class="btn btn-warning" id="btnCancelarAlteracoes">
					<span class="glyphicon glyphicon-remove"></span> Sair
				</button>   	            
	        </div>	  
	    </div>  <!-- Row botões -->
		  
</form:form>

  
            
<%@ include file="../layout/rodapeFicha.jsp" %>   

<%@ include file="../../../../resourses/adm/html/pesqEntidade.jsp" %>    