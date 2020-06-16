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
			<p>Data Pegawai </p>
		</div>
		<div class="data">
			<table border="1">
				<tr>
					<td colspan="8">
						<form method="POST" action="detail.php?aksi=search">
							<input type="submit" name="submit" value="Search" class="button1">
							<input type="text" name="search" placeholder="Search ..." class="search">
						</form>
					</td>
				</tr>
				<tr>
					<th width="150">Kode Pegawai</th>
					<th width="200">Nama Pegawai</th>
					<th width="200">Jabatan Pegawai</th>
					<th width="200">Email Pegawai</th>
					<th width="150">Telp Pegawai</th>
					<th width="200">No Rekening</th>
					<th>Alamat</th>
					<th width="200">Action</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM pegawai_honorer");
					while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['kode_pegawai'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['jabatan_pegawai'] ?></td>
					<td><?php echo $tampil['email_pegawai'] ?></td>
					<td><?php echo $tampil['telp_pegawai'] ?></td>
					<td><?php echo $tampil['no_rekening_pegawai'] ?></td>
					<td><?php echo $tampil['jalan_pegawai'] ?>, <?php echo $tampil['rt_rw_pegawai'] ?>, <?php echo $tampil['no_rumah_pegawai'] ?>, <?php echo $tampil['kota_pegawai'] ?>, <?php echo $tampil['kode_pos_pegawai'] ?></td>
					<td><center><a href="detail.php?aksi=edit&id=<?php echo $tampil['kode_pegawai'] ?>" disabled class="ed">EDIT</a> <a href="detail.php?aksi=hapus&id=<?php echo $tampil['kode_pegawai'] ?>" disabled class="del">DELETE</a></center></td>
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
			<p>Data pegawai | Sisga <a href="detail.php?aksi=print" class="print">PRINT</a></p>
		</div>
		<div class="data">
			<table border="1">
				<tr>
					<th width="150">Kode Pegawai</th>
					<th width="200">Nama Pegawai</th>
					<th width="200">Jabatan Pegawai</th>
					<th width="200">Email Pegawai</th>
					<th width="150">Telp Pegawai</th>
					<th width="200">No Rekening</th>
					<th>Alamat</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM pegawai_honorer");
					while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['kode_pegawai'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['jabatan_pegawai'] ?></td>
					<td><?php echo $tampil['email_pegawai'] ?></td>
					<td><?php echo $tampil['telp_pegawai'] ?></td>
					<td><?php echo $tampil['no_rekening_pegawai'] ?></td>
					<td><?php echo $tampil['jalan_pegawai'] ?>, <?php echo $tampil['rt_rw_pegawai'] ?>, <?php echo $tampil['no_rumah_pegawai'] ?>, <?php echo $tampil['kota_pegawai'] ?>, <?php echo $tampil['kode_pos_pegawai'] ?></td>
				</tr>
			<?php	
			}
		?>
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		 <tr style="height: 200px">
		    <td colspan="4">&nbsp;</td>
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
	else if($aksi =="print")
		{
			?>
		<div class="up">
			<p>Data pegawai | Sisga</p>
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
					<th width="150">Kode Pegawai</th>
					<th width="200">Nama Pegawai</th>
					<th width="200">Jabatan Pegawai</th>
					<th width="200">Email Pegawai</th>
					<th width="150">Telp Pegawai</th>
					<th width="200">No Rekening</th>
					<th>Alamat</th>
				</tr>
				<?php
					$query = mysqli_query($connect, "SELECT * FROM pegawai_honorer");
					while ($tampil = mysqli_fetch_array($query)) {
				?>
				<tr>
					<td><?php echo $tampil['kode_pegawai'] ?></td>
					<td><?php echo $tampil['nama_pegawai'] ?></td>
					<td><?php echo $tampil['jabatan_pegawai'] ?></td>
					<td><?php echo $tampil['email_pegawai'] ?></td>
					<td><?php echo $tampil['telp_pegawai'] ?></td>
					<td><?php echo $tampil['no_rekening_pegawai'] ?></td>
					<td><?php echo $tampil['jalan_pegawai'] ?>, <?php echo $tampil['rt_rw_pegawai'] ?>, <?php echo $tampil['no_rumah_pegawai'] ?>, <?php echo $tampil['kota_pegawai'] ?>, <?php echo $tampil['kode_pos_pegawai'] ?></td>
				</tr>
			<?php	
			}
		?>
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		 <tr style="height: 200px">
		    <td colspan="4">&nbsp;</td>
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
		else if($aksi =="tambah")
		{
			?>
				<form method="POST">
					<div class="tambah">
						<h3>TAMBAH DATA PEGAWAI</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<?php
								$get = mysqli_query($connect, "SELECT * FROM pegawai_honorer ORDER BY kode_pegawai DESC");
								$row = mysqli_fetch_array($get);
								$split = explode('-', $row['kode_pegawai']);
								$nip_kasi = $row['nip_kasi'];
								$number = str_pad($split[1]+1,3,0, STR_PAD_LEFT);
								$code = "PG-".$number;
							?>
							<input type="hidden" name="kode_pegawai" value="<?php echo $code ?>">
							<tr>
								<td colspan="2"><input type="hidden" name="nip_kasi" value="<?php echo $nip_kasi ?>"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="Text" name="nama_pegawai" placeholder="Nama Lengkap" required></td>
							</tr>
							<tr>
								<td colspan="2"><input type="Text" name="jabatan_pegawai" placeholder="Jabatan" required></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="email_pegawai" placeholder="Alamat Email" required></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="telp_pegawai" placeholder="Nomor Telepon" required></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="no_rekening_pegawai" placeholder="No Rekening" required></td>
							</tr>
							<tr>
									<td colspan="2">
											Alamat Lengkap : 
									</td>
							</tr>
							<tr>
								<td><input type="text" name="jalan_pegawai" placeholder="Jalan" required></td>
								<td><input type="text" name="kec_pegawai" placeholder="Kecamatan" required></td>
								<td><input type="text" name="kota_pegawai" placeholder="Kota" required></td>
							</tr>
							<tr>
								<td><input type="text" name="no_rumah_pegawai" placeholder="No Rumah" required></td>
								<td><input type="text" name="rt_rw_pegawai" placeholder="RT/RW" required></td>
								<td><input type="text" name="kode_pos_pegawai" placeholder="Kode Pos" required></td>
							</tr>
							<tr>
									<td colspan="2">
											Alamat Log In : 
									</td>
							</tr>
							<tr>
								<td><input type="text" name="username_pegawai" placeholder="Username Pegawai" required></td>
								<td><input type="text" name="pass_pegawai" placeholder="Password" required></td>
							</tr>
							<tr>
								<td colspan="2">
									<button type="submit" name="simpan" class="pilih">Simpan</button>
								</td>	
							</tr>
							<?php
								if (isset($_POST['simpan'])) {
								$code = $_POST['kode_pegawai'];	
								$nama = $_POST['nama_pegawai'];
								$jabatan = $_POST['jabatan_pegawai'];
								$email = $_POST['email_pegawai'];
								$telp = $_POST['telp_pegawai'];
								$noreg = $_POST['no_rekening_pegawai'];
								$jalan = $_POST['jalan_pegawai'];
								$rumah = $_POST['no_rumah_pegawai'];
								$rt = $_POST['rt_rw_pegawai'];
								$kec = $_POST['kec_pegawai'];
								$kota = $_POST['kota_pegawai'];
								$pos = $_POST['kode_pos_pegawai'];
								$Username = $_POST['username_pegawai'];
								$pass = $_POST['pass_pegawai'];
								$nip = $_POST['nip_kasi'];
								$query = mysqli_query($connect, "INSERT INTO pegawai_honorer(kode_pegawai,nama_pegawai, jabatan_pegawai, email_pegawai, telp_pegawai, no_rekening_pegawai, jalan_pegawai, no_rumah_pegawai, rt_rw_pegawai, kec_pegawai, kota_pegawai, kode_pos_pegawai, username_pegawai, pass_pegawai, nip_kasi) VALUES ('$code','$nama','$jabatan','$email','$telp','$noreg','$jalan','$rumah','$rt','$kec','$kota','$pos','$username','$pass','$nip')");


								if ($query) {
									echo "<script language='javascript'>
									alert('Data berhasil disimpan')</script>";
									?>
										<meta http-equiv="refresh" content="1;url=detail.php?aksi=tampil">
									<?php
								} else {
									echo "<script language='javascript'>
									alert('Data gagal disimpan ".$query."')</script>";
								}
								}
							?>
						</table>
					</div>
				</form>
			<?php
		}
		else if($aksi =="edit")
		{
			$id=$_GET['id'];
			$query = mysqli_query($connect, "SELECT * FROM pegawai_honorer WHERE kode_pegawai = '$id'");
			$row = mysqli_fetch_array($query);
				?>
					<form method="POST">
					<div class="tambah">
						<h3>EDIT DATA PEGAWAI</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<tr>
								<td colspan="2"><input type="Text" name="nama_pegawai" value="<?php echo $row['nama_pegawai'] ?>"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="Text" name="jabatan_pegawai" value="<?php echo $row['jabatan_pegawai'] ?>"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="email_pegawai" value="<?php echo $row['email_pegawai'] ?>"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="telp_pegawai" value="<?php echo $row['telp_pegawai'] ?>"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="Text" name="no_rekening_pegawai" value="<?php echo $row['no_rekening_pegawai'] ?>"></td>
							</tr>
							<tr>
									<td colspan="2">
											Alamat Lengkap : 
									</td>
							</tr>
							<tr>
								<td><input type="text" name="jalan_pegawai" value="<?php echo $row['jalan_pegawai'] ?>"></td>
								<td><input type="text" name="kota_pegawai" value="<?php echo $row['kota_pegawai'] ?>"></td>
							</tr>
							<tr>
								<td><input type="text" name="no_rumah_pegawai" value="<?php echo $row['no_rumah_pegawai'] ?>"></td>
								<td><input type="text" name="rt_rw_pegawai" value="<?php echo $row['rt_rw_pegawai'] ?>"></td>
								<td><input type="text" name="kode_pos_pegawai" value="<?php echo $row['kode_pos_pegawai'] ?>"></td>
							</tr>
							<tr>
								<td colspan="2">
									<button name="update" class="pilih">Update</button>									
								</td>	
							</tr>
							<?php
								if (isset($_POST['update'])) {
								$nama = $_POST['nama_pegawai'];
								$jabatan = $_POST['jabatan_pegawai'];
								$email = $_POST['email_pegawai'];
								$telp = $_POST['telp_pegawai'];
								$noreg = $_POST['no_rekening_pegawai'];
								$jalan = $_POST['jalan_pegawai'];
								$kota = $_POST['kota_pegawai'];
								$rumah = $_POST['no_rumah_pegawai'];
								$rt = $_POST['rt_rw_pegawai'];
								$pos = $_POST['kode_pos_pegawai'];
								$query = mysqli_query($connect, "UPDATE pegawai_honorer SET nama_pegawai='$nama', jabatan_pegawai='$jabatan', email_pegawai='$email', telp_pegawai='$telp', kota_pegawai='$kota', rt_rw_pegawai='$rt', no_rumah_pegawai='$rumah', jalan_pegawai='$jalan', kode_pos_pegawai='$pos' WHERE kode_pegawai='$id'");
								if ($query) {
									echo "<script language='javascript'>
									alert('Data berhasil diupdate')</script>";
									?>
										<meta http-equiv="refresh" content="1;url=detail.php?aksi=tampil">
									<?php
								} else {
									echo "<script language='javascript'>
									alert('Data gagal diupdate')</script>";
								}
								}
							?>
						</table>
					</div>
				</form>
				<?php
			}
			else if($aksi =="hapus")
			{
				$id=$_GET['id'];
			$query = mysqli_query($connect, "SELECT * FROM pegawai_honorer WHERE kode_pegawai = '$id'");
			$row = mysqli_fetch_array($query);
				?>
					<form method="POST">
					<div class="tambah">
						<h3>HAPUS DATA PEGAWAI</h3>
						<br/>
						<hr size="1" width="100%" color="grey">
						<table>
							<tr>
								<td colspan="2"><input type="Text" name="nama_pegawai" value="<?php echo $row['nama_pegawai'] ?>" disabled></td>
							</tr>
							<tr>
								<td colspan="2"><input type="Text" name="jabatan_pegawai" value="<?php echo $row['jabatan_pegawai'] ?>" disabled></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="email_pegawai" value="<?php echo $row['email_pegawai'] ?>" disabled></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="telp_pegawai" value="<?php echo $row['telp_pegawai'] ?>" disabled></td>
							</tr>
							<tr>
								<td colspan="2"><input type="Text" name="no_rekening_pegawai" value="<?php echo $row['no_rekening_pegawai'] ?>" disabled></td>
							</tr>
							<tr>
									<td colspan="2">
											Alamat Lengkap : 
									</td>
							</tr>
							<tr>
								<td><input type="text" name="jalan_pegawai" value="<?php echo $row['jalan_pegawai'] ?>" disabled></td>
								<td><input type="text" name="kota_pegawai" value="<?php echo $row['kota_pegawai'] ?>" disabled></td>
							</tr>
							<tr>
								<td><input type="text" name="no_rumah_pegawai" value="<?php echo $row['no_rumah_pegawai'] ?>" disabled></td>
								<td><input type="text" name="rt_rw_pegawai" value="<?php echo $row['rt_rw_pegawai'] ?>" disabled></td>
								<td><input type="text" name="kode_pos_pegawai" value="<?php echo $row['kode_pos_pegawai'] ?>" disabled></td>
							</tr>
							<tr>
								<td colspan="2">
									<button name="hapus" class="pilih">Hapus</button>
								</td>	
							</tr>
							<?php
								if (isset($_POST['hapus'])) {
								$query = mysqli_query($connect, "DELETE FROM pegawai_honorer WHERE kode_pegawai='$id'");
								if ($query) {
									echo "<script language='javascript'>
									alert('Data berhasil dihapus')</script>";
									?>
										<meta http-equiv="refresh" content="1;url=detail.php?aksi=tampil">
									<?php
								} else {
									echo "<script language='javascript'>
									alert('Data gagal dihapus')</script>";
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
						<p>Data Pegawai </p>
					</div>
					<div class="data">
						<table border="1">
							<tr>
								<td colspan="8">
									<form method="POST">
										<input type="submit" name="submit" value="Search" class="button1">
										<input type="text" name="search" placeholder="Search ..." class="search">
									</form>
								</td>
							</tr>
							<tr>
								<th width="150">Kode Pegawai</th>
								<th width="200">Nama Pegawai</th>
								<th width="200">Jabatan Pegawai</th>
								<th width="200">Email Pegawai</th>
								<th width="150">Telp Pegawai</th>
								<th width="200">No Rekening</th>
								<th>Alamat</th>
								<th width="200">Action</th>
							</tr>
							<?php
							if (isset($_POST['search'])) {
								$search = $_POST['search'];
								$query = mysqli_query($connect, "SELECT * FROM pegawai_honorer WHERE kode_pegawai LIKE '%$search%' OR nama_pegawai LIKE '%$search%' OR jabatan_pegawai LIKE '%$search%' OR telp_pegawai LIKE '%$search%' OR no_rekening_pegawai LIKE '%$search%' OR jalan_pegawai LIKE '%$search%' OR no_rumah_pegawai LIKE '%$search%' OR rt_rw_pegawai LIKE '%$search%' OR kec_pegawai LIKE '%$search%'OR kota_pegawai LIKE '%$search%' OR kode_pos_pegawai LIKE '%$search%'");
								while ($tampil = mysqli_fetch_array($query)) {
							?>
							<tr>
								<td><?php echo $tampil['kode_pegawai'] ?></td>
								<td><?php echo $tampil['nama_pegawai'] ?></td>
								<td><?php echo $tampil['jabatan_pegawai'] ?></td>
								<td><?php echo $tampil['email_pegawai'] ?></td>
								<td><?php echo $tampil['telp_pegawai'] ?></td>
								<td><?php echo $tampil['no_rekening_pegawai'] ?></td>
								<td><?php echo $tampil['jalan_pegawai'] ?>, <?php echo $tampil['rt_rw_pegawai'] ?>, <?php echo $tampil['no_rumah_pegawai'] ?>, <?php echo $tampil['kota_pegawai'] ?>, <?php echo $tampil['kode_pos_pegawai'] ?></td>
								<td><center><a href="detail.php?aksi=edit&id=<?php echo $tampil['kode_pegawai'] ?>" disabled class="ed">EDIT</a> <a href="detail.php?aksi=hapus&id=<?php echo $tampil['kode_pegawai'] ?>" disabled class="del">DELETE</a></center></td>
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