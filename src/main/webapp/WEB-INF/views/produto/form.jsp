<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Formulário de Cadastro</title>
</head>
<body>
	<form action="/spring-cdc/produto/" method="post">
		<div>
			<label>Título:</label>
			<input type="text" name="titulo">
		</div>
		<div>
			<label>Descrição:</label>
			<textarea rows="6" cols="20" name="descricao"></textarea>
		</div>
		<div>
			<label>N. de Páginas:</label>
			<input type="text" name="paginas">
		</div>
		
		<c:forEach items="${tipos }" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco }</label>
				<input type="text" name="precos[${status.index }].valor">
				<input type="hidden" name="precos[${status.index }].tipo" value="${tipoPreco }">
			</div>
		</c:forEach>
		
		<button type="submit">Salvar</button>
	</form>
</body>
</html>