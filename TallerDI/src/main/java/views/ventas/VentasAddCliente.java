package views.ventas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ClienteDAO;
import models.Usuario;
import views.LoginV;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VentasAddCliente extends JFrame implements MouseListener,ActionListener{


	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnAdd;
	protected JLabel lblNombre;
	protected JLabel lblApellidos;
	protected JLabel lblTelefono;
	protected JLabel lblDni,lblAddOk;
	protected JTextField tFNombre;
	protected JTextField tFApellidos;
	protected JTextField tFTelefono;
	protected JTextField tFDni;
	protected ClienteDAO miClienteDao;
	protected ImageIcon imgUsu;

	/**
	 * Create the application.
	 */
	public VentasAddCliente(Usuario miUsuario) {
		miClienteDao = new ClienteDAO();
		miUser = miUsuario;
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//iniciamos y damos las propiedades al frame 
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color( 244, 162, 97));
		getContentPane().setLayout(null);
		
		//Iniciamos todos los componentes 
		this.iniciarComponentes();
		//Ponemos sus layouts
		this.ponerLayoutsComponentes();
		//Damos color a los paneles, botones y lineas 
		this.darColorComponentes();
		//Damos el tamaño a los componentes que están en absoluto
		this.colocarComponentes();
		//Damos el tamaño, fuente y color a las letras 
		this.addPropiedadesLetras();
		//Añadimos los componentes al frame 
		this.addComponentes();
		
		this.setVisible(true);
	}
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasGenerico ventanaVentasG;
		
		String txtBtn = e.getActionCommand();
		
		switch (txtBtn) {
		case "Volver":
			
			this.setVisible(false);
			this.dispose();
			ventanaVentasG = new VentasGenerico(miUser);			
			break;
			
		case "Registrar":
			
			lblAddOk.setVisible(false);
			miClienteDao.addCliente(
					tFNombre.getText(), tFApellidos.getText(), tFTelefono.getText(), tFDni.getText());
			lblAddOk.setVisible(true);
			tFNombre.setText("");
			tFApellidos.setText("");
			tFTelefono.setText("");
			tFDni.setText("");
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
	 * Método interno para iniciar los componentes
	 */
	private void iniciarComponentes() {
		
		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesion");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Alta clientes");
		lblNombre = new JLabel("Nombre: ");
		lblApellidos = new JLabel("Apellidos:");
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblDni = new JLabel("DNI:");
		tFNombre = new JTextField();
		tFApellidos = new JTextField();
		tFTelefono = new JTextField();
		tFDni = new JTextField();		
		btnVolver = new JButton("Volver");
		btnAdd = new JButton("Registrar");
		lblAddOk = new JLabel("CLIENTE REGISTRADO CON \u00C9XITO");
		lblAddOk.setVisible(false);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnAdd.addActionListener(this);
	}
	/**
	 * Metodo para poner a los paneles y label los layout que necesitan
	 */
	private void ponerLayoutsComponentes() {
		
		panelDepartamento.setLayout(new BorderLayout(0, 0));
		panelUsuario.setLayout(null);
		panelContenido.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddOk.setHorizontalAlignment(SwingConstants.CENTER);
	}
	/**
	 * Método interno para dar color a los componenetes (botones, lineas, labels, panels...)
	 */
	private void darColorComponentes() {
		
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelContenido.setBackground(new java.awt.Color( 244, 162, 97));
		panelInfo.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelInfo.setBackground(new java.awt.Color( 244, 162, 97));
		btnVolver.setBackground(new java.awt.Color(119, 14, 38));
		btnAdd.setBackground(new java.awt.Color(0,92,48));
		lblAddOk.setBackground(new java.awt.Color(0,92,48));
	}
	/**
	 * Método para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(-2, 76, 786, 485);
		panelInfo.setBounds(281, 0, 228, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		lblNombre.setBounds(236, 97, 106, 30);
		lblApellidos.setBounds(236, 160, 99, 30);
		lblTelefono.setBounds(236, 229, 99, 30);
		lblDni.setBounds(236, 295, 106, 30);
		tFNombre.setBounds(376, 100, 222, 27);
		tFApellidos.setBounds(376, 165, 222, 27);
		tFTelefono.setBounds(376, 234, 222, 27);
		tFDni.setBounds(376, 295, 222, 27);
		btnVolver.setBounds(153, 391, 117, 35);
		btnAdd.setBounds(516, 391, 117, 35);
		lblAddOk.setBounds(258, 40, 276, 41);
	}
	/**
	 * Método para darle la fuentes a las letras de los componentes
	 */
	private void addPropiedadesLetras() {
		
		lblDepartamento.setForeground(new java.awt.Color(38, 70, 83));
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(new java.awt.Color(38, 70, 83));
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(new java.awt.Color(38, 70, 83));
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaClientes.setForeground(new java.awt.Color(38, 70, 83));
		lblNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTelefono.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblDni.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFNombre.setColumns(10);
		tFApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFApellidos.setColumns(10);
		tFApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFTelefono.setColumns(10);
		tFTelefono.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFDni.setColumns(10);
		tFDni.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnAdd.setForeground(Color.WHITE);
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
	}
	/**
	 * Método para añadir todos los componentes al panel principal 
	 */
	private void addComponentes() {
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
		panelInfo.add(lblAltaClientes);		
		panelContenido.add(lblNombre);		
		panelContenido.add(lblApellidos);		
		panelContenido.add(lblTelefono);		
		panelContenido.add(lblDni);		
		panelContenido.add(tFNombre);		
		panelContenido.add(tFApellidos);		
		panelContenido.add(tFTelefono);		
		panelContenido.add(tFDni);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnAdd);
		panelContenido.add(lblAddOk);
	}
}
