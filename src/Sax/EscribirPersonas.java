package Sax;

import java.io.*;
import com.thoughtworks.xstream.XStream;

public class EscribirPersonas {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException, IOException
    {
        File fichero = new File("D://Aleatorio.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream datalS = new ObjectInputStream(filein);
        System.out.println("Comienza el proceso...");
        //Creamos un objeto Lista de Personas
        ListarPersona listaper = new ListarPersona();
        try {
            while (true)
            { //lectura del fichero
                Persona persona = (Persona) datalS.readObject();
                listaper.add(persona); //añadir persona a la lista
            }
        } catch (EOFException eo)
        {
        }
        datalS.close(); //cerrar stream de entrada
        try {
            XStream xstream = new XStream();
             //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaPersonasMunicipio", ListarPersona.class);
            xstream.alias("DatosPersona", Persona.class);
            //quitar etiqueta lista (atributo de la clase ListaPersonas)
            xstream.addImplicitCollection(ListarPersona.class, "lista");
            //Insertar los objetos en el XML
            xstream.toXML(listaper, new FileOutputStream("D://Personas.xml"));
            System.out.println("Creado fichero XML....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
