package TradadoArchivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class EjercicioClase
{
public static void main(String[]args) throws IOException {
File archivo = new File("D://Aleatorio.dat");	
RandomAccessFile fichero = new RandomAccessFile(archivo,"rw");

int[] posicion = {1,2,3,4};
String[] apellido = {"Rio","Torcal","Princich","San Martín"};
int[] dep = {1,2,3,4};
double[] salario = {1500.1,2000.0,3000.5,5000.0};
  

StringBuffer buffer = null;
int n = apellido.length;

for(int i = 0; i < n; i++) {
	
fichero.writeInt( i + 1);
buffer =new StringBuffer(apellido[i]);
buffer.setLength(10);
fichero.writeChars(buffer.toString());

fichero.writeInt(dep[i]);
fichero.writeDouble(salario[i]);
}
}
}