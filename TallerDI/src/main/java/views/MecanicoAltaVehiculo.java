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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ClienteDAO;
import dao.ConcesionarioDAO;
import dao.ReparacionDAO;
import dao.VehiculoDAO;
import models.Cliente;
import models.Usuario;
import models.Vehiculo;
import views.ventas.VentasFichaCliente;
import views.ventas.VentasFichaVehiculo;
import views.ventas.VentasListadoClientes;

import javax.swing.border.LineBorder;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class MecanicoAltaVehiculo extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaVehiculo,lblkm,lblCombustible;
	protected JButton btnVolver,btnRegistrar,btnBuscarMatricula,btnBuscarDni;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JLabel lblTipo,lblAddOk;
	protected JLabel lblFotoSur;
	protected JLabel lblDni,lblNombre,lblApellidos,lblTelfono;
	protected JTextField tFMatricula;
	protected JTextField tFMarca;
	protected JTextField tFModelo;
	protected VehiculoDAO miVehiculoDao;
	protected ClienteDAO miClienteDao;
	protected ReparacionDAO miReparacionDao;
	private JTextField tFKm,tFTipo,tFCombustible;
	private JTextField tFDni;
	private JTextField tFNombre;
	private JTextField tFApellidos;
	private JTextField tFTelefono;
	protected Vehiculo miVehiculo;	
	protected Cliente miCliente;
	
	
	/**
	 * Create the application.
	 */
	public MecanicoAltaVehiculo(Usuario miUsuario) {
		setTitle("piCARso - Taller");
		miVehiculoDao = new VehiculoDAO();
		miClienteDao = new ClienteDAO();
		miReparacionDao = new ReparacionDAO();
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
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaVehiculo = new JLabel("Alta veh�culo");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblTipo = new JLabel("Tipo:");
		tFMatricula = new JTextField();
		tFMarca = new JTextField();
		tFModelo = new JTextField();
		tFKm = new JTextField();
		lblkm = new JLabel("Kil�metros:");
		lblCombustible = new JLabel("Combustible:");
		btnVolver = new JButton("Volver");
		btnRegistrar = new JButton("Registrar");
		lblAddOk = new JLabel("VEH\u00CDCULO A\u00D1ADIDO CORRECTAMENTE");
		lblAddOk.setVisible(false);
		lblDni = new JLabel("DNI: ");
		lblNombre = new JLabel("Nombre:");
		lblApellidos = new JLabel("Apellidos:");
		lblTelfono = new JLabel("Tel\u00E9fono:");
		lblFotoSur = new JLabel((Icon) null);
		tFDni = new JTextField();
		tFApellidos = new JTextField();
		tFNombre = new JTextField();
		tFTelefono = new JTextField();
		tFTipo = new JTextField();
		tFCombustible = new JTextField();
		btnBuscarMatricula = new JButton("Buscar matr�cula");
		btnBuscarDni = new JButton("Buscar DNI");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnRegistrar.addActionListener(this);
		btnBuscarMatricula.addActionListener(this);
		btnBuscarDni.addActionListener(this);
		
		
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
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
		panelDepartamento.setLayout(null);
		
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
		btnBuscarMatricula.setBackground(new Color(38, 70, 83));
		btnBuscarDni.setBackground(new Color(38, 70, 83));
		lblAddOk.setBackground(new java.awt.Color(0,92,48));
		
		//Damos el tama�o a los componentes que est�n en absoluto
		panelUsuario.setBounds(394, 0, 400, 76);
		panelDepartamento.setBounds(0, 0, 394, 76);
		panelContenido.setBounds(0, 76, 794, 495);
		panelInfo.setBounds(0, 0, 794, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		
		lblMatricula.setBounds(20, 80, 119, 30);
		lblMarca.setBounds(20, 157, 119, 30);
		lblModelo.setBounds(20, 195, 119, 30);
		lblTipo.setBounds(20, 271, 119, 30);
		tFMatricula.setBounds(143, 82, 202, 27);
		tFMarca.setBounds(143, 159, 202, 27);
		tFModelo.setBounds(143, 197, 202, 27);

		tFKm.setBounds(143, 235, 202, 27);
		lblkm.setBounds(20, 233, 142, 30);
		lblCombustible.setBounds(20, 311, 131, 30);
		lblAddOk.setBounds(0, 40, 794, 41);
		lblDni.setBounds(409, 80, 119, 30);
		lblNombre.setBounds(409, 157, 119, 30);
		lblApellidos.setBounds(409, 195, 119, 30);
		lblTelfono.setBounds(409, 233, 142, 30);
		lblFotoSur.setBounds(34, 11, 70, 54);
		tFTelefono.setBounds(524, 235, 202, 27);
		tFNombre.setBounds(524, 157, 202, 27);
		tFApellidos.setBounds(524, 195, 202, 27);
		tFDni.setBounds(524, 80, 202, 27);
		tFTipo.setBounds(143, 273, 202, 27);
		tFCombustible.setBounds(143, 313, 202, 27);

		btnBuscarDni.setBounds(534, 121, 182, 27);
		btnBuscarMatricula.setBounds(153, 121, 182, 27);
		
		btnVolver.setBounds(10, 407, 375, 77);
		btnRegistrar.setBounds(409, 407, 375, 77);
		
		//Damos el tama�o, fuente y color a las letras 
		lblDepartamento.setForeground(Color.BLACK);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaVehiculo.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaVehiculo.setForeground(Color.BLACK);
		lblMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTipo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));		
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
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 25));
		btnVolver.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("DejaVu Sans", Font.PLAIN, 25));
		btnRegistrar.setForeground(Color.WHITE);
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		btnBuscarMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		lblDni.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFDni.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		btnBuscarDni.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		lblNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTelfono.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFTelefono.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFDni.setColumns(10);	
		tFNombre.setColumns(10);		
		tFApellidos.setColumns(10);		
		tFTelefono.setColumns(10);
		tFTipo.setColumns(10);
		tFCombustible.setColumns(10);
		tFTipo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		btnBuscarMatricula.setForeground(Color.WHITE);
		btnBuscarDni.setForeground(Color.WHITE);
		
		//A�adimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		//A�adimos los labels a los paneles 
		
		panelDepartamento.add(lblFotoSur);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);				
		//A�adimos el panel informativo, labels, textfield y botones 
		panelContenido.add(panelInfo);
		panelInfo.add(lblAltaVehiculo);	
		
		panelContenido.add(lblMatricula);		
		panelContenido.add(lblMarca);		
		panelContenido.add(lblModelo);		
		panelContenido.add(lblTipo);
		
		panelContenido.add(tFMatricula);		
		panelContenido.add(tFMarca);		
		panelContenido.add(tFModelo);		
		panelContenido.add(tFKm);		
		panelContenido.add(lblkm);		
		panelContenido.add(lblCombustible);
		panelContenido.add(lblDni);
		panelContenido.add(lblAddOk);
		panelContenido.add(tFDni);
		panelContenido.add(lblNombre);
		panelContenido.add(lblApellidos);
		panelContenido.add(lblTelfono);
		panelContenido.add(tFApellidos);
		panelContenido.add(tFNombre);
		panelContenido.add(tFTelefono);
		panelContenido.add(tFTipo);
		panelContenido.add(tFCombustible);
		
		panelDepartamento.add(lblDepartamento);
		
		
		
		panelContenido.add(btnBuscarDni);
		panelContenido.add(btnBuscarMatricula);
		panelContenido.add(btnVolver);
		panelContenido.add(btnRegistrar);

		this.setVisible(true);
	}
	/**
	 * M�todo para cuando se pulse alg�n bot�n
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		MecanicoGenerico ventanaMecanicoG;
		ArrayList<Cliente> listaClientes;
		ArrayList<Vehiculo> miListaVehiculos;
		String txtBtn = e.getActionCommand();
		boolean addReparacionOk = false;

		
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaMecanicoG = new MecanicoGenerico(miUser);			
			break;
			
		case "Registrar":

			addReparacionOk = miReparacionDao.addReparacion(tFMatricula.getText());
			if(addReparacionOk) {
				this.setVisible(false);
				this.dispose();
				ventanaMecanicoG = new MecanicoGenerico(miUser);
				JOptionPane.showMessageDialog(this, "Reparacion a�adida con �xito");
			}else {
				JOptionPane.showMessageDialog(this, "No se ha podido a�adir la reparaci�n");
			}
			
		
			break;
			
		
		case "Buscar matr�cula":
			miListaVehiculos = miVehiculoDao.buscarVehiculo(tFMatricula.getText(), "", "", "", "", "",
					"", "", "", "", false);
			
			if(miListaVehiculos.size()==1) {
				miVehiculo = miListaVehiculos.get(0);
				
				tFMarca.setText(miVehiculo.getMarca());
				tFModelo.setText(miVehiculo.getModelo());
				tFKm.setText(miVehiculo.getKilometros()+"");
				tFTipo.setText(miVehiculo.getTipo());
				tFCombustible.setText(miVehiculo.getCombustible());	
				
				miCliente = miClienteDao.buscarClienteById(miVehiculo.getIdCliente());
				tFDni.setText(miCliente.getDni());
				tFNombre.setText(miCliente.getNombre());
				tFApellidos.setText(miCliente.getApellidos());
				tFTelefono.setText(miCliente.getTelefono());
			}else {
				JOptionPane.showMessageDialog(this, "No hay ning�n veh�culo con esa matr�cula, debes registrarlo a mano");
			}
		
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