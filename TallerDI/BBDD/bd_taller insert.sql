-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_taller
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table cliente
--

/* Creación de tabla clientes */
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
	idCliente int NOT NULL AUTO_INCREMENT,
	Nombre varchar(20) NOT NULL,
	Apellidos varchar(50) NOT NULL,
	Telefono varchar(10) NOT NULL,
	DNI varchar(20) NOT NULL,
	PRIMARY KEY (idCliente));

/* Inserts de clientes */
INSERT INTO bd_taller.cliente (Nombre, Apellidos, Telefono, DNI) VALUES ('Sergio', 'Campos', '654123789', '12345678D');
INSERT INTO bd_taller.cliente (Nombre, Apellidos, Telefono, DNI) VALUES ('Ruben', 'Torrejon', '654789321', '87654321C');
INSERT INTO bd_taller.cliente (Nombre, Apellidos, Telefono, DNI) VALUES ('Adrian', 'Beigveder', '654123987', '98745632D');
INSERT INTO bd_taller.cliente (Nombre, Apellidos, Telefono, DNI) VALUES ('Manolo', 'Lopez', '654123321', '66666666D');
INSERT INTO bd_taller.cliente (Nombre, Apellidos, Telefono, DNI) VALUES ('Daniel', 'Perez', '646136341', '14725836F');
INSERT INTO bd_taller.cliente (Nombre, Apellidos, Telefono, DNI) VALUES ('Jose', 'Martinez', '613564554', '63516812G');
INSERT INTO bd_taller.cliente (Nombre, Apellidos, Telefono, DNI) VALUES ('Antonio', 'Ruiz', '747896321', '58741296F');
INSERT INTO bd_taller.cliente (Nombre, Apellidos, Telefono, DNI) VALUES ('Maria', 'Fuentes Ortiz', '987456214', '32145897J');
INSERT INTO bd_taller.cliente (Nombre, Apellidos, Telefono, DNI) VALUES ('Nuria', 'Rivas', '665544332', '95162384A');



/* Creación de tabla concesionario */
DROP TABLE IF EXISTS concesionario;
CREATE TABLE concesionario (
	idConcesionario int NOT NULL AUTO_INCREMENT,
	Ciudad varchar(45) NOT NULL,
	Nombre varchar(45) DEFAULT NULL,
	PRIMARY KEY (idConcesionario));

/* Inserts de concesionarios */
INSERT INTO bd_taller.concesionario (Ciudad, Nombre) VALUES ('Malaga', 'Autos Fermin');
INSERT INTO bd_taller.concesionario (Ciudad, Nombre) VALUES ('Malaga', 'Rincon Motor');
INSERT INTO bd_taller.concesionario (Ciudad, Nombre) VALUES ('Almeria', 'AutoAlmería');
INSERT INTO bd_taller.concesionario (Ciudad, Nombre) VALUES ('Almeria', 'Motos Ejido');



/* Creación de tabla propuesta de venta */
DROP TABLE IF EXISTS propuesta;
CREATE TABLE propuesta (
	idPropuesta int NOT NULL AUTO_INCREMENT,
	Usuario int NOT NULL,
	Cliente int NOT NULL,
	Veh_Matricula varchar(7) NOT NULL,
	Fecha date NOT NULL,
	Presupuesto int NOT NULL,
	PRIMARY KEY (idPropuesta),
	KEY idUsuario_idx (Usuario),
	KEY idCliente_idx (Cliente),
	KEY Matricula_idx (Veh_Matricula),
	CONSTRAINT Cliente FOREIGN KEY (Cliente) REFERENCES cliente (idCliente),
	CONSTRAINT Usuario FOREIGN KEY (Usuario) REFERENCES usuario (idUsuario),
	CONSTRAINT Veh_Matricula FOREIGN KEY (Veh_Matricula) REFERENCES vehiculo (Matricula));

/* Inserts de propuesta */
INSERT INTO bd_taller.propuesta (Usuario, Cliente, Veh_Matricula, Fecha, Presupuesto) VALUES ('1', '1', '0666HHH', '2020-11-04', '3500');
INSERT INTO bd_taller.propuesta (Usuario, Cliente, Veh_Matricula, Fecha, Presupuesto) VALUES ('2', '2', '1234BBB', '2020-11-03', '1200');
INSERT INTO bd_taller.propuesta (Usuario, Cliente, Veh_Matricula, Fecha, Presupuesto) VALUES ('3', '1', '9876GGG', '2020-11-05', '1500');



/* Creación de tabla repara */
DROP TABLE IF EXISTS repara;
CREATE TABLE repara (
	idRepara int NOT NULL AUTO_INCREMENT,
	idUsuario int NOT NULL,
	Matricula varchar(7) NOT NULL,
	Fecha_Entrada date NOT NULL,
	Fecha_Salida date NOT NULL,
	Presupuesto int NOT NULL,
	Piezas varchar(500) NOT NULL,
	PRIMARY KEY (idRepara),
	KEY idUsuario_idx (idUsuario),
	KEY idCliente_idx (Matricula),
	CONSTRAINT idUsuario FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario),
	CONSTRAINT Matricula FOREIGN KEY (Matricula) REFERENCES vehiculo (Matricula));



