-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_taller
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Telefono` varchar(10) NOT NULL,
  `DNI` varchar(20) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Sergio','Campos','654123789','12345678D'),(2,'Rubén','Torrejon','654789321','87654321C'),(3,'Adrián','Beigveder','654123987','98745632D'),(4,'Manolo','Lopez','654123321','66666666D'),(5,'Daniel','Perez','646136341','14725836F'),(6,'Jose','Martinez','613564554','63516812G'),(7,'Antonio','Ruiz','747896321','58741296F'),(8,'Maria','Fuentes Ortiz','987456214','32145897J'),(9,'Nuria','Rivas','665544332','95162384A'),(10,'Sergio','Molina','666333000','54106622Z'),(11,'Juanma','Lopez Iturriaga','666222777','5463300D'),(12,'Mateo','Salas','654123987','00886633W'),(13,'Joselito','Ruisenhol','666333777','20202045M'),(14,'Jorge','Martos','222666888','12345632K');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concesionario`
--

DROP TABLE IF EXISTS `concesionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concesionario` (
  `idConcesionario` int NOT NULL AUTO_INCREMENT,
  `Ciudad` varchar(45) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idConcesionario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concesionario`
--

LOCK TABLES `concesionario` WRITE;
/*!40000 ALTER TABLE `concesionario` DISABLE KEYS */;
INSERT INTO `concesionario` VALUES (1,'Málaga','Autos Fermín'),(2,'Málaga','Rincón Motor'),(3,'Almería','AutoAlmería'),(4,'Almería','Motos Ejido');
/*!40000 ALTER TABLE `concesionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propuesta`
--

DROP TABLE IF EXISTS `propuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propuesta` (
  `idPropuesta` int NOT NULL AUTO_INCREMENT,
  `Usuario` int NOT NULL,
  `Cliente` int NOT NULL,
  `Veh_Matricula` varchar(8) NOT NULL,
  `Fecha` date NOT NULL,
  `Presupuesto` int NOT NULL,
  PRIMARY KEY (`idPropuesta`),
  KEY `idUsuario_idx` (`Usuario`),
  KEY `idCliente_idx` (`Cliente`),
  KEY `Matricula_idx` (`Veh_Matricula`),
  CONSTRAINT `Cliente` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `Usuario` FOREIGN KEY (`Usuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `Veh_Matricula` FOREIGN KEY (`Veh_Matricula`) REFERENCES `vehiculo` (`Matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propuesta`
--

LOCK TABLES `propuesta` WRITE;
/*!40000 ALTER TABLE `propuesta` DISABLE KEYS */;
INSERT INTO `propuesta` VALUES (2,1,1,'0666HHH','2020-11-04',3500),(3,2,2,'1234BBB','2020-11-03',1200),(4,3,1,'9876GGG','2020-11-05',1500),(5,1,4,'C2790BCB','2020-11-25',500),(6,1,11,'9876GGG','2020-11-25',2000);
/*!40000 ALTER TABLE `propuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repara`
--

DROP TABLE IF EXISTS `repara`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repara` (
  `idRepara` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int DEFAULT NULL,
  `Matricula` varchar(8) NOT NULL,
  `Fecha_Entrada` date NOT NULL,
  `Fecha_Salida` date DEFAULT NULL,
  `Presupuesto` int DEFAULT NULL,
  `Piezas` varchar(500) DEFAULT NULL,
  `Tiempo` varchar(45) DEFAULT NULL,
  `Tarea` varchar(500) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idRepara`),
  KEY `idUsuario_idx` (`idUsuario`),
  KEY `idCliente_idx` (`Matricula`),
  CONSTRAINT `idUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `Matricula` FOREIGN KEY (`Matricula`) REFERENCES `vehiculo` (`Matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repara`
--

LOCK TABLES `repara` WRITE;
/*!40000 ALTER TABLE `repara` DISABLE KEYS */;
INSERT INTO `repara` VALUES (1,7,'9999ZZZ','2020-11-22',NULL,50,'bombillas','1 hora','cambiar luces','Pendiente'),(3,8,'8888ZZZ','2020-11-22',NULL,1000,'cara y el sol','RIP','Cara al sol','Pendiente'),(4,NULL,'C1111BBB','2020-11-22',NULL,NULL,NULL,NULL,NULL,NULL),(10,NULL,'6200CWC','2020-11-25',NULL,NULL,NULL,NULL,NULL,NULL),(11,NULL,'2191HZZ','2020-11-25',NULL,NULL,NULL,NULL,NULL,NULL),(12,5,'9876GGG','2020-11-25','2020-11-25',200,'ruedas, tornillos','1 hora','Cambiar ruedas','Finalizada'),(13,6,'2030LLL','2020-11-25','2020-11-26',200,'nada','1 dia','Mirar','Finalizada'),(14,8,'8888ZZZ','2020-11-25',NULL,1000,'cara y el sol','RIP','Cara al sol','Pendiente'),(15,5,'1234TTT','2020-11-26','2020-11-26',150,'paragolpes, tornillos','3 horas','Cambiar paragolpes','Finalizada'),(16,6,'2030LLL','2020-11-26','2020-11-26',200,'nada','1 dia','Mirar','Finalizada'),(17,NULL,'C1111BBB','2020-11-26',NULL,NULL,NULL,NULL,NULL,NULL),(18,NULL,'8888ZZZ','2020-11-26',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `repara` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(20) NOT NULL,
  `Pass` varchar(50) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `Sueldo` int DEFAULT NULL,
  `Rol` varchar(45) DEFAULT NULL,
  `Mecanico_Jefe` tinyint DEFAULT NULL,
  `Esp_Coches` tinyint DEFAULT NULL,
  `Esp_Motos` tinyint DEFAULT NULL,
  `Esp_Ciclomotores` tinyint DEFAULT NULL,
  `Ventas` int DEFAULT NULL,
  `Concesionario` int DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `Concesionario_idx` (`Concesionario`),
  CONSTRAINT `Concesionario` FOREIGN KEY (`Concesionario`) REFERENCES `concesionario` (`idConcesionario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'pepe','202cb962ac59075b964b07152d234b70','Pepe','Marin','654123456',2000,'Ventas',0,0,0,0,22500,1),(2,'ana','202cb962ac59075b964b07152d234b70','Ana','Lopez','654654321',2000,'ventas',0,0,0,0,20000,1),(3,'jose','202cb962ac59075b964b07152d234b70','Jose','Jimenez','665656565',2000,'ventas',0,0,0,0,20000,1),(4,'fermin','202cb962ac59075b964b07152d234b70','Fermín','Trozo','666555444',2200,'ventas',0,0,0,0,32000,2),(5,'yoni','202cb962ac59075b964b07152d234b70','Juan','Perez','606060606',1200,'Mecánico',0,1,1,0,0,1),(6,'fausto','202cb962ac59075b964b07152d234b70','Fausto','Satanas','666666666',6660,'Mecánico',1,1,1,1,0,1),(7,'manu','202cb962ac59075b964b07152d234b70','Manuel','Martinez','654456654',1200,'Mecánico',0,1,0,0,0,1),(8,'pakillo','202cb962ac59075b964b07152d234b70','Francisco','Soria','636363636',1200,'Mecánico',0,0,1,0,0,1),(9,'oswaldo','202cb962ac59075b964b07152d234b70','Oswaldo','Washington','646464646',1200,'Mecánico',0,0,0,1,0,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `Matricula` varchar(8) NOT NULL,
  `Marca` varchar(15) NOT NULL,
  `Modelo` varchar(25) NOT NULL,
  `Tipo` varchar(15) DEFAULT NULL,
  `Precio` int DEFAULT NULL,
  `Kilometros` int DEFAULT '0',
  `Color` varchar(45) DEFAULT '0',
  `Combustible` varchar(15) DEFAULT NULL,
  `FechaEntrada` date DEFAULT NULL,
  `idConcesionario` int DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  `Vendido` tinyint DEFAULT NULL,
  PRIMARY KEY (`Matricula`),
  KEY `idConcesionario_idx` (`idConcesionario`),
  KEY `idCliente_idx` (`idCliente`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `idConcesionario` FOREIGN KEY (`idConcesionario`) REFERENCES `concesionario` (`idConcesionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES ('0666HHH','Seat','Leon','Coche',3800,200000,'Rojo','Diesel','2020-10-02',3,NULL,0),('1234BBB','Ford','Fiesta','Coche',1500,150000,'Verde','Gasolina','2019-11-04',1,NULL,0),('1234TTT','Testla','T','Coche',NULL,100,'0','Electrico','2020-11-26',1,14,1),('2030LLL','Masseratti','Ni idea','Coche',NULL,0,'0','Gasolina','2020-11-25',1,13,1),('2191HZZ','BMW','Z4','Coche',NULL,200,'0','Diesel','2020-11-25',1,11,1),('2345CCC','Citroen','C4','Coche',4000,127000,'Negro','Electrico','2020-09-03',2,NULL,0),('4567JHJ','Jeep','Cherokee','Coche',10000,60000,'Negro','Gasolina','2020-11-25',1,NULL,0),('6200CWC','BMW','630','Coche',NULL,200,NULL,'Diesel','2020-11-25',1,10,1),('8888ZZZ','Kymco','Agility','Motocicleta',0,35000,'Blanco','Gasolina','2019-11-22',1,3,1),('9876GGG','Kawasaki','Ninja','Motocicleta',2000,45000,'Blanco','Hibrido','2020-10-01',4,11,1),('9999ZZZ','Tesla','Model3','Coche',0,50000,'Rojo','Electrico','2020-11-22',1,2,1),('C1111BBB','Yamaha','Aerox','Ciclomotor',0,60000,'Negro','Gasolina','2020-11-22',1,4,1),('C2790BCB','Piaggio','City','Ciclomotor',500,350000,'Negro','Gasolina','2020-09-15',1,4,1);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-26  8:57:55
