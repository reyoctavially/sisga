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
			<p>Pengajuan Cuti </p>
		</div>
		<div class="data">
			<table border="1">
			<tr>
					<td colspan="9">
						<form method="POST" action="cuti.php?aksi=search">
							<input type="submit" name="submit" value="Search" class="button1">
							<input type="text" name="search" placeholder="Search ..." class="search">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Pengajuan Cuti</th>
					<th width="200">Nama Pegawai</th>
					<th width="150">Tgl Pengajuan Cuti</th>
					<th width="200">Alasan</th>
					<th width="150">Tgl Mulai Cuti</th>
					<th width="150">Tgl Selesa Cuti</th>
					<th width="200">Status Pengajuan Cuti</th>
					<th width="200">Keterangan Pengajuan Cuti</th>
					<th width="250">Action</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM pengajuan_cuti JOIN pegawai_honorer USING(kode_pegawai)");
					while ($tampil = mysqli_fetch_array($query)) {
						$status = $tampil['status_pengajuan_cuti'];
				?>
				<tr>
					<td><?php echo $tampil['kode_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['alasan_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['tgl_mulai_cuti'] ?></td>
					<td><?php echo $tampil['tgl_selesai_cuti'] ?></td>
					<td><?php echo $tampil['status_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['ket_pengajuan_cuti'] ?></td>
					<?php
						if ($status == "Disetujui" OR $status == "Ditolak") {
							?>
								<td>&nbsp;</td>
							<?php
						} else {
							?>
								<td><center><a href="cuti.php?aksi=tambah&id=<?php echo $tampil['kode_pengajuan_cuti'] ?>" disabled class="ed">ACC</a> <a href="cuti.php?aksi=tolak&id=<?php echo $tampil['kode_pengajuan_cuti'] ?>" disabled class="del">TOLAK</a></center></td>
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
			$query = mysqli_query($connect, "SELECT * FROM pengajuan_cuti JOIN pegawai_honorer USING(kode_pegawai) WHERE kode_pengajuan_cuti = '$id'");
			$rowkode = mysqli_fetch_array($query);
			?>
				<form method="POST">
					<div class="tambah">
						<h3>PROSES PENGAJUAN CUTI</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<tr>
								<td>Kode Pengajuan Cuti</td>
								<td name="kode">: <?php echo $rowkode['kode_pengajuan_cuti'] ?></td>
								<td width="50px"></td>
								<td>Nama Pegawai</td>
								<td>: <?php echo $rowkode['nama_pegawai'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Pengajuan Cuti</td>
								<td>: <?php echo $rowkode['tgl_pengajuan_cuti'] ?></td>
								<td width="50px"></td>
								<td>Alasan Pengajuan Cuti</td>
								<td>: <?php echo $rowkode['alasan_pengajuan_cuti'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Mulai Cuti</td>
								<td>: <?php echo $rowkode['tgl_mulai_cuti'] ?></td>
								<td width="50px"></td>
								<td>Tanggal Selesai Cuti</td>
								<td>: <?php echo $rowkode['tgl_selesai_cuti'] ?></td>
							</tr>
							<tr>
								<td>Status Pengajuan Cuti</td>
								<td>: <?php echo $rowkode['status_pengajuan_cuti'] ?></td>
								<td width="50px"></td>
								<td>Keterangan Pengajuan Cuti</td>
								<td>: <?php echo $rowkode['ket_pengajuan_cuti'] ?></td>
							</tr>
						</table>
						<br/>
						<h3>PROSES DATA CUTI</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<?php
								$get = mysqli_query($connect, "SELECT kode_cuti FROM cuti ORDER BY kode_cuti DESC");
								$row = mysqli_fetch_array($get);
								$split = explode('-', $row['kode_cuti']);
								$number = str_pad($split[1]+1,3,0, STR_PAD_LEFT);
								$code = "CT-".$number;
							?>
							<input type="hidden" name="kode_cuti" value="<?php echo $code ?>">
							<br/>
							<tr>
								<td>
									<select name="jenis_cuti" class="search2">
										<option>Cuti Kecil</option>
										<option>Cuti Besar</option>
									</select>
								</td>
							</tr>
							<tr>
								<td><input type="Text" name="pemotongan_honor" placeholder="Pemotongan Honor" required></td>
							</tr>
							<tr>
								<td>
									<button name="simpan" class="pilih">Simpan</button>
								</td>	
							</tr>
							<?php
								if (isset($_POST['simpan'])) {
								$kpc = $rowkode['kode_pengajuan_cuti'];
								$jeniscuti = $_POST['jenis_cuti'];
								$pemotonganhonor = $_POST['pemotongan_honor'];
								$tglmulai = $rowkode['tgl_mulai_cuti'];
								$tglselesai = $rowkode['tgl_selesai_cuti'];
								$status = "Berlaku";
								$kode = $rowkode['kode_pegawai'];
								$nip = "19820614 200901 1 005";
								$tambah = mysqli_query($connect, "INSERT INTO cuti VALUES ('$code','$jeniscuti','$pemotonganhonor','$tglmulai','$tglselesai','$status','$kode','$nip','$kpc')");
								$update = mysqli_query($connect, "UPDATE pengajuan_cuti SET status_pengajuan_cuti = 'Disetujui', ket_pengajuan_cuti = 'Cuti telah disetujui' WHERE kode_pengajuan_cuti = '$kpc'");
								if ($tambah) {
									echo "<script language='javascript'>
									alert('Data berhasil disimpan')</script>";
									?>
										<meta http-equiv="refresh" content="1;url=cuti.php?aksi=tampil">
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
			$query = mysqli_query($connect, "SELECT * FROM pengajuan_cuti JOIN pegawai_honorer USING(kode_pegawai) WHERE kode_pengajuan_cuti = '$id'");
			$rowkode = mysqli_fetch_array($query);
			?>
				<form method="POST">
					<div class="tambah">
						<h3>PROSES PENGAJUAN CUTI</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<tr>
								<td>Kode Pengajuan Cuti</td>
								<td>: <?php echo $rowkode['kode_pengajuan_cuti'] ?></td>
								<td width="50px"></td>
								<td>Nama Pegawai</td>
								<td>: <?php echo $rowkode['nama_pegawai'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Pengajuan Cuti</td>
								<td>: <?php echo $rowkode['tgl_pengajuan_cuti'] ?></td>
								<td width="50px"></td>
								<td>Alasan Pengajuan Cuti</td>
								<td>: <?php echo $rowkode['alasan_pengajuan_cuti'] ?></td>
							</tr>
							<tr>
								<td>Tanggal Mulai Cuti</td>
								<td>: <?php echo $rowkode['tgl_mulai_cuti'] ?></td>
								<td width="50px"></td>
								<td>Tanggal Selesai Cuti</td>
								<td>: <?php echo $rowkode['tgl_selesai_cuti'] ?></td>
							</tr>
							<tr>
								<td>Status Pengajuan Cuti</td>
								<td>: <?php echo $rowkode['status_pengajuan_cuti'] ?></td>
								<td width="50px"></td>
								<td>Keterangan Pengajuan Cuti</td>
								<td>: <?php echo $rowkode['ket_pengajuan_cuti'] ?></td>
							</tr>
						</table>
						<br/>
						<h3>PROSES DATA CUTI</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<tr>
								<td>
									<textarea name="ket_penolakan" placeholder="Keterangan penolakan cuti"></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<button name="tolak" class="pilih">Simpan</button>
								</td>	
							</tr>
							<?php
								if (isset($_POST['tolak'])) {
								$kpc = $rowkode['kode_pengajuan_cuti'];
								$ket = $_POST['ket_penolakan'];
								$update = mysqli_query($connect, "UPDATE pengajuan_cuti SET status_pengajuan_cuti = 'Ditolak', ket_pengajuan_cuti = '$ket' WHERE kode_pengajuan_cuti = '$kpc'");
								if ($update) {
									echo "<script language='javascript'>
									alert('Data berhasil disimpan')</script>";
									?>
										<meta http-equiv="refresh" content="1;url=cuti.php?aksi=tampil">
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
			<p>Pengajuan Cuti </p>
		</div>
		<div class="data">
			<table border="1">
			<tr>
					<td colspan="9">
						<form method="POST" action="cuti.php?aksi=search">
							<input type="submit" name="submit" value="Search" class="button1">
							<input type="text" name="search" placeholder="Search ..." class="search">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Pengajuan Cuti</th>
					<th width="200">Nama Pegawai</th>
					<th width="150">Tgl Pengajuan Cuti</th>
					<th width="200">Alasan</th>
					<th width="150">Tgl Mulai Cuti</th>
					<th width="150">Tgl Selesa Cuti</th>
					<th width="200">Status Pengajuan Cuti</th>
					<th width="200">Keterangan Pengajuan Cuti</th>
					<th width="250">Action</th>
				</tr>
				<?php
					if (isset($_POST['search'])) {
						$search = $_POST['search'];
						$query = mysqli_query($connect, "SELECT * FROM pengajuan_cuti JOIN pegawai_honorer USING(kode_pegawai)  WHERE nama_pegawai LIKE '%$search%' OR kode_pengajuan_cuti LIKE '%$search%' OR tgl_pengajuan_cuti LIKE '%$search%' OR alasan_pengajuan_cuti LIKE '%$search%' OR tgl_mulai_cuti LIKE '%$search%' OR tgl_selesai_cuti LIKE '%$search%' OR status_pengajuan_cuti LIKE '%$search%' OR ket_pengajuan_cuti LIKE '%$search%'");
						while ($tampil = mysqli_fetch_array($query)) {
							$status = $tampil['status_pengajuan_cuti'];
				?>
				<tr>
					<td><?php echo $tampil['kode_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['tgl_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['alasan_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['tgl_mulai_cuti'] ?></td>
					<td><?php echo $tampil['tgl_selesai_cuti'] ?></td>
					<td><?php echo $tampil['status_pengajuan_cuti'] ?></td>
					<td><?php echo $tampil['ket_pengajuan_cuti'] ?></td>
					<?php
						if ($status == "Disetujui" OR $status == "Ditolak") {
							?>
								<td>&nbsp;</td>
							<?php
						} else {
							?>
								<td><center><a href="cuti.php?aksi=tambah&id=<?php echo $tampil['kode_pengajuan_cuti'] ?>" disabled class="ed">ACC</a> <a href="cuti.php?aksi=tolak&id=<?php echo $tampil['kode_pengajuan_cuti'] ?>" disabled class="del">TOLAK</a></center></td>
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