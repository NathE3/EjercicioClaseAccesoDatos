package TratadoArchivos;

import java.io.File;
import java.io.IOException;

public class CrearCarpeta 
{
public static void main(String[]args) 
 {
File d = new File("NuevoDir");
File f1 = new File("Fichero1.txt");
File f2 = new File("Fichero2.txt");

d.mkdir();	
	
try{
if(f1.createNewFile()) {
	System.out.println("Fichero 1 creado con exito");
	
                       }else {
                    	   System.out.println("El fichero no se ha podido crear");
                             }
if(f2.createNewFile()){
	System.out.println("Fichero 2 creado con exito");
                      }else {
                    	  System.out.println("El fichero 2 no se ha creado con exito");
                      }
	
   }catch(IOException ioe) {ioe.printStackTrace();}
	   f1.renameTo(new File(d,"FICHERONuevo"));
	   
	   try {
		   File f3 = new File("NUEVODIR/FICHERO3.TXT");
		   f3.createNewFile();
		   
	   }catch(IOException ioe) {ioe.printStackTrace();}
   }
 }



