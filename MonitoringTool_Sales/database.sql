-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Gegenereerd op: 03 jul 2017 om 22:41
-- Serverversie: 5.6.28
-- PHP-versie: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `monitoringtool_login`
--
CREATE DATABASE IF NOT EXISTS `monitoringtool_login` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `monitoringtool_login`;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `login`
--

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

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `login`
--
ALTER TABLE `login`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;