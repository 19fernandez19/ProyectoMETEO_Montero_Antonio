import java.io.*;

import java.util.ArrayList;
import java.util.Properties;

public class FicheroProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties propiedades = new Properties();
		InputStream entrada = null;
		
		ArrayList listaCiudades = new ArrayList();
		
		
		try {
			entrada = new FileInputStream("datos.properties");
			propiedades.load(entrada);//cargamos el fichero entrada
			
			System.out.println("El ID de la ciudad es " + propiedades);
			System.out.println("La ciudad es " + propiedades.getProperty("localidad"));
		
		} catch (Exception e) {
			e.printStackTrace();//mostrar los errores
		}
		
		

	}

}