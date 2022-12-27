package ar.com.codoacodo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

	public static Connection getConnection() {

		String hosts = "127.0.0.1";
		String port = "3306";
		String password = "root";
		String username = "root";
		String dbName = "22569";
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://" + hosts + ":" + port + "/" + dbName + "?serverTimeZone=UTC&useSSL=false";

		Connection connection = null;

		try {
			
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println("algo faloo");
			connection = null;
		}

		return connection;
	}
}
