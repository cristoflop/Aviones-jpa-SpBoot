-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-02-2021 a las 01:05:46
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `companies`
--

CREATE TABLE `companies` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flies_crewmates`
--

CREATE TABLE `flies_crewmates` (
  `fly_id` bigint(20) NOT NULL,
  `crewmates_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
