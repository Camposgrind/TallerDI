/* Inserts de concesionarios */
INSERT INTO `bd_taller`.`concesionario` (`Ciudad`, `Nombre`) VALUES ('Malaga', 'Autos Fermin');
INSERT INTO `bd_taller`.`concesionario` (`Ciudad`, `Nombre`) VALUES ('Malaga', 'Rincon Motor');
INSERT INTO `bd_taller`.`concesionario` (`Ciudad`, `Nombre`) VALUES ('Almeria', 'AutoAlmería');
INSERT INTO `bd_taller`.`concesionario` (`Ciudad`, `Nombre`) VALUES ('Almeria', 'Motos Ejido');

/* Inserts de vehículos */
INSERT INTO `bd_taller`.`vehiculo` (`Matricula`, `Marca`, `Modelo`, `Tipo`, `Precio`, `Color`, `FechaEntrada`, `idConcesionario`) VALUES ('1234BBB', 'Ford', 'Fiesta', 'Coche', '1500', 'Verde', '2020-11-04', '1');
INSERT INTO `bd_taller`.`vehiculo` (`Matricula`, `Marca`, `Modelo`, `Tipo`, `Precio`, `Color`, `FechaEntrada`, `idConcesionario`) VALUES ('2345CCC', 'Citroen', 'C4', 'Coche', '4000', 'Negro', '2020-09-03', '2');
INSERT INTO `bd_taller`.`vehiculo` (`Matricula`, `Marca`, `Modelo`, `Tipo`, `Precio`, `Color`, `FechaEntrada`, `idConcesionario`) VALUES ('0666HHH', 'Seat', 'Leon', 'Coche', '3800', 'Rojo', '2020-10-02', '3');
INSERT INTO `bd_taller`.`vehiculo` (`Matricula`, `Marca`, `Modelo`, `Tipo`, `Precio`, `Color`, `FechaEntrada`, `idConcesionario`) VALUES ('9876GGG', 'Kawasaki', 'Ninja', 'Moto', '2000', 'Blanco', '2020-10-01', '4');
INSERT INTO `bd_taller`.`vehiculo` (`Matricula`, `Marca`, `Modelo`, `Tipo`, `Precio`, `Color`, `FechaEntrada`, `idConcesionario`) VALUES ('C2790BC', 'Piaggio', 'City', 'Ciclomotor', '500', 'Negro', '2020-09-15', '1');

/* Inserts de usuario */
INSERT INTO `bd_taller`.`usuario` (`Usuario`, `Pass`, `Nombre`, `Apellidos`, `Telefono`, `Sueldo`, `Rol`, `Mecanico_Jefe`, `Esp_Coches`, `Esp_Motos`, `Esp_Ciclomotores`, `Ventas`, `Concesionario`) VALUES ('pepe', '123', 'Pepe', 'Marin', '654123456', '2000', 'ventas', '0', '0', '0', '0', '20000', '1');
INSERT INTO `bd_taller`.`usuario` (`Usuario`, `Pass`, `Nombre`, `Apellidos`, `Telefono`, `Sueldo`, `Rol`, `Mecanico_Jefe`, `Esp_Coches`, `Esp_Motos`, `Esp_Ciclomotores`, `Ventas`, `Concesionario`) VALUES ('ana', '123', 'Ana', 'Lopez', '654654321', '2000', 'ventas', '0', '0', '0', '0', '20000', '1');
INSERT INTO `bd_taller`.`usuario` (`Usuario`, `Pass`, `Nombre`, `Apellidos`, `Telefono`, `Sueldo`, `Rol`, `Mecanico_Jefe`, `Esp_Coches`, `Esp_Motos`, `Esp_Ciclomotores`, `Ventas`, `Concesionario`) VALUES ('jose', '123', 'Jose', 'Jimenez', '665656565', '2000', 'ventas', '0', '0', '0', '0', '20000', '1');
INSERT INTO `bd_taller`.`usuario` (`Usuario`, `Pass`, `Nombre`, `Apellidos`, `Telefono`, `Sueldo`, `Rol`, `Mecanico_Jefe`, `Esp_Coches`, `Esp_Motos`, `Esp_Ciclomotores`, `Ventas`, `Concesionario`) VALUES ('fermin', '123', 'Fermin', 'Trozo', '666555444', '2200', 'ventas', '0', '0', '0', '0', '32000', '2');

/* Inserts de clientes */
INSERT INTO `bd_taller`.`cliente` (`Nombre`, `Apellidos`, `Telefono`, `DNI`) VALUES ('Sergio', 'Campos', '654123789', '12345678D');
INSERT INTO `bd_taller`.`cliente` (`Nombre`, `Apellidos`, `Telefono`, `DNI`) VALUES ('Ruben', 'Torrejon', '654789321', '87654321C');
INSERT INTO `bd_taller`.`cliente` (`Nombre`, `Apellidos`, `Telefono`, `DNI`) VALUES ('Adrian', 'Beigveder', '654123987', '98745632D');
INSERT INTO `bd_taller`.`cliente` (`Nombre`, `Apellidos`, `Telefono`, `DNI`) VALUES ('Manolo', 'Lopez', '654123321', '66666666D');
INSERT INTO `bd_taller`.`cliente` (`Nombre`, `Apellidos`, `Telefono`, `DNI`) VALUES ('Daniel', 'Perez', '646136341', '14725836F');
INSERT INTO `bd_taller`.`cliente` (`Nombre`, `Apellidos`, `Telefono`, `DNI`) VALUES ('Jose', 'Martinez', '613564554', '63516812G');
INSERT INTO `bd_taller`.`cliente` (`Nombre`, `Apellidos`, `Telefono`, `DNI`) VALUES ('Antonio', 'Ruiz', '747896321', '58741296F');
INSERT INTO `bd_taller`.`cliente` (`Nombre`, `Apellidos`, `Telefono`, `DNI`) VALUES ('Maria', 'Fuentes Ortiz', '987456214', '32145897J');
INSERT INTO `bd_taller`.`cliente` (`Nombre`, `Apellidos`, `Telefono`, `DNI`) VALUES ('Nuria', 'Rivas', '665544332', '95162384A');

/* Inserts de propuesta */
INSERT INTO `bd_taller`.`propuesta` (`Usuario`, `Cliente`, `Veh_Matricula`, `Fecha`, `Presupuesto`) VALUES ('1', '1', '0666HHH', '2020-11-04', '3500');
INSERT INTO `bd_taller`.`propuesta` (`Usuario`, `Cliente`, `Veh_Matricula`, `Fecha`, `Presupuesto`) VALUES ('2', '2', '1234BBB', '2020-11-03', '1200');
INSERT INTO `bd_taller`.`propuesta` (`Usuario`, `Cliente`, `Veh_Matricula`, `Fecha`, `Presupuesto`) VALUES ('3', '1', '9876GGG', '2020-11-05', '1500');