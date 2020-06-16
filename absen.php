<?php error_reporting(0) ?>
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
	<section>
		<?php
		$aksi=$_GET['aksi'];
		if ($aksi=="tampil") 
		{
		?>
		<div class="up">
			<p>Data Absen</p>
		</div>
		<div class="data">
			<table border="1">
				<tr>
					<td colspan="5">
						<form method="POST" action="absen.php?aksi=search">
						<select name="nama" class="search2">
										<?php
										$query = mysqli_query($connect, "SELECT * FROM pegawai_honorer");
										while ($row = mysqli_fetch_array($query)) {
										?>
										<option value="<?php echo $row['nama_pegawai'] ?>"><?php echo $row['nama_pegawai'] ?></option>
										<?php
										}
										?>
									</select>
						Dari tanggal : <input type="date" name="awal" class="search2">
						Sampai tanggal : <input type="date" name="akhir" class="search2">
						<input type="submit" name="search" value="Search" class="button2">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Absensi</th>
					<th width="150">Nama Pegawai</th>
					<th width="200">Tanggal Absen</th>
					<th width="150">Jam Masuk</th>
					<th width="200">Jam Keluar</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM absensi_pegawai JOIN pegawai_honorer USING(kode_pegawai)");
					while ($tampil = mysqli_fetch_array($query)) {
						
				?>
				<tr>
					<td><?php echo $tampil['kode_absensi'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tanggal_absen'] ?></td>
					<td><?php echo $tampil['jam_masuk'] ?></td>
					<td><?php echo $tampil['jam_keluar'] ?></td>
				</tr>
			<?php	
			}
		?>
		</table>
		</div>
		<?php
		}
		else if($aksi =="report")
		{
			?>
		<div class="up">
			<p>Data Absen | Sisga</p>
		</div>
		<div class="data">
			<table border="1">
				<tr>
					<td colspan="5">
						<form method="POST" action="absen.php?aksi=print">
						<select name="nama" class="search2">
										<?php
										$query = mysqli_query($connect, "SELECT * FROM pegawai_honorer");
										while ($row = mysqli_fetch_array($query)) {
										?>
										<option value="<?php echo $row['nama_pegawai'] ?>"><?php echo $row['nama_pegawai'] ?></option>
										<?php
										}
										?>
									</select>
						Dari tanggal : <input type="date" name="awal" class="search2">
						Sampai tanggal : <input type="date" name="akhir" class="search2">
						<input type="submit" name="search" value="PRINT" class="button2">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Absensi</th>
					<th width="150">Nama Pegawai</th>
					<th width="200">Tanggal Absen</th>
					<th width="150">Jam Masuk</th>
					<th width="200">Jam Keluar</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM absensi_pegawai JOIN pegawai_honorer USING(kode_pegawai)");
					while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['kode_absensi'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tanggal_absen'] ?></td>
					<td><?php echo $tampil['jam_masuk'] ?></td>
					<td><?php echo $tampil['jam_keluar'] ?></td>
				</tr>
			<?php	
			}
		?>
		<tr>
			<td colspan="5">&nbsp;</td>
		</tr>
		 <tr style="height: 200px">
		    <td colspan="3">&nbsp;</td>
		    <td align="center" colspan="2">
		    	<font style="font-family:'Trebuchet MS', Arial, Helvetica, sans-serif">
			    <p>Bandung, <?php echo date('d-M-Y') ?><br/>
			    Direktur</p>
			    <p>&nbsp;</p>
			    <p>&nbsp;</p>
			    <p>&nbsp;</p>
			    <p>&nbsp;</p>
			    <p>Reynaldi Prama Octavially</p>
			    </font>
			</td>
		</tr>
		</table>
		</div>
		<?php
		}
	else if($aksi =="print")
		{
			?>
		<div class="up">
			<p>Data Absen | Sisga</p>
			<?php
				echo "<script language=javascript>
				function printWindow() {
				bV = parseInt(navigator.appVersion);
				if (bV >= 4) window.print();}
				printWindow();
				</script>";
			?>
		</div>
		<div class="data">
			<table border="1">
				<tr>
					<th width="150">Kode Absensi</th>
					<th width="150">Nama Pegawai</th>
					<th width="200">Tanggal Absen</th>
					<th width="150">Jam Masuk</th>
					<th width="200">Jam Keluar</th>
				</tr>
				<?php
					if (isset($_POST['search'])) {
						$nama = $_POST['nama'];
						$awal = $_POST['awal'];
						$akhir = $_POST['akhir'];
						$query = mysqli_query($connect, "SELECT * FROM absensi_pegawai JOIN pegawai_honorer USING(kode_pegawai) WHERE nama_pegawai LIKE '%$nama%' AND tanggal_absen BETWEEN '$awal' AND '$akhir'");
						while ($tampil = mysqli_fetch_array($query)) {
							?>
							<tr>
								<td><?php echo $tampil['kode_absensi'] ?></td>
								<td><?php echo $tampil['nama_pegawai'] ?></td>
								<td><?php echo $tampil['tanggal_absen'] ?></td>
								<td><?php echo $tampil['jam_masuk'] ?></td>
								<td><?php echo $tampil['jam_keluar'] ?></td>
							</tr>
				<?php
						}	
					}
		?>
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		 <tr style="height: 200px">
		    <td colspan="3">&nbsp;</td>
		    <td align="center" colspan="2">
		    	<font style="font-family:'Trebuchet MS', Arial, Helvetica, sans-serif">
			    <p>Bandung, <?php echo date('d-M-Y') ?><br/>
			    Direktur</p>
			    <p>&nbsp;</p>
			    <p>&nbsp;</p>
			    <p>&nbsp;</p>
			    <p>&nbsp;</p>
			    <p>Reynaldi Prama Octavially</p>
			    </font>
			</td>
		</tr>
		</table>
		</div>
		<?php
			}
		elseif ($aksi=="search")
			{
				?>
					<div class="up">
			<p>Data Absen</p>
		</div>
		<div class="data">
			<table border="1">
				<tr>
					<td colspan="5">
						<form method="POST" action="absen.php?aksi=search">
						<select name="nama" class="search2">
										<?php
										$query = mysqli_query($connect, "SELECT * FROM pegawai_honorer");
										while ($row = mysqli_fetch_array($query)) {
										?>
										<option value="<?php echo $row['nama_pegawai'] ?>"><?php echo $row['nama_pegawai'] ?></option>
										<?php
										}
										?>
									</select>
						Dari tanggal : <input type="date" name="awal" class="search2">
						Sampai tanggal : <input type="date" name="akhir" class="search2">
						<input type="submit" name="search" value="Search" class="button2">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Absensi</th>
					<th width="150">Nama Pegawai</th>
					<th width="200">Tanggal Absen</th>
					<th width="150">Jam Masuk</th>
					<th width="200">Jam Keluar</th>
				</tr>
				<?php
					if (isset($_POST['search'])) {
						$nama = $_POST['nama'];
						$awal = $_POST['awal'];
						$akhir = $_POST['akhir'];
						$query = mysqli_query($connect, "SELECT * FROM absensi_pegawai JOIN pegawai_honorer USING(kode_pegawai) WHERE nama_pegawai LIKE '%$nama%' AND tanggal_absen BETWEEN '$awal' AND '$akhir'");
						while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['kode_absensi'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tanggal_absen'] ?></td>
					<td><?php echo $tampil['jam_masuk'] ?></td>
					<td><?php echo $tampil['jam_keluar'] ?></td>
				</tr>
				<?php
						}
					}
				?>
			</table>
		</div>
		<?php
}
		?>
	</section>
</body>
</html>
