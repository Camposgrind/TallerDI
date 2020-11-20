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
import javax.swing.Icon;

@SuppressWarnings("serial")
public class MecanicoAsignarTrabajo extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnRegistrar;
	protected JLabel lblResumen;
	protected JLabel lblTarea;
	protected JLabel lblAddOk;
	protected JLabel lblConcesionario;
	protected JTextField tFResumen;
	protected JTextField tFTarea;
	protected VehiculoDAO miVehiculoDao;
	protected ConcesionarioDAO miConcesionarioDao;
	protected JComboBox comboConcesionarios;
	private JTextField textField;
	/**
	 * Create the application.
	 */
	public MecanicoAsignarTrabajo(Usuario miUsuario) {
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
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Asignar trabajo a los mec\u00E1nicos");
		lblResumen = new JLabel("Resumen:");
		lblTarea = new JLabel("Tarea:");
		lblConcesionario = new JLabel("Mec\u00E1nico:");
		tFResumen = new JTextField();
		tFTarea = new JTextField();
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
		lblResumen.setHorizontalAlignment(SwingConstants.LEFT);
		lblTarea.setHorizontalAlignment(SwingConstants.LEFT);
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
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(394, 0, 400, 76);
		panelDepartamento.setBounds(0, 0, 394, 76);
		panelContenido.setBounds(0, 76, 794, 495);
		panelInfo.setBounds(0, 0, 794, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		lblResumen.setBounds(10, 122, 119, 30);
		lblTarea.setBounds(10, 163, 119, 30);
		lblConcesionario.setBounds(10, 84, 142, 30);
		tFResumen.setBounds(117, 124, 667, 27);
		tFTarea.setBounds(117, 165, 667, 184);
		btnVolver.setBounds(10, 407, 375, 77);
		btnRegistrar.setBounds(409, 407, 375, 77);
		lblAddOk.setBounds(0, 40, 794, 41);
		
		//Damos el tamaño, fuente y color a las letras 
		lblDepartamento.setForeground(Color.BLACK);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaClientes.setForeground(Color.BLACK);
		lblResumen.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTarea.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblConcesionario.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFResumen.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFResumen.setColumns(10);
		tFResumen.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFTarea.setColumns(10);
		tFTarea.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnVolver.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnRegistrar.setForeground(Color.WHITE);
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		
		//Añadimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		panelDepartamento.setLayout(null);
		//Añadimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		
		JLabel lblFotoSur = new JLabel((Icon) null);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoSur.setBounds(34, 11, 70, 54);
		panelDepartamento.add(lblFotoSur);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);				
		//Añadimos el panel informativo, labels, textfield y botones 
		panelContenido.add(panelInfo);
		panelInfo.add(lblAltaClientes);
		panelContenido.add(lblResumen);		
		panelContenido.add(lblTarea);
		panelContenido.add(lblConcesionario);
		panelContenido.add(tFResumen);		
		panelContenido.add(tFTarea);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnRegistrar);
		panelContenido.add(lblAddOk);
		
		comboConcesionarios = new JComboBox();
		listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(0);
		comboConcesionarios.addItem("");
		for (int i = 0; i < listaConcesionarios.size(); i++) {
			comboConcesionarios.addItem(listaConcesionarios.get(i));
		}
		comboConcesionarios.setSelectedItem("");
		comboConcesionarios.addActionListener(this);
		comboConcesionarios.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		comboConcesionarios.setBounds(117, 86, 268, 27);
		panelContenido.add(comboConcesionarios);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 19));
		lblFecha.setBounds(436, 81, 142, 30);
		panelContenido.add(lblFecha);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 19));
		textField.setColumns(10);
		textField.setBounds(516, 83, 268, 27);
		panelContenido.add(textField);
		
					
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
			
			idConcesionario = miConcesionarioDao.buscarIDConcesionario(comboConcesionarios.getSelectedItem().toString())+"";

			lblAddOk.setVisible(true);

			tFResumen.setText("");
			tFTarea.setText("");

			comboConcesionarios.setSelectedItem("");
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
}