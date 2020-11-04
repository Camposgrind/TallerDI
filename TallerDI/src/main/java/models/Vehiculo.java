package models;

import java.util.Date;

public class Vehiculo {
	//ESTADO
	String matricula;
	String marca;
	String modelo;
	String tipo;
	int precio;
	String color;
	Date fechaEntrada;
	int idConcesionario;
	int idCliente;
	/**
	 * Constructor vacio
	 */
	public Vehiculo() {
		
	}
	/**
	 * Constructor
	 * @param miMatricula
	 * @param miMarca
	 * @param miModelo
	 * @param miTipo
	 * @param miPrecio
	 * @param miColor
	 * @param miFecha fecha de entrada del vehículo
	 * @param miIDConcesio id concesionario
	 * @param miIDCliente
	 */
	public Vehiculo(String miMatricula, String miMarca,String miModelo,String miTipo,
			int miPrecio,String miColor,Date miFecha,int miIDConcesio, int miIDCliente) {
		
		matricula = miMatricula;
		marca = miMarca;
		modelo = miModelo;
		tipo = miTipo;
		precio = miPrecio;
		color = miColor;
		fechaEntrada = miFecha;
		idConcesionario = miIDConcesio;
		idCliente = miIDCliente;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public int getIdConcesionario() {
		return idConcesionario;
	}
	public void setIdConcesionario(int idConcesionario) {
		this.idConcesionario = idConcesionario;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
