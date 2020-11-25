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
import views.ventas.VentasListadoClientes;

import javax.swing.border.LineBorder;
import javax.swing.JList;

@SuppressWarnings("serial")
public class MecanicoConsultarHistorial extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnAmpliar;
	protected JLabel lblMatricula;
	protected JTextField tFMatricula;
	protected VehiculoDAO miVehiculoDao;
	protected ConcesionarioDAO miConcesionarioDao;
	private JTextField textField;
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
		imgUsu = new ImageIcon("assets/user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Consultar historial de reparaciones");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		tFMatricula = new JTextField();
		btnVolver = new JButton("Volver");
		btnAmpliar = new JButton("Ampliar");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnAmpliar.addActionListener(this);
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
		btnAmpliar.setBackground(new java.awt.Color(42, 157, 143));
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(394, 0, 400, 76);
		panelDepartamento.setBounds(0, 0, 394, 76);
		panelContenido.setBounds(0, 76, 794, 495);
		panelInfo.setBounds(0, 0, 794, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		
		lblMatricula.setBounds(21, 52, 119, 30);
		tFMatricula.setBounds(143, 52, 202, 27);
		btnVolver.setBounds(10, 407, 375, 77);
		btnAmpliar.setBounds(409, 407, 375, 77);
		
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
		tFMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFMatricula.setColumns(10);
		
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnVolver.setForeground(Color.WHITE);
		btnAmpliar.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnAmpliar.setForeground(Color.WHITE);
		
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
		
		panelContenido.add(tFMatricula);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnAmpliar);
		listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(0);
		for (int i = 0; i < listaConcesionarios.size(); i++) {
			//comboConcesionarios.addItem(listaConcesionarios.get(i));
		}
		
		JButton btnBuscarMatricula = new JButton("Buscar");
		btnBuscarMatricula.setForeground(Color.WHITE);
		btnBuscarMatricula.setFont(new Font("Dialog", Font.PLAIN, 19));
		btnBuscarMatricula.setBackground(new java.awt.Color(38, 70, 83));
		btnBuscarMatricula.setBounds(153, 90, 182, 27);
		panelContenido.add(btnBuscarMatricula);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblDni.setBounds(409, 52, 119, 30);
		panelContenido.add(lblDni);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 19));
		textField.setColumns(10);
		textField.setBounds(518, 54, 202, 27);
		panelContenido.add(textField);
		
		JButton btnBuscarDni = new JButton("Buscar");
		btnBuscarDni.setForeground(Color.WHITE);
		btnBuscarDni.setFont(new Font("Dialog", Font.PLAIN, 19));
		btnBuscarDni.setBackground(new java.awt.Color(38, 70, 83));
		btnBuscarDni.setBounds(528, 90, 182, 27);
		panelContenido.add(btnBuscarDni);
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(10, 128, 774, 268);
		panelContenido.add(list);
		
					
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
		VentasFichaCliente ventanaFicha;
		VentasListadoClientes ventanaListaClientes;
		VentasFichaVehiculo ventanaFichaVehiculo;
		String idConcesionario;
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaMecanicoG = new MecanicoGenerico(miUser);			
			break;
			
		case "Registrar":
			
//			idConcesionario = miConcesionarioDao.buscarIDConcesionario(comboConcesionarios.getSelectedItem().toString())+"";
//			miVehiculoDao.addVehiculo(
//					tFMatricula.getText(), tFMarca.getText(), tFModelo.getText(),
//					comboBox.getSelectedItem().toString(),tFPrecio.getText(),tFKm.getText(),tFColor.getText(),comboCombustible.getSelectedItem().toString(), 
//					tfFechaEntrada.getText(),idConcesionario);
//			
//			lblAddOk.setVisible(true);
//			tFMatricula.setText("");
//			tFMarca.setText("");
//			tFModelo.setText("");
//			tfFechaEntrada.setText("");
//			tFPrecio.setText("");
//			tFColor.setText("");
//			tFKm.setText("");
//			comboCombustible.setSelectedItem("");
//			comboBox.setSelectedItem("");
//			comboConcesionarios.setSelectedItem("");
//			break;


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