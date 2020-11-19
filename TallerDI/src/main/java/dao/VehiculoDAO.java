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
	protected Statement st;
	protected ResultSet rs;
	protected Vehiculo miVehiculo;
	protected String nombreConcesionario;
	protected String provincia;
	
	/**
	 * Constructor
	 */
	public VehiculoDAO() {
		super();
		st = null;
		rs=null;
		
	}
	/**
	 * Método para buscar un vehículo en la BBDD
	 * @param miMatricula
	 * @param miMarca
	 * @param miModelo
	 * @param miTipo
	 * @param miPrecio
	 * @param misKm
	 * @param miColor
	 * @param miCombustible
	 * @param miFecha
	 * @param idConcesionario
	 * @return
	 */
	public ArrayList<Vehiculo> buscarVehiculo(String miMatricula, String miMarca,String miModelo,String miTipo,
			String miPrecio,String misKm,String miColor,String miCombustible,String miFecha,String idConcesionario) {
						
			ArrayList<Vehiculo> miListaVehiculos=null;
			Vehiculo miVehiculo;
			PreparedStatement preparedStmt;
			//Iniciamos el precio para añadir a la consulta vacio 
			String precio="";
			//iniciamos la fecha para añadirlo a la consulta 
			String fecha = "'%"+miFecha+"%'" ;
			String km = "";
			String idCon = "";
			int i = 7;
			
		//si la fecha no está vacia le añadimos la fecha que nos ha traido el textfield	
		if(!miFecha.equals("")){
		    fecha = "%" + Date.valueOf(miFecha) + "%";
		}
		if(!misKm.equals("")) {
			km = " and precio like ?";
		}
		//si el precio no viene vacio le añadimos el string a la consulta 
		if(!miPrecio.equals("")) {
			precio = " and precio like ?";			
		}
		if(!idConcesionario.equals("")) {
			idCon = " and idConcesionario like ?"; 
		}

		try {
			 String query = "select *"
			 		+ " FROM vehiculo where matricula like ? and marca like ? and modelo like ? and tipo like ?"
			 		+ " and color like ? and combustible like ? and vendido like 0 and fechaEntrada like " + fecha + km + precio + idCon;
			 
			 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 preparedStmt.setString(1, "%"+ miMatricula + "%" );
			 preparedStmt.setString(2, "%"+ miMarca + "%");
			 preparedStmt.setString(3, "%"+ miModelo + "%" );
			 preparedStmt.setString(4, "%"+ miTipo + "%" );
			 preparedStmt.setString(5, "%"+ miColor + "%" );
			 preparedStmt.setString(6, "%"+ miCombustible + "%" );
			 //Si el precio no era igual a "" que introduzca el precio al final que meta la variable precio en la consulta y asigne 
			 //a la interrogación el valor que venia del textfield 
			 if(!miPrecio.equals("")) {
				 preparedStmt.setInt(i,Integer.valueOf(miPrecio));
				 i++;
			 }
			 if(!misKm.equals("")) {
				 preparedStmt.setInt(i,Integer.valueOf(misKm));
				 i++;
			 }
			 if(!idConcesionario.equals("")) {
				 preparedStmt.setInt(i,Integer.valueOf(idConcesionario));
				 i++;
			 }			 
	            rs = preparedStmt.executeQuery();
										
			miListaVehiculos= new ArrayList<Vehiculo>();
			
			//mientras el resultset tenga filas creará clientes, les setea el estado y lo añade a la lista 
			while(rs.next()){
				miVehiculo = new Vehiculo(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getDate(9),rs.getInt(10), rs.getInt(11),rs.getBoolean(12));
				miListaVehiculos.add(miVehiculo);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return miListaVehiculos;
	}
	
	/**
	 *  Método para añadir un vehículo a la BBDD
	 * @param miMatricula
	 * @param miMarca
	 * @param miModelo
	 * @param miTipo
	 * @param miPrecio
	 * @param misKm
	 * @param miColor
	 * @param miCombustible
	 * @param miFecha
	 * @param miIdConcesionario
	 */
	public void addVehiculo(String miMatricula, String miMarca,String miModelo,String miTipo,
			String miPrecio,String misKm,String miColor,String miCombustible,String miFecha,String miIdConcesionario) {
		
		PreparedStatement preparedStmt;
		
		try {
			
			
			preparedStmt = super.con.prepareStatement("insert into vehiculo (Matricula, Marca, Modelo, Tipo,"
					+ " Precio, Kilometros, Color, Combustible, FechaEntrada, idConcesionario) values (?,?,?,?,?,?,?,?,'2020-11-06',?)");
			
			preparedStmt.setString(1,miMatricula);
			preparedStmt.setString(2, miMarca);
			preparedStmt.setString(3, miModelo);
			preparedStmt.setString(4, miTipo);
			preparedStmt.setString(5, miPrecio);
			preparedStmt.setString(6, misKm);
			preparedStmt.setString(7, miColor);
			preparedStmt.setString(8, miCombustible);
			preparedStmt.setString(9, miIdConcesionario);
			
			preparedStmt.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}
	/**
	 * Metodo para modificar el vehiculo
	 * @param miMatricula
	 * @param miMarca
	 * @param miModelo
	 * @param miTipo
	 * @param miPrecio
	 * @param miCombustible
	 * @param miColor
	 * @param misKm
	 * @param miFechaEntrada
	 * @param idConcesionario
	 * @param matriculaWhere
	 * @return
	 */
	public Vehiculo modificarVehiculo(String miMatricula, String miMarca, String miModelo, String miTipo, String miPrecio,
			String miCombustible, String miColor, String misKm, String miFechaEntrada,int idConcesionario,String matriculaWhere) {
		PreparedStatement preparedStmt;
		Vehiculo miVehiculo = new Vehiculo();
		
		try {

			
			preparedStmt = super.con.prepareStatement("update vehiculo "
					+ "set Matricula = ?,Marca = ?, Modelo = ? ,Tipo = ?, Precio = ?, Kilometros = ?, Color = ?,"
					+ " Combustible = ?, FechaEntrada = ?, idConcesionario = ? where matricula='"+matriculaWhere+"'");
			
			preparedStmt.setString(1,miMatricula);
			preparedStmt.setString(2, miMarca);
			preparedStmt.setString(3, miModelo);
			preparedStmt.setString(4, miTipo);
			preparedStmt.setInt(5, Integer.valueOf(miPrecio));
			preparedStmt.setInt(6, Integer.valueOf(misKm));
			preparedStmt.setString(7, miColor);
			preparedStmt.setString(8, miCombustible);
			preparedStmt.setString(9, miFechaEntrada);
			preparedStmt.setInt(10, idConcesionario);
			
			//Aquí lo mismo habría que poner un where pero creo que se puede tocar algo en el SQL para que no haga falta 

			preparedStmt.executeUpdate();
			
			//seteamos el estado del Vehiculo en memoria para luego mostrarlo en el vista de la ficha 
			miVehiculo.setMatricula(miMatricula);
			miVehiculo.setMarca(miMarca);
			miVehiculo.setModelo(miModelo);
			miVehiculo.setTipo(miTipo);
			miVehiculo.setPrecio(Integer.valueOf(miPrecio));
			miVehiculo.setKilometros(Integer.valueOf(misKm));
			miVehiculo.setColor(miColor);
			miVehiculo.setCombustible(miCombustible);
			miVehiculo.setFechaEntrada(Date.valueOf(miFechaEntrada));
			miVehiculo.setIdConcesionario(idConcesionario);
			//Lo mismo hay que cambiar también el concesionario 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return miVehiculo;
	}
	/**
	 * Método para que nos de todos los combustibles que hay en la BBDD
	 * @return
	 */
	public ArrayList<String> getCombustibles() {
		ArrayList<String> listaCombustibles= new ArrayList<>();
		String combustible;
		PreparedStatement preparedStmt;
		try {
			String query = "SELECT DISTINCT(combustible) FROM vehiculo";
			 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 rs = preparedStmt.executeQuery();
			//ponemos el rs.next porque el puntero del sql se coloca antes de
			//la primera fila de la tabla, por lo tanto si tiene un valor el 
			//resulset devolverá true 

			 while(rs.next()) {
				 combustible = rs.getString(1);
				 listaCombustibles.add(combustible);				 
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCombustibles;
	}
	/**
	 * Método para confirmar y modificar los campos del coche cuando se ha vendido
	 * @param idUsuario
	 * @param vendido
	 * @param matriculaWhere
	 */
	public void venderVehiculo(int idUsuario, int vendido,String matriculaWhere) {
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = super.con.prepareStatement("update vehiculo "
					+ "set idCliente = ?,Vendido = ? where matricula='"+matriculaWhere+"'");
			
			preparedStmt.setInt(1,idUsuario);
			preparedStmt.setInt(2, vendido);

			//Aquí lo mismo habría que poner un where pero creo que se puede tocar algo en el SQL para que no haga falta 

			preparedStmt.executeUpdate();
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	


}
