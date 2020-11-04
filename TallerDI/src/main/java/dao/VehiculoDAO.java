package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Cliente;
import models.Vehiculo;

public class VehiculoDAO extends AbstractDAO{
	
	//ESTADO
	Statement st;
	ResultSet rs;
	Vehiculo miVehiculo;
	
	/**
	 * Constructor
	 */
	public VehiculoDAO() {
		super();
		st = null;
		rs=null;
		
	}
	public ArrayList<Vehiculo> buscarVehiculo(String miMatricula, String miMarca,String miModelo,String miTipo,
			String miPrecio,String miColor,String miFecha) {
			Date date= null;
			ArrayList<Vehiculo> miListaVehiculos=null;
			Vehiculo miVehiculo;
			PreparedStatement preparedStmt;
			String precio="";
			String fecha = "'%"+miFecha+"%'" ;

		if(!miFecha.equals("")){
		    fecha = "%" + Date.valueOf(miFecha) + "%";
		}
		
		if(!miPrecio.equals("")) {
			precio = " and precio like ? ";
			
		}

		try {
			 String query = "select matricula,marca,modelo,tipo,precio,color,fechaEntrada,ciudad,nombre"
			 		+ " FROM vehiculo,concesionario where vehiculo.idConcesionario=concesionario.idConcesionario"
			 		+ " and matricula like ? and marca like ? and modelo like ? and tipo like ?"
			 		+ " and color like ? and fechaEntrada like " + fecha + precio;
			 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 preparedStmt.setString(1, "%"+ miMatricula + "%" );
			 preparedStmt.setString(2, "%"+ miMarca + "%");
			 preparedStmt.setString(3, "%"+ miModelo + "%" );
			 preparedStmt.setString(4, "%"+ miTipo + "%" );
			 preparedStmt.setString(5, "%"+ miColor + "%" );
			 //preparedStmt.setDate(6,date);			
			 if(!miPrecio.equals("")) preparedStmt.setInt(6,Integer.valueOf(miPrecio));
	            rs = preparedStmt.executeQuery();
										
			miListaVehiculos= new ArrayList<Vehiculo>();
			//mientras el resultset tenga filas creará clientes, les setea el estado y lo añade a la lista 
		/*	while(rs.next()) {
				miVehiculo = new Vehiculo(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),
						int miPrecio,String miColor,Date miFecha,int miIDConcesio, int miIDCliente);
				
			}	*/	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return miListaVehiculos;
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
}
