<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Listagem de Produtos</title>
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
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">
						<security:authentication property="principal" var="usuario" />
						${usuario.nome }
					</a></li>
					<li><a href='<c:url value="/logout" />'>Sair</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>
	<div class="container">
		<h1>Lista de Produtos</h1>


		<div>${message }</div>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Páginas</th>
			</tr>

			<c:forEach items="${produtos }" var="produto">
				<tr>
					<td><a
						href='<c:url value="/produto/detalhe/${produto.id }" />'>${produto.titulo }</a>
					</td>
					<td>${produto.descricao }</td>
					<td>${produto.paginas }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>