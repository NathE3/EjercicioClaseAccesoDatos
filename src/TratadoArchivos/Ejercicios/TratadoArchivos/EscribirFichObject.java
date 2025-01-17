package TratadoArchivos;
import java.io.*;
public class EscribirFichObject
{
  public static void main(String[] args) throws IOException
  {  
   Persona persona; 
   File fichero = new File("F:\\Ejercicios","1-19-EscribirFichObject-FichPersona.txt");
   FileOutputStream fileout;
   ObjectOutputStream dataOS;

   {
       if (!fichero.exists())
       {
           fileout = new FileOutputStream(fichero,true); 
           dataOS = new ObjectOutputStream(fileout);
           System.out.println("NO Existe");
       }
       else
       {
           fileout = new FileOutputStream(fichero,true); 
           dataOS = new MiObjectOutputStream(fileout);
           System.out.println("Existe");
       }
   }
   //*/
   String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andres",
                       "Julio","Antonio","Maria Jesus"};
   int edades[] = {14,15,13,15,16,12,16,14,13};
   System.out.println("COMIENZA A GRABAR LOS DATOS DE LAS PERSONAS.");      
   for (int i=0;i<edades.length; i++)
   { 
      persona = new Persona(nombres[i],edades[i]);     
      dataOS.writeObject(persona); 
      System.out.println("GRABA LOS DATOS DE PERSONA "+(i+1));  
   }
   dataOS.close();  
}
}