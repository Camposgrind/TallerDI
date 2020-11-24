package views.ventas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ClienteDAO;
import models.Cliente;
import models.Usuario;
import views.LoginV;

@SuppressWarnings("serial")
public class VentasFichaCliente extends JFrame implements MouseListener,ActionListener{

	protected Cliente miCliente;
	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblFichaClientes;
	protected JButton btnVolver,btnModificar,btnPropuestaVenta;
	protected JLabel lblNombre;
	protected JLabel lblApellidos;
	protected JLabel lblTelefono;
	protected JLabel lblDni;
	protected JLabel infoNombre;
	protected JLabel infoApellidos;
	protected JLabel infoTelefono;
	protected JLabel infoDni;
	protected ClienteDAO miClienteDao;
	protected VentasListadoClientes ventasListadoClientes;
	protected VentasPropuestaVenta ventanaPropuestas;
	
	/**
	 * Constructor de la vista 
	 * @param miUsuario
	 * @param miCliente
	 * @param ventasListadoClientes
	 */
	public  VentasFichaCliente(Usuario miUsuario,Cliente miCliente, VentasListadoClientes ventasListadoClientes,
			VentasPropuestaVenta miVentanaPropuesta) {
		setTitle("piCARso - Ventas");
		this.ventasListadoClientes = ventasListadoClientes;
		ventanaPropuestas = miVentanaPropuesta;
		this.miCliente = miCliente;
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
		
		//Añadimos los componentes al panel principal los paneles	
		this.addComponentes();
							
		this.setVisible(true);
	}
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasBuscarCliente ventanaBuscarCliente;
		ArrayList<Cliente> miListaClientes;
		String txtBtn = e.getActionCommand();
		VentasFichaCliente ventanaFicha;
		VentasModificarCliente ventanaModificar;
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			if(ventasListadoClientes==null) {
				
				ventanaBuscarCliente = new VentasBuscarCliente(miUser,ventanaPropuestas);
			}else {
				ventasListadoClientes.setVisible(true);
			}

			break;
			
		case "Modificar":			
			this.setVisible(false);
			this.dispose();
			ventanaModificar = new VentasModificarCliente(miUser, miCliente,ventanaPropuestas);
			//Aquí habría que meter una ventana de buscar cliente pero con los texfield ya puestos con la info 
			break;
			
		case "Propuesta de venta":
			this.setVisible(false);
			this.dispose();
			if(ventanaPropuestas!=null) {
				ventanaPropuestas.setCliente(miCliente);				
			}else {
				ventanaPropuestas = new VentasPropuestaVenta(miUser, null, miCliente);
			}
			ventanaPropuestas.setTextFieldCliente();
			ventanaPropuestas.setVisible(true);
			
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
		ImageIcon imgUsu;
		
		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesión");
		imgUsu = new ImageIcon("assets/user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblFichaClientes = new JLabel("Ficha cliente");
		lblNombre = new JLabel("Nombre: ");
		lblApellidos = new JLabel("Apellidos:");
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblDni = new JLabel("DNI:");
		infoNombre = new JLabel(miCliente.getNombre());
		infoApellidos = new JLabel(miCliente.getApellidos());
		infoTelefono = new JLabel(miCliente.getTelefono());
		infoDni = new JLabel(miCliente.getDni());		
		btnVolver = new JButton("Volver");
		btnModificar = new JButton("Modificar");
		btnPropuestaVenta = new JButton("Prop. de venta");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnModificar.addActionListener(this);
		btnPropuestaVenta.addActionListener(this);
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
	}
	/**
	 * Método interno para dar color a los componenetes (botones, lineas, labels, panels...)
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
		btnPropuestaVenta.setBackground(new Color(38, 70, 83));
	}
	/**
	 * Método para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
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
		infoNombre.setBounds(376, 100, 222, 27);
		infoApellidos.setBounds(376, 165, 222, 27);
		infoTelefono.setBounds(376, 234, 222, 27);
		infoDni.setBounds(376, 295, 222, 27);
		btnVolver.setBounds(60, 391, 150, 50);
		btnModificar.setBounds(319, 391, 150, 50);
		btnPropuestaVenta.setBounds(565, 391, 150, 50);
	}
	/**
	 * Método para darle la fuentes a las letras de los componentes
	 */
	private void addPropiedadesLetras() {
		
		lblDepartamento.setForeground(Color.BLACK);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblFichaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblFichaClientes.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTelefono.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblDni.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		infoNombre.setFont(new Font("DejaVu Sans", Font.ITALIC, 19));
		infoApellidos.setFont(new Font("DejaVu Sans", Font.ITALIC, 19));
		infoTelefono.setFont(new Font("DejaVu Sans", Font.ITALIC, 19));
		infoDni.setFont(new Font("DejaVu Sans", Font.ITALIC, 19));
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnModificar.setForeground(Color.WHITE);
		btnPropuestaVenta.setForeground(Color.WHITE);
		btnPropuestaVenta.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
	}
	/**
	 * Método para añadir todos los componentes al panel principal 
	 */
	private void addComponentes() {
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
		panelInfo.add(lblFichaClientes);		
		panelContenido.add(lblNombre);		
		panelContenido.add(lblApellidos);		
		panelContenido.add(lblTelefono);		
		panelContenido.add(lblDni);		
		panelContenido.add(infoNombre);		
		panelContenido.add(infoApellidos);		
		panelContenido.add(infoTelefono);		
		panelContenido.add(infoDni);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnModificar);		
		panelContenido.add(btnPropuestaVenta);
	} 

}
