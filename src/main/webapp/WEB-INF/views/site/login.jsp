	<%@ include file="../../../WEB-INF/views/site/layout/cabecalho.jsp"%>

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="<%=Base_url%>Inicio">Início</a></li>
			<li><a href="<%=Base_url%>Login">Login</a></li>
			<liActive val="Login"></liActive>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Sign in</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Sign in to your account</h3>
							<p class="text-center text-muted">Lorem ipsum dolor sit amet, <a href="<%=Base_url%>Cadastro">Cadastro</a> adipisicing elit. Quo nulla quibusdam cum doloremque incidunt nemo sunt a tenetur omnis odio. </p>
							<hr>
							
							<form:form servletRelativeAction="/login" method="post" class="form-login">
										
								<c:if test="${param.error != null}">
									<div id="divErros" class="div-error">
					                    Usuário e senha inválidos.
					                </div>
				                </c:if>
				                <c:if test="${param.logout != null}">
					                <div id="divErros" class="div-error"> 
					                    Logout realizado
					                </div>						
				                </c:if>							
							
								<div class="top-margin">
							    	<label for="usuario">Usuário</label>
							    	<input type="text" value="${usuario.usuario}" class="form-control" name="username" id="usuario">
							    	<span class="help-block"><form:errors path="usuario.usuario" /></span>
								</div>
								<div class="top-margin">
							    	<label for="senha">Senha</label>
							    	<input type="password" value="${usuario.senha}" class="form-control" name="password">
							    	<span class="help-block"><form:errors path="usuario.senha" /></span>
								</div>

								<hr>

								<div class="row">
									<div class="col-lg-8">
										<b><a href="">Forgot password?</a></b>
									</div>
									<div class="col-lg-4 text-right">
										<button class="btn btn-action" type="submit">Sign in</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->
	

	<%@ include file="../../../WEB-INF/views/site/layout/rodape.jsp"%>