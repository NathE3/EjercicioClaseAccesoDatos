package TradadoArchivos.XMLEmpleado;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class LeerEmpleadoXML {

        public static void main(String[] args) {
            try {

                XStream xstream = new XStream();


                xstream.addPermission(AnyTypePermission.ANY);


                xstream.alias("ListaEmpleados", ListaEmpleado.class);
                xstream.alias("DatosEmpleados", Empleado.class);

                xstream.aliasField("nombreEmpleado", Empleado.class,"nombre");
                xstream.aliasField("edadEmpleado", Empleado.class,"edad");
                xstream.aliasField("salarioEmpleado", Empleado.class, "salario");


                xstream.addImplicitCollection(ListaEmpleado.class, "lista");


                try (FileInputStream fis = new FileInputStream("D://Empleado.xml")) {

                   ListaEmpleado listarEmpleados = (ListaEmpleado) xstream.fromXML(fis);


                    System.out.println("Numero de Empleado: " + listarEmpleados.getListarEmpleado().size());


                    ArrayList<Empleado> listaPersonas = listarEmpleados.getListarEmpleado();

                    //Iterator<Empleado> iterador = listaPersonas.listIterator();

                    //while (iterador.hasNext()) {
                      // Empleado e = iterador.next();
                        //System.out.printf(e.toString());
                        //System.out.println(" Fin de listado");
                    //}

                    for(Empleado e: listaPersonas)
                        {
                            System.out.println(e.toString());

                        }
                    System.out.println(" Fin de listado");
                }
            } catch (FileNotFoundException e) {
                System.out.println("El archivo no se encuentra: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

