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
	String nombreConcesionario;
	String provincia;
	
	/**
	 * Constructor
	 */
	public VehiculoDAO() {
		super();
		st = null;
		rs=null;
		nombreConcesionario="";
		provincia="";
		
	}
	/**
	 * Método para buscar un vehículo en la BBDD
	 * @param miMatricula la matrícula por la que vamos a buscar el coche 
	 * @param miMarca la marca por la que vamos a buscar el coche
	 * @param miModelo el modelo por el que vamos a buscar el coche
	 * @param miTipo el tipo por el que vamos a buscar el coche 
	 * @param miPrecio el precio por el que vamos a buscar el coche 
	 * @param miColor el color por el que vamos a buscar el coche 
	 * @param miFecha la fecha por la que vamos a buscar el coche
	 * @return la lista de los vehículos encontrados 
	 */
	public ArrayList<Vehiculo> buscarVehiculo(String miMatricula, String miMarca,String miModelo,String miTipo,
			String miPrecio,String miColor,String miFecha) {
						
			ArrayList<Vehiculo> miListaVehiculos=null;
			Vehiculo miVehiculo;
			PreparedStatement preparedStmt;
			//Iniciamos el precio para añadir a la consulta vacio 
			String precio="";
			//iniciamos la fecha para añadirlo a la consulta 
			String fecha = "'%"+miFecha+"%'" ;
			
		//si la fecha no está vacia le añadimos la fecha que nos ha traido el textfield	
		if(!miFecha.equals("")){
		    fecha = "%" + Date.valueOf(miFecha) + "%";
		}
		//si el precio no viene vacio le añadimos el string a la consulta 
		if(!miPrecio.equals("")) {
			precio = " and precio like ? ";
			
		}

		try {
			 String query = "select vehiculo.*,ciudad,nombre"
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
			 //Si el precio no era igual a "" que introduzca el precio al final que meta la variable precio en la consulta y asigne 
			 //a la interrogación el valor que venia del textfield 
			 if(!miPrecio.equals("")) preparedStmt.setInt(6,Integer.valueOf(miPrecio));
	            rs = preparedStmt.executeQuery();
										
			miListaVehiculos= new ArrayList<Vehiculo>();
			//mientras el resultset tenga filas creará clientes, les setea el estado y lo añade a la lista 
			while(rs.next()) {
				miVehiculo = new Vehiculo(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getString(6),rs.getDate(7),rs.getInt(8), rs.getInt(9));
				provincia = rs.getString(10);
				nombreConcesionario = rs.getString(11);
				miListaVehiculos.add(miVehiculo);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return miListaVehiculos;
	}
	/**
	 * Método para añadir un vehículo a la BBDD 
	 * @param miMatricula la matrícula que vamos a añadir 
	 * @param miMarca la marca que vamos a añadir 
	 * @param miModelo el modelo del coche que vamos a añadir 
	 * @param miTipo el tipo del coche que vamos a añadir 
	 * @param miPrecio el precio del coche que vamos a añadir 
	 * @param miColor el color del coche que vamos a añadir 
	 * @param miFecha la fecha de entrada del coche que vamos a añadir 
	 * @param miConcesionario
	 */
	public void addVehiculo(String miMatricula, String miMarca,String miModelo,String miTipo,
			String miPrecio,String miColor,String miFecha,String miConcesionario) {
		
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = super.con.prepareStatement("insert into vehiculo (Matricula, Marca, Modelo, Tipo,"
					+ " Precio, Color, FechaEntrada, idConcesionario) values (?,?,?,?,?,?,'2020-11-06',1)");
			
			preparedStmt.setString(1,miMatricula);
			preparedStmt.setString(2, miMarca);
			preparedStmt.setString(3, miModelo);
			preparedStmt.setString(4, miTipo);
			preparedStmt.setString(5, miPrecio);
			preparedStmt.setString(6, miColor);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	/////////////////////////////////////////////////////////
	//FALTA HACERLO, YA QUE ESTO ES COPY PASTE DE CLiENTE///
	///////////////////////////////////////////////////////
	public Cliente modificarVehiculo(String miNombre, String miApellido, String miTlfn, String miDni,Cliente miCliente) {
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
	public String getNombreConcesionario() {
		return nombreConcesionario;
	}
	public void setNombreConcesionario(String nombreConcesionario) {
		this.nombreConcesionario = nombreConcesionario;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
}
