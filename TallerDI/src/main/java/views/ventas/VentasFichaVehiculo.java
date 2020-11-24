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

import dao.ConcesionarioDAO;
import dao.VehiculoDAO;
import models.Usuario;
import models.Vehiculo;
import views.LoginV;

@SuppressWarnings("serial")
public class VentasFichaVehiculo extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnModificar,btnPropuesta;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JLabel lblTipo,lblAddOk;
	protected JLabel lblFechaEntrada;
	protected JLabel lblPrecio,lblColor,lblConcesionario;
	protected JLabel tFMatricula;
	protected JLabel tFMarca;
	protected JLabel tFModelo, lblkm,lblCombustible,tFkm,tFCombustible;
	protected JLabel tFTipo,tfFechaEntrada,tFPrecio,tFColor,tFConcesionario;
	protected VehiculoDAO miVehiculoDao;
	protected Vehiculo miVehiculo;
	protected String provincia;
	protected String nombreConcesionario;
	protected VentasListadoVehiculos miVentanaListadoVehiculos;
	protected ConcesionarioDAO miConcesionarioDao;
	protected VentasPropuestaVenta ventanaPropuesta;
	
	/**
	 * Create the application.
	 */
	public VentasFichaVehiculo(Usuario miUsuario,Vehiculo miVehiculo,VentasListadoVehiculos miVentanaListado
			,VentasPropuestaVenta miVentanaPropuesta) {
		
		ventanaPropuesta = miVentanaPropuesta;
		miConcesionarioDao = new ConcesionarioDAO();
		miVentanaListadoVehiculos = miVentanaListado;
		miVehiculoDao = new VehiculoDAO();
		this.miVehiculo= miVehiculo;
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
		VentasBuscarVehiculo ventanaBuscarVehiculo;
		ArrayList<Vehiculo> miListaVehiculos;
		String txtBtn = e.getActionCommand();
		VentasFichaCliente ventanaFicha;
		VentasListadoClientes ventanaListaClientes;
		VentasModificarVehiculo ventanaModificarVehiculo;
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			if(miVentanaListadoVehiculos==null) {
							
				ventanaBuscarVehiculo = new VentasBuscarVehiculo(miUser,ventanaPropuesta);
			}else {
				miVentanaListadoVehiculos.setVisible(true);
			}
			break;
			
		case "Modificar":
			this.setVisible(false);
			this.dispose();
			ventanaModificarVehiculo = new VentasModificarVehiculo(miUser,miVehiculo,ventanaPropuesta);
			break;
			
		case "Propuesta de venta":
			this.setVisible(false);
			this.dispose();
			
			if(ventanaPropuesta!=null) {
				ventanaPropuesta.setVehiculo(miVehiculo);				
			}else {
				ventanaPropuesta = new VentasPropuestaVenta(miUser, miVehiculo, null);
			}
			ventanaPropuesta.setVisible(true);
			ventanaPropuesta.setTextFieldVehiculo();

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
		ArrayList<String> listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(miVehiculo.getIdConcesionario());
		String concesionario= listaConcesionarios.get(0);

		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesión");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Ficha veh\u00EDculo");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblTipo = new JLabel("Tipo:");
		lblFechaEntrada = new JLabel("Fecha Entrada:");
		lblPrecio =  new JLabel("Precio:");
		lblColor = new JLabel("Color:");
		lblConcesionario = new JLabel("Concesionario:");	
		tFMatricula = new JLabel(miVehiculo.getMatricula());
		tFMarca = new JLabel(miVehiculo.getMarca());
		tFModelo = new JLabel(miVehiculo.getModelo());
		tFTipo = new JLabel(miVehiculo.getTipo());	
		tfFechaEntrada = new JLabel(miVehiculo.getFechaEntrada().toString());
		lblkm = new JLabel("Kilómetros:");
		lblCombustible = new JLabel("Combustible:");
		tFkm = new JLabel(miVehiculo.getKilometros()+"");
		tFCombustible = new JLabel(miVehiculo.getCombustible());
		
		tFPrecio = new JLabel(miVehiculo.getPrecio()+"");
		tFColor = new JLabel(miVehiculo.getColor());
		tFConcesionario = new JLabel(concesionario);
		btnVolver = new JButton("Volver");
		btnModificar = new JButton("Modificar");
		btnPropuesta = new JButton("Propuesta de venta");
		lblAddOk = new JLabel("VEHÍCULO NO ENCONTRADO");
		lblAddOk.setVisible(false);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnModificar.addActionListener(this);
		btnPropuesta.addActionListener(this);
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
		lblMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarca.setHorizontalAlignment(SwingConstants.LEFT);
		lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
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
		btnModificar.setBackground(new java.awt.Color(0,92,48));
		btnPropuesta.setBackground(new Color(82, 21, 255));
		lblAddOk.setBackground(new java.awt.Color(0,92,48));
	}
	/**
	 * Método para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(0, 76, 786, 485);
		panelInfo.setBounds(281, 0, 228, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		
		lblMatricula.setBounds(54, 109, 119, 30);
		lblMarca.setBounds(54, 150, 119, 30);
		lblModelo.setBounds(54, 191, 119, 30);
		lblTipo.setBounds(54, 232, 119, 30);
		lblPrecio.setBounds(54, 303, 119, 30); 
		lblColor.setBounds(425, 150, 142, 30); 
		lblFechaEntrada.setBounds(425, 232, 142, 30);
		lblConcesionario.setBounds(425, 303, 142, 30); 	
		tFMatricula.setBounds(183, 111, 207, 27);
		tFMarca.setBounds(183, 152, 207, 27);
		tFModelo.setBounds(183, 194, 202, 27);
		tFTipo.setBounds(183, 234, 202, 27);
		lblkm.setBounds(425, 109, 142, 30);
		tFkm.setBounds(577, 112, 179, 27);
		tFCombustible.setBounds(577, 194, 179, 27);
		lblCombustible.setBounds(425, 191, 131, 30);
		tFPrecio.setBounds(183, 305, 222, 27);
		tFColor.setBounds(577, 152, 179, 27);
		tfFechaEntrada.setBounds(577, 234, 179, 27);
		tFConcesionario.setBounds(569, 305, 207, 27);
		btnVolver.setBounds(94, 424, 117, 35);
		btnModificar.setBounds(295, 424, 117, 35);
		btnPropuesta.setBounds(490, 424, 202, 35);
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
		lblMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTipo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblFechaEntrada.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblPrecio.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblColor.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblConcesionario.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 			
		tFMatricula.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));		
		tFMarca.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));				
		tFModelo.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));		
		tFTipo.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		lblkm.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFkm.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFCombustible.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		lblCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));		
		tfFechaEntrada.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFPrecio.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFColor.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFConcesionario.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnModificar.setForeground(Color.WHITE);
		btnPropuesta.setForeground(Color.WHITE);
		btnPropuesta.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
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
		panelInfo.add(lblAltaClientes);		
		panelContenido.add(lblMatricula);		
		panelContenido.add(lblMarca);		
		panelContenido.add(lblModelo);		
		panelContenido.add(lblTipo);
		panelContenido.add(lblFechaEntrada);
		panelContenido.add(lblPrecio);
		panelContenido.add(lblColor);
		panelContenido.add(lblConcesionario);	
		panelContenido.add(tFMatricula);		
		panelContenido.add(tFMarca);		
		panelContenido.add(tFModelo);		
		panelContenido.add(tFTipo);
		panelContenido.add(tfFechaEntrada);		
		panelContenido.add(tFPrecio);		
		panelContenido.add(tFColor);		
		panelContenido.add(tFConcesionario);
		panelContenido.add(lblkm);
		panelContenido.add(lblCombustible);
		panelContenido.add(tFkm);
		panelContenido.add(tFCombustible);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnModificar);
		panelContenido.add(btnPropuesta);
		panelContenido.add(lblAddOk);
		
	} 
}