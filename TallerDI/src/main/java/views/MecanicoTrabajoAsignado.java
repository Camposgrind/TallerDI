package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import dao.ReparacionDAO;
import models.Reparacion;
import models.Usuario;

import javax.swing.border.LineBorder;
import javax.swing.Icon;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class MecanicoTrabajoAsignado extends JFrame implements MouseListener,ActionListener{

	protected Usuario miUser;
	protected JPanel panelDepartamento,panelUsuario,panelContenido,panelInfo;
	protected JLabel lblDepartamento,lblUsuario,lblFotoUsu,lblCerrarSesion,lblAltaClientes,lblFotoSur;
	protected JButton btnVolver,btnRegistrar;
	protected ReparacionDAO miReparacionDao;
	protected ArrayList<Reparacion> listaReparaciones;
	private JTable table;
	protected String info[][];
	/**
	 * Create the application.
	 */
	public MecanicoTrabajoAsignado(Usuario miUsuario) {
		setTitle("piCARso - Taller");
		miReparacionDao = new ReparacionDAO();
		miUser = miUsuario;
		listaReparaciones = miReparacionDao.buscarReparacionesEmpleado(miUser.getIdUsuario());
		getContentPane().setForeground(Color.BLACK);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		//iniciamos y damos las propiedades al frame 
		this.setBounds(100, 100, 810, 610);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBackground(new java.awt.Color( 244, 162, 97));
		getContentPane().setLayout(null);

		//Iniciamos todos los componentes 
		this.iniciarComponentes();
		
		//propiedades a los layouts
		this.ponerLayoutsComponentes();
		
		//Damos color a los paneles, botones y lineas 
		this.darColorComponentes();
		
		//Damos el tamaño a los componentes que están en absoluto
		this.colocarComponentes();
		
		//Damos el tamaño, fuente y color a las letras 
		this.addPropiedadesLetras();
		
		//Añadimos los componentes al panel principal los paneles	
		this.addComponentes();
		
		
		this.rellenarTabla();
		
					
		this.setVisible(true);
		
		if(listaReparaciones.size()==0) {
			JOptionPane.showMessageDialog(this, "Enhorabuena, no tienes que hacer ningun trabajo, ponte a limpiar");
		}
	}
	

	/**
	 * Método para cuando se pulse algún botón
	 */
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		MecanicoGenerico ventanaMecanicoG;

			this.setVisible(false);
			this.dispose();
			ventanaMecanicoG = new MecanicoGenerico(miUser);			
		
	}
	/**
	 * Método para que cuando se pulse el ratón en el label que lo tenga agenciado
	 * en este caso el de cerrar sesión, se cierre la sesión
	 */
	@SuppressWarnings("unused")
	@Override
	public void mouseClicked(MouseEvent e) {
		MecanicoFichaReparacion ventanaFichaReparacion;
		Component txtBtn = e.getComponent();
		LoginV loginCerrarSesion;
		
		if(txtBtn==lblCerrarSesion) {
			this.setVisible(false);
			this.dispose();
			miUser = null;
			loginCerrarSesion = new LoginV();
			
		}else {
			 //obtener la fila
	        int row = table.getSelectedRow();
	        //obtener la columna
	        int i = table.getSelectedColumn();
			table.getValueAt(row, i);
			this.setVisible(false);
			//Aquí debería inicarse una Ficha de reparación 
			ventanaFichaReparacion = new MecanicoFichaReparacion(miUser, listaReparaciones.get(row),this);
		}

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
		ImageIcon imgUsu;
		panelDepartamento = new JPanel();
		panelContenido = new JPanel();
		panelContenido.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario = new JPanel();
		panelInfo = new JPanel();
		lblDepartamento = new JLabel("TALLER");
		lblDepartamento.setBounds(10, 11, 374, 54);
		lblFotoSur = new JLabel((Icon) null);
		lblUsuario = new JLabel(miUser.getNomUsuario());
		lblCerrarSesion = new JLabel("Cerrar sesión");
		imgUsu = new ImageIcon("user-icon.png");
		lblFotoUsu = new JLabel(imgUsu);
		lblAltaClientes = new JLabel("Trabajo asignado");
		btnVolver = new JButton("Volver");
		btnRegistrar = new JButton("Ampliar");
		lblCerrarSesion.addMouseListener(this);
		btnVolver.addActionListener(this);
		btnRegistrar.addActionListener(this);
	}
	/**
	 * Metodo para poner a los paneles y label los layout que necesitan
	 */
	private void ponerLayoutsComponentes() {
		
		panelUsuario.setLayout(null);
		panelContenido.setLayout(null);
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepartamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoUsu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarSesion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFotoSur.setHorizontalAlignment(SwingConstants.CENTER);
	}
	/**
	 * Método interno para dar color a los componenetes (botones, lineas, labels, panels...)
	 */
	private void darColorComponentes() {
		
		panelDepartamento.setBackground(new java.awt.Color(233, 196, 106));
		panelDepartamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelUsuario.setBorder(new LineBorder(Color.BLACK));
		panelUsuario.setBackground(new java.awt.Color(233, 196, 106));
		panelContenido.setBackground(new java.awt.Color(233, 196, 106));
		panelInfo.setBorder(new LineBorder(null));
		panelInfo.setBackground(new java.awt.Color(233, 196, 106));
		btnVolver.setBackground(new java.awt.Color(231, 111, 81));
		btnRegistrar.setBackground(new java.awt.Color(42, 157, 143));
	}
	/**
	 * Método para darle las propiedades a los componentes(alto, ancho) y su posicion en la pantalla
	 */
	private void colocarComponentes() {
		
		panelUsuario.setBounds(394, 0, 400, 76);
		panelDepartamento.setBounds(0, 0, 394, 76);
		panelContenido.setBounds(0, 76, 794, 495);
		panelInfo.setBounds(0, 0, 794, 41);
		lblFotoSur.setBounds(34, 11, 70, 54);
		lblUsuario.setBounds(183, 11, 123, 24);
		lblCerrarSesion.setBounds(183, 46, 123, 14);
		lblFotoUsu.setBounds(327, 9, 46, 51);
		btnVolver.setBounds(10, 407, 375, 77);
		btnRegistrar.setBounds(409, 407, 375, 77);
	}
	/**
	 * Método para darle la fuentes a las letras de los componentes
	 */
	private void addPropiedadesLetras() {
		
		lblDepartamento.setForeground(Color.BLACK);
		lblDepartamento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
		lblCerrarSesion.setForeground(Color.BLACK);
		lblCerrarSesion.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblAltaClientes.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblAltaClientes.setForeground(Color.BLACK);
		
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnVolver.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnRegistrar.setForeground(Color.WHITE);
	}
	/**
	 * Método para añadir todos los componentes al panel principal 
	 */
	private void addComponentes() {
		getContentPane().add(panelDepartamento);
		getContentPane().add(panelUsuario);
		getContentPane().add(panelContenido);
		panelDepartamento.setLayout(null);
		//Añadimos los labels a los paneles 
		panelDepartamento.add(lblDepartamento);
		

		panelDepartamento.add(lblFotoSur);
		panelUsuario.add(lblUsuario);
		panelUsuario.add(lblFotoUsu);
		panelUsuario.add(lblCerrarSesion);				
		//Añadimos el panel informativo, labels, textfield y botones 
		panelContenido.add(panelInfo);
		panelInfo.add(lblAltaClientes);
			
		panelContenido.add(btnVolver);
		panelContenido.add(btnRegistrar);
	} 
	/**
	 * Método interno para rellnar la tabla 
	 */
	private void rellenarTabla() {
		//Para la tabla 
		//este array bidimensional sera para determinar como es de grande
		//la tabla (filas, columnas)
		info = new String[listaReparaciones.size()][5];
		

		//en esta array ponemos los nombre de las columnas
		String[] nombresColumnas = { "Matrícula", "Trabajo", "Tiempo estimado", "Piezas", "Estado" };
		
		for (int i = 0; i < info.length; i++) {
			info[i][0] = listaReparaciones.get(i).getMatricula() + "";
			info[i][1] = listaReparaciones.get(i).getTrabajo() + "";
			info[i][2] = listaReparaciones.get(i).getTiempoEstimado() + "";
			info[i][3] = listaReparaciones.get(i).getPiezas() + "";
			info[i][4] = listaReparaciones.get(i).getEstado() + "";
		}
		
		table = new JTable(info,nombresColumnas);
		table.setBounds(10, 93, 774, 287);
		table.setCellSelectionEnabled(true);
		
		table.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		//Iniciamos un scrollpane para que meta la tabla dentro 
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setBackground(new java.awt.Color(244, 162, 97));
		scrollPane.setBounds(10, 93, 774, 287);
		//le añadimos un mouse listener para que cuando pinchemos nos salga la ficha
		//del cliente que tocamos 
		table.addMouseListener(this);

		panelContenido.add(scrollPane);
		
	}
}