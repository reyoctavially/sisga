-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Feb 2020 pada 07.49
-- Versi server: 10.1.31-MariaDB
-- Versi PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `diskominfo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `absen`
--

CREATE TABLE `absen` (
  `id_absen` int(11) NOT NULL,
  `tgl` date NOT NULL,
  `jam_masuk` varchar(50) NOT NULL,
  `jam_keluar` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `absen`
--

INSERT INTO `absen` (`id_absen`, `tgl`, `jam_masuk`, `jam_keluar`, `username`) VALUES
(1, '2019-07-24', '09:56', '09:57', 'reyoctavially'),
(2, '2019-08-12', '13:25', '', 'reyoctavially'),
(3, '2019-08-12', '13:26', '', 'reyoctavially'),
(4, '2019-08-12', '13:26', '', 'reyoctavially'),
(5, '2020-02-10', '16:21', '', 'reyoctavially');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `unique_id` varchar(25) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `username` varchar(50) NOT NULL,
  `encrypted_password` varchar(80) NOT NULL,
  `salt` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `unique_id`, `nama`, `email`, `telp`, `username`, `encrypted_password`, `salt`) VALUES
(8, '5d317d620b13d9.59445295', 'admin system', 'system@gmail.com', '082216805580', 'admin', 'yCrqIGYJ82WYMLKpejtLjDe0mq4xOGYyYTg3NDIx', '18f2a87421'),
(9, '5d31870bda68b9.88273249', 'Rd. Bayu Nugraha, ST', 'bayunugraha12@gmail.com', '085284410111', 'bayunugraha', 'bybKRRoiJHhN28EdPNcQ7Y2rOU82NWFiNDJlM2Ey', '65ab42e3a2'),
(10, '5d318750018fb6.66060249', 'Tedi Nur Komaludin, S.Pd', 'teddybelexs@gmail.com', '085318507444', 'tedinur', 'iULrZiu8nA+biNABpsaI5jo6MsExNDc5YmUwZmE1', '1479be0fa5'),
(11, '5d3189ecc22ea9.80484551', 'Yusup Muliana, S.T', 'yusufmuliana@gmail.com', '089668093715', 'yusupmuliana', 'mFBpJbQnfI5LnGzZfRNvXvHbamxlYWM2MDI3OGYz', 'eac60278f3'),
(12, '5d318a49c38ce8.10822254', 'Yoga Saprida, ST', 'yogasaprida@gmail.com', '087723633399', 'yogasaprida', 'EXsOgYdShMSZka9r/rmk8U9/7UE1MGM3Yjc4MjI5', '50c7b78229'),
(13, '5d318add1eb462.88960370', 'Anang Setiana AMd', 'anangsetiana353@gmail.com', '081395578191', 'anangsetiana', 'sshuJO9ImxukJ2BBA77PNCdvoLU4MGM1NjRlMmZj', '80c564e2fc'),
(14, '5d318b34afbf99.57010002', 'Anisa Nurkomalasari S ST', 'anisa.nsuherman@gmail.com', '082225113522', 'anisa', '9WepygzJwPjapeiXfpgG64KzrCE4ZTgxMzkzZjBl', '8e81393f0e'),
(15, '5d318b6f0e27d2.96030122', 'Saepudin S.H.I', 'saepudinmusaafandi14@gmail.com', '085352890588', 'saepudin', 'W80QQwcIpGJtizqVSKMvRKWk5TA1ODk2YTg1YzBj', '5896a85c0c'),
(16, '5d318baec86f84.54974299', 'Sinta Riyana ST', 'sintariyana88@gmail.com', '085322000034', 'sintariyana', 'oc4yhU/jaJq5MrDPc/NRobQ62SkzNzA0ZmQwZDQw', '3704fd0d40'),
(17, '5d37c889077709.21655893', 'Reynaldi Prama Octavially', 'reynaldi.octavially@gmail.com', '082216805580', 'reyoctavially', 'd5qLx+Px+OUXK0GSUCH6jpc8ih40NDIwMmM0ZDU1', '44202c4d55');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `absen`
--
ALTER TABLE `absen`
  ADD PRIMARY KEY (`id_absen`),
  ADD KEY `username` (`username`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD UNIQUE KEY `unique_id` (`unique_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `absen`
--
ALTER TABLE `absen`
  MODIFY `id_absen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id_pegawai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `absen`
--
ALTER TABLE `absen`
  ADD CONSTRAINT `absen_ibfk_1` FOREIGN KEY (`username`) REFERENCES `pegawai` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
