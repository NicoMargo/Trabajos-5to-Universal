-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 03-10-2019 a las 13:40:21
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
-- Base de datos: `flecha10`
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
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `precio`, `descripcion`, `foto`) VALUES
(1, 'Nerf rapidstrike', 8900, 'Super tren made in china', '1'),
(2, 'Nerf Super Trooper', 4500, 'Pistola Nerf rapidfire con 35 dardos', '2'),
(3, 'Nerf Mega Rotofury', 4500, 'descripcion', '3'),
(4, 'Nerf Rapidfire', 3800, 'Super tren made in china', '4'),
(5, 'Nerf Retaliator', 4200, 'descripcion', '5'),
(6, 'Nerf Maverick', 2500, 'Super tren made in china', '6');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
