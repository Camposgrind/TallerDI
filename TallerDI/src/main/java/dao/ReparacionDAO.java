package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.cj.protocol.Resultset;

import models.Propuesta;
import models.Reparacion;

public class ReparacionDAO extends AbstractDAO{
	
	//ESTADO
	protected Reparacion miReparacion;
	protected ResultSet rs;
	protected Statement st;
	
	/**
	 * Constructor
	 */
	public ReparacionDAO() {
		super();
		rs = null;
		
	}
	
	
	/**
	 * Método para que el jefe de taller introduzca una reparación en la BBDD<br>
	 * este método deja muchos campos a null de la tabla que en otra ventana el <br>
	 * jefe actualizará con el usuario que hará la reparación, piezas, precio...
	 * @param miMatricula matricula del coche a reparar
	 * @return
	 */
	public boolean addReparacion(String miMatricula) {
		PreparedStatement preparedStmt;
		
		Calendar calendario = Calendar.getInstance();
		String day = Integer.toString(calendario.get(Calendar.DATE));
		String month = Integer.toString(calendario.get(Calendar.MONTH)+1);
		String year = Integer.toString(calendario.get(Calendar.YEAR));
		String fecha = year+"-"+month+"-"+day;
		boolean resultado = false;		
		
		try {
			preparedStmt = super.con.prepareStatement("insert into repara"
					+ "(Matricula,Fecha_Entrada) values(?,?)");
			
			preparedStmt.setString(1,miMatricula);
			preparedStmt.setDate(2, Date.valueOf(fecha));
			preparedStmt.executeUpdate();
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return resultado;
	}
	
	
//	public void asignarReparacion(String miMatricula, int idUsuario) {
//		
//		try {
//			preparedStmt = super.con.prepareStatement("insert into repara (Matricula,Fecha_Entrada) values(?,?)");
//		} catch (Exception e) {
//			
//		}
//	}
	
	
	
	public ArrayList<Reparacion> buscarReparacionesEmpleado(int idUsuario) {
		ArrayList<Reparacion> listaReparaciones = null;
		PreparedStatement preparedStmt;
		
		 try {
			 String query = "SELECT * FROM repara where idUsuario like ? and Estado != 'Finalizada'";
			
			 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 
			 preparedStmt.setInt(1,idUsuario);

	            rs = preparedStmt.executeQuery();
				listaReparaciones = new ArrayList<Reparacion>();						
			//mientras el resultset tenga filas creará clientes, les setea el estado y lo añade a la lista 
			while(rs.next()) {
				miReparacion = new Reparacion(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDate(4),
						rs.getDate(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				
				listaReparaciones.add(miReparacion);
				
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		return listaReparaciones;
	}
	
	
	public boolean modificarReparacion(String miMatricula, int miUsuario, String miTarea, String miPiezas, String miTiempo, String miPresupuesto) {
		
		boolean miReparacion = false;
		
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = super.con.prepareStatement("update repara set idUsuario=?,Presupuesto=?,Tarea=?,Piezas=?,Tiempo=?,Estado=\"Pendiente\" where Matricula=?");
			
			preparedStmt.setInt(1, miUsuario);
			preparedStmt.setInt(2, Integer.valueOf(miPresupuesto));
			preparedStmt.setString(3, miTarea);
			preparedStmt.setString(4, miPiezas);
			preparedStmt.setString(5, miTiempo);
			
			//Aquí le decimos que nos de la matrícula que tiene para ponerlo en el where
			preparedStmt.setString(6, miMatricula);
			preparedStmt.executeUpdate();
			
			miReparacion = true;
//			
//			//seteamos el estado del cliente en memoria para luego mostrarlo en el vista de la ficha 
//			miReparacion.setNombre(miNombre);
//			miReparacion.setApellidos(miApellido);
//			miReparacion.setTelefono(miTlfn);
//			miReparacion.setDni(miDni);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		return miReparacion;
	}
	
	

	/**
	 * Método que obtiene la matrícula de un vehículo y devuelve el historial de reparaciones
	 * @return 
	 */
	public ArrayList<Reparacion> consultarHistorialPorMatricula(String matriculaHistorial) {
		
		PreparedStatement stm;
		ResultSet rs;
		
		Reparacion miReparacion;
		ArrayList<Reparacion> listaReparaciones = new ArrayList<Reparacion>();
		
		String query = "SELECT * FROM repara WHERE matricula = ? and Estado = 'Finalizada'";
		
		try {
			stm = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stm.setString(1, matriculaHistorial);
	        
			rs = stm.executeQuery();
	        
			while(rs.next()){
				miReparacion = new Reparacion(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDate(4),rs.getDate(5),
											  rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				listaReparaciones.add(miReparacion);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaReparaciones;
	}
	
	
	
	/**
	 * Método que actualiza en la BBDD el estado de la reparación
	 * @param estado
	 * @param matriculaWhere
	 * @return
	 */
	public boolean actualizarEstado(String estado,String matriculaWhere) {
		boolean resultado = false;
		String fecha="";
		
		if(estado.equals("Finalizada")) {
			
			Calendar calendario = Calendar.getInstance();
			String day = Integer.toString(calendario.get(Calendar.DATE));
			String month = Integer.toString(calendario.get(Calendar.MONTH)+1);
			String year = Integer.toString(calendario.get(Calendar.YEAR));
			fecha = ", Fecha_Salida = '"+year+"-"+month+"-"+day+"'";
		}
		PreparedStatement preparedStmt;
		
		try {

			
			preparedStmt = super.con.prepareStatement("update repara "
					+ "set Estado = ? "+fecha+" where matricula='"+matriculaWhere+"'");
			
			preparedStmt.setString(1,estado);

			preparedStmt.executeUpdate();
			
			resultado = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		return resultado;
	}
	

}