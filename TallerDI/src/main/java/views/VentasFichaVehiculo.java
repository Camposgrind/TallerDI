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

import dao.VehiculoDAO;
import models.Usuario;
import models.Vehiculo;

@SuppressWarnings("serial")
public class VentasFichaVehiculo extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes;
	protected JButton btnVolver,btnModificar,btnPropuesta;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JLabel lblTipo,lblAddOk;
	protected JLabel lblFechaEntrada;
	protected JLabel lblPrecio,lblColor,lblConcesionario;
	protected JLabel tFMatricula;
	protected JLabel tFMarca;
	protected JLabel tFModelo;
	protected JLabel tFTipo,tfFechaEntrada,tFPrecio,tFColor,tFConcesionario;
	protected VehiculoDAO miVehiculoDao;
	protected Vehiculo miVehiculo;
	protected String provincia;
	protected String nombreConcesionario;
	/**
	 * Create the application.
	 */
	public VentasFichaVehiculo(Usuario miUsuario,Vehiculo miVehiculo,String miProvincia,String miNombreConcesionario) {
		miVehiculoDao = new VehiculoDAO();
		provincia = miProvincia;
		this.miVehiculo= miVehiculo;
		nombreConcesionario = miNombreConcesionario;
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
		lblAltaClientes = new JLabel("Buscar coches");
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblTipo = new JLabel("Tipo:");
		lblFechaEntrada = new JLabel("Fecha Entrada:");
		lblPrecio =  new JLabel("Precio:");
		lblColor = new JLabel("Color:");
		lblConcesionario = new JLabel("Concesionario:");	
		tFMatricula = new JLabel(miVehiculo.getMatricula());
		tFMarca = new JLabel(miVehiculo.getMarca());
		tFModelo = new JLabel(miVehiculo.getModelo());
		tFTipo = new JLabel(miVehiculo.getTipo());	
		tfFechaEntrada = new JLabel(miVehiculo.getFechaEntrada().toString());
		
		tFPrecio = new JLabel(miVehiculo.getPrecio()+"");
		tFColor = new JLabel(miVehiculo.getColor());
		tFConcesionario = new JLabel(nombreConcesionario+" ("+provincia+")");
		btnVolver = new JButton("Volver");
		btnModificar = new JButton("Modificar");
		btnPropuesta = new JButton("Propuesta de venta");
		lblAddOk = new JLabel("VEH�CULO NO ENCONTRADO");
		lblAddOk.setVisible(false);
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnModificar.addActionListener(this);

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
		lblAddOk.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		btnPropuesta.setBackground(new Color(82, 21, 255));
		lblAddOk.setBackground(new java.awt.Color(0,92,48));
		
		//Damos el tama�o a los componentes que est�n en absoluto
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(0, 76, 786, 485);
		panelInfo.setBounds(281, 0, 228, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		lblMatricula.setBounds(200, 74, 142, 30);
		lblMarca.setBounds(200, 115, 135, 30);
		lblModelo.setBounds(200, 156, 135, 30);
		lblTipo.setBounds(200, 197, 142, 30);

		lblPrecio.setBounds(200, 238, 142, 30); 
		lblColor.setBounds(200, 279, 142, 30); 
		lblFechaEntrada.setBounds(200, 320, 142, 30);
		lblConcesionario.setBounds(200, 361, 142, 30); 	
		tFMatricula.setBounds(376, 76, 222, 27);
		tFMarca.setBounds(376, 117, 222, 27);
		tFModelo.setBounds(376, 158, 222, 27);
		tFTipo.setBounds(376, 199, 222, 27);

		tFPrecio.setBounds(376, 240, 222, 27);
		tFColor.setBounds(376, 281, 222, 27);
		tfFechaEntrada.setBounds(376, 322, 222, 27);
		tFConcesionario.setBounds(376, 363, 299, 27);
		btnVolver.setBounds(94, 424, 117, 35);
		btnModificar.setBounds(295, 424, 117, 35);
		btnPropuesta.setBounds(490, 424, 202, 35);
		lblAddOk.setBounds(258, 40, 276, 41);
		
		//Damos el tama�o, fuente y color a las letras 
		lblDepartamento.setForeground(new java.awt.Color(38, 70, 83));
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(new java.awt.Color(38, 70, 83));
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(new java.awt.Color(38, 70, 83));
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaClientes.setForeground(new java.awt.Color(38, 70, 83));
		lblMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblTipo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblFechaEntrada.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblPrecio.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblColor.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblConcesionario.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 			
		tFMatricula.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));		
		tFMarca.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));				
		tFModelo.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));		
		tFTipo.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		
		tfFechaEntrada.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFPrecio.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFColor.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		tFConcesionario.setFont(new Font("DejaVu Sans", Font.BOLD | Font.ITALIC, 19));
		
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnModificar.setForeground(Color.WHITE);
		btnPropuesta.setForeground(Color.WHITE);
		btnPropuesta.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		lblAddOk.setForeground(Color.BLACK);
		lblAddOk.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		
		//A�adimos los componentes al panel principal los paneles	
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		//A�adimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);				
		//A�adimos el panel informativo, labels, textfield y botones 
		panelContenido.add(panelInfo);
		panelInfo.add(lblAltaClientes);		
		panelContenido.add(lblMatricula);		
		panelContenido.add(lblMarca);		
		panelContenido.add(lblModelo);		
		panelContenido.add(lblTipo);
		panelContenido.add(lblFechaEntrada);
		panelContenido.add(lblPrecio);
		panelContenido.add(lblColor);
		panelContenido.add(lblConcesionario);
		
		panelContenido.add(tFMatricula);		
		panelContenido.add(tFMarca);		
		panelContenido.add(tFModelo);		
		panelContenido.add(tFTipo);
		panelContenido.add(tfFechaEntrada);		
		panelContenido.add(tFPrecio);		
		panelContenido.add(tFColor);		
		panelContenido.add(tFConcesionario);
		
		panelContenido.add(btnVolver);
		panelContenido.add(btnModificar);
		panelContenido.add(btnPropuesta);
		panelContenido.add(lblAddOk);
					
		this.setVisible(true);
	}
	/**
	 * M�todo para cuando se pulse alg�n bot�n
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		VentasBuscarVehiculo ventanaBuscarVehiculo;
		ArrayList<Vehiculo> miListaVehiculos;
		String txtBtn = e.getActionCommand();
		VentasFichaCliente ventanaFicha;
		VentasListadoClientes ventanaListaClientes;
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaBuscarVehiculo = new VentasBuscarVehiculo(miUser);
			break;
			
		case "Modificar":
			
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

}