import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		Creamos las variables.
		Scanner edd = new Scanner(System.in);
		int opcion = 0;
		int i = 0;
		int n=1;
		String ruta = "";
		String nombre = "";
		String apellido="";
		String ciudad="";
		String nacionalidad="";
		int edad =0;
		String lectura="";
		String buscar="";
// 		Creamos el menu con un bucle do While
		do {
			System.out.println("***************************************");
			System.out.println("***   GESTOR DE ARCHIVOS DE TEXTO   ***");
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.println("");
			System.out.println("");
			System.out.println("   1.- Alamcenar Personas.");
			System.out.println("   2.- Leer todo el archivo.");
			System.out.println("   3.- Buscar persona.");
			System.out.println("   0.- Salir.");
			opcion = edd.nextInt();
			edd.nextLine();
//			Cuando opcion es 1 creamos el documento y grabamos en el.
			if (opcion==1) {
				System.out.println("***   Escriba la ruta y el nombre del fichero a crear. ***");
				ruta = edd.nextLine();
//				Creamos el fichero.
				File f = new File(ruta);
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);
//				Comprovamos que el fichero exista.
				if (f.exists()) {
					System.out.println("***   Entrar datos persona   *** ");
					while (i<n) {
						i++;
						System.out.println("Introduzca el nombre nº " + i);
						nombre = edd.nextLine();
						System.out.println("Introduca el apellido nº " + i);
						apellido = edd.nextLine();
						System.out.println("Introduzca la ciudad nº " + i);
						ciudad = edd.nextLine();
						System.out.println("Introduzca la nacionalidad nº " + i);
						nacionalidad = edd.nextLine();
						System.out.println("Introduzca la edad nº " + i);
						edad = edd.nextInt();
//						Introducimos los datos en un objeto persona.						
						Persona p1 = new Persona(nombre,apellido,ciudad,nacionalidad,edad);
//						Introducimos los datos en el archivo.
						pw.println(p1.print());
//						Cerramos los objetos Fw y pw.
						fw.close();
						pw.close();
					}
				}else {
					System.err.println("El fichero no existe.");
				}
//			Para leer todo el fichero.
			}else if (opcion==2) {
				System.out.println("***   Escriba el nombre del fichero a leer.   ***");
				ruta=edd.nextLine();
				File f = new File(ruta);
//				Comprovamos que el fichero exista.
				if (f.exists()) {
//					Creamos un objeto de tipo FileReader para leer el fichero.
					FileReader fr= new FileReader(f);
//					Creamos un objeto de tipo BufferedReader para almacenar lo que leemos.				
					BufferedReader br = new BufferedReader(fr);
//					Para recorrer el buffer mientras tenga contenido.
					while((lectura = br.readLine()) != null) {
						nombre = nombre + lectura + " ";
					}
					System.out.println(nombre);
//					Cerramos los objetos.
					fr.close();
					br.close();
				}else {
					System.err.println("El fichero no existe.");
				}
			}else if (opcion==3) {
				System.out.println("*** Escriba el nombre del fichero donde realizar la busqueda:");
				ruta = edd.nextLine();
				System.out.println("***   Escriba el nombre de la persona a buscar.   ");
				buscar = edd.nextLine();
				File f = new File (ruta);
				if(f.exists()) {
//					Creamos un ArrayList para introducir lo leido.
					ArrayList persona = new ArrayList();
//					Creamos los objetos FR y BR para leer y almacenar respectivamente.
					FileReader fr = new FileReader (f);
					BufferedReader br = new BufferedReader (fr);
//					Para introducir lo leido en el array.
					while ((lectura = br.readLine())!=null){
						persona.add(lectura);
					}
//					Para recorrer el array persona.
					while (persona!=null) {
//						Recorremos el array.
						for(i=0; i<persona.size();i++) {
//							Comparamos el nombre introducido con el del array e imprimimos por consola.
//						System.out.println("<---------------->" + persona.get(1));
							if(persona.get(i).equals("Nombre: " +buscar)) {
								System.out.println("<------------");
								System.out.println(persona.get(i) + " - " + persona.get(i+1) + " - " + persona.get(i+2) + " - " + persona.get(i+3) + " - " + persona.get(i+4));
							}else {
								System.err.println("Nombre no encontrado.");							
							}
							break;
						}
						break;
					}
//					Cerramos los objetos.
					fr.close();
					br.close();
				}else {
					System.err.println("El fichero no existe.");
				}
				
			}
//		definimos el while para salir del programa.			
		} while (opcion!=0);
	}

}
