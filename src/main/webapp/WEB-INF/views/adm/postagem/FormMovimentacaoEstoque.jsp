<%@ include file="../layout/Cabecalho.jsp" %>

<h2 class="page-header">Movimentação de estoque</h2>

<form:form servletRelativeAction="/Estoque/MovimentarEstoque/Processar" commandName="movimentacaoEstoque" method="post">
												

		<div class="row">		
			<div class="form-group col-lg-10 col-md-10">
				<label for="basic-url">Idoso:</label>
				<div class="input-group">				  
				  <input class="form-control idPesqEntidade" idPesqEntidade="Idoso" nomeEntidade="Idoso" name="idoso.idIdoso" required="required" aria-describedby="basic-addon3" id="idIdoso"  value="${movimentacaoEstoque.idoso.idIdoso}" autofocus="autofocus">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Idoso" nomeEntidade="Idoso">${movimentacaoEstoque.idoso.nome}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="idoso" /></span>			
			</div>							
		</div>

		<div class="row">		
			<div class="form-group col-lg-10 col-md-10">
				<label for="basic-url">Medicamento:</label>
				<div class="input-group">				  
				  <input class="form-control idPesqEntidade" idPesqEntidade="Medicamento" nomeEntidade="Medicamento" name="apresentacao.medicamento.idMedicamento" required="required" aria-describedby="basic-addon3" id="idMedicamento"  value="${movimentacaoEstoque.apresentacao.medicamento.idMedicamento}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Medicamento" nomeEntidade="Medicamento">${movimentacaoEstoque.apresentacao.medicamento.descricaoComercial}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="apresentacao.medicamento" /></span>			
			</div>							
		</div>
		
		<div class="row">		
			<div class="form-group col-lg-10 col-md-10">
				<label for="basic-url">Apresentação:</label>
				<div class="input-group">				  
				  <input class="form-control idPesqEntidade" idCampoFiltro="idMedicamento" idPesqEntidade="Apresentacao" nomeEntidade="Apresentacao" name="apresentacao.idApresentacao" required="required" aria-describedby="basic-addon3" id="idApresentacao"  value="${movimentacaoEstoque.apresentacao.idApresentacao}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Apresentacao" nomeEntidade="Apresentacao">${itemFichaMedicamento.apresentacao.descricao}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="apresentacao" /></span>			
			</div>							
		</div>	

		<div class="row">	
			<div class="form-group col-lg-2 col-md-2">
				<label for="quantidade">Quantidade:</label>
				<input name="quantidadeMovimento" type="number" step="0.01" required="required" value="${movimentacaoEstoque.quantidadeMovimento}"  class="form-control" id="quantidadeMovimento" >
				<span class="help-block"><form:errors path="quantidadeMovimento"/></span>				
			</div>
			<div class="form-group col-lg-2 col-md-2">
				<label for="quantidade">Unidade:</label>
				<select class="form-control" name="unidadeMedida.idUnidadeMedida" id="unidadeMedida">
				</select>
			</div>			
			
			<div class="form-group col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2">
				<label for="referenciaLote">Nr Lote:</label>
				<input name="referenciaLote" type="text" required="required" value="${movimentacaoEstoque.referenciaLote}"  class="form-control" id="referenciaLote" >
				<span class="help-block"><form:errors path="referenciaLote"/></span>				
			</div>
			
			<div class="form-group col-lg-2 col-md-2">
				<label for="dataVencimentoe">Data vencimento:</label>
				<fmt:formatDate var="dataVencimento" value="${movimentacaoEstoque.dataVencimento.time}" pattern="yyyy-MM-dd"/>
				<input name="dataVencimento" type="date" min="2016-01-01" max="9999-01-01" required="required" value="${dataVencimento}"  class="form-control">
				<span class="help-block"><form:errors path="dataVencimento"/></span>				
			</div>										
												
		</div>										

		<div class="row">				
			<div class="form-group col-lg-2 col-md-2">
				<label for="quantidade">Tipo:</label>
				<select class="form-control" name="tipoMovimento">
					<option value="ENTRADA" <c:if test="${movimentacaoEstoque.tipoMovimento == 'ENTRADA'}">selected</c:if> >ENTRADA</option>
					<c:if test="${tipoUsuario == 'ADMINISTRADOR'}">
						<option value="SAIDA" <c:if test="${movimentacaoEstoque.tipoMovimento == 'SAIDA'}">selected</c:if> >SAIDA</option>
					</c:if>
				</select>
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