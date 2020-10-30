package views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.UsuarioDAO;
import models.Usuario;

import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class LoginV extends JFrame implements ActionListener{

	
	private JTextField tFUsuario;
	private JPasswordField pFPassword;
	protected JLabel lblUsuario,lblPassword,lblLogin;
	protected JButton btnNewButton;
	protected JPanel panelPrincipal, panelSuperior,panelInferior,panelVacioIzquierda,
					 panelContenido,panelUsuario,panelPassword,panelVacioDerecha,panelButton;
	protected UsuarioDAO miUsuarioDao;
	protected Usuario miUsuario;
	
	/**
	 * Create the application.
	 */
	public LoginV() {
		initialize();
		miUsuarioDao = new UsuarioDAO();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon img;
		FlowLayout flowLayoutU;
		FlowLayout flowLayoutP;
		
		//Iniciamos y damos las propiedades al frame
	
		this.setBounds(100, 100, 800, 600);
		this.setResizable(false);
		this.setTitle("APP TALLER");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
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
		lblLogin = new JLabel("Usuario o contraseña incorrecta");
		lblLogin.setVisible(false);
		btnNewButton = new JButton("Iniciar sesión");
		btnNewButton.addActionListener(this);
		
		//Ponemos sus layout
		this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
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
		lblLogin.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		btnNewButton.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));

		//Añadidmos a los paneles todos los paneles con los tF,JLabel,coloreados...
		panelPrincipal.add(panelSuperior);
		panelPrincipal.add(panelInferior);
		//Añadimos la imagen al panel superior
		panelSuperior.add(new JLabel(img));
		//Añadimos 3 paneles a la parte inferior para el GridLayout
		panelInferior.add(panelVacioIzquierda);
		panelInferior.add(panelContenido);
		panelInferior.add(panelVacioDerecha);
		//El le añadimos al panel del contenido 3 paneles para meter label y Tf en cada uno
		panelContenido.add(panelUsuario);
		panelContenido.add(panelPassword);
		panelContenido.add(panelButton);
		//Añadimos label y textield de usuario y contraseña a sus paneles y el botón
		panelUsuario.add(lblUsuario);
		panelUsuario.add(tFUsuario);		
		panelPassword.add(lblPassword);
		panelPassword.add(pFPassword);		
		
		
		panelPassword.add(lblLogin);
		panelButton.add(btnNewButton);
	
		this.setVisible(true);
	}
	/**
	 * Método para cuando se pulse el botón de iniciar sesión
	 */
	public void actionPerformed(ActionEvent e) {
		//Pillamos la contraseña del textfield
		String pass = new String(pFPassword.getPassword());		
		VentasGenerico ventanaV;
		JefeGenerico ventanaJ;
		MecanicoGenerico ventanaM;
		miUsuario = miUsuarioDao.testLogin(tFUsuario.getText(),pass);	

		if(miUsuario!=null) {
			String rol = miUsuario.getRol();
			//si el usuario no es null, ponemos el label invisible
			lblLogin.setVisible(false);
			
			switch (rol) {
			case "ventas":
				this.setVisible(false);
				dispose();
				ventanaV = new VentasGenerico(miUsuario);
				break;
			case "jefe":
				this.setVisible(false);
				ventanaJ = new JefeGenerico(miUsuario);
				break;
			case "mecanico":
				this.setVisible(false);
				dispose();
				ventanaM = new MecanicoGenerico(miUsuario);
				break;		
			}			
		}else {
			//si es null ponemos el label de aviso verdadero
			lblLogin.setVisible(true);
		}
	}
}
