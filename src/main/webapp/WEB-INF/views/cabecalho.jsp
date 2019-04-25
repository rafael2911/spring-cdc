
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
						
						<li><a href='<s:url value="/carrinho" />' rel="nofollow">Carrinho</a></li>
						<li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre Nós</a></li>
						<li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>

	<nav class="categories-nav">
		<ul class="container">
			<li class="category"><a href="http://www.casadocodigo.com.br">Home</a></li>
			<li class="category"><a href="/collections/livros-de-agile"> Agile </a></li>
			<li class="category"><a href="/collections/livros-de-front-end"> Front End </a></li>
			<li class="category"><a href="/collections/livros-de-games"> Games </a></li>
			<li class="category"><a href="/collections/livros-de-java"> Java </a></li>
			<li class="category"><a href="/collections/livros-de-mobile"> Mobile </a></li>
			<li class="category"><a href="/collections/livros-desenvolvimento-web"> Web </a></li>
			<li class="category"><a href="/collections/outros"> Outros </a></li>
		</ul>
	</nav>