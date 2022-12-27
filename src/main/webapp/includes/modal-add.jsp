<div class="modal fade" id="modalNuevoProducto" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Agregar
					Producto</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<main class="container">
					<h1>Nuevo Producto</h1>
					<jsp:include page="../mensajeria.jsp" />
					<div class="row">
						<div class="col-12">
							<form class="row g-3 needs-validation" novalidate
								action="<%=request.getContextPath()%>/CreateProductoController"
								method="POST">
								<jsp:include page="create-product.jsp" />
								<input type="hidden" name="modal" value="1"> <!-- Input hidden para verificar que la consulta viene del modal  -->
								<div class="col-12">
									<button class="btn btn-primary" type="submit">Nuevo</button>
								</div>
							</form>
						</div>
					</div>
				</main>
			</div>
		</div>
	</div>
</div>
