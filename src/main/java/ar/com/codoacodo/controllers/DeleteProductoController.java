package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;

@WebServlet("/DeleteProductoController")
public class DeleteProductoController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long id = Long.parseLong(req.getParameter("idProducto"));

		IProductoDAO dao = new ProductoDAOMysqlImpl();

		try {
			dao.delete(id);
			req.setAttribute("success", List.of("Se he eliminado el producto con id:" + id));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("erorrs", List.of("NO se he eliminado el producto :" + e.getMessage()));
		}
		getServletContext().getRequestDispatcher("/FindAllProductoController").forward(req, resp);
	}
}