package Sax;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class LeerXML {
    public static void main(String[] args) {
        try {

            XStream xstream = new XStream();


            xstream.addPermission(AnyTypePermission.ANY);


            xstream.alias("ListaPersonasMunicipio", ListarPersona.class);
            xstream.alias("DatosPersona", Persona.class);
            xstream.aliasField("nombreAlumno", Persona.class, "nombre");
            xstream.aliasField("edadAlumno", Persona.class, "edad");


            xstream.addImplicitCollection(ListarPersona.class, "lista");


            try (FileInputStream fis = new FileInputStream("D://Personas.xml")) {

                ListarPersona listadoTodas = (ListarPersona) xstream.fromXML(fis);


                System.out.println("Numero de Personas: " + listadoTodas.getListarPersona().size());


                List<Persona> listaPersonas = listadoTodas.getListarPersona();
                Iterator<Persona> iterador = listaPersonas.listIterator();

                while (iterador.hasNext()) {
                    Persona p = iterador.next();
                    System.out.printf(p.toString());
                    System.out.println("Fin de listado");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encuentra: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
