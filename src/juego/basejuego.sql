-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2016 a las 19:46:14
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juego`
--
CREATE DATABASE IF NOT EXISTS `juego` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `juego`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `Nick` varchar(20) NOT NULL,
  `Contraseña` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Nombre con los jugadores';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `ganador` varchar(20) NOT NULL,
  `perdedor` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='muestra quien es el que gana/pierde';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidades`
--

CREATE TABLE `unidades` (
  `Nombre` varchar(50) NOT NULL,
  `Faccion` varchar(10) NOT NULL,
  `Combate` int(3) NOT NULL,
  `Fuerza` int(3) NOT NULL,
  `Defensa` int(3) NOT NULL,
  `Num_Ataques` int(3) NOT NULL,
  `Heridas` int(3) NOT NULL,
  `Tipo_Unidad` varchar(20) NOT NULL,
  `Coste` int(2) NOT NULL,
  `Ruta_Img` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Características de las unidades';

--
-- Volcado de datos para la tabla `unidades`
--

INSERT INTO `unidades` (`Nombre`, `Faccion`, `Combate`, `Fuerza`, `Defensa`, `Num_Ataques`, `Heridas`, `Tipo_Unidad`, `Coste`, `Ruta_Img`) VALUES
('Guerrero de minas Thirith', 'Bien', 3, 3, 5, 1, 1, 'Infantería', 7, './imagenes/bien/guerrminas.jpg'),
('Caballero de Minas Thirith', 'Bien', 3, 3, 5, 2, 2, 'Caballería', 15, './imagenes/bien/caballerominas.jpg'),
('Guardia del Patio del Manantial', 'Bien', 4, 3, 6, 1, 1, 'Infantería', 10, './imagenes/bien/guardiapatio.jpg'),
('Guardia de la ciudadela', 'Bien', 4, 3, 5, 1, 1, 'Infantería', 8, './imagenes/bien/guardiapatio.jpg'),
('Caballero de Dol Amroth', 'Bien', 4, 3, 6, 1, 1, 'Infantería', 9, './imagenes/bien/caballerodol.jpg'),
('Capitán de Minas Thirith', 'Bien', 4, 4, 6, 2, 2, 'Infantería', 17, './imagenes/bien/capitanminas.jpg'),
('Faramir', 'Bien', 5, 4, 5, 2, 2, 'Infantería', 20, './imagenes/bien/faramir.jpg'),
('Berengond', 'Bien', 4, 4, 6, 1, 1, 'Infantería', 11, './imagenes/bien/beregond.jpg'),
('Imrahil', 'Bien', 6, 4, 7, 3, 3, 'Infantería', 27, './imagenes/bien/imrahil.jpg'),
('Damrod', 'Bien', 4, 4, 5, 1, 1, 'Infantería', 9, './imagenes/bien/damrod.jpg'),
('Rey de los hombres', 'Bien', 5, 4, 4, 2, 2, 'Infantería', 16, './imagenes/bien/reyhombres.jpg'),
('Capitán de Dol Amroth', 'Bien', 4, 4, 7, 2, 2, 'Infantería', 18, './imagenes/bien/capitandol.jpg'),
('Shagrat', 'Mal', 5, 5, 5, 2, 2, 'Infantería', 18, './imagenes/mal/shagrot.jpg'),
('Gorbag', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, './imagenes/mal/gorbag.jpg'),
('Capitán Orco', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, './imagenes/mal/capitanorco.jpg'),
('Capitán Uruk-hai', 'Mal', 5, 5, 5, 2, 2, 'Infantería', 17, './imagenes/mal/capitanuruk.jpg'),
('Jefe Troll', 'Mal', 7, 7, 8, 3, 3, 'Monstruo', 90, './imagenes/mal/jefetroll.jpg'),
('Guerrero Orco', 'Mal', 3, 3, 4, 1, 1, 'Infantería', 5, './imagenes/mal/guerreroorco.jpg'),
('Orco de Morannon', 'Mal', 3, 4, 5, 1, 1, 'Infantería', 7, './imagenes/mal/orcomoranon.jpg'),
('Jinete de Huargo', 'Mal', 3, 4, 4, 2, 2, 'Caballería', 14, './imagenes/mal/jinetehuargo.jpg'),
('Uruk-hai de Mordor', 'Mal', 4, 4, 4, 1, 1, 'Infantería', 8, './imagenes/mal/urukmordor.jpg'),
('Grishnákh', 'Mal', 4, 4, 5, 2, 2, 'Infantería', 15, './imagenes/mal/grisnackh.jpg'),
('Troll de Mordor', 'Mal', 7, 7, 7, 3, 3, 'Monstruo', 70, './imagenes/mal/trollmordor.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`Nick`);

--
-- Indices de la tabla `unidades`
--
ALTER TABLE `unidades`
  ADD PRIMARY KEY (`Nombre`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
