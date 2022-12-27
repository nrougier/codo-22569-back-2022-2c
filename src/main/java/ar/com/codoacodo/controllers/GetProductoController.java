package ar.com.codoacodo.controllers;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

public class GetProductoController {

	public static void main(String[] args) {
		IProductoDAO dao = new ProductoDAOMysqlImpl();
		Long id = 1l;
		Producto p;

		try {
			p = dao.getById(id);
		} catch (Exception e) {
			p = null;
		}
		
		if (p != null) {
			System.out.println(p);
		} else {
			System.out.println("no existe la id: " + p);
		}
	}

}
