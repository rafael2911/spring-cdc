<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

	<header id="layout-header">
		<div class="clearfix container">
			<a href='<c:url value="/produto/form" />' id="logo"> </a>
			<div id="header-content">
				<nav id="main-nav">
					<ul class="clearfix">
						<security:authorize access="isAuthenticated()">
							<li><a href='<s:url value="/produto" />' rel="nofollow">Listagem de Produtos</a></li>
						</security:authorize>
						<security:authorize access="hasRole('ROLE_ADMIN')">
    						<li><a href='<s:url value="/produto/form" />' rel="nofollow">Cadastro de Produtos</a></li>
    					</security:authorize>
						
						<li><a href='<s:url value="/carrinho" />' rel="nofollow">
							<s:message code="menu.carrinho" arguments="${carrinhoCompras.quantidade }" />
						</a></li>
						<li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">
							<fmt:message key="menu.sobre" />
						</a></li>
						<li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>

	<nav class="categories-nav">
		<ul class="container">
			<li class="category"><a href="http://www.casadocodigo.com.br">
				<fmt:message key="navegacao.categoria.home" />
			</a></li>
			<li class="category"><a href="/collections/livros-de-agile">
				<fmt:message key="navegacao.categoria.agile" />
			</a></li>
			<li class="category"><a href="/collections/livros-de-front-end">
				<fmt:message key="navegacao.categoria.front_end" />
			</a></li>
			<li class="category"><a href="/collections/livros-de-games">
				<fmt:message key="navegacao.categoria.games" />
			</a></li>
			<li class="category"><a href="/collections/livros-de-java">
				<fmt:message key="navegacao.categoria.java" />
			</a></li>
			<li class="category"><a href="/collections/livros-de-mobile">
				<fmt:message key="navegacao.categoria.mobile" />
			</a></li>
			<li class="category"><a href="/collections/livros-desenvolvimento-web">
				<fmt:message key="navegacao.categoria.web" />
			</a></li>
			<li class="category"><a href="/collections/outros">
				<fmt:message key="navegacao.categoria.outros" />
			</a></li>
		</ul>
	</nav>