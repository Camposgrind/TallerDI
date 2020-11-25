package views.ventas;

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

import dao.ClienteDAO;
import models.Cliente;
import models.Usuario;
import views.LoginV;

@SuppressWarnings("serial")
public class VentasListadoClientes extends JFrame implements MouseListener, ActionListener {

	protected ArrayList<Cliente> miLista;
	protected Usuario miUser;
	protected JPanel panelDepartamento, panelUsuario, panelContenido, panelInfo;
	protected JLabel lblDepartamento, lblUsuario, lblFotoUsu, lblCerrarSesion, lblInfoVentana;
	protected JButton btnVolver;
	protected ClienteDAO miClienteDao;
	private JTable table;
	protected String info[][];
	protected VentasPropuestaVenta ventanaPropuesta;

	/**
	 * Create the application.
	 */
	public VentasListadoClientes(Usuario miUsuario, ArrayList<Cliente> listaClientes,VentasPropuestaVenta miVentanaPropuesta) {
		setTitle("piCARso - Ventas");

		miClienteDao = new ClienteDAO();
		miUser = miUsuario;
		miLista = listaClientes;
		ventanaPropuesta = miVentanaPropuesta;
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
		//rellenamos la tabla
		this.rellenarTabla();
		

		this.setVisible(true);
	}

	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasBuscarCliente ventanaBuscarCliente;

		this.setVisible(false);
		this.dispose();
		ventanaBuscarCliente = new VentasBuscarCliente(miUser,ventanaPropuesta);

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
			 //obtener la fila
	        int row = table.getSelectedRow();
	        //obtener la columna
	        int i = table.getSelectedColumn();
			table.getValueAt(row, i);
			this.setVisible(false);
			ventanaClienteSeleccionado = new VentasFichaCliente(miUser, miLista.get(row),this,ventanaPropuesta);
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
		imgUsu = new ImageIcon("assets/FotosUsuario/FotoUsuario"+miUser.getIdUsuario()+".jpg");
		lblFotoUsu = new JLabel(imgUsu);
		lblInfoVentana = new JLabel("Listado clientes");
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
		
		panelDepartamento.setBackground(new java.awt.Color(233, 196, 106));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color(233, 196, 106));
		panelContenido.setBackground(new java.awt.Color(233, 196, 106));
		panelInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelInfo.setBackground(new java.awt.Color(233, 196, 106));
		btnVolver.setBackground(new java.awt.Color(231, 111, 81));
	}
	/**
	 * Método para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		
		panelUsuario.setBounds(393, 0, 391, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(0, 76, 784, 484);
		panelInfo.setBounds(0, 0, 784, 41);

		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		btnVolver.setBounds(313, 386, 150, 50);
	}
	/**
	 * Método para darle la fuentes a las letras de los componentes
	 */
	private void addPropiedadesLetras() {
		
		lblDepartamento.setForeground(Color.BLACK);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblInfoVentana.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblInfoVentana.setForeground(Color.BLACK);
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
		info = new String[miLista.size()][5];
		
		//en esta array ponemos los nombre de las columnas
		String[] nombresColumnas = { "ID cliente", "Nombre", "Apellidos", "Teléfono", "DNI" };
		//hacemos un buvle para que la lista nos de los datos del cliente poniendo 
		// "" para que si es un int lo convierta en string 
		for (int i = 0; i < info.length; i++) {
			info[i][0] = miLista.get(i).getIdCliente() + "";
			info[i][1] = miLista.get(i).getNombre() + "";
			info[i][2] = miLista.get(i).getApellidos() + "";
			info[i][3] = miLista.get(i).getTelefono() + "";
			info[i][4] = miLista.get(i).getDni() + "";
		}
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
	}
}
