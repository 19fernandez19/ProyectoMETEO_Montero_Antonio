package vista;


import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

public class Vista extends JFrame {

	private JPanel contentPane;
	public JComboBox<String> comboBox;
	public JComboBox<String> comboBoxDias; 
	public JButton btnBuscar;
	public JButton btnBuscarMapa;
	
	
	//DIA 1
	public JLabel labelIcon;
	public JTextField textRClima1;
	public JTextField textRTMax1;
	public JTextField textRTMin1;
	public JLabel lblTMax1;
	public JLabel lblTMin1;
	
	
	//DIA 2
	public JTextField mañana;
	public JLabel labelIconDia2;
	public JTextField textRClima2;
	public JLabel lblTMax2;
	public JLabel lblTMin2;
	public JTextField textRTMin2;
	public JTextField textRTMax2;
	
	
	
	//DIA 3
	public JPanel panelDia3;
	public JTextField dia3;
	public JLabel labelIconDia3;
	public JLabel textRClima3;
	public JLabel lblTMax3;
	public JLabel lblTMin3;
	public JTextField textRTMax3;
	public JTextField textRTMin3;
	
	
	//DIA 4
	public JPanel panelDia4;
	public JTextField dia4;
	public JLabel labelIconDia4;
	public JLabel textRClima4;
	public JLabel lblTMax4;
	public JLabel lblTMin4;
	public JTextField textRTMax4;
	public JTextField textRTMin4;
	
	//---------------------------------------//
	
	
	//PANEL MENU LATERAL
	public JPanel panelDias;
	public JTextField textRCiudad;
	private JPanel panelPrincipal;
	private JLabel textCiudad;
	
	
	//LABEL DE LOS ICONOS
	public JLabel labelIconoCiudadReal;
	public JLabel labelIconoOviedo;
	public JLabel labelIconoBarcelona;
	public JLabel labelIconoMadrid;
	public JLabel labelIconoBenidorm;
	public JLabel labelIconoSevilla;
	public JLabel labelIconoValladolid;
	public JLabel labelIconoZaragoza;
	public JLabel textSpain;

	//JTEXTFIELD DE LOS MOUSELISTENER
	public JTextField textCiudadReal;
	public JTextField textOviedo;
	public JTextField textMadrid;
	public JTextField textSevilla;
	public JTextField textBarcelona;
	private JTextField textBenidorm;
	private JTextField textZaragoza;
	private JTextField textValladolid;


