<!Doctype html>
<!-- directiva para importar clases-->
<%@page import="ar.com.codoacodo.domain.Producto"%>
<%@page import="java.util.List"%>
<html lang="es">
	<head>
		<jsp:include page="styles/styles.jsp"/>
	</head>
	<body class="bg-light">
		<jsp:include page="includes/navbar.jsp"/>
		<main class="container">
			
			<section class="row my-5 justify-content-center">
				<%List<Producto> list = (List<Producto>)request.getAttribute("productos");%>
				<%if (list.size() > 0) {%>
				<div class="col-2 bg-secondary bg-opacity-25 rounded text-center py-5 m-3">
					<p class="text-align-center">Cantidad de elemenos en la tabla</p>
					<h2><%=list.size()%></h2>
				</div>
				<div class="col-4 bg-secondary bg-opacity-25 rounded text-center p-5 m-3">
					<p class="text-align-center">T&iacute;tulo aleateorio</p>
						<h2 class="text-break"><%=list.get(((int) (Math.random() * list.size()))).getTitulo()%></h2>
				</div>
				<div class="col-4 bg-secondary bg-opacity-25 rouded text-center p-5 m-3">
				<p class="text-align-center text-break">&Uacute;ltimo elemento agregado</p>
					<h2 class="text-break"><%=list.get(list.size() - 1).getTitulo()%></h2>
				</div>
			</section>
			
			<section class="row">
				<div class="col">
					<button type="button" class="btn btn-primary bg-opacity-25" data-bs-toggle="modal" data-bs-target="#modalNuevoProducto">
	  					Agregar Producto
					</button>
					<jsp:include page="includes/modal-add.jsp"/>
				</div>
				
				<div class="col-4">
			    	<form class="d-flex"	
			    		 action="<%=request.getContextPath()%>/SearchProductosController">
			        	<input class="form-control me-2"
				        	name="claveBusqueda" 
				        	type="search" 
				        	placeholder="titulo de producto..." 
				        	aria-label="Search">
			       		<button class="btn btn-outline-success" type="submit">
			        		Buscar
			        	</button>
			     	</form>
			     </div>
			</section>
			
			<section class="container">
				<div class="row justify-content-center">
					
					<div class="row">
						<div class="col-4 offset-4 text-center align-middle">
							<jsp:include page="mensajeria.jsp"/>
						</div>
					</div>
			
				<%} else {%>
					<jsp:include page="includes/error.jsp"/>
				<%}%>
				
				<%for(Producto p : list) {
				int random = (int) (Math.random() * 100);
				if (random == 97 || random == 86) random = 1;%> <!-- En la API LoremPicsum faltan los ID 97 86 por lo cual se descartan -->
				<div class="card m-3 col-6" style="max-width: 480px;">
					<div class="row g-0 align-items-center">
						<div class="col-md-4">
							<img src="https://picsum.photos/id/<%=random%>/200/250" class="img-fluid" alt="..."> <!-- Utilizo random para elegir entre las primeras 100 imagenes -->
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">PRODUCTO ID <%=p.getId()%></h5>
								<ul>
									<li><%=p.getCodigo()%></li>
									<li><%=p.getTitulo()%></li>
									<li><%=p.getPrecio()%></li>
									<li><%=p.getFechaAlta()%></li>
									<li><%=p.getAutor()%></li>
								</ul>
								<div class="col text-end">
									
									<a class="btn btn-info bg-opacity-25 rounded-circle"
										role="button" href="<%=request.getContextPath()%>/EditarProductoController?id=<%=p.getId()%>">
										<i class="bi bi-check-circle fs-4"></i>
									</a>
									
			
									<button onclick="setProductoId(<%=p.getId()%>)" 
									type="button" class="btn btn-danger bg-opacity-25 rounded-circle"
									data-bs-toggle="modal" data-bs-target="#exampleModal">
	  									<i class="bi bi-x-circle fs-4"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%}%>
				</div>
			</section>
		</main>
			<jsp:include page="includes/footer.jsp"/>
		<!-- Modal -->
		<jsp:include page="includes/modal-delete.jsp"/>
		<jsp:include page="scripts/scripts.jsp"/>
		<script>
			function setProductoId(id) {
				document.getElementById('idProducto').value=id;
			}
		</script>
	</body>
	
</html>