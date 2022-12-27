<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
    	<form action="<%=request.getContextPath()%>/DeleteProductoController">
    	  <input type="hidden" name="idProducto" id="idProducto">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Eliminar Producto</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        Confirma que desea eliminar? 
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Eliminar</button>
	      </div>
    	</form>
    </div>
  </div>
</div>