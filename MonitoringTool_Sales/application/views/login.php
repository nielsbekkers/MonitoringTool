<!--************************** HOMEPAGINA *****************************-->
<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html; charset=utf-8" />
		<title>Inloggen!</title>
                <link rel = "stylesheet" type = "text/css" href = "<?php echo base_url(); ?>/assets/css/style.css">
	</head>
	<body>
		<center>
			<div id="login-form">
				<form method="post">
				<h1>Inloggen</h1>
					<table align="center" width="30%" border="0">
						<tr>
                            <td><input type="text" name="username" placeholder="Gebruikersnaam" required /></td><br/>
						</tr>
						<tr>
                            <td><input type="text" name="password" placeholder="Wachtwoord" required /></td><br/>               
						</tr>
						<tr>
							<td><button type="submit" name="btn-login">Inloggen</button></td>
						</tr>
						<tr>
                            <td><a href="<?php echo site_url('Registreer'); ?>" id="linkhomepagina"><img src="https://image.freepik.com/free-icon/home_318-42210.png"width="30" height="30"/>&nbsp;Registreren</a></td>
						</tr>
					</table>
				</form>
			</div>
		</center>
	</body>
</html>