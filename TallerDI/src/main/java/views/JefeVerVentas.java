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
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import dao.UsuarioDAO;
import models.DateLabelFormatter;
import models.Usuario;
import views.ventas.VentasFichaCliente;
import javax.swing.JTextField;

public class JefeVerVentas extends JFrame implements MouseListener, ActionListener {

	protected Usuario miUser;
	protected JPanel panelDepartamento, panelUsuario, panelContenido, panelInfo;
	protected JLabel lblDepartamento, lblUsuario, lblFotoUsu, lblCerrarSesion, lblInfoVentana,lblVentasT;
	protected JButton btnVolver,btnBuscar;
	private JTable table;
	protected String info[][];
	protected ArrayList<Usuario> listaUsuarios;
	private JTextField tFTotalVentas;
	private int totalVentas;
	private JLabel lblDesde;
	private JLabel lblHasta;
	private UsuarioDAO miUsuDao;

	/**
	 * Create the application.
	 */
	public JefeVerVentas(Usuario miUsuario) {

		miUser = miUsuario;
		miUsuDao = new UsuarioDAO();
		getContentPane().setForeground(Color.BLACK);
		initialize();
		totalVentas = 0;
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
		//rellenamos la tabla
		this.rellenarTabla();
		//añadimos el datepicker
		this.crearDatePickers();

		this.setVisible(true);
	}

	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		JefeGenerico ventanaJefeG;

		this.setVisible(false);
		this.dispose();
		ventanaJefeG = new JefeGenerico(miUser);

	}

	@SuppressWarnings("unused")
	@Override
	/**
	 * Método para cuando pulsemos una celada nos de la ficha o si es el 
	 * label de cerrar sesión se salga del usuario
	 */
	public void mouseClicked(MouseEvent e) {
		LoginV loginCerrarSesion;
		VentasFichaCliente ventanaClienteSeleccionado;
		
		Component txtBtn = e.getComponent();
		if(txtBtn==lblCerrarSesion) {
			this.setVisible(false);
			this.dispose();
			miUser = null;
			loginCerrarSesion = new LoginV();
		}else {
			/* //obtener la fila
	        int row = table.getSelectedRow();
	        //obtener la columna
	        int i = table.getSelectedColumn();
			table.getValueAt(row, i);
			this.setVisible(false);
			ventanaClienteSeleccionado = new VentasFichaCliente(miUser, miLista.get(row),this,ventanaPropuesta);*/
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
		lblCerrarSesion = new JLabel("Cerrar sesion");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblVentasT = new JLabel("Total Ventas:");
		tFTotalVentas = new JTextField(totalVentas);
		tFTotalVentas.setEditable(false);
		tFTotalVentas.setColumns(10);
		lblInfoVentana = new JLabel("Listado ventas");
		btnVolver = new JButton("Volver");
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		
		listaUsuarios = miUsuDao.buscarUsuarioVentas(null, null);
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
		btnBuscar.setBackground(new Color(119, 14, 38));
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
		lblVentasT.setBounds(437, 336, 125, 29);
		tFTotalVentas.setBounds(572, 336, 150, 29);
		btnVolver.setBounds(332, 403, 117, 35);
		btnBuscar.setBounds(605, 66, 117, 35);
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
		tFTotalVentas.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblVentasT.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
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
		panelContenido.add(lblVentasT);
		panelContenido.add(tFTotalVentas);

		panelContenido.add(btnVolver);
		panelContenido.add(btnBuscar);
	} 
	private void rellenarTabla() {
		//Para la tabla 
		//este array bidimensional sera para determinar como es de grande
		//la tabla (filas, columnas)
		info = new String[listaUsuarios.size()][6];
		
		//en esta array ponemos los nombre de las columnas
		String[] nombresColumnas = { "Usuario", "Nombre", "Apellidos", "Teléfono", "Sueldo", "Ventas" };
		//hacemos un buvle para que la lista nos de los datos del cliente poniendo 
		// "" para que si es un int lo convierta en string 
		for (int i = 0; i < info.length; i++) {
			info[i][0] = listaUsuarios.get(i).getNomUsuario() + "";
			info[i][1] = listaUsuarios.get(i).getNombre() + "";
			info[i][2] = listaUsuarios.get(i).getApellido() + "";
			info[i][3] = listaUsuarios.get(i).getTelefono() + "";
			info[i][4] = listaUsuarios.get(i).getSueldo() + "";
			info[i][5] = listaUsuarios.get(i).getComisionVentas() + "";
			totalVentas += listaUsuarios.get(i).getComisionVentas();
			
		}
		//le decimos que ponga el total de ventas en el textfield 
		tFTotalVentas.setText(totalVentas+"");
		//le decimos que la tabla tendra la array bi dimensional de info y las columnas de parametro
		table = new JTable(info, nombresColumnas);
		table.setCellSelectionEnabled(true);
		
		table.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		table.setBounds(0, 0, 510, 209);
		//Iniciamos un scrollpane para que meta la tabla dentro 
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setBackground(new java.awt.Color(244, 162, 97));
		scrollPane.setBounds(65, 112, 657, 213);
		//le añadimos un mouse listener para que cuando pinchemos nos salga la ficha
		//del cliente que tocamos 
		table.addMouseListener(this);

		panelContenido.add(scrollPane);
		
		lblDesde = new JLabel("Desde:");
		lblDesde.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblDesde.setBounds(65, 72, 70, 29);
		panelContenido.add(lblDesde);
		
		lblHasta = new JLabel("Hasta:");
		lblHasta.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblHasta.setBounds(334, 72, 70, 29);
		panelContenido.add(lblHasta);
		

	}
	private void crearDatePickers() {
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePickerDesde = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePickerDesde.setBounds(131, 72, 193, 29);
		panelContenido.add(datePickerDesde);
		JDatePickerImpl datePickerHasta = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePickerHasta.setBounds(396, 72, 193, 29);
		panelContenido.add(datePickerHasta);
		

	}
}
