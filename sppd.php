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
			<p>Pengajuan SPPD </p>
		</div>
		<div class="data">
			<table border="1">
			<tr>
					<td colspan="9">
						<form method="POST" action="sppd.php?aksi=search">
							<input type="submit" name="submit" value="Search" class="button1">
							<input type="text" name="search" placeholder="Search ..." class="search">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Pengajuan Surat</th>
					<th width="200">Nama Pegawai</th>
					<th width="150">Tgl Pengajuan Surat</th>
					<th width="200">Tujuan Pengajuan Surat</th>
					<th width="150">Tgl Mulai SPPD</th>
					<th width="150">Tgl Selesa SPPD</th>
					<th width="200">Status Pengajuan Surat</th>
					<th width="200">Keterangan Pengajuan SPPD</th>
					<th width="250">Action</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM pengajuan_surat_perjalanan_dinas JOIN pegawai_honorer USING(kode_pegawai)");
					while ($tampil = mysqli_fetch_array($query)) {
						$status = $tampil['status_pengajuan_surat'];
				?>
				<tr>
					<td><?php echo $tampil['kode_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['tujuan_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['tgl_mulai_sppd'] ?></td>
					<td><?php echo $tampil['tgl_selesai_sppd'] ?></td>
					<td><?php echo $tampil['status_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['ket_pengajuan_sppd'] ?></td>
					<?php
					if ($status == "Disetujui" OR $status == "Ditolak") {
						?>
						<td>&nbsp;</td>
						<?php
					}else{
						?>
						<td><center><a href="sppd.php?aksi=tambah&id=<?php echo $tampil['kode_pengajuan_surat'] ?>" disabled class="ed">ACC</a> <a href="sppd.php?aksi=tolak&id=<?php echo $tampil['kode_pengajuan_surat'] ?>" disabled class="del">TOLAK</a></center></td>
						<?php
					}
				?>
				</tr>
			<?php	
			}
		?>
		</table>
		</div>

		<?php
		}
		else if($aksi =="tambah")
		{
			$id=$_GET['id'];
			$query = mysqli_query($connect, "SELECT * FROM pengajuan_surat_perjalanan_dinas JOIN pegawai_honorer USING(kode_pegawai) WHERE kode_pengajuan_surat = '$id'");
			$rowkode = mysqli_fetch_array($query);
			?>
				<form method="POST">
					<div class="tambah">
						<h3>PROSES PENGAJUAN SPPD</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<tr>
								<td>Kode Pengajuan Surat</td>
								<td>: <?php echo $rowkode['kode_pengajuan_surat'] ?></td>
								<td width="50px"></td>
								<td>Nama Pegawai</td>
								<td>: <?php echo $rowkode['nama_pegawai'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Pengajuan Surat</td>
								<td>: <?php echo $rowkode['tgl_pengajuan_surat'] ?></td>
								<td width="50px"></td>
								<td>Tujuan Pengajuan Surat</td>
								<td>: <?php echo $rowkode['tujuan_pengajuan_surat'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Mulai SPPD</td>
								<td>: <?php echo $rowkode['tgl_mulai_sppd'] ?></td>
								<td width="50px"></td>
								<td>Tanggal Selesai SPPD </td>
								<td>: <?php echo $rowkode['tgl_selesai_sppd'] ?></td>
							</tr>
							<tr>
								<td>Status Pengajuan Surat</td>
								<td>: <?php echo $rowkode['status_pengajuan_surat'] ?></td>
								<td width="50px"></td>
								<td>Keterangan Pengajuan SPPD </td>
								<td>: <?php echo $rowkode['ket_pengajuan_sppd'] ?></td>
							</tr>
						</table>
						<br/>
						<h3>PROSES DATA SPPD</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<!-- <?php
								$get = mysqli_query($connect, "SELECT no_surat FROM surat_perjalanan_dinas ORDER BY no_surat DESC");
								$row = mysqli_fetch_array($get);
								$split = explode('-', $row['no_surat']);
								$number = str_pad($split[1]+1,3,0, STR_PAD_LEFT);
								$code = "NS-".$number;
							?> -->
							<input type="hidden" name="no_surat" value="<?php echo $code ?>">
							<br/>
							<tr>
								<td><input type="Text" name="no_surat" placeholder="Nomor Surat" required></td>
							</tr>
							<tr>
								<td>
									<select name="jenis_surat" class="search2">
										<option>Dalam Kota</option>
										<option>Luar Kota</option>
									</select>
								</td>
							</tr>
							<tr>
								<td><input type="Text" name="uang_saku" placeholder="Uang Saku" required></td>
							</tr>
							<tr>
								<td>
									<button name="simpan" class="pilih">Simpan</button>
								</td>	
							</tr>
							<?php
								if (isset($_POST['simpan'])) {
								$kps = $rowkode['kode_pengajuan_surat'];
								$mulai = $rowkode['tgl_mulai_sppd'];
								$selesai = $rowkode['tgl_selesai_sppd'];
								$no_surat = $_POST['no_surat'];
								$jenissurat = $_POST['jenis_surat'];
								$uangsaku = $_POST['uang_saku'];
								$status = "Berlaku";
								$kode = $rowkode['kode_pegawai'];
								$nip = "19820614 200901 1 005";
								$tambah = mysqli_query($connect, "INSERT INTO surat_perjalanan_dinas VALUES ('$no_surat','$jenissurat','$uangsaku','$mulai','$selesai','$status','$kode','$nip','$kps')");
								$update = mysqli_query($connect, "UPDATE pengajuan_surat_perjalanan_dinas SET status_pengajuan_surat = 'Disetujui', ket_pengajuan_sppd = 'SPPD telah disetujui' WHERE kode_pengajuan_surat = '$kps'");
								if ($update) {
									echo "<script language='javascript'>
									alert('Data berhasil disimpan')</script>";
									?>
										<meta http-equiv="refresh" content="1;url=sppd.php?aksi=tampil">
									<?php
								} else {
									echo "<script language='javascript'>
									alert('Data gagal disimpan')</script>";
								}
								}
							?>
						</table>
					</div>
				</form>
				<?php
			}
			else if($aksi =="tolak")
			{
			$id=$_GET['id'];
			$query = mysqli_query($connect, "SELECT * FROM pengajuan_surat_perjalanan_dinas JOIN pegawai_honorer USING(kode_pegawai) WHERE kode_pengajuan_surat = '$id'");
			$rowkode = mysqli_fetch_array($query);
			?>
				<form method="POST">
					<div class="tambah">
						<h3>PROSES PENGAJUAN SPPD</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<tr>
								<td>Kode Pengajuan Surat</td>
								<td>: <?php echo $rowkode['kode_pengajuan_surat'] ?></td>
								<td width="50px"></td>
								<td>Nama Pegawai</td>
								<td>: <?php echo $rowkode['nama_pegawai'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Pengajuan Surat</td>
								<td>: <?php echo $rowkode['tgl_pengajuan_surat'] ?></td>
								<td width="50px"></td>
								<td>Tujuan Pengajuan Surat</td>
								<td>: <?php echo $rowkode['tujuan_pengajuan_surat'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Mulai SPPD</td>
								<td>: <?php echo $rowkode['tgl_mulai_sppd'] ?></td>
								<td width="50px"></td>
								<td>Tanggal Selesai SPPD </td>
								<td>: <?php echo $rowkode['tgl_selesai_sppd'] ?></td>
							</tr>
							<tr>
								<td>Status Pengajuan Surat</td>
								<td>: <?php echo $rowkode['status_pengajuan_surat'] ?></td>
								<td width="50px"></td>
								<td>Keterangan Pengajuan SPPD </td>
								<td>: <?php echo $rowkode['ket_pengajuan_sppd'] ?></td>
							</tr>
						</table>
						<br/>
						<h3>PROSES DATA SPPD</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<tr>
								<td>
									<textarea name="ket_penolakan" placeholder="Keterangan penolakan sppd"></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<button name="tolak" class="pilih">Simpan</button>
									<form method="POST" action="sppd.php?aksi=tampil">
										<button class="batal">Batal</button>
									</form>
								</td>	
							</tr>
							<?php
								if (isset($_POST['tolak'])) {
								$kps = $rowkode['kode_pengajuan_surat'];
								$ket = $_POST['ket_penolakan'];
								$update = mysqli_query($connect, "UPDATE pengajuan_surat_perjalanan_dinas SET status_pengajuan_surat = 'Ditolak', ket_pengajuan_sppd = '$ket' WHERE kode_pengajuan_surat = '$kps'");
								if ($update) {
									echo "<script language='javascript'>
									alert('Data berhasil disimpan')</script>";
									?>
										<meta http-equiv="refresh" content="1;url=sppd.php?aksi=tampil">
									<?php
								} else {
									echo "<script language='javascript'>
									alert('Data gagal disimpan')</script>";
								}
								}
							?>
						</table>
					</div>
				</form>
				<?php
			}	
		elseif ($aksi=="search")
			{
				?>
				<div class="up">
			<p>Pengajuan SPPD </p>
		</div>
		<div class="data">
			<table border="1">
				<tr>
					<td colspan="9">
						<form method="POST" action="sppd.php?aksi=search">
							<input type="submit" name="submit" value="Search" class="button1">
							<input type="text" name="search" placeholder="Search ..." class="search">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Pengajuan Surat</th>
					<th width="200">Nama Pegawai</th>
					<th width="150">Tgl Pengajuan Surat</th>
					<th width="200">Tujuan Pengajuan Surat</th>
					<th width="150">Tgl Mulai SPPD</th>
					<th width="150">Tgl Selesa SPPD</th>
					<th width="200">Status Pengajuan Surat</th>
					<th width="200">Keterangan Pengajuan SPPD</th>
					<th width="250">Action</th>
				</tr>
				<?php
					if (isset($_POST['search'])) {
						$search = $_POST['search'];
						$query = mysqli_query($connect, "SELECT * FROM pengajuan_surat_perjalanan_dinas JOIN pegawai_honorer USING(kode_pegawai)  WHERE nama_pegawai LIKE '%$search%' OR kode_pengajuan_surat LIKE '%$search%' OR tgl_pengajuan_surat LIKE '%$search%' OR tujuan_pengajuan_surat LIKE '%$search%' OR tgl_mulai_sppd LIKE '%$search%' OR tgl_selesai_sppd LIKE '%$search%' OR status_pengajuan_surat LIKE '%$search%' OR ket_pengajuan_sppd LIKE '%$search%'");
						while ($tampil = mysqli_fetch_array($query)) {
							$status = $tampil['status_pengajuan_surat'];
				?>
				<tr>
					<td><?php echo $tampil['kode_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['tujuan_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['tgl_mulai_sppd'] ?></td>
					<td><?php echo $tampil['tgl_selesai_sppd'] ?></td>
					<td><?php echo $tampil['status_pengajuan_surat'] ?></td>
					<td><?php echo $tampil['ket_pengajuan_sppd'] ?></td>
					<?php
						if ($status == "Disetujui" OR $status == "Ditolak") {
							?>
							<td>&nbsp;</td>
							<?php
						}else{
							?>
							<td><center><a href="sppd.php?aksi=tambah&id=<?php echo $tampil['kode_pengajuan_surat'] ?>" disabled class="ed">ACC</a> <a href="sppd.php?aksi=tolak&id=<?php echo $tampil['kode_pengajuan_surat'] ?>" disabled class="del">TOLAK</a></center></td>
						<?php	
						}
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
