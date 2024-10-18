package TratadoArchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeerArchivo
{
public static void main(String[]args)
 {
 File f1 = new File("D:\\PrincisichEsUnHuevon.txt"); 	
 BufferedWriter escribir = null;
 BufferedReader leer = null;
 try {
	   if(!f1.exists())
	   {
		 f1.createNewFile();
		 System.out.println("Pablo se cree KanekiKun");
	   }
	 
	   else 
	   {
	    System.out.println("SHOTTTTTTAAAAAAM");	 
	   }	
	 

	   
	    escribir = new BufferedWriter(new FileWriter(f1));
		if(f1.canWrite()) 
		  {
			 escribir.write("Carlos es un cono que solo coge rebotes");
		  }
	
	 
	    leer = new BufferedReader(new FileReader(f1));
		 String linea;
		  while((linea = leer.readLine())!= null)
		  {
			 System.out.println(linea);
		  }
         }catch(IOException exception) {
	    	 System.out.println("Sukaaaaaa");
	     }
         finally 
		 {
        	 if(leer != null){
        	  try {
				leer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	 
        	 } 
        	 
        	 if(escribir != null){
        	  try {
				escribir.close();
			      } catch (IOException e) {
				         e.printStackTrace();
			                         }	 
        	                     }  
        	 
	 }
 }
}
	 
     
	 
		 
	 
 
 

