package views;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConcesionarioDAO;
import dao.VehiculoDAO;
import models.Usuario;
import models.Vehiculo;
import views.ventas.VentasFichaCliente;
import views.ventas.VentasFichaVehiculo;
import views.ventas.VentasGenerico;
import views.ventas.VentasListadoClientes;

import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class MecanicoFichaHistorial extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes,lblkm,lblCombustible;
	protected JButton btnVolver,btnRegistrar;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JLabel lblTipo,lblAddOk;
	protected JLabel lblFechaEntrada;
	protected JLabel lblConcesionario;
	protected JTextField tFMatricula;
	protected JTextField tFMarca;
	protected JTextField tFModelo;
	protected JTextField tfFechaEntrada;
	protected VehiculoDAO miVehiculoDao;
	protected ConcesionarioDAO miConcesionarioDao;
	protected JComboBox comboBox,comboCombustible,comboConcesionarios;
	private JTextField tFKm;
	private JTextField textField;
	private JTextField tFNombre;
	private JTextField tFApellidos;
	private JTextField tFTelefono;
	/**
	 * Create the application.
	 */
	public MecanicoFichaHistorial(Usuario miUsuario) {
		setTitle("piCARso - Taller");
		miVehiculoDao = new VehiculoDAO();
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
		panelContenido.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("TALLER");
		lblDepartamento.setBounds(10, 11, 374, 54);
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesion");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Consultar historial de reparaciones");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblTipo = new JLabel("Tipo:");
		lblFechaEntrada = new JLabel("Entrada:");
		lblConcesionario = new JLabel("Mec\u00E1nico:");	
		tFMatricula = new JTextField();
		tFMarca = new JTextField();
		tFModelo = new JTextField();
		tfFechaEntrada = new JTextField();
		tFKm = new JTextField();
		lblkm = new JLabel("Kilómetros:");
		lblCombustible = new JLabel("Combustible:");
		btnVolver = new JButton("Volver");
		btnRegistrar = new JButton("Registrar");
		lblAddOk = new JLabel("VEH\u00CDCULO A\u00D1ADIDO CORRECTAMENTE");
		lblAddOk.setVisible(false);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnRegistrar.addActionListener(this);
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
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color(233, 196, 106));
		panelDepartamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario.setBorder(new LineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color(233, 196, 106));
		panelContenido.setBackground(new java.awt.Color(233, 196, 106));
		panelInfo.setBorder(new LineBorder(null));
		panelInfo.setBackground(new java.awt.Color(233, 196, 106));
		btnVolver.setBackground(new java.awt.Color(231, 111, 81));
		btnRegistrar.setBackground(new java.awt.Color(42, 157, 143));
		lblAddOk.setBackground(new java.awt.Color(0,92,48));
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(394, 0, 400, 76);
		panelDepartamento.setBounds(0, 0, 394, 76);
		panelContenido.setBounds(0, 76, 794, 495);
		panelInfo.setBounds(0, 0, 794, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);

		lblMatricula.setBounds(20, 80, 119, 30);
		lblMarca.setBounds(20, 157, 119, 30);
		lblModelo.setBounds(20, 195, 119, 30);
		lblTipo.setBounds(20, 271, 119, 30);
		lblFechaEntrada.setBounds(409, 271, 142, 30);
		lblConcesionario.setBounds(409, 311, 142, 30); 	
		tFMatricula.setBounds(143, 82, 202, 27);
		tFMarca.setBounds(143, 159, 202, 27);
		tFModelo.setBounds(143, 197, 202, 27);
		tfFechaEntrada.setBounds(524, 273, 202, 27);

		tFKm.setBounds(143, 235, 202, 27);
		lblkm.setBounds(20, 233, 142, 30);
		lblCombustible.setBounds(20, 311, 131, 30);
		btnVolver.setBounds(10, 407, 375, 77);
		btnRegistrar.setBounds(409, 407, 375, 77);
		lblAddOk.setBounds(0, 40, 794, 41);
		
		//Damos el tamaño, fuente y color a las letras 
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
		lblFechaEntrada.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblConcesionario.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 			
		tFMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFMatricula.setColumns(10);
		tFMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFMarca.setColumns(10);
		tFMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFModelo.setColumns(10);
		tFModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFKm.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblkm.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		tfFechaEntrada.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnVolver.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnRegistrar.setForeground(Color.WHITE);
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		
		//Añadimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		panelDepartamento.setLayout(null);
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
		panelContenido.add(lblConcesionario);
		
		panelContenido.add(tFMatricula);		
		panelContenido.add(tFMarca);		
		panelContenido.add(tFModelo);		
		panelContenido.add(tfFechaEntrada);
		panelContenido.add(tFKm);		
		panelContenido.add(lblkm);		
		panelContenido.add(lblCombustible);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnRegistrar);
		panelContenido.add(lblAddOk);
		
		comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Coche");
		comboBox.addItem("Motocicleta");
		comboBox.addItem("Ciclomotor");
		comboBox.setSelectedItem("");
		comboBox.addActionListener(this);
		comboBox.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboBox.setBounds(143, 273, 202, 27);
		panelContenido.add(comboBox);
		
		comboCombustible = new JComboBox();
		comboCombustible.addItem("");
		comboCombustible.addItem("Hibrido");
		comboCombustible.addItem("Diesel");
		comboCombustible.addItem("Gasolina");
		comboCombustible.addItem("Electrico");
		comboCombustible.setSelectedItem("");
		comboCombustible.addActionListener(this);
		comboCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboCombustible.setBounds(141, 313, 204, 27);
		panelContenido.add(comboCombustible);
		
		comboConcesionarios = new JComboBox();
		listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(0);
		comboConcesionarios.addItem("");
		for (int i = 0; i < listaConcesionarios.size(); i++) {
			comboConcesionarios.addItem(listaConcesionarios.get(i));
		}
		comboConcesionarios.setSelectedItem("");
		comboConcesionarios.addActionListener(this);
		comboConcesionarios.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboConcesionarios.setBounds(524, 312, 202, 27);
		panelContenido.add(comboConcesionarios);
		
		JButton btnBuscarMatricula = new JButton("Buscar");
		btnBuscarMatricula.setForeground(Color.WHITE);
		btnBuscarMatricula.setFont(new Font("Dialog", Font.PLAIN, 19));
		btnBuscarMatricula.setBackground(new Color(231, 111, 81));
		btnBuscarMatricula.setBounds(153, 121, 182, 27);
		panelContenido.add(btnBuscarMatricula);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblDni.setBounds(409, 80, 119, 30);
		panelContenido.add(lblDni);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 19));
		textField.setColumns(10);
		textField.setBounds(524, 80, 202, 27);
		panelContenido.add(textField);
		
		JButton btnBuscarDni = new JButton("Buscar");
		btnBuscarDni.setForeground(Color.WHITE);
		btnBuscarDni.setFont(new Font("Dialog", Font.PLAIN, 19));
		btnBuscarDni.setBackground(new Color(231, 111, 81));
		btnBuscarDni.setBounds(534, 121, 182, 27);
		panelContenido.add(btnBuscarDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblNombre.setBounds(409, 157, 119, 30);
		panelContenido.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblApellidos.setBounds(409, 195, 119, 30);
		panelContenido.add(lblApellidos);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblTelfono.setBounds(409, 233, 142, 30);
		panelContenido.add(lblTelfono);
		
		tFNombre = new JTextField();
		tFNombre.setFont(new Font("Dialog", Font.PLAIN, 19));
		tFNombre.setColumns(10);
		tFNombre.setBounds(524, 157, 202, 27);
		panelContenido.add(tFNombre);
		
		tFApellidos = new JTextField();
		tFApellidos.setFont(new Font("Dialog", Font.PLAIN, 19));
		tFApellidos.setColumns(10);
		tFApellidos.setBounds(524, 195, 202, 27);
		panelContenido.add(tFApellidos);
		
		tFTelefono = new JTextField();
		tFTelefono.setFont(new Font("Dialog", Font.PLAIN, 19));
		tFTelefono.setColumns(10);
		tFTelefono.setBounds(524, 235, 202, 27);
		panelContenido.add(tFTelefono);
		
					
		this.setVisible(true);
	}
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasGenerico ventanaVentasG;
		ArrayList<Vehiculo> miListaVehiculos;
		String txtBtn = e.getActionCommand();
		VentasFichaCliente ventanaFicha;
		VentasListadoClientes ventanaListaClientes;
		VentasFichaVehiculo ventanaFichaVehiculo;
		String idConcesionario;
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaVentasG = new VentasGenerico(miUser);			
			break;
			
		case "Registrar":
			
			idConcesionario = miConcesionarioDao.buscarIDConcesionario(comboConcesionarios.getSelectedItem().toString())+"";
			lblAddOk.setVisible(true);
			tFMatricula.setText("");
			tFMarca.setText("");
			tFModelo.setText("");
			tfFechaEntrada.setText("");
			tFKm.setText("");
			comboCombustible.setSelectedItem("");
			comboBox.setSelectedItem("");
			comboConcesionarios.setSelectedItem("");
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
}