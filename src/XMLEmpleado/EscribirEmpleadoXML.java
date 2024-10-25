package XMLEmpleado;

import com.thoughtworks.xstream.XStream;
import java.io.*;

public class EscribirEmpleadoXML
{
    public static void main(String[] args) throws IOException,
            ClassNotFoundException, IOException
    {
        File fichero = new File("D://Empleado.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream datalS = new ObjectInputStream(filein);
        System.out.println("Comienza el proceso...");
        //Creamos un objeto Lista de Empleado
        ListaEmpleado listaEmpleado = new ListaEmpleado();
        try {
            while (true)
            { //lectura del fichero
                Empleado empleado = (Empleado) datalS.readObject();
                listaEmpleado.add(empleado); //añadir persona a la lista
            }
        } catch (EOFException eo)
        {
        }
        datalS.close(); //cerrar stream de entrada
        try {
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaEmpleados", ListaEmpleado.class);
            xstream.alias("DatosEmpleados", Empleado.class);

            xstream.aliasField("nombreEmpleado", Empleado.class,"nombre");
            xstream.aliasField("edadEmpleado", Empleado.class,"edad");
            xstream.aliasField("salarioEmpleado", Empleado.class, "salario");
            //quitar etiqueta lista (atributo de la clase ListaPersonas)
            xstream.addImplicitCollection(ListaEmpleado.class, "lista");
            //Insertar los objetos en el XML
            xstream.toXML(listaEmpleado, new FileOutputStream("D://Empleado.xml"));
            System.out.println("Creado fichero XML....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
