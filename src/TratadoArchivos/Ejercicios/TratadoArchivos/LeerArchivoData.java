package TratadoArchivos;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerArchivoData
{
	 public static void main(String[] args) throws IOException
	    {    
	        File fichero = new File("F:\\Ejercicios\\FichData.txt");
	        DataInputStream dataIS = new DataInputStream(new FileInputStream(fichero));
	        String n;
	        int e;
	       try
	       {
	        while (true) 
	        {
	            n = dataIS.readUTF(); 
	            e = dataIS.readInt(); 
	            System.out.println("Nombre: " + n +
	                    ", edad: " + e);        
	        }
	       } 
	       catch (EOFException eo) 
	       {
	           System.out.println("Fin del fichero");
	       }
	       dataIS.close();   
	  }
	}

