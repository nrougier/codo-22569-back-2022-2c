package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

public class UpdateProductoController {

	public static void main(String[] args) throws Exception {

		IProductoDAO dao = new ProductoDAOMysqlImpl();

		Long id = 10l;// existe
		Producto p = dao.getById(id);

		// actualizo los datos
		p.setImg("urldementirita");
		p.setAutor("Nuevo Autor");

		// vuelvo a grabar!
		dao.update(p);
	}

}
