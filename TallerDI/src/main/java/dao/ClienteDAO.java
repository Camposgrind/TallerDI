package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Cliente;


public class ClienteDAO extends AbstractDAO{

	//ESTADO
	protected Statement st;
	protected ResultSet rs;
	protected Cliente miCliente;
	
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
	 * Método para añadir un cliente a la BBDD
	 * @param miNombre nombre que pone en el textfield
	 * @param miApellido apellidos que ponen en el textfield
	 * @param miTlfn teléfono que pone en el textfield
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
			e.printStackTrace();
		}
	}
	/**
	 * Método para buscar un cliente, según los campos que rellenemos hara una consulta u otra 
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
			//mientras el resultset tenga filas creará clientes, les setea el estado y lo añade a la lista 
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
	/**
	 * Método para modificar un cliente mediante los texfield de la vista 
	 * @param miNombre es el nombre que se le va a poner nuevo en la bbdd 
	 * @param miApellido el apellido nuevo que se le va a poner en la bbdd
	 * @param miTlfn el telefono nuevo que se le va a poner en la bbdd
	 * @param miDni el dni nuevo que se le va a poner a la bbdd
	 * @param miCliente el cliente que vamos a modificar con los setter despues de modificarlo en el bbdd
	 * @return
	 */
	public Cliente modificarCliente(String miNombre, String miApellido, String miTlfn, String miDni,Cliente miCliente) {
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = super.con.prepareStatement("update cliente "
					+ "set Nombre = ?,Apellidos = ?, Telefono = ? ,DNI = ? where idCliente = ?");
			
			preparedStmt.setString(1,miNombre);
			preparedStmt.setString(2, miApellido);
			preparedStmt.setString(3, miTlfn);
			preparedStmt.setString(4, miDni);			
			//Aquí le decimos que nos de el id cliente que tiene para ponerlo en el where
			preparedStmt.setInt(5, miCliente.getIdCliente());
			preparedStmt.executeUpdate();
			
			//seteamos el estado del cliente en memoria para luego mostrarlo en el vista de la ficha 
			miCliente.setNombre(miNombre);
			miCliente.setApellidos(miApellido);
			miCliente.setTelefono(miTlfn);
			miCliente.setDni(miDni);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return miCliente;
	}
	/**
	 * Método para buscar un cliente según la id que le pasemos
	 * @param miIdCliente
	 * @return cliente
	 */
	public Cliente buscarClienteById(int miIdCliente) {
		
		Cliente miCliente= null;
		PreparedStatement preparedStmt;
		
		try {
			 String query = "SELECT * FROM Cliente where idCliente like ?";
			 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 
			 preparedStmt.setInt(1,miIdCliente);

	            rs = preparedStmt.executeQuery();
										
			//mientras el resultset tenga filas creará clientes, les setea el estado y lo añade a la lista 
			if(rs.next()) {
				miCliente = new Cliente();
				miCliente.setIdCliente(rs.getInt(1));
				miCliente.setNombre(rs.getString(2));
				miCliente.setApellidos(rs.getString(3));
				miCliente.setTelefono(rs.getString(4));
				miCliente.setDni(rs.getString(5));		
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return miCliente;
	}
	
}
