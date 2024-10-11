package TradadoArchivos;

public class CrearArchivoEjemplo
{
	public static void main(String[] args) throws IOException
	{
		File archivo = new File("D://Aleatorio.dat");
		RandomAccessFile fichero = new RandomAccessFile(archivo, "rw");

		int[] id = { 1, 2, 3, 4 };
		String[] apellido = { "Rio", "Torcal", "Princich", "San Martín" };
		String[] nombre = { "Paul", "Luis", "Nicolas", "Ethan" };
		int[] dep = { 1, 2, 3, 4 };
		double[] salario = { 1500.1, 2000.0, 3000.5, 5000.0 };
		long[] km = { 50, 60, 70, 80 };

		StringBuffer buffer = null;
		int n = apellido.length;

		for (int i = 0; i < n; i++)
		{

			fichero.writeInt(i + 1);
			buffer = new StringBuffer(nombre[i]);
			buffer.setLength(15);
			fichero.writeChars(buffer.toString());

			buffer2 = new StringBuffer(apellido[i]);
			buffer2.setLength(30);
			fichero.writeChars(buffer.toString());
			fichero.writeInt(dep[i]);
			fichero.writeDouble(salario[i]);
			fichero.writeLong(km[i]);
		}
	}
}
