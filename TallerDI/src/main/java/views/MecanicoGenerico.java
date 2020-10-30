package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import models.Usuario;

public class MecanicoGenerico extends JFrame implements ActionListener{

	private JFrame frame;
	protected Usuario miUser;
	

	/**
	 * Create the application.
	 */
	public MecanicoGenerico(Usuario miUsuario) {
		miUser = miUsuario;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
