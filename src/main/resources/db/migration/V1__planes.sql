-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-02-2021 a las 00:17:36
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `planes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `airports`
--

CREATE TABLE `airports` (
  `iata` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `airports`
--

INSERT INTO `airports` (`iata`, `city`, `country`, `name`) VALUES
('BCN', 'Barcelona', 'Spain', 'El Prat'),
('LCY', 'London', 'England', 'London City Airport'),
('MAD', 'Madrid', 'Spain', 'Barajas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `companies`
--

CREATE TABLE `companies` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `companies`
--

INSERT INTO `companies` (`id`, `name`) VALUES
(1, 'Iberia'),
(2, 'Fly Emirates'),
(3, 'American Airlines'),
(4, 'Mechanics Top'),
(5, 'Airbus Getafe'),
(6, 'Airbus Illescas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `crewmates`
--

CREATE TABLE `crewmates` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `crewmates`
--

INSERT INTO `crewmates` (`id`, `name`, `surname`, `position`, `company_id`) VALUES
('0001', 'Cristofer', 'Lopez', 'COPILOT', 1),
('0002', 'Juan', 'Avila', 'COMMANDER', 2),
('0003', 'Francisco', 'Calero', 'COMMANDER', 1),
('0004', 'Sergio', 'Manzanaro', 'PURSER', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flies`
--

