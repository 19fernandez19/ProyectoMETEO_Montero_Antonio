import java.io.*;
import java.net.URL;
import java.net.URLConnection;
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
    
    	 Properties propiedades = new Properties();

         FileReader entrada=null;

         entrada = new FileReader("datos.properties");
         propiedades.load(entrada);// cargamos el fichero entrada
         
         //objeto properties 
         
        FicheroProperties main = new FicheroProperties();
        
        
        // 1� Ciudad
        String urlMadrid = propiedades.getProperty("madrid");
        main.recogerInfoURL(urlMadrid);
        
        // 2� Ciudad
        String urlBarcelona = propiedades.getProperty("barcelona");
        main.recogerInfoURL(urlBarcelona);
        
        // 3� Ciudad
        String urlBenidorm = propiedades.getProperty("benidorm");
        main.recogerInfoURL(urlBenidorm);
        
        // 4� Ciudad
        String urlSevilla = propiedades.getProperty("sevilla");
        main.recogerInfoURL(urlSevilla);
        
        // 5� Ciudad
        String urlToledo = propiedades.getProperty("toledo");
        main.recogerInfoURL(urlToledo);
        
        // 6� Ciudad
        String urlZaragoza = propiedades.getProperty("zaragoza");
        main.recogerInfoURL(urlZaragoza);
        
        // 7� Ciudad
        String urlOviedo = propiedades.getProperty("oviedo");
        main.recogerInfoURL(urlOviedo);
        
        // 8� Ciudad
        String urlCiudadReal = propiedades.getProperty("ciudadreal");
        main.recogerInfoURL(urlCiudadReal);
        
    }

}