package vista;

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

public class Vista extends JFrame {

	/**
	 * Create the frame.
	 */
	private JPanel contentPane;
	public JComboBox<String> comboBox;
	public JButton btnBuscar;
	
	//DIA 1
	public JTextField textRClima1;
	public JTextField textRTMax1;
	public JTextField textRTMin1;
	public JLabel labelIcon;
	
	//DIA 2
	public JTextField textRTMin2;
	public JTextField textRTMax2;
	public JTextField textRClima2;
	
	//DIA 3
	public JTextField textRClima3;
	public JTextField textRTMax3;
	public JTextField textRTMin3;
	
	//DIA 4
	public JTextField textRClima4;
	public JTextField textRTMax4;
	public JTextField textRTMin4;
	
	
	public JPanel panelDias;
	
	
	public JPanel panelDia3;
	public JPanel panelDia4;
	public JTextField textRCiudad;
	private JPanel panelPrincipal;
	private JLabel textCiudad;
	
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		setForeground(new Color(0, 0, 0));
		setTitle("El tiempo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 835);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
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
		panelMapa.setBounds(20, 198, 591, 537);
		panelMapa.setBackground(SystemColor.activeCaption);
		panelMapa.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelMapa.setIcon(new ImageIcon("src\\imagenes\\mapa.png"));
		panel.add(panelMapa);
		
		
		
		
		/**
		 * PANEL DIA 1
		 */
		
		
		
		
		/**
		 * PANEL DIA 2
		 */
		
		
		/**
		 * PANEL DIA 3
		 */
		
		
		
		/**
		 * PANEL DIA 4
		 */
		
		
		
		
		/**
		 * PANEL NOMBRE CIUDAD
		 */
		
		
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
		comboBox.setFont(new Font("Agency FB", Font.BOLD, 30));
		
		btnBuscar= new  JButton("Buscar");
		btnBuscar.setBounds(344, 39, 104, 40);
		panelPrincipal.add(btnBuscar);
		btnBuscar.setFont(new Font("Agency FB", Font.BOLD, 25));
		
		/**
		 * PANEL DIAS
		 */
		
		panelDias = new JPanel();
		panelDias.setBorder(null);
		panelDias.setVisible(false);
		panelDias.setBackground(new Color(255, 255, 255));
		panelDias.setBounds(630, 0, 372, 799);
		panel.add(panelDias);
		panelDias.setLayout(null);
		
		/**
		 * PANEL DIA 1
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
		
		JPanel panelDia1 = new JPanel();
		panelDia1.setBounds(0, 78, 370, 220);
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
		lblTMax1.setBounds(26, 51, 79, 27);
		panelDia1.add(lblTMax1);
		lblTMax1.setFont(new Font("Agency FB", Font.BOLD, 20));
		
		textRTMax1 = new JTextField();
		textRTMax1.setBackground(new Color(255, 255, 255));
		textRTMax1.setBounds(26, 82, 79, 47);
		textRTMax1.setBorder(null);
		panelDia1.add(textRTMax1);
		textRTMax1.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMax1.setEditable(false);
		textRTMax1.setForeground(Color.RED);
		textRTMax1.setFont(new Font("Agency FB", Font.BOLD, 40));
		textRTMax1.setColumns(10);
		
		textRTMin1 = new JTextField();
		textRTMin1.setBackground(new Color(255, 255, 255));
		textRTMin1.setBounds(267, 82, 79, 47);
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
		lblTMin1.setFont(new Font("Agency FB", Font.BOLD, 20));
		
		

		labelIcon = new JLabel("");
		labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		labelIcon.setBounds(115, 10, 138, 122);
		panelDia1.add(labelIcon);
		labelIcon.setBackground(new Color(255, 255, 255));
		
		
		
		/**
		 * PANEL DIA 3
		 */
		panelDia3 = new JPanel();
		panelDia3.setBackground(new Color(255, 255, 255));
		panelDia3.setBounds(0, 459, 372, 140);
		panelDias.add(panelDia3);
		panelDia3.setLayout(null);
		panelDia3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textRClima3 = new JTextField();
		textRClima3.setBackground(new Color(255, 255, 255));
		textRClima3.setBounds(10, 71, 180, 27);
		panelDia3.add(textRClima3);
		textRClima3.setHorizontalAlignment(SwingConstants.RIGHT);
		textRClima3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRClima3.setEditable(false);
		textRClima3.setColumns(10);
		
		JLabel lblTMax3 = new JLabel("T Maxima");
		lblTMax3.setBounds(202, 34, 76, 27);
		panelDia3.add(lblTMax3);
		lblTMax3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textRTMax3 = new JTextField();
		textRTMax3.setBackground(new Color(255, 255, 255));
		textRTMax3.setBounds(202, 61, 76, 27);
		panelDia3.add(textRTMax3);
		textRTMax3.setHorizontalAlignment(SwingConstants.RIGHT);
		textRTMax3.setForeground(Color.RED);
		textRTMax3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRTMax3.setEditable(false);
		textRTMax3.setColumns(10);
		
		JLabel lblTMin3 = new JLabel("T Minima");
		lblTMin3.setBounds(310, 34, 81, 27);
		panelDia3.add(lblTMin3);
		lblTMin3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textRTMin3 = new JTextField();
		textRTMin3.setBackground(new Color(255, 255, 255));
		textRTMin3.setBounds(310, 61, 81, 27);
		panelDia3.add(textRTMin3);
		textRTMin3.setHorizontalAlignment(SwingConstants.RIGHT);
		textRTMin3.setForeground(Color.BLUE);
		textRTMin3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRTMin3.setEditable(false);
		textRTMin3.setColumns(10);
		
		JLabel lblClima3 = new JLabel("Clima");
		lblClima3.setBackground(new Color(255, 255, 255));
		lblClima3.setBounds(10, 34, 152, 27);
		panelDia3.add(lblClima3);
		lblClima3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		/**
		 * PANEL DIA 2
		 */
		JPanel panelDia2 = new JPanel();
		panelDia2.setBackground(new Color(255, 255, 255));
		panelDia2.setBounds(0, 309, 372, 140);
		panelDias.add(panelDia2);
		panelDia2.setLayout(null);
		panelDia2.setBorder(null);
		
		textRClima2 = new JTextField();
		textRClima2.setBackground(new Color(255, 255, 255));
		textRClima2.setBounds(10, 85, 180, 27);
		panelDia2.add(textRClima2);
		textRClima2.setHorizontalAlignment(SwingConstants.RIGHT);
		textRClima2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRClima2.setEditable(false);
		textRClima2.setColumns(10);
		
		JLabel lblTMax2 = new JLabel("T Maxima");
		lblTMax2.setBounds(216, 34, 78, 27);
		panelDia2.add(lblTMax2);
		lblTMax2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textRTMax2 = new JTextField();
		textRTMax2.setBackground(new Color(255, 255, 255));
		textRTMax2.setBounds(215, 71, 79, 27);
		panelDia2.add(textRTMax2);
		textRTMax2.setHorizontalAlignment(SwingConstants.RIGHT);
		textRTMax2.setForeground(Color.RED);
		textRTMax2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRTMax2.setEditable(false);
		textRTMax2.setColumns(10);
		
		JLabel lblTMin2 = new JLabel("T Minima");
		lblTMin2.setBounds(304, 34, 72, 27);
		panelDia2.add(lblTMin2);
		lblTMin2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textRTMin2 = new JTextField();
		textRTMin2.setBackground(new Color(255, 255, 255));
		textRTMin2.setBounds(304, 71, 76, 27);
		panelDia2.add(textRTMin2);
		textRTMin2.setHorizontalAlignment(SwingConstants.RIGHT);
		textRTMin2.setForeground(Color.BLUE);
		textRTMin2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRTMin2.setEditable(false);
		textRTMin2.setColumns(10);
		panelDia4 = new JPanel();
		panelDia4.setBounds(0, 609, 373, 140);
		panelDias.add(panelDia4);
		panelDia4.setBackground(new Color(255, 255, 255));
		panelDia4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDia4.setLayout(null);
		
		textRClima4 = new JTextField();
		textRClima4.setBackground(new Color(255, 255, 255));
		textRClima4.setBounds(71, 89, 180, 27);
		panelDia4.add(textRClima4);
		textRClima4.setBorder(null);
		textRClima4.setHorizontalAlignment(SwingConstants.CENTER);
		textRClima4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRClima4.setEditable(false);
		textRClima4.setColumns(10);
		
		textRTMax4 = new JTextField();
		textRTMax4.setBackground(new Color(255, 255, 255));
		textRTMax4.setBounds(10, 52, 76, 27);
		panelDia4.add(textRTMax4);
		textRTMax4.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMax4.setForeground(Color.RED);
		textRTMax4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRTMax4.setEditable(false);
		textRTMax4.setColumns(10);
		
		textRTMin4 = new JTextField();
		textRTMin4.setBackground(new Color(255, 255, 255));
		textRTMin4.setBounds(234, 52, 81, 27);
		panelDia4.add(textRTMin4);
		textRTMin4.setHorizontalAlignment(SwingConstants.CENTER);
		textRTMin4.setForeground(Color.BLUE);
		textRTMin4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textRTMin4.setEditable(false);
		textRTMin4.setColumns(10);
		
		/**
		 * COMBO BOX
		 */
		comboBox.addItem("Madrid");
		comboBox.addItem("Barcelona");
		comboBox.addItem("CiudadReal");
		comboBox.addItem("Oviedo");
		comboBox.addItem("Benidorm");
		comboBox.addItem("Sevilla");
		comboBox.addItem("Toledo");
		comboBox.addItem("Zaragoza");
		
	}
}
