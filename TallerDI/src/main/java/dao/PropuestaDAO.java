package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
