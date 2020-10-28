package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import common.Constant;

abstract class AbstractDAO {
	protected Connection con;
	
	public AbstractDAO() {
		ConectarBD();
	}
	/**
	 * Método para conectarse a la BBDD en local 
	 */
	private void ConectarBD() {
		try {
			Class.forName(Constant.CONTROLADOR);
			try {
				this.con = DriverManager.getConnection(Constant.URL, Constant.USUARIO, Constant.CLAVE);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
