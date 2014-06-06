-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.15 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para seguros
CREATE DATABASE IF NOT EXISTS `seguros` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `seguros`;


-- Volcando estructura para tabla seguros.clientes
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `observaciones` varchar(100) DEFAULT NULL,
  `f_nacimiento` datetime DEFAULT NULL,
  `DNICUIT` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla seguros.companias
DROP TABLE IF EXISTS `companias`;
CREATE TABLE IF NOT EXISTS `companias` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla seguros.pagos
DROP TABLE IF EXISTS `pagos`;
CREATE TABLE IF NOT EXISTS `pagos` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_POLIZA` int(10) unsigned DEFAULT NULL,
  `ID_COMPANIA` int(10) unsigned DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `IMPORTE` double DEFAULT NULL,
  `TIPO_PAGO` varchar(1) DEFAULT NULL,
  `CONCEPTO` varchar(100) DEFAULT NULL,
  `NRO_RECIBO` int(11) DEFAULT NULL,
  `FECHA_VENCIMIENTO` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PAGO_COMPANIA` (`ID_COMPANIA`),
  KEY `FK_PAGO_POLIZA` (`ID_POLIZA`),
  CONSTRAINT `FK_PAGO_COMPANIA` FOREIGN KEY (`ID_COMPANIA`) REFERENCES `companias` (`ID`),
  CONSTRAINT `FK_PAGO_POLIZA` FOREIGN KEY (`ID_POLIZA`) REFERENCES `polizas` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla seguros.polizas
DROP TABLE IF EXISTS `polizas`;
CREATE TABLE IF NOT EXISTS `polizas` (
  `ID` int(10) unsigned NOT NULL,
  `id_cliente` int(10) unsigned DEFAULT NULL,
  `id_compania` int(10) unsigned DEFAULT NULL,
  `SECCION_ID` int(10) unsigned DEFAULT NULL,
  `NRO_POLIZA` varchar(20) DEFAULT NULL,
  `ENDOSO` varchar(20) DEFAULT NULL,
  `OBSERVACIONES` varchar(100) DEFAULT NULL,
  `F_VIG_DESDE` datetime DEFAULT NULL,
  `F_VIG_HASTA` datetime DEFAULT NULL,
  `CANT_CUOTAS` int(11) DEFAULT NULL,
  `PRIMA` double DEFAULT NULL,
  `SUMA` double DEFAULT NULL,
  `PREMIO` double DEFAULT NULL,
  `TIPO_POLIZA` varchar(5) DEFAULT NULL,
  `BIEN_A_CUBRIR` varchar(40) DEFAULT NULL,
  `MONEDA` varchar(3) DEFAULT NULL,
  `RIESGO_A_CUBRIR` varchar(50) DEFAULT NULL,
  `CLASE_POLIZA` varchar(1) DEFAULT NULL,
  `UBICACION` varchar(100) DEFAULT NULL,
  `NRO_CHASIS` varchar(50) DEFAULT NULL,
  `NRO_MOTOR` varchar(50) DEFAULT NULL,
  `TIPO_COBERTURA` varchar(50) DEFAULT NULL,
  `f_registracion` datetime DEFAULT NULL,
  `ORDEN` int(11) DEFAULT NULL,
  `PATENTE` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_POLIZA_CLIENTE` (`id_cliente`),
  KEY `FK_POLIZA_COMPANIA` (`id_compania`),
  KEY `FK_POLIZA_SECCION` (`SECCION_ID`),
  CONSTRAINT `FK_POLIZA_CLIENTE` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`),
  CONSTRAINT `FK_POLIZA_COMPANIA` FOREIGN KEY (`id_compania`) REFERENCES `companias` (`ID`),
  CONSTRAINT `FK_POLIZA_SECCION` FOREIGN KEY (`SECCION_ID`) REFERENCES `secciones` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla seguros.secciones
DROP TABLE IF EXISTS `secciones`;
CREATE TABLE IF NOT EXISTS `secciones` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_COMPANIA` int(11) DEFAULT NULL,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `codigo` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
