<%@ include file="Cabecalho.jsp" %>

	<link href="<%=Base_url%>resourses/css/FichaIdoso.css" rel="stylesheet">
	
	<IdIdosoFicha valor="${idoso.idIdoso}"/>

	<div class="row">

    	<div class="col-sm-3 col-md-2 sidebar" id="divSidebar">
        
          	<div class="row placeholders">
            	<div class="col-xs-offset-1 col-xs-10 col-sm-10 col-sm-offset-1 placeholder">
				            	
					<c:if test="${idoso.imagem != '' && idoso.imagem != null}">
						<img id="imgImagemIdoso" src="<%= Base_url %>${idoso.imagem}" width="100" height="100" class="img-responsive" alt="Generic placeholder thumbnail">
					</c:if>
					<c:if test="${idoso.imagem == '' or idoso.imagem == null}">
						<img id="imgImagemIdoso" src="<%= Base_url %>resourses/img/semImagem.png" width="100" height="100" class="img-responsive" alt="Generic placeholder thumbnail">
					</c:if>            	
            	
	              	<h4>${idoso.nome}</h4>
	              	
	              	<c:if test="${idoso.idade > 0}">
	              		<span class="text-muted">${idoso.idade} anos</span>           
	              	</c:if>
	              	   		              		
            	</div>
          	</div>  

          	<ul class="nav nav-sidebar">             
          	
	            <li id="liDadosPessoais"><a href="<%= Base_url %>Idoso/DadosPessoais/${idoso.idIdoso}">Dados Pessoais</a></li>
	            	
	           	<c:if test="${idoso.idIdoso > 0}"> 	           
	            	<li id="liContatos"><a href="<%=Base_url%>Contato/Consulta/${idoso.idIdoso}">Contatos</a></li>
	           	</c:if>
	            	            
	            <c:if test="${idoso.situacao != 'ES' && idoso.situacao != null}">
		            <li id="liProntuario"><a href="<%=Base_url%>Prontuario/Form/${idoso.idIdoso}">SAE</a></li>
		        </c:if>
		        	            
		        <c:if test="${idoso.situacao != 'ES' && idoso.situacao != 'AV' && idoso.situacao != null}">    
		        
		        	<li id="liInternacao"><a href="<%=Base_url%>Internacao/Form/${idoso.idIdoso}">Dados Internação</a></li>
		        
		        	<li id="liFichaMedicamento"><a href="<%=Base_url%>FichaMedicamento/${idoso.idIdoso}">Medicamentos</a></li>
		        	
		            <li id="liConsultaMedica"><a href="<%=Base_url%>ConsultaMedica/Consulta/${idoso.idIdoso}">Consultas médicas</a></li>
		            		          		           
		            <c:if test="${tipoUsuario == 'ADMINISTRADOR'}">    	            	         			
		            	<li id="liParcelas"><a href="<%=Base_url%>Parcela/Idoso/${idoso.idIdoso}">Formação de preço</a></li>
		            </c:if>
            	</c:if>
            		
          	</ul>         
                    
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main conteudoFicha">		      