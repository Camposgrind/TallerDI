package views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.UsuarioDAO;
import models.Usuario;
import views.ventas.VentasGenerico;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class LoginV extends JFrame implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8657198232727133443L;
	private JTextField tFUsuario;
	private JPasswordField pFPassword;
	protected JLabel lblUsuario,lblPassword,lblLogin;
	protected JButton btnNewButton;
	protected UsuarioDAO miUsuarioDao;
	protected Usuario miUsuario;
	private JPanel panel;
	
	
	/**
	 * Create the application.
	 */
	public LoginV() {
		getContentPane().setBackground(new java.awt.Color(233, 196, 106));
		initialize();
		miUsuarioDao = new UsuarioDAO();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ImageIcon img;
		
		//Iniciamos y damos las propiedades al frame
	
		this.setBounds(100, 100, 800, 600);
		this.setResizable(false);
		this.setTitle("PICARSO - INICIAR SESI\u00D3N");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		img = new ImageIcon("assets/logoLogin.png");
		getContentPane().setLayout(null);
		lblLogin = new JLabel("Usuario o contrase�a incorrecta");
		lblLogin.setForeground(Color.RED);
		lblLogin.setBounds(285, 413, 269, 36);
		getContentPane().add(lblLogin);
		lblLogin.setVisible(false);
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton = new JButton("Iniciar sesi�n");
		
		btnNewButton.setBounds(285, 449, 229, 45);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(205, 326, 114, 36);
		getContentPane().add(lblUsuario);
		
		//Damos las propiedades a la fuente, espacio de los textfield...
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 20));
		pFPassword = new JPasswordField();
		pFPassword.setBounds(319, 380, 269, 26);
		getContentPane().add(pFPassword);
		pFPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		pFPassword.setColumns(15);
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(205, 373, 114, 36);
		getContentPane().add(lblPassword);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 20));
		tFUsuario = new JTextField();
		tFUsuario.setBounds(319, 333, 269, 26);
		getContentPane().add(tFUsuario);
		tFUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		tFUsuario.setColumns(15);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 774, 299);
		getContentPane().add(panel);
		panel.add(new JLabel(img));
		panel.setBackground(new java.awt.Color(233, 196, 106));
		//Este m�todo es para que puedas darle al intro y avance
		//Solo vale para cuando hay un bot�n en la pantalla
		this.getRootPane().setDefaultButton(btnNewButton);
		this.setVisible(true);
	}
	/**
	 * M�todo para cuando se pulse el bot�n de iniciar sesi�n
	 */
	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent e) {
		//Pillamos la contrase�a del textfield
		String pass = new String(pFPassword.getPassword());		
		VentasGenerico ventanaV;
		JefeGenerico ventanaJ;
		MecanicoGenerico ventanaM;
		pass= this.getMD5(pass);
		
		miUsuario = miUsuarioDao.testLogin(tFUsuario.getText(),pass);	

		if(miUsuario!=null) {
			String rol = miUsuario.getRol();
			//si el usuario no es null, ponemos el label invisible
			lblLogin.setVisible(false);
			
			switch (rol) {
			case "Ventas":
				this.setVisible(false);
				dispose();
				ventanaV = new VentasGenerico(miUsuario);
				break;
			case "Jefe":
				this.setVisible(false);
				ventanaJ = new JefeGenerico(miUsuario);
				break;
			case "Mec�nico":
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
	
	
	/**
	 * M�todo interno para cambiar la contrase�a a MD5 
	 * @param input
	 * @return
	 */
	private String getMD5(String input) {
		
		try {
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] messageDigest = md.digest(input.getBytes());
			 BigInteger number = new BigInteger(1, messageDigest);
			 String hashtext = number.toString(16);

			 while (hashtext.length() < 32) {
				 hashtext = "0" + hashtext;
			 }
			 
			 return hashtext;
			 }
		
			 catch (NoSuchAlgorithmException e) {
				 throw new RuntimeException(e);
			 }
		
	}
}
