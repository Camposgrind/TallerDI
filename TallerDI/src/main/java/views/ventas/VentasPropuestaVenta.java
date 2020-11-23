package views.ventas;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.PropuestaDAO;
import models.Cliente;
import models.Usuario;
import models.Vehiculo;
import views.LoginV;

public class VentasPropuestaVenta extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnBuscar;
	protected JLabel lblNombre,lblApellidos,lblTelefono,lblDni;	
	protected JTextField tFNombre,tFApellidos,tFTelefono,tFDni;

	protected PropuestaDAO miPropuesta;
	protected Cliente miCliente;
	protected Vehiculo miVehiculo;
	protected JLabel lblMatricula,lblCombustible;
	protected JLabel lblMarca,lblModelo,lblPrecio,lblColor;
	protected JTextField tFMatricula,tFMarca;
	protected JTextField tFModelo;
	protected JTextField tFPrecio,tFColor,tFCombustible;
	private JButton btnBuscarVehiculo,btnBuscarCliente;
	
	/**
	 * Create the application.
	 */
	public VentasPropuestaVenta(Usuario miUsuario,Vehiculo miVehiculo,Cliente miCliente) {
		miPropuesta = new PropuestaDAO();
		this.miCliente = miCliente;
		this.miVehiculo = miVehiculo;
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

		//Iniciamos todos los componentes 
		this.iniciarComponentes();
		
		//Ponemos sus layouts
		this.ponerLayoutsComponentes();
		
		//Damos color a los paneles, botones y lineas 
		this.darColorComponentes();
		
		//Damos el tamaño a los componentes que están en absoluto
		this.colocarComponentes();
		
		//Damos el tamaño, fuente y color a las letras 
		this.addPropiedadesLetras();
		
		//Añadimos los componentes al panel principal los paneles	
		this.addComponentes();
					
		this.setVisible(true);
	}
	
	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasGenerico ventanaVentasG;
		VentasBuscarCliente ventanaBuscarCl;
		VentasBuscarVehiculo ventanaBuscarVehi;
		String txtBtn = e.getActionCommand();
		boolean todoOk = false;
		
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaVentasG = new VentasGenerico(miUser);
			break;
			
		case "Buscar cliente":	
			this.setVisible(false);
			ventanaBuscarCl =new VentasBuscarCliente(miUser,this);	
			break;
			
		case "Realizar":	
			todoOk = miPropuesta.addPropuesta(miUser.getIdUsuario(), miCliente.getIdCliente(), 
					miVehiculo.getMatricula(), tFPrecio.getText());
			if(todoOk) {
				JOptionPane.showMessageDialog(this, "Propuesta realizada con éxito");
			}else {
				JOptionPane.showMessageDialog(this, "Ha fallado la proposición");
			}
			break;
			
		case "Buscar vehículo":	
			this.setVisible(false);
			ventanaBuscarVehi =new VentasBuscarVehiculo(miUser,this);	
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
	
	/**
	 * Método para rellenar los campos del cliente cuando lo hayamos buscado
	 */
	public void setTextFieldCliente() {
		tFNombre.setText(miCliente.getNombre());
		tFApellidos.setText(miCliente.getApellidos());
		tFTelefono.setText(miCliente.getTelefono());
		tFDni.setText(miCliente.getDni());
	}
	
	/**
	 * Méotdo para rellenar los campos del vehículo cuando lo hayamos buscado
	 */
	public void setTextFieldVehiculo() {
		tFMatricula.setText(miVehiculo.getMatricula());;
		tFMarca.setText(miVehiculo.getMarca());
		tFModelo.setText(miVehiculo.getModelo());
		tFPrecio.setText(miVehiculo.getPrecio()+"");
		tFColor.setText(miVehiculo.getColor());
		tFCombustible.setText(miVehiculo.getCombustible());
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

	public void setCliente(Cliente c) {
		miCliente=c;
		
	}
	public void setVehiculo(Vehiculo v) {
		miVehiculo = v;
	}
	/**
	 * Método interno para iniciar los componentes
	 */
	private void iniciarComponentes() {
		ImageIcon imgUsu;
		
		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("DEPARTAMENTO DE VENTAS");
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesion");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Propuesta de venta");
		lblNombre = new JLabel("Nombre: ");
		lblApellidos = new JLabel("Apellidos:");
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblDni = new JLabel("DNI:");	
		tFNombre = new JTextField();
		tFApellidos = new JTextField();
		tFTelefono = new JTextField();
		tFDni = new JTextField();			
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblPrecio =  new JLabel("Precio:");
		lblColor = new JLabel("Color:");
		lblCombustible = new JLabel("Combustible:");	
		tFMatricula = new JTextField();
		tFMarca = new JTextField();
		tFModelo = new JTextField();
		tFPrecio = new JTextField();
		tFColor = new JTextField();
		tFCombustible = new JTextField();
		
		btnVolver = new JButton("Volver");
		btnBuscar = new JButton("Realizar");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnBuscarCliente = new JButton("Buscar cliente");
		btnBuscarVehiculo = new JButton("Buscar vehículo");
		btnBuscarCliente.addActionListener(this);
		btnBuscarVehiculo.addActionListener(this);
	}
	/**
	 * Metodo para poner a los paneles y label los layout que necesitan
	 */
	private void ponerLayoutsComponentes() {
		
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
	}
	/**
	 * Método interno para dar color a los componenetes (botones, lineas, labels, panels...)
	 */
	private void darColorComponentes() {
		
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelContenido.setBackground(new java.awt.Color( 244, 162, 97));
		panelInfo.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelInfo.setBackground(new java.awt.Color( 244, 162, 97));
		btnVolver.setBackground(new java.awt.Color(119, 14, 38));
		btnBuscar.setBackground(new java.awt.Color(0,92,48));
		btnBuscarCliente.setBackground(new Color(82, 21, 255));
		btnBuscarVehiculo.setBackground(new Color(82, 21, 255));
		
	}
	/**
	 * Método para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(-2, 76, 786, 485);
		panelInfo.setBounds(281, 0, 228, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		lblNombre.setBounds(34, 98, 106, 30);
		lblApellidos.setBounds(34, 148, 99, 30);
		lblTelefono.setBounds(34, 198, 99, 30);
		lblDni.setBounds(34, 248, 106, 30);
		tFNombre.setBounds(127, 100, 222, 27);
		tFApellidos.setBounds(127, 150, 222, 27);
		tFTelefono.setBounds(127, 200, 222, 27);
		tFDni.setBounds(127, 250, 222, 27);	
		lblMatricula.setBounds(412, 50, 119, 30);
		lblMarca.setBounds(412, 90, 119, 30);
		lblModelo.setBounds(412, 130, 119, 30);
		lblColor.setBounds(412, 170, 142, 30);
		lblCombustible.setBounds(412, 210, 131, 30);
		lblPrecio.setBounds(412, 250, 119, 30);
		tFMatricula.setBounds(554, 50, 202, 27);
		tFMarca.setBounds(554, 90, 202, 27);
		tFModelo.setBounds(554, 130, 202, 27);
		tFColor.setBounds(554, 170, 202, 27);
		tFCombustible.setBounds(554, 210, 202, 27);
		tFPrecio.setBounds(554, 250, 202, 27);
				
		btnVolver.setBounds(153, 391, 117, 35);
		btnBuscar.setBounds(516, 391, 117, 35);
		btnBuscarCliente.setBounds(127, 320, 177, 35);
		btnBuscarVehiculo.setBounds(487, 320, 177, 35);
	}
	/**
	 * Método para darle la fuentes a las letras de los componentes
	 */
	private void addPropiedadesLetras() {
		
		lblDepartamento.setForeground(new java.awt.Color(38, 70, 83));
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(new java.awt.Color(38, 70, 83));
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(new java.awt.Color(38, 70, 83));
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaClientes.setForeground(new java.awt.Color(38, 70, 83));
		lblNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTelefono.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblDni.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFNombre.setColumns(10);
		tFApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFApellidos.setColumns(10);
		tFApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFTelefono.setColumns(10);
		tFTelefono.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFDni.setColumns(10);
		tFDni.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));	
		lblMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblPrecio.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblColor.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 		
		tFMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFMatricula.setColumns(10);
		tFMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFMarca.setColumns(10);
		tFMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFModelo.setColumns(10);
		tFModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFPrecio.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFColor.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFCombustible.setColumns(10);
		tFCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscarCliente.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnBuscarVehiculo.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnBuscarCliente.setForeground(Color.WHITE);
		btnBuscarVehiculo.setForeground(Color.WHITE);
	}
	/**
	 * Método para añadir todos los componentes al panel principal 
	 */
	private void addComponentes() {
		
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
		panelInfo.add(lblAltaClientes);		
		panelContenido.add(lblNombre);		
		panelContenido.add(lblApellidos);		
		panelContenido.add(lblTelefono);		
		panelContenido.add(lblDni);		
		panelContenido.add(tFNombre);		
		panelContenido.add(tFApellidos);		
		panelContenido.add(tFTelefono);		
		panelContenido.add(tFDni);	
		panelContenido.add(lblMatricula);		
		panelContenido.add(lblMarca);		
		panelContenido.add(lblModelo);		
		panelContenido.add(lblPrecio);
		panelContenido.add(lblColor);
		panelContenido.add(lblCombustible);
		panelContenido.add(tFMatricula);		
		panelContenido.add(tFMarca);		
		panelContenido.add(tFModelo);		
		panelContenido.add(tFPrecio);		
		panelContenido.add(tFColor);
		panelContenido.add(tFCombustible);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnBuscar);
		panelContenido.add(btnBuscarCliente);		
		panelContenido.add(btnBuscarVehiculo);
	} 
}
