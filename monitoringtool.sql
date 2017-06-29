-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Gegenereerd op: 29 jun 2017 om 15:28
-- Serverversie: 10.1.16-MariaDB
-- PHP-versie: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `monitoringtool`
--
CREATE DATABASE IF NOT EXISTS `monitoringtool` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `monitoringtool`;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `database_changed`
--

DROP TABLE IF EXISTS `database_changed`;
CREATE TABLE `database_changed` (
  `Id` int(11) NOT NULL,
  `Time_Unix` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
CREATE TABLE `product_detail` (
  `Id` int(11) NOT NULL,
  `PId` int(11) NOT NULL,
  `Serial_Number` varchar(50) NOT NULL,
  `Time_Unix` int(11) NOT NULL,
  `Property_1` varchar(50) NOT NULL,
  `Property_2` varchar(50) NOT NULL,
  `Property_3` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `product_detail_last_25`
--

DROP TABLE IF EXISTS `product_detail_last_25`;
CREATE TABLE `product_detail_last_25` (
  `Id` int(11) NOT NULL,
  `PId` int(11) NOT NULL,
  `Serial_Number` varchar(50) NOT NULL,
  `Time_Unix` int(11) NOT NULL,
  `Property_1` varchar(50) NOT NULL,
  `Property_2` varchar(50) NOT NULL,
  `Property_3` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `product_types`
--

DROP TABLE IF EXISTS `product_types`;
CREATE TABLE `product_types` (
  `PId` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `Id` int(11) NOT NULL,
  `PId` int(11) NOT NULL,
  `Serial_Number` varchar(50) NOT NULL,
  `Client_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `database_changed`
--
ALTER TABLE `database_changed`
  ADD PRIMARY KEY (`Id`);

--
-- Indexen voor tabel `product_detail`
--
ALTER TABLE `product_detail`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Serial_Number` (`Serial_Number`),
  ADD KEY `PId` (`PId`),
  ADD KEY `Serial_Number_2` (`Serial_Number`);

--
-- Indexen voor tabel `product_detail_last_25`
--
ALTER TABLE `product_detail_last_25`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Serial_Number` (`Serial_Number`),
  ADD KEY `PId` (`PId`);

--
-- Indexen voor tabel `product_types`
--
ALTER TABLE `product_types`
  ADD PRIMARY KEY (`PId`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- Indexen voor tabel `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Serial_Number` (`Serial_Number`),
  ADD KEY `Serial_Number_2` (`Serial_Number`),
  ADD KEY `PId` (`PId`),
  ADD KEY `Client_Id` (`Client_Id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `database_changed`
--
ALTER TABLE `database_changed`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `product_detail`
--
ALTER TABLE `product_detail`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `product_detail_last_25`
--
ALTER TABLE `product_detail_last_25`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT voor een tabel `sales`
--
ALTER TABLE `sales`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `product_detail`
--
ALTER TABLE `product_detail`
  ADD CONSTRAINT `product_detail_ibfk_1` FOREIGN KEY (`PId`) REFERENCES `product_types` (`PId`);

--
-- Beperkingen voor tabel `product_detail_last_25`
--
ALTER TABLE `product_detail_last_25`
  ADD CONSTRAINT `product_detail_last_25_ibfk_1` FOREIGN KEY (`PId`) REFERENCES `product_types` (`PId`);

--
-- Beperkingen voor tabel `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`PId`) REFERENCES `product_types` (`PId`),
  ADD CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`Serial_Number`) REFERENCES `product_detail` (`Serial_Number`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
