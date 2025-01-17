package TradadoArchivos.TratadoXML;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

    public class LeerXML {

        public static void main(String[] args) {
            try {
                // Creación  de DocumentBuilderFactory
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();

                // Parsear el archivo XML y cargarlo en memoria
                Document document = builder.parse(new File("D:\\CrearEmpleadoXml.xml"));
                document.getDocumentElement().normalize(); // Normalizamos la estructura del documento

                // Obtener el nodo raíz (Empleados)
                Element raiz = document.getDocumentElement();
                System.out.println("Nodo raíz: " + raiz.getNodeName());

                // Obtener todos los nodos "empleado"
                NodeList listaEmpleados = document.getElementsByTagName("empleado");

                // Recorrer la lista de empleados
                for (int i = 0; i < listaEmpleados.getLength(); i++) {
                    Node nodo = listaEmpleados.item(i);

                    // Verificar que el nodo sea de tipo ELEMENT_NODE (un elemento)
                    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                        Element empleado = (Element) nodo;

                        // Leer los datos de cada empleado
                        String id = empleado.getElementsByTagName("id").item(0).getTextContent();
                        String apellido = empleado.getElementsByTagName("apellido").item(0).getTextContent();
                        String dep = empleado.getElementsByTagName("dep").item(0).getTextContent();
                        String salario = empleado.getElementsByTagName("salario").item(0).getTextContent();

                        // Mostrar la información del empleado
                        System.out.println("Empleado ID: " + id);
                        System.out.println("Apellido: " + apellido);
                        System.out.println("Departamento: " + dep);
                        System.out.println("Salario: " + salario);

                        // Leer y mostrar los datos de la etiqueta "extra"
                        Node extra = empleado.getElementsByTagName("extra").item(0);
                        if (extra != null && extra.getNodeType() == Node.ELEMENT_NODE) {
                            Element extraElement = (Element) extra;
                            String subExtra1 = extraElement.getElementsByTagName("subExtra1").item(0).getTextContent();
                            String subExtra2 = extraElement.getElementsByTagName("subExtra2").item(0).getTextContent();

                            // Mostrar la información adicional
                            System.out.println("Extra:");
                            System.out.println("  SubExtra1: " + subExtra1);
                            System.out.println("  SubExtra2: " + subExtra2);
                        }
                        System.out.println("----------------------------");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


