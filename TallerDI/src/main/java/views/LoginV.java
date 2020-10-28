package views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class LoginV extends JPanel implements ActionListener{

	private JFrame frame;
	private JTextField tFUsuario;
	private JPasswordField pFPassword;
	protected JLabel lblUsuario,lblPassword;
	protected JButton btnNewButton;
	protected JPanel panelPrincipal, panelSuperior,panelInferior,panelVacioIzquierda,
					 panelContenido,panelUsuario,panelPassword,panelVacioDerecha,panelButton;
	
	/**
	 * Create the application.
	 */
	public LoginV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon img;
		FlowLayout flowLayoutU;
		FlowLayout flowLayoutP;
		
		//Iniciamos y damos las propiedades al frame
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.setTitle("APP TALLER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//Iniciamos todos los componentes 
		panelPrincipal = new JPanel();
		panelSuperior = new JPanel();
		panelInferior = new JPanel();
		panelVacioIzquierda = new JPanel();
		panelContenido = new JPanel();
		panelVacioDerecha = new JPanel();
		panelUsuario = new JPanel();
		panelPassword = new JPanel();
		panelButton = new JPanel();
		img = new ImageIcon("imagenModificada.png");
		lblUsuario = new JLabel("Usuario");
		tFUsuario = new JTextField();
		lblPassword = new JLabel("Password");
		pFPassword = new JPasswordField();
		btnNewButton = new JButton("Iniciar sesi�n");
		btnNewButton.addActionListener(this);
		
		//Ponemos sus layout
		frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new GridLayout(2, 0, 0, 0));
		panelInferior.setLayout(new GridLayout(0, 3, 0, 0));
		panelContenido.setLayout(new GridLayout(3, 0, 0, 0));
		flowLayoutU = (FlowLayout) panelUsuario.getLayout();
		flowLayoutU.setHgap(10);
		flowLayoutP = (FlowLayout) panelPassword.getLayout();
		flowLayoutP.setHgap(10);
		
		//Damos color a todos los paneles
		panelSuperior.setBackground(new java.awt.Color( 42, 216, 240));
		panelVacioIzquierda.setBackground(new java.awt.Color( 42, 216, 240));
		panelUsuario.setBackground(new java.awt.Color( 42, 216, 240));
		panelPassword.setBackground(new java.awt.Color( 42, 216, 240));
		panelButton.setBackground(new java.awt.Color( 42, 216, 240));
		panelVacioDerecha.setBackground(new java.awt.Color( 42, 216, 240));
		
		//Damos las propiedades a la fuente, espacio de los textfield...
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		tFUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		tFUsuario.setColumns(15);				
		lblPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		pFPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		pFPassword.setColumns(15);
		btnNewButton.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));

		//A�adidmos a los paneles todos los paneles con los tF,JLabel,coloreados...
		panelPrincipal.add(panelSuperior);
		panelPrincipal.add(panelInferior);
		//A�adimos la imagen al panel superior
		panelSuperior.add(new JLabel(img));
		//A�adimos 3 paneles a la parte inferior para el GridLayout
		panelInferior.add(panelVacioIzquierda);
		panelInferior.add(panelContenido);
		panelInferior.add(panelVacioDerecha);
		//El le a�adimos al panel del contenido 3 paneles para meter label y Tf en cada uno
		panelContenido.add(panelUsuario);
		panelContenido.add(panelPassword);
		panelContenido.add(panelButton);
		//A�adimos label y textield de usuario y contrase�a a sus paneles y el bot�n
		panelUsuario.add(lblUsuario);
		panelUsuario.add(tFUsuario);		
		panelPassword.add(lblPassword);
		panelPassword.add(pFPassword);		
		panelButton.add(btnNewButton);
	
		this.frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {

		
	}
}
