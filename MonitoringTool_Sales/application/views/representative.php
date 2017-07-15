<!--************************** Vertegenwoordiger pagina *****************************-->
<!DOCTYPE html>
<html lang="nl">
	<head>
    	<title>Welkom <?= $this->session->userdata('username') ?></title>
        <link rel = "stylesheet" type = "text/css" href = "<?php echo base_url(); ?>/assets/css/style.css">
	</head>
	<body>
            <center>
            <div id="login-form">
                <h2>Beste <?= $this->session->userdata('username') ?> ,registreer uw verkoop: </h2> <br>
                <?php echo validation_errors(); ?>
                <?php echo form_open('representative'); ?>
                    <table align="center" width="30%" border="0">
                        <tr><td>
                    <?php echo $this->sCustomersSelect ?><br>
                            </td></tr><tr><td>
                    <?php echo $this->sProductTypesSelect ?><br>
                    </td></tr><tr><td>
                    <input type="number" name="amountOfProducts" /><br>
                    </td></tr><tr><td>
                    <button value="Order" name="SalesFormButton" >Order</button><br>
                    </td></tr>
                    </table>
                    </form>
                    <a href="<?= site_url('home/logout') ?>"><i class="fa fa-fw fa-power-off"></i>=> Uitloggen</a>         
            </div>
            </center>
	</body>
</html>
