<% 
String Base_url = request.getContextPath()+"/";
%>


<!-- Bootstrap -->
<link href="<%=Base_url%>resourses/adm/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->



<!-- Latest compiled and minified CSS --> 
<!-- <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.css"> -->

<link rel="stylesheet" href="<%=Base_url%>resourses/adm/css/bootstrap-table.min.css" />

<link rel="stylesheet" href="<%=Base_url%>resourses/adm/css/Geral.css"/>

<% 
	String currentPage = request.getRequestURI();
	String[] pastas = currentPage.split("/");	
	
	String arquivoUrl = pastas[pastas.length - 1];
	String arquivoImportar = "";
	if(arquivoUrl.length()> 4){
		arquivoImportar = arquivoUrl.substring(0,arquivoUrl.length()- 4);
	}
	
	out.println("<link href=\""+ Base_url +"resourses/adm/css/"+ arquivoImportar +".css\" rel=\"stylesheet\">");	
%>