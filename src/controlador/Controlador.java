package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.ForecastDay;
import modelo.Modelo;
import modelo.Objeto;
import vista.Vista;

public class Controlador {

	static List<ForecastDay> dias = null;
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		//CREO LOS OBJETOS DE LAS CLASES MODELO, VISTA Y CONTROLADOR
		Vista frame = new Vista();
		frame.setVisible(true);
		
		Modelo model = new Modelo();
		Controlador control = new Controlador();
		
		//LLAMO A LOS ACTIONLISTENERS DE LOS BOTONES
		control.buscarCiudades(frame, model, control);
		control.buscarDias(frame, model, control);
		
 	}
	
	//LLAMADA AL METODO "buscarDatos" DE LA CLASE MODELO Y A PARTIR DE LA ELECCI�N DEL COMBOBOX, LE PASA LA CIUDAD
	public void buscarCiudades(Vista frame, Modelo model, Controlador control) {
		frame.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.panelDias.setVisible(true);
				try {
					Objeto objeto = model.buscarDatos(frame.comboBox.getSelectedItem().toString());
					control.obtenerDatos(frame, objeto);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	// BOTON DE BUSQUEDA PARA EL COMBOBOX DE LOS DIAS
	public void buscarDias(Vista frame, Modelo model, Controlador control) {
		frame.btnBuscarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.panelDias.setVisible(false);
				try {
					Objeto ciudadReal = model.buscarDatos("CiudadReal");
					Objeto oviedo = model.buscarDatos("Oviedo");
					Objeto madrid = model.buscarDatos("Madrid");
					Objeto barcelona = model.buscarDatos("Barcelona");
					Objeto benidorm = model.buscarDatos("Benidorm");
					Objeto sevilla = model.buscarDatos("Sevilla");
					Objeto valladolid = model.buscarDatos("Valladolid");
					Objeto zaragoza = model.buscarDatos("Zaragoza");
					
					ArrayList<Objeto> listaCiudades = new ArrayList<Objeto>(); 
					listaCiudades.add(ciudadReal);
					listaCiudades.add(oviedo);
					listaCiudades.add(madrid);
					listaCiudades.add(barcelona);
					listaCiudades.add(benidorm);
					listaCiudades.add(sevilla);
					listaCiudades.add(valladolid);
					listaCiudades.add(zaragoza);
					
					
					
					control.obtenerInfoMapa(frame, listaCiudades);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	
	
	
	// OBTENER LA INFORMACI�N DE LOS ICONOS DEL MAPA
	
	public void obtenerInfoMapa (Vista frame, ArrayList <Objeto> listaCiudades) {
		
		 //DIA HOY
		 if(frame.comboBoxDias.getSelectedItem().equals("HOY")) {
			 
			 	iconosMapas(frame, listaCiudades, frame.labelIconoCiudadReal, 	0, 0);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoOviedo, 		1, 0);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoMadrid, 		2, 0);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoBarcelona, 	3, 0);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoBenidorm,		4, 0);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoSevilla, 		5, 0);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoValladolid, 	6, 0);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoZaragoza, 	7, 0);
			 	
		//DIA MA�ANA
			}else if (frame.comboBoxDias.getSelectedItem().equals("MAÑANA")) {
				
				iconosMapas(frame, listaCiudades, frame.labelIconoCiudadReal, 	0, 1);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoOviedo, 		1, 1);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoMadrid, 		2, 1);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoBarcelona, 	3, 1);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoBenidorm, 	4, 1);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoSevilla, 		5, 1);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoValladolid, 	6, 1);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoZaragoza, 	7, 1);
								
				
		//DIA PASADO
			}else if (frame.comboBoxDias.getSelectedItem().equals("PASADO")) {
				
				iconosMapas(frame, listaCiudades, frame.labelIconoCiudadReal,	0, 2);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoOviedo, 		1, 2);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoMadrid, 		2, 2);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoBarcelona, 	3, 2);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoBenidorm, 	4, 2);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoSevilla, 		5, 2);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoValladolid, 	6, 2);
			 	iconosMapas(frame, listaCiudades, frame.labelIconoZaragoza, 	7, 2);
				
			}
		 
	}
	
	// OBTENER EL CLIMA, LAS TEMPERATURAS Y LA LLAMADA AL METODO DE LA ELECCION DEL ICONO
	 public void obtenerDatos(Vista frame, Objeto objeto) {

		 try {
			 
			//LISTA DE LOS DIAS
			dias = objeto.getCity().getForecast().getForecastDay();

			//OBTENEMOS EL NOMBRE DE LA CIUDAD SELECCIONADA PARA IMPRIMIRLO EN LA INTERFAZ
			frame.textRCiudad.setText(objeto.getCity().getCityName());

			for (int i = 0; i < 4; i++) {
	
				ForecastDay fore = dias.get(i);
				
				if (i==0) {
				
					//OBTENEMOS EL CLIMA, LA TEMPERATURA MAXIMA Y MINIMA Y LA IMPRIMIMOS EN LA INTERFAZ
					frame.textRClima1.setText(fore.getWeather());
					frame.textRTMax1.setText(fore.getMaxTemp() + "ºC");
					frame.textRTMin1.setText(fore.getMinTemp() + "ºC");
							
					eleccionIconoPrincipal(frame, dias, frame.labelIcon);	
					
				}else if (i==1) {
					
					//OBTENEMOS EL CLIMA, LA TEMPERATURA MAXIMA Y MINIMA Y LA IMPRIMIMOS EN LA INTERFAZ
					frame.textRClima2.setText(fore.getWeather());
					frame.textRTMax2.setText(fore.getMaxTemp() + "ºC");
					frame.textRTMin2.setText(fore.getMinTemp() + "ºC");
					
					eleccionIconosDias(frame, dias, frame.labelIconDia2, 1);
					
					
				}else if (i==2) {
					
					//OBTENEMOS EL CLIMA, LA TEMPERATURA MAXIMA Y MINIMA Y LA IMPRIMIMOS EN LA INTERFAZ
					frame.textRClima3.setText(fore.getWeather());
					frame.textRTMax3.setText(fore.getMaxTemp() + "ºC");
					frame.textRTMin3.setText(fore.getMinTemp() + "ºC");
					frame.dia3.setText(fore.getForecastDate());

					eleccionIconosDias(frame, dias, frame.labelIconDia3, 2);
					
					
				}else if (i==3) {
					//OBTENEMOS EL CLIMA, LA TEMPERATURA MAXIMA Y MINIMA Y LA IMPRIMIMOS EN LA INTERFAZ
					frame.textRClima4.setText(fore.getWeather());
					frame.textRTMax4.setText(fore.getMaxTemp() + "ºC");
					frame.textRTMin4.setText(fore.getMinTemp() + "ºC");
					frame.dia4.setText(fore.getForecastDate());

					eleccionIconosDias(frame, dias, frame.labelIconDia4, 3);
				}
			}
			
		 } catch (Exception e) {
				e.printStackTrace();
		 }
		
	 }
	 
	 // ELECCION DE LOS ICONOS DEL MENU LATERAL
	 
	 private void eleccionIconosDias (Vista frame,  List<ForecastDay> dias, JLabel label, int dia) {
		 
		 
		 ForecastDay fore = dias.get(dia);
		 
		 if (fore.getWeatherIcon().equals("0101") || fore.getWeatherIcon().equals("0102") || fore.getWeatherIcon().equals("0103") || fore.getWeatherIcon().equals("0104") || fore.getWeatherIcon().equals("2601") || fore.getWeatherIcon().equals("2602") || fore.getWeatherIcon().equals("2603") || fore.getWeatherIcon().equals("2604")) {
				label.setIcon(new ImageIcon("src\\imagenes\\wind3.png"));
				
			}else if (fore.getWeatherIcon().equals("0201") || fore.getWeatherIcon().equals("0202") || fore.getWeatherIcon().equals("0203") || fore.getWeatherIcon().equals("0206")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain_thunder3.png"));
				
			}else if (fore.getWeatherIcon().equals("0301") || fore.getWeatherIcon().equals("0801")) {
				label.setIcon(new ImageIcon("src\\imagenes\\sleet3.png"));
				
			}else if (fore.getWeatherIcon().equals("0401") || fore.getWeatherIcon().equals("0402") || fore.getWeatherIcon().equals("0402") || fore.getWeatherIcon().equals("0403") || fore.getWeatherIcon().equals("0404")) {
				label.setIcon(new ImageIcon("src\\imagenes\\snow3.png"));
				
			}else if (fore.getWeatherIcon().equals("0501") || fore.getWeatherIcon().equals("0502") || fore.getWeatherIcon().equals("0701")) {
				label.setIcon(new ImageIcon("src\\imagenes\\snow3.png"));
				
			}else if (fore.getWeatherIcon().equals("0601") || fore.getWeatherIcon().equals("0602")) {
				label.setIcon(new ImageIcon("src\\imagenes\\snow_thunder3.png"));
				
			}else if (fore.getWeatherIcon().equals("0901") || fore.getWeatherIcon().equals("0902") || fore.getWeatherIcon().equals("0903")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain_thunder3.png"));
				
			}else if (fore.getWeatherIcon().equals("1001") || fore.getWeatherIcon().equals("1002") || fore.getWeatherIcon().equals("1101")){
				label.setIcon(new ImageIcon("src\\imagenes\\day_rain3.png"));
				
			}else if (fore.getWeatherIcon().equals("1201") || fore.getWeatherIcon().equals("1301") || fore.getWeatherIcon().equals("1401") || fore.getWeatherIcon().equals("1501") || fore.getWeatherIcon().equals("1502")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain3.png"));
				
			}else if (fore.getWeatherIcon().equals("1601")){
				label.setIcon(new ImageIcon("src\\imagenes\\fog3.png"));
				
			}else if (fore.getWeatherIcon().equals("1701") || fore.getWeatherIcon().equals("1801") || fore.getWeatherIcon().equals("1901")){
				label.setIcon(new ImageIcon("src\\imagenes\\mist3.png"));
				
			}else if (fore.getWeatherIcon().equals("2001") || fore.getWeatherIcon().equals("2302")){
				label.setIcon(new ImageIcon("src\\imagenes\\overcast3.png"));
				
			}else if (fore.getWeatherIcon().equals("2101") || fore.getWeatherIcon().equals("2102") || fore.getWeatherIcon().equals("2103") || fore.getWeatherIcon().equals("2201") || fore.getWeatherIcon().equals("2202") || fore.getWeatherIcon().equals("2203")){
				label.setIcon(new ImageIcon("src\\imagenes\\day_partial_cloud3.png"));
				
			}else if (fore.getWeatherIcon().equals("2201") || fore.getWeatherIcon().equals("2202") || fore.getWeatherIcon().equals("2203")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain_thunder3.png"));
	
			}else if (fore.getWeatherIcon().equals("2301")) {
				label.setIcon(new ImageIcon("src\\imagenes\\cloudy3.png"));
				
			}else if (fore.getWeatherIcon().equals("2401") || fore.getWeatherIcon().equals("2402") || fore.getWeatherIcon().equals("2403") || fore.getWeatherIcon().equals("2501") || fore.getWeatherIcon().equals("2502")) {
				label.setIcon(new ImageIcon("src\\imagenes\\day_clear3.png"));
				
			}
		 
	 }
	 
	 //ELECCION DEL ICONO DEL DIA ACTUAL
	 private void eleccionIconoPrincipal (Vista frame, List<ForecastDay> dias, JLabel label) {
		 
		 ForecastDay fore = dias.get(0);
		 
		 if (fore.getWeatherIcon().equals("0101") || fore.getWeatherIcon().equals("0102") || fore.getWeatherIcon().equals("0103") || fore.getWeatherIcon().equals("0104") || fore.getWeatherIcon().equals("2601") || fore.getWeatherIcon().equals("2602") || fore.getWeatherIcon().equals("2603") || fore.getWeatherIcon().equals("2604")) {
				label.setIcon(new ImageIcon("src\\imagenes\\wind.png"));
				
			}else if (fore.getWeatherIcon().equals("0201") || fore.getWeatherIcon().equals("0202") || fore.getWeatherIcon().equals("0203") || fore.getWeatherIcon().equals("0206")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain_thunder.png"));
				
			}else if (fore.getWeatherIcon().equals("0301") || fore.getWeatherIcon().equals("0801")) {
				label.setIcon(new ImageIcon("src\\imagenes\\sleet.png"));
				
			}else if (fore.getWeatherIcon().equals("0401") || fore.getWeatherIcon().equals("0402") || fore.getWeatherIcon().equals("0402") || fore.getWeatherIcon().equals("0403") || fore.getWeatherIcon().equals("0404")) {
				label.setIcon(new ImageIcon("src\\imagenes\\snow.png"));
				
			}else if (fore.getWeatherIcon().equals("0501") || fore.getWeatherIcon().equals("0502") || fore.getWeatherIcon().equals("0701")) {
				label.setIcon(new ImageIcon("src\\imagenes\\snow.png"));
				
			}else if (fore.getWeatherIcon().equals("0601") || fore.getWeatherIcon().equals("0602")) {
				label.setIcon(new ImageIcon("src\\imagenes\\snow_thunder.png"));
				
			}else if (fore.getWeatherIcon().equals("0901") || fore.getWeatherIcon().equals("0902") || fore.getWeatherIcon().equals("0903")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain_thunder.png"));
				
			}else if (fore.getWeatherIcon().equals("1001") || fore.getWeatherIcon().equals("1002") || fore.getWeatherIcon().equals("1101")){
				label.setIcon(new ImageIcon("src\\imagenes\\day_rain.png"));
				
			}else if (fore.getWeatherIcon().equals("1201") || fore.getWeatherIcon().equals("1301") || fore.getWeatherIcon().equals("1401") || fore.getWeatherIcon().equals("1501") || fore.getWeatherIcon().equals("1502")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain.png"));
				
			}else if (fore.getWeatherIcon().equals("1601")){
				label.setIcon(new ImageIcon("src\\imagenes\\fog.png"));
				
			}else if (fore.getWeatherIcon().equals("1701") || fore.getWeatherIcon().equals("1801") || fore.getWeatherIcon().equals("1901")){
				label.setIcon(new ImageIcon("src\\imagenes\\mist.png"));
				
			}else if (fore.getWeatherIcon().equals("2001") || fore.getWeatherIcon().equals("2302")){
				label.setIcon(new ImageIcon("src\\imagenes\\overcast.png"));
				
			}else if (fore.getWeatherIcon().equals("2101") || fore.getWeatherIcon().equals("2102") || fore.getWeatherIcon().equals("2103") || fore.getWeatherIcon().equals("2201") || fore.getWeatherIcon().equals("2202") || fore.getWeatherIcon().equals("2203")){
				label.setIcon(new ImageIcon("src\\imagenes\\day_partial_cloud.png"));
				
			}else if (fore.getWeatherIcon().equals("2201") || fore.getWeatherIcon().equals("2202") || fore.getWeatherIcon().equals("2203")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain_thunder.png"));
	
			}else if (fore.getWeatherIcon().equals("2301")) {
				label.setIcon(new ImageIcon("src\\imagenes\\cloudy.png"));
				
			}else if (fore.getWeatherIcon().equals("2401") || fore.getWeatherIcon().equals("2402") || fore.getWeatherIcon().equals("2403") || fore.getWeatherIcon().equals("2501") || fore.getWeatherIcon().equals("2502")) {
				label.setIcon(new ImageIcon("src\\imagenes\\day_clear.png"));
				
			}
	 }
	
	 // ELECCION DE LOS ICONOS DEL MAPA
	 private void iconosMapas (Vista frame, ArrayList <Objeto> listaCiudades, JLabel label, int posicion, int dia) {
			
			String ciudad = listaCiudades.get(posicion).getCity().getForecast().getForecastDay().get(dia).getWeatherIcon();
		
			if (ciudad.equals("0101") || ciudad.equals("0102") || ciudad.equals("0103") || ciudad.equals("0104") || ciudad.equals("2601") || ciudad.equals("2602") || ciudad.equals("2603") || ciudad.equals("2604")) {
				label.setIcon(new ImageIcon("src\\imagenes\\wind2.png"));
				
			}else if (ciudad.equals("0201") || ciudad.equals("0202") || ciudad.equals("0203") || ciudad.equals("0206")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain_thunder2.png"));
				
			}else if (ciudad.equals("0301") || ciudad.equals("0801")) {
				label.setIcon(new ImageIcon("src\\imagenes\\sleet2.png"));
				
			}else if (ciudad.equals("0401") || ciudad.equals("0402") || ciudad.equals("0402") || ciudad.equals("0403") || ciudad.equals("0404")) {
				label.setIcon(new ImageIcon("src\\imagenes\\snow2.png"));
				
			}else if (ciudad.equals("0501") || ciudad.equals("0502") || ciudad.equals("0701")) {
				label.setIcon(new ImageIcon("src\\imagenes\\snow2.png"));
				
			}else if (ciudad.equals("0601") || ciudad.equals("0602")) {
				label.setIcon(new ImageIcon("src\\imagenes\\snow_thunder2.png"));
				
			}else if (ciudad.equals("0901") || ciudad.equals("0902") || ciudad.equals("0903")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain_thunder2.png"));
				
			}else if (ciudad.equals("1001") || ciudad.equals("1002") || ciudad.equals("1101")){
				label.setIcon(new ImageIcon("src\\imagenes\\day_rain2.png"));
				
			}else if (ciudad.equals("1201") || ciudad.equals("1301") || ciudad.equals("1401") || ciudad.equals("1501") || ciudad.equals("1502")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain2.png"));
				
			}else if (ciudad.equals("1601")){
				label.setIcon(new ImageIcon("src\\imagenes\\fog2.png"));
				
			}else if (ciudad.equals("1701") || ciudad.equals("1801") || ciudad.equals("1901")){
				label.setIcon(new ImageIcon("src\\imagenes\\mist2.png"));
				
			}else if (ciudad.equals("2001") || ciudad.equals("2302")){
				label.setIcon(new ImageIcon("src\\imagenes\\overcast2.png"));
				
			}else if (ciudad.equals("2101") || ciudad.equals("2102") || ciudad.equals("2103") || ciudad.equals("2201") || ciudad.equals("2202") || ciudad.equals("2203")){
				label.setIcon(new ImageIcon("src\\imagenes\\day_partial_cloud2.png"));
				
			}else if (ciudad.equals("2201") || ciudad.equals("2202") || ciudad.equals("2203")){
				label.setIcon(new ImageIcon("src\\imagenes\\rain_thunder2.png"));
	
			}else if (ciudad.equals("2301")) {
				label.setIcon(new ImageIcon("src\\imagenes\\cloudy2.png"));
				
			}else if (ciudad.equals("2401") || ciudad.equals("2402") || ciudad.equals("2403") || ciudad.equals("2501") || ciudad.equals("2502")) {
				label.setIcon(new ImageIcon("src\\imagenes\\day_clear2.png"));
				
			}
	
	}
}		