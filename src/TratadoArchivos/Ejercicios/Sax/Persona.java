package TradadoArchivos.Sax;
import java.io.Serializable;
import java.util.Objects;

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

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Persona persona = (Persona) o;
            return edad == persona.edad && Objects.equals(nombre, persona.nombre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombre, edad);
        }
    }//fin Persona

