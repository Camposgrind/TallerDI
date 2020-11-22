package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import models.Cliente;
import models.Reparacion;

public class ReparacionDAO extends AbstractDAO{
	
	//ESTADO
	protected Reparacion miReparacion;
	protected ResultSet rs;
	protected PreparedStatement preparedStmt;
	
	/**
	 * Constructor
	 */
	public ReparacionDAO() {
		super();
		rs = null;
		preparedStmt = null;
		
	}
	/**
	 * M�todo para que el jefe de taller introduzca una reparaci�n en la BBDD<br>
	 * este m�todo deja muchos campos a null de la tabla que en otra ventana el <br>
	 * jefe actualizar� con el usuario que har� la reparaci�n, piezas, precio...
	 * @param miMatricula matricula del coche a reparar
	 * @return
	 */
	public boolean addReparacion(String miMatricula) {
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
	
	public ArrayList<Reparacion> buscarReparacionesEmpleado(int idUsuario) {
		ArrayList<Reparacion> listaReparaciones = null;
		
		 try {
			 String query = "SELECT * FROM repara where idUsuario like ?";
			
			 preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
					 ResultSet.CONCUR_UPDATABLE);
			 
			 preparedStmt.setInt(1,idUsuario);

	            rs = preparedStmt.executeQuery();
				listaReparaciones = new ArrayList<Reparacion>();						
			//mientras el resultset tenga filas crear� clientes, les setea el estado y lo a�ade a la lista 
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
	

}