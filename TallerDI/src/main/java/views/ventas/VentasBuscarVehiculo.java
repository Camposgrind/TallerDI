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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConcesionarioDAO;
import dao.VehiculoDAO;
import models.Concesionario;
import models.Usuario;
import models.Vehiculo;
import views.LoginV;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class VentasBuscarVehiculo extends JFrame implements MouseListener,ActionListener{

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
	private JTextField tFKm;
	protected VentasPropuestaVenta ventanaPropuesta;
	/**
	 * Create the application.
	 */
	public VentasBuscarVehiculo(Usuario miUsuario, VentasPropuestaVenta miVentanaPropuesta ) {
		miVehiculoDao = new VehiculoDAO();
		miConcesionarioDao = new ConcesionarioDAO();
		ventanaPropuesta = miVentanaPropuesta;
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
		
		//iniciamos todos los componentes de la vista
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
		//Rellenamos el combo
		this.rellenarCombo();
					
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
		VentasListadoVehiculos ventanaListaVehiculos;
		VentasFichaVehiculo ventanaFichaVehiculo;
		String idConcesionario=comboConcesionarios.getSelectedItem().toString();
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			
			if(ventanaPropuesta!=null) {
				ventanaPropuesta.setVisible(true);
			}else {
				ventanaVentasG = new VentasGenerico(miUser);						
			}
			break;
			
		case "Buscar":
			
			lblAddOk.setVisible(false);
			if(!idConcesionario.equals("")) {
			idConcesionario = miConcesionarioDao.buscarIDConcesionario(idConcesionario)+"";
			}
			miListaVehiculos = miVehiculoDao.buscarVehiculo(tFMatricula.getText(), tFMarca.getText(), 
					tFModelo.getText(),comboBox.getSelectedItem().toString(),tFPrecio.getText(),tFKm.getText(),
					tFColor.getText(),comboCombustible.getSelectedItem().toString(),tfFechaEntrada.getText(),idConcesionario,true);			
		
			if(miListaVehiculos.size()==1) {
				this.setVisible(false);
				this.dispose();	
				ventanaFichaVehiculo = new VentasFichaVehiculo(miUser,miListaVehiculos.get(0),null,ventanaPropuesta);
			}else if(miListaVehiculos.size()>1) {
				this.setVisible(false);
				this.dispose();
				ventanaListaVehiculos = new VentasListadoVehiculos(miUser,miListaVehiculos,ventanaPropuesta);
			}else{
				lblAddOk.setVisible(true);
				tFMatricula.setText("");
				tFMarca.setText("");
				tFModelo.setText("");
							
			}
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
		ImageIcon imgUsu;
		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesión");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Buscar vehículos");
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
		lblkm = new JLabel("Kilómetros:");
		lblCombustible = new JLabel("Combustible:");
		btnVolver = new JButton("Volver");
		btnBuscar = new JButton("Buscar");
		lblAddOk = new JLabel("VEHÍCULO NO ENCONTRADO");
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
		btnBuscar.setBackground(new java.awt.Color(0,92,48));
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
		lblColor.setBounds(412, 150, 142, 30); 
		lblFechaEntrada.setBounds(412, 232, 142, 30);
		lblConcesionario.setBounds(412, 303, 142, 30); 	
		tFMatricula.setBounds(183, 111, 202, 27);
		tFMarca.setBounds(183, 152, 202, 27);
		tFModelo.setBounds(183, 194, 202, 27);
		tFPrecio.setBounds(183, 305, 202, 27);
		tFColor.setBounds(554, 152, 194, 27);
		tfFechaEntrada.setBounds(554, 234, 194, 27);
		tFKm.setBounds(554, 111, 194, 27);
		lblkm.setBounds(412, 109, 142, 30);
		lblCombustible.setBounds(412, 191, 131, 30);
		btnVolver.setBounds(153, 420, 117, 35);
		btnBuscar.setBounds(515, 420, 117, 35);
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
		btnBuscar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnBuscar.setForeground(Color.WHITE);
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
		panelContenido.add(tfFechaEntrada);		
		panelContenido.add(tFPrecio);		
		panelContenido.add(tFColor);		
		panelContenido.add(tFKm);		
		panelContenido.add(lblkm);		
		panelContenido.add(lblCombustible);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnBuscar);
		panelContenido.add(lblAddOk);
	} 
	private void rellenarCombo() {
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