/* Creación de tabla usuario */
DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
	idUsuario int NOT NULL AUTO_INCREMENT,
	Usuario varchar(20) NOT NULL,
	Pass varchar(20) NOT NULL,
	Nombre varchar(20) NOT NULL,
	Apellidos varchar(50) NOT NULL,
	Telefono varchar(10) DEFAULT NULL,
	Sueldo int DEFAULT NULL,
	Rol varchar(45) DEFAULT NULL,
	Mecanico_Jefe tinyint DEFAULT NULL,
	Esp_Coches tinyint DEFAULT NULL,
	Esp_Motos tinyint DEFAULT NULL,
	Esp_Ciclomotores tinyint DEFAULT NULL,
	Ventas int DEFAULT NULL,
	Concesionario int DEFAULT NULL,
	PRIMARY KEY (idUsuario),
	KEY Concesionario_idx (Concesionario),
	CONSTRAINT Concesionario FOREIGN KEY (Concesionario) REFERENCES concesionario (idConcesionario));

/* Inserts de usuario */
INSERT INTO bd_taller.usuario (Usuario, Pass, Nombre, Apellidos, Telefono, Sueldo, Rol, Mecanico_Jefe, Esp_Coches, Esp_Motos, Esp_Ciclomotores, Ventas, Concesionario) VALUES ('pepe', '123', 'Pepe', 'Marin', '654123456', '2000', 'ventas', '0', '0', '0', '0', '20000', '1');
INSERT INTO bd_taller.usuario (Usuario, Pass, Nombre, Apellidos, Telefono, Sueldo, Rol, Mecanico_Jefe, Esp_Coches, Esp_Motos, Esp_Ciclomotores, Ventas, Concesionario) VALUES ('ana', '123', 'Ana', 'Lopez', '654654321', '2000', 'ventas', '0', '0', '0', '0', '20000', '1');
INSERT INTO bd_taller.usuario (Usuario, Pass, Nombre, Apellidos, Telefono, Sueldo, Rol, Mecanico_Jefe, Esp_Coches, Esp_Motos, Esp_Ciclomotores, Ventas, Concesionario) VALUES ('jose', '123', 'Jose', 'Jimenez', '665656565', '2000', 'ventas', '0', '0', '0', '0', '20000', '1');
INSERT INTO bd_taller.usuario (Usuario, Pass, Nombre, Apellidos, Telefono, Sueldo, Rol, Mecanico_Jefe, Esp_Coches, Esp_Motos, Esp_Ciclomotores, Ventas, Concesionario) VALUES ('fermin', '123', 'Fermin', 'Trozo', '666555444', '2200', 'ventas', '0', '0', '0', '0', '32000', '2');



/* Creación de tabla vehículo */
DROP TABLE IF EXISTS vehiculo;
CREATE TABLE vehiculo (
	Matricula varchar(7) NOT NULL,
	Marca varchar(15) NOT NULL,
	Modelo varchar(25) NOT NULL,
	Tipo varchar(15) DEFAULT NULL,
	Precio int DEFAULT NULL,
	Color varchar(45) DEFAULT NULL,
	FechaEntrada date DEFAULT NULL,
	idConcesionario int DEFAULT NULL,
	idCliente int DEFAULT NULL,
	PRIMARY KEY (Matricula),
	KEY idConcesionario_idx (idConcesionario),
	KEY idCliente_idx (idCliente),
	CONSTRAINT idCliente FOREIGN KEY (idCliente) REFERENCES cliente (idCliente),
	CONSTRAINT idConcesionario FOREIGN KEY (idConcesionario) REFERENCES concesionario (idConcesionario));

/* Inserts de vehículos */
INSERT INTO bd_taller.vehiculo (Matricula, Marca, Modelo, Tipo, Precio, Color, FechaEntrada, idConcesionario) VALUES ('1234BBB', 'Ford', 'Fiesta', 'Coche', '1500', 'Verde', '2020-11-04', '1');
INSERT INTO bd_taller.vehiculo (Matricula, Marca, Modelo, Tipo, Precio, Color, FechaEntrada, idConcesionario) VALUES ('2345CCC', 'Citroen', 'C4', 'Coche', '4000', 'Negro', '2020-09-03', '2');
INSERT INTO bd_taller.vehiculo (Matricula, Marca, Modelo, Tipo, Precio, Color, FechaEntrada, idConcesionario) VALUES ('0666HHH', 'Seat', 'Leon', 'Coche', '3800', 'Rojo', '2020-10-02', '3');
INSERT INTO bd_taller.vehiculo (Matricula, Marca, Modelo, Tipo, Precio, Color, FechaEntrada, idConcesionario) VALUES ('9876GGG', 'Kawasaki', 'Ninja', 'Moto', '2000', 'Blanco', '2020-10-01', '4');
INSERT INTO bd_taller.vehiculo (Matricula, Marca, Modelo, Tipo, Precio, Color, FechaEntrada, idConcesionario) VALUES ('C2790BC', 'Piaggio', 'City', 'Ciclomotor', '500', 'Negro', '2020-09-15', '1');



