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
	<div class="container">
		
		<form:form servletRelativeAction="/login" method="post" cssClass="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h2>Formulário de Login</h2>
				<s:url value="/produto" var="produto" />
				<div class="form-group">
					<label>Email:</label>
					<input type="text" name="username" class="form-control" />
				</div>
				<div class="form-group">
					<label>Senha:</label>
					<input type="password" name="password" class="form-control" />
				</div>
				
				<button type="submit" class="btn btn-primary">Entrar</button>
			</div>
			<div class="col-sm-4"></div>
		</form:form>
	</div>
</body>
</html>