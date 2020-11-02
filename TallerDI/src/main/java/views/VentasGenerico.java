package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Usuario;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;

public class VentasGenerico extends JFrame implements ActionListener, MouseListener{
	
	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelBotones;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblFotoSur;
	protected JButton btnAltaCl,btnBuscarVehiculos,btnBuscarClientes,btnPropuestaDeVenta,btnBuscarPropuesta;
	
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
		//iniciamos y damos las propiedades al frame 
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setBackground(new java.awt.Color( 244, 162, 97));
		getContentPane().setLayout(null);
		
		//Iniciamos todos los componentes 
		panelDepartamento = new JPanel();
		panelBotones = new JPanel();
		panelUsuario = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesion");
		lblFotoUsu = new JLabel("fotico");
		btnAltaCl = new JButton("Alta de clientes");
		btnBuscarVehiculos = new JButton("Buscar vehiculos");
		btnBuscarClientes = new JButton("Buscar clientes");
		btnPropuestaDeVenta = new JButton("Propuesta de venta");
		btnBuscarPropuesta = new JButton("Buscar propuesta de venta");
		lblFotoSur = new JLabel("fotico");
		lblCerrarSesion.addMouseListener(this);
		btnAltaCl.addActionListener(this);
		btnBuscarVehiculos.addActionListener(this);
		btnBuscarClientes.addActionListener(this);
		btnPropuestaDeVenta.addActionListener(this);
		btnBuscarPropuesta.addActionListener(this);
		

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
		
		//Damos el tama�o a los componentes que est�n en absoluto
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelBotones.setBounds(-2, 76, 786, 485);
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		btnAltaCl.setBounds(115, 61, 187, 41);
		btnBuscarVehiculos.setBounds(490, 61, 187, 41);
		btnBuscarClientes.setBounds(115, 151, 187, 41);
		btnPropuestaDeVenta.setBounds(490, 151, 187, 41);
		btnBuscarPropuesta.setBounds(302, 242, 187, 41);
		lblFotoSur.setBounds(350, 326, 61, 73);
		
		//Damos el tama�o, fuente y color a las letras 
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
		
		//A�adimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelBotones);
		//A�adimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);
		//A�adimos los botones y el label de la fto al panel principal 
		panelBotones.add(btnAltaCl);
		panelBotones.add(btnBuscarVehiculos);
		panelBotones.add(btnBuscarClientes);
		panelBotones.add(btnPropuestaDeVenta);
		panelBotones.add(btnBuscarPropuesta);
		panelBotones.add(lblFotoSur);
					
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VentasAddCliente ventanaAddCliente;
		VentasBuscarCliente ventanaBuscarCliente;
		
		String txtBtn = e.getActionCommand();
		
		switch (txtBtn) {
		case "Alta de clientes":
			this.setVisible(false);
			this.dispose();
			ventanaAddCliente = new VentasAddCliente(miUser);
			break;
		case "Buscar vehiculos":
			
			break;
		case "Buscar clientes":
			this.setVisible(false);
			this.dispose();
			ventanaBuscarCliente = new VentasBuscarCliente(miUser);
			break;
		case "Propuesta de venta":
			
			break;
		case "Buscar propuesta de venta":
			
			break;

		}
		
	}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
