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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ClienteDAO;
import dao.ConcesionarioDAO;
import dao.UsuarioDAO;
import dao.VehiculoDAO;
import models.Cliente;
import models.Propuesta;
import models.Usuario;
import models.Vehiculo;
import views.LoginV;

public class VentasFichaPropuesta extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnVender;
	protected JLabel lblMatricula,lblNombreUsu,lblApellidosUsu;
	protected JLabel lblMarca,lblNombreCl,lblApellidosCl;
	protected JLabel lblModelo;
	protected JLabel lblTipo;
	protected JLabel lblFechaPropuesta;
	protected JLabel lblPrecio,lblColor,lblConcesionario;
	protected JLabel tFMatricula,tFNombreUsu,tFApellidosUsu;
	protected JLabel tFMarca,tFNombreCl,tFApellidosCl;
	protected JLabel tFModelo, lblkm,lblCombustible,tFkm,tFCombustible;
	protected JLabel tFTipo,tfFechaPropuesta,tFPrecio,tFColor,tFConcesionario;
	protected VentasListadoPropuestas ventanaListadoPropuesta;
	protected VentasPropuestaVenta ventanaPropuesta;
	protected VehiculoDAO miVehiculoDao;
	protected ConcesionarioDAO miConcesionarioDao;
	protected ClienteDAO miClienteDao;
	protected UsuarioDAO miUsuarioDao;
	protected Vehiculo miVehiculo;
	protected Propuesta miPropuesta;
	protected Cliente miCliente;
	protected Usuario miUsuarioPropuesta;
	protected String nombreConcesionario;
	
	/**
	 * Create the application.
	 */
	public VentasFichaPropuesta(Usuario miUsuario,Propuesta miPropuesta, VentasListadoPropuestas miVentanaListado) {
		setTitle("piCARso - Ventas");
		
		miConcesionarioDao = new ConcesionarioDAO();
		miVehiculoDao = new VehiculoDAO();
		miClienteDao = new ClienteDAO();
		miUsuarioDao = new UsuarioDAO();
		ventanaListadoPropuesta = miVentanaListado;
			
		this.miPropuesta = miPropuesta;
		miUser = miUsuario;
		miUsuarioPropuesta = miUsuarioDao.buscarUsuarioById(miPropuesta.getIdUsuario());
		miVehiculo = miVehiculoDao.buscarVehiculo(miPropuesta.getMatricula()
				, "", "", "", "", "", "", "", "", "",false).get(0);
		miCliente = miClienteDao.buscarClienteById(miPropuesta.getIdCliente());
		nombreConcesionario = miConcesionarioDao.buscarNombreConcesionario(miVehiculo.getIdConcesionario()).get(0);
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
		VentasBuscarPropuesta ventanaBuscarPropuesta;
		VentasGenerico ventanaVentasGenerico;
		int comisionActualizada;
		String txtBtn = e.getActionCommand();
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			if(ventanaListadoPropuesta==null) {
							
				ventanaBuscarPropuesta = new VentasBuscarPropuesta(miUser);
			}else {
				ventanaListadoPropuesta.setVisible(true);
			}
			break;

		case "Vender":
			this.setVisible(false);
			this.dispose();
			ventanaVentasGenerico = new VentasGenerico(miUser);
			//Sumamon las comisi�n que tenia el usuario a el precio que se hab�a estimado la venta
			comisionActualizada = miUser.getComisionVentas() + miPropuesta.getPresupuesto();
			miUsuarioDao.actualizaComision(miUser.getIdUsuario(),comisionActualizada);
			miVehiculoDao.venderVehiculo(miCliente.getIdCliente(),1,miVehiculo.getMatricula());
			
			JOptionPane.showMessageDialog(this, "Venta realizada con �xito");
			

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
		lblAltaClientes = new JLabel("Ficha veh\u00EDculo");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblTipo = new JLabel("Tipo:");
		lblFechaPropuesta = new JLabel("Fecha propuesta:");
		lblPrecio =  new JLabel("Precio:");
		lblColor = new JLabel("Color:");
		lblConcesionario = new JLabel("Concesionario:");	
		tFMatricula = new JLabel(miVehiculo.getMatricula());
		tFMarca = new JLabel(miVehiculo.getMarca());
		tFModelo = new JLabel(miVehiculo.getModelo());
		tFTipo = new JLabel(miVehiculo.getTipo());	
		tfFechaPropuesta = new JLabel(miPropuesta.getFecha().toString());
		lblkm = new JLabel("Kil�metros:");
		lblCombustible = new JLabel("Combustible:");
		tFkm = new JLabel(miVehiculo.getKilometros()+"");
		tFCombustible = new JLabel(miVehiculo.getCombustible());
		lblNombreUsu = new JLabel("Nombre vendedor");
		lblApellidosUsu = new JLabel("Apellidos vendedor:");
		lblNombreCl = new JLabel("Nombre cliente:");
		lblApellidosCl = new JLabel("Apellidos cliente:");
		tFNombreUsu = new JLabel(miUsuarioPropuesta.getNombre());
		tFApellidosUsu  = new JLabel(miUsuarioPropuesta.getApellido());
		tFNombreCl  = new JLabel(miCliente.getNombre());
		tFApellidosCl = new JLabel(miCliente.getApellidos());
		
		tFPrecio = new JLabel(miPropuesta.getPresupuesto()+"");
		tFColor = new JLabel(miVehiculo.getColor());
		//Hay que modificar esto
		tFConcesionario = new JLabel(nombreConcesionario);
		btnVolver = new JButton("Volver");
		//btnModificar = new JButton("Vender");
		btnVender = new JButton("Vender");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnVender.addActionListener(this);
		
		if(miVehiculo.isVendido()) {
			btnVender.setText("Veh�culo vendido");
			btnVender.setEnabled(false);
		}
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
		btnVender.setBackground(new Color(42, 157, 143));
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
		
		lblMatricula.setBounds(425, 70, 119, 30);
		lblMarca.setBounds(425, 191, 119, 30);
		lblModelo.setBounds(425, 232, 119, 30);
		lblTipo.setBounds(425, 111, 119, 30);
		lblPrecio.setBounds(24, 314, 119, 30); 
		lblColor.setBounds(425, 150, 142, 30); 
		lblFechaPropuesta.setBounds(24, 273, 179, 30);
		lblConcesionario.setBounds(425, 355, 142, 30); 	
		tFMatricula.setBounds(569, 72, 207, 27);
		tFMarca.setBounds(569, 193, 207, 27);
		tFModelo.setBounds(569, 234, 202, 27);
		tFTipo.setBounds(569, 111, 202, 27);
		lblkm.setBounds(425, 273, 142, 30);
		tFkm.setBounds(569, 275, 179, 27);
		tFCombustible.setBounds(569, 316, 179, 27);
		lblCombustible.setBounds(425, 314, 131, 30);
		tFPrecio.setBounds(213, 316, 189, 27);
		tFColor.setBounds(569, 152, 179, 27);
		tfFechaPropuesta.setBounds(213, 275, 179, 27);
		tFConcesionario.setBounds(569, 357, 207, 27);	
		lblNombreUsu.setBounds(27, 111, 179, 30);
		lblApellidosUsu.setBounds(27, 150, 179, 30); 
		lblNombreCl.setBounds(27, 191, 159, 30);
		lblApellidosCl.setBounds(27, 232, 159, 30);
		tFNombreUsu.setBounds(213, 113, 202, 27);
		tFApellidosUsu.setBounds(213, 152, 179, 27);
		tFNombreCl.setBounds(213, 193, 207, 27);
		tFApellidosCl.setBounds(213, 234, 202, 27);
		
		btnVolver.setBounds(119, 409, 150, 50);
		btnVender.setBounds(516, 409, 150, 50);
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
		lblMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTipo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblFechaPropuesta.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
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
		tfFechaPropuesta.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFPrecio.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFColor.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFConcesionario.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));	
		lblNombreUsu.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblApellidosUsu.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblNombreCl.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblApellidosCl.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		tFNombreUsu.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFApellidosUsu.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFNombreCl.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFApellidosCl.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnVender.setForeground(Color.WHITE);
		btnVender.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
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
		
		panelContenido.add(lblMatricula);		
		panelContenido.add(lblMarca);		
		panelContenido.add(lblModelo);		
		panelContenido.add(lblTipo);
		panelContenido.add(lblFechaPropuesta);
		panelContenido.add(lblPrecio);
		panelContenido.add(lblColor);
		panelContenido.add(lblConcesionario);	
		panelContenido.add(tFMatricula);		
		panelContenido.add(tFMarca);		
		panelContenido.add(tFModelo);		
		panelContenido.add(tFTipo);
		panelContenido.add(tfFechaPropuesta);		
		panelContenido.add(tFPrecio);		
		panelContenido.add(tFColor);		
		panelContenido.add(tFConcesionario);
		panelContenido.add(lblNombreCl);
		panelContenido.add(lblApellidosCl);
		panelContenido.add(lblNombreUsu);
		panelContenido.add(lblApellidosUsu);
		panelContenido.add(tFNombreCl);
		panelContenido.add(tFNombreUsu);
		panelContenido.add(tFApellidosCl);
		panelContenido.add(tFApellidosUsu);		
		panelContenido.add(lblkm);
		panelContenido.add(lblCombustible);
		panelContenido.add(tFkm);
		panelContenido.add(tFCombustible);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnVender);
	} 
}
