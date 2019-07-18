-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 18-07-2019 a las 12:20:54
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
-- Base de datos: `flechin`
--

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `Loguear`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Loguear` (IN `Nombre` VARCHAR(20), IN `Clave` VARCHAR(20))  NO SQL
SELECT * from usuarios where Nombre = usuarios.Nombre and md5(Clave) = usuarios.Clave$$

DROP PROCEDURE IF EXISTS `Registrar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Registrar` (IN `Nombre` VARCHAR(20), IN `Clave` VARCHAR(20), IN `Correo` VARCHAR(30))  NO SQL
if not EXISTS(SELECT idUsuarios from usuarios where usuarios.Nombre = Nombre)
THEN
	insert into usuarios(usuarios.Nombre,usuarios.Clave,usuarios.Correo) values(Nombre,MD5(Clave), Correo);
	select 1;
    
    ELSE
    select 0;
end if$$

DROP PROCEDURE IF EXISTS `TraerNoticias`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TraerNoticias` ()  NO SQL
select noticias.idNoticias, noticias.Titulo, noticias.Imagen, noticias.fecha from noticias$$

DROP PROCEDURE IF EXISTS `TraerUnaNoticia`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `TraerUnaNoticia` (IN `id` INT(11))  NO SQL
select * from noticias where noticias.idNoticias = id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticias`
--

DROP TABLE IF EXISTS `noticias`;
CREATE TABLE IF NOT EXISTS `noticias` (
  `idNoticias` int(11) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(50) DEFAULT NULL,
  `Copete` varchar(100) NOT NULL,
  `Cuerpo` varchar(300) DEFAULT NULL,
  `Imagen` varchar(50) DEFAULT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idNoticias`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `noticias`
--

INSERT INTO `noticias` (`idNoticias`, `Titulo`, `Copete`, `Cuerpo`, `Imagen`, `fecha`) VALUES
(1, 'Anuncian nueva temporada de attack on titan', 'Wit Studio, el estudio encargado de animar Attack on Titan, anunció la cuarta temporada para 2020', 'xd', 'lol', '0005-05-05'),
(2, 'Netflix suma a Evangelion en su catálogo', 'La aclamada empresa de entretenimiento netflix adquirió una lisencia del famoso anime NeonGenesis Ev', 'xd', 'xddd', '0000-00-00'),
(3, 'xd', 'xd', 'xd', 'xd', '0000-00-00'),
(4, 'xd', 'xd', 'xd', 'xd', '0000-00-00'),
(5, 'xd', '45', '45', '456', '0004-04-04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuarios` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  `Clave` varchar(100) NOT NULL,
  `Correo` varchar(30) NOT NULL,
  PRIMARY KEY (`idUsuarios`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuarios`, `Nombre`, `Clave`, `Correo`) VALUES
(3, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin@admin'),
(2, 'Nombre', 'e2f804a152092eaadaf84613ea13bf7a', 'Mail');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
