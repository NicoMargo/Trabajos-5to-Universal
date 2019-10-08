-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 08-10-2019 a las 13:47:59
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
DROP PROCEDURE IF EXISTS `spAgregarJuguete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAgregarJuguete` (IN `pNombre` VARCHAR(100), IN `pPrecio` FLOAT(10,2), IN `pDescripcion` VARCHAR(200), IN `pFoto` VARCHAR(320))  NO SQL
if(pPrecio>0 and pNombre !="")
THEN
	INSERT into productos(nombre,precio,descripcion,foto) values(pNombre,pPrecio,pDescripcion,pFoto);
end IF$$

DROP PROCEDURE IF EXISTS `spBorrarJuguete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spBorrarJuguete` (IN `pId` INT(11))  NO SQL
delete from productos where id = pId$$

DROP PROCEDURE IF EXISTS `spModificarJuguete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarJuguete` (IN `pId` INT(11), IN `pNombre` VARCHAR(320), IN `pDes` VARCHAR(320), IN `pPrecio` FLOAT, IN `pFoto` VARCHAR(320))  NO SQL
BEGIN
if EXISTS(SELECT id from productos where id = pId)
then
	if(pNombre != "")
    THEN
    	update productos set nombre = pNombre where id = pId;
    end if;
	UPDATE productos set descripcion = pDes,foto = pFoto where id = pId;
    if(pPrecio>0)
    THEN
    	update productos set precio = pPrecio where id = pId;
    end if;
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
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

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
