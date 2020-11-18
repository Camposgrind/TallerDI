package models;

import java.util.Date;

public class Propuesta {
	
	//ESTADO
	private int idPropuesta;
	private int idUsuario;
	private int idCliente;
	private String matricula;
	private Date fecha;
	private int presupuesto;
	/**
	 * Constructor con parámetros 
	 * @param miIdPropuesta
	 * @param miIdUsuario
	 * @param miIdCliente
	 * @param miMatricula
	 * @param miFecha
	 * @param miPresupuesto
	 */
	public Propuesta(int miIdPropuesta,int miIdUsuario, int miIdCliente, String miMatricula, Date miFecha, int miPresupuesto) {
		idPropuesta = miIdPropuesta;
		idUsuario = miIdUsuario;
		idCliente = miIdCliente;
		matricula = miMatricula;
		fecha = miFecha;
		presupuesto = miPresupuesto;
	}
	/**
	 * Constructor vacío
	 */
	public Propuesta() {
		
	}
	public int getIdPropuesta() {
		return idPropuesta;
	}
	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
}
