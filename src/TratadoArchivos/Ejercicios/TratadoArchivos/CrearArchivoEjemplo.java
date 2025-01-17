package TratadoArchivos;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CrearArchivoEjemplo
{
	public static void main(String[] args) throws IOException
	{
		File archivo = new File("D://Aleatorio.dat");
		RandomAccessFile fichero = new RandomAccessFile(archivo, "rw");

		int[] id = { 11122331, 22299912, 33377723, 11177744};
		String[] apellido = { "Rio", "Torcal", "Princich", "San Martín"};
		double[] salario = { 1500.1, 2000.0, 3000.5, 5000.0};


		StringBuffer buffer = null;
		int n = apellido.length;


		for (int i = 0; i < n; i++)
		{

			fichero.writeInt(id[i]);
			buffer = new StringBuffer(apellido[i]);
			buffer.setLength(10);
			fichero.writeChars(buffer.toString());
			fichero.writeDouble(salario[i]);

		}
	}
}
