<%@page import="ar.com.codoacodo.domain.Producto"%>
<% Producto p = (Producto) request.getAttribute("producto"); %>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="styles/styles.jsp" />
  </head>
  <body>
    <jsp:include page="includes/navbar.jsp" />
    <main class="container">
      <h1>Editar Producto</h1>
      <jsp:include page="mensajeria.jsp" />
      <div class="row">
        <div class="col-12">
        <%if (p == null) {%>
        	<h2>ERROR</h2>
        	<%} else { %>
          <form
            class="row g-3 needs-validation"
            action="<%=request.getContextPath()%>/EditarProductoController"
            method="POST"
          >
            <input type="hidden" name="id" value="<%=p.getId()%>" />
            <div class="col-md-4">
              <label for="validationCustom01" class="form-label">
                C&oacute;digo
              </label>
              <input
                type="text"
                readonly="readonly"
                name="codigo"
                class="form-control"
                id="validationCustom01"
                value="<%=p.getCodigo()%>"
                required
                disabled
              />
              <div class="valid-feedback">Looks good!</div>
            </div>
            <div class="col-md-4">
              <label for="validationCustom02" class="form-label"
                >T&iacute;tulo</label
              >
              <input
                type="text"
                name="titulo"
                class="form-control"
                id="validationCustom02"
                value="<%=p.getTitulo()%>"
                required
              />
              <div class="valid-feedback">Looks good!</div>
            </div>
            <div class="col-md-4">
              <label for="validationCustom02" class="form-label">Precio</label>
              <input
                type="number"
                name="precio"
                class="form-control"
                id="validationCustom02"
                value="<%=p.getPrecio()%>"
                required
              />
              <div class="valid-feedback">Looks good!</div>
            </div>
            <div class="col-md-4">
              <label for="validationCustom03" class="form-label"
                >Fecha Alta</label
              >
              <input
                type="date"
                name="fechaAlta"
                readonly="readonly"
                class="form-control"
                id="validationCustom03"
                value="<%=p.getFechaAlta()%>"
                required
                disabled
              />
              <div class="invalid-feedback">Please provide a valid city.</div>
            </div>
            <div class="col-md-4">
              <label for="validationCustom04" class="form-label">Autor</label>
              <input
                type="text"
                name="autor"
                class="form-control"
                id="validationCustom03"
                value="<%=p.getAutor()%>"
                required
              />
              <div class="invalid-feedback">Please select a valid state.</div>
            </div>
            <div class="col-md-4">
              <label for="validationCustom05" class="form-label">Imagen</label>
              <div class="input-group">
                <input
                  type="file"
                  name="img"
                  class="form-control"
                  id="inputGroupFile04"
                  value="<%=p.getImg()%>"
                  aria-describedby="inputGroupFileAddon04"
                  aria-label="Upload"
                  disabled
                />
              </div>
              <div class="invalid-feedback">Please provide a valid zip.</div>
            </div>
            <div class="col-12">
              <button class="btn btn-primary" type="submit">Editar</button>
            </div>
          </form>
          <%}%>
        </div>
      </div>
    </main>
  </body>
</html>
