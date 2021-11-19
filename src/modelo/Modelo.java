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

	//ESTA METODO BUSCA LA URL EN EL .PROPERTIES Y VUELCA LA INFORMACI�N EN LA CLASE JAVA
	
	public Objeto buscarDatos(String ciudad) throws FileNotFoundException, IOException {
		
		Objeto object = null;
		
		try { 
			//CREAMOS UN FICHERO Y LE PASAMOS LA DIRECCION DEL .PROPERTIES
			File fichero = new File("src\\files\\datos.properties");
			
			//CREAMOS UN PROPERTIES Y LE MANDAMOS LA DIRECCION DEL PROPERTIES
			Properties config = new Properties();
			config.load(new FileReader(fichero));
			
			//BUSCAMOS LA URL Y LA GUARDAMOS EN UN STRING JAVA
			String url = config.getProperty(ciudad);
			
			//CREAMOS UN OBJECTMAPPER Y LE PASAMOS EL CONTENIDO DE LA URL Y EL OBJETO JAVA DONDE SE GUARDA LA INFORMACI�N
			ObjectMapper mapper = new ObjectMapper();
			object = mapper.readValue(lecturaURL(url), modelo.Objeto.class);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;

	 }
	 
	//ESTE METODO SIRVE PARA BUSCAR LA URL EN EL .PROPERTIES
	public String lecturaURL(String url) throws IOException{
	     URL urlpagina = null;
	     InputStreamReader inputStreamReader = null;
	     BufferedReader br = null;
	     String linea;
	     StringBuffer buffer = new StringBuffer();

	     try {
	    	 //GUARDAMOS LA URL EN UN OBJETO DE TIPO URL
			 urlpagina = new URL(url);
			   
			 //LE PASAMOS LA URL A UN INPUTSTREAMREADER
			 inputStreamReader = new InputStreamReader(urlpagina.openStream());
			  
			 //PASAMOS EL INPUTSTREAMREADER A UN BUFFERREADER PARA REALIZAR LA LECTURA
			 br = new BufferedReader(inputStreamReader);

			 //GUARDAMOS LA LECTURA DEL BUFFERREADER EN UN BUFFER
			 while ((linea = br.readLine()) != null){	   
				   buffer.append(linea);
			   }
			   
			 //CERRAMOS EL BUFFERREADER Y EL INPUTSTREAMREADER
			   br.close();
			   inputStreamReader.close();
			   
	     } catch (Exception e) {
				e.printStackTrace();
	     }
	     return buffer.toString();
	   }
	
	
} 