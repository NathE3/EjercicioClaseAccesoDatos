package TradadoArchivos.BasesDatos;

import java.sql.*;

public class ConectarseBD {

    public static void main(String[] args) {
        try {
            // Cargar el driver
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("org.sqlite.JDBC");
            //Class.forName("org.h2.Driver");
            //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection conexion = DriverManager.getConnection("jdbc:hsqldb:file:C:/Users/Vespertino/Desktop/cosas/hsqldb-2.7.4/hsqldb-2.7.4/hsqldb/data/Robin/Arkham","Batman","1234");


            //Establecemos la conexion con la BD a Access
            //Connection conexion = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Vespertino/Documents/Database1.accdb");

            //Establecemos la conexion con la BD a Access
            //Connection conexion = DriverManager.getConnection("jdbc:derby:D:/lol_champions;create=true'");

            // Establecemos la conexión con la BD de mysql
            //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/lol_champions", "root", "");

            // Establecemos la conexión con la BD de sqlite
            //Connection conexion = DriverManager.getConnection("jdbc:sqlite:D:\\BasesDatos\\lol_champions.db");

            // Establecemos la conexión con la BD de H2
            //Connection conexion = DriverManager.getConnection("jdbc:h2:D:\\H2\\lol_champions", "ethan","");

            // Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM departamentos";
            ResultSet resul = sentencia.executeQuery(sql);

            // Recorremos el resultado para visualizar cada fila
            // Se hace un bucle mientras haya registros y se van mostrando
            while (resul.next()) {
                System.out.printf("%d| %s| %s| %n",
                        resul.getInt(1),
                        resul.getString(2),
                        resul.getString(3));
            }

            System.out.println();

            sentencia = conexion.createStatement();
            sql = "SELECT * FROM empleados";
            ResultSet resultado = sentencia.executeQuery(sql);

            while (resultado.next()) {
                System.out.printf("%d| %s| %s|  %d | %s | %f | %f | %d | %n",
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getInt(4),
                        resultado.getDate(5),
                        resultado.getDouble(6),
                        resultado.getDouble(7),
                        resultado.getInt(8)

                );
            }

            // Cerrar ResultSet, Statement y conexión
            resul.close();
            sentencia.close();
            conexion.close();

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}