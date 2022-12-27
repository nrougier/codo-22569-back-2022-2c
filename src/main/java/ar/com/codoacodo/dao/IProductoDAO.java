package ar.com.codoacodo.dao;

import java.util.List;

import ar.com.codoacodo.domain.Producto;

public interface IProductoDAO {

	/*define los metodos de acceso a la tabla PRODUCTOS*/
	/*CRUD*/
	public Producto getById(Long id) throws Exception;
	//select * from producto where id = id
	
	public List<Producto> findAll() throws Exception;
	//select * from producto
	
	public void delete(Long id) throws Exception;
	//delete from producto where id = id
	
	public void update(Producto producto) throws Exception;
	//update producto 
	//set campo1 = valor1.....
	//where id = producto.id
	
	public void create(Producto newProduct) throws Exception;
	//insert into producto (campo1, ....m campoN)
	//values(newProducto.campo1, ...newProducto.campoN)

	//select * from producto where titulo like '%clave%' 
	public List<Producto> search(String clave) throws Exception;
	
}