package TradadoArchivos.BasesDatos;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.Scanner;

public class ModificarBD
{
    static String BDPer = "DBEmpleados.yap";
    static Scanner tc = new Scanner(System.in);

    public static void main(String[] args) {
        Integer edad;
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);

        System.out.println("Dame el nombre por el que quieres filtrar");
        String nombre = tc.nextLine();

        System.out.println("Pulsa enter si no quieres buscar por apellido");
        String apellido = tc.nextLine();

        System.out.println("Pulsar enter si no quieres buscar por edad");
        String edad1 = tc.nextLine();

        if (apellido.equals("")) {
            apellido = null;
        }

        if(nombre.equals(""))
        {
            nombre = null;
        }

        if(edad1.equals("") )
        {
            edad1 = null;
            edad =null;
        }else
        {
            edad = Integer.parseInt(edad1);
        }


        Empleado per = new Empleado(nombre, apellido, edad);
        ObjectSet<Empleado> result = db.queryByExample(per);
        if (result.size() == 0)
            System.out.println("No existen Registros de Personas..");
        else {
            System.out.printf("Número de registros: Id %n", result.size());
            while (result.hasNext()) {
                Empleado e = result.next();

                System.out.println("Dame el nombre si lo quieres modificar");
                String nombreModificado = tc.nextLine();
                System.out.println("Dame el apellido si lo quieres modificar");
                String apellidoModificado = tc.nextLine();
                System.out.println("Dame la edad si la quieres modificar");
                String edadModificada = tc.nextLine();

                if(nombreModificado != null)
                {
                    e.setNombre(nombreModificado);
                }else
                    {
                        e.setNombre(e.getNombre());
                    }

                if(apellidoModificado != null)
                {
                    e.setApellido(apellidoModificado);
                }else
                    {
                        e.setApellido(e.getApellido());
                    }
                if(edad != null)
                {
                    e.setEdad(Integer.parseInt(edadModificada));
                }else
                    {
                        e.setEdad(e.getEdad());
                    }
                db.store(e);
                System.out.println("Nombre: " + e.getNombre() + " Apellido: " + e.getApellido() + " Edad: " + e.getEdad());
            }
        }
        db.close(); // cerrar base de datos
    }
}
