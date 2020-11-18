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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.ClienteDAO;
import models.Cliente;
import models.Usuario;

@SuppressWarnings("serial")
public class VentasFichaCliente extends JFrame implements MouseListener,ActionListener{

	protected Cliente miCliente;
	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblFichaClientes;
	protected JButton btnVolver,btnModificar,btnPropuestaVenta;
	protected JLabel lblNombre;
	protected JLabel lblApellidos;
	protected JLabel lblTelefono;
	protected JLabel lblDni;
	protected JLabel infoNombre;
	protected JLabel infoApellidos;
	protected JLabel infoTelefono;
	protected JLabel infoDni;
	protected ClienteDAO miClienteDao;
	protected VentasListadoClientes ventasListadoClientes;
	protected VentasPropuestaVenta ventanaPropuestas;
	
	/**
	 * Constructor de la vista 
	 * @param miUsuario
	 * @param miCliente
	 * @param ventasListadoClientes
	 */
	public  VentasFichaCliente(Usuario miUsuario,Cliente miCliente, VentasListadoClientes ventasListadoClientes,
			VentasPropuestaVenta miVentanaPropuesta) {
		this.ventasListadoClientes = ventasListadoClientes;
		ventanaPropuestas = miVentanaPropuesta;
		this.miCliente = miCliente;
		miClienteDao = new ClienteDAO();
		miUser = miUsuario;
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		ImageIcon imgUsu;

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
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesion");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblFichaClientes = new JLabel("Ficha cliente");
		lblNombre = new JLabel("Nombre: ");
		lblApellidos = new JLabel("Apellidos:");
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblDni = new JLabel("DNI:");
		infoNombre = new JLabel(miCliente.getNombre());
		infoApellidos = new JLabel(miCliente.getApellidos());
		infoTelefono = new JLabel(miCliente.getTelefono());
		infoDni = new JLabel(miCliente.getDni());		
		btnVolver = new JButton("Volver");
		btnModificar = new JButton("Modificar");
		btnPropuestaVenta = new JButton("Propuesta de venta");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnModificar.addActionListener(this);
		btnPropuestaVenta.addActionListener(this);
		//Ponemos sus layouts
		panelDepartamento.setLayout(new BorderLayout(0, 0));
		panelUsuario.setLayout(null);
		panelContenido.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelContenido.setBackground(new java.awt.Color( 244, 162, 97));
		panelInfo.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelInfo.setBackground(new java.awt.Color( 244, 162, 97));
		btnVolver.setBackground(new java.awt.Color(119, 14, 38));
		btnModificar.setBackground(new java.awt.Color(0,92,48));
		btnPropuestaVenta.setBackground(new Color(82, 21, 255));
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(-2, 76, 786, 485);
		panelInfo.setBounds(281, 0, 228, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		lblNombre.setBounds(236, 97, 106, 30);
		lblApellidos.setBounds(236, 160, 99, 30);
		lblTelefono.setBounds(236, 229, 99, 30);
		lblDni.setBounds(236, 295, 106, 30);
		infoNombre.setBounds(376, 100, 222, 27);
		infoApellidos.setBounds(376, 165, 222, 27);
		infoTelefono.setBounds(376, 234, 222, 27);
		infoDni.setBounds(376, 295, 222, 27);
		btnVolver.setBounds(93, 391, 117, 35);
		btnModificar.setBounds(295, 391, 117, 35);
		btnPropuestaVenta.setBounds(492, 391, 202, 35);
		
		//Damos el tamaño, fuente y color a las letras 
		lblDepartamento.setForeground(new java.awt.Color(38, 70, 83));
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(new java.awt.Color(38, 70, 83));
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(new java.awt.Color(38, 70, 83));
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblFichaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblFichaClientes.setForeground(new java.awt.Color(38, 70, 83));
		lblNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTelefono.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblDni.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		infoNombre.setFont(new Font("DejaVu Sans", Font.ITALIC, 19));
		infoApellidos.setFont(new Font("DejaVu Sans", Font.ITALIC, 19));
		infoTelefono.setFont(new Font("DejaVu Sans", Font.ITALIC, 19));
		infoDni.setFont(new Font("DejaVu Sans", Font.ITALIC, 19));
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnModificar.setForeground(Color.WHITE);
		btnPropuestaVenta.setForeground(Color.WHITE);
		btnPropuestaVenta.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		
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
		panelInfo.add(lblFichaClientes);		
		panelContenido.add(lblNombre);		
		panelContenido.add(lblApellidos);		
		panelContenido.add(lblTelefono);		
		panelContenido.add(lblDni);		
		panelContenido.add(infoNombre);		
		panelContenido.add(infoApellidos);		
		panelContenido.add(infoTelefono);		
		panelContenido.add(infoDni);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnModificar);		
		panelContenido.add(btnPropuestaVenta);
							
		this.setVisible(true);
	}
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasBuscarCliente ventanaBuscarCliente;
		ArrayList<Cliente> miListaClientes;
		String txtBtn = e.getActionCommand();
		VentasFichaCliente ventanaFicha;
		VentasModificarCliente ventanaModificar;
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			if(ventasListadoClientes==null) {
				
				ventanaBuscarCliente = new VentasBuscarCliente(miUser,ventanaPropuestas);
			}else {
				ventasListadoClientes.setVisible(true);
			}

			break;
			
		case "Modificar":			
			this.setVisible(false);
			this.dispose();
			ventanaModificar = new VentasModificarCliente(miUser, miCliente,ventanaPropuestas);
			//Aquí habría que meter una ventana de buscar cliente pero con los texfield ya puestos con la info 
			break;
			
		case "Propuesta de venta":
			this.setVisible(false);
			this.dispose();
			if(ventanaPropuestas!=null) {
				ventanaPropuestas.setCliente(miCliente);				
			}else {
				ventanaPropuestas = new VentasPropuestaVenta(miUser, null, miCliente);
			}
			ventanaPropuestas.setTextFieldCliente();
			ventanaPropuestas.setVisible(true);
			
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
