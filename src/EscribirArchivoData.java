package TradadoArchivos;
import java.io.*;
public class EscribirArchivoData
{	
	  public static void main(String[] args) throws IOException
	  {   
	 
		  File fichero = new File("F:\\Ejercicios\\FichData.txt");
		  DataOutputStream dataOS = 
				  new DataOutputStream(new FileOutputStream(fichero));

	   String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andres",
	                       "Julio","Antonio","Maria Jesus"};
						   
	   int edades[] = {14,15,13,15,16,12,16,14,13};
		
	   for (int i=0;i<edades.length; i++)
	   {
	      dataOS.writeUTF(nombres[i]);
		  //dataOS.writeBytes(nombres[i]);
	      //dataOS.writeChars(nombres[i]); //inserta nombre (2 caracteres + nombre)
	      dataOS.writeInt(edades[i]);  //inserta edad (tipo int = 4 bytes)
	   }     
	   dataOS.close();  //cerrar stream 
	  }
}
