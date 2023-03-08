-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-03-2023 a las 20:37:37
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `panaderia`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `A_S_ID_Cliente` (IN `IDCLIENTE_V` INT)   BEGIN 
SELECT idcliente, cedula, nombres, apellidos, direccion, 
telefono from cliente WHERE idcliente = IDCLIENTE_V; 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `A_S_ID_Producto` (IN `ID_PRODUCTO_V` INT)   BEGIN 
SELECT * FROM `PRODUCTO` WHERE IDPRODUCTO = ID_PRODUCTO_V; 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `A_S_ID_Registro` (IN `ID_REGISTRO_V` INT)   BEGIN
	SELECT * FROM registro WHERE idRegistro = ID_REGISTRO_V;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETE_CLIENTE` (IN `ID_CLIENTE_V` INT)   BEGIN 
	DELETE FROM CLIENTE WHERE IDCLIENTE = ID_CLIENTE_V;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETE_INSUMOS` (IN `ID_CLIENTE_V` INT)   BEGIN 
	DELETE FROM INSUMOS WHERE IDINSUMO = ID_CLIENTE_V;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETE_PRODUCTO` (IN `ID_CLIENTE_V` INT)   BEGIN 
	DELETE FROM PRODUCTO WHERE IDPRODUCTO = ID_CLIENTE_V;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETE_REGISTRO` (IN `ID_REGISTRO_V` INT)   BEGIN 
DELETE FROM REGISTRO 
WHERE idRegistro = ID_REGISTRO_V;
ENd$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_CLIENTE` (IN `CEDULA_V` VARCHAR(15), IN `NOMBRES_V` VARCHAR(45), IN `APELLIDOS_V` VARCHAR(45), IN `FECHA_V` DATE, IN `DIRECCION_V` VARCHAR(45), IN `TELEFONO_V` VARCHAR(15))   BEGIN
	INSERT INTO CLIENTE(CEDULA, NOMBRES,APELLIDOS,FECHA, DIRECCION, TELEFONO) VALUES
    (CEDULA_V, 
     NOMBRES_V, 
     APELLIDOS_V,
     FECHA_V,
     DIRECCION_V, 
     TELEFONO_V);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_INSUMOS` (IN `NOMBRE_V` VARCHAR(45), IN `PRECIO_V` FLOAT, IN `FECHACOMPRA_V` DATE, IN `CANTIDAD_V` INT, IN `TIPO_V` VARCHAR(45))   BEGIN
INSERT INTO `insumos` (`nombre`, `precio`, `fechaCompra`, `cantidad`, `tipo`) VALUES
(NOMBRE_V,PRECIO_V,FECHACOMPRA_V,CANTIDAD_V,TIPO_V);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_PRODUCTO` (IN `NOMBRE_V` VARCHAR(45), IN `CANTIDAD_V` INT, IN `PRECIO_V` FLOAT, IN `ELABORACION_V` DATE)   BEGIN
INSERT INTO `PRODUCTO` (`NOMBRE`, `CANTIDAD`, `PRECIO`, `ELABORACION`) VALUES
(NOMBRE_V,PRECIO_V,CANTIDAD_V,ELABORACION_V);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_REGISTRO` (IN `FECHA_V` DATE, IN `REG_NUMERO_V` INT, IN `REG_TIPO_V` VARCHAR(15), IN `FKCLIENTE_V` INT, IN `FKPRODUCTO_V` INT)   BEGIN
	INSERT INTO REGISTRO(regFecha, regNumero, regTipo, FKCLIENTE,FKPRODUCTO) values (
    FECHA_V, REG_NUMERO_V, REG_TIPO_V,FKCLIENTE_V, FKPRODUCTO_V
    );
    
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECT_CLIENTES` ()   BEGIN 
SELECT idcliente, cedula, nombres, apellidos, cliente.fecha, direccion, telefono from cliente; 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECT_ID_INSUMO` (IN `ID_INSUMO_V` INT)   BEGIN 
SELECT * FROM `INSUMOS` WHERE idinsumo = ID_INSUMO_V; 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECT_INSUMO` ()   BEGIN 
SELECT * FROM `INSUMOS`; 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECT_PRODUCTOS` ()   BEGIN 
SELECT * FROM `PRODUCTO`; 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECT_REGISTROS` ()   BEGIN
SELECT 
idRegistro ,
regFecha, 
regNumero,
regTipo, 
cliente.NOMBRES, 
cliente.APELLIDOS,
producto.nombre
FROM REGISTRO
INNER JOIN CLIENTE ON REGISTRO.fkCliente = cliente.idCliente
INNER JOIN PRODUCTO ON REGISTRO.fkProducto = producto.idproducto;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_Cliente` (IN `IDCLIENTE_V` INT, IN `CEDULA_V` VARCHAR(15), IN `NOMBRES_V` VARCHAR(45), IN `APELLIDOS_V` VARCHAR(45), IN `DIRECCION_V` VARCHAR(45), IN `TELEFONO_V` VARCHAR(15))   BEGIN
	UPDATE cliente SET 
    cedula = CEDULA_V,
    NOMBRES = NOMBRES_V,
    APELLIDOS = APELLIDOS_V,
	DIRECCION = DIRECCION_V,
    TELEFONO = TELEFONO_V
    WHERE IDCLIENTE = IDCLIENTE_V;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_INSUMOS` (IN `ID_INSUMO_V` INT, IN `NOMBRE_V` VARCHAR(45), IN `PRECIO_V` FLOAT, IN `CANTIDAD_V` INT, IN `TIPO_V` VARCHAR(45))   BEGIN
	UPDATE INSUMOS SET
    nombre = NOMBRE_V,
    precio = PRECIO_V,
    cantidad = CANTIDAD_V,
    tipo = TIPO_V
    WHERE IDINSUMO = ID_INSUMO_V;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_Producto` (IN `ID_PRODUCTO_V` INT, IN `nombre` VARCHAR(30), IN `cantidad` VARCHAR(30), IN `precio` VARCHAR(30), IN `Elaboracion` VARCHAR(30))   BEGIN
	UPDATE producto SET
    nombre= nombre,
    cantidad = cantidad,
    precio = precio,
    Elaboracion = Elaboracion
    WHERE IDPRODUCTO = ID_PRODUCTO_V;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATE_REGISTRO` (IN `ID_REGISTRO_V` INT, IN `FECHA_V` DATE, IN `REG_NUMERO_V` INT, IN `REG_TIPO_V` VARCHAR(15))   BEGIN 
    UPDATE  REGISTRO SET 
    regFecha=FECHA_V, 
    regNumero=REG_NUMERO_V,
    regTipo=REG_TIPO_V
    WHERE idRegistro = ID_REGISTRO_V;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `cedula` varchar(15) NOT NULL,
  `NOMBRES` varchar(45) NOT NULL,
  `APELLIDOS` varchar(45) NOT NULL,
  `FECHA` date NOT NULL,
  `DIRECCION` varchar(45) NOT NULL,
  `TELEFONO` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `cedula`, `NOMBRES`, `APELLIDOS`, `FECHA`, `DIRECCION`, `TELEFONO`) VALUES
(6, '1723382594', 'Richard Anthonys', 'Perez Palacioss', '2023-02-06', 'Quito, Ecuadors', '0980868422'),
(7, '123456789', 'nnn123', 'aaaaAAAA', '2023-02-06', 'dddd', '098756321'),
(8, '123456789', 'www', 'pppp', '2023-02-06', 'dire', '01234567980'),
(9, '123456789000', 'nnn00', 'aaaa00', '2023-02-06', 'dddd00', '09875632100'),
(10, '123456789000', 'nnn00', 'aaaa00', '2023-02-06', 'dddd00', '09875632100'),
(11, '123456789000', 'nnn00', 'aaaa00', '2023-02-06', 'dddd00', '09875632100'),
(12, '1478965230', 'Pep', 'Guardiola', '2023-03-07', 'PepDireccion', '0987456321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumos`
--

