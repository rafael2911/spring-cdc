<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Listagem de Produtos</title>
<c:url value="/resources/bootstrap/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath }/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath }/bootstrap-theme.css">

</head>
<body>
	<h1>Lista de Produtos</h1>
	
	
	<div>${message }</div>
	
	<table>
		<tr>
			<th>Título</th>
			<th>Descrição</th>
			<th>Páginas</th>
		</tr>
		
		<c:forEach items="${produtos }" var="produto">
			<tr>
				<td>
					<a href='<c:url value="/produto/detalhe/${produto.id }" />'>${produto.titulo }</a>
				</td>
				<td>${produto.descricao }</td>
				<td>${produto.paginas }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>