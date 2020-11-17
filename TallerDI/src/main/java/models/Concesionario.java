package models;

public class Concesionario {
	
	//ESTADO
	protected int idConcesionario;
	protected String ciudad;
	protected String nombre;
	/**
	 * Constructor vacio
	 */
	public Concesionario() {
		
	}
	/**
	 * Constructor
	 * @param miId
	 * @param miCiudad
	 * @param miNombre
	 */
	public Concesionario(int miId, String miCiudad,String miNombre) {
		idConcesionario = miId;
		ciudad = miCiudad;
		nombre = miNombre;
	}
	public int getIdConcesionario() {
		return idConcesionario;
	}
	public void setIdConcesionario(int idConcesionario) {
		this.idConcesionario = idConcesionario;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
