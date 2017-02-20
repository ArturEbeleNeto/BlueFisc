<%@ include file="../layout/Cabecalho.jsp" %>


<h2 class="page-header">Cadastro de Cliente</h2>


<itemMenu item="DadosPessoais"/>

<form:form servletRelativeAction="/Adm/Cliente/Form/Processar" commandName="cliente" method="post">

	<input name="idCliente" type="hidden" value="${cliente.idCliente}">
	<input name="sequencia" type="hidden" value="${cliente.sequencia}">


		<div class="row">
			<div class="form-group col-lg-1 col-md-1">
				<label for="txtNome">C�digo:</label>
				<input name="idClienteDisable" disabled value="${cliente.id}" type="text" class="form-control">         
			</div>
			
			<div class="form-group col-lg-2 col-md-2">
				<label for="txtSituacao">Situa��o</label>
				<select class="form-control" name="situacao">
					<option <c:if test="${cliente.situacao == 'ATIVO'}">selected</c:if> value="ATIVO">Ativo</option>
					<option <c:if test="${cliente.situacao == 'INATIVO'}">selected</c:if> value="INATIVO">Inativo</option>
				</select>
				<span class="help-block"><form:errors path="situacao" /></span>
			</div> 			
			
		</div> <!-- Row -->

		<div class="row">
			<div class="form-group col-lg-6 col-md-6">
				<label for="txtNome">Nome:</label>
				<input autofocus="autofocus" name="nome" type="text" value="${cliente.nome}" class="form-control" id="txtNome">
				<span class="help-block"><form:errors path="nome" /></span>
			</div>
			<div class="form-group col-lg-6 col-md-6">
				<label for="txtSobrenome">Sobrenome:</label>
				<input name="sobrenome" value="${cliente.sobrenome}" type="text" class="form-control" id="txtSobrenomeCliente">
				<span class="help-block"><form:errors path="sobrenome" /></span>
			</div>
		</div> <!-- Row -->
                    
		<div class="row">
			<div class="form-group col-lg-2 col-md-3 col-sm-4">
				<label for="txtNumeroCpf">CPF:</label>
				<input name="numeroCpf" value="${cliente.numeroCpf}" type="text" class="form-control mskCpf" id="txtNumeroCpf">
				<span class="help-block"><form:errors path="numeroCpf" /></span>
			</div>
			<div class="form-group col-lg-2 col-md-2">
				<label for="txtNumeroRg">RG:</label>
				<input name="numeroRg" value="${cliente.numeroRg}" type="text" class="form-control" id="txtNumeroRg">
				<span class="help-block"><form:errors path="numeroRg" /></span>
			</div>
			<div class="form-group col-lg-2 col-md-2">
				<label for="txtSexo">Sexo</label>
				<select class="form-control" name="sexo">
					<option <c:if test="${cliente.sexo == 'M'}">selected</c:if> value="M">Masculino</option>
					<option <c:if test="${cliente.sexo == 'F'}">selected</c:if> value="F">Feminino</option>
				</select>
				<span class="help-block"><form:errors path="sexo" /></span>
			</div>                          
                      
		</div> <!-- Row -->

		<div class="row">
			<div class="form-group col-lg-2 col-md-3 col-sm-4">
				<label for="txtDataNascimento">Data de nascimento</label>
				<fmt:formatDate var="dataNascimento" value="${cliente.dataNascimento.time}" pattern="yyyy-MM-dd"/>
				<input name="dataNascimento" value="${dataNascimento}" type="date" class="form-control" id="txtDataNascimento">
				<span class="help-block"><form:errors path="dataNascimento" /></span>
			</div>                       		                        			
			<div class="form-group col-lg-2 col-md-2">
			    <label for="txtIdade">Idade</label>
			    <input name="idade" value="${cliente.idade}" type="number" class="form-control" id="txtIdade">
			    <span class="help-block"><form:errors path="idade" /></span>
			</div>
                                        
		</div> <!-- Row -->
                
						
	    <div class="row">        
	        <div class="col-md-12 col-lg-12" id="divBotoesForm">            
	            <button id="btnSalvarForm" type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-floppy-disk"></span> Salvar</button>
	            <button id="btnCancelarAlteracoes" type="reset" class="btn btn-warning"><span class="glyphicon glyphicon-remove"></span> Cancelar Altera��s</button>
	        </div>	  	       
	    </div>  <!-- Row bot�es -->
		            				       
          
</form:form>
            
<%@ include file="../layout/Rodape.jsp" %>            