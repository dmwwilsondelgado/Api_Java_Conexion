-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 20-10-2021 a las 23:03:03
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `cod_cargo` int(11) NOT NULL,
  `nom_cargo` varchar(25) DEFAULT NULL,
  `salario_cargo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`cod_cargo`, `nom_cargo`, `salario_cargo`) VALUES
(102, 'Gerente geneal', 3500000),
(103, 'Contable Administrativo', 2300000),
(107, 'aprendiz contrato', 120000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `cod_dprt` int(11) NOT NULL,
  `nombre_dpart` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`cod_dprt`, `nombre_dpart`) VALUES
(1, 'Compras'),
(2, 'Gerencia'),
(3, 'Contabilidad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `cod_empleado` int(11) NOT NULL,
  `nom_empleado` varchar(25) NOT NULL,
  `ape_empleado` varchar(25) NOT NULL,
  `dir_empleado` varchar(25) NOT NULL,
  `email_empleado` varchar(25) NOT NULL,
  `fch_nac_empleado` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`cod_empleado`, `nom_empleado`, `ape_empleado`, `dir_empleado`, `email_empleado`, `fch_nac_empleado`) VALUES
(63502703, 'Maria', 'Rojas', 'calle9', 'mrojas@empresa.com.co', '1980-04-12'),
(771919456, 'Zergio', 'Tabares', 'calle11', 'Ztabares@empresa.com.co', '1986-02-02'),
(1098765438, 'Linda', 'Arias', 'calle10', 'larias@empresa.com.co', '1970-08-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_laboral`
--

CREATE TABLE `historial_laboral` (
  `cod_historia` int(11) NOT NULL,
  `cod_emp_historia` int(11) NOT NULL,
  `cod_dprt_historia` int(11) NOT NULL,
  `cod_cargo_historia` int(11) NOT NULL,
  `fecha_inicio_contrato` date DEFAULT NULL,
  `fecha_final_contrato` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `historial_laboral`
--

INSERT INTO `historial_laboral` (`cod_historia`, `cod_emp_historia`, `cod_dprt_historia`, `cod_cargo_historia`, `fecha_inicio_contrato`, `fecha_final_contrato`) VALUES
(1, 63502703, 1, 101, '2013-11-01', '2014-09-02'),
(2, 63502703, 1, 101, '2013-11-01', '2014-09-02'),
(3, 771919456, 2, 102, '2011-09-07', '2014-09-09'),
(4, 1098765438, 3, 103, '2013-09-02', '2014-09-09');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`cod_cargo`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`cod_dprt`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`cod_empleado`);

--
-- Indices de la tabla `historial_laboral`
--
ALTER TABLE `historial_laboral`
  ADD PRIMARY KEY (`cod_historia`),
  ADD KEY `cod_emp_historia` (`cod_emp_historia`),
  ADD KEY `cod_dprt_historia` (`cod_dprt_historia`),
  ADD KEY `cod_cargo_historia` (`cod_cargo_historia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial_laboral`
--
ALTER TABLE `historial_laboral`
  MODIFY `cod_historia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
