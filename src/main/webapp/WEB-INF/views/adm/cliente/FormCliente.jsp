<%@ include file="../layout/Cabecalho.jsp" %>


<h2 class="page-header">Cadastro de Cliente</h2>


<itemMenu item="DadosPessoais"/>

<form:form servletRelativeAction="/Adm/Cliente/Form/Processar" commandName="cliente" method="post">

	<input name="idCliente" type="hidden" value="${cliente.idCliente}">
	<input name="sequencia" type="hidden" value="${cliente.sequencia}">
	
	<input name="usuario.idUsuario" type="hidden" value="${cliente.usuario.idUsuario}">


		<div class="row">
			<div class="form-group col-lg-1 col-md-1">
				<label for="txtNome">Código:</label>
				<input name="idClienteDisable" disabled value="${cliente.id}" type="text" class="form-control">         
			</div>
			
			<div class="form-group col-lg-2 col-md-2">
				<label for="txtSituacao">Situação</label>
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
			<div class="form-group col-lg-10 col-md-10">
				<label for="basic-url">Plano:</label>
				<div class="input-group">				  
				  <input class="form-control idPesqEntidade" required="required" idPesqEntidade="Plano" nomeEntidade="Plano" name="plano.idPlano" aria-describedby="basic-addon3" id="idPlano"  value="${cliente.plano.idPlano}">				  
				  <span class="input-group-addon descricaoPesqEntidade" idPesqEntidade="Plano">${cliente.plano.descricao}</span>				  		
				</div>		
				<span class="help-block"><form:errors path="plano" /></span>			
			</div>							
		</div>		                
		
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<h3 class="page-header">Acesso</h3>		
			</div>
		</div>

		<div class="row">
			<div class="form-group col-lg-2 col-md-3 col-sm-4">
				<label for="txtUsuario">Usuário:</label>
				<input name="usuario.usuario" value="${cliente.usuario.usuario}" type="text" class="form-control" id="txtUsuario">
				<span class="help-block"><form:errors path="usuario.usuario" /></span>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-lg-2 col-md-3 col-sm-4">
				<label for="txtSenha">Senha:</label>
				<input name="usuario.senha" value="${cliente.usuario.senha}" type="password" class="form-control" id="txtSenha">
				<span class="help-block"><form:errors path="usuario.senha" /></span>
			</div>
			<div class="form-group col-lg-2 col-md-2">
				<label for="txtConfirmacaoSenha">Confimação da senha:</label>
				<input name="usuario.confirmacaoSenha" value="${cliente.usuario.confirmacaoSenha}" type="password" class="form-control" id="txtConfirmacaoSenha">
				<span class="help-block"><form:errors path="usuario.confirmacaoSenha" /></span>
			</div>
		</div>
						
	    <div class="row">        
	        <div class="col-md-12 col-lg-12" id="divBotoesForm">            
	            <button id="btnSalvarForm" type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-floppy-disk"></span> Salvar</button>
	            <button id="btnCancelarAlteracoes" type="reset" class="btn btn-warning"><span class="glyphicon glyphicon-remove"></span> Cancelar Alteraçõs</button>
	        </div>	  	       
	    </div>  <!-- Row botões -->
		            				       
          
</form:form>
            
<%@ include file="../layout/Rodape.jsp" %>
<%@ include file="../../../../resourses/adm/html/pesqEntidade.jsp" %>    