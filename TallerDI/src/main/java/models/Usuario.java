package models;

public class Usuario {
	
	//ESTADO
	protected int idUsuario;
	protected String nomUsuario;
	protected String password;
	protected String nombre;
	protected String apellido;
	protected String telefono;
	protected int sueldo;
	protected String rol;
	protected boolean mecanicoJefe;
	protected boolean mecaCoches;
	protected boolean mecaMotos;
	protected boolean mecaCicloMotor;
	protected int comisionVentas;
	
	public Usuario() {
		
	}

	public Usuario(int miID, String miNomUsuario, String miPassword, String miNombre, String miApellido, String miTelefono,
			int miSueldo, String miRol, boolean miMecanicoJefe, boolean miMecaCoches, boolean miMecaMotos, boolean miMecaCicloMotor,
			int miComisionVentas) {
		
		idUsuario = miID;
		nomUsuario = miNomUsuario;
		password = miPassword;
		nombre = miNombre;
		apellido = miApellido;
		telefono = miTelefono;
		sueldo = miSueldo;
		rol = miRol;
		mecanicoJefe = miMecanicoJefe;
		mecaCoches = miMecaCoches;
		mecaMotos = miMecaMotos;
		mecaCicloMotor = miMecaCicloMotor;
		comisionVentas = miComisionVentas;
	}
	
	
	
	//Getter y setter del usuario
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isMecanicoJefe() {
		return mecanicoJefe;
	}

	public void setMecanicoJefe(boolean mecanicoJefe) {
		this.mecanicoJefe = mecanicoJefe;
	}

	public boolean isMecaCoches() {
		return mecaCoches;
	}

	public void setMecaCoches(boolean mecaCoches) {
		this.mecaCoches = mecaCoches;
	}

	public boolean isMecaMotos() {
		return mecaMotos;
	}

	public void setMecaMotos(boolean mecaMotos) {
		this.mecaMotos = mecaMotos;
	}

	public boolean isMecaCicloMotor() {
		return mecaCicloMotor;
	}

	public void setMecaCicloMotor(boolean mecaCicloMotor) {
		this.mecaCicloMotor = mecaCicloMotor;
	}

	public int getComisionVentas() {
		return comisionVentas;
	}

	public void setComisionVentas(int comisionVentas) {
		this.comisionVentas = comisionVentas;
	}
	
	
	
}
