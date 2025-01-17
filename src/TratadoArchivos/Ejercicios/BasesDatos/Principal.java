package TradadoArchivos.BasesDatos;


import java.sql.*;

public class Principal
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		//MYSQL
		Class.forName("com.mysql.jdbc.Driver");	
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "");
		
		//JDBC-ODBC NO FUNCIONA
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//Connection conexion = DriverManager.getConnection("jdbc:odbc:MiEjemplo");
		
		//SQLITE
		//Class.forName("org.sqlite.JDBC");
		//Connection conexion = DriverManager.getConnection("jdbc:sqlite:D:/snprincich/eclipse-workspace/AccesoDatos/ficheros_ejercicios/ej18_sqlite.db");
		
		//H2
		//Class.forName("org.h2.Driver");
		//Connection conexion = DriverManager.getConnection("jdbc:h2:~/Prueba3","sa","");
		
		//Access
		//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		//Connection conexion = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Vespertino/Documents/Prueba3.accdb");
		
		//DERBY
		//Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		//Connection conexion = DriverManager.getConnection("jdbc:derby:D:/snprincich/ad/db-derby-10.16.1.1-bin/bin/prueba99");
		
		//HSQLDB
		//Class.forName("org.hsqldb.jdbcDriver");
		//Connection conexion = DriverManager.getConnection("jdbc:hsqldb:file:D:\\snprincich\\ad\\hsqldb-2.7.4\\hsqldb\\data\\ejemplo\\prueba99");
		
		//String tipos[]= {"TABLE","VIEW"};
		DatabaseMetaData dbmd =  conexion.getMetaData();
		ResultSet result = dbmd.getTables("prueba", "prueba", null, null);
	
		while (result.next()) 
		{
			String catalogo = result.getString(1);//columna 1
			String esquema = result.getString(2); //columna 2
			String tabla = result.getString(3); //columna 3
			String tipo = result.getString(4); //columna 4
			System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			
			
		}
		System.out.println();
		
		/*Statement sentencia = conexion.createStatement();
		String sql = "SELECT * FROM departamentos";
		result = sentencia.executeQuery(sql);
	
		
		while (result.next()) 
		{
			System.out.printf("%d, %s, %s %n", result.getInt(1), result.getString(2), result.getString(3));
		}
		System.out.println();
		

		sql = "SELECT * FROM empleados";
		result = sentencia.executeQuery(sql);
		
		while (result.next()) 
		{
			System.out.printf("%4d, %10s, %15s, %4d, %10s, %8.2f, %8s, %2d %n", result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getFloat(6), result.getString(7), result.getInt(8));
		}*/
	}
}
