package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConcesionarioDAO;
import dao.UsuarioDAO;
import models.Usuario;


public class JefeAddUsuario extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaUsu,lblTlfn,lblRol;
	protected JButton btnVolver,btnRegistrar;
	protected JLabel lblNombreUsu;
	protected JLabel lblPassword;
	protected JLabel lblNombre;
	protected JLabel lblApellidos,lblAddOk;
	protected JLabel lblEspeMoto;
	protected JLabel lblSueldo,lblMecaJefe,lblConcesionario;
	protected JTextField tFUsuario;
	protected JPasswordField tFPassWord;
	protected JTextField tFNombre;
	protected JTextField tFTlfn,tFSueldo;
	protected UsuarioDAO miUsuarioDao;
	protected ConcesionarioDAO miConcesionarioDao;
	protected JComboBox comboRol,comboConcesionarios,comboMJefe,comboMCoche,comboMMoto,comboMMotoC;
	private JTextField tFApellidos;
	
	/**
	 * Create the application.
	 */
	public JefeAddUsuario(Usuario miUsuario) {
		miUsuarioDao = new UsuarioDAO();
		miConcesionarioDao = new ConcesionarioDAO();
		miUser = miUsuario;
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon imgUsu;
		ArrayList<String> listaConcesionarios;
	
		//iniciamos y damos las propiedades al frame 
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color( 244, 162, 97));
		getContentPane().setLayout(null);

		//Iniciamos todos los componentes 
		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("JEFE");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesion");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaUsu = new JLabel("Alta usuario");
		lblNombreUsu = new JLabel("Usuario:");
		lblPassword = new JLabel("Password:");
		lblNombre = new JLabel("Nombre:");
		lblApellidos = new JLabel("Apellidos:");
		lblEspeMoto = new JLabel("Especialidad moto:");
		lblSueldo =  new JLabel("Sueldo:");
		lblMecaJefe = new JLabel("Mecanico jefe:");
		lblConcesionario = new JLabel("Concesionario:");	
		tFUsuario = new JTextField();
		tFPassWord = new JPasswordField();;
		tFNombre = new JTextField();
		tFTlfn = new JTextField();
		
		tFSueldo = new JTextField();
		tFApellidos = new JTextField();
		lblTlfn = new JLabel("Tel\u00E9fono:");
		lblRol = new JLabel("Rol empresa:");
		btnVolver = new JButton("Volver");
		btnRegistrar = new JButton("Registrar");
		lblAddOk = new JLabel("VEHÍCULO AÑADIDO");
		lblAddOk.setVisible(false);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnRegistrar.addActionListener(this);
		
		//Ponemos sus layouts
		panelDepartamento.setLayout(new BorderLayout(0, 0));
		panelUsuario.setLayout(null);
		panelContenido.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombreUsu.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddOk.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelContenido.setBackground(new java.awt.Color( 244, 162, 97));
		panelInfo.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelInfo.setBackground(new java.awt.Color( 244, 162, 97));
		btnVolver.setBackground(new java.awt.Color(119, 14, 38));
		btnRegistrar.setBackground(new java.awt.Color(0,92,48));
		lblAddOk.setBackground(new java.awt.Color(0,92,48));
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(0, 76, 786, 485);
		panelInfo.setBounds(281, 0, 228, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		
		lblNombreUsu.setBounds(30, 109, 119, 30);
		lblPassword.setBounds(30, 150, 119, 30);
		lblNombre.setBounds(30, 191, 119, 30);
		lblApellidos.setBounds(30, 232, 119, 30);

		lblSueldo.setBounds(30, 314, 119, 30); 
		lblMecaJefe.setBounds(354, 150, 184, 30); 
		lblEspeMoto.setBounds(354, 232, 212, 30);
		lblConcesionario.setBounds(354, 314, 155, 30); 	
		tFUsuario.setBounds(129, 111, 202, 27);
		tFPassWord.setBounds(129, 152, 202, 27);
		tFNombre.setBounds(129, 193, 202, 27);

		tFSueldo.setBounds(129, 316, 202, 27);
		tFTlfn.setBounds(129, 276, 202, 27);

		tFApellidos.setBounds(129, 234, 202, 27);
		lblTlfn.setBounds(30, 273, 142, 30);
		lblRol.setBounds(354, 109, 173, 30);
		btnVolver.setBounds(153, 420, 117, 35);
		btnRegistrar.setBounds(515, 420, 117, 35);
		lblAddOk.setBounds(258, 40, 276, 41);
		
		//Damos el tamaño, fuente y color a las letras 
		lblDepartamento.setForeground(new java.awt.Color(38, 70, 83));
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(new java.awt.Color(38, 70, 83));
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(new java.awt.Color(38, 70, 83));
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaUsu.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaUsu.setForeground(new java.awt.Color(38, 70, 83));
		lblNombreUsu.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblPassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblEspeMoto.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblSueldo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblMecaJefe.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblConcesionario.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 			
		tFUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFUsuario.setColumns(10);
		tFPassWord.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFPassWord.setColumns(10);
		tFPassWord.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFNombre.setColumns(10);
		tFNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTlfn.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblRol.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		tFTlfn.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFSueldo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnRegistrar.setForeground(Color.WHITE);
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		
		//Añadimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		//Añadimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);				
		//Añadimos el panel informativo, labels, textfield y botones 
		panelContenido.add(panelInfo);
		panelInfo.add(lblAltaUsu);	
		
		panelContenido.add(lblNombreUsu);		
		panelContenido.add(lblPassword);		
		panelContenido.add(lblNombre);		
		panelContenido.add(lblApellidos);
		panelContenido.add(lblEspeMoto);
		panelContenido.add(lblSueldo);
		panelContenido.add(lblMecaJefe);
		panelContenido.add(lblConcesionario);
		
		panelContenido.add(tFUsuario);		
		panelContenido.add(tFPassWord);		
		panelContenido.add(tFNombre);		
		panelContenido.add(tFTlfn);		
		panelContenido.add(tFSueldo);					
		panelContenido.add(tFApellidos);		
		panelContenido.add(lblTlfn);		
		panelContenido.add(lblRol);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnRegistrar);
		panelContenido.add(lblAddOk);
		
		comboRol = new JComboBox();
		comboRol.addItem("");
		comboRol.addItem("Ventas");
		comboRol.addItem("Mecánico");
		comboRol.setSelectedItem("");
		comboRol.addActionListener(this);
		comboRol.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboRol.setBounds(588, 111, 172, 27);
		panelContenido.add(comboRol);
		
		comboConcesionarios = new JComboBox();
		listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(0);
		comboConcesionarios.addItem("");
		for (int i = 0; i < listaConcesionarios.size(); i++) {
			comboConcesionarios.addItem(listaConcesionarios.get(i));
		}
		comboConcesionarios.setSelectedItem("");
		comboConcesionarios.addActionListener(this);
		comboConcesionarios.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboConcesionarios.setBounds(588, 316, 172, 27);
		panelContenido.add(comboConcesionarios);
		
		comboMJefe = new JComboBox();
		comboMJefe.addItem("No");
		comboMJefe.addItem("Sí");
		comboMJefe.setSelectedItem("No");
		comboMJefe.addActionListener(this);
		comboMJefe.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboMJefe.setBounds(588, 150, 172, 27);
		panelContenido.add(comboMJefe);
		
		
		comboMCoche = new JComboBox();
		comboMCoche.addItem("No");
		comboMCoche.addItem("Sí");
		comboMCoche.setSelectedItem("No");
		comboMCoche.addActionListener(this);
		comboMCoche.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboMCoche.setBounds(588, 191, 172, 27); 
		panelContenido.add(comboMCoche);
		
		comboMMotoC = new JComboBox();
		comboMMotoC.addItem("No");
		comboMMotoC.addItem("Sí");
		comboMMotoC.setSelectedItem("No");
		comboMMotoC.addActionListener(this);
		comboMMotoC.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboMMotoC.setBounds(588, 273, 172, 27);
		panelContenido.add(comboMMotoC);
		
		comboMMoto= new JComboBox();
		comboMMoto.addItem("No");
		comboMMoto.addItem("Sí");
		comboMMoto.setSelectedItem("No");
		comboMMoto.addActionListener(this);
		comboMMoto.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboMMoto.setBounds(588, 232, 172, 27);
		panelContenido.add(comboMMoto);
		
		JLabel lblEspeCoches = new JLabel("Especialidad coche:");
		lblEspeCoches.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblEspeCoches.setBounds(354, 191, 184, 30);
		panelContenido.add(lblEspeCoches);
		
		JLabel lblEspecialidadMotocicleta = new JLabel("Especialidad motocicleta:");
		lblEspecialidadMotocicleta.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblEspecialidadMotocicleta.setBounds(354, 273, 247, 30);
		panelContenido.add(lblEspecialidadMotocicleta);
		
					
		this.setVisible(true);
	}
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		JefeGenerico ventanaGenerica;
		String txtBtn = e.getActionCommand();
		String idConcesionario;
		int insertJefe = this.compruebaCombos(comboMJefe.getSelectedItem().toString());
		int insertEspCoche =this.compruebaCombos(comboMCoche.getSelectedItem().toString());
		int insertEspMoto = this.compruebaCombos(comboMMoto.getSelectedItem().toString());
		int insertEspeCiclo = this.compruebaCombos(comboMMotoC.getSelectedItem().toString());
		boolean todoOk =false;
		String pass = new String(tFPassWord.getPassword());
		pass= this.getMD5(pass);
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaGenerica = new JefeGenerico(miUser);			
			break;
			
		case "Registrar":
			
			idConcesionario = miConcesionarioDao.buscarIDConcesionario(comboConcesionarios.getSelectedItem().toString())+"";
			
			todoOk = miUsuarioDao.addUsuario(tFUsuario.getText(), pass, tFNombre.getText(),
					tFApellidos.getText(),tFTlfn.getText(), tFSueldo.getText(),comboRol.getSelectedItem().toString(), 
					insertJefe,insertEspCoche,insertEspMoto,insertEspeCiclo, idConcesionario);
			if(todoOk) {
				
				tFUsuario.setText("");
				tFPassWord.setText("");
				tFNombre.setText("");
				tFApellidos.setText("");
				tFTlfn.setText("");
				tFSueldo.setText("");
				comboRol.setSelectedItem("");
				comboConcesionarios.setSelectedItem("");
				comboMCoche.setSelectedItem("No");
				comboMJefe.setSelectedItem("No");
				comboMMoto.setSelectedItem("No");
				comboMMotoC.setSelectedItem("No");
				JOptionPane.showMessageDialog(this, "Usuario registrado con exito");
			}else {
				JOptionPane.showMessageDialog(this, "El usuario no se ha registrado");
			}
			break;


		}
		
	}
	/**
	 * Método para que cuando se pulse el ratón en el label que lo tenga agenciado
	 * en este caso el de cerrar sesión, se cierre la sesión
	 */
	@SuppressWarnings("unused")
	@Override
	public void mouseClicked(MouseEvent e) {
		LoginV loginCerrarSesion;
		
		this.setVisible(false);
		this.dispose();
		miUser = null;
		loginCerrarSesion = new LoginV();

    }
	
	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}
	/**
	 * Método para cambiar lo que nos da el combo y le devolvemos un 0 si es NO y 1 si es Sí
	 * @param contenido
	 * @return resultado
	 */
	private int compruebaCombos(String contenido) {
		int resultado = 0;
		
		if(!contenido.equals("No")) {
			resultado = 1;
		}
		return resultado;
	}
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