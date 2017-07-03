<!--************************** PAGINA na Inloggen *****************************-->
<!DOCTYPE html>
<html lang="nl">
	<head>
    	<title>Welkom <?= $this->session->userdata('username') ?></title>
	</head>
	<body>
		<h2>Proficiat! u bent succesvol ingelogd onder de naam: <?= $this->session->userdata('username') ?></h2>
		<a href="<?= site_url('home/logout') ?>"><i class="fa fa-fw fa-power-off"></i>=> Uitloggen</a>                        
	</body>
</html>
