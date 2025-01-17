package TratadoArchivos;

import java.io.*;
public class LeerFichObject
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Persona persona; 
        File fichero = new File("F:\\Ejercicios\\1-19-EscribirFichObject-FichPersona.txt");
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
        int i = 1;
        try
        {
            while (true) 
            { 
                persona = (Persona) dataIS.readObject(); 
                System.out.print(i + "=>");
                i++;
                System.out.printf("Nombre: %s, edad: %d %n",
                        persona.getNombre(),persona.getEdad());
            }
        } 
        catch (EOFException eo) 
        {
            System.out.println("FIN DE LA LECTURA.");
        } 
        catch (StreamCorruptedException x) 
        {
            System.out.println("HUBO ERRORES DE LECTURA.");
        }
        dataIS.close(); 
    }
}
