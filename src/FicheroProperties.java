import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.DomainLoadStoreParameter;
import java.util.ArrayList;
import java.util.Properties;



public class FicheroProperties {
	
	public void recogerInfoURL (String temp) {
		
		try {
			// 1. Creamos un objero URL
			URL url = new URL (temp);
			
			// 2. Obtenga el objeto URLConnection
			URLConnection connection = (URLConnection)url.openConnection();
			
			// 3. LLamamos al metodo de conexion
			connection.connect();
			
			// 4. Acceso a los datos
			Reader read = new InputStreamReader(connection.getInputStream());
		    BufferedReader br = new BufferedReader(read);
		    String lineaDatos = br.readLine();
		        
		    //Imprimos la informacion obtenida 
		    System.out.println(lineaDatos);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) throws Exception{
	
	
		FicheroProperties main = new FicheroProperties ();
		
		// 1º Ciudad
		String urlMadrid = "https://worldweather.wmo.int/es/json/195_es.xml";
		main.recogerInfoURL(urlMadrid);
		
		// 2º Ciudad
		String urlBarcelona = "https://worldweather.wmo.int/es/json/1232_es.xml";
		main.recogerInfoURL(urlBarcelona);
		
		// 3º Ciudad
		String urlBenidorm = "https://worldweather.wmo.int/es/json/2888_es.xml";
		main.recogerInfoURL(urlBenidorm);
		
		// 4º Ciudad
		String urlCordoba = "https://worldweather.wmo.int/es/json/1765_es.xml";
		main.recogerInfoURL(urlCordoba);
		
		// 5º Ciudad
		String urlSanSebastian = "https://worldweather.wmo.int/es/json/1767_es.xml";
		main.recogerInfoURL(urlSanSebastian);
		
		// 6º Ciudad
		String urlLeon = "https://worldweather.wmo.int/es/json/1774_es.xml";
		main.recogerInfoURL(urlLeon);
		
		// 7º Ciudad
		String urlACoruna = "https://worldweather.wmo.int/es/json/1231_es.xml";
		main.recogerInfoURL(urlACoruna);
		
		// 8º Ciudad
		String urlCiudadReal = "https://worldweather.wmo.int/es/json/1764_es.xml";
		main.recogerInfoURL(urlCiudadReal);
		
		// 9º Ciudad
		String urlOviedo = "https://worldweather.wmo.int/es/json/1781_es.xml";
		main.recogerInfoURL(urlOviedo);
		
	
	}	
}