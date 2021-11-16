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
	 
	 public void llenarInterfaz(Vista frame, Objeto objeto) {

		 try {
			 
			//Lista de los dias 
			List<ForecastDay> dias = objeto.getCity().getForecast().getForecastDay();
			
			//Obtenemos el nombre de la ciudad seleccionado para imprimirlo en la interfaz
			frame.textRCiudad.setText(objeto.getCity().getCityName());
			
			for (int i = 0; i < 4; i++) {
	
				ForecastDay fore = dias.get(i);
				if (i==0) {
					
					//Obtenemos el clima, la temperatura maxina y minima y la imprimimos en la interfaz
					frame.textRClima1.setText(fore.getWeather());
					frame.textRTMax1.setText(fore.getMaxTemp());
					frame.textRTMin1.setText(fore.getMinTemp());
					if(fore.getWeatherIcon().equals("2402")) {
						frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\mostlycloudy.png"));
					}
				}else if (i==1) {
					
					//Obtenemos el clima, la temperatura maxina y minima y la imprimimos en la interfaz
					frame.textRClima2.setText(fore.getWeather());
					frame.textRTMax2.setText(fore.getMaxTemp());
					frame.textRTMin2.setText(fore.getMinTemp());
					
				}else if (i==2) {
					
					//Obtenemos el clima, la temperatura maxina y minima y la imprimimos en la interfaz
					frame.textRClima3.setText(fore.getWeather());
					frame.textRTMax3.setText(fore.getMaxTemp());
					frame.textRTMin3.setText(fore.getMinTemp());	
					frame.panelDia3.setBorder((new TitledBorder(null, fore.getForecastDate(), TitledBorder.LEADING, TitledBorder.TOP, null, null)));

				}else if (i==3) {
					frame.textRClima4.setText(fore.getWeather());
					frame.textRTMax4.setText(fore.getMaxTemp());
					frame.textRTMin4.setText(fore.getMinTemp());	
					
						
					
					frame.panelDia4.setBorder((new TitledBorder(null, fore.getForecastDate(), TitledBorder.LEADING, TitledBorder.TOP, null, null)));

				}
			}
			
		 } catch (Exception e) {
				e.printStackTrace();
		 }
		
	 }
	
} 
