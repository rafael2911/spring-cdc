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
</head>
<body>
	<form:form action="${s:mvcUrl('PC#salvar').build() }" method="post" commandName="produto">
		<div>
			<label>Título:</label>
			<input type="text" name="titulo">
			<form:errors path="titulo" />
		</div>
		<div>
			<label>Descrição:</label>
			<textarea rows="6" cols="20" name="descricao"></textarea>
			<form:errors path="descricao" />
		</div>
		<div>
			<label>N. de Páginas:</label>
			<input type="text" name="paginas">
			<form:errors path="paginas" />
		</div>
		
		<c:forEach items="${tipos }" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco }</label>
				<input type="text" name="precos[${status.index }].valor">
				<input type="hidden" name="precos[${status.index }].tipo" value="${tipoPreco }">
			</div>
		</c:forEach>
		
		<button type="submit">Salvar</button>
	</form:form>
</body>
</html>