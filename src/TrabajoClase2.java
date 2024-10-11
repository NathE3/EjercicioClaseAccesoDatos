package TradadoArchivos;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EjercicioParaNota2
{

	Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		EjercicioParaNota ejercicioParaNota = new EjercicioParaNota();
		ejercicioParaNota.menu();

	}

	public void menu() throws IOException
	{
		File archivo = new File("D://Aleatorio.dat");
		RandomAccessFile fichero = new RandomAccessFile(archivo, "rw");
		int opcion = 0;
		do
		{
			System.out.println("Elige una opción");
			System.out.println("1.Leer empleado según DNI ");
			System.out.println("2.Borrar empleado");
			System.out.println("3.Añadir empleado");
			System.out.println("4. Actualizar empleado");
			System.out.println("5.Listar todos los empleados");
			System.out.println("6.Listar un empleado en particular");
			System.out.println("7.Listar al reves los empleados");
			System.out.println("8.Salir");
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


				listarTodosEmpleados(fichero);
				break;
				
			case 4:
				break;

			default:
				System.out.println("Argumento no valido");
			}

		}
		while (opcion != 8);
	}

	public void leerEmpleado(File archivo, RandomAccessFile fichero) throws IOException
	{
		System.out.print("Dame el número de DNI que quieres buscar: ");
		double dni = teclado.nextInt();
		double posicionReal = (posicion - 1) * 114;

		if (posicionReal >= fichero.length())
		{
			System.out.println("El registro no existe.");
			return;
		}

		fichero.seek(posicionReal);
		long id = fichero.readInt();
		String nombre = readString(fichero, 15);
		String apellido = redString(fichero,30);
		int dep = fichero.readInt();
		double salario = fichero.readDouble();
		long kilometros = fichero.readLong();

		System.out.println("Empleado ID: " + id + ", Nombre: " + apellido.trim() + ", Apellido: " + apellido
				+ ", Dep: " + dep + ", Salario: " + salario + ", Km: " + kilometros);
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
		System.out.print("Dame el número de registro que quieres borrar: ");
		int posicion = teclado.nextInt();
		int posicionReal = (posicion - 1) * 36;

		if (posicionReal >= fichero.length())
		{
			System.out.println("El registro no existe.");
			return;
		}

		fichero.seek(posicionReal);
		fichero.writeInt(-1);

		System.out.println();
	}

	public void añadirEmpleado(File archivo, RandomAccessFile fichero) throws IOException
	{
		long posicion = archivo.length() - 36;
		fichero.seek(posicion);
		int id = fichero.readInt();
		fichero.seek(archivo.length());
		fichero.writeInt(Math.abs(id) + 1);

		System.out.println("Dame el apellido del empleado:");
		String apellido = teclado.nextLine();
		StringBuffer buffer = null;

		System.out.println("Dame el departamento del empleado:");
		int departamento = teclado.nextInt();

		System.out.println("Dame el salario del nuevo empleado:");
		double salario = teclado.nextDouble();

		buffer = new StringBuffer(apellido);
		buffer.setLength(10);
		fichero.writeChars(buffer.toString());
		fichero.writeInt(departamento);
		fichero.writeDouble(salario);
	}


	public void listarTodosEmpleados(RandomAccessFile fichero) throws IOException
	{
		fichero.seek(0);
		while (fichero.getFilePointer() < fichero.length())
		{
			int id = fichero.readInt();
			String apellido = readString(fichero, 10);
			int dep = fichero.readInt();
			double salario = fichero.readDouble();
			if (id > 0)
			{
				System.out.println("Empleado ID: " + id + ", Apellido: " + apellido.trim() + ", Departamento: " + dep
						+ ", Salario:" + salario);
			}
		}
	}

	

	
}
