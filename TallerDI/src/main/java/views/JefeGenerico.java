package views;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.Usuario;

public class JefeGenerico extends JFrame implements ActionListener, MouseListener{
	
	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelBotones;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblFotoSur;
	protected JButton btnAltaUsuario,btnResumenVentas,btnVehiculosSinVender;
	
	/**
	 * Create the application.
	 */
	public JefeGenerico(Usuario miUsuario) {
		miUser = miUsuario;
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//iniciamos y damos las propiedades al frame 
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color( 244, 162, 97));
		getContentPane().setLayout(null);
		
		this.iniciarComponentes();
		//Ponemos sus layouts
		this.ponerLayoutsComponentes();
		
		//Damos color a los paneles, botones y lineas 
		this.darColorComponentes();
		//Damos el tama�o a los componentes que est�n en absoluto
		this.colocarComponentes();
		
		//Damos el tama�o, fuente y color a las letras 
		this.addPropiedadesLetras();
		
		//A�adimos los componentes al panel principal los paneles	
		this.addComponentes();
					
		this.setVisible(true);
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		JefeAddUsuario ventanaAddUser;
		JefeVerVentas ventanaVentasTotales;
		JefeStockVehiculos ventanaStock;
		
		String txtBtn = e.getActionCommand();
		
		switch (txtBtn) {
		case "Alta de empleado":
			this.setVisible(false);
			this.dispose();
			ventanaAddUser = new JefeAddUsuario(miUser);
			break;
		case "Resumen de ventas":
			this.setVisible(false);
			this.dispose();
			ventanaVentasTotales = new JefeVerVentas(miUser);
			break;
		case "Stock veh�culos":
			this.setVisible(false);
			this.dispose();
			ventanaStock = new JefeStockVehiculos(miUser);
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
	/**
	 * M�todo interno para iniciar los componentes
	 */
	private void iniciarComponentes() {

		//Iniciamos todos los componentes 
		ImageIcon imgJefe,imgUsu;
		panelDepartamento = new JPanel();
		panelBotones = new JPanel();
		panelUsuario = new JPanel();
		lblDepartamento = new JLabel("JEFE");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		imgUsu = new ImageIcon("user-icon.png");
		lblCerrarSesion = new JLabel("Cerrar sesi�n");
		lblFotoUsu = new JLabel(imgUsu);
		btnAltaUsuario = new JButton("Alta de empleado");
		btnResumenVentas = new JButton("Resumen de ventas");
		btnVehiculosSinVender = new JButton("Stock veh�culos");
		imgJefe = new ImageIcon("logoJefePro.png");
		lblFotoSur = new JLabel(imgJefe);
		lblCerrarSesion.addMouseListener(this);
		btnAltaUsuario.addActionListener(this);
		btnResumenVentas.addActionListener(this);
		btnVehiculosSinVender.addActionListener(this);
		

	}
	/**
	 * Metodo para poner a los paneles y label los layout que necesitan
	 */
	private void ponerLayoutsComponentes() {
		
		panelDepartamento.setLayout(new BorderLayout(0, 0));
		panelUsuario.setLayout(null);
		panelBotones.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
		
	}
	/**
	 * M�todo interno para dar color a los componenetes (botones, lineas, labels, panels...)
	 */
	private void darColorComponentes() {
		
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelBotones.setBackground(new java.awt.Color( 244, 162, 97));
		btnAltaUsuario.setBackground(new java.awt.Color(38, 70, 83));
		btnResumenVentas.setBackground(new java.awt.Color(38, 70, 83));
		btnVehiculosSinVender.setBackground(new java.awt.Color(38, 70, 83));
	}
	/**
	 * M�todo para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelBotones.setBounds(-2, 76, 786, 485);
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		btnAltaUsuario.setBounds(94, 61, 226, 52);
		btnResumenVentas.setBounds(445, 61, 226, 52);
		btnVehiculosSinVender.setBounds(282, 220, 226, 52);
		lblFotoSur.setBounds(249, 294, 276, 162);
	}
	/**
	 * M�todo para darle la fuentes a las letras de los componentes
	 */
	private void addPropiedadesLetras() {
		
		lblDepartamento.setForeground(new java.awt.Color(38, 70, 83));
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(new java.awt.Color(38, 70, 83));
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(new java.awt.Color(38, 70, 83));
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnAltaUsuario.setForeground(Color.WHITE);
		btnAltaUsuario.setForeground(Color.WHITE);
		btnResumenVentas.setForeground(Color.WHITE);
		btnVehiculosSinVender.setForeground(Color.WHITE);
		btnAltaUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		btnResumenVentas.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		btnVehiculosSinVender.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
	}
	/**
	 * M�todo para a�adir todos los componentes al panel principal 
	 */
	private void addComponentes() {
		
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelBotones);
		//A�adimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);
		//A�adimos los botones y el label de la fto al panel principal 
		panelBotones.add(btnAltaUsuario);
		panelBotones.add(btnResumenVentas);
		panelBotones.add(btnVehiculosSinVender);
		panelBotones.add(lblFotoSur);
	} 

}
