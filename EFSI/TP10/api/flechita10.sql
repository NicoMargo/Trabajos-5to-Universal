-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 02-10-2019 a las 12:07:12
-- Versión del servidor: 5.7.21
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `flechita10`
--

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `spModificarUnJuguete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarUnJuguete` (IN `pid` INT(11), IN `pnombre` VARCHAR(320), IN `pdes` VARCHAR(320), IN `pprecio` FLOAT, IN `pfoto` VARCHAR(320))  NO SQL
BEGIN
if EXISTS(SELECT id from productos where id = pid)
then
	UPDATE productos set nombre = pnombre,descripcion = pdes,precio = pprecio,foto = pfoto where id = pid;
end if;
END$$

DROP PROCEDURE IF EXISTS `spTraerJuguetes`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spTraerJuguetes` ()  NO SQL
select * from productos$$

DROP PROCEDURE IF EXISTS `sptraerUnJuguete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sptraerUnJuguete` (IN `pid` INT(11))  NO SQL
if EXISTS(SELECT id from productos where id = pid)
then
	select * from productos where productos.id = pid;
end if$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `foto` varchar(320) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `precio`, `descripcion`, `foto`) VALUES
(1, 'Tren Grande', 2000, 'Super tren made in china', 'lol'),
(2, 'Nerf Rapidfire', 4500, 'Pistola Nerf rapidfire con 35 dardos', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
