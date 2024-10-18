package TratadoArchivos;

import java.io.File;

public class ArbolCarpetas {

	public static void main(String[]args) {
		{
			String dir = ".";
			File f = new File(dir);
		   
			if(!f.exists()){
				System.out.println("El archivo no existe");
				System.exit(1);
			}
			else { 
				if(!f.isDirectory()){
			
				System.out.println("No es una carpeta");
				System.exit(1);
			}else {
				ArbolCarpetas arbolCarpetas = new ArbolCarpetas();
				arbolCarpetas.listar(f);
				
			}
			}
		}
		
		}
	
			public void listar(File f) {
		   File archivos[]= f.listFiles();
			System.out.printf("ficheros en el directorio actual %d %n", archivos.length);	
				for(int i = 0; i < archivos.length; i++) {
					if(archivos[i].isDirectory()) {
						listar(archivos[i]);
					}
					System.out.printf("Nombre: "+archivos[i].getName()+", ¿es fichero?: %b, ¿es directorio?: %b %n", archivos[i], archivos[i].isFile(), f.isDirectory());
				}
				
			}
	}
		
	
		
	

	
	
