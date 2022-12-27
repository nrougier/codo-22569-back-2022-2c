<!Doctype html>
<html>
<head>
<jsp:include page="styles/styles.jsp" />
</head>
<body>
	<jsp:include page="includes/navbar.jsp" />
	<main class="container">
		<h1>Nuevo Producto</h1>
		<jsp:include page="mensajeria.jsp" />
		<div class="row">
			<div class="col-12">
				<form class="row g-3 needs-validation" novalidate
					action="<%=request.getContextPath()%>/CreateProductoController"
					method="POST">
					<jsp:include page="includes/create-product.jsp" />
					<input type="hidden" name="modal" value="0">
					<!-- Input hidden para verificar si la consulta NO viene desde el modal -->
					<div class="col-12">
						<button class="btn btn-primary" type="submit">Nuevo</button>
					</div>
				</form>
			</div>
		</div>
	</main>
	<div class="fixed-bottom">
	<jsp:include page="includes/footer.jsp" />
	</div>
</body>
</html>