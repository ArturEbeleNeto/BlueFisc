<%@ include file="../layout/Cabecalho.jsp" %>

<h2 class="page-header">Cadastro de Categorias da Área</h2>

<form:form servletRelativeAction="/Adm/AreaPlano/Form/Processar" commandName="categoriaPostagemArea" method="post">
		
		<input type="hidden" name="idPlano" value="${plano.idPlano}">
		
		<div class="row">		
			<div class="form-group col-lg-10 col-md-10">
				<label for="basic-url">Plano:</label>
				<div class="input-group">				  
				  <input disabled="disabled" class="form-control idPesqEntidade" required="required" idPesqEntidade="Plano" nomeEntidade="Plano" name="idPlano" aria-describedby="basic-addon3" id="idPlano"  value="${plano.idPlano}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Plano" nomeEntidade="Plano">${plano.descricao}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="plano" /></span>			
			</div>							
		</div>		
		
		<div class="row">		
			<div class="form-group col-lg-10 col-md-10">
				<label for="basic-url">Área:</label>
				<div class="input-group">				  
				  <input class="form-control idPesqEntidade" autofocus="autofocus" required="required" idPesqEntidade="Area" nomeEntidade="Area" aria-describedby="basic-addon3" name="idArea" value="${area.idArea}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Area" nomeEntidade="Area">${area.descricao}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="area" /></span>			
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