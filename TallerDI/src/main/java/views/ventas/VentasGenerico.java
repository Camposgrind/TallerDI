package views.ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Usuario;
import views.LoginV;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VentasGenerico extends JFrame implements ActionListener, MouseListener{
	
	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelBotones;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblFotoSur;
	protected JButton btnAltaCl,btnBuscarVehiculos,btnBuscarClientes,btnPropuestaDeVenta,btnBuscarPropuesta,btnAltaCoche;
	
	/**
	 * Create the application.
	 */
	public VentasGenerico(Usuario miUsuario) {
		miUser = miUsuario;
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon imgLogoVentas,imgUsu;
		
		//iniciamos y damos las propiedades al frame 
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color( 244, 162, 97));
		getContentPane().setLayout(null);
		
		//Iniciamos todos los componentes 
		panelDepartamento = new JPanel();
		panelBotones = new JPanel();
		panelUsuario = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		imgUsu = new ImageIcon("user-icon.png");
		lblCerrarSesion = new JLabel("Cerrar sesion");
		lblFotoUsu = new JLabel(imgUsu);
		btnAltaCl = new JButton("Alta de clientes");
		btnBuscarVehiculos = new JButton("Buscar vehículos");
		btnBuscarClientes = new JButton("Buscar clientes");
		btnPropuestaDeVenta = new JButton("Propuesta de venta");
		btnBuscarPropuesta = new JButton("Buscar propuesta de venta");
		btnAltaCoche = new JButton("Alta vehículo");
		imgLogoVentas = new ImageIcon("iconoVentas.png");
		lblFotoSur = new JLabel(imgLogoVentas);
		lblCerrarSesion.addMouseListener(this);
		btnAltaCl.addActionListener(this);
		btnBuscarVehiculos.addActionListener(this);
		btnBuscarClientes.addActionListener(this);
		btnPropuestaDeVenta.addActionListener(this);
		btnBuscarPropuesta.addActionListener(this);
		btnAltaCoche.addActionListener(this);

		//Ponemos sus layouts
		panelDepartamento.setLayout(new BorderLayout(0, 0));
		panelUsuario.setLayout(null);
		panelBotones.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelBotones.setBackground(new java.awt.Color( 244, 162, 97));
		btnAltaCl.setBackground(new java.awt.Color(38, 70, 83));
		btnBuscarVehiculos.setBackground(new java.awt.Color(38, 70, 83));
		btnBuscarClientes.setBackground(new java.awt.Color(38, 70, 83));
		btnPropuestaDeVenta.setBackground(new java.awt.Color(38, 70, 83));
		btnBuscarPropuesta.setBackground(new java.awt.Color(38, 70, 83));
		btnAltaCoche.setBackground(new java.awt.Color(38, 70, 83));
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelBotones.setBounds(-2, 76, 786, 485);
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		btnAltaCl.setBounds(94, 61, 208, 41);
		btnBuscarVehiculos.setBounds(490, 151, 208, 41);
		btnBuscarClientes.setBounds(490, 61, 208, 41);
		btnPropuestaDeVenta.setBounds(94, 242, 208, 41);
		btnAltaCoche.setBounds(94, 151, 208, 41);
		btnBuscarPropuesta.setBounds(490, 242, 208, 41);
		lblFotoSur.setBounds(256, 294, 276, 162);
		
		//Damos el tamaño, fuente y color a las letras 
		lblDepartamento.setForeground(new java.awt.Color(38, 70, 83));
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(new java.awt.Color(38, 70, 83));
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(new java.awt.Color(38, 70, 83));
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnAltaCl.setForeground(Color.WHITE);
		btnAltaCl.setForeground(Color.WHITE);
		btnBuscarVehiculos.setForeground(Color.WHITE);
		btnBuscarClientes.setForeground(Color.WHITE);
		btnPropuestaDeVenta.setForeground(Color.WHITE);
		btnBuscarPropuesta.setForeground(Color.WHITE);
		btnAltaCl.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnBuscarVehiculos.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnBuscarClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnPropuestaDeVenta.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnBuscarPropuesta.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnAltaCoche.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnAltaCoche.setForeground(Color.WHITE);
		//Añadimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelBotones);
		//Añadimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);
		//Añadimos los botones y el label de la fto al panel principal 
		panelBotones.add(btnAltaCl);
		panelBotones.add(btnBuscarVehiculos);
		panelBotones.add(btnBuscarClientes);
		panelBotones.add(btnPropuestaDeVenta);
		panelBotones.add(btnBuscarPropuesta);
		panelBotones.add(btnAltaCoche);
		panelBotones.add(lblFotoSur);
					
		this.setVisible(true);
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasAddCliente ventanaAddCliente;
		VentasBuscarCliente ventanaBuscarCliente;
		VentasBuscarVehiculo ventanaBuscarVehiculo;
		VentasAltaVehiculo ventanaAltaVehiculo;
		VentasPropuestaVenta ventanaRealizarPropuesta;
		VentasBuscarPropuesta ventanaBuscarPropuesta;
		
		String txtBtn = e.getActionCommand();
		
		switch (txtBtn) {
		case "Alta de clientes":
			this.setVisible(false);
			this.dispose();
			ventanaAddCliente = new VentasAddCliente(miUser);
			break;
		case "Buscar vehículos":
			this.setVisible(false);
			this.dispose();
			ventanaBuscarVehiculo = new VentasBuscarVehiculo(miUser,null);
			break;
		case "Buscar clientes":
			this.setVisible(false);
			this.dispose();
			ventanaBuscarCliente = new VentasBuscarCliente(miUser,null);
			break;
		case "Propuesta de venta":
			this.setVisible(false);
			this.dispose();
			ventanaRealizarPropuesta = new VentasPropuestaVenta(miUser,null,null);
			
			break;
		case "Buscar propuesta de venta":
			this.setVisible(false);
			this.dispose();
			ventanaBuscarPropuesta = new VentasBuscarPropuesta(miUser);
			
			break;
			
		case "Alta vehículo":
			this.setVisible(false);
			this.dispose();	
			ventanaAltaVehiculo = new VentasAltaVehiculo(miUser);
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
