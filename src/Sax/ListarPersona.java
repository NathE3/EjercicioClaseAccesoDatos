package Sax;
import java.util.ArrayList;

public class ListarPersona
    {
        private ArrayList<Persona> lista = new ArrayList<>();

        public ListarPersona()
            {

            }

            public void add(Persona per)
                {
                lista.add(per);
                }

                public ArrayList<Persona> getListarPersona()
                    {
                    return lista;
                    }
    }

