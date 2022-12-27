package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.dao.impl.ProductoDAOMysqlImpl;
import ar.com.codoacodo.domain.Producto;

@WebServlet("/CreateProductoController")
public class CreateProductoController extends BaseController {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");
		String precio = req.getParameter("precio");
		String fechaAlta = req.getParameter("fechaAlta");
		String autor = req.getParameter("autor");
		String img = req.getParameter("img");
		
		String modal = req.getParameter("modal");

		List<String> errores = new ArrayList<>();

		if (titulo == null || "".equals(titulo)) {
			errores.add("Campo titulo vacío");
		}
		if (codigo == null || "".equals(codigo)) {
			errores.add("Campo codigo vacío");
		}
		if (precio == null || "".equals(precio)) {
			errores.add("Campo precio vacío");
		}
		if (fechaAlta == null || "".equals(fechaAlta)) {
			errores.add("Campo fecha vacía");
		}
		if (autor == null || "".equals(autor)) {
			errores.add("Campo autor vacío");
		}

		if (!errores.isEmpty()) {
			req.setAttribute("errors", errores);
			//	Si la consulta NO viene desde el modal (0) else viene del modal		
			if(Integer.valueOf(modal) == 0) {
				super.irA("/nuevo.jsp", req, resp);
			} else {
				super.irA("/FindAllProductoController", req, resp);
			}
			return;
		}

		IProductoDAO dao = new ProductoDAOMysqlImpl();

		Producto newProducto = new Producto(codigo, titulo, Double.parseDouble(precio), new Date(), autor, img);

		try {
			dao.create(newProducto);
			req.setAttribute("success", List.of("Alta de producto exitosa"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		super.irA("/FindAllProductoController", req, resp);
	}
}