-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Bulan Mei 2020 pada 13.48
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sisga`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `absensi_pegawai`
--

CREATE TABLE `absensi_pegawai` (
  `kode_absensi` varchar(8) NOT NULL,
  `tanggal_absen` date NOT NULL,
  `jam_masuk` time NOT NULL,
  `jam_keluar` time NOT NULL,
  `kode_pegawai` varchar(8) NOT NULL,
  `nip_kasi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `absensi_pegawai`
--

INSERT INTO `absensi_pegawai` (`kode_absensi`, `tanggal_absen`, `jam_masuk`, `jam_keluar`, `kode_pegawai`, `nip_kasi`) VALUES
('SN-001', '2020-04-02', '07:30:00', '23:14:48', 'PG-001', '19820614 200901 1 005'),
('SN-002', '2020-04-03', '07:32:00', '12:06:04', 'PG-001', '19820614 200901 1 005'),
('SN-003', '2020-04-04', '07:29:07', '15:30:29', 'PG-001', '19820614 200901 1 005'),
('SN-004', '2020-04-25', '07:29:07', '15:30:29', 'PG-001', '19820614 200901 1 005'),
('SN-005', '2020-05-02', '14:16:24', '00:00:00', 'PG-001', '19820614 200901 1 005');

-- --------------------------------------------------------

--
-- Struktur dari tabel `cuti`
--

