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
-- Volcando datos para la tabla master.productores: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `productores` DISABLE KEYS */;
INSERT INTO `productores` (`ID`, `NOMBRE`, `APELLIDO`, `DNI`, `MATRICULA`) VALUES
	(1, 'Alberto Andres', 'Melo', NULL, NULL),
	(2, 'Sebastian Rodrigo', 'Melo', NULL, NULL);
/*!40000 ALTER TABLE `productores` ENABLE KEYS */;

-- Volcando datos para la tabla master.users: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`ID`, `USERNAME`, `PASSWORD`, `ENABLED`) VALUES
	(1, 'lisandro', '1234', 1),
	(2, 'vanina', '1234', 1),
	(3, 'sebastian', '1234', 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Volcando datos para la tabla master.user_roles: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`user_role_id`, `username`, `ROLE`) VALUES
	(2, 'lisandro', 'ROLE_ADMIN'),
	(5, 'sebastian', 'ROLE_ADMIN'),
	(4, 'vanina', 'ROLE_ADMIN'),
	(1, 'lisandro', 'ROLE_USER'),
	(6, 'sebastian', 'ROLE_USER'),
	(3, 'vanina', 'ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;

-- Volcando datos para la tabla master.usuarios_productores: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios_productores` DISABLE KEYS */;
INSERT INTO `usuarios_productores` (`ID`, `USER_ID`, `PRODUCTOR_ID`) VALUES
	(2, 3, 1),
	(3, 3, 2),
	(4, 1, 1);
/*!40000 ALTER TABLE `usuarios_productores` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
