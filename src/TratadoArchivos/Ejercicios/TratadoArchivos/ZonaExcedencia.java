package TratadoArchivos;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;


    public class ZonaExcedencia {
        static final int TAMREG = 114;
        Scanner teclado = new Scanner(System.in);

        public static void main(String[] args) throws IOException
        {
            ZonaExcedencia zonaExcedencia = new ZonaExcedencia();
            zonaExcedencia.menu();

        }

        public void menu() throws IOException
        {
            File archivo = new File("D://Aleatorio.dat");
            RandomAccessFile fichero = new RandomAccessFile(archivo, "rw");
            int opcion = 0;
            do
            {
                System.out.println("Elige una opción");
                System.out.println("1.Leer empleado según registro ");
                System.out.println("2.Borrar empleado");
                System.out.println("3.Añadir empleado");
                System.out.println("4. Actualizar empleado");
                System.out.println("5.Listar todos los empleados");
                System.out.println("6.Listar empleados");
                System.out.println("7.Salir");
                opcion = teclado.nextInt();
                teclado.nextLine();
                switch (opcion)
                {
                    case 1:

                        leerEmpleado(archivo, fichero);
                        break;

                    case 2:

                        borrarEmpleado(archivo, fichero);
                        break;

                    case 3:

                        añadirEmpleado(archivo, fichero);
                        break;

                    case 4:

                        actualizarEmpleado(archivo, fichero);
                        break;

                    case 5:

                        listarTodosEmpleados(fichero);
                        break;

                    case 6:
                        listarEmpleados(fichero);
                        break;

                    case 7:
                        break;

                    default:
                        System.out.println("Argumento no valido");
                }

            }
            while (opcion != 7);
        }

        public void leerEmpleado(File archivo, RandomAccessFile fichero) throws IOException {
            System.out.print("Dame el número de dni que quieres buscar: ");
            int dni = teclado.nextInt();
            teclado.nextLine();
            int dniBorrar = dni % 10;

            int posicionReal = dniBorrar * TAMREG;


            while (posicionReal < archivo.length()) {
                fichero.seek(posicionReal);
                int dni2 = fichero.readInt();
                String nombre = readString(fichero, 15);
                String apellido = readString(fichero, 30);
                int dep = fichero.readInt();
                double salario = fichero.readDouble();
                long km = fichero.readLong();

                if (dni == dni2) {
                    System.out.println("Empleado DNI: " + dni + ", Nombre: " + nombre.trim() + ", Apellido: " + apellido.trim() + ", Departamento: " + dep
                            + ", Salario: " + salario + ", Km: " + km);
                }else
                    {
                        posicionReal += TAMREG * 10;
                    }
            }
            if (posicionReal >= fichero.length()) {
                System.out.println("El registro no existe.");
                return;
            }
        }

        private String readString(RandomAccessFile archivo, int posicion) throws IOException
        {
            char[] chars = new char[posicion];
            for (int i = 0; i < posicion; i++)
            {
                chars[i] = archivo.readChar();
            }
            return new String(chars);
        }

        public void borrarEmpleado(File archivo, RandomAccessFile fichero) throws IOException
        {
            System.out.print("Dame el número de dni que quieres borrar: ");
            int dni = teclado.nextInt();
            teclado.nextLine();
            int dniBorrar = dni % 10;

            int posicionReal = dniBorrar * TAMREG;
            fichero.seek(posicionReal);

            if (posicionReal >= fichero.length())
            {
                System.out.println("El registro no existe.");
                return;
            }

            fichero.writeInt(-1);

            System.out.println();
        }

        public void crearZonaExcedencia(File archivo, RandomAccessFile fichero) throws IOException {

            fichero.seek(archivo.length());

            for (int i = 0; i < 10 ; i++)
            {
                fichero.writeInt(-1);
                StringBuffer buffer = new StringBuffer();
                buffer.setLength(15);
                fichero.writeChars(buffer.toString());

                StringBuffer buffer2 = new StringBuffer();
                buffer2.setLength(30);
                fichero.writeChars(buffer2.toString());

                fichero.writeInt(-1);
                fichero.writeDouble(-1);
                fichero.writeLong(-1);
            }
        }



        public void añadirEmpleado(File archivo, RandomAccessFile fichero) throws IOException {
            long puntero = 0;

            System.out.println("Dame el dni del empleado:");
            int dni = teclado.nextInt();
            teclado.nextLine();

            System.out.println("Dame el nombre del empleado:");
            String nombre = teclado.nextLine();
            StringBuffer buffer = null;

            System.out.println("Dame el apellido del empleado:");
            String apellido = teclado.nextLine();
            StringBuffer buffer2 = null;

            System.out.println("Dame el departamento del empleado:");
            int departamento = teclado.nextInt();

            System.out.println("Dame el salario del nuevo empleado:");
            double salario = teclado.nextDouble();

            System.out.println("Dame km del empleado:");
            long km = teclado.nextLong();

            int ultimoDig = dni % 10;
            puntero = (ultimoDig * TAMREG);

            while (puntero < archivo.length())
            {
                fichero.seek(puntero);
                int dniOcupado = fichero.readInt();

                if (dni == dniOcupado) {
                    System.out.println("Este dni ya existe");
                    break;

                }
                else if (dniOcupado == -1)
                {
                    fichero.seek(fichero.getFilePointer() - 4);
                    fichero.writeInt(dni);
                    buffer = new StringBuffer(nombre);
                    buffer.setLength(15);
                    fichero.writeChars(buffer.toString());

                    buffer2 = new StringBuffer(apellido);
                    buffer2.setLength(30);
                    fichero.writeChars(buffer2.toString());

                    fichero.writeInt(departamento);
                    fichero.writeDouble(salario);
                    fichero.writeLong(km);
                }
                else
                    {
                    puntero += TAMREG * 10;
                    if (puntero >= archivo.length())
                        {
                        crearZonaExcedencia(archivo, fichero);
                        }
                    }

            }
        }

        public void actualizarEmpleado(File archivo, RandomAccessFile fichero) throws IOException {
            System.out.print("Dame el número de dni que quieres actualizar: ");
            int dni = teclado.nextInt();
            teclado.nextLine();
            int dniBorrar = dni % 10;

            int posicionReal = dniBorrar * TAMREG;
            fichero.seek(posicionReal);
            int dniNuevo = fichero.readInt();


            while (posicionReal < archivo.length()) {

                 if (dni == dniNuevo) {

                    System.out.println("Dame el nombre del empleado :");
                    String nombre = teclado.nextLine();
                    StringBuffer buffer = null;

                    System.out.println("Dame el apellido del empleado :");
                    String apellido = teclado.nextLine();
                    StringBuffer buffer2 = null;

                    System.out.println("Dame el departamento del empleado :");
                    int departamento = teclado.nextInt();

                    System.out.println("Dame el salario del empleado :");
                    double salario = teclado.nextDouble();

                    System.out.println("Dame los km del  empleado :");
                    long km = teclado.nextInt();

                    fichero.seek(posicionReal);
                    fichero.skipBytes(4);
                    buffer = new StringBuffer(nombre);
                    buffer.setLength(15);
                    fichero.writeChars(buffer.toString());
                    buffer2 = new StringBuffer(apellido);
                    buffer2.setLength(30);
                    fichero.writeChars(buffer2.toString());
                    fichero.writeInt(departamento);
                    fichero.writeDouble(salario);
                    fichero.writeLong(km);
                } else {
                    fichero.seek(posicionReal += dniBorrar * TAMREG);
                }
                 if (posicionReal >= fichero.length())
                    {
                System.out.println("El registro no existe.");
                     }
            }

        }

        public void listarTodosEmpleados(RandomAccessFile fichero) throws IOException
        {
            fichero.seek(0);
            while (fichero.getFilePointer() < fichero.length())
            {
                int dni = fichero.readInt();
                String nombre = readString(fichero, 15);
                String apellido = readString(fichero, 30);
                int dep = fichero.readInt();
                double salario = fichero.readDouble();
                long km = fichero.readLong();
                if (true)
                {
                    System.out.println("Empleado DNI: " + dni + ", Nombre: " + nombre.trim() + ", Apellido: "+ apellido.trim() + ", Departamento: " + dep
                            + ", Salario: " + salario + ", Km: " + km);
                }
            }
        }

        public void listarEmpleados(RandomAccessFile fichero) throws IOException
        {
            fichero.seek(0);
            while (fichero.getFilePointer() < fichero.length())
            {
                int dni = fichero.readInt();
                String nombre = readString(fichero, 15);
                String apellido = readString(fichero, 30);
                int dep = fichero.readInt();
                double salario = fichero.readDouble();
                long km = fichero.readLong();
                if (dni != -1)
                {
                    System.out.println("Empleado DNI: " + dni + ", Nombre: " + nombre.trim() + ", Apellido: "+ apellido.trim() + ", Departamento: " + dep
                            + ", Salario: " + salario + ", Km: " + km);
                }
            }
        }

    }


