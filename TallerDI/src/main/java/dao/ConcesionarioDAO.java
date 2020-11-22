package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConcesionarioDAO extends AbstractDAO {
	
	//ESTADO
	protected Statement st;
	protected ResultSet rs;
	
	/**
	 * Constructor 
	 */
	public ConcesionarioDAO() {
		super();
		st = null;
		rs=null;
	}
	/**
	 * Método para buscar los nombre de los concesionarios de la base de datos para rellenar los comboBox 
	 * también está hecho para rellenar la tabla de vehiculos 
	 * @param idConcesionario le metemos el id si quieremos buscar un concesionario específico o 0 si queremos rellenar el comboBox
	 * @return listaNombresConcesionarios
	 */
	public ArrayList<String> buscarNombreConcesionario(int idConcesionario) {
		ArrayList<String> listaNombresConcesionarios= new ArrayList<String>();
		String concesionario;
		PreparedStatement preparedStmt;
		
		try {
			//Aquí le decimos que si es igual a 0 el parámetro que busque todos los nombres
			if(idConcesionario==0) {
				String query = "SELECT NOMBRE FROM CONCESIONARIO";
				 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
						 ResultSet.CONCUR_UPDATABLE);
			//Si no que busque el nombre del concesionario que tiene ese id	 
			}else {
				String query = "SELECT NOMBRE FROM CONCESIONARIO where idConcesionario like ?";
				preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				preparedStmt.setInt(1,idConcesionario);
			}
				
			 rs = preparedStmt.executeQuery();
			//ponemos el rs.next porque el puntero del sql se coloca antes de
			//la primera fila de la tabla, por lo tanto si tiene un valor el 
			//resulset devolverá true 
			 while(rs.next()) {
				 concesionario = rs.getString(1);
				 listaNombresConcesionarios.add(concesionario);
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaNombresConcesionarios;
				
	}
	/**
	 * Buscamos el id de un concesionario según su Nombre para hacer inserciones, buscar o actualizar 
	 * @param nombreConcesionario
	 * @return idConcesionario 
	 */
	public int buscarIDConcesionario(String nombreConcesionario) {
		int idConcesionario = 0;
		
		PreparedStatement preparedStmt;
		
		try {
			String query = "SELECT idConcesionario FROM CONCESIONARIO WHERE Nombre='"+nombreConcesionario+"'";
			 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 rs = preparedStmt.executeQuery();
			//ponemos el rs.next porque el puntero del sql se coloca antes de
			//la primera fila de la tabla, por lo tanto si tiene un valor el 
			//resulset devolverá true 
			 if(rs.next()) {
				 idConcesionario = rs.getInt(1);			 
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return idConcesionario;
		
	}
		

}
