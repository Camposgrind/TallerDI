package views.ventas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

import dao.ClienteDAO;
import dao.ConcesionarioDAO;
import dao.VehiculoDAO;
import models.Cliente;
import models.Propuesta;
import models.Usuario;
import models.Vehiculo;
import views.LoginV;

public class VentasListadoPropuestas extends JFrame implements MouseListener, ActionListener {

	protected ArrayList<Vehiculo> listaVehiculos;
	protected Usuario miUser;
	protected JPanel panelDepartamento, panelUsuario, panelContenido, panelInfo;
	protected JLabel lblDepartamento, lblUsuario, lblFotoUsu, lblCerrarSesion, lblInfoVentana;
	protected JButton btnVolver;
	private JTable table;
	protected String info[][];
	protected ArrayList<Cliente> listaClientes;
	protected ClienteDAO miClienteDao;
	protected VehiculoDAO miVehiculoDao;
	protected ArrayList<Propuesta> listaPropuestas;
	/**
	 * Constructor
	 * @param miUser
	 * @param miListaVehiculos
	 */
	public VentasListadoPropuestas(Usuario miUser, ArrayList<Propuesta> miListaPropuestas) {
		miClienteDao = new ClienteDAO();
		miVehiculoDao = new VehiculoDAO();
		listaPropuestas = miListaPropuestas;
		this.miUser = miUser;
		listaVehiculos = new ArrayList<Vehiculo>();
		listaClientes = new ArrayList<Cliente>();
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		// iniciamos y damos las propiedades al frame
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color(244, 162, 97));
		getContentPane().setLayout(null);
	
		// Iniciamos todos los componentes
		this.iniciarComponentes();
	
		// Ponemos sus layouts
		this.ponerLayoutsComponentes();
	
		// Damos color a los paneles, botones y lineas
		this.darColorComponentes();
	
		// Damos el tamaño a los componentes que están en absoluto
		this.colocarComponentes();
	
		// Damos el tamaño, fuente y color a las letras
		this.addPropiedadesLetras();
	
		// Añadimos los componentes al panel principal los paneles
		this.addComponentes();
		
		
		this.rellenarListaVehiculos();
		this.rellenarListaClientes();
		
		this.rellenarTabla();
	
		this.setVisible(true);
	}
	/**
	 * Método interno para rellenar la lista de vehiculos para meter en la tabla su info
	 */
	private void rellenarListaVehiculos() {
		ArrayList<Vehiculo> listaTemporal= new ArrayList<Vehiculo>();
		
		for (int i = 0; i < listaPropuestas.size(); i++) {
			
			listaTemporal = miVehiculoDao.buscarVehiculo(listaPropuestas.get(i).getMatricula(),
					"", "", "", "", "", "", "", "", "",false);
			for (int j = 0; j < listaTemporal.size(); j++) {
				listaVehiculos.add(listaTemporal.get(j));
			}
		}

	}
	/**
	 * Método interno para rellenar la lista de clientes para meter en la tabla su info
	 */
	private void rellenarListaClientes() {
		Cliente miCliente;
		
		for (int i = 0; i < listaPropuestas.size(); i++) {
			miCliente = miClienteDao.buscarClienteById(listaPropuestas.get(i).getIdCliente());
			listaClientes.add(miCliente);
		}
	}
	/**
	 * Método para cuando se pulse algún botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasBuscarPropuesta ventanaBuscarPropuesta;
	
		this.setVisible(false);
		this.dispose();
		ventanaBuscarPropuesta = new VentasBuscarPropuesta(miUser);
	}
	
	@Override
	/**
	 * Método para cuando pulsemos una celada nos de la ficha o si es el 
	 * label de cerrar sesión se salga del usuario
	 */
	public void mouseClicked(MouseEvent e) {
		LoginV loginCerrarSesion;
		VentasFichaPropuesta ventanaPropuestaSeleccionada;
		VentasFichaCliente ventanaClienteSeleccionado;
		
		Component txtBtn = e.getComponent();
		if(txtBtn==lblCerrarSesion) {
			this.setVisible(false);
			this.dispose();
			miUser = null;
			loginCerrarSesion = new LoginV();
		}else {
			 //obtener la fila
	        int row = table.getSelectedRow();
	        //obtener la columna
	        int i = table.getSelectedColumn();
			table.getValueAt(row, i);
			this.setVisible(false);
			ventanaPropuestaSeleccionada = new VentasFichaPropuesta(miUser, listaPropuestas.get(row),this);
		}
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
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblInfoVentana = new JLabel("Listado propuestas");
		btnVolver = new JButton("Volver");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
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
	}
	/**
	 * Método interno para dar color a los componenetes (botones, lineas, labels, panels...)
	 */
	private void darColorComponentes() {
		
		panelDepartamento.setBackground(new java.awt.Color(244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBackground(new java.awt.Color(244, 162, 97));
		panelContenido.setBackground(new java.awt.Color(244, 162, 97));
		panelInfo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelInfo.setBackground(new java.awt.Color(244, 162, 97));
		btnVolver.setBackground(new java.awt.Color(119, 14, 38));
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
		btnVolver.setBounds(332, 403, 117, 35);
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
		lblInfoVentana.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblInfoVentana.setForeground(new java.awt.Color(38, 70, 83));
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
	}
	/**
	 * Método para añadir todos los componentes al panel principal 
	 */
	private void addComponentes() {
		
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		// Añadimos los labels a los paneles
		panelDepartamento.add(lblDepartamento);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);
		// Añadimos el panel informativo, labels, textfield y botones
		panelContenido.add(panelInfo);
		panelInfo.add(lblInfoVentana);
	
		panelContenido.add(btnVolver);
	} 
	private void rellenarTabla() {
		//Para la tabla 
		//este array bidimensional sera para determinar como es de grande
		//la tabla (filas, columnas)
		info = new String[listaPropuestas.size()][9];
		//String nombreConcesionario = miConcesionarioDao.get
		
		//en esta array ponemos los nombre de las columnas
		String[] nombresColumnas = { "Nombre", "Apellidos", "Matricula", "Tipo", 
				"Marca","Modelo","Combustible","Precio","Fecha propuesta" };
		//hacemos un buvle para que la lista nos de los datos del cliente poniendo 
		// "" para que si es un int lo convierta en string 
		for (int i = 0; i < listaPropuestas.size(); i++) {
			info[i][0] = listaClientes.get(i).getNombre() + "";
			info[i][1] = listaClientes.get(i).getApellidos() + "";
			info[i][2] = listaVehiculos.get(i).getMatricula() + "";
			info[i][3] = listaVehiculos.get(i).getTipo() + "";
			info[i][4] = listaVehiculos.get(i).getMarca() + "";
			info[i][5] = listaVehiculos.get(i).getModelo() + "";
			info[i][6] = listaVehiculos.get(i).getCombustible() + "";
			info[i][7] = listaPropuestas.get(i).getPresupuesto() + "";
			info[i][8] = listaPropuestas.get(i).getFecha() + "";
		}
		//le decimos que la tabla tendra la array bi dimensional de info y las columnas de parametro
		table = new JTable(info, nombresColumnas);
		table.setCellSelectionEnabled(true);
		
		table.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		table.setBounds(0, 0, 510, 209);
		//Iniciamos un scrollpane para que meta la tabla dentro 
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setBackground(new java.awt.Color(244, 162, 97));
		scrollPane.setBounds(10, 112, 766, 213);
		//le añadimos un mouse listener para que cuando pinchemos nos salga la ficha
		//del cliente que tocamos 
		table.addMouseListener(this);
	
		panelContenido.add(scrollPane);

	}
	
}
