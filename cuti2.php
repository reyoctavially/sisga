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
			<p>Data Cuti </p>
		</div>
		<div class="data">
			<table border="1">
			<tr>
					<td colspan="10">
						<form method="POST" action="cuti2.php?aksi=search">
							<input type="submit" name="submit" value="Search" class="button1">
							<input type="text" name="search" placeholder="Search ..." class="search">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Cuti</th>
					<th width="200">Nama Pegawai</th>
					<th width="200">Jenis Cuti</th>
					<th width="150">Tgl Pengajuan Cuti</th>
					<th width="150">Tgl Mulai Cuti</th>
					<th width="150">Tgl Selesai Cuti</th>
					<th width="200">Pemotongan Honor</th>
					<th width="200">Status Cuti</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM pengajuan_cuti JOIN pegawai_honorer USING(kode_pegawai) JOIN cuti USING(kode_pengajuan_cuti)");
					while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['kode_cuti'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['jenis_cuti'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['tglmulaicuti'] ?></td>
					<td><?php echo $tampil['tglselesaicuti'] ?></td>
					<td>Rp.<?php echo $tampil['pemotongan_honor'] ?></td>
					<td><?php echo $tampil['statuscuti'] ?></td>
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
			<p>Data Cuti</p>
		</div>
		<div class="data">
			<table border="1">
			<tr>
					<td colspan="11">
						<form method="POST" action="cuti2.php?aksi=search">
							<input type="submit" name="submit" value="Search" class="button1">
							<input type="text" name="search" placeholder="Search ..." class="search">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Cuti</th>
					<th width="200">Nama Pegawai</th>
					<th width="200">Jenis Cuti</th>
					<th width="150">Tgl Pengajuan Cuti</th>
					<th width="150">Tgl Mulai Cuti</th>
					<th width="150">Tgl Selesai Cuti</th>
					<th width="200">Pemotongan Honor</th>
					<th width="200">Status Cuti</th>
				</tr>
				<?php
					if (isset($_POST['search'])) {
						$search = $_POST['search'];
						$query = mysqli_query($connect, "SELECT * FROM pengajuan_cuti JOIN pegawai_honorer USING(kode_pegawai) JOIN cuti USING(kode_pengajuan_cuti) WHERE kode_cuti LIKE '%$search%' OR nama_pegawai LIKE '%$search%' OR jenis_cuti LIKE '%$search%' OR tgl_pengajuan_cuti LIKE '%$search%' OR tglmulaicuti LIKE '%$search%' OR tglselesaicuti LIKE '%$search%' OR pemotongan_honor LIKE '%$search%' OR statuscuti LIKE '%$search%'");
						while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['kode_cuti'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['jenis_cuti'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['tglmulaicuti'] ?></td>
					<td><?php echo $tampil['tglselesaicuti'] ?></td>
					<td>Rp.<?php echo $tampil['pemotongan_honor'] ?></td>
					<td><?php echo $tampil['statuscuti'] ?></td>
				</tr>
				<?php
						}
					}
				?>
			</table>
		</div>
				<?php	
		}
		elseif ($aksi=="report")
		{
			?>
		<div class="up">
			<p>Data Cuti </p>
		</div>
		<div class="data">
			<table border="1">
				<tr>
					<td colspan="8">
						<form method="POST" action="cuti2.php?aksi=print">
						Tanggal mulai : <input type="date" name="awal" class="search2">
						Tanggal selesai : <input type="date" name="akhir" class="search2">
						<input type="submit" name="search" value="PRINT" class="button2">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Cuti</th>
					<th width="200">Nama Pegawai</th>
					<th width="200">Jenis Cuti</th>
					<th width="150">Tgl Pengajuan Cuti</th>
					<th width="150">Tgl Mulai Cuti</th>
					<th width="150">Tgl Selesai Cuti</th>
					<th width="200">Pemotongan Honor</th>
					<th width="200">Status Cuti</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM pengajuan_cuti JOIN pegawai_honorer USING(kode_pegawai) JOIN cuti USING(kode_pengajuan_cuti)");
					while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['kode_cuti'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['jenis_cuti'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['tglmulaicuti'] ?></td>
					<td><?php echo $tampil['tglselesaicuti'] ?></td>
					<td>Rp.<?php echo $tampil['pemotongan_honor'] ?></td>
					<td><?php echo $tampil['statuscuti'] ?></td>
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
			<p>Data Cuti | Sisga</p>
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
					<th width="150">Kode Cuti</th>
					<th width="200">Nama Pegawai</th>
					<th width="200">Jenis Cuti</th>
					<th width="150">Tgl Pengajuan Cuti</th>
					<th width="150">Tgl Mulai Cuti</th>
					<th width="150">Tgl Selesai Cuti</th>
					<th width="200">Pemotongan Honor</th>
					<th width="200">Status Cuti</th>
				</tr>
				<?php
					if (isset($_POST['search'])) {
						$awal = $_POST['awal'];
						$akhir = $_POST['akhir'];
						$query = mysqli_query($connect, "SELECT * FROM pengajuan_cuti JOIN pegawai_honorer USING(kode_pegawai) JOIN cuti USING(kode_pengajuan_cuti) WHERE tglmulaicuti = '$awal' AND tglselesaicuti = '$akhir'");
						while ($tampil = mysqli_fetch_array($query)) {
							?>
							<tr>
								<td><?php echo $tampil['kode_cuti'] ?></td>
								<td><?php echo $tampil['nama_pegawai'] ?></td>
								<td><?php echo $tampil['jenis_cuti'] ?></td>
								<td><?php echo $tampil['tgl_pengajuan_cuti'] ?></td>
								<td><?php echo $tampil['tglmulaicuti'] ?></td>
								<td><?php echo $tampil['tglselesaicuti'] ?></td>
								<td>Rp.<?php echo $tampil['pemotongan_honor'] ?></td>
								<td><?php echo $tampil['statuscuti'] ?></td>
							</tr>
				<?php
						}	
					}
		?>
		<tr>
			<td colspan="8">&nbsp;</td>
		</tr>
		 <tr style="height: 200px">
		    <td colspan="5">&nbsp;</td>
		    <td align="center" colspan="3">
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
</html>