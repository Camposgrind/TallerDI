package views.ventas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ClienteDAO;
import dao.ConcesionarioDAO;
import dao.UsuarioDAO;
import dao.VehiculoDAO;
import models.Cliente;
import models.Concesionario;
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
		
		miConcesionarioDao = new ConcesionarioDAO();
		miVehiculoDao = new VehiculoDAO();
		miClienteDao = new ClienteDAO();
		miUsuarioDao = new UsuarioDAO();
		miConcesionarioDao = new ConcesionarioDAO();
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
		ImageIcon imgUsu;
		//ArrayList<String> listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(miVehiculo.getIdConcesionario());
		
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
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesion");
		imgUsu = new ImageIcon("user-icon.png");
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
		lblkm = new JLabel("Kilómetros:");
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
			btnVender.setText("Vehículo vendido");
			btnVender.setEnabled(false);
		}

		//Ponemos sus layouts
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
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelContenido.setBackground(new java.awt.Color( 244, 162, 97));
		panelInfo.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelInfo.setBackground(new java.awt.Color( 244, 162, 97));
		btnVolver.setBackground(new java.awt.Color(119, 14, 38));
		btnVender.setBackground(new Color(82, 21, 255));
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(0, 76, 786, 485);
		panelInfo.setBounds(281, 0, 228, 41);
		
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
		
		btnVolver.setBounds(94, 424, 117, 35);
		btnVender.setBounds(490, 424, 202, 35);

		//Damos el tamaño, fuente y color a las letras 
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
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnVender);
		
		panelContenido.add(lblkm);
		panelContenido.add(lblCombustible);
		panelContenido.add(tFkm);
		panelContenido.add(tFCombustible);
					
		this.setVisible(true);
	}
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasBuscarPropuesta ventanaBuscarPropuesta;
		VentasGenerico ventanaVentasGenerico;
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
			miVehiculoDao.venderVehiculo(miUsuarioPropuesta.getIdUsuario(),1,miVehiculo.getMatricula());
			JOptionPane.showMessageDialog(this, "Venta realizada con éxito");
			

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
	private void getUsuario() {
		
	}
}
