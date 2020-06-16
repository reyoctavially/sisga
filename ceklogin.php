<!DOCTYPE html>
<html>
<head>
	<title>Sisga</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<section>
	<?php
	session_start();
	if (isset($_POST['login'])) {
		include "config.php";
		$username = $_POST['username'];
		$pass = $_POST['password'];
		$_SESSION['username'] = "$username";
		$_SESSION['password'] = "$pass";
		$sql="select *from kepala_seksi where username_kasi='$username' and pass_kasi='$pass'";
		$result=mysqli_query($connect, $sql);

		if ($data=mysqli_fetch_array($result)) {
			?>
				<meta http-equiv="refresh" content="1;url=beranda.php">
			<?php
		}else {
			?>
			<div class="ceklogin">
			<p>
				Maaf Username atau password salah, <br/>
				Klik <a href="index.php"> DISINI </a> untuk kembali
			</p>
			</div>
			<?php
		}

	}
	?>
</section>
</body>
</html>