package views.ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Usuario;
import views.LoginV;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class VentasGenerico extends JFrame implements ActionListener, MouseListener{
	
	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelBotones;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblFotoSur;
	protected JButton btnAltaCl,btnBuscarVehiculos,btnBuscarClientes,btnPropuestaDeVenta,btnBuscarPropuesta,btnAltaCoche;
	JLabel lblIcono1; 
	private JLabel lblIcono3;
	private JLabel lblIcono5;
	private JLabel lblIcono2;
	private JLabel lblIcono4;
	private JLabel lblIcono6;
	
	/**
	 * Create the application.
	 */
	public VentasGenerico(Usuario miUsuario) {
		setTitle("piCARso - Ventas");
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

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasAddCliente ventanaAddCliente;
		VentasBuscarCliente ventanaBuscarCliente;
		VentasBuscarVehiculo ventanaBuscarVehiculo;
		VentasAltaVehiculo ventanaAltaVehiculo;
		VentasPropuestaVenta ventanaRealizarPropuesta;
		VentasBuscarPropuesta ventanaBuscarPropuesta;
		
		String txtBtn = e.getActionCommand();
		
		switch (txtBtn) {
		case "Alta de clientes":
			this.setVisible(false);
			this.dispose();
			ventanaAddCliente = new VentasAddCliente(miUser);
			break;
		case "Buscar vehículos":
			this.setVisible(false);
			this.dispose();
			ventanaBuscarVehiculo = new VentasBuscarVehiculo(miUser,null);
			break;
		case "Buscar clientes":
			this.setVisible(false);
			this.dispose();
			ventanaBuscarCliente = new VentasBuscarCliente(miUser,null);
			break;
		case "Propuesta de venta":
			this.setVisible(false);
			this.dispose();
			ventanaRealizarPropuesta = new VentasPropuestaVenta(miUser,null,null);
			
			break;
		case "Buscar propuesta de venta":
			this.setVisible(false);
			this.dispose();
			ventanaBuscarPropuesta = new VentasBuscarPropuesta(miUser);
			
			break;
			
		case "Alta vehículo":
			this.setVisible(false);
			this.dispose();	
			ventanaAltaVehiculo = new VentasAltaVehiculo(miUser);
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

		//Iniciamos todos los componentes 
		ImageIcon imgLogoVentas,imgUsu,icono1,icono2,icono3,icono4,icono5,icono6;
		panelDepartamento = new JPanel();
		panelBotones = new JPanel();
		panelUsuario = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		imgUsu = new ImageIcon("assets/FotosUsuario/FotoUsuario"+miUser.getIdUsuario()+".jpg");
		lblCerrarSesion = new JLabel("Cerrar sesión");
		lblFotoUsu = new JLabel(imgUsu);
		btnAltaCl = new JButton("Alta de clientes");
		btnBuscarVehiculos = new JButton("Buscar vehículos");
		btnBuscarClientes = new JButton("Buscar clientes");
		btnPropuestaDeVenta = new JButton("Propuesta de venta");
		btnBuscarPropuesta = new JButton("Buscar propuesta de venta");
		btnAltaCoche = new JButton("Alta vehículo");
		imgLogoVentas = new ImageIcon("assets/iconoVentas.png");
		lblFotoSur = new JLabel(imgLogoVentas);
		
		icono1 = new ImageIcon("assets/VentasAltaCliente.png");
		icono2 = new ImageIcon("assets/VentasBuscarCliente.png");
		icono3 = new ImageIcon("assets/VentasAltaVehiculo.png");
		icono4 = new ImageIcon("assets/VentasBuscarVehiculo.png");
		icono5 = new ImageIcon("assets/VentasAltaVenta.png");
		icono6 = new ImageIcon("assets/VentasBuscarVenta.png");
		
		lblIcono1 = new JLabel(icono1);
		lblIcono2 = new JLabel(icono2);
		lblIcono3 = new JLabel(icono3);
		lblIcono4 = new JLabel(icono4);
		lblIcono5 = new JLabel(icono5);
		lblIcono6 = new JLabel(icono6);
		
		lblCerrarSesion.addMouseListener(this);
		btnAltaCl.addActionListener(this);
		btnBuscarVehiculos.addActionListener(this);
		btnBuscarClientes.addActionListener(this);
		btnPropuestaDeVenta.addActionListener(this);
		btnBuscarPropuesta.addActionListener(this);
		btnAltaCoche.addActionListener(this);
		
		//Borramos los cuadros cuando se focaliza en un botón
		btnAltaCl.setFocusPainted(false);
		btnBuscarVehiculos.setFocusPainted(false);
		btnBuscarClientes.setFocusPainted(false);
		btnPropuestaDeVenta.setFocusPainted(false);
		btnBuscarPropuesta.setFocusPainted(false);
		btnAltaCoche.setFocusPainted(false);
	}
	
	
	/**
	 * Metodo para poner a los paneles y label los layout que necesitan
	 */
	private void ponerLayoutsComponentes() {
		
		panelDepartamento.setLayout(new BorderLayout(0, 0));
		panelUsuario.setLayout(null);
		panelBotones.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
	}
	/**
	 * Método interno para dar color a los componenetes (botones, lineas, labels, panels...)
	 */
	private void darColorComponentes() {
		
		panelDepartamento.setBackground(new java.awt.Color(233, 196, 106));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color(233, 196, 106));
		panelBotones.setBackground(new java.awt.Color(233, 196, 106));
		btnAltaCl.setBackground(new java.awt.Color(38, 70, 83));
		btnBuscarVehiculos.setBackground(new java.awt.Color(38, 70, 83));
		btnBuscarClientes.setBackground(new java.awt.Color(38, 70, 83));
		btnPropuestaDeVenta.setBackground(new java.awt.Color(38, 70, 83));
		btnBuscarPropuesta.setBackground(new java.awt.Color(38, 70, 83));
		btnAltaCoche.setBackground(new java.awt.Color(38, 70, 83));
	}
	/**
	 * Método para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		
		panelUsuario.setBounds(393, 0, 391, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelBotones.setBounds(0, 76, 784, 484);
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		btnAltaCl.setBounds(56, 61, 250, 50);
		btnBuscarVehiculos.setBounds(473, 138, 250, 50);
		btnBuscarClientes.setBounds(473, 61, 250, 50);
		btnPropuestaDeVenta.setBounds(56, 219, 250, 50);
		btnAltaCoche.setBounds(56, 138, 250, 50);
		btnBuscarPropuesta.setBounds(473, 219, 250, 50);
		lblFotoSur.setBounds(256, 294, 276, 162);
		lblIcono1.setBounds(315, 61, 50, 50);
		lblIcono3.setBounds(315, 138, 50, 50);
		lblIcono5.setBounds(315, 219, 50, 50);
		lblIcono2.setBounds(413, 61, 50, 50);
		lblIcono4.setBounds(413, 138, 50, 50);
		lblIcono6.setBounds(413, 219, 50, 50);
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
		btnAltaCl.setForeground(Color.WHITE);
		btnAltaCl.setForeground(Color.WHITE);
		btnBuscarVehiculos.setForeground(Color.WHITE);
		btnBuscarClientes.setForeground(Color.WHITE);
		btnPropuestaDeVenta.setForeground(Color.WHITE);
		btnBuscarPropuesta.setForeground(Color.WHITE);
		btnAltaCl.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnBuscarVehiculos.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnBuscarClientes.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnPropuestaDeVenta.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnBuscarPropuesta.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnAltaCoche.setFont(new Font("Dialog", Font.PLAIN, 17));
		btnAltaCoche.setForeground(Color.WHITE);
	}
	/**
	 * Método para añadir todos los componentes al panel principal 
	 */
	private void addComponentes() {
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelBotones);
		//Añadimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);
		//Añadimos los botones y el label de la fto al panel principal 
		panelBotones.add(btnAltaCl);
		panelBotones.add(btnBuscarVehiculos);
		panelBotones.add(btnBuscarClientes);
		panelBotones.add(btnPropuestaDeVenta);
		panelBotones.add(btnBuscarPropuesta);
		panelBotones.add(btnAltaCoche);
		panelBotones.add(lblFotoSur);
		
		
		panelBotones.add(lblIcono1);
		panelBotones.add(lblIcono3);
		panelBotones.add(lblIcono5);
		panelBotones.add(lblIcono2);
		panelBotones.add(lblIcono4);
		panelBotones.add(lblIcono6);
		
	} 
}
