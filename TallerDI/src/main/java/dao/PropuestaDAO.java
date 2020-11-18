package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import models.Propuesta;

public class PropuestaDAO extends AbstractDAO{
	
	//ESTADO
	
	protected ResultSet rs;
	protected Propuesta miPropuesta;
	
	public PropuestaDAO() {
		super();
		miPropuesta = new Propuesta();
		rs= null;
		
	}
	/**
	 * Método para añadir una propuesta a la BBDD
	 * @param idUsuario
	 * @param idCliente
	 * @param matriculaVehiculo
	 * @param presupuesto
	 * @return
	 */
	public boolean addPropuesta(int idUsuario,int idCliente, String matriculaVehiculo, String presupuesto) {
		PreparedStatement preparedStmt;
		Calendar calendario = Calendar.getInstance();
		String day = Integer.toString(calendario.get(Calendar.DATE));
		String month = Integer.toString(calendario.get(Calendar.MONTH)+1);
		String year = Integer.toString(calendario.get(Calendar.YEAR));
		String fecha= year+"-"+month+"-"+day;
		boolean resultado = false;
		
		try {
			preparedStmt = super.con.prepareStatement("insert into propuesta"
					+ "(Usuario,Cliente,Veh_Matricula,Fecha,Presupuesto) values(?,?,?,?,?)");
			
			preparedStmt.setInt(1,idUsuario);
			preparedStmt.setInt(2, idCliente);
			preparedStmt.setString(3, matriculaVehiculo);
			preparedStmt.setDate(4, Date.valueOf(fecha));
			preparedStmt.setString(5,presupuesto);
			preparedStmt.executeUpdate();
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	/**
	 * Método para buscar las propuestas
	 * @param miNombreCl
	 * @param misApellidosCl
	 * @param miMatricula
	 * @param miTipo
	 * @param miMarca
	 * @param miModelo
	 * @param miCombustible
	 * @param miPrecio
	 * @param miFecha
	 * @return listaPropuestas
	 */
	public ArrayList<Propuesta> buscarPropuestas(String miNombreCl, String misApellidosCl, String miMatricula,
			String miTipo, String miMarca, String miModelo, String miCombustible, String miPrecio, String miFecha){
		
		ArrayList<Propuesta> listaPropuestas=null;
		Propuesta miPropuesta;
		PreparedStatement preparedStmt;
		//Iniciamos el precio para añadir a la consulta vacio 
		String precio="";
		//iniciamos la fecha para añadirlo a la consulta 
		String fecha = "'%"+miFecha+"%'" ;
		
		//si la fecha no está vacia le añadimos la fecha que nos ha traido el textfield	
		if(!miFecha.equals("")){
			fecha = "%" + Date.valueOf(miFecha) + "%";
		}
		if(!miPrecio.equals("")) {
			precio = " and p.presupuesto like ?";			
		}
		
		try {
			 String query = "SELECT P.* "
			 		+ "FROM PROPUESTA P "
			 		+ "LEFT JOIN VEHICULO V ON V.MATRICULA = P.VEH_MATRICULA "
			 		+ "LEFT JOIN CLIENTE C ON C.IDCLIENTE = P.CLIENTE "
			 		+ "WHERE C.NOMBRE LIKE ? AND C.APELLIDOS LIKE ? AND "
			 		+ "V.MATRICULA LIKE ? AND V.TIPO LIKE ? AND "
			 		+ "V.MARCA LIKE ? AND V.MODELO LIKE ? AND "
			 		+ "V.COMBUSTIBLE LIKE ? AND "
			 		+ "P.FECHA LIKE " + fecha + precio;
			 
			 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 preparedStmt.setString(1, "%"+ miNombreCl + "%" );
			 preparedStmt.setString(2, "%"+ misApellidosCl + "%");
			 preparedStmt.setString(3, "%"+ miMatricula + "%" );
			 preparedStmt.setString(4, "%"+ miTipo + "%" );
			 preparedStmt.setString(5, "%"+ miMarca + "%" );
			 preparedStmt.setString(6, "%"+ miModelo + "%" );
			 preparedStmt.setString(7, "%"+ miCombustible + "%" );

			 //Si el precio no era igual a "" que introduzca el precio al final que meta la variable precio en la consulta y asigne 
			 //a la interrogación el valor que venia del textfield 
			 if(!miPrecio.equals("")) {
				 preparedStmt.setInt(8,Integer.valueOf(miPrecio));
			 }
			 
	         rs = preparedStmt.executeQuery();
	            
	         listaPropuestas = new ArrayList<Propuesta>();
	         
			while(rs.next()){
				miPropuesta = new Propuesta(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),
						rs.getDate(5),rs.getInt(6));
				
				listaPropuestas.add(miPropuesta);
			}              
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		
		return listaPropuestas;
	}

}
