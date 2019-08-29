-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 29-08-2019 a las 13:54:56
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

DROP PROCEDURE IF EXISTS `NoticiasAgregar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `NoticiasAgregar` (IN `pTitulo` VARCHAR(50), IN `pCopete` VARCHAR(200), IN `pCuerpo` VARCHAR(400), IN `pImagen` VARCHAR(50), IN `pFecha` DATE)  BEGIN
	if not exists( select idNoticias from noticias where Titulo = pTitulo)
    then
		insert into noticias(Titulo, Copete, Cuerpo, Imagen, Fecha) values(pTitulo, pCopete, pCuerpo, pImagen, pFecha);
    end if;
END$$

DROP PROCEDURE IF EXISTS `NoticiasBorrar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `NoticiasBorrar` (IN `pId` INT)  BEGIN
	delete from noticias where idNoticias = pId;
END$$

DROP PROCEDURE IF EXISTS `NoticiasModificar`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `NoticiasModificar` (IN `pId` INT, IN `pTitulo` VARCHAR(50), IN `pCopete` VARCHAR(200), IN `pCuerpo` VARCHAR(400), IN `pImagen` VARCHAR(50), IN `pFecha` DATE)  BEGIN
	if exists(select Noticias.idNoticias from Noticias where Noticias.IdNoticias = pId)
    then

		if (not exists(select Noticias.idNoticias from Noticias where Noticias.Titulo = pTitulo) and pTitulo != "")
		then
			update noticias set Titulo = pTitulo where idNoticias = pId;
		end if;
        
		if (pCopete != "")
		then
			update noticias set Copete = pCopete where idNoticias = pId;
		end if;
        
		if (pCuerpo != "")
		then
			update noticias set Cuerpo = pCuerpo where idNoticias = pId;
		end if;
        
		if (pImagen != "")
		then
			update noticias set Imagen = pImagen where idNoticias = pId;
		end if;
        
        if (pFecha != 0)
		then
			update noticias set Fecha = pFecha where idNoticias = pId;
		end if;
    end if;
END$$

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
select Noticias.Titulo, Noticias.Copete, Noticias.Cuerpo, Noticias.Imagen, Noticias.Fecha from noticias where noticias.idNoticias = id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticias`
--

DROP TABLE IF EXISTS `noticias`;
CREATE TABLE IF NOT EXISTS `noticias` (
  `idNoticias` int(11) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(50) DEFAULT NULL,
  `Copete` varchar(200) NOT NULL,
  `Cuerpo` varchar(400) DEFAULT NULL,
  `Imagen` varchar(50) DEFAULT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idNoticias`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `noticias`
--

INSERT INTO `noticias` (`idNoticias`, `Titulo`, `Copete`, `Cuerpo`, `Imagen`, `fecha`) VALUES
(1, 'Anuncian nueva temporada de attack on titan', 'Wit Studio, el estudio encargado de animar Attack on Titan, anuncio la cuarta temporada para 2020', 'Ja lol xddd', 'snkNew.jpg', '0005-05-05'),
(2, 'Netflix suma a Evangelion en su catalogo', 'La aclamada empresa de entretenimiento netflix adquirio una lisencia del famoso anime Neon Genesis Evangelion.', 'xd', 'evaNew.jpg', '0000-00-00'),
(3, 'Explosion en el estudio Nro1 de Kyoto Animation', 'El prestigioso estudio de animacion Kyoto Animation, conocido por series animadas como la franquicia de Suzumiya Haruhi, K On, Violet Evergarden, entre otros, sufrio una tragedia en su estudio nro 1. ', 'xd', 'kyoaniNew.jpg', '0005-05-05'),
(15, 'sdfgsgfsdfg', 'sdfgsdfgsdfgsdfg', 'sdfgsdfgsdfgsdfg', 'sdfgsdfgsdfsgd', '0322-04-23'),
(16, 'asdfasdfa', 'asdfasdfasdasdf', 'asdasdfasdfsdf', 'sasdfasdfasdf', '0345-12-31'),
(17, 'asdfasdf', 'asdfasdf', 'ascfsdfaasdfasdfsdf', 'asdfasdf', '0111-11-11'),
(18, '111', '1', '1', '11', '1111-11-11'),
(19, '1', '1', '1', '1', '0011-01-01'),
(14, 'asdffdas', 'asdffasd', 'asdfasdfasdfsdff', 'asdffda', '0345-06-04'),
(12, 'asdf', 'asdf', 'asdf', 'asdf', '0565-03-25'),
(11, 'LOL Ja we', 'asdfasdffas wasd', 'wasdwasdasdffads wad', 'lol xddd wasd', '5485-07-24');

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
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuarios`, `Nombre`, `Clave`, `Correo`) VALUES
(3, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin@admin'),
(2, 'Nombre', 'e2f804a152092eaadaf84613ea13bf7a', 'Mail'),
(4, 'anush', '578ed5a4eecf5a15803abdc49f6152d6', 'hfasd'),
(5, 'Chino', '33c98fed061261dd324ffd388204927b', 'chino@chino'),
(6, 'SuperCool', '35bfc17979c9548d8d67503256026c64', 'supercool@ort');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
