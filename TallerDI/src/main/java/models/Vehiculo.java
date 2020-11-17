package models;

import java.util.Date;

public class Vehiculo {
	//ESTADO
	protected String matricula;
	protected String marca;
	protected String modelo;
	protected String tipo;
	protected int precio;
	protected int km;
	protected String color;
	protected String combustible;
	protected Date fechaEntrada;
	protected int idConcesionario;
	protected int idCliente;
	protected boolean vendido;
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
			int miPrecio,int misKm,String miColor,String miCombustible,Date miFecha,int miIDConcesio, int miIDCliente, boolean vendido) {
		
		matricula = miMatricula;
		marca = miMarca;
		modelo = miModelo;
		tipo = miTipo;
		precio = miPrecio;
		km = misKm;
		color = miColor;
		combustible = miCombustible;
		fechaEntrada = miFecha;
		idConcesionario = miIDConcesio;
		idCliente = miIDCliente;
		this.vendido = vendido;
	}
	
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public boolean isVendido() {
		return vendido;
	}
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	public int getKilometros() {
		return km;
	}
	public void setKilometros(int km) {
		this.km = km;
	}
	public String getCombustible() {
		return combustible;
	}
	public void setCombustible(String combustible) {
		this.combustible = combustible;
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
