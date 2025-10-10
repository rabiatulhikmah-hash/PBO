-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2025 at 05:30 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_driver`
--

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `id_driver` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `plat_nomor` varchar(20) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `riwayat_order` int(11) DEFAULT NULL,
  `usia` int(11) DEFAULT NULL,
  `jenis_driver` enum('Mobil','Motor') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`id_driver`, `nama`, `plat_nomor`, `status`, `riwayat_order`, `usia`, `jenis_driver`) VALUES
(1, 'Budi', 'KT1234AA', 'Aktif', 120, 25, 'Motor'),
(2, 'Andi', 'KT5678BB', 'Aktif', 200, 32, 'Mobil'),
(3, 'Siti', 'KT9012CC', 'Nonaktif', 340, 28, 'Motor'),
(4, 'Dewi', 'KT3456DD', 'Aktif', 90, 22, 'Mobil'),
(5, 'Rudi', 'KT7890EE', 'Aktif', 150, 45, 'Motor'),
(6, 'Agus', 'KT1122FF', 'Nonaktif', 210, 27, 'Mobil'),
(7, 'Nina', 'KT3344GG', 'Aktif', 175, 30, 'Motor'),
(8, 'Eka', 'KT5566HH', 'Aktif', 130, 40, 'Mobil'),
(9, 'Yudi', 'KT7788II', 'Aktif', 320, 19, 'Motor'),
(10, 'Lina', 'KT9900JJ', 'Nonaktif', 250, 35, 'Mobil'),
(11, 'hshs', 'se33', 'Aktif', 13, 12, 'Motor');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`id_driver`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `id_driver` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
