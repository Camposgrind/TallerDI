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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ClienteDAO;
import models.Cliente;
import models.Usuario;
import views.LoginV;

@SuppressWarnings("serial")
public class VentasModificarCliente extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnModificar;
	protected JLabel lblNombre;
	protected JLabel lblApellidos;
	protected JLabel lblTelefono;
	protected JLabel lblDni,lblModificacionOK;
	protected JTextField tFNombre;
	protected JTextField tFApellidos;
	protected JTextField tFTelefono;
	protected JTextField tFDni;
	protected ClienteDAO miClienteDao;
	protected Cliente miCliente;
	protected VentasPropuestaVenta ventanaPropuesta;
	
	/**
	 * Create the application.
	 */
	public VentasModificarCliente(Usuario miUsuario,Cliente miCliente,VentasPropuestaVenta miVentanaPropuesta) {
		setTitle("piCARso - Ventas");
		miClienteDao = new ClienteDAO();
		ventanaPropuesta = miVentanaPropuesta;
		miUser = miUsuario;
		this.miCliente = miCliente;
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
		
		//iniciamos todos los componentes
		this.iniciarComponentes();
		
		//Ponemos sus layouts
		this.ponerLayoutsComponentes();
		
		//Damos color a los paneles, botones y lineas 
		this.darColorComponentes();
		
		//Damos el tama�o a los componentes que est�n en absoluto
		this.colocarComponentes();
		
		//Damos el tama�o, fuente y color a las letras 
		this.addPropiedadesLetras();
		
		//A�adimos los componentes al panel principal los paneles	
		this.addComponentes();
					
		this.setVisible(true);
	}
	
	
	/**
	 * M�todo para cuando se pulse alg�n bot�n
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean todoOk = false;
		String txtBtn = e.getActionCommand();
		VentasFichaCliente ventanaFicha;		
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaFicha = new VentasFichaCliente(miUser, miCliente, null,ventanaPropuesta);
			break;
			
		case "Modificar":			
			lblModificacionOK.setVisible(false);
			miCliente = miClienteDao.modificarCliente(tFNombre.getText(), tFApellidos.getText(),
					tFTelefono.getText(),tFDni.getText(),miCliente);			
			
			lblModificacionOK.setVisible(true);
			this.setVisible(false);
			ventanaFicha = new VentasFichaCliente(miUser, miCliente, null,ventanaPropuesta);
			
			break;

		}
		
	}	
	
	
	
	/**
	 * M�todo para que cuando se pulse el rat�n en el label que lo tenga agenciado
	 * en este caso el de cerrar sesi�n, se cierre la sesi�n
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
	 * M�todo interno para iniciar los componentes
	 */
	private void iniciarComponentes() {

		ImageIcon imgUsu;
		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesi�n");
		imgUsu = new ImageIcon("assets/FotosUsuario/FotoUsuario"+miUser.getIdUsuario()+".jpg");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Modificar Cliente");
		lblNombre = new JLabel("Nombre: ");
		lblApellidos = new JLabel("Apellidos:");
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblDni = new JLabel("DNI:");
		tFNombre = new JTextField(miCliente.getNombre());
		tFApellidos = new JTextField(miCliente.getApellidos());
		tFTelefono = new JTextField(miCliente.getTelefono());
		tFDni = new JTextField(miCliente.getDni());		
		btnVolver = new JButton("Volver");
		btnModificar = new JButton("Modificar");
		lblModificacionOK = new JLabel("CLIENTE MODIFICADO");
		lblModificacionOK.setVisible(false);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnModificar.addActionListener(this);
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
		lblModificacionOK.setHorizontalAlignment(SwingConstants.CENTER);
	}
	/**
	 * M�todo interno para dar color a los componenetes (botones, lineas, labels, panels...)
	 */
	private void darColorComponentes() {
		
		panelDepartamento.setBackground(new java.awt.Color(233, 196, 106));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color(233, 196, 106));
		panelContenido.setBackground(new java.awt.Color(233, 196, 106));
		panelInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelInfo.setBackground(new java.awt.Color(233, 196, 106));
		btnVolver.setBackground(new java.awt.Color(231, 111, 81));
		btnModificar.setBackground(new java.awt.Color(42, 157, 143));
		lblModificacionOK.setBackground(new java.awt.Color(0,92,48));
	}
	/**
	 * M�todo para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		
		panelUsuario.setBounds(393, 0, 391, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(0, 76, 784, 484);
		panelInfo.setBounds(0, 0, 784, 41);
		
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
		btnVolver.setBounds(153, 391, 150, 50);
		btnModificar.setBounds(483, 391, 150, 50);
		lblModificacionOK.setBounds(258, 40, 276, 41);
	}
	/**
	 * M�todo para darle la fuentes a las letras de los componentes
	 */
	private void addPropiedadesLetras() {
		
		lblDepartamento.setForeground(Color.BLACK);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaClientes.setForeground(Color.BLACK);
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
		btnModificar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnModificar.setForeground(Color.WHITE);
		lblModificacionOK.setForeground(Color.BLACK);
		lblModificacionOK.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
	}
	/**
	 * M�todo para a�adir todos los componentes al panel principal 
	 */
	private void addComponentes() {
		
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		//A�adimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);				
		//A�adimos el panel informativo, labels, textfield y botones 
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
		panelContenido.add(btnModificar);
		panelContenido.add(lblModificacionOK);
	} 

}