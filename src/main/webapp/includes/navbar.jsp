<div class="bg-white px-1">
	<nav class="navbar navbar-expand-lg bg-light bg-white px-4">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="<%=request.getContextPath()%>/index.jsp"> <img alt=""
				src="img/logo.png" height="48" class="d-inline-block align-text-top">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						aria-current="page" href="<%=request.getContextPath()%>/nuevo.jsp">Nuevo
							Producto</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/FindAllProductoController">Listado</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</div>