package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ClienteDAO;
import dao.ConcesionarioDAO;
import dao.UsuarioDAO;
import dao.VehiculoDAO;
import models.Cliente;
import models.Propuesta;
import models.Reparacion;
import models.Usuario;
import models.Vehiculo;
import views.ventas.VentasBuscarPropuesta;
import views.ventas.VentasGenerico;
import views.ventas.VentasListadoPropuestas;
import views.ventas.VentasPropuestaVenta;
import javax.swing.JTextArea;

public class MecanicoFichaReparacion extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblFichaReparacion;
	protected JButton btnVolver,btnFinalizarRep,btnIniciarRepa;
	protected JLabel lblMatricula,lblNombreUsu,lblTrabajo;
	protected JLabel lblMarca,lblNombreCl,lblApellidosCl;
	protected JLabel lblModelo;
	protected JLabel lblTipo;
	protected JLabel lblFechaEntrada;
	protected JLabel lblPresupuesto,lblEstado;
	protected JLabel tFMatricula,tFNombreUsu,tFTrabajo;
	protected JLabel tFMarca,tFNombreCl,tFApellidosCl;
	protected JLabel tFModelo, lblPiezas,lblCombustible,tFCombustible;
	protected JLabel tFTipo,tfFechaEntrada,tFPresupuesto,tFEstado;
	protected JTextArea textArea;
	protected MecanicoTrabajoAsignado ventanaTrabajoAsignado;
	protected VentasPropuestaVenta ventanaPropuesta;
	protected VehiculoDAO miVehiculoDao;
	protected ClienteDAO miClienteDao;
	protected Vehiculo miVehiculo;
	protected Reparacion miReparacion;
	protected Cliente miCliente;
	
	/**
	 * Create the application.
	 */
	public MecanicoFichaReparacion(Usuario miUsuario,Reparacion miReparacion, MecanicoTrabajoAsignado miVentanaTrabajo) {
		
		miVehiculoDao = new VehiculoDAO();
		miClienteDao = new ClienteDAO();
		ventanaTrabajoAsignado = miVentanaTrabajo;		
		this.miReparacion = miReparacion;
		miUser = miUsuario;
		miVehiculo = miVehiculoDao.buscarVehiculo(miReparacion.getMatricula()
				, "", "", "", "", "", "", "", "", "",false).get(0);
		miCliente = miClienteDao.buscarClienteById(miVehiculo.getIdCliente());
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon imgUsu;
		//ArrayList<String> listaConcesionarios = miConcesionarioDao.buscarNombreConcesionario(miVehiculo.getIdConcesionario());
		
		//iniciamos y damos las propiedades al frame 
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color( 244, 162, 97));
		getContentPane().setLayout(null);

		//Iniciamos todos los componentes 
		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("MEC\u00C1NICO");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesion");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblFichaReparacion = new JLabel("Ficha reparaci\u00F3n");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblTipo = new JLabel("Tipo:");
		lblFechaEntrada = new JLabel("Fecha entrada:");
		lblPresupuesto =  new JLabel("Presupuesto:");
		lblEstado = new JLabel("Estado:");
		tFMatricula = new JLabel(miVehiculo.getMatricula());
		tFMarca = new JLabel(miVehiculo.getMarca());
		tFModelo = new JLabel(miVehiculo.getModelo());
		tFTipo = new JLabel(miVehiculo.getTipo());	
		tfFechaEntrada = new JLabel(miReparacion.getFechaEntrada().toString());
		lblPiezas = new JLabel("Piezas:");
		lblCombustible = new JLabel("Combustible:");
		tFCombustible = new JLabel(miVehiculo.getCombustible());
		lblNombreUsu = new JLabel("Nombre mec\u00E1nico:");
		lblTrabajo = new JLabel("Trabajo:");
		lblNombreCl = new JLabel("Nombre cliente:");
		lblApellidosCl = new JLabel("Apellidos cliente:");
		tFNombreUsu = new JLabel(miUser.getNombre());
		tFTrabajo  = new JLabel(miReparacion.getTrabajo());
		tFNombreCl  = new JLabel(miCliente.getNombre());
		tFApellidosCl = new JLabel(miCliente.getApellidos());
		textArea = new JTextArea(miReparacion.getPiezas());
		textArea.setEditable(false);
		btnIniciarRepa = new JButton("Iniciar reparaci\u00F3n");
		tFPresupuesto = new JLabel(miReparacion.getPresupuesto()+"");
		tFEstado = new JLabel(miReparacion.getEstado());
		//Hay que modificar esto
		btnVolver = new JButton("Volver");
		//btnModificar = new JButton("Vender");
		btnFinalizarRep = new JButton("Finalizar reparaci\u00F3n");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnFinalizarRep.addActionListener(this);
		
		if(miReparacion.getEstado().equals("Pendiente")) {
			btnFinalizarRep.setEnabled(false);
		}else if(miReparacion.getEstado().equals("En curso")) {
			btnIniciarRepa.setEnabled(false);
		}else {
			btnFinalizarRep.setEnabled(false);
			btnIniciarRepa.setEnabled(false);
		}

		//Ponemos sus layouts
		panelDepartamento.setLayout(new BorderLayout(0, 0));
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
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelContenido.setBackground(new java.awt.Color( 244, 162, 97));
		panelInfo.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelInfo.setBackground(new java.awt.Color( 244, 162, 97));
		btnVolver.setBackground(new java.awt.Color(119, 14, 38));
		btnFinalizarRep.setBackground(new Color(82, 21, 255));
		textArea.setBackground(new java.awt.Color( 244, 162, 97));
		btnIniciarRepa.setBackground(new Color(82, 21, 255));
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(0, 76, 786, 485);
		panelInfo.setBounds(0, 0, 786, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		
		lblMatricula.setBounds(425, 70, 119, 30);
		lblMarca.setBounds(425, 152, 119, 30);
		lblModelo.setBounds(425, 193, 119, 30);
		lblTipo.setBounds(425, 111, 119, 30);

		lblPresupuesto.setBounds(23, 232, 163, 30); 
		lblEstado.setBounds(24, 273, 142, 30); 
		lblFechaEntrada.setBounds(24, 314, 179, 30);
		tFMatricula.setBounds(569, 72, 207, 27);
		tFMarca.setBounds(569, 154, 207, 27);
		tFModelo.setBounds(574, 195, 202, 27);
		tFTipo.setBounds(569, 111, 202, 27);
		lblPiezas.setBounds(425, 273, 119, 30);
		tFCombustible.setBounds(569, 234, 179, 27);
		lblCombustible.setBounds(425, 234, 131, 30);

		tFPresupuesto.setBounds(213, 234, 189, 27);
		tFEstado.setBounds(213, 275, 179, 27);
		tfFechaEntrada.setBounds(213, 317, 179, 27);
		
		lblNombreUsu.setBounds(24, 70, 179, 30);
		lblTrabajo.setBounds(24, 191, 179, 30); 
		lblNombreCl.setBounds(24, 111, 159, 30);
		lblApellidosCl.setBounds(24, 150, 159, 30);
		tFNombreUsu.setBounds(213, 70, 202, 27);
		tFTrabajo.setBounds(213, 194, 179, 27);
		tFNombreCl.setBounds(213, 113, 207, 27);
		tFApellidosCl.setBounds(213, 152, 202, 27);
		textArea.setBounds(569, 279, 179, 92);
		btnIniciarRepa.setBounds(270, 399, 240, 75);
		btnVolver.setBounds(10, 399, 238, 75);
		btnFinalizarRep.setBounds(536, 399, 240, 75);

		//Damos el tamaño, fuente y color a las letras 
		lblDepartamento.setForeground(new java.awt.Color(38, 70, 83));
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(new java.awt.Color(38, 70, 83));
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(new java.awt.Color(38, 70, 83));
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblFichaReparacion.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblFichaReparacion.setForeground(new java.awt.Color(38, 70, 83));
		lblMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTipo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblFechaEntrada.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblPresupuesto.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblEstado.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 		
		tFMatricula.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));		
		tFMarca.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));				
		tFModelo.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));		
		tFTipo.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		lblPiezas.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFCombustible.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		lblCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));		
		tfFechaEntrada.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFPresupuesto.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFEstado.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		
		lblNombreUsu.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblTrabajo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblNombreCl.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblApellidosCl.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		tFNombreUsu.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFTrabajo.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFNombreCl.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFApellidosCl.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		textArea.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		btnIniciarRepa.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnFinalizarRep.setForeground(Color.WHITE);
		btnIniciarRepa.setForeground(Color.WHITE);
		btnFinalizarRep.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		
		//Añadimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		//Añadimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);				
		//Añadimos el panel informativo, labels, textfield y botones 
		panelContenido.add(panelInfo);
		panelInfo.add(lblFichaReparacion);		
		panelContenido.add(lblMatricula);		
		panelContenido.add(lblMarca);		
		panelContenido.add(lblModelo);		
		panelContenido.add(lblTipo);
		panelContenido.add(lblFechaEntrada);
		panelContenido.add(lblPresupuesto);
		panelContenido.add(lblEstado);
		
		panelContenido.add(tFMatricula);		
		panelContenido.add(tFMarca);		
		panelContenido.add(tFModelo);		
		panelContenido.add(tFTipo);
		panelContenido.add(tfFechaEntrada);		
		panelContenido.add(tFPresupuesto);		
		panelContenido.add(tFEstado);		
		panelContenido.add(lblNombreCl);
		panelContenido.add(lblApellidosCl);
		panelContenido.add(lblNombreUsu);
		panelContenido.add(lblTrabajo);
		panelContenido.add(tFNombreCl);
		panelContenido.add(tFNombreUsu);
		panelContenido.add(tFApellidosCl);
		panelContenido.add(tFTrabajo);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnFinalizarRep);
		panelContenido.add(textArea);
		panelContenido.add(btnIniciarRepa);
		panelContenido.add(lblPiezas);
		panelContenido.add(lblCombustible);
		panelContenido.add(tFCombustible);
					
		this.setVisible(true);
	}
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasBuscarPropuesta ventanaBuscarPropuesta;
		VentasGenerico ventanaVentasGenerico;
		String txtBtn = e.getActionCommand();
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			if(ventanaTrabajoAsignado==null) {
							
				ventanaBuscarPropuesta = new VentasBuscarPropuesta(miUser);
			}else {
				ventanaTrabajoAsignado.setVisible(true);
			}
			break;

		case "Vender":
			this.setVisible(false);
			this.dispose();
			ventanaVentasGenerico = new VentasGenerico(miUser);
			//miVehiculoDao.venderVehiculo(miUsuarioPropuesta.getIdUsuario(),1,miVehiculo.getMatricula());
			JOptionPane.showMessageDialog(this, "Venta realizada con éxito");
			

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
	private void getUsuario() {
		
	}
}
