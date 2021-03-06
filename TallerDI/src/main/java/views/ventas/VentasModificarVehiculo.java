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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConcesionarioDAO;
import dao.VehiculoDAO;
import models.Concesionario;
import models.Usuario;
import models.Vehiculo;
import views.LoginV;

public class VentasModificarVehiculo extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes,lblkm,lblCombustible;
	protected JButton btnVolver,btnBuscar;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JLabel lblTipo,lblAddOk;
	protected JLabel lblFechaEntrada;
	protected JLabel lblPrecio,lblColor,lblConcesionario;
	protected JTextField tFMatricula;
	protected JTextField tFMarca;
	protected JTextField tFModelo;
	protected JTextField tfFechaEntrada,tFPrecio,tFColor;
	protected VehiculoDAO miVehiculoDao;
	protected ConcesionarioDAO miConcesionarioDao;
	protected JComboBox comboBox,comboCombustible,comboConcesionarios;
	protected Vehiculo  miVehiculo;
	protected JTextField tFkm;
	protected Concesionario miConcesionario;
	protected ArrayList<String >listaCombustibles;
	protected VentasPropuestaVenta ventanaPropuesta;
	
	/**
	 * Create the application.
	 */
	public VentasModificarVehiculo(Usuario miUsuario,Vehiculo miVehiculo,VentasPropuestaVenta miVentanaPropuesta) {
		setTitle("piCARso - Ventas");
		ventanaPropuesta = miVentanaPropuesta;
		miVehiculoDao = new VehiculoDAO();
		miConcesionarioDao = new ConcesionarioDAO();
		listaCombustibles = new ArrayList<String>();
		this.miVehiculo = miVehiculo;
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
		
		//Damos el tama�o a los componentes que est�n en absoluto
		this.colocarComponentes();
		
		//Damos el tama�o, fuente y color a las letras 
		this.addPropiedadesLetras();
		
		//A�adimos los componentes al panel principal los paneles	
		this.addComponentes();
		//rellenamos el combo 
		this.rellenarCombo();	
					
		this.setVisible(true);
	}
	/**
	 * M�todo para cuando se pulse alg�n bot�n
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasGenerico ventanaVentasG;
		String txtBtn = e.getActionCommand();
		VentasFichaVehiculo ventanaFichaVehiculo;
		int idConcesionarioModificado;
		
		switch (txtBtn) {
		
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaVentasG = new VentasGenerico(miUser);			
			break;
			
		case "Modificar":
			
			lblAddOk.setVisible(false);
			idConcesionarioModificado = miConcesionarioDao.buscarIDConcesionario(comboConcesionarios.getSelectedItem().toString());
			
			miVehiculo = miVehiculoDao.modificarVehiculo(tFMatricula.getText(), tFMarca.getText(), tFModelo.getText(),
					comboBox.getSelectedItem().toString(),tFPrecio.getText(),comboCombustible.getSelectedItem().toString(),
					tFColor.getText(),tFkm.getText(),tfFechaEntrada.getText(),idConcesionarioModificado,miVehiculo.getMatricula());			
			
			lblAddOk.setVisible(true);
			this.setVisible(false);
			ventanaFichaVehiculo = new VentasFichaVehiculo(miUser, miVehiculo, null,ventanaPropuesta);
			
			break;

		}		
	}
	/**
	 * M�todo para que cuando se pulse el rat�n en el label que lo tenga agenciado
	 * en este caso el de cerrar sesi�n, se cierre la sesi�n
	 */
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
		lblAltaClientes = new JLabel("Modificar Veh�culo");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblTipo = new JLabel("Tipo:");
		lblFechaEntrada = new JLabel("Fecha Entrada:");
		lblPrecio =  new JLabel("Precio:");
		lblColor = new JLabel("Color:");
		lblConcesionario = new JLabel("Concesionario:");	
		tFMatricula = new JTextField(miVehiculo.getMatricula());
		tFMarca = new JTextField(miVehiculo.getMarca());
		tFModelo = new JTextField(miVehiculo.getModelo());
		tfFechaEntrada = new JTextField(miVehiculo.getFechaEntrada()+"");
		
		tFPrecio = new JTextField(miVehiculo.getPrecio()+"");
		tFColor = new JTextField(miVehiculo.getColor());
		tFkm = new JTextField(miVehiculo.getKilometros()+"");
		lblkm = new JLabel("Kil�metros:");
		lblCombustible = new JLabel("Combustible:");
		btnVolver = new JButton("Volver");
		btnBuscar = new JButton("Modificar");
		lblAddOk = new JLabel("VEH�CULO NO ENCONTRADO");
		lblAddOk.setVisible(false);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnBuscar.addActionListener(this);
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
		btnBuscar.setBackground(new java.awt.Color(38, 70, 83));
		lblAddOk.setBackground(new java.awt.Color(0,92,48));
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
		
		lblMatricula.setBounds(54, 109, 119, 30);
		lblMarca.setBounds(54, 150, 119, 30);
		lblModelo.setBounds(54, 191, 119, 30);
		lblTipo.setBounds(54, 232, 119, 30);

		lblPrecio.setBounds(54, 303, 119, 30); 
		lblColor.setBounds(412, 150, 142, 30); 
		lblFechaEntrada.setBounds(412, 232, 142, 30);
		lblConcesionario.setBounds(412, 303, 142, 30); 	
		tFMatricula.setBounds(183, 111, 202, 27);
		tFMarca.setBounds(183, 152, 202, 27);
		tFModelo.setBounds(183, 194, 202, 27);

		tFPrecio.setBounds(183, 305, 202, 27);
		tFColor.setBounds(554, 152, 194, 27);
		tfFechaEntrada.setBounds(554, 234, 194, 27);
		tFkm.setBounds(554, 111, 194, 27);
		lblkm.setBounds(412, 109, 142, 30);
		lblCombustible.setBounds(412, 191, 131, 30);
		btnVolver.setBounds(135, 395, 150, 50);
		btnBuscar.setBounds(498, 395, 150, 50);
		lblAddOk.setBounds(258, 40, 276, 41);
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
		lblFechaEntrada.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblPrecio.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblColor.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblConcesionario.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 			
		tFMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFMatricula.setColumns(10);
		tFMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFMarca.setColumns(10);
		tFMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFModelo.setColumns(10);
		tFModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFkm.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblkm.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));		
		tfFechaEntrada.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFPrecio.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFColor.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnBuscar.setForeground(Color.WHITE);
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
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
		panelContenido.add(lblFechaEntrada);
		panelContenido.add(lblPrecio);
		panelContenido.add(lblColor);
		panelContenido.add(lblConcesionario);	
		panelContenido.add(tFMatricula);		
		panelContenido.add(tFMarca);		
		panelContenido.add(tFModelo);		
		panelContenido.add(tfFechaEntrada);		
		panelContenido.add(tFPrecio);		
		panelContenido.add(tFColor);		
		panelContenido.add(tFkm);		
		panelContenido.add(lblkm);		
		panelContenido.add(lblCombustible);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnBuscar);
		panelContenido.add(lblAddOk);
	} 
	/**
	 * M�todo interno para rellenar el comboBox, iniciarlo....
	 */
	private void rellenarCombo() {
		ArrayList<String> listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(miVehiculo.getIdConcesionario());
		String concesionarioOriginal = listaConcesionarios.get(0);
		
		comboBox = new JComboBox();
		comboBox.addItem("Coche");
		comboBox.addItem("Motocicleta");
		comboBox.addItem("Ciclomotor");
		comboBox.setSelectedItem(miVehiculo.getTipo());
		comboBox.addActionListener(this);
		comboBox.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboBox.setBounds(183, 234, 202, 27);
		panelContenido.add(comboBox);
		
		comboCombustible = new JComboBox();
		comboCombustible.addItem("Hibrido");
		comboCombustible.addItem("Diesel");
		comboCombustible.addItem("Gasolina");
		comboCombustible.addItem("Electrico");
		comboCombustible.setSelectedItem(miVehiculo.getCombustible());
		comboCombustible.addActionListener(this);
		comboCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboCombustible.setBounds(554, 193, 194, 27);
		panelContenido.add(comboCombustible);
		
		comboConcesionarios = new JComboBox();
		listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(0);
		for (int i = 0; i < listaConcesionarios.size(); i++) {
			comboConcesionarios.addItem(listaConcesionarios.get(i));
		}
		comboConcesionarios.setSelectedItem(concesionarioOriginal);
		comboConcesionarios.addActionListener(this);
		comboConcesionarios.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboConcesionarios.setBounds(554, 305, 195, 27);
		panelContenido.add(comboConcesionarios);
	}
}
