package XMLEmpleado;

import Sax.MiObjectOutputStream;
import Sax.Persona;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirArchivoEmpleado {

    public static void main(String[] args) throws IOException
    {

        Persona persona; //define el objeto/variable persona

        File fichero = new File("D://Empleado.dat");//declara el fichero

        //*
        //FileOutputStream fileout = new FileOutputStream(fichero,true); //crea el flujo de salida
        FileOutputStream fileout;
        //FileOutputStream fileout = new FileOutputStream("F:\\Ejercicios\\1-19-EscribirFichObject-FichPersona.txt",true);

   /*
   //conecta el flujo de bytes al flujo de datos
   ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
   */

        ObjectOutputStream dataOS;
        ///* Nuevo bloque
        {
            if (!fichero.exists())
            {
                fileout = new FileOutputStream(fichero,true); //crea el flujo de salida
                dataOS = new ObjectOutputStream(fileout);
                System.out.println("NO Existe");
            }
            else
            {
                fileout = new FileOutputStream(fichero,true); //crea el flujo de salida
                dataOS = new MiObjectOutputStream(fileout);
                System.out.println("Existe");
            }
        }
        //*/

        String nombres[] = {"Ethan","Nicolas","Martin","Hugo","Manuel","Andres",
                "Julio","Antonio","Maria Jesus"};

        int edades[] = {30,60,22,25,27,31,21,19,18};

        double salarios[] = {1500,6000,2500,1200,4000,6000,3000,2000,1000};

        System.out.println("COMIENZA A GRABAR LOS DATOS DE LAS PERSONAS.");

        for (int i=0;i<edades.length; i++)
        { //recorre los arrays para asignar los datos al array de personas.
            Empleado empleado = new Empleado(nombres[i],edades[i],salarios[i]); //creo la persona
            dataOS.writeObject(empleado); //escribo la persona en el fichero
            System.out.println("GRABA LOS DATOS DE LOS EMPLEADOS "+(i+1));

        }

        dataOS.close();  //cerrar stream de salida
    }
}
