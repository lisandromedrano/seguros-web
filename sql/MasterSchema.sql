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

-- Volcando estructura de base de datos para master
CREATE DATABASE IF NOT EXISTS `master` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `master`;


-- Volcando estructura para tabla master.productores
CREATE TABLE IF NOT EXISTS `productores` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(100) DEFAULT NULL,
  `APELLIDO` varchar(100) DEFAULT NULL,
  `DNI` varchar(50) DEFAULT NULL,
  `MATRICULA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla master.productores: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `productores` DISABLE KEYS */;
/*!40000 ALTER TABLE `productores` ENABLE KEYS */;


-- Volcando estructura para tabla master.users
CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(30) DEFAULT NULL,
  `PASSWORD` varchar(30) DEFAULT NULL,
  `ENABLED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla master.users: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`ID`, `USERNAME`, `PASSWORD`, `ENABLED`) VALUES
	(1, 'lisandro', '1234', 1),
	(2, 'vanina', '1234', 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Volcando estructura para tabla master.user_roles
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `ROLE` varchar(30) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`ROLE`,`username`),
  KEY `fk_username_idx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla master.user_roles: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`user_role_id`, `username`, `ROLE`) VALUES
	(2, 'lisandro', 'ROLE_ADMIN'),
	(4, 'vanina', 'ROLE_ADMIN'),
	(1, 'lisandro', 'ROLE_USER'),
	(3, 'vanina', 'ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;


-- Volcando estructura para tabla master.usuarios_productores
CREATE TABLE IF NOT EXISTS `usuarios_productores` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `PRODUCTOR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_UP_PRODUCTORES` (`PRODUCTOR_ID`),
  CONSTRAINT `FK_UP_PRODUCTORES` FOREIGN KEY (`PRODUCTOR_ID`) REFERENCES `productores` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla master.usuarios_productores: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios_productores` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_productores` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
