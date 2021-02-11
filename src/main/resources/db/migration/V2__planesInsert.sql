-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-02-2021 a las 01:06:01
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

--
-- Volcado de datos para la tabla `airports`
--

INSERT INTO `airports` (`iata`, `city`, `country`, `name`) VALUES
('BCN', 'Barcelona', 'Spain', 'El Prat'),
('LCY', 'London', 'England', 'London City Airport'),
('MAD', 'Madrid', 'Spain', 'Barajas');

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

--
-- Volcado de datos para la tabla `crewmates`
--

INSERT INTO `crewmates` (`id`, `name`, `surname`, `position`, `company_id`) VALUES
('0001', 'Cristofer', 'Lopez', 'COPILOT', 1),
('0002', 'Juan', 'Avila', 'COMMANDER', 2),
('0003', 'Francisco', 'Calero', 'COMMANDER', 1),
('0004', 'Sergio', 'Manzanaro', 'PURSER', 2);

--
-- Volcado de datos para la tabla `flies`
--

INSERT INTO `flies` (`id`, `duration`, `start_date`, `start_time`, `company_id`, `destination_iata`, `plane_plate`, `source_iata`) VALUES
(7, 1.2, '2020-05-10', '09:00:00', 1, 'BCN', '0001', 'MAD'),
(8, 2.43, '2020-05-27', '12:00:00', 1, 'LCY', '0002', 'MAD'),
(9, 3.1, '2020-06-18', '18:00:00', 2, 'BCN', '0001', 'LCY'),
(10, 3.1, '2020-06-18', '09:00:00', 3, 'BCN', '0001', 'LCY');

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

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(1001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);

--
-- Volcado de datos para la tabla `mechanics`
--

INSERT INTO `mechanics` (`id`, `name`, `surname`, `incorporation_year`, `training`, `company_id`) VALUES
('0001', 'Ernesto', 'Vivar', 2020, 'CAREER', 4),
('0002', 'David', 'Salido', 2020, 'CAREER', 4),
('0003', 'Luis', 'Fernandez', 2020, 'CAREER', 5),
('0004', 'Micael', 'Gallego', 2020, 'CAREER', 6);

--
-- Volcado de datos para la tabla `planes`
--

INSERT INTO `planes` (`plate`, `flight_hours`, `maker`, `model`) VALUES
('0001', 5000, 'Airbus', 'A320'),
('0002', 5000, 'British Airways', 'Boeing 747'),
('0003', 5000, 'EEUU', 'F-18'),
('0004', 2000, 'Heinkel', 'He 280'),
('0005', 2000, 'Arado', 'Ar 430');

--
-- Volcado de datos para la tabla `revisions`
--

INSERT INTO `revisions` (`id`, `description`, `end_date`, `init_date`, `revision_type`, `spent_hours`, `airport_iata`, `mechanic_in_charge_id`, `plane_plate`) VALUES
(11, 'Periodic revision of January', '2020-01-29', '2020-01-27', 'PERIODIC', 23, 'MAD', '0001', '0001'),
(12, 'Left wing reparation', '2020-02-15', '2020-02-10', 'REPARATION', 40, 'MAD', '0002', '0001');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
