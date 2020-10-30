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
		btnAltaCl.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnBuscarVehiculos = new JButton("Buscar vehiculos");
		btnBuscarVehiculos.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnBuscarClientes = new JButton("Buscar clientes");
		btnBuscarClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnPropuestaDeVenta = new JButton("Propuesta de venta");
		btnPropuestaDeVenta.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btnBuscarPropuesta = new JButton("Buscar propuesta de venta");
		btnBuscarPropuesta.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblFotoSur = new JLabel("fotico");
		lblCerrarSesion.addMouseListener(this);

		//Ponemos sus layouts
		panelDepartamento.setLayout(new BorderLayout(0, 0));
		panelUsuario.setLayout(null);
		panelBotones.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Damos color a los paneles y lineas 
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelBotones.setBackground(new java.awt.Color( 244, 162, 97));
		
		//Damos el tamaño a los componentes que están en absoluto
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
		
		//Damos el tamaño, fuente y color a las letras 
		//lblDepartamento.setForeground(Color.BLUE);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		//lblUsuario.setForeground(Color.BLUE);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		//lblCerrarSesion.setForeground(Color.BLUE);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		
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
		panelBotones.add(lblFotoSur);
					
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String txtBtn = e.getActionCommand();
		
		switch (txtBtn) {
		case "Alta de clientes":
			
			break;
		case "Buscar vehiculos":
			
			break;
		case "Buscar clientes":
			
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
