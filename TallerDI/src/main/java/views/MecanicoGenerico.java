package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Usuario;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class MecanicoGenerico extends JFrame implements ActionListener, MouseListener{
	
	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelBotones;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblFotoSur;
	protected JButton btnAltaVeh,btnHistorialTaller,btnVerVehiculosTaller,btnFinalizarReparacion,btnTrabajoAsignado;
	private JLabel lblFotoSurPeque;
	protected JTextPane textPanelOpcion;
	boolean jefe = false;
	
	/**
	 * Create the application.
	 */
	public MecanicoGenerico(Usuario miUsuario) {
		setTitle("PICARSO - Taller");
		miUser = miUsuario;
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon imgLogoTaller,imgUsu;
		
		//iniciamos y damos las propiedades al frame 
		this.setBounds(100,100,810,610);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color(233, 196, 106));
		getContentPane().setLayout(null);
		
		//Iniciamos todos los componentes 
		panelDepartamento = new JPanel();
		panelBotones = new JPanel();
		panelBotones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario = new JPanel();
		lblUsuario = new JLabel(miUser.getNomUsuario());
		imgUsu = new ImageIcon("user-icon.png");
		lblCerrarSesion = new JLabel("Cerrar sesion");
		lblFotoUsu = new JLabel(imgUsu);
		btnAltaVeh = new JButton("Alta de veh\u00EDculos");
		btnHistorialTaller = new JButton("Consultar historial");
		btnVerVehiculosTaller = new JButton("Veh\u00EDculos en taller");
		btnFinalizarReparacion = new JButton("Asignar trabajo");
		btnTrabajoAsignado = new JButton("Trabajo asignado");
		imgLogoTaller = new ImageIcon("logoTaller.png");
		lblFotoSur = new JLabel(imgLogoTaller);
		lblCerrarSesion.addMouseListener(this);
		btnAltaVeh.addActionListener(this);
		btnHistorialTaller.addActionListener(this);
		btnVerVehiculosTaller.addActionListener(this);
		btnFinalizarReparacion.addActionListener(this);
		btnTrabajoAsignado.addActionListener(this);
		panelUsuario.setLayout(null);
		panelBotones.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color(233, 196, 106));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario.setBackground(new java.awt.Color(233, 196, 106));
		panelBotones.setBackground(new java.awt.Color(233, 196, 106));
		btnAltaVeh.setBackground(new java.awt.Color(38, 70, 83));
		btnHistorialTaller.setBackground(new java.awt.Color(38, 70, 83));
		btnVerVehiculosTaller.setBackground(new java.awt.Color(38, 70, 83));
		btnFinalizarReparacion.setBackground(new java.awt.Color(38, 70, 83));
		btnTrabajoAsignado.setBackground(new java.awt.Color(38, 70, 83));
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(393, 0, 401, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelBotones.setBounds(0, 74, 794, 496);
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		btnAltaVeh.setBounds(32, 27, 270, 75);
		btnHistorialTaller.setBounds(490, 113, 270, 79);
		btnVerVehiculosTaller.setBounds(490, 27, 270, 75);
		btnTrabajoAsignado.setBounds(490, 203, 270, 79);
		btnFinalizarReparacion.setBounds(32, 112, 270, 80);
		lblFotoSur.setBounds(10, 323, 774, 162);
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnAltaVeh.setForeground(Color.BLACK);
		btnAltaVeh.setForeground(Color.WHITE);
		btnHistorialTaller.setForeground(Color.WHITE);
		btnVerVehiculosTaller.setForeground(Color.WHITE);
		btnFinalizarReparacion.setForeground(Color.WHITE);
		btnAltaVeh.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnHistorialTaller.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnVerVehiculosTaller.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnFinalizarReparacion.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnTrabajoAsignado.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnTrabajoAsignado.setForeground(Color.WHITE);
		//Añadimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelBotones);
		panelDepartamento.setLayout(null);
		
		lblFotoSurPeque = new JLabel((Icon) null);
		lblFotoSurPeque.setBounds(1, 1, 0, 74);
		lblFotoSurPeque.setHorizontalAlignment(SwingConstants.CENTER);
		panelDepartamento.add(lblFotoSurPeque);
		lblDepartamento = new JLabel("TALLER");
		lblDepartamento.setBounds(10, 11, 373, 54);
		panelDepartamento.add(lblDepartamento);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Damos el tamaño, fuente y color a las letras 
		lblDepartamento.setForeground(Color.BLACK);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);
		//Añadimos los botones y el label de la fto al panel principal 
		panelBotones.add(btnAltaVeh);
		panelBotones.add(btnHistorialTaller);
		panelBotones.add(btnVerVehiculosTaller);
		panelBotones.add(btnFinalizarReparacion);
		panelBotones.add(btnTrabajoAsignado);
		panelBotones.add(lblFotoSur);
		
		textPanelOpcion = new JTextPane();
		textPanelOpcion.setBackground(new java.awt.Color(233, 196, 106));
		textPanelOpcion.setForeground(Color.RED);
		textPanelOpcion.setFont(new Font("Dialog", Font.PLAIN, 20));
		textPanelOpcion.setText("Opci\u00F3n no disponible desde este perfil.");
		textPanelOpcion.setBounds(32, 203, 270, 79);
		textPanelOpcion.setVisible(false);
		panelBotones.add(textPanelOpcion);
					
		this.setVisible(true);
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		MecanicoAltaVehiculo ventanaAltaVehiculo;
		MecanicoAsignarTrabajo ventanaAsignarTrabajo;
		MecanicoVehiculosEnTaller ventanaVehiculosEnTaller;
		MecanicoTrabajoAsignado ventanaTrabajoAsignado;
		MecanicoConsultarHistorial ventanaConsultarHistorial;
		
		String txtBtn = e.getActionCommand();
		
		jefe = miUser.isMecanicoJefe();
		
		switch (txtBtn) {
		case "Alta de vehículos":
			if (jefe == true) {
				this.setVisible(false);
				this.dispose();
				ventanaAltaVehiculo = new MecanicoAltaVehiculo(miUser);
			} else {
				textPanelOpcion.setVisible(true);
			}
			break;
		case "Asignar trabajo":
			if (jefe == true) {
				this.setVisible(false);
				this.dispose();
				ventanaAsignarTrabajo = new MecanicoAsignarTrabajo(miUser);
			} else {
				textPanelOpcion.setVisible(true);
			}
			break;
		case "Vehículos en taller":
			this.setVisible(false);
			this.dispose();
			ventanaVehiculosEnTaller = new MecanicoVehiculosEnTaller(miUser);
			break;
		case "Consultar historial":
			this.setVisible(false);
			this.dispose();
			ventanaConsultarHistorial = new MecanicoConsultarHistorial(miUser);
			break;
		case "Trabajo asignado":
			this.setVisible(false);
			this.dispose();
			ventanaTrabajoAsignado = new MecanicoTrabajoAsignado(miUser);
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