	/**
	 * Create the frame.
	 */
	public Vista() {
		setResizable(false);
		setFont(new Font("Agency FB", Font.BOLD, 30));
		setForeground(new Color(0, 0, 0));
		setTitle("El Tiempo\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 834);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 1002, 798);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		/**
		 * IMAGEN MAPA
		 */
		JLabel panelMapa = new JLabel("");
		panelMapa.setBounds(20, 198, 600, 537);
		panelMapa.setBackground(Color.WHITE);
		panelMapa.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelMapa.setIcon(new ImageIcon("src\\imagenes\\mapa.png"));
		panel.add(panelMapa);
		
		/**
		 * PANEL DIAS
		 */
		
		panelDias = new JPanel();
		panelDias.setBorder(null);
		panelDias.setVisible(false);
		panelDias.setBackground(new Color(255, 255, 255));
		panelDias.setBounds(630, 0, 372, 798);
		panel.add(panelDias);
		panelDias.setLayout(null);
		
		
		/**
		 * PANEL NOMBRE CIUDAD
		 */
		
		textRCiudad = new JTextField();
		textRCiudad.setEnabled(false);
		textRCiudad.setBounds(0, 21, 373, 60);
		panelDias.add(textRCiudad);
		textRCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		textRCiudad.setBackground(new Color(255, 255, 255));
		textRCiudad.setBorder(null);
		textRCiudad.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 50));
		textRCiudad.setColumns(10);
		
		
		/**
		 * PANEL PRINCIPAL
		 */
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(224, 255, 255));
		panelPrincipal.setBounds(0, 0, 605, 189);
		panel.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		textCiudad = new JLabel("CIUDAD");
		textCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		textCiudad.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 40));
		textCiudad.setBounds(10, 37, 156, 40);
		panelPrincipal.add(textCiudad);
		
		comboBox = new JComboBox();
		comboBox.setBounds(176, 37, 145, 40);
		panelPrincipal.add(comboBox);
		comboBox.setFont(new Font("Agency FB", Font.BOLD, 28));
		
		btnBuscar= new  JButton("Buscar");
		btnBuscar.setBounds(344, 39, 104, 40);
		panelPrincipal.add(btnBuscar);
		btnBuscar.setFont(new Font("Agency FB", Font.BOLD, 25));
		
		comboBoxDias = new JComboBox();
		comboBoxDias.setFont(new Font("Agency FB", Font.BOLD, 28));
		comboBoxDias.setModel(new DefaultComboBoxModel(new String[] {"", "HOY", "MAÑANA", "PASADO"}));
		comboBoxDias.setBounds(176, 103, 145, 40);
		panelPrincipal.add(comboBoxDias);
		
		btnBuscarMapa = new JButton("Buscar");
		btnBuscarMapa.setFont(new Font("Agency FB", Font.BOLD, 25));
		btnBuscarMapa.setBounds(344, 104, 104, 40);
		panelPrincipal.add(btnBuscarMapa);
		
		JLabel textDia = new JLabel("DIA");
		textDia.setHorizontalAlignment(SwingConstants.CENTER);
		textDia.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 40));
		textDia.setBounds(10, 98, 156, 40);
		panelPrincipal.add(textDia);
		
		
		
		/**
		 * PANEL DIA 1
		 */
		
		JPanel panelDia1 = new JPanel();
		panelDia1.setBounds(0, 77, 370, 194);
		panelDias.add(panelDia1);
		panelDia1.setBackground(new Color(255, 255, 255));
		panelDia1.setBorder(null);
		panelDia1.setLayout(null);
		
		textRClima1 = new JTextField();
		textRClima1.setBackground(new Color(255, 255, 255));
		textRClima1.setBounds(0, 139, 370, 42);
		textRClima1.setBorder(null);
		panelDia1.add(textRClima1);
		textRClima1.setHorizontalAlignment(SwingConstants.CENTER);
		textRClima1.setFont(new Font("Agency FB", Font.BOLD, 40));
		textRClima1.setEditable(false);
		textRClima1.setColumns(10);
		
		JLabel lblTMax1 = new JLabel("Tª Máxima");
		lblTMax1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTMax1.setBounds(20, 50, 88, 27);
		panelDia1.add(lblTMax1);
		lblTMax1.setFont(new Font("Agency FB", Font.BOLD, 22));
		
		textRTMax1 = new JTextField();
		textRTMax1.setBackground(new Color(255, 255, 255));
		textRTMax1.setBounds(21, 82, 88, 47);
		textRTMax1.setBorder(null);
		panelDia1.add(textRTMax1);
		textRTMax1.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMax1.setEditable(false);
		textRTMax1.setForeground(Color.RED);
		textRTMax1.setFont(new Font("Agency FB", Font.BOLD, 40));
		textRTMax1.setColumns(10);
		
		textRTMin1 = new JTextField();
		textRTMin1.setBackground(new Color(255, 255, 255));
		textRTMin1.setBounds(269, 82, 79, 47);
		textRTMin1.setBorder(null);
		panelDia1.add(textRTMin1);
		textRTMin1.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMin1.setForeground(Color.BLUE);
		textRTMin1.setFont(new Font("Agency FB", Font.BOLD, 40));
		textRTMin1.setEditable(false);
		textRTMin1.setColumns(10);
		
		JLabel lblTMin1 = new JLabel("Tª Mínima");
		lblTMin1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTMin1.setBounds(267, 51, 79, 27);
		panelDia1.add(lblTMin1);
		lblTMin1.setFont(new Font("Agency FB", Font.BOLD, 22));
		
		

		labelIcon = new JLabel("");
		labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		labelIcon.setBounds(115, 20, 138, 122);
		panelDia1.add(labelIcon);
		labelIcon.setBackground(new Color(255, 255, 255));
		
		
		/**
		 * PANEL DIA 2
		 */
		JPanel panelDia2 = new JPanel();
		panelDia2.setBackground(new Color(255, 255, 255));
		panelDia2.setBounds(0, 287, 372, 168);
		panelDias.add(panelDia2);
		panelDia2.setLayout(null);
		panelDia2.setBorder(null);
		
		mañana = new JTextField();
		mañana.setEditable(false);
		mañana.setEnabled(false);
		mañana.setText("MAÑANA");
		mañana.setHorizontalAlignment(SwingConstants.CENTER);
		mañana.setBackground(new Color(255, 255, 255));
		mañana.setBounds(10, 12, 352, 36);
		mañana.setBorder(null);
		panelDia2.add(mañana);
		mañana.setFont(new Font("Agency FB", Font.BOLD, 30));
		mañana.setColumns(10);
		
		textRTMax2 = new JTextField();
		textRTMax2.setBackground(new Color(255, 255, 255));
		textRTMax2.setBounds(30, 80, 88, 47);
		textRTMax2.setBorder(null);
		panelDia2.add(textRTMax2);
		textRTMax2.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMax2.setForeground(Color.RED);
		textRTMax2.setFont(new Font("Agency FB", Font.BOLD, 35));
		textRTMax2.setEditable(false);
		textRTMax2.setColumns(10);
		
		textRTMin2 = new JTextField();
		textRTMin2.setBackground(new Color(255, 255, 255));
		textRTMin2.setBounds(260, 80, 88, 47);
		textRTMin2.setBorder(null);
		panelDia2.add(textRTMin2);
		textRTMin2.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMin2.setForeground(Color.BLUE);
		textRTMin2.setFont(new Font("Agency FB", Font.BOLD, 35));
		textRTMin2.setEditable(false);
		textRTMin2.setColumns(10);
		
		labelIconDia2 = new JLabel("");
		labelIconDia2.setHorizontalAlignment(SwingConstants.CENTER);
		labelIconDia2.setBounds(123, 51, 127, 80);
		panelDia2.add(labelIconDia2);
		
		lblTMax2 = new JLabel("Tª Máxima");
		lblTMax2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTMax2.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTMax2.setBounds(30, 56, 88, 27);
		panelDia2.add(lblTMax2);
		
		lblTMin2 = new JLabel("Tª Mínima");
		lblTMin2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTMin2.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTMin2.setBounds(260, 56, 88, 27);
		panelDia2.add(lblTMin2);
		
		textRClima2 = new JTextField();
		textRClima2.setHorizontalAlignment(SwingConstants.CENTER);
		textRClima2.setFont(new Font("Agency FB", Font.BOLD, 25));
		textRClima2.setEditable(false);
		textRClima2.setColumns(10);
		textRClima2.setBorder(null);
		textRClima2.setBackground(Color.WHITE);
		textRClima2.setBounds(10, 135, 352, 28);
		panelDia2.add(textRClima2);
		
		/**
		 * PANEL DIA 3
		 */
		panelDia3 = new JPanel();
		panelDia3.setLayout(null);
		panelDia3.setBorder(null);
		panelDia3.setBackground(Color.WHITE);
		panelDia3.setBounds(1, 455, 372, 168);
		panelDias.add(panelDia3);
		
		dia3 = new JTextField();
		dia3.setEnabled(false);
		dia3.setHorizontalAlignment(SwingConstants.CENTER);
		dia3.setFont(new Font("Agency FB", Font.BOLD, 30));
		dia3.setEditable(false);
		dia3.setColumns(10);
		dia3.setBorder(null);
		dia3.setBackground(Color.WHITE);
		dia3.setBounds(10, 12, 352, 36);
		panelDia3.add(dia3);
		
		textRTMax3 = new JTextField();
		textRTMax3.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMax3.setForeground(Color.RED);
		textRTMax3.setFont(new Font("Agency FB", Font.BOLD, 35));
		textRTMax3.setEditable(false);
		textRTMax3.setColumns(10);
		textRTMax3.setBorder(null);
		textRTMax3.setBackground(Color.WHITE);
		textRTMax3.setBounds(30, 80, 88, 47);
		panelDia3.add(textRTMax3);
		
		textRTMin3 = new JTextField();
		textRTMin3.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMin3.setForeground(Color.BLUE);
		textRTMin3.setFont(new Font("Agency FB", Font.BOLD, 35));
		textRTMin3.setEditable(false);
		textRTMin3.setColumns(10);
		textRTMin3.setBorder(null);
		textRTMin3.setBackground(Color.WHITE);
		textRTMin3.setBounds(260, 80, 88, 47);
		panelDia3.add(textRTMin3);
		
		labelIconDia3 = new JLabel("");
		labelIconDia3.setHorizontalAlignment(SwingConstants.CENTER);
		labelIconDia3.setBounds(123, 51, 127, 80);
		panelDia3.add(labelIconDia3);
		
		lblTMax3 = new JLabel("Tª Máxima");
		lblTMax3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTMax3.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTMax3.setBounds(30, 56, 88, 27);
		panelDia3.add(lblTMax3);
		
		lblTMin3 = new JLabel("Tª Mínima");
		lblTMin3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTMin3.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTMin3.setBounds(260, 56, 88, 27);
		panelDia3.add(lblTMin3);
		
		textRClima3 = new JLabel("");
		textRClima3.setHorizontalAlignment(SwingConstants.CENTER);
		textRClima3.setFont(new Font("Agency FB", Font.BOLD, 25));
		textRClima3.setBounds(10, 135, 352, 28);
		panelDia3.add(textRClima3);
		
		/**
		 * PANEL DIA 4
		 */
		panelDia4 = new JPanel();
		panelDia4.setLayout(null);
		panelDia4.setBorder(null);
		panelDia4.setBackground(Color.WHITE);
		panelDia4.setBounds(0, 621, 372, 168);
		panelDias.add(panelDia4);
		
		dia4 = new JTextField();
		dia4.setEnabled(false);
		dia4.setHorizontalAlignment(SwingConstants.CENTER);
		dia4.setFont(new Font("Agency FB", Font.BOLD, 30));
		dia4.setEditable(false);
		dia4.setColumns(10);
		dia4.setBorder(null);
		dia4.setBackground(Color.WHITE);
		dia4.setBounds(10, 12, 352, 36);
		panelDia4.add(dia4);
		
		textRTMax4 = new JTextField();
		textRTMax4.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMax4.setForeground(Color.RED);
		textRTMax4.setFont(new Font("Agency FB", Font.BOLD, 35));
		textRTMax4.setEditable(false);
		textRTMax4.setColumns(10);
		textRTMax4.setBorder(null);
		textRTMax4.setBackground(Color.WHITE);
		textRTMax4.setBounds(30, 80, 88, 47);
		panelDia4.add(textRTMax4);
		
		textRTMin4 = new JTextField();
		textRTMin4.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMin4.setForeground(Color.BLUE);
		textRTMin4.setFont(new Font("Agency FB", Font.BOLD, 35));
		textRTMin4.setEditable(false);
		textRTMin4.setColumns(10);
		textRTMin4.setBorder(null);
		textRTMin4.setBackground(Color.WHITE);
		textRTMin4.setBounds(260, 80, 88, 47);
		panelDia4.add(textRTMin4);
		
		labelIconDia4 = new JLabel("");
		labelIconDia4.setHorizontalAlignment(SwingConstants.CENTER);
		labelIconDia4.setBounds(123, 51, 127, 80);
		panelDia4.add(labelIconDia4);
		
		lblTMax4 = new JLabel("Tª Máxima");
		lblTMax4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTMax4.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTMax4.setBounds(30, 50, 88, 27);
		panelDia4.add(lblTMax4);
		
		lblTMin4 = new JLabel("Tª Mínima");
		lblTMin4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTMin4.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblTMin4.setBounds(260, 50, 88, 27);
		panelDia4.add(lblTMin4);
		
		textRClima4 = new JLabel("");
		textRClima4.setFont(new Font("Agency FB", Font.BOLD, 25));
		textRClima4.setHorizontalAlignment(SwingConstants.CENTER);
		textRClima4.setBounds(10, 135, 352, 28);
		panelDia4.add(textRClima4);
		
		
		
		/**
		 * LABEL DE LAS CIUDADES
		 */
		labelIconoCiudadReal = new JLabel("");
		panelMapa.add(labelIconoCiudadReal);
		//labelIconoCiudadReal.addMouseListener(this);
		labelIconoCiudadReal.setBounds(240, 280, 70, 80);
		
		labelIconoOviedo = new JLabel("");
		panelMapa.add(labelIconoOviedo);
		//labelIconoOviedo.addMouseListener(this);
		labelIconoOviedo.setBounds(150, 10, 70, 80);
		
		labelIconoBarcelona = new JLabel("");
		labelIconoBarcelona.setBounds(515, 120, 70, 80);
		//labelIconoBarcelona.addMouseListener(this);
		panelMapa.add(labelIconoBarcelona);
		
		labelIconoMadrid = new JLabel("");
		labelIconoMadrid.setBounds(250, 180, 70, 80);
		//labelIconoMadrid.addMouseListener(this);
		panelMapa.add(labelIconoMadrid);
		
		labelIconoBenidorm = new JLabel("");
		labelIconoBenidorm.setBounds(410, 290, 70, 80);
		//labelIconoBenidorm.addMouseListener(this);
		panelMapa.add(labelIconoBenidorm);
		
		labelIconoSevilla = new JLabel("");
		labelIconoSevilla.setBounds(160, 360, 70, 80);
		//labelIconoSevilla.addMouseListener(this);
		panelMapa.add(labelIconoSevilla);
		
		labelIconoValladolid = new JLabel("");
		labelIconoValladolid.setBounds(200, 115, 70, 80);
		//labelIconoValladolid.addMouseListener(this);
		panelMapa.add(labelIconoValladolid);
		
		labelIconoZaragoza = new JLabel("");
		labelIconoZaragoza.setBounds(360, 110, 70, 80);
		//labelIconoZaragoza.addMouseListener(this);
		panelMapa.add(labelIconoZaragoza);
		
		textSpain = new JLabel("MAPA DE ESPAÑA");
		textSpain.setHorizontalAlignment(SwingConstants.CENTER);
		textSpain.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 50));
		textSpain.setBounds(10, 730, 610, 54);
		textSpain.setVisible(true);
		panel.add(textSpain);
		
		
		/**
		 * JTEXTFIELD DE LAS CIUDADES
		 */
		textCiudadReal = new JTextField();
		textCiudadReal.setFont(new Font("Agency FB", Font.BOLD, 20));
		textCiudadReal.setBounds(235, 265, 90, 28);
		textCiudadReal.setBorder(null);
		textCiudadReal.setOpaque(false);
		panelMapa.add(textCiudadReal);
		textCiudadReal.setColumns(10);
		
		textOviedo = new JTextField();
		textOviedo.setFont(new Font("Agency FB", Font.BOLD, 20));
		textOviedo.setBounds(155, 0, 90, 28);
		textOviedo.setBorder(null);
		textOviedo.setOpaque(false);
		panelMapa.add(textOviedo);
		textOviedo.setColumns(10);
		
		textMadrid = new JTextField();
		textMadrid.setFont(new Font("Agency FB", Font.BOLD, 20));
		textMadrid.setBounds(257, 175, 90, 28);
		textMadrid.setBorder(null);
		textMadrid.setOpaque(false);
		panelMapa.add(textMadrid);
		textMadrid.setColumns(10);
		
		textSevilla = new JTextField();
		textSevilla.setFont(new Font("Agency FB", Font.BOLD, 20));
		textSevilla.setBounds(168, 347, 91, 28);
		textSevilla.setBorder(null);
		textSevilla.setOpaque(false);
		panelMapa.add(textSevilla);
		textSevilla.setColumns(10);
		
		textBarcelona = new JTextField();
		textBarcelona.setFont(new Font("Agency FB", Font.BOLD, 20));
		textBarcelona.setBounds(515, 105, 90, 28);
		textBarcelona.setBorder(null);
		textBarcelona.setOpaque(false);
		panelMapa.add(textBarcelona);
		textBarcelona.setColumns(10);
		
		textBenidorm = new JTextField();
		textBenidorm.setFont(new Font("Agency FB", Font.BOLD, 20));
		textBenidorm.setBounds(410, 280, 96, 28);
		textBenidorm.setBorder(null);
		textBenidorm.setOpaque(false);
		panelMapa.add(textBenidorm);
		textBenidorm.setColumns(10);
		
		textZaragoza = new JTextField();
		textZaragoza.setFont(new Font("Agency FB", Font.BOLD, 20));
		textZaragoza.setBounds(360, 95, 96, 28);
		textZaragoza.setBorder(null);
		textZaragoza.setOpaque(false);
		panelMapa.add(textZaragoza);
		textZaragoza.setColumns(10);
		
		textValladolid = new JTextField();
		textValladolid.setFont(new Font("Agency FB", Font.BOLD, 20));
		textValladolid.setBounds(200, 105, 96, 28);
		textValladolid.setBorder(null);
		textValladolid.setOpaque(false);
		panelMapa.add(textValladolid);
		textValladolid.setColumns(10);
		
		
		/**
		 * COMBO BOX CIUDADES
		 */

		comboBox.addItem("Madrid");
		comboBox.addItem("Barcelona");
		comboBox.addItem("CiudadReal");
		comboBox.addItem("Oviedo");
		comboBox.addItem("Benidorm");
		comboBox.addItem("Sevilla");
		comboBox.addItem("Valladolid");
		comboBox.addItem("Zaragoza");
		
	}

	/*EVENTOS DEL MOUSE LISTENER
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent evento) {
		// TODO Auto-generated method stub
		if (evento.getSource() == labelIconoCiudadReal){
			textCiudadReal.setText("Ciudad Real");
        }else if(evento.getSource() == labelIconoOviedo) {
        	textOviedo.setText("Oviedo");
        }else if(evento.getSource() == labelIconoMadrid){
        	textMadrid.setText("Madrid");
        }else if(evento.getSource() == labelIconoSevilla) {
        	textSevilla.setText("Sevilla");
        }else if(evento.getSource() == labelIconoBarcelona) {
      	  	textBarcelona.setText("Barcelona");
        }else if(evento.getSource() == labelIconoBenidorm) {
      	  textBenidorm.setText("Benidorm");
        }else if(evento.getSource() == labelIconoZaragoza) {
      	  textZaragoza.setText("Zaragoza");
        }else {
      	  textValladolid.setText("Valladolid");
		}
	}

	@Override
	public void mouseExited(MouseEvent evento) {
		// TODO Auto-generated method stub
		if (evento.getSource() == labelIconoCiudadReal){
			textCiudadReal.setText("");
        }else if(evento.getSource() == labelIconoOviedo) {
        	textOviedo.setText("");
        }else if(evento.getSource() == labelIconoMadrid) {
        	textMadrid.setText("");
        }else if(evento.getSource() == labelIconoSevilla){
        	textSevilla.setText("");
        }else if(evento.getSource() == labelIconoBarcelona) {
      	  textBarcelona.setText("");
        }else if(evento.getSource() == labelIconoBenidorm) {
      	  textBenidorm.setText("");
        }else if(evento.getSource() == labelIconoZaragoza) {
      	  textZaragoza.setText("");
        }else {
			textValladolid.setText("");
		}
	}

	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/
}