package TradadoArchivos.TratadoXML;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
public class TratarXml {

    // Creación de fichero XML con DOM
    /* DOM: Un procesador que utilice este planteamiento
     * utiliza toda la estructura del documento en memoria
     * en forma de árbol con nodos padre, nodos hijo y
     * nodos finales (que son aquellos que no tienen des-
     * cendientes). Una vez creado el árbol, se van reco-
     * rriendo los diferentes nodos y se analiza a qué ti-
     * po particular pertenecen. Tiene su origen en W3C.
     * Este tipo de procesamiento necesita más recursos de
     * memoria y tiempo, sobre todo si los ficheros XML a
     * procesar son bastante grandes y complejos.
     */
        public static void main(String args[]) throws IOException
        {
            File fichero = new File("D://Aleatorio.dat");
            RandomAccessFile file = new RandomAccessFile(fichero, "r");
            int  id, dep, posicion=0; //para situarnos al principio del fichero
            Double salario;
            char apellido[] = new char[10];
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try
            {
                DocumentBuilder builder = factory.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                // Etiqueta raíz o general:
                Document document = implementation.createDocument(null, "Empleados", null);
                // Versión XML:
                document.setXmlVersion("1.0");
                for(;;)
                {
                    // file.seek(posicion); // nos posicionamos
                    id=file.readInt();   // obtengo id de empleado
                    for (int i = 0; i < apellido.length; i++)
                    {
                        apellido[i] = file.readChar();
                    }
                    String apellidos = new String(apellido);
                    dep = file.readInt();
                    salario = file.readDouble();
                    if(id>0)
                    { //id válidos a partir de 1
                        // En el libro a empleado lo llama raiz, pero aquí lo llamaremos empleado
                        // Para que no se preste a confusión.
                        // En el libro hace: Element raiz...
                        // Pero para que no se preste a confusión haremos: Element empleado...
                        Element empleado = document.createElement("empleado"); //nodo empleado
                        document.getDocumentElement().appendChild(empleado);
                        //añadir ID
                        CrearElemento("id",Integer.toString(id), empleado, document);


                    {

                    }

                        //Apellido
                        CrearElemento("apellido",apellidos.trim(), empleado, document);
                        //añadir DEP
                        CrearElemento("dep",Integer.toString(dep), empleado, document);
                        //añadir salario
                        CrearElemento("salario",Double.toString(salario), empleado, document);
                        /*
                         * Pensar cómo añadir una etiqueta "extra"
                         * dentro de "empleado" con 2 o 3 subetiquetas:
                         * "subExtra1"
                         * "subExtra2"
                         */
                        Element extra = document.createElement("extra"); //damos valor
                        empleado.appendChild(extra); //pegamos el elemento hijo a la raiz
                        CrearElemento("subExtra1","",extra,document);
                        CrearElemento("subExtra2","",extra,document);
                    }
                    // posicion= posicion + 36; // me posiciono para el sig empleado
                    if (file.getFilePointer() >= file.length()) break;
                }//fin del for que recorre el fichero
                // FUENTE
                Source source = new DOMSource(document);
                // RESULTADO
                Result fresult =
                        new StreamResult(new File("D:\\CrearEmpleadoXml.xml"));
                Transformer transformer =
                        TransformerFactory.newInstance().newTransformer();
                // https://stackoverflow.com/questions/8085006/how-to-add-a-carriage-return-to-xml-output-in-java
                transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Para que el fichero XML tenga saltos de línea
                transformer.transform(source, fresult);
            }
            catch (Exception e)
            { System.err.println("Error: "+e); }
            file.close();  //cerrar fichero
        }//fin de main
        //Método para facilitar la inserción de los datos de cada empleado:
        static void  CrearElemento(String datoEmple, String valor, Element padre, Document document)
        {
            Element elem = document.createElement(datoEmple);
            Text text = document.createTextNode(valor); //damos valor
            padre.appendChild(elem); //pegamos el elemento hijo a la raiz
            elem.appendChild(text); //pegamos el valor
        }
    }//fin de la clase

