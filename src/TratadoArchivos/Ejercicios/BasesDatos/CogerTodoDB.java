package TradadoArchivos.BasesDatos;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CogerTodoDB {

    private String db_name;
    private Class clase;
    private Connection conexion;
    private DatabaseMetaData dbmd;

    public CogerTodoDB()
    {
        try
        {
            this.db_name = "prueba";

            this.clase = Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + db_name, "root", "");
            this.dbmd = conexion.getMetaData();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        CogerTodoDB app = new CogerTodoDB();

        HashMap<String,String> nombresTablas = app.getTablesNames();

        try {

            DatosBaseDatos(app.dbmd);
            for(Map.Entry<String,String> entry : nombresTablas.entrySet())
            {
                System.out.printf(entry.getValue() + "- Catalogo: %s, Esquema: %s, Nombre: %s%n",
                        app.db_name, null, entry.getKey());
            }

            System.out.println();

            for (Map.Entry<String,String> entry : nombresTablas.entrySet())
            {

                System.out.printf("COLUMNAS DE LA %s '%s':%n", entry.getValue(),entry.getKey());
                System.out.println("=======================================");

                TipoDatosTabla(entry.getKey(), app.conexion);

                System.out.println();

                DatosTabla(entry.getKey(), app.conexion);

                String pkTab = getTipoClave(app.dbmd.getPrimaryKeys(null, "prueba", entry.getKey()), "COLUMN_NAME");

                String pkTab2 = getTipoClave(app.dbmd.getExportedKeys(null, "prueba", entry.getKey()), "FKTABLE_NAME");

                String pkTab3 = getTipoClave(app.dbmd.getImportedKeys(null, "prueba", entry.getKey()), "PKTABLE_NAME");

                System.out.println("Clave Primaria: " + pkTab);
                System.out.println("Clave Foranea: " + pkTab2);
                System.out.println("Claves Importadas: " + pkTab3);

                System.out.println();
            }

            ResultSet proc = app.dbmd.getProcedures(null, app.db_name, null);

            while (proc.next())
            {
                String proc_name = proc.getString("PROCEDURE_NAME");
                String proc_type = proc.getString("PROCEDURE_TYPE");
                System.out.printf("Nombre Procedimiento: %s - Tipo: %s %n", proc_name, proc_type);
            }

            ResultSet funct = app.dbmd.getFunctions(null, app.db_name, null);
            while (funct.next()) {
                String funct_name = funct.getString("FUNCTION_NAME");
                String funct_type = funct.getString("FUNCTION_TYPE");
                System.out.printf("Nombre Funcion: %s - Tipo: %s %n", funct_name, funct_type);
            }


                app.conexion.close();

        }
        catch (SQLException e)
        {
            System.out.println("Error al interactuar con la base de datos.");
            e.printStackTrace();
        }
    }

    private static void TipoDatosTabla(String tabla, Connection conexion) throws SQLException
    {
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabla + " LIMIT 1");

        ResultSetMetaData rsMeta = rs.getMetaData();
        int columnCount = rsMeta.getColumnCount();

        for (int i = 1; i <= columnCount; i++)
        {
            String nombreColumna = rsMeta.getColumnName(i);
            String tipoColumna = rsMeta.getColumnTypeName(i);
            int tamanoColumna = rsMeta.getColumnDisplaySize(i);
            boolean esNula = rsMeta.isNullable(i) == ResultSetMetaData.columnNullable;

            System.out.printf("Columna: %s, Tipo: %s, Tamaño: %d, ¿Puede ser Nula?: %s%n",
                    nombreColumna, tipoColumna, tamanoColumna, esNula ? "Sí" : "No");
        }
    }

    private static void DatosTabla(String tabla, Connection conexion) throws SQLException {
        Statement stmt = conexion.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM " + tabla);

        ResultSetMetaData rsMeta = result.getMetaData();
        int columnCount = rsMeta.getColumnCount();
        while (result.next()) {
            StringBuilder row = new StringBuilder();
            for (int i = 1; i <= columnCount; i++) {

                row.append(result.getString(i)).append("");

                if(i != columnCount)
                {
                  row.append(",");
                }
            }
            System.out.println(row);
        }
    }

    private static String getTipoClave(ResultSet resultSet, String keyColumnName) throws SQLException {
        StringBuilder claves = new StringBuilder();
        String separador = "";
        while (resultSet.next()) {
            String clave = resultSet.getString(keyColumnName);
            claves.append(separador).append(clave);
            separador = "+";
        }
        return claves.toString().isEmpty() ? "No tiene claves" : claves.toString();
    }

    private HashMap<String, String> getTablesNames()
    {
        HashMap<String, String> tableNames = null;
        try {
            DatabaseMetaData dbmd = conexion.getMetaData();

            ResultSet resul = dbmd.getTables("prueba", null, null, new String[]{"TABLE", "VIEW"});
            tableNames = new HashMap<>();


            while (resul.next()) {
                String tabla = resul.getString(3);
                String tipo = resul.getString(4);
                tableNames.put(tabla, tipo);
            }


        } catch (SQLException e) {
            e.getMessage();
        }
        return tableNames;
    }

    private static void DatosBaseDatos(DatabaseMetaData dbmd)
    {
        try
        {
            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();
            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
            System.out.println("================================== ");
            System.out.printf("Nombre %s %n", nombre);
            System.out.printf("Driver %s %n", driver);
            System.out.printf("URL %s %n", url);
            System.out.printf("Usuario %s %n", usuario);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


