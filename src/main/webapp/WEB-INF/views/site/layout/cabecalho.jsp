<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% String Base_url = request.getContextPath()+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="PT-br">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Progressus - Free business bootstrap template by GetTemplate</title>

	<link rel="shortcut icon" href="<%=Base_url%>resourses/site/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="<%=Base_url%>resourses/site/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=Base_url%>resourses/site/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="<%=Base_url%>resourses/site/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="<%=Base_url%>resourses/site/css/main.css">

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="<%=Base_url%>resourses/site/js/html5shiv.js"></script>
	<script src="<%=Base_url%>resourses/site/js/respond.min.js"></script>
	<![endif]-->
	
	<link rel="stylesheet" href="<%=Base_url%>resourses/site/css/bootstrap-table.min.css">
</head>

<body class="home">

	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="<%=Base_url%>Inicio"><img src="<%=Base_url%>resourses/site/images/logo.png" alt=""></a>
			</div>
			<div class="navbar-collapse collapse" id="navbar-sup">
				<ul class="nav navbar-nav pull-right">
				
					<li class="liInicio itemMenuSup"><a href="<%=Base_url%>Inicio">Início</a></li>
					<li class="liQuemSomos itemMenuSup"><a href="<%=Base_url%>QuemSomos">Quem Somos</a></li>
					<li class="liServicos itemMenuSup"><a href="<%=Base_url%>Servicos">Serviços</a></li>
					<li class="liContato itemMenuSup"><a href="<%=Base_url%>Contato">Contato</a></li>
					
					<li class="liAreaCliente itemMenuSup"><a class="btn btn-navbarsup" href="<%=Base_url%>AreaCliente">Área do Cliente</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	<!-- /.navbar -->