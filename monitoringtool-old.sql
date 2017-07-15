-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Gegenereerd op: 06 jul 2017 om 21:05
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
-- Tabelstructuur voor tabel `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `customers`
--

INSERT INTO `customers` (`Id`, `Name`) VALUES
(1, 'IPTE'),
(2, 'Jabil');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `database_changed`
--

DROP TABLE IF EXISTS `database_changed`;
CREATE TABLE `database_changed` (
  `Id` int(11) NOT NULL,
  `Time_Unix` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `database_changed`
--

INSERT INTO `database_changed` (`Id`, `Time_Unix`) VALUES
(1, 1498927540);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id_user` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Gegevens worden geëxporteerd voor tabel `login`
--

INSERT INTO `login` (`id_user`, `username`, `password`) VALUES
(2, 'blabla', 'df5ea29924d39c3be8785734f13169c6'),
(3, 'test', '098f6bcd4621d373cade4e832627b4f6');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
CREATE TABLE `product_detail` (
  `Id` int(11) NOT NULL,
  `PId` int(11) NOT NULL,
  `Serial_Number` varchar(50) NOT NULL,
  `Time_Unix` bigint(20) NOT NULL,
  `Property_1` varchar(50) NOT NULL,
  `Property_2` varchar(50) NOT NULL,
  `Property_3` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `product_detail`
--

INSERT INTO `product_detail` (`Id`, `PId`, `Serial_Number`, `Time_Unix`, `Property_1`, `Property_2`, `Property_3`) VALUES
(1, 2, '21498982508126403', 1498982532, 'green', 'large', 'boxed'),
(2, 2, '21498982630390088', 1498982638, 'green', 'large', 'boxed'),
(3, 2, '21498982652532701', 1498982653, 'green', 'large', 'boxed'),
(4, 1, '11499003898488494', 1499003902, 'jTextField3', 'jTextField4', 'jTextField5'),
(5, 1, '11499004016251528', 1499004029, '1', '2', '3'),
(6, 1, '11499004060920447', 1499004066, '1', '2', '3'),
(7, 1, '11499004179283348', 1499004200, 'jTextField3', 'jTextField4', 'jTextField5'),
(8, 1, '11499004726280399', 1499004729, 'jTextField3', 'jTextField4', 'jTextField5'),
(9, 1, '11499004769703932', 1499004775, '1', '2', '3'),
(10, 1, '11499004879226317', 1499004902, '1', '2', '3'),
(11, 1, '1149900503927180', 1499005048, '1', '2', '3'),
(13, 1, '1149900506686485', 1499005071, '1', '2', '3'),
(14, 1, '11499005158580631', 1499005168, 'jTextField3', 'jTextField4', 'jTextField5'),
(16, 1, '11499005299892690', 1499005301, 'jTextField3', 'jTextField4', 'jTextField5'),
(19, 1, '11499005311882886', 1499005314, 'jTextField3', 'jTextField4', 'jTextField5'),
(23, 1, '11499005319612831', 1499005320, 'jTextField3', 'jTextField4', 'jTextField5'),
(26, 1, '11499005323775041', 1499005324, 'jTextField3', 'jTextField4', 'jTextField5'),
(30, 2, '21499010380536543', 1499010382, 'jTextField3', 'jTextField4', 'jTextField5'),
(32, 2, '21499010386238057', 1499010387, 'jTextField3', 'jTextField4', 'jTextField5'),
(33, 1, 'jLabel17', 1499019251, 'jTextField3', 'jTextField4', 'jTextField5'),
(39, 1, '11499019291648343', 1499019292, 'jTextField3', 'jTextField4', 'jTextField5'),
(43, 1, '1149901929529999', 1499019296, 'jTextField3', 'jTextField4', 'jTextField5'),
(44, 2, '21499019340932208', 1499019343, 'jTextField3', 'jTextField4', 'jTextField5'),
(46, 2, '21499019345865330', 1499019346, 'jTextField3', 'jTextField4', 'jTextField5'),
(49, 1, '11499019852960415', 1499019859, 'jTextField3', 'jTextField4', 'jTextField5'),
(54, 1, '11499019866314730', 1499019868, 'jTextField3', 'jTextField4', 'jTextField5'),
(55, 1, '11499096398756453', 1499096403, 'jTextField3', 'jTextField4', 'jTextField5'),
(58, 1, '11499096412896911', 1499096415, 'jTextField3', 'jTextField4', 'jTextField5'),
(59, 1, '11499163981879494', 1499163983, '', '', ''),
(61, 1, '11499165465129696', 1499165467, '', '', ''),
(63, 2, '21499165477617836', 1499165479, '', '', ''),
(65, 2, '21499165481876869', 1499165482, '', '', ''),
(66, 2, '21499165483184617', 1499165485, '', '', ''),
(67, 2, '21499165486410093', 1499165487, '', '', ''),
(68, 2, '21499165787905875', 1499165788, '', '', ''),
(69, 2, '2149916579190756', 1499165792, '', '', ''),
(70, 2, '2149916579628042', 1499165797, '', '', '');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `product_detail_last_25`
--

DROP TABLE IF EXISTS `product_detail_last_25`;
CREATE TABLE `product_detail_last_25` (
  `Id` int(11) NOT NULL,
  `PId` int(11) NOT NULL,
  `Serial_Number` varchar(50) NOT NULL,
  `Time_Unix` bigint(20) NOT NULL,
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

--
-- Gegevens worden geëxporteerd voor tabel `product_types`
--

INSERT INTO `product_types` (`PId`, `Name`, `Amount`) VALUES
(1, 'PID-box', 42),
(2, 'Photovoltaic Converter 3000W', 788);

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
-- Indexen voor tabel `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- Indexen voor tabel `database_changed`
--
ALTER TABLE `database_changed`
  ADD PRIMARY KEY (`Id`);

--
-- Indexen voor tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_user`);

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
-- AUTO_INCREMENT voor een tabel `customers`
--
ALTER TABLE `customers`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT voor een tabel `database_changed`
--
ALTER TABLE `database_changed`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT voor een tabel `login`
--
ALTER TABLE `login`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT voor een tabel `product_detail`
--
ALTER TABLE `product_detail`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
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
