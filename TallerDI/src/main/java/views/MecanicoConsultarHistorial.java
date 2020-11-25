package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConcesionarioDAO;
import dao.ReparacionDAO;
import dao.VehiculoDAO;
import models.Reparacion;
import models.Usuario;
import models.Vehiculo;
import views.ventas.VentasFichaCliente;
import views.ventas.VentasFichaVehiculo;
import views.ventas.VentasListadoClientes;

import javax.swing.border.LineBorder;
import javax.swing.JList;

@SuppressWarnings("serial")
public class MecanicoConsultarHistorial extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo,panelTemporal;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver;
	protected JLabel lblMatricula;
	protected VehiculoDAO miVehiculoDao;
	protected ConcesionarioDAO miConcesionarioDao;
	private JTextField tfMatricula;
	private JTable table;
	protected String info[][];
	protected ReparacionDAO miReparacionDAO;
	
	
	/**
	 * Create the application.
	 */
	public MecanicoConsultarHistorial(Usuario miUsuario) {
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
		this.setBounds(100, 100, 810, 610);
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
		imgUsu = new ImageIcon("assets/FotosUsuario/FotoUsuario"+miUser.getIdUsuario()+".jpg");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Consultar historial de reparaciones");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		btnVolver = new JButton("Volver");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		panelUsuario.setLayout(null);
		panelContenido.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color(233, 196, 106));
		panelDepartamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario.setBorder(new LineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color(233, 196, 106));
		panelContenido.setBackground(new java.awt.Color(233, 196, 106));
		panelInfo.setBorder(new LineBorder(null));
		panelInfo.setBackground(new java.awt.Color(233, 196, 106));
		btnVolver.setBackground(new java.awt.Color(231, 111, 81));
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(394, 0, 400, 76);
		panelDepartamento.setBounds(0, 0, 394, 76);
		panelContenido.setBounds(0, 76, 794, 495);
		panelInfo.setBounds(0, 0, 794, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		
		lblMatricula.setBounds(155, 72, 119, 41);
		btnVolver.setBounds(10, 407, 375, 77);
		
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
		
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnVolver.setForeground(Color.WHITE);
		
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
		

		
		panelContenido.add(btnVolver);
		listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(0);
		for (int i = 0; i < listaConcesionarios.size(); i++) {
			//comboConcesionarios.addItem(listaConcesionarios.get(i));
		}
		
		
		JButton btnBuscarMatricula = new JButton("Buscar Matr\u00EDcula");
		btnBuscarMatricula.setForeground(Color.WHITE);
		btnBuscarMatricula.setFont(new Font("Dialog", Font.PLAIN, 19));
		btnBuscarMatricula.setBackground(new java.awt.Color(38, 70, 83));
		btnBuscarMatricula.setBounds(409, 407, 375, 77);
		panelContenido.add(btnBuscarMatricula);
		btnBuscarMatricula.addActionListener(this);

		tfMatricula = new JTextField();
		tfMatricula.setFont(new Font("Dialog", Font.PLAIN, 19));
		tfMatricula.setColumns(10);
		tfMatricula.setBounds(257, 72, 375, 41);
		panelContenido.add(tfMatricula);
		
		
		panelTemporal = new JPanel();
		panelTemporal.setVisible(true);
		panelTemporal.setBounds(10, 136, 774, 260);
		panelContenido.add(panelTemporal);
		
					
		this.setVisible(true);
	}
	
	
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		MecanicoGenerico ventanaMecanicoG;
		ArrayList<Vehiculo> miListaVehiculos;
		String txtBtn = e.getActionCommand();
		String idConcesionario;
		ReparacionDAO miReparacionDAO;
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaMecanicoG = new MecanicoGenerico(miUser);			
			break;
			
		case "Buscar Matrícula":
			panelTemporal.setVisible(false);
			this.rellenarTabla();
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
	
	
	private void rellenarTabla() {
		
		miReparacionDAO = new ReparacionDAO();
		
		ArrayList<Reparacion> listaReparaciones = miReparacionDAO.consultarHistorialPorMatricula(tfMatricula.getText());
		
		//Para la tabla 
		//este array bidimensional sera para determinar como es de grande
		//la tabla (filas, columnas)
		info = new String[listaReparaciones.size()][4];
		
		//en esta array ponemos los nombre de las columnas
		String[] nombresColumnas = { "Matricula", "Fecha de Entrada", "Fecha de Salida", "Reparación" };
		//hacemos un buvle para que la lista nos de los datos del cliente poniendo 
		// "" para que si es un int lo convierta en string 
		for (int i = 0; i < info.length; i++) {
			info[i][0] = listaReparaciones.get(i).getMatricula() + "";
			info[i][1] = listaReparaciones.get(i).getFechaEntrada() + "";
			info[i][2] = listaReparaciones.get(i).getFechaSalida() + "";
			info[i][3] = listaReparaciones.get(i).getTrabajo() + "";
		}
		
		//le decimos que la tabla tendra la array bi dimensional de info y las columnas de parametro
		table = new JTable(info, nombresColumnas);
		table.setCellSelectionEnabled(true);
		
		table.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		table.setBounds(0, 0, 510, 209);
		
		
		
		//Iniciamos un scrollpane para que meta la tabla dentro 
		JScrollPane scrollPane= new JScrollPane(table);
		scrollPane.setBackground(new java.awt.Color(244, 162, 97));
		scrollPane.setBounds(10, 136, 774, 260);
		
		//le añadimos un mouse listener para que cuando pinchemos nos salga la ficha
		//del cliente que tocamos 
		table.addMouseListener(this);

		panelContenido.add(scrollPane);
	}
	
}