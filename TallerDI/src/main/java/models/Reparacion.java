package models;

import java.util.Date;

public class Reparacion {

	//ESTADO
	private int idReparacion;
	private int idUsuario;
	private String matricula;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int presupuesto;
	private String piezas;
	private String tiempoEstimado;
	private String trabajo;
	private String estado;
	
	
	/**
	 * Constructor
	 * @param idReparacion
	 * @param idUsuario
	 * @param matricula
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @param presupuesto
	 * @param piezas
	 */
	public Reparacion(int idReparacion, int idUsuario, String matricula, Date fechaEntrada, Date fechaSalida,
			int presupuesto, String piezas, String tiempoEstimado,String trabajo,String estado) {
		super();
		this.idReparacion = idReparacion;
		this.idUsuario = idUsuario;
		this.matricula = matricula;
		this.fechaSalida = fechaSalida;
		this.presupuesto = presupuesto;
		this.piezas = piezas;
		this.fechaEntrada = fechaEntrada;
		this.tiempoEstimado = tiempoEstimado;
		this.trabajo = trabajo;
		this.estado = estado;
		
	}
	public Reparacion() {
		
	}

	public String getTiempoEstimado() {
		return tiempoEstimado;
	}
	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	public String getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdReparacion() {
		return idReparacion;
	}

	public void setIdReparacion(int idReparacion) {
		this.idReparacion = idReparacion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getPiezas() {
		return piezas;
	}

	public void setPiezas(String piezas) {
		this.piezas = piezas;
	}
	
	
	
}
