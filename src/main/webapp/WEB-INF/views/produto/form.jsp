<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
		
		<button type="submit">Salvar</button>
	</form>
</body>
</html>