<!DOCTYPE html>
<html>
<head>
	<title>Sisga</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<?php
		include "config.php";
	?>
</head>
<body>
	<nav>
		<p>
			<a href="beranda.php" style="text-decoration: none; color: black;"> SISGA </a><font color="#00458e">|</font>
		</p>
		<ul>
			<li class="dropdown"><a href=""><img src="Icon/account.png">
				<div class="dropdown-content">
					 <a href="logout.php"><img src="Icon/signin.png">Logout</a>
				</div>
			</li>
			
		</ul>
	</nav>

	<div class="nav2">
		<ul>
			<li class="dropdown"><a href="">PEGAWAI</a>
				<div class="dropdown-content">
					<a href="detail.php?aksi=tambah">Tambah Data</a>
					<a href="detail.php?aksi=tampil">Lihat Data</a>
					<a href="detail.php?aksi=report">Print Data</a>
				</div>
			</li>
			<li class="dropdown"><a href="">ABSEN PEGAWAI</a>
					<div class="dropdown-content">
						<a href="absen.php?aksi=tampil">Data Absen</a>
						<a href="absen.php?aksi=report">Print Data</a>
					</div>
			</li>
			<li class="dropdown"><a href="">CUTI PEGAWAI</a>
					<div class="dropdown-content">
						<a href="cuti.php?aksi=tampil">Pengajuan Cuti</a>
						<a href="cuti2.php?aksi=tampil">Data Cuti</a>
						<a href="cuti2.php?aksi=report">Print Data</a>
					</div>
			</li>
			<li class="dropdown"><a href="">SPPD</a>
				<div class="dropdown-content">
					<a href="sppd.php?aksi=tampil">Pengajuan SPPD</a>
					<a href="sppd2.php?aksi=tampil">Data SPPD</a>
					<a href="sppd2.php?aksi=report">Print Data</a>
				</div>
		</ul>
	</div>
	<div class="first">
		<h1>SISGA SYSTEM </h1>
		<p>WELCOME IN SYSTEM</p>
	</div>
</body>
</html>