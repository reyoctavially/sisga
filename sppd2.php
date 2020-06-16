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
			<p>Data SPPD </p>
		</div>
		<div class="data">
			<table border="1">
			<tr>
					<td colspan="10">
						<form method="POST" action="sppd2.php?aksi=search">
							<input type="submit" name="submit" value="Search" class="button1">
							<input type="text" name="search" placeholder="Search ..." class="search">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">No Surat</th>
					<th width="200">Nama Pegawai</th>
					<th width="150">Tgl Pengajuan Surat</th>
					<th width="200">Jenis Surat</th>
					<th width="150">Tgl Mulai SPPD</th>
					<th width="150">Tgl Selesai SPPD</th>
					<th width="200">Status Surat</th>
					<th width="200">Uang Saku</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM pengajuan_surat_perjalanan_dinas JOIN pegawai_honorer USING(kode_pegawai) JOIN surat_perjalanan_dinas USING(kode_pengajuan_surat)");
					while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['no_surat'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['jenis_surat'] ?></td>
					<td><?php echo $tampil['tglmulaisppd'] ?></td>
					<td><?php echo $tampil['tglselesaisppd'] ?></td>
					<td><?php echo $tampil['statussurat'] ?></td>
					<td>Rp.<?php echo $tampil['uang_saku'] ?></td>	
				</tr>
			<?php	
			}
		?>
		</table>
		</div>

		<?php
		}
		
		elseif ($aksi=="search")
			{
				?>
				<div class="up">
			<p>Data SPPD </p>
		</div>
		<div class="data">
			<table border="1">
				<tr>
					<td colspan="10">
						<form method="POST" action="sppd2.php?aksi=search">
							<input type="submit" name="submit" value="Search" class="button1">
							<input type="text" name="search" placeholder="Search ..." class="search">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">No Surat</th>
					<th width="200">Nama Pegawai</th>
					<th width="150">Tgl Pengajuan Surat</th>
					<th width="200">Jenis Surat</th>
					<th width="150">Tgl Mulai SPPD</th>
					<th width="150">Tgl Selesai SPPD</th>
					<th width="200">Status Surat</th>
					<th width="200">Uang Saku</th>
				</tr>
				<?php
					if (isset($_POST['search'])) {
						$search = $_POST['search'];
						$query = mysqli_query($connect, "SELECT * FROM pengajuan_surat_perjalanan_dinas JOIN pegawai_honorer USING(kode_pegawai) JOIN surat_perjalanan_dinas USING(kode_pengajuan_surat) WHERE no_surat LIKE '%$search%' OR nama_pegawai LIKE '%$search%' OR tgl_pengajuan_surat LIKE '%$search%' OR jenis_surat LIKE '%$search%' OR tglmulaisppd LIKE '%$search%' OR tglselesaisppd LIKE '%$search%' OR statussurat LIKE '%$search%' OR uang_saku LIKE '%$search%' ");
						while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['no_surat'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['jenis_surat'] ?></td>
					<td><?php echo $tampil['tglmulaisppd'] ?></td>
					<td><?php echo $tampil['tglselesaisppd'] ?></td>
					<td><?php echo $tampil['statussurat'] ?></td>
					<td>Rp.<?php echo $tampil['uang_saku'] ?></td>	
				</tr>
				<?php
						}
					}
				?>
			</table>
		</div>
				<?php	
		}
		else if ($aksi=="report") 
		{
		?>
		<div class="up">
			<p>Data SPPD</p>
		</div>
		<div class="data">
			<table border="1">
			<tr>
					<td colspan="8">
						<form method="POST" action="sppd2.php?aksi=print">
						Tanggal mulai : <input type="date" name="awal" class="search2">
						Tanggal selesai : <input type="date" name="akhir" class="search2">
						<input type="submit" name="search" value="PRINT" class="button2">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">No Surat</th>
					<th width="200">Nama Pegawai</th>
					<th width="150">Tgl Pengajuan Surat</th>
					<th width="200">Jenis Surat</th>
					<th width="150">Tgl Mulai SPPD</th>
					<th width="150">Tgl Selesai SPPD</th>
					<th width="200">Status Surat</th>
					<th width="200">Uang Saku</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM pengajuan_surat_perjalanan_dinas JOIN pegawai_honorer USING(kode_pegawai) JOIN surat_perjalanan_dinas USING(kode_pengajuan_surat)");
					while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['no_surat'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['jenis_surat'] ?></td>
					<td><?php echo $tampil['tglmulaisppd'] ?></td>
					<td><?php echo $tampil['tglselesaisppd'] ?></td>
					<td><?php echo $tampil['statussurat'] ?></td>
					<td>Rp.<?php echo $tampil['uang_saku'] ?></td>	
				</tr>
			<?php	
			}
		?>
		</table>
		</div>

		<?php
		}
		else if($aksi =="print")
		{
		?>
		<div class="up">
			<p>Data Sppd | Sisga</p>
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
					<th width="150">No Surat</th>
					<th width="200">Nama Pegawai</th>
					<th width="150">Tgl Pengajuan Surat</th>
					<th width="200">Jenis Surat</th>
					<th width="150">Tgl Mulai SPPD</th>
					<th width="150">Tgl Selesai SPPD</th>
					<th width="200">Status Surat</th>
					<th width="200">Uang Saku</th>
				</tr>
				<?php
					if (isset($_POST['search'])) {
						$awal = $_POST['awal'];
						$akhir = $_POST['akhir'];
						$query = mysqli_query($connect, "SELECT * FROM pengajuan_surat_perjalanan_dinas JOIN pegawai_honorer USING(kode_pegawai) JOIN surat_perjalanan_dinas USING(kode_pengajuan_surat) WHERE tglmulaisppd = '$awal' AND tglselesaisppd = '$akhir'");
						while ($tampil = mysqli_fetch_array($query)) {
							?>
							<tr>
								<td><?php echo $tampil['no_surat'] ?></td>
								<td><?php echo $tampil['nama_pegawai'] ?></td>
								<td><?php echo $tampil['tgl_pengajuan_surat'] ?></td>
								<td><?php echo $tampil['jenis_surat'] ?></td>
								<td><?php echo $tampil['tglmulaisppd'] ?></td>
								<td><?php echo $tampil['tglselesaisppd'] ?></td>
								<td><?php echo $tampil['statussurat'] ?></td>
								<td>Rp.<?php echo $tampil['uang_saku'] ?></td>	
							</tr>
				<?php
						}	
					}
		?>
		<tr>
			<td colspan="8">&nbsp;</td>
		</tr>
		 <tr style="height: 200px">
		    <td colspan="4">&nbsp;</td>
		    <td align="center" colspan="4">
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
		?>
	</section>
</body>
<?php?>
</html>