CREATE TABLE `flies` (
  `id` bigint(20) NOT NULL,
  `duration` double NOT NULL,
  `start_date` date DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `destination_iata` varchar(255) DEFAULT NULL,
  `plane_plate` varchar(255) DEFAULT NULL,
  `source_iata` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `flies`
--

INSERT INTO `flies` (`id`, `duration`, `start_date`, `start_time`, `company_id`, `destination_iata`, `plane_plate`, `source_iata`) VALUES
(7, 1.2, '2020-05-10', '09:00:00', 1, 'BCN', '0001', 'MAD'),
(8, 2.43, '2020-05-27', '12:00:00', 1, 'LCY', '0002', 'MAD'),
(9, 3.1, '2020-06-18', '18:00:00', 2, 'BCN', '0001', 'LCY'),
(10, 3.1, '2020-06-18', '09:00:00', 3, 'BCN', '0001', 'LCY');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flies_crewmates`
--

CREATE TABLE `flies_crewmates` (
  `fly_id` bigint(20) NOT NULL,
  `crewmates_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `flies_crewmates`
--

INSERT INTO `flies_crewmates` (`fly_id`, `crewmates_id`) VALUES
(7, '0001'),
(7, '0003'),
(7, '0004'),
(8, '0002'),
(8, '0003'),
(9, '0001'),
(9, '0004'),
(10, '0002');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(1001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mechanics`
--

CREATE TABLE `mechanics` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `incorporation_year` int(11) NOT NULL,
  `training` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mechanics`
--

INSERT INTO `mechanics` (`id`, `name`, `surname`, `incorporation_year`, `training`, `company_id`) VALUES
('0001', 'Ernesto', 'Vivar', 2020, 'CAREER', 4),
('0002', 'David', 'Salido', 2020, 'CAREER', 4),
('0003', 'Luis', 'Fernandez', 2020, 'CAREER', 5),
('0004', 'Micael', 'Gallego', 2020, 'CAREER', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `planes`
--

CREATE TABLE `planes` (
  `plate` varchar(255) NOT NULL,
  `flight_hours` int(11) NOT NULL,
  `maker` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `planes`
--

INSERT INTO `planes` (`plate`, `flight_hours`, `maker`, `model`) VALUES
('0001', 5000, 'Airbus', 'A320'),
('0002', 5000, 'British Airways', 'Boeing 747'),
('0003', 5000, 'EEUU', 'F-18'),
('0004', 2000, 'Heinkel', 'He 280'),
('0005', 2000, 'Arado', 'Ar 430');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revisions`
--

CREATE TABLE `revisions` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `init_date` date DEFAULT NULL,
  `revision_type` varchar(255) DEFAULT NULL,
  `spent_hours` int(11) NOT NULL,
  `airport_iata` varchar(255) DEFAULT NULL,
  `mechanic_in_charge_id` varchar(255) DEFAULT NULL,
  `plane_plate` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `revisions`
--

INSERT INTO `revisions` (`id`, `description`, `end_date`, `init_date`, `revision_type`, `spent_hours`, `airport_iata`, `mechanic_in_charge_id`, `plane_plate`) VALUES
(11, 'Periodic revision of January', '2020-01-29', '2020-01-27', 'PERIODIC', 23, 'MAD', '0001', '0001'),
(12, 'Left wing reparation', '2020-02-15', '2020-02-10', 'REPARATION', 40, 'MAD', '0002', '0001');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `airports`
--
ALTER TABLE `airports`
  ADD PRIMARY KEY (`iata`);

--
-- Indices de la tabla `companies`
--
ALTER TABLE `companies`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `crewmates`
--
ALTER TABLE `crewmates`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4s6k7y583i7vv3kihkuvovg4p` (`company_id`);

--
-- Indices de la tabla `flies`
--
ALTER TABLE `flies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfnv4mptex5a4hp7w07whl7dii` (`company_id`),
  ADD KEY `FKkwu09dkp7aadgltdfbcncujnp` (`destination_iata`),
  ADD KEY `FKnwqsihkhv6d1w3q4cjrn3ft26` (`plane_plate`),
  ADD KEY `FKs46760ef6mt6xbyj5q2nvuodh` (`source_iata`);

--
-- Indices de la tabla `flies_crewmates`
--
ALTER TABLE `flies_crewmates`
  ADD KEY `FKhptjuh8tkhjjau2xjaky5mnoh` (`crewmates_id`),
  ADD KEY `FKe8fqrlbll2mqfima82e3u67h0` (`fly_id`);

--
-- Indices de la tabla `mechanics`
--
ALTER TABLE `mechanics`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiip8lwe7klh4domnyl1blad3e` (`company_id`);

--
-- Indices de la tabla `planes`
--
ALTER TABLE `planes`
  ADD PRIMARY KEY (`plate`);

--
-- Indices de la tabla `revisions`
--
ALTER TABLE `revisions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjx3ww67jwk4hhgkfc5meusb7v` (`airport_iata`),
  ADD KEY `FKl6xv250jputt1wwdc5pb9a6tl` (`mechanic_in_charge_id`),
  ADD KEY `FKjlmd0ijcj7qavpo4jttu3mhtr` (`plane_plate`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `crewmates`
--
ALTER TABLE `crewmates`
  ADD CONSTRAINT `FK4s6k7y583i7vv3kihkuvovg4p` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`);

--
-- Filtros para la tabla `flies`
--
ALTER TABLE `flies`
  ADD CONSTRAINT `FKfnv4mptex5a4hp7w07whl7dii` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`),
  ADD CONSTRAINT `FKkwu09dkp7aadgltdfbcncujnp` FOREIGN KEY (`destination_iata`) REFERENCES `airports` (`iata`),
  ADD CONSTRAINT `FKnwqsihkhv6d1w3q4cjrn3ft26` FOREIGN KEY (`plane_plate`) REFERENCES `planes` (`plate`),
  ADD CONSTRAINT `FKs46760ef6mt6xbyj5q2nvuodh` FOREIGN KEY (`source_iata`) REFERENCES `airports` (`iata`);

--
-- Filtros para la tabla `flies_crewmates`
--
ALTER TABLE `flies_crewmates`
  ADD CONSTRAINT `FKe8fqrlbll2mqfima82e3u67h0` FOREIGN KEY (`fly_id`) REFERENCES `flies` (`id`),
  ADD CONSTRAINT `FKhptjuh8tkhjjau2xjaky5mnoh` FOREIGN KEY (`crewmates_id`) REFERENCES `crewmates` (`id`);

--
-- Filtros para la tabla `mechanics`
--
ALTER TABLE `mechanics`
  ADD CONSTRAINT `FKiip8lwe7klh4domnyl1blad3e` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`);

--
-- Filtros para la tabla `revisions`
--
ALTER TABLE `revisions`
  ADD CONSTRAINT `FKjlmd0ijcj7qavpo4jttu3mhtr` FOREIGN KEY (`plane_plate`) REFERENCES `planes` (`plate`),
  ADD CONSTRAINT `FKjx3ww67jwk4hhgkfc5meusb7v` FOREIGN KEY (`airport_iata`) REFERENCES `airports` (`iata`),
  ADD CONSTRAINT `FKl6xv250jputt1wwdc5pb9a6tl` FOREIGN KEY (`mechanic_in_charge_id`) REFERENCES `mechanics` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
