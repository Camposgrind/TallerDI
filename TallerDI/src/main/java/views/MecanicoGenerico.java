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
	protected JButton btnAltaVeh,btnHistorialTaller,btnVerVehiculosTaller,btnAsignarTrabajo,btnTrabajoAsignado;
	private JLabel lblFotoSurPeque;
	protected JTextPane textPanelOpcion;
	boolean jefe = false;
	private JLabel lblicono1;
	private JLabel lblicono3;
	private JLabel lblicono2;
	private JLabel lblicono4;
	private JLabel lblicono5;
	
	/**
	 * Create the application.
	 */
	public MecanicoGenerico(Usuario miUsuario) {
		setTitle("piCARso - Taller");
		miUser = miUsuario;
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
		//iniciamos y damos las propiedades al frame 
		this.setBounds(100,100,810,610);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color(233, 196, 106));
		getContentPane().setLayout(null);
		
		
		//Iniciamos todos los componentes 
		this.iniciarComponentes();
		
		this.ponerLayoutsComponentes();
		
		//Damos color a los paneles, botones y lineas 
		this.darColorComponentes();
		
		//Damos el tamaño a los componentes que están en absoluto
		this.colocarComponentes();		
		
		this.addPropiedadesLetras();
		
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
		panelBotones.add(btnAsignarTrabajo);
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
		

		panelBotones.add(lblicono1);
		panelBotones.add(lblicono3);
		panelBotones.add(lblicono2);
		panelBotones.add(lblicono4);
		panelBotones.add(lblicono5);

					
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
	/**
	 * Método interno para iniciar los componentes
	 */
	private void iniciarComponentes() {

		ImageIcon imgLogoTaller,imgUsu,icono1,icono2,icono3,icono4,icono5;
		
		panelDepartamento = new JPanel();
		panelBotones = new JPanel();
		panelBotones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario = new JPanel();
		lblUsuario = new JLabel(miUser.getNomUsuario());
		imgUsu = new ImageIcon("assets/FotosUsuario/FotoUsuario"+miUser.getIdUsuario()+".jpg");
		lblCerrarSesion = new JLabel("Cerrar sesión");
		lblFotoUsu = new JLabel(imgUsu);
		btnAltaVeh = new JButton("Alta de veh\u00EDculos");
		btnHistorialTaller = new JButton("Consultar historial");
		btnVerVehiculosTaller = new JButton("Veh\u00EDculos en taller");
		btnAsignarTrabajo = new JButton("Asignar trabajo");
		btnTrabajoAsignado = new JButton("Trabajo asignado");
		imgLogoTaller = new ImageIcon("assets/logoTaller.png");
		lblFotoSur = new JLabel(imgLogoTaller);
		lblCerrarSesion.addMouseListener(this);
		btnAltaVeh.addActionListener(this);
		btnHistorialTaller.addActionListener(this);
		btnVerVehiculosTaller.addActionListener(this);
		btnAsignarTrabajo.addActionListener(this);
		btnTrabajoAsignado.addActionListener(this);
		
		icono1 = new ImageIcon("assets/MecanicoAltaVehiculo.png");
		icono2 = new ImageIcon("assets/MecanicoBuscarVehiculo.png");
		icono3 = new ImageIcon("assets/MecanicoAsignarTrabajo.png");
		icono4 = new ImageIcon("assets/MecanicoConsultarHistorial.png");
		icono5 = new ImageIcon("assets/MecanicoConsultarTrabajo.png");
		
		lblicono1 = new JLabel(icono1);
		lblicono2 = new JLabel(icono2);
		lblicono3 = new JLabel(icono3);
		lblicono4 = new JLabel(icono4);
		lblicono5 = new JLabel(icono5);
		
		//Borramos los cuadros cuando se focaliza en un botón
		btnAltaVeh.setFocusPainted(false);
		btnHistorialTaller.setFocusPainted(false);
		btnVerVehiculosTaller.setFocusPainted(false);
		btnAsignarTrabajo.setFocusPainted(false);
		btnTrabajoAsignado.setFocusPainted(false);

	}
	
	
	
	/**
	 * Metodo para poner a los paneles y label los layout que necesitan
	 */
	private void ponerLayoutsComponentes() {
		
		panelUsuario.setLayout(null);
		panelBotones.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
	}
	/**
	 * Método interno para dar color a los componenetes (botones, lineas, labels, panels...)
	 */
	private void darColorComponentes() {
		
		panelDepartamento.setBackground(new java.awt.Color(233, 196, 106));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario.setBackground(new java.awt.Color(233, 196, 106));
		panelBotones.setBackground(new java.awt.Color(233, 196, 106));
		jefe = miUser.isMecanicoJefe();
		if(jefe == true) {
			btnAltaVeh.setBackground(new java.awt.Color(38, 70, 83));
			btnAsignarTrabajo.setBackground(new java.awt.Color(38, 70, 83));
		} else if (jefe == false) {
			btnAltaVeh.setBackground(Color.GRAY);
			btnAsignarTrabajo.setBackground(Color.GRAY);
		}
		btnHistorialTaller.setBackground(new java.awt.Color(38, 70, 83));
		btnVerVehiculosTaller.setBackground(new java.awt.Color(38, 70, 83));
		btnTrabajoAsignado.setBackground(new java.awt.Color(38, 70, 83));
	}
	/**
	 * Método para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		
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
		btnAsignarTrabajo.setBounds(32, 112, 270, 80);
		lblFotoSur.setBounds(10, 323, 774, 162);
		lblicono1.setBounds(312, 27, 75, 75);
		lblicono3.setBounds(312, 113, 75, 75);
		lblicono2.setBounds(405, 27, 75, 75);
		lblicono4.setBounds(405, 113, 75, 75);
		lblicono5.setBounds(405, 203, 75, 75);
	}
	/**
	 * Método para darle la fuentes a las letras de los componentes
	 */
	private void addPropiedadesLetras() {
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnAltaVeh.setForeground(Color.BLACK);
		btnAltaVeh.setForeground(Color.WHITE);
		btnHistorialTaller.setForeground(Color.WHITE);
		btnVerVehiculosTaller.setForeground(Color.WHITE);
		btnAsignarTrabajo.setForeground(Color.WHITE);
		btnAltaVeh.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnHistorialTaller.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnVerVehiculosTaller.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnAsignarTrabajo.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnTrabajoAsignado.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnTrabajoAsignado.setForeground(Color.WHITE);
	}
	
	
}
