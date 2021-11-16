package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import modelo.ForecastDay;
import modelo.Modelo;
import modelo.Objeto;
import vista.Vista;

public class Controlador {
	
	static List<ForecastDay> dias = null;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Creo objetos las clases modelo vista y contolador
		Vista frame = new Vista();
		frame.setVisible(true);
		
		Modelo model = new Modelo();
		Controlador control = new Controlador();
		
		//Llamo a las clases de los button para que se activen 
		control.buscar(frame, model, control);
		
 	}
	
	//Esta clase llama a la clase de File to Object de modelo y le pasa la ciudad elegida

	public void buscar(Vista frame, Modelo model, Controlador control) {
		frame.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.panelDias.setVisible(true);
				try {
					Objeto objeto = model.buscarDatos(frame.comboBox.getSelectedItem().toString());
					control.llenarInterfaz(frame, objeto);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	 
	 
	 public void llenarInterfaz(Vista frame, Objeto objeto) {

		 try {
			 
			//Lista de los dias 
			dias = objeto.getCity().getForecast().getForecastDay();
			
			//Obtenemos el nombre de la ciudad seleccionado para imprimirlo en la interfaz
			frame.textRCiudad.setText(objeto.getCity().getCityName());
			
			for (int i = 0; i < 4; i++) {
	
				ForecastDay fore = dias.get(i);
				if (i==0) {
					
					//Obtenemos el clima, la temperatura maxina y minima y la imprimimos en la interfaz
					frame.textRClima1.setText(fore.getWeather());
					frame.textRTMax1.setText(fore.getMaxTemp() + "ºC");
					frame.textRTMin1.setText(fore.getMinTemp());
					
					eleccionIconos(frame, dias);
					
					
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
	 
	 private void eleccionIconos (Vista frame, List<ForecastDay> dias) {
		 
		 ForecastDay fore = dias.get(0);
		 
		 if (fore.getWeatherIcon().equals("0101") || fore.getWeatherIcon().equals("0102") || fore.getWeatherIcon().equals("0103") || fore.getWeatherIcon().equals("0104") || fore.getWeatherIcon().equals("2601") || fore.getWeatherIcon().equals("2602") || fore.getWeatherIcon().equals("2603") || fore.getWeatherIcon().equals("2604")) {
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\wind.png"));
				
			}else if (fore.getWeatherIcon().equals("0201") || fore.getWeatherIcon().equals("0202") || fore.getWeatherIcon().equals("0203") || fore.getWeatherIcon().equals("0206")){
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\rain_thunder.png"));
				
			}else if (fore.getWeatherIcon().equals("0301") || fore.getWeatherIcon().equals("0801")) {
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\sleet.png"));
				
			}else if (fore.getWeatherIcon().equals("0401") || fore.getWeatherIcon().equals("0402") || fore.getWeatherIcon().equals("0402") || fore.getWeatherIcon().equals("0403") || fore.getWeatherIcon().equals("0404")) {
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\snow.png"));
				
			}else if (fore.getWeatherIcon().equals("0501") || fore.getWeatherIcon().equals("0502") || fore.getWeatherIcon().equals("0701")) {
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\snow.png"));
				
			}else if (fore.getWeatherIcon().equals("0601") || fore.getWeatherIcon().equals("0602")) {
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\snow_thunder.png"));
				
			}else if (fore.getWeatherIcon().equals("0901") || fore.getWeatherIcon().equals("0902") || fore.getWeatherIcon().equals("0903")){
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\rain_thunder.png"));
				
			}else if (fore.getWeatherIcon().equals("1001") || fore.getWeatherIcon().equals("1002") || fore.getWeatherIcon().equals("1101")){
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\day_rain.png"));
				
			}else if (fore.getWeatherIcon().equals("1201") || fore.getWeatherIcon().equals("1301") || fore.getWeatherIcon().equals("1401") || fore.getWeatherIcon().equals("1501") || fore.getWeatherIcon().equals("1502")){
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\rain.png"));
				
			}else if (fore.getWeatherIcon().equals("1601")){
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\fog.png"));
				
			}else if (fore.getWeatherIcon().equals("1701") || fore.getWeatherIcon().equals("1801") || fore.getWeatherIcon().equals("1901")){
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\mist.png"));
				
			}else if (fore.getWeatherIcon().equals("2001")){
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\overcast.png"));
				
			}else if (fore.getWeatherIcon().equals("2101") || fore.getWeatherIcon().equals("2102") || fore.getWeatherIcon().equals("2103") || fore.getWeatherIcon().equals("2201") || fore.getWeatherIcon().equals("2202") || fore.getWeatherIcon().equals("2203")){
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\day_partial_cloud.png"));
				
			}else if (fore.getWeatherIcon().equals("2201") || fore.getWeatherIcon().equals("2202") || fore.getWeatherIcon().equals("2203")){
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\rain_thunder.png"));
	
			}else if (fore.getWeatherIcon().equals("2301")) {
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\cloudy.png"));
				
			}else if (fore.getWeatherIcon().equals("2401") || fore.getWeatherIcon().equals("2402") || fore.getWeatherIcon().equals("2403") || fore.getWeatherIcon().equals("2501") || fore.getWeatherIcon().equals("2502")) {
				frame.labelIcon.setIcon(new ImageIcon("src\\imagenes\\day_clear.png"));
			}
	 }
	
}
