package TradadoArchivos;
import java.io.File;

public class Ejercicio2 {

	public static void main(String[] args) 
	{
	String dir = "C:\\Program Files (x86)";
	File f = new File(dir);
    File archivos[]=f.listFiles();
	
	System.out.printf("ficheros en el directorio actual %d %n", archivos.length);	
		for(int i = 0; i < archivos.length; i++) {
			System.out.printf("Nombre: "+archivos[i].getName()+", ¿es fichero?: %b, ¿es directorio?: %b %n", archivos[i], archivos[i].isFile(), f.isDirectory());
		}
		
	}
}

