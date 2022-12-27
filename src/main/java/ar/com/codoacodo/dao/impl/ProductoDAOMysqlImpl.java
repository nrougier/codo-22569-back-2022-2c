package ar.com.codoacodo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.dao.IProductoDAO;
import ar.com.codoacodo.db.AdministradorDeConexiones;
import ar.com.codoacodo.domain.Producto;

public class ProductoDAOMysqlImpl implements IProductoDAO {

	@Override
	public Producto getById(Long id) throws Exception {

		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM PRODUCTO WHERE ID = " + id;
		Statement statement = connection.createStatement();

		// 3 - resultset
		ResultSet resultSet = statement.executeQuery(sql);

		// verifico si hay datos
		if (resultSet.next()) {
			Producto p = this.crearProducto(resultSet);
			cerrar(connection);
			return p;
		}
		
		// flata cerrar la connection!!!
		return null;
	}

	private void cerrar(Connection con) throws Exception{
		con.close();
	}
	
	@Override
	public List<Producto> findAll() throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM PRODUCTO";
		Statement statement = connection.createStatement();

		// 3 - resultset
		ResultSet resultSet = statement.executeQuery(sql);

		// Interface i = new ClaseQueImplementaLaInterface();
		List<Producto> productos = new ArrayList<Producto>();

		// verifico si hay datos
		while (resultSet.next()) {
			productos.add(this.crearProducto(resultSet));
		}
		
		cerrar(connection);
		
		return productos;
	}

	@Override
	public void delete(Long id) throws Exception{
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "DELETE FROM PRODUCTO WHERE ID="+id;
		Statement statement = connection.createStatement();

		// 3 - resultset
		int eliminado = statement.executeUpdate(sql);//1 o 2
		
		cerrar(connection);
		System.out.println(eliminado);
	}

	@Override
	public void update(Producto producto) throws Exception {
		
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "UPDATE PRODUCTO set titulo=?, precio=?, autor=?, img=? WHERE id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		//cambiar los ? por el tipo de dato y su valor
		statement.setString(1,producto.getTitulo());
		statement.setDouble(2,producto.getPrecio());
		statement.setString(3,producto.getAutor());
		statement.setString(4,producto.getImg());
		statement.setLong(5,producto.getId());
		
		statement.execute();
		
		cerrar(connection);
	}

	@Override
	public void create(Producto producto) throws Exception {//alt+shift+r
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement															  1 2 3 4 5 6
		String sql = "INSERT INTO PRODUCTO (codigo,titulo,precio,fecha_alta,autor,img) values(?,?,?,?,?,?)" ;
		
		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		//cambiar los ? por el tipo de dato y su valor
		statement.setString(1,producto.getCodigo());
		statement.setString(2,producto.getTitulo()); 
		statement.setDouble(3,producto.getPrecio());
		statement.setDate(4, new java.sql.Date(producto.getFechaAlta().getTime()));
		statement.setString(5,producto.getAutor());
		statement.setString(6,producto.getImg());
		
		statement.execute();
		
		ResultSet res = statement.getGeneratedKeys();//me retorna la clave generada
		
		if(res.next()) {
			producto.setId(res.getLong(1));
		}
		
		cerrar(connection);
	}

	private Producto crearProducto(ResultSet resultSet) throws Exception {
		// obtengo el dato del campo id
		Long idDb = resultSet.getLong("id");
		String codigo = resultSet.getString("codigo");
		String titulo = resultSet.getString("titulo");
		Double precio = resultSet.getDouble("precio");
		Date fechaAlta = resultSet.getDate("fecha_alta");
		String autor = resultSet.getString("autor");
		String img = resultSet.getString("img");

		return new Producto(idDb, codigo, titulo, precio, fechaAlta, autor, img);
	}

	@Override
	public List<Producto> search(String clave) throws Exception {
		// 1 - necesito la Connection
		Connection connection = AdministradorDeConexiones.getConnection();

		// 2 - arma el statement
		String sql = "SELECT * FROM PRODUCTO WHERE TITULO LIKE ?";
		PreparedStatement statement = connection.prepareStatement(sql);

		//setear el valor que va en remplazo del ?
		statement.setString(1, "%" + clave + "%");
		
		// 3 - resultset
		ResultSet resultSet = statement.executeQuery();

		// Interface i = new ClaseQueImplementaLaInterface();
		List<Producto> productos = new ArrayList<Producto>();

		// verifico si hay datos
		while (resultSet.next()) {
			productos.add(this.crearProducto(resultSet));
		}
		
		cerrar(connection);
		
		return productos;
	}
}