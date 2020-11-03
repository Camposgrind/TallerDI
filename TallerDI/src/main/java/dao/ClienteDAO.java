package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Cliente;


public class ClienteDAO extends AbstractDAO{

	//ESTADO
	Statement st;
	ResultSet rs;
	Cliente miCliente;
	
	/**
	 * Constructor
	 */
	public ClienteDAO() {
		super();
		miCliente = new Cliente();
		st = null;
		rs=null;
	}
	/**
	 * M�todo para a�adir un cliente a la BBDD
	 * @param miNombre nombre que pone en el textfield
	 * @param miApellido apellidos que ponen en el textfield
	 * @param miTlfn tel�fono que pone en el textfield
	 * @param miDni dni que pone en el textfield 
	 */
	public void addCliente(String miNombre,String miApellido, String miTlfn, String miDni) {
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = super.con.prepareStatement("insert into cliente"
					+ "(nombre,apellidos,telefono,dni) values(?,?,?,?)");
			
			preparedStmt.setString(1,miNombre);
			preparedStmt.setString(2, miApellido);
			preparedStmt.setString(3, miTlfn);
			preparedStmt.setString(4, miDni);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * M�todo para buscar un cliente, seg�n los campos que rellenemos hara una consulta u otra 
	 * @param miNombre texto del textfield del nombre
	 * @param miApellido texto del textfield del apellido
	 * @param miTlfn texto del textfield del telefono 
	 * @param miDni texto del textfield del dni
	 * @return una lista de clientes 
	 */
	public ArrayList<Cliente> buscarCliente(
			String miNombre,String miApellido, String miTlfn, String miDni) {
		
		ArrayList<Cliente> miListaClientes=null;
		Cliente miCliente;
		PreparedStatement preparedStmt;
		try {
			 String query = "SELECT *  FROM Cliente where "
			 		+ "nombre like ? and apellidos like ? and telefono like ? and dni like ?";
			 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 preparedStmt.setString(1, "%"+ miNombre + "%" );
			 preparedStmt.setString(2, "%"+ miApellido + "%");
			 preparedStmt.setString(3, "%"+ miTlfn + "%" );
			 preparedStmt.setString(4, "%"+ miDni + "%" );
	            rs = preparedStmt.executeQuery();
										
			miListaClientes= new ArrayList<Cliente>();
			//mientras el resultset tenga filas crear� clientes, les setea el estado y lo a�ade a la lista 
			while(rs.next()) {
				miCliente = new Cliente();
				miCliente.setIdCliente(rs.getInt(1));
				miCliente.setNombre(rs.getString(2));
				miCliente.setApellidos(rs.getString(3));
				miCliente.setTelefono(rs.getString(4));
				miCliente.setDni(rs.getString(5));
				miListaClientes.add(miCliente);			
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return miListaClientes;
	}
}
