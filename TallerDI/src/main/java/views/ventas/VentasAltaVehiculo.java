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
import views.LoginV;

@SuppressWarnings("serial")
public class VentasAltaVehiculo extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes,lblkm,lblCombustible;
	protected JButton btnVolver,btnRegistrar;
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
	private JTextField tFKm;
	/**
	 * Create the application.
	 */
	public VentasAltaVehiculo(Usuario miUsuario) {
		setTitle("piCARso - Ventas");
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
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		
		this.addComponentes();
		//rellenamos el combo
		this.rellenarCombos();

		
					
		this.setVisible(true);
	}
	/**
	 * M�todo para cuando se pulse alg�n bot�n
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
			miVehiculoDao.addVehiculo(
					tFMatricula.getText(), tFMarca.getText(), tFModelo.getText(),
					comboBox.getSelectedItem().toString(),tFPrecio.getText(),tFKm.getText(),tFColor.getText(),comboCombustible.getSelectedItem().toString(), 
					tfFechaEntrada.getText(),idConcesionario);
			
			lblAddOk.setVisible(true);
			tFMatricula.setText("");
			tFMarca.setText("");
			tFModelo.setText("");
			tfFechaEntrada.setText("");
			tFPrecio.setText("");
			tFColor.setText("");
			tFKm.setText("");
			comboCombustible.setSelectedItem("");
			comboBox.setSelectedItem("");
			comboConcesionarios.setSelectedItem("");
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
		imgUsu = new ImageIcon("assets/user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Alta veh�culo");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblTipo = new JLabel("Tipo:");
		lblFechaEntrada = new JLabel("Fecha Entrada:");
		lblPrecio =  new JLabel("Precio:");
		lblColor = new JLabel("Color:");
		lblConcesionario = new JLabel("Concesionario:");	
		tFMatricula = new JTextField();
		tFMarca = new JTextField();
		tFModelo = new JTextField();
		tfFechaEntrada = new JTextField();
		
		tFPrecio = new JTextField();
		tFColor = new JTextField();
		tFKm = new JTextField();
		lblkm = new JLabel("Kil�metros:");
		lblCombustible = new JLabel("Combustible:");
		btnVolver = new JButton("Volver");
		btnRegistrar = new JButton("Registrar");
		lblAddOk = new JLabel("VEH�CULO A�ADIDO");
		lblAddOk.setVisible(false);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnRegistrar.addActionListener(this);
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
		btnRegistrar.setBackground(new java.awt.Color(42, 157, 143));
		lblAddOk.setBackground(new java.awt.Color(0,92,48));
	}
	/**
	 * M�todo para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(0, 76, 786, 485);
		panelInfo.setBounds(0, 0, 786, 41);
		
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
		lblkm.setBounds(412, 109, 142, 30);
		lblCombustible.setBounds(412, 191, 131, 30);
		
		tFMatricula.setBounds(183, 111, 202, 27);
		tFMarca.setBounds(183, 152, 202, 27);
		tFModelo.setBounds(183, 194, 202, 27);
		tFPrecio.setBounds(183, 305, 202, 27);
		tFColor.setBounds(554, 152, 194, 27);
		tfFechaEntrada.setBounds(554, 234, 194, 27);
		tFKm.setBounds(554, 111, 194, 27);
		btnVolver.setBounds(152, 401, 150, 50);
		btnRegistrar.setBounds(487, 401, 150, 50);
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
		tFKm.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblkm.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tfFechaEntrada.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFPrecio.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFColor.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
	
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnRegistrar.setForeground(Color.WHITE);
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
	}
	/**
	 * M�todo para a�adir todos los componentes al panel principal 
	 */
	private void addComponentes() {
		
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
		panelContenido.add(tFKm);		
		panelContenido.add(lblkm);		
		panelContenido.add(lblCombustible);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnRegistrar);
		panelContenido.add(lblAddOk);
	}
	/**
	 * M�todo para crear los comboBox, rellenarlos, darle todas sus propiedades y a�adirlos al panel
	 */
	private void rellenarCombos() {
		ArrayList<String> listaConcesionarios;
		
		comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Coche");
		comboBox.addItem("Motocicleta");
		comboBox.addItem("Ciclomotor");
		comboBox.setSelectedItem("");
		comboBox.addActionListener(this);
		comboBox.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboBox.setBounds(183, 234, 202, 27);
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
		comboCombustible.setBounds(554, 193, 194, 27);
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
		comboConcesionarios.setBounds(554, 305, 195, 27);
		panelContenido.add(comboConcesionarios);
	}
}