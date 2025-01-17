package TradadoArchivos.BasesDatos;

import java.sql.*;

public class MostrarTablas {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver

            // Establecemos la conexión con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/lol_champions", "root", "");
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet resul = null;

            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();

            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
            System.out.println(" ");
            System.out.printf("Nombre: %s%n", nombre);
            System.out.printf("Driver: %s%n", driver);
            System.out.printf("URL: %s%n", url);
            System.out.printf("Usuario: %s%n", usuario);

            // Obtener información de las tablas y vistas que hay
            resul = dbmd.getColumns(null, "lol_champions", null, null);

            while (resul.next()) {
                String id = resul.getString(1);  // Columna 1
                String nombret = resul.getString(2);   // Columna 2
                String rol = resul.getString(3);     // Columna 3
                String id_region = resul.getString(4);
                String dificultad = resul.getString(5); // Columna 4
                String historia = resul.getString(5); // Columna 4


                System.out.printf("%f - Nombre: %s, Rol: %s, Id_Region: %f, Dificultad: %s, Historia: %s%n", id, nombret, rol, id_region,dificultad,historia);
            }

            conexion.close(); // Cerrar conexión
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

