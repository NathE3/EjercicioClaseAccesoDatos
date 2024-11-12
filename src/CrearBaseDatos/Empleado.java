package TradadoArchivos.CrearBaseDatos;

public class Empleado {

    String nombre;
    String apellido;
    Integer edad;

    public Empleado(String nombre, String apellido, Integer edad)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Empleado(){};

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}