<!DOCTYPE html>
<html>
<head>
	<title>Sisga</title>
	<link rel="stylesheet" type="text/css" href="css/login_style.css">
	<?php
		include "config.php";
	?>
</head>
<body>
	<form method="post" action="ceklogin.php">
		<div id="utama">
			<header>
				<p>Sign In</p>
			</header>
			<section>
				<table>
					<tr>
						<td><input type="text" name="username" placeholder="Username" requicyan></td>
					</tr>
					<tr>
						<td><input type="password" name="password" placeholder="password" requicyan></td>
					</tr>
					<tr>
						<td><input type="submit" name="login" value="LOGIN" class="login"></td>
					</tr>
				</table>
			</section>
		</div>
	</form>
</body>
</html>