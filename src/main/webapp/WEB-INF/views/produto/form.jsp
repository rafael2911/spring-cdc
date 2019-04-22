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

</head>
<body>
	<s:url value="/produto" var="produto" />
	<form:form action="${produto}" method="post" commandName="produto" enctype="multipart/form-data">
		<div>
			<label>Título:</label>
			<form:input path="titulo" />
			<form:errors path="titulo" />
		</div>
		<div>
			<label>Descrição:</label>
			<form:textarea path="descricao" rows="6" cols="20" />
			<form:errors path="descricao" />
		</div>
		<div>
			<label>N. de Páginas:</label>
			<form:input path="paginas" />
			<form:errors path="paginas" />
		</div>
		<div>
			<label>Data Lançamento:</label>
			<form:input path="dataLancamento"/>
			<form:errors path="dataLancamento" />
		</div>
		
		<c:forEach items="${tipos }" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco }</label>
				<form:input path="precos[${status.index }].valor" />
				<form:hidden path="precos[${status.index }].tipo" value="${tipoPreco }" />
			</div>
		</c:forEach>
		
		<div>
			<label>Sumário:</label>
			<input type="file" name="sumario">
		</div>
		
		<button type="submit">Salvar</button>
	</form:form>
</body>
</html>