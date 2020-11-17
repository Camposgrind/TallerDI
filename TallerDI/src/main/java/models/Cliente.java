package models;

public class Cliente {
	
	//ESTADO
	protected int idCliente;
	protected String nombre;
	protected String apellidos;
	protected String telefono;
	protected String dni;
	
	/**
	 * Constructor vacío
	 */
	public Cliente() {
		
	}
	/**
	 * Constructor con parámetros
	 * @param miIdCliente el idCliente que guardará nuestro cliente
	 * @param miNombre el nombre del cliente
	 * @param misApellidos los apellidos del cliente
	 * @param miTlfn el teléfono del cliente 
	 * @param miDni el dni del cliente 
	 */
	public Cliente(int miIdCliente, String miNombre, String misApellidos,String miTlfn,String miDni) {
		idCliente = miIdCliente;
		nombre = miNombre;
		apellidos = misApellidos;
		telefono = miTlfn;
		dni = miDni;
	}
	
	//Getters y setters
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
}