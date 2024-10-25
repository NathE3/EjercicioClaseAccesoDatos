package XMLEmpleado;

import java.io.Serializable;
import java.util.Objects;

public class Empleado implements Serializable {
        //Clase persona

        private String nombre;
        private int edad;
        private double salario;

        // Constructores:
        public Empleado(String nombre,int edad, double salario)
        {
            this.nombre=nombre;
            this.edad=edad;
            this.salario =salario;
        }

        public Empleado()
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
            return "Empleado: " + "nombre: " + nombre + '\'' +
                    ", edad: " + edad + ", salario" + salario;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Empleado empleado = (Empleado) o;
            return edad == empleado.edad && Objects.equals(nombre, empleado.nombre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombre, edad);
        }
    }//fin Persona

