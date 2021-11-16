package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.Modelo;
import modelo.Objeto;
import vista.Vista;

public class Controlador {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Creo objetos las clases modelo vista y contolador
		Vista frame = new Vista();
		frame.setVisible(true);
		
		Modelo model = new Modelo();
		Controlador control = new Controlador();
		
		//Llamo a las clases de los button para que se activen 
		control.buscar(frame, model);
		
 	}
	
	//Esta clase llama a la clase de File to Object de modelo y le pasa la ciudad elegida

	public void buscar(Vista frame, Modelo model) {
		frame.btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Objeto objeto = model.buscarDatos(frame.comboBox.getSelectedItem().toString());
					model.llenarInterfaz(frame, objeto);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
}
