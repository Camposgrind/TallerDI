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
import javax.swing.border.LineBorder;
import javax.swing.JList;

@SuppressWarnings("serial")
public class MecanicoVehiculosEnTaller extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnAmpliar;
	protected VehiculoDAO miVehiculoDao;
	protected ConcesionarioDAO miConcesionarioDao;
	/**
	 * Create the application.
	 */
	public MecanicoVehiculosEnTaller(Usuario miUsuario) {
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
		this.setBackground(new java.awt.Color(244, 162, 97));
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
		lblAltaClientes = new JLabel("Consultar veh\u00EDculos en el taller");
		btnVolver = new JButton("Volver");
		btnAmpliar = new JButton("Iniciar reparaci\u00F3n");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnAmpliar.addActionListener(this);
		panelUsuario.setLayout(null);
		panelContenido.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		
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
		btnVolver.setBounds(10, 407, 254, 77);
		btnAmpliar.setBounds(274, 407, 250, 77);
		
		//Damos el tamaño, fuente y color a las letras 
		lblDepartamento.setForeground(Color.BLACK);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaClientes.setForeground(Color.BLACK);
		
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnVolver.setForeground(Color.WHITE);
		btnAmpliar.setFont(new Font("Dialog", Font.PLAIN, 22));
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
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnAmpliar);
		listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(0);
		for (int i = 0; i < listaConcesionarios.size(); i++) {
			//comboConcesionarios.addItem(listaConcesionarios.get(i));
		}
		
		JList list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(10, 52, 774, 344);
		panelContenido.add(list);
		
		JButton btnFinalizarReparacin = new JButton("Finalizar reparaci\u00F3n");
		btnFinalizarReparacin.setForeground(Color.WHITE);
		btnFinalizarReparacin.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnFinalizarReparacin.setBackground(new Color(42, 157, 143));
		btnFinalizarReparacin.setBounds(534, 407, 250, 77);
		panelContenido.add(btnFinalizarReparacin);
		
					
		this.setVisible(true);
	}
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		MecanicoGenerico ventanaMecanicoG;
		MecanicoReparacionEnCurso ventanaReparacion;
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
			
		case "Iniciar reparación":
			
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
			
			this.setVisible(false);
			this.dispose();
			ventanaReparacion = new MecanicoReparacionEnCurso(miUser);			
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