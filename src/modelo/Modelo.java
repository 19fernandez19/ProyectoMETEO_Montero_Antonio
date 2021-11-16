package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import com.fasterxml.jackson.databind.ObjectMapper;

import vista.Vista;

public class Modelo {
	
	
	//Esta clase busca la URL en el .properties y vuelca la informacion en la clase JAVA
	
	public Objeto buscarDatos(String ciudad) throws FileNotFoundException, IOException {
		Objeto object = null;
		
		try { 
			//Creamos un fichero y le pasamos la direccion del .properties
			File fichero = new File("src\\files\\datos.properties");
			
			//Creamos un properties y le mandamos la direccion del properties
			Properties config = new Properties();
			config.load(new FileReader(fichero));
			
			//Buscamos la URL y la guardamos en un String JAVA
			String url = config.getProperty(ciudad);
			
			//Creamos un ObjectMapper y le pasamos el contenido de la URl y el objeto JAVA donde se guarda la informacion
			ObjectMapper mapper = new ObjectMapper();
			object = mapper.readValue(obtenerCodigoFuente(url), modelo.Objeto.class);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;

	 }
	 
	//Este metodo sirve para buscar la URL en el .properties
	public String obtenerCodigoFuente(String url) throws IOException{
	     URL urlpagina = null;
	     InputStreamReader inputStreamReader = null;
	     BufferedReader br = null;
	     String linea;
	     StringBuffer buffer = new StringBuffer();

	     try {
	    	 //Guardamos la URL en un objeto de tipo URL
			 urlpagina = new URL(url);
			   
			 //Le pasamos la URL a un InputStreamReader
			 inputStreamReader = new InputStreamReader(urlpagina.openStream());
			  
			 //Pasamos el InputStreamReader a un BufferReader para realizar la lectura
			 br = new BufferedReader(inputStreamReader);
			   
			 //Guardamos la lectura del BufferReader en un Buffer
			 while ((linea = br.readLine()) != null){	   
				   buffer.append(linea);
			   }
			   
			 //Cerramos el BufferReader y el InputStreamReader
			   br.close();
			   inputStreamReader.close();
			   
	     } catch (Exception e) {
				e.printStackTrace();
	     }
	     return buffer.toString();
	   }
	
	
} 
