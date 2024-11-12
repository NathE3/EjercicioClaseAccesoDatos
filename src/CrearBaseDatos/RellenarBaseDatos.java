package TradadoArchivos.CrearBaseDatos;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class RellenarBaseDatos {
    static String BDPer = "DBEmpleados.yap";
    public static void main(String[]args)

    {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
        // Se crean objetos Persona
        Empleado p1 = new Empleado("Juan", "Guadalajara",23);
        Empleado p2 = new Empleado("Ana", "Madrid",28);
        Empleado p3 = new Empleado("Luis", "Granada",54);
        Empleado p4 = new Empleado("Pedro", "Asturias",34);
        // Almacenar objetos Persona en la base de datos
        db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
        db.close(); // cerrar base de datos
    }// fin metodo main
}// fin de la clase Main


