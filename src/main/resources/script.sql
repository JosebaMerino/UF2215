-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.7.24 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para uf2215-joseba
DROP DATABASE IF EXISTS `uf2215-joseba`;
CREATE DATABASE IF NOT EXISTS `uf2215-joseba` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `uf2215-joseba`;

-- Volcando estructura para tabla uf2215-joseba.autor
DROP TABLE IF EXISTS `autor`;
CREATE TABLE IF NOT EXISTS `autor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla uf2215-joseba.autor: ~4 rows (aproximadamente)
DELETE FROM `autor`;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` (`id`, `nombre`) VALUES
	(2, 'Juan Bas'),
	(1, 'Patrick'),
	(3, 'Rubius'),
	(4, 'York');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;

-- Volcando estructura para tabla uf2215-joseba.libro
DROP TABLE IF EXISTS `libro`;
CREATE TABLE IF NOT EXISTS `libro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `idAutor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_autor` (`idAutor`),
  CONSTRAINT `FK_autor` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla uf2215-joseba.libro: ~5 rows (aproximadamente)
DELETE FROM `libro`;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` (`id`, `nombre`, `idAutor`) VALUES
	(1, 'El nombre del viento', 1),
	(2, 'Voracidad', 2),
	(3, 'Escuela de gamers', 3),
	(4, 'Fuego y sangre', 4),
	(5, 'Juego de tronos', 4);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
