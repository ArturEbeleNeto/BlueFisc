<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="ImportsCabecalho.jsp" %>
	<title>SILPI - Sistema para Instituições de Longa Permanência para Idosos</title>
</head>
<body>

<!-- Menu superior -->
<nav class="navbar navbar-fixed-top navbar-inverse">
  <div class="container-fluid">
  
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">CONSULT</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    
      <ul class="nav navbar-nav">
      
        <li><a href="<%=Base_url%>Adm">Início</a></li>
        
        <li><a href="<%=Base_url%>Adm/Plano/Consulta">Planos</a></li>
        
        <li><a href="<%=Base_url%>Adm/Area/Consulta">Áreas</a></li>      
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Postagens<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=Base_url%>Adm/Postagem/Consulta">Consulta</a></li>                     
            <li role="separator" class="divider"></li>
            <li><a href="<%=Base_url%>Adm/CategoriaPostagem/Consulta">Categorias</a></li>                        
          </ul>
        </li>          
        
      </ul>

      <ul class="nav navbar-nav navbar-right">
      	<li><a>Usuário: <security:authentication property="principal.nome"/></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Opções<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=Base_url%>Usuario/AlterarSenha">Alterar senha</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="<%=Base_url%>logout">Sair</a></li>
          </ul>
        </li>
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav> <!-- Menu Superior -->
<!-- Fim Menu superior -->

<!-- Início conteúdo da página -->
<div class="container-fluid">