<!--************************** Vertegenwoordiger pagina *****************************-->
<!DOCTYPE html>
<html lang="nl">
	<head>
    	<title>Welkom <?= $this->session->userdata('username') ?></title>
	</head>
	<body>
		<h2>Beste <?= $this->session->userdata('username') ?> ,registreer uw verkoop: </h2>
                <form method="post" >
                <?php echo $this->sCustomersSelect ?><br>
                <?php echo $this->sProductTypesSelect ?><br>
                <input type="number" name="amountOfProducts" /><br>
                <button value="Order" name="SalesFormButton" >Order</button><br>
                </form>
		<a href="<?= site_url('home/logout') ?>"><i class="fa fa-fw fa-power-off"></i>=> Uitloggen</a>                        
	</body>
</html>
