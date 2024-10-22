package Sax;
import java.io.Serializable;
public class Persona implements Serializable
    {
    //Clase persona

        private String nombre;
        private int edad;

        // Constructores:
        public Persona(String nombre,int edad)
        {
            this.nombre=nombre;
            this.edad=edad;
        }

        public Persona()
        {
            this.nombre=null;
        }
        // En java no se definen destructores como en C u otros lenguajes.

        public void setNombre(String nom){nombre=nom;}
        public void setEdad(int ed){edad=ed;}

        public String getNombre(){return nombre;}
        public int getEdad(){return edad;}
    }//fin Persona

