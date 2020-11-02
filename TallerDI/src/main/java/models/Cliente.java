package models;

public class Cliente {
	//ESTADO
	int idCliente;
	String nombre;
	String apellidos;
	String telefono;
	String dni;
	
	
	public Cliente() {
		
	}
	public Cliente(int miIdCliente, String miNombre, String misApellidos,String miTlfn,String miDni) {
		idCliente = miIdCliente;
		nombre = miNombre;
		apellidos = misApellidos;
		telefono = miTlfn;
		dni = miDni;
	}
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