CREATE TABLE `cuti` (
  `kode_cuti` varchar(8) NOT NULL,
  `jenis_cuti` varchar(50) NOT NULL,
  `pemotongan_honor` varchar(50) NOT NULL,
  `tglmulaicuti` date NOT NULL,
  `tglselesaicuti` date NOT NULL,
  `statuscuti` varchar(20) NOT NULL,
  `kode_pegawai` varchar(8) NOT NULL,
  `nip_kasi` varchar(30) NOT NULL,
  `kode_pengajuan_cuti` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `cuti`
--

INSERT INTO `cuti` (`kode_cuti`, `jenis_cuti`, `pemotongan_honor`, `tglmulaicuti`, `tglselesaicuti`, `statuscuti`, `kode_pegawai`, `nip_kasi`, `kode_pengajuan_cuti`) VALUES
('CT-001', 'Cuti kecil', '20000', '2020-02-18', '2020-02-19', 'Berlaku', 'PG-001', '19820614 200901 1 005', 'PC-001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kepala_seksi`
--

CREATE TABLE `kepala_seksi` (
  `nip_kasi` varchar(30) NOT NULL,
  `nama_kasi` varchar(100) NOT NULL,
  `email_kasi` varchar(50) NOT NULL,
  `telp_kasi` varchar(15) NOT NULL,
  `jalan_kasi` varchar(50) NOT NULL,
  `no_rumah_kasi` varchar(8) NOT NULL,
  `rt_rw_kasi` varchar(15) NOT NULL,
  `kec_kasi` varchar(50) NOT NULL,
  `kota_kasi` varchar(50) NOT NULL,
  `kode_pos_kasi` int(11) NOT NULL,
  `username_kasi` varchar(15) NOT NULL,
  `pass_kasi` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kepala_seksi`
--

INSERT INTO `kepala_seksi` (`nip_kasi`, `nama_kasi`, `email_kasi`, `telp_kasi`, `jalan_kasi`, `no_rumah_kasi`, `rt_rw_kasi`, `kec_kasi`, `kota_kasi`, `kode_pos_kasi`, `username_kasi`, `pass_kasi`) VALUES
('19820614 200901 1 005', 'Indra Budhiman', 'indrabulle125@gmail.com', '08122438800', 'Jl. Mutiara Blok B Desa Rajagaluh', '015', '004/002', 'Rajagaluh', 'Majalengka', 45472, 'indrabudhiman', '123456');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai_honorer`
--

CREATE TABLE `pegawai_honorer` (
  `kode_pegawai` varchar(8) NOT NULL,
  `nama_pegawai` varchar(100) NOT NULL,
  `jabatan_pegawai` varchar(50) NOT NULL,
  `email_pegawai` varchar(50) NOT NULL,
  `telp_pegawai` varchar(15) NOT NULL,
  `no_rekening_pegawai` varchar(30) NOT NULL,
  `jalan_pegawai` varchar(50) NOT NULL,
  `no_rumah_pegawai` varchar(8) NOT NULL,
  `rt_rw_pegawai` varchar(15) NOT NULL,
  `kec_pegawai` varchar(50) NOT NULL,
  `kota_pegawai` varchar(50) NOT NULL,
  `kode_pos_pegawai` int(11) NOT NULL,
  `username_pegawai` varchar(15) NOT NULL,
  `pass_pegawai` varchar(15) NOT NULL,
  `nip_kasi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pegawai_honorer`
--

INSERT INTO `pegawai_honorer` (`kode_pegawai`, `nama_pegawai`, `jabatan_pegawai`, `email_pegawai`, `telp_pegawai`, `no_rekening_pegawai`, `jalan_pegawai`, `no_rumah_pegawai`, `rt_rw_pegawai`, `kec_pegawai`, `kota_pegawai`, `kode_pos_pegawai`, `username_pegawai`, `pass_pegawai`, `nip_kasi`) VALUES
('PG-001', 'Reynaldi Prama Octavially', 'Staff Bidang Informatika', 'reynaldi.octavially@gmail.com', '082216805580', 'BRI : 429601010399539', 'Jl. Desa Karayunan', '003', '001/008', 'Cigasong', 'Majalengka', 45472, 'reyoctavially', '18101998', '19820614 200901 1 005');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengajuan_cuti`
--

CREATE TABLE `pengajuan_cuti` (
  `kode_pengajuan_cuti` varchar(8) NOT NULL,
  `tgl_pengajuan_cuti` date NOT NULL,
  `alasan_pengajuan_cuti` varchar(500) NOT NULL,
  `tgl_mulai_cuti` date NOT NULL,
  `tgl_selesai_cuti` date NOT NULL,
  `status_pengajuan_cuti` varchar(15) NOT NULL,
  `ket_pengajuan_cuti` varchar(500) NOT NULL,
  `kode_pegawai` varchar(8) NOT NULL,
  `nip_kasi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengajuan_cuti`
--

INSERT INTO `pengajuan_cuti` (`kode_pengajuan_cuti`, `tgl_pengajuan_cuti`, `alasan_pengajuan_cuti`, `tgl_mulai_cuti`, `tgl_selesai_cuti`, `status_pengajuan_cuti`, `ket_pengajuan_cuti`, `kode_pegawai`, `nip_kasi`) VALUES
('PC-001', '2020-02-17', 'Cuti Sakit', '2020-02-18', '2020-02-19', 'Disetujui', 'Cuti telah disetujui', 'PG-001', '19820614 200901 1 005');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengajuan_surat_perjalanan_dinas`
--

CREATE TABLE `pengajuan_surat_perjalanan_dinas` (
  `kode_pengajuan_surat` varchar(8) NOT NULL,
  `tgl_pengajuan_surat` date NOT NULL,
  `tujuan_pengajuan_surat` varchar(50) NOT NULL,
  `tgl_mulai_sppd` date NOT NULL,
  `tgl_selesai_sppd` date NOT NULL,
  `status_pengajuan_surat` varchar(15) NOT NULL,
  `ket_pengajuan_sppd` varchar(500) NOT NULL,
  `kode_pegawai` varchar(8) NOT NULL,
  `nip_kasi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengajuan_surat_perjalanan_dinas`
--

INSERT INTO `pengajuan_surat_perjalanan_dinas` (`kode_pengajuan_surat`, `tgl_pengajuan_surat`, `tujuan_pengajuan_surat`, `tgl_mulai_sppd`, `tgl_selesai_sppd`, `status_pengajuan_surat`, `ket_pengajuan_sppd`, `kode_pegawai`, `nip_kasi`) VALUES
('PD-001', '2020-02-18', 'Diklat kenaikan pangkat', '2020-02-18', '2020-02-20', 'Disetujui', 'SPPD telah disetujui', 'PG-001', '19820614 200901 1 005');

-- --------------------------------------------------------

--
-- Struktur dari tabel `surat_perjalanan_dinas`
--

CREATE TABLE `surat_perjalanan_dinas` (
  `no_surat` varchar(50) NOT NULL,
  `jenis_surat` varchar(50) NOT NULL,
  `uang_saku` varchar(50) NOT NULL,
  `tglmulaisppd` date NOT NULL,
  `tglselesaisppd` date NOT NULL,
  `statussurat` varchar(20) NOT NULL,
  `kode_pegawai` varchar(8) NOT NULL,
  `nip_kasi` varchar(30) NOT NULL,
  `kode_pengajuan_surat` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `surat_perjalanan_dinas`
--

INSERT INTO `surat_perjalanan_dinas` (`no_surat`, `jenis_surat`, `uang_saku`, `tglmulaisppd`, `tglselesaisppd`, `statussurat`, `kode_pegawai`, `nip_kasi`, `kode_pengajuan_surat`) VALUES
('09.001/DISKOMINFO/IV/2020', 'Dalam Kota', '200000', '2020-02-18', '2020-02-20', 'Berlaku', 'PG-001', '19820614 200901 1 005', 'PD-001');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `absensi_pegawai`
--
ALTER TABLE `absensi_pegawai`
  ADD PRIMARY KEY (`kode_absensi`),
  ADD KEY `nip_kasi` (`nip_kasi`),
  ADD KEY `kode_pegawai` (`kode_pegawai`);

--
-- Indeks untuk tabel `cuti`
--
ALTER TABLE `cuti`
  ADD PRIMARY KEY (`kode_cuti`),
  ADD KEY `kode_pengajuan_cuti` (`kode_pengajuan_cuti`),
  ADD KEY `kode_pegawai` (`kode_pegawai`),
  ADD KEY `nip_kasi` (`nip_kasi`);

--
-- Indeks untuk tabel `kepala_seksi`
--
ALTER TABLE `kepala_seksi`
  ADD PRIMARY KEY (`nip_kasi`);

--
-- Indeks untuk tabel `pegawai_honorer`
--
ALTER TABLE `pegawai_honorer`
  ADD PRIMARY KEY (`kode_pegawai`),
  ADD KEY `nip_kasi` (`nip_kasi`);

--
-- Indeks untuk tabel `pengajuan_cuti`
--
ALTER TABLE `pengajuan_cuti`
  ADD PRIMARY KEY (`kode_pengajuan_cuti`),
  ADD KEY `kode_pegawai` (`kode_pegawai`),
  ADD KEY `nip_kasi` (`nip_kasi`);

--
-- Indeks untuk tabel `pengajuan_surat_perjalanan_dinas`
--
ALTER TABLE `pengajuan_surat_perjalanan_dinas`
  ADD PRIMARY KEY (`kode_pengajuan_surat`),
  ADD KEY `kode_pegawai` (`kode_pegawai`),
  ADD KEY `nip_kasi` (`nip_kasi`);

--
-- Indeks untuk tabel `surat_perjalanan_dinas`
--
ALTER TABLE `surat_perjalanan_dinas`
  ADD PRIMARY KEY (`no_surat`),
  ADD KEY `kode_pengajuan_surat` (`kode_pengajuan_surat`),
  ADD KEY `kode_pegawai` (`kode_pegawai`),
  ADD KEY `nip_kasi` (`nip_kasi`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `absensi_pegawai`
--
ALTER TABLE `absensi_pegawai`
  ADD CONSTRAINT `absensi_pegawai_ibfk_1` FOREIGN KEY (`nip_kasi`) REFERENCES `kepala_seksi` (`nip_kasi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `absensi_pegawai_ibfk_2` FOREIGN KEY (`kode_pegawai`) REFERENCES `pegawai_honorer` (`kode_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `cuti`
--
ALTER TABLE `cuti`
  ADD CONSTRAINT `cuti_ibfk_1` FOREIGN KEY (`kode_pengajuan_cuti`) REFERENCES `pengajuan_cuti` (`kode_pengajuan_cuti`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cuti_ibfk_2` FOREIGN KEY (`kode_pegawai`) REFERENCES `pegawai_honorer` (`kode_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cuti_ibfk_3` FOREIGN KEY (`nip_kasi`) REFERENCES `kepala_seksi` (`nip_kasi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pegawai_honorer`
--
ALTER TABLE `pegawai_honorer`
  ADD CONSTRAINT `pegawai_honorer_ibfk_1` FOREIGN KEY (`nip_kasi`) REFERENCES `kepala_seksi` (`nip_kasi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengajuan_cuti`
--
ALTER TABLE `pengajuan_cuti`
  ADD CONSTRAINT `pengajuan_cuti_ibfk_1` FOREIGN KEY (`kode_pegawai`) REFERENCES `pegawai_honorer` (`kode_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pengajuan_cuti_ibfk_2` FOREIGN KEY (`nip_kasi`) REFERENCES `kepala_seksi` (`nip_kasi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengajuan_surat_perjalanan_dinas`
--
ALTER TABLE `pengajuan_surat_perjalanan_dinas`
  ADD CONSTRAINT `pengajuan_surat_perjalanan_dinas_ibfk_1` FOREIGN KEY (`kode_pegawai`) REFERENCES `pegawai_honorer` (`kode_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pengajuan_surat_perjalanan_dinas_ibfk_2` FOREIGN KEY (`nip_kasi`) REFERENCES `kepala_seksi` (`nip_kasi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `surat_perjalanan_dinas`
--
ALTER TABLE `surat_perjalanan_dinas`
  ADD CONSTRAINT `surat_perjalanan_dinas_ibfk_1` FOREIGN KEY (`kode_pengajuan_surat`) REFERENCES `pengajuan_surat_perjalanan_dinas` (`kode_pengajuan_surat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `surat_perjalanan_dinas_ibfk_2` FOREIGN KEY (`kode_pegawai`) REFERENCES `pegawai_honorer` (`kode_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `surat_perjalanan_dinas_ibfk_3` FOREIGN KEY (`nip_kasi`) REFERENCES `kepala_seksi` (`nip_kasi`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
