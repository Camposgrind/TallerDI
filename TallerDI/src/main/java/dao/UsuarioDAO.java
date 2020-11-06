package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Usuario;

public class UsuarioDAO extends AbstractDAO{
	
	//ESTADO
	Statement st;
	ResultSet rs;
	Usuario miUsuario;
	
	/**
	 * Constructor
	 */
	public UsuarioDAO() {
		super();
		st = null;
		rs=null;
		
	}
	/**
	 * método para ver si el usuario y la contraseña del login son correctas
	 * @param user usuario del textfield
	 * @param pass contraseña de la passwordField
	 * @return miUsuario devuelve el usuario si ha ido bien y null si no ha ido bien
	 */
	public Usuario testLogin(String user, String pass) {
	
		try {
			st = super.con.createStatement();
			rs = st.executeQuery("SELECT * FROM USUARIO WHERE USUARIO='"+user+"' AND PASS='"+pass+"'");
			//ponemos el rs.next porque el puntero del sql se coloca antes de
			//la primera fila de la tabla, por lo tanto si tiene un valor el 
			//resulset devolverá true 
			if(rs.next()) {
				miUsuario = new Usuario();
				this.setText();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return miUsuario;
	}
	/**
	 * Método para setear todo el estado de usuario con la consulta a la BBDD
	 */
	private void setText() {
		
		try {
			miUsuario.setIdUsuario(rs.getInt(1));
			miUsuario.setNomUsuario(rs.getString(2));
			miUsuario.setPassword(rs.getString(3));
			miUsuario.setNombre(rs.getString(4));
			miUsuario.setApellido(rs.getString(5));
			miUsuario.setTelefono(rs.getString(6));
			miUsuario.setSueldo(rs.getInt(7));
			miUsuario.setRol(rs.getString(8));
			miUsuario.setMecanicoJefe(rs.getBoolean(9));
			miUsuario.setMecaCoches(rs.getBoolean(10));
			miUsuario.setMecaMotos(rs.getBoolean(11));
			miUsuario.setMecaCicloMotor(rs.getBoolean(12));
			miUsuario.setComisionVentas(rs.getInt(13));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}