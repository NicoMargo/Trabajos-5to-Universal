-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 05-09-2019 a las 13:23:41
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `NoticiasAgregar` (IN `pTitulo` VARCHAR(100), IN `pCopete` VARCHAR(400), IN `pCuerpo` VARCHAR(1600), IN `pImagen` VARCHAR(400), IN `pFecha` DATE)  BEGIN
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `NoticiasModificar` (IN `pId` INT, IN `pTitulo` VARCHAR(100), IN `pCopete` VARCHAR(400), IN `pCuerpo` VARCHAR(1600), IN `pImagen` VARCHAR(400), IN `pFecha` DATE)  BEGIN
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
  `Titulo` varchar(100) DEFAULT NULL,
  `Copete` varchar(400) NOT NULL,
  `Cuerpo` varchar(1600) DEFAULT NULL,
  `Imagen` varchar(400) DEFAULT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idNoticias`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `noticias`
--

INSERT INTO `noticias` (`idNoticias`, `Titulo`, `Copete`, `Cuerpo`, `Imagen`, `fecha`) VALUES
(1, 'Anuncian nueva temporada de attack on titan', 'El dÃ©cimo y Ãºltimo episodio del segundo curso de la tercera temporada de anime Shingeki no Kyojin terminÃ³ con un anuncio el lunes de que la temporada final se emitirÃ¡ en el otoÃ±o de 2020 en NHK General.', 'Shingeki no Kyojin adapta el manga post-apocalÃ­ptico de fantasÃ­a de Hajime Isayama del mismo tÃ­tulo, que comenzÃ³ su serializaciÃ³n en la revista Bessatsu Shounen en septiembre de 2009. Kodansha publicÃ³ el volumen 28 el 9 de abril, con el volumen 29 previsto para un lanzamiento el 9 de agosto. El manga tiene 90 millones de copias acumuladas de sus volÃºmenes compilados en circulaciÃ³n en todo el mundo.\n\nProducida por Wit Studio, la primera temporada de anime se estrenÃ³ en la primavera de 2013. La preproducciÃ³n de la segunda temporada comenzÃ³ en 2014, que se emitiÃ³ en la primavera de 2017. La tercera temporada se estrenÃ³ en el verano de 2018, y su segunda mitad se estrenÃ³ el 29 de abril.', 'https://e.rpp-noticias.io/normal/2019/06/30/190219_809014.jpg', '0005-05-05'),
(2, 'Netflix suma a Evangelion en su catalogo', 'La aclamada empresa de entretenimiento netflix adquirio una lisencia del famoso anime Neon Genesis Evangelion.', 'xd', 'https://media.diariopopular.com.ar/adjuntos/143/imagenes/005/949/0005949778.jpg', '0004-04-04'),
(3, 'Explosion en el estudio Nro1 de Kyoto Animation', 'El prestigioso estudio de animacion Kyoto Animation, conocido por series animadas como la franquicia de Suzumiya Haruhi, K On, Violet Evergarden, entre otros, sufrio una tragedia en su estudio nro 1. ', 'Un presunto ataque incendiario en el edificio nÃºmero 1 de Studio de la compaÃ±Ã­a de producciÃ³n de animaciÃ³n Kyoto Animation el jueves dejÃ³ al menos 33 muertos y 36 heridos mÃ¡s. Es el incidente de incendio provocado mÃ¡s mortal de JapÃ³n desde 1989 y su incidente de incendio mÃ¡s mortal desde 2001, segÃºn la policÃ­a. Un hombre de 41 aÃ±os, que se encuentra entre los heridos, ha sido identificado como sospechoso.\n\nSegÃºn un informe de incidente del jueves por la noche de la Agencia de Manejo de Incendios y Desastres, se encontraron dos contenedores de gasolina de 20 litros afuera en la calle cerca del lugar del incendio. La policÃ­a dice que el sospechoso admitiÃ³ haber encendido gasolina mientras lo transportaban fuera de la escena. EstÃ¡ pendiente de interrogatorio mientras recibe tratamiento en el hospital. Los medios japoneses informan que testigos oyeron al hombre decir \"Â¡Vete a morir!\" mientras incendia el vestÃ­bulo del edificio.\n\nLos informes dicen que unas 70 personas estaban dentro del edificio de tres pisos cuando comenzÃ³ el incendio aproximadamente a las 10:35 a.m., hora local. Las agencias locales de bomberos enviaron 30 vehÃ­culos a la escena, y el incendio finalmente se extinguiÃ³ casi cinco horas despuÃ©s. Los bomberos encontraron la puerta de la azotea cerrada, pero no estaba cerrada. Las actividades de bomberos y rescate han terminado desde entonces, y no queda nadie dentro del edificio.\n', 'https://i.kinja-img.com/gawker-media/image/upload/s--m_LrhNrX--/c_scale,f_auto,fl_progressive,q_80,w_800/ab9zrdhny0gjssk8kpdv.png', '0005-05-05'),
(21, 'Anuncian adaptacion anime del manga de terror Uzumaki', 'Una adaptacion de anime del manga sobrenatural de terror de Junji Ito, Uzumaki (Uzumaki: Spiral into Horror) fue anunciada el viernes en su panel de Crunchyroll Expo.\n', 'Hiroshi Nagahama (Mushishi, Aku no Hana) dirige la serie en el estudio de animaciÃ³n Production I.G, con la partitura musical de Colin Stetson (Hereditario). La mini serie de anime de cuatro episodios debutarÃ¡ en el bloque de programaciÃ³n Toonami de Adult Swim en 2020, antes del estreno japonÃ©s.', 'https://img.vixdata.io/pd/jpg-large/es/sites/default/files/uzumaki-portada-manga-anime_0.jpg', '2019-09-04'),
(22, 'Se anuncia la nueva OVA de Kishibe Rohans Struggle', 'En el evento especial JoJo no Kimyou na Bouken: Ougon no Kaze - Esperienza d oro el domingo, se anunciÃ³ un nuevo episodio para el video animado original Kishibe Rohan wa Ugokanai (AsÃ­ hablÃ³ Kishibe Rohan). Warner Bros. Japan abriÃ³ un sitio web teaser para el episodio, revelando un avance del anuncio.', 'El nuevo episodio adaptarÃ¡ los capÃ­tulos \"Zange-shitsu\" (At a Confessional) y \"The Run\" del primer y segundo volumen de la serie de manga spin-off de Hirohiko Araki del mismo tÃ­tulo.\n\nUna proyecciÃ³n especial para el episodio se llevarÃ¡ a cabo en seis ciudades, comenzando con el TFT Hall 1000 en Tokio el 8 de diciembre. Las siguientes proyecciones tendrÃ¡n lugar en Zepp Nagoya en Aichi el 19 de enero, Mielparque Hall en Osaka el 9 de febrero, Uenogakuen Hall en Hiroshima el 23 de febrero, Sendai GIGS en Miyagi el 8 de marzo y Sonic City Hall en Saitama el 29 de marzo. Takahiro Sakurai, la voz del protagonista titular Kishibe Rohan, asistirÃ¡ a cada uno de los seis eventos con otros invitados. La venta anticipada de boletos para las proyecciones comenzarÃ¡ el 2 de octubre.', 'https://cdn.myanimelist.net/s/common/uploaded_files/1566147847-f42b77cb1fa28626fd8de09d6fcb1bf5.jpeg', '2019-08-31'),
(23, 'Se anuncia la tercera temporada de  Agresive Retsuko', 'Una tercera temporada para la serie de anime net Aggressive Retsuko (Aggretsuko) ha sido autorizada para la producciÃ³n. El anuncio se hizo en la 20a ExposiciÃ³n de cÃ³mics de Taipei el lunes.', 'El director Rareko volverÃ¡ a dirigir la tercera temporada. La fecha de lanzamiento para la nueva temporada en Netflix se revelarÃ¡ en una fecha posterior.\n\nBasado en la mascota del panda rojo de Sanrio, Retsuko, el primer anime se emitiÃ³ en 100 episodios de un minuto entre abril de 2016 y marzo de 2018 en el programa Ousama no Brunch de TBS. La primera y segunda temporada del anime exclusivo de Netflix se transmitiÃ³ en todo el mundo el 20 de abril del aÃ±o pasado y el 14 de junio, respectivamente. El primer anime corto y las dos temporadas de Netflix fueron dirigidos por Rareko en Fanworks.', 'https://fsmedia.imgix.net/29/84/37/e1/cdbd/46f3/9e31/83cf4989ce90/its-time-for-retsuko-to-go-full-rage-panda.jpeg?rect=0%2C115%2C958%2C478&auto=format%2Ccompress&dpr=2&w=650', '2019-08-24'),
(24, 'xd', 'xd', 'xd', 'xd', '0002-03-21');

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
