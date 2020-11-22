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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UsuarioDAO;
import dao.VehiculoDAO;
import models.Usuario;
import models.Vehiculo;
import views.ventas.VentasFichaCliente;
import views.ventas.VentasFichaVehiculo;
import views.ventas.VentasListadoClientes;

import javax.swing.border.LineBorder;
import javax.swing.Icon;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MecanicoAsignarTrabajo extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnRegistrar;
	protected JLabel lblVehiculo;
	protected JLabel lblAddOk;
	protected JLabel lblMecanico;
	protected VehiculoDAO miVehiculoDao;
	protected UsuarioDAO miUsuarioDao;
	protected JComboBox<String> comboMecanico;
	private JTextField tfTiempo;
	private JTextField tfPresupuesto;
	private JTextField tfTarea;
	private JLabel lblTarea;
	private JLabel lblPiezas;
	private JTextArea textArea;
	
	/**
	 * Create the application.
	 */
	public MecanicoAsignarTrabajo(Usuario miUsuario) {
		setTitle("piCARso - Taller");
		miVehiculoDao = new VehiculoDAO();
		miUsuarioDao = new UsuarioDAO();
		miUser = miUsuario;
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon imgUsu;
		ArrayList<Usuario> listaMecanicos;
	
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
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Asignar trabajo a los mec\u00E1nicos");
		lblVehiculo = new JLabel("Vehiculo:");
		lblMecanico = new JLabel("Mec\u00E1nico:");
		btnVolver = new JButton("Volver");
		btnRegistrar = new JButton("Asignar");
		lblAddOk = new JLabel("TRABAJO ASIGNADO CORRECTAMENTE");
		lblAddOk.setVisible(false);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnRegistrar.addActionListener(this);
		panelUsuario.setLayout(null);
		panelContenido.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVehiculo.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddOk.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color(233, 196, 106));
		panelDepartamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario.setBorder(new LineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color(233, 196, 106));
		panelContenido.setBackground(new java.awt.Color(233, 196, 106));
		panelInfo.setBorder(new LineBorder(null));
		panelInfo.setBackground(new java.awt.Color(233, 196, 106));
		btnVolver.setBackground(new java.awt.Color(231, 111, 81));
		btnRegistrar.setBackground(new java.awt.Color(42, 157, 143));
		lblAddOk.setBackground(new java.awt.Color(0,92,48));
		
		//Damos el tama�o a los componentes que est�n en absoluto
		panelUsuario.setBounds(394, 0, 400, 76);
		panelDepartamento.setBounds(0, 0, 394, 76);
		panelContenido.setBounds(0, 76, 794, 495);
		panelInfo.setBounds(0, 0, 794, 41);
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		lblVehiculo.setBounds(76, 121, 119, 30);
		lblMecanico.setBounds(76, 84, 142, 30);
		btnVolver.setBounds(10, 407, 375, 77);
		btnRegistrar.setBounds(409, 407, 375, 77);
		lblAddOk.setBounds(0, 40, 794, 41);
		
		//Damos el tama�o, fuente y color a las letras 
		lblDepartamento.setForeground(Color.BLACK);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaClientes.setForeground(Color.BLACK);
		lblVehiculo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblMecanico.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnVolver.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnRegistrar.setForeground(Color.WHITE);
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		
		//A�adimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		panelDepartamento.setLayout(null);
		
		//A�adimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		JLabel lblFotoSur = new JLabel((Icon) null);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoSur.setBounds(34, 11, 70, 54);
		panelDepartamento.add(lblFotoSur);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);				
		
		//A�adimos el panel informativo, labels, textfield y botones 
		panelContenido.add(panelInfo);
		panelInfo.add(lblAltaClientes);
		panelContenido.add(lblVehiculo);
		panelContenido.add(lblMecanico);
		panelContenido.add(btnVolver);
		panelContenido.add(btnRegistrar);
		panelContenido.add(lblAddOk);
		
		comboMecanico = new JComboBox<String>();
		
		listaMecanicos = miUsuarioDao.buscarMecanicos();
		comboMecanico.addItem("");
		String mecanicoConcat = "";
		for (int i = 0; i < listaMecanicos.size(); i++) {
			mecanicoConcat = listaMecanicos.get(i).getNombre()+" "
					+listaMecanicos.get(i).getApellido()+" ("
					+listaMecanicos.get(i).getNomUsuario()+")";
			comboMecanico.addItem(mecanicoConcat);
		}
		
		comboMecanico.setSelectedItem("");
		comboMecanico.addActionListener(this);
		comboMecanico.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboMecanico.setBounds(210, 86, 508, 27);
		panelContenido.add(comboMecanico);
		
		JLabel lblTiempo = new JLabel("Tiempo est:");
		lblTiempo.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblTiempo.setBounds(76, 300, 142, 30);
		panelContenido.add(lblTiempo);
		
		tfTiempo = new JTextField();
		tfTiempo.setFont(new Font("Dialog", Font.PLAIN, 19));
		tfTiempo.setColumns(10);
		tfTiempo.setBounds(210, 302, 509, 27);
		panelContenido.add(tfTiempo);
		
		JComboBox comboVehiculo = new JComboBox();
		comboVehiculo.setFont(new Font("Dialog", Font.PLAIN, 19));
		comboVehiculo.setBounds(209, 122, 508, 27);
		panelContenido.add(comboVehiculo);
		
		JLabel lblPresupuesto = new JLabel("Presupuesto:");
		lblPresupuesto.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblPresupuesto.setBounds(76, 336, 142, 30);
		panelContenido.add(lblPresupuesto);
		
		tfPresupuesto = new JTextField();
		tfPresupuesto.setFont(new Font("Dialog", Font.PLAIN, 19));
		tfPresupuesto.setColumns(10);
		tfPresupuesto.setBounds(210, 338, 509, 27);
		panelContenido.add(tfPresupuesto);
		
		tfTarea = new JTextField();
		tfTarea.setFont(new Font("Dialog", Font.PLAIN, 19));
		tfTarea.setColumns(10);
		tfTarea.setBounds(209, 160, 509, 27);
		panelContenido.add(tfTarea);
		
		lblTarea = new JLabel("Tarea:");
		lblTarea.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblTarea.setBounds(76, 158, 142, 30);
		panelContenido.add(lblTarea);
		
		lblPiezas = new JLabel("Piezas:");
		lblPiezas.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblPiezas.setBounds(76, 193, 142, 30);
		panelContenido.add(lblPiezas);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Dialog", Font.PLAIN, 19));
		textArea.setBounds(210, 198, 508, 91);
		panelContenido.add(textArea);
		
					
		this.setVisible(true);
		
		
	}
	
	
	/**
	 * M�todo para cuando se pulse alg�n bot�n
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
			
		case "Asignar":
			//idConcesionario = miConcesionarioDao.buscarIDConcesionario(comboMecanico.getSelectedItem().toString())+"";
			lblAddOk.setVisible(true);
			textArea.setText("");
			tfTarea.setText("");
			tfTiempo.setText("");
			tfPresupuesto.setText("");
			comboMecanico.setSelectedItem("");
			//comboVehiculo.setSelectedItem("");
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
}