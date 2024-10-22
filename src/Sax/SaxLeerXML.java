package Sax;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SaxLeerXML {

    public static void main(String[] args) throws SAXException, IOException {
        SaxLeerXML app = new SaxLeerXML();

        XMLReader leerXml = XMLReaderFactory.createXMLReader();
        GestionContenido gestor = app.new GestionContenido();
        leerXml.setContentHandler(gestor);
        InputSource archivoXML = new InputSource("D:\\empleadoXML.xml");
        leerXml.parse(archivoXML);
    }

    class GestionContenido extends DefaultHandler {

        public GestionContenido() {
            super();
        }

        @Override
        public void startDocument() {
            System.out.println("Comienzo del Documento XML");
        }

        @Override
        public void endDocument() {
            System.out.println("Final de documento XML");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) {
            System.out.printf("\tPrincipio Elemento: %s %n", localName); // Corrección del parámetro "nombre"
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.printf("\tFin Elemento: %s %n", localName); // Corrección del parámetro "nombre"
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String car = new String(ch, start, length);
            // Quitar saltos de línea y tabulaciones
            car = car.replaceAll("[\t\n]", "").trim(); // Añadir trim() para eliminar espacios en blanco alrededor
            if (!car.isEmpty()) { // Evitar imprimir líneas vacías
                System.out.printf("\tCaracteres: %s %n", car);
            }
        }
    }
}
