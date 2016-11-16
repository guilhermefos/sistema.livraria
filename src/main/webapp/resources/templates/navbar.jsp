<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/">Sistema
				de Livraria</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/editora/listarEditora">Pesquisa
						de Editora</a></li>
				<li><a href="<%=request.getContextPath()%>/categoria/listarCategoria">Pesquisa
						de Categoria</a></li>
				<li><a href="<%=request.getContextPath()%>/livro/pesquisar">Pesquisa
						de Livros</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>