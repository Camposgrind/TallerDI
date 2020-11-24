package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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


import dao.VehiculoDAO;
import models.Usuario;
import models.Vehiculo;

import views.ventas.VentasFichaVehiculo;


public class JefeStockVehiculos extends JFrame implements MouseListener, ActionListener {

	protected ArrayList<Vehiculo> listaVehiculos;
	protected Usuario miUser;
	protected JPanel panelDepartamento, panelUsuario, panelContenido, panelInfo;
	protected JLabel lblDepartamento, lblUsuario, lblFotoUsu, lblCerrarSesion, lblInfoVentana;
	protected JButton btnVolver;
	private JTable table;
	protected ArrayList<String> listaNombreConce;
	protected String info[][];
	protected VehiculoDAO miVehiculoDao;
	
	/**
	 * Constructor
	 * @param miUser
	 * @param miListaVehiculos
	 */
	public JefeStockVehiculos(Usuario miUser) {
		
		this.miUser = miUser;
		miVehiculoDao = new VehiculoDAO();
		listaVehiculos = miVehiculoDao.buscarVehiculo("", "", "", "", "", "", "", "", "", "", true);
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
		
		this.rellenarTabla();
	
		this.setVisible(true);
	}
	
	/**
	 * Método para cuando se pulse algún botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JefeGenerico ventanaGenericaJefe;
	
		this.setVisible(false);
		this.dispose();
		ventanaGenericaJefe = new JefeGenerico(miUser);
	
	}
	
	@Override
	/**
	 * Método para cuando pulsemos una celada nos de la ficha o si es el 
	 * label de cerrar sesión se salga del usuario
	 */
	public void mouseClicked(MouseEvent e) {
		LoginV loginCerrarSesion;
		VentasFichaVehiculo ventanaVehiculoSeleccionado;
		
		Component txtBtn = e.getComponent();
		if(txtBtn==lblCerrarSesion) {
			this.setVisible(false);
			this.dispose();
			miUser = null;
			loginCerrarSesion = new LoginV();
		}else {/*
			 //obtener la fila
	        int row = table.getSelectedRow();
	        //obtener la columna
	        int i = table.getSelectedColumn();
			table.getValueAt(row, i);
			this.setVisible(false);
			ventanaVehiculoSeleccionado = new VentasFichaVehiculo(miUser, listaVehiculos.get(row),this,ventanaPropuesta);*/
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
		lblDepartamento = new JLabel("JEFE");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesión");
		imgUsu = new ImageIcon("assets/user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblInfoVentana = new JLabel("Vehículos en stock");
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
	/**
	 * Método interno para rellenar la tabla 
	 */
	private void rellenarTabla() {
		//Para la tabla 
		//este array bidimensional sera para determinar como es de grande
		//la tabla (filas, columnas)
		info = new String[listaVehiculos.size()][9];
		//String nombreConcesionario = miConcesionarioDao.get
		
		//en esta array ponemos los nombre de las columnas
		String[] nombresColumnas = { "Matrícula", "Marca", "Modelo", "Tipo", 
				"Precio","KM","Color","Combustible","Fecha entrada" };
		//hacemos un buvle para que la lista nos de los datos del cliente poniendo 
		// "" para que si es un int lo convierta en string 
		for (int i = 0; i < info.length; i++) {
			info[i][0] = listaVehiculos.get(i).getMatricula() + "";
			info[i][1] = listaVehiculos.get(i).getMarca() + "";
			info[i][2] = listaVehiculos.get(i).getModelo() + "";
			info[i][3] = listaVehiculos.get(i).getTipo() + "";
			info[i][4] = listaVehiculos.get(i).getPrecio() + "";
			info[i][5] = listaVehiculos.get(i).getKilometros() + "";
			info[i][6] = listaVehiculos.get(i).getColor() + "";
			info[i][7] = listaVehiculos.get(i).getCombustible() + "";
			info[i][8] = listaVehiculos.get(i).getFechaEntrada() + "";
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