CREATE TABLE `insumos` (
  `idinsumo` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `fechaCompra` date DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `insumos`
--

INSERT INTO `insumos` (`idinsumo`, `nombre`, `precio`, `fechaCompra`, `cantidad`, `tipo`) VALUES
(2, 'azucar', 10, '2022-09-10', 2, 'rico'),
(3, 'saleeee', 10, '2022-09-10', 4, 'sabro'),
(4, 'leche', 10, '2022-09-10', 5, 'vaquita'),
(5, 'huevos', 10, '2022-09-10', 5, 'ninguno'),
(6, 'leche', 10, '2022-09-15', 5, 'vaquita'),
(7, 'sal', 10, '2022-09-15', 5, 'sabro'),
(8, 'azucar', 10, '2022-09-15', 2, 'rico'),
(9, 'harina', 48, '2022-09-15', 1, 'oso'),
(10, 'huevos', 1, '2022-09-15', 5, 'ninguno'),
(11, 'nOMBRE', 10.45, '2023-02-06', 450, 'RICO'),
(12, 'harina', 100000, '2023-02-21', 1000, 'oso'),
(13, 'HHHHH', 8, '2023-03-07', 5555, 'malo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `cantidad` varchar(30) DEFAULT NULL,
  `precio` varchar(30) DEFAULT NULL,
  `Elaboracion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `nombre`, `cantidad`, `precio`, `Elaboracion`) VALUES
(2, 'empanadaaaaa', '12000', '18.0', '2022-10-10'),
(3, 'pan casa', '15', '20', '2022-10-10'),
(4, 'empanada', '10', '16', '2022-10-11'),
(5, 'empanda', '15', '20', '2022-10-11'),
(6, 'pan casa', '10', '15', '2022-10-11'),
(7, 'pan casa', '14', '14', '2022-10-11'),
(8, 'pan casa', '12', '11', '2022-10-11'),
(9, 'pastel', '1', '20', '2022-10-11'),
(10, 'pastel', '1', '20', '2022-10-11'),
(11, 'Producto', '100', '500', '2023-02-06'),
(12, 'empanada', '18', '12', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro`
--

CREATE TABLE `registro` (
  `idRegistro` int(11) NOT NULL,
  `regFecha` date NOT NULL,
  `regNumero` int(11) NOT NULL,
  `regTipo` varchar(15) NOT NULL,
  `fkCliente` int(11) NOT NULL,
  `fkProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registro`
--

INSERT INTO `registro` (`idRegistro`, `regFecha`, `regNumero`, `regTipo`, `fkCliente`, `fkProducto`) VALUES
(4, '2023-03-08', 555, 'Gasto', 5, 5),
(5, '2023-03-08', 10, '110', 6, 8),
(6, '2023-03-08', 10, '110', 6, 8),
(7, '2023-03-08', 10, '110', 6, 8),
(8, '2023-03-08', 4, '60', 12, 6),
(9, '2023-03-08', 5, '100', 12, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `insumos`
--
ALTER TABLE `insumos`
  ADD PRIMARY KEY (`idinsumo`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idproducto`);

--
-- Indices de la tabla `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`idRegistro`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `insumos`
--
ALTER TABLE `insumos`
  MODIFY `idinsumo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idproducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `registro`
--
ALTER TABLE `registro`
  MODIFY `idRegistro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
