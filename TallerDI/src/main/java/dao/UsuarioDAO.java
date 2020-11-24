package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Usuario;

public class UsuarioDAO extends AbstractDAO{
	
	//ESTADO
	protected Statement st;
	protected ResultSet rs;
	protected Usuario miUsuario;
	
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
	public Usuario buscarUsuarioById(int idUsuario) {
		try {
			st = super.con.createStatement();
			rs = st.executeQuery("SELECT * FROM USUARIO WHERE idUsuario='"+idUsuario+"'");
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
	
	public boolean addUsuario(String miNombreUsu,String miPass,String miNombre,String misApellidos,
			String miTlfn,String miSueldo,String miRol,int mecaJefe,int espCoches,int espMotos,
			int espCicloM,String miIdConcesionario) {
		
		
		boolean resultado= false;
		PreparedStatement preparedStmt;
		
		try {
			preparedStmt = super.con.prepareStatement("insert into usuario"
					+ "(usuario,Pass,Nombre,Apellidos,Telefono,Sueldo,Rol,Mecanico_Jefe,"
					+ "Esp_coches,Esp_motos,Esp_Ciclomotores,Concesionario) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			preparedStmt.setString(1,miNombreUsu);
			preparedStmt.setString(2, miPass);
			preparedStmt.setString(3, miNombre);
			preparedStmt.setString(4, misApellidos);
			preparedStmt.setString(5, miTlfn);
			preparedStmt.setString(6, miSueldo);
			preparedStmt.setString(7, miRol);
			preparedStmt.setInt(8, mecaJefe);
			preparedStmt.setInt(9, espCoches);
			preparedStmt.setInt(10, espMotos);
			preparedStmt.setInt(11, espCicloM);
			preparedStmt.setInt(12, Integer.valueOf(miIdConcesionario));
			preparedStmt.executeUpdate();
			resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return resultado;
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
			miUsuario.setIdConcesionario(rs.getInt(14));
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	public ArrayList<Usuario> buscarMecanicos(String tipo) {
		ArrayList<Usuario> listaMecanicos = new ArrayList<Usuario>();
		Usuario mecanico;
		PreparedStatement preparedStmt;
		
		String query = "";

		try {
			
			if (tipo.equals("")) {
				query = "select * from usuario where rol = \"Mecánico\"";
			}
			
			else {
				switch (tipo) {
					case "Coche":
						query = "select * from usuario where rol = \"Mecánico\" and esp_Coches=true";
						break;
					case "Motocicleta":
						query = "select * from usuario where rol = \"Mecánico\" and esp_Motos=true";
						break;
					case "Ciclomotor":
						query = "select * from usuario where rol = \"Mecánico\" and esp_Ciclomotores=true";
						break;
					}
			}
			
			preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = preparedStmt.executeQuery();
			
			//mientras el resultset tenga filas creará clientes, les setea el estado y lo añade a la lista 
			while(rs.next()) {
				mecanico = new Usuario();
				mecanico.setIdUsuario(rs.getInt(1));
				mecanico.setNomUsuario(rs.getString(2));
				mecanico.setPassword(rs.getString(3));
				mecanico.setNombre(rs.getString(4));
				mecanico.setApellido(rs.getString(5));
				mecanico.setTelefono(rs.getString(6));
				mecanico.setSueldo(rs.getInt(7));
				mecanico.setRol(rs.getString(8));
				mecanico.setMecanicoJefe(rs.getBoolean(9));
				mecanico.setMecaCoches(rs.getBoolean(10));
				mecanico.setMecaMotos(rs.getBoolean(11));
				mecanico.setMecaCicloMotor(rs.getBoolean(12));
				mecanico.setIdConcesionario(rs.getInt(14));
				listaMecanicos.add(mecanico);
			}	
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaMecanicos;
				
	}
	/**
	 * Método para buscar los usuarios de la sección de ventas
	 * @param fechaDesde
	 * @param fechaHasta
	 * @return
	 */
	public ArrayList<Usuario> buscarUsuarioVentas(String fechaDesde,String fechaHasta){
		ArrayList<Usuario> listaUsuVentas = new ArrayList<Usuario>();
		Usuario usuVentas;
		PreparedStatement preparedStmt;
		String query = "Select * from usuario where Rol = 'Ventas'";
		
		if(fechaDesde!=null&&fechaHasta!=null) {
			
		}
		
		try {
			preparedStmt = super.con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = preparedStmt.executeQuery();
			
			while (rs.next()) {
				miUsuario = new Usuario();
				this.setText();
				listaUsuVentas.add(miUsuario);				
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaUsuVentas;
	}
	
}