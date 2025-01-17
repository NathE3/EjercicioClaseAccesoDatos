package TradadoArchivos.XMLEmpleado;

import TradadoArchivos.Sax.Persona;

import java.util.ArrayList;

public class ListaEmpleado
    {
        private ArrayList<Empleado> lista = new ArrayList<>();

        public ListaEmpleado()
        {

        }

        public void add(Empleado empleado)
        {
            lista.add(empleado);
        }

        public ArrayList<Empleado> getListarEmpleado()
        {
            return lista;
        }
    }


