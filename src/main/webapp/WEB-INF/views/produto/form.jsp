<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Formulário de Cadastro</title>

<c:url value="/resources/bootstrap/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath }/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath }/bootstrap-theme.css">

<style type="text/css">
	body {
	padding: 60px 0px;
}
</style>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href='<c:url value="/" />'>Casa do Código</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href='<c:url value="/produto" />'>Lista de Produtos</a></li>
					<li><a href="<c:url value="/produto/form" />">Cadastro de Produtos</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>
	<div class="container">
		
		<h2>Cadastro de Produtos</h2>
		<s:url value="/produto" var="produto" />
		<form:form action="${produto }" method="post" commandName="produto" enctype="multipart/form-data">
			<div class="form-group">
				<label>Título:</label>
				<form:input path="titulo" cssClass="form-control" />
				<form:errors path="titulo" />
			</div>
			<div class="form-group">
				<label>Descrição:</label>
				<form:textarea path="descricao" cssClass="form-control" />
				<form:errors path="descricao" />
			</div>
			<div class="form-group">
				<label>N. de Páginas:</label>
				<form:input path="paginas" cssClass="form-control" />
				<form:errors path="paginas" />
			</div>
			<div class="form-group">
				<label>Data Lançamento:</label>
				<form:input path="dataLancamento" cssClass="form-control" />
				<form:errors path="dataLancamento" />
			</div>
			
			<c:forEach items="${tipos }" var="tipoPreco" varStatus="status">
				<div class="form-groupl">
					<label>${tipoPreco }</label>
					<form:input path="precos[${status.index }].valor" cssClass="form-control" />
					<form:hidden path="precos[${status.index }].tipo" value="${tipoPreco }" />
				</div>
			</c:forEach>
			
			<div class="form-group">
				<label>Sumário:</label>
				<input type="file" name="sumario" class="form-control">
			</div>
			
			<button type="submit" class="btn btn-primary">Salvar</button>
		</form:form>
	</div>
</body>
</html>