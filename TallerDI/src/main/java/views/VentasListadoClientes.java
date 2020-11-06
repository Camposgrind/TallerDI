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

import dao.ClienteDAO;
import models.Cliente;
import models.Usuario;

public class VentasListadoClientes extends JFrame implements MouseListener, ActionListener {

	protected ArrayList<Cliente> miLista;
	protected Usuario miUser;
	protected JPanel panelDepartamento, panelUsuario, panelContenido, panelInfo;
	protected JLabel lblDepartamento, lblUsuario, lblFotoUsu, lblCerrarSesion, lblInfoVentana;
	protected JButton btnVolver;
	protected ClienteDAO miClienteDao;
	private JTable table;
	String info[][];

	/**
	 * Create the application.
	 */
	public VentasListadoClientes(Usuario miUsuario, ArrayList<Cliente> listaClientes) {

		miClienteDao = new ClienteDAO();
		miUser = miUsuario;
		miLista = listaClientes;
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon imgUsu;

		// iniciamos y damos las propiedades al frame
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color(244, 162, 97));
		getContentPane().setLayout(null);

		// Iniciamos todos los componentes
		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesion");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblInfoVentana = new JLabel("Listado clientes");
		btnVolver = new JButton("Volver");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);

		// Ponemos sus layouts
		panelDepartamento.setLayout(new BorderLayout(0, 0));
		panelUsuario.setLayout(null);
		panelContenido.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);

		// Damos color a los paneles, botones y lineas
		panelDepartamento.setBackground(new java.awt.Color(244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBackground(new java.awt.Color(244, 162, 97));
		panelContenido.setBackground(new java.awt.Color(244, 162, 97));
		panelInfo.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelInfo.setBackground(new java.awt.Color(244, 162, 97));
		btnVolver.setBackground(new java.awt.Color(119, 14, 38));

		// Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(0, 76, 786, 485);
		panelInfo.setBounds(281, 0, 228, 41);

		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		btnVolver.setBounds(332, 403, 117, 35);

		// Damos el tamaño, fuente y color a las letras
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

		// Añadimos los componentes al panel principal los paneles
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

		this.setVisible(true);
	}

	/**
	 * Método para cuando se pulse algún botón
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasBuscarCliente ventanaBuscarCliente;

		this.setVisible(false);
		this.dispose();
		ventanaBuscarCliente = new VentasBuscarCliente(miUser);

	}

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
			ventanaClienteSeleccionado = new VentasFichaCliente(miUser, miLista.get(row),this);
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
}
