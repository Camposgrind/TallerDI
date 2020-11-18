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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.PropuestaDAO;
import models.Cliente;
import models.Propuesta;
import models.Usuario;

public class VentasBuscarPropuesta extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblBuscarPropuesta;
	protected JButton btnVolver,btnBuscar;
	protected JLabel lblNombre,lblApellidos;	
	protected JTextField tFNombre,tFApellidos;

	protected PropuestaDAO miPropuestaDao;
	protected JLabel lblMatricula,lblCombustible;
	protected JLabel lblMarca,lblModelo,lblPrecio,lblTipo,lblFecha;
	protected JTextField tFMatricula,tFMarca;
	protected JTextField tFModelo;
	protected JTextField tFPrecio,tFTipo,tFCombustible,tFFecha;
	
	/**
	 * Create the application.
	 */
	public VentasBuscarPropuesta(Usuario miUsuario) {
		miPropuestaDao = new PropuestaDAO();
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
		lblBuscarPropuesta = new JLabel("Buscar propuesta");
		lblNombre = new JLabel("Nombre: ");
		lblApellidos = new JLabel("Apellidos:");
		
		tFNombre = new JTextField();
		tFApellidos = new JTextField();
				
		lblMatricula = new JLabel("Matr\u00EDcula: ");
		lblMarca = new JLabel("Marca:");
		lblModelo = new JLabel("Modelo:");
		lblPrecio =  new JLabel("Precio:");
		lblTipo = new JLabel("Tipo:");
		lblCombustible = new JLabel("Combustible:");
		lblFecha = new JLabel("Fecha propuesta:");
		
		tFMatricula = new JTextField();
		tFMarca = new JTextField();
		tFModelo = new JTextField();
		tFPrecio = new JTextField();
		tFTipo = new JTextField();
		tFCombustible = new JTextField();
		tFFecha = new JTextField();
		
		btnVolver = new JButton("Volver");
		btnBuscar = new JButton("Buscar");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnBuscar.addActionListener(this);
		
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
		
		//Damos color a los paneles, botones y lineas 
		panelDepartamento.setBackground(new java.awt.Color( 244, 162, 97));
		panelDepartamento.setBorder(BorderFactory.createLineBorder(new java.awt.Color(38, 70, 83)));
		panelUsuario.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelUsuario.setBackground(new java.awt.Color( 244, 162, 97));
		panelContenido.setBackground(new java.awt.Color( 244, 162, 97));
		panelInfo.setBorder(BorderFactory.createLineBorder(new java.awt.Color( 38, 70, 83)));
		panelInfo.setBackground(new java.awt.Color( 244, 162, 97));
		btnVolver.setBackground(new java.awt.Color(119, 14, 38));
		btnBuscar.setBackground(new java.awt.Color(0,92,48));
		
		//Damos el tamaño a los componentes que están en absoluto
		panelUsuario.setBounds(393, 0, 393, 76);
		panelDepartamento.setBounds(0, 0, 393, 76);
		panelContenido.setBounds(-2, 76, 786, 485);
		panelInfo.setBounds(281, 0, 228, 41);
		
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		lblNombre.setBounds(23, 155, 99, 30);
		lblApellidos.setBounds(23, 225, 99, 30);
		tFNombre.setBounds(127, 157, 222, 27);
		tFApellidos.setBounds(127, 227, 222, 27);
		
		lblMatricula.setBounds(385, 75, 146, 30);
		lblTipo.setBounds(385, 115, 169, 30);
		lblMarca.setBounds(385, 155, 146, 30);
		lblModelo.setBounds(385, 195, 146, 30);
		lblCombustible.setBounds(385, 235, 158, 30);
		lblPrecio.setBounds(385, 275, 146, 30); 
		lblFecha.setBounds(385, 315, 169, 30);
		tFMatricula.setBounds(554, 75, 202, 27);
		tFTipo.setBounds(554, 115, 202, 27);
		tFMarca.setBounds(554, 155, 202, 27);
		tFModelo.setBounds(554, 195, 202, 27);
		tFCombustible.setBounds(554, 235, 202, 27);
		tFPrecio.setBounds(554, 275, 202, 27);
		tFFecha.setBounds(554, 315, 202, 27);
				
		btnVolver.setBounds(153, 391, 117, 35);
		btnBuscar.setBounds(516, 391, 117, 35);
		
		//Damos el tamaño, fuente y color a las letras 
		lblDepartamento.setForeground(new java.awt.Color(38, 70, 83));
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(new java.awt.Color(38, 70, 83));
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(new java.awt.Color(38, 70, 83));
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblBuscarPropuesta.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblBuscarPropuesta.setForeground(new java.awt.Color(38, 70, 83));
		lblNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFNombre.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFNombre.setColumns(10);
		tFApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFApellidos.setColumns(10);
		tFApellidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		lblMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblPrecio.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblTipo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		lblFecha.setFont(new Font("DejaVu Sans", Font.PLAIN, 19)); 
		tFMatricula.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFMatricula.setColumns(10);
		tFMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFMarca.setColumns(10);
		tFMarca.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFModelo.setColumns(10);
		tFModelo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		lblCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFPrecio.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFTipo.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFCombustible.setColumns(10);
		tFCombustible.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		tFFecha.setColumns(10);
		tFFecha.setFont(new Font("DejaVu Sans", Font.PLAIN, 19));
		
		btnVolver.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnVolver.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("DejaVu Sans", Font.PLAIN, 17));
		btnBuscar.setForeground(Color.WHITE);
		
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
		panelInfo.add(lblBuscarPropuesta);		
		panelContenido.add(lblNombre);		
		panelContenido.add(lblApellidos);		
		panelContenido.add(tFNombre);		
		panelContenido.add(tFApellidos);		

		
		panelContenido.add(lblMatricula);		
		panelContenido.add(lblMarca);		
		panelContenido.add(lblModelo);		
		panelContenido.add(lblPrecio);
		panelContenido.add(lblTipo);
		panelContenido.add(lblCombustible);
		panelContenido.add(lblFecha);
		panelContenido.add(tFMatricula);		
		panelContenido.add(tFMarca);		
		panelContenido.add(tFModelo);		
		panelContenido.add(tFPrecio);		
		panelContenido.add(tFTipo);
		panelContenido.add(tFCombustible);
		panelContenido.add(tFFecha);
		panelContenido.add(btnVolver);
		panelContenido.add(btnBuscar);
					
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
		VentasListadoPropuestas ventanaListaPropo;
		VentasFichaPropuesta ventanaFichaPropuesta;
		String txtBtn = e.getActionCommand();
		boolean todoOk = false;
		ArrayList<Propuesta> listaPropuestas;
		
		switch (txtBtn) {
		case "Volver":
			this.setVisible(false);
			this.dispose();
			ventanaVentasG = new VentasGenerico(miUser);
			break;
			
		case "Buscar":	
			listaPropuestas = miPropuestaDao.buscarPropuestas(tFNombre.getText(), tFApellidos.getText(), tFMatricula.getText(),
					tFTipo.getText(),tFMarca.getText(), tFModelo.getText(),
					tFCombustible.getText(), tFPrecio.getText(), tFFecha.getText());
			
			if(listaPropuestas.size()!=0) {
				this.setVisible(false);
				this.dispose();
				
				if(listaPropuestas.size()>1) {
					ventanaListaPropo = new VentasListadoPropuestas(miUser,listaPropuestas);				
				}else { 
					//ventanaFichaPropuesta = new VentasFichaPropuesta(miUser,listaPropuestas.get(0));
				}				
				
			}else {
				JOptionPane.showMessageDialog(this, "No se ha encontrado ninguna propuesta");
			}
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