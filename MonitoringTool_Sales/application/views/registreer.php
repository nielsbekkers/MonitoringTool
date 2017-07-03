<!--************************** REGISTREERPAGINA *****************************-->
<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html; charset=utf-8" />
		<title>Registreer Jezelf!</title>
                <link rel = "stylesheet" type = "text/css" href = "<?php echo base_url(); ?>/assets/css/style.css">
	</head>
	<body>
            
            <p><?php if($this->session->flashdata('flashSuccess')):?>
                <p class='flashMsg flashSuccess'> <?=$this->session->flashdata('flashSuccess')?> </p>
                    <?php endif?></p>
        
		<center>
			<div id="login-form">
                            <!--<h1><img src="https://cdn0.iconfinder.com/data/icons/academics-linear-black/2048/Register-512.png" width="80"height="80"/>Gelieve te registreren</h1>-->
				<form method="post">
					<table align="center" width="30%" border="0">
						<tr>
                                                    <td><input class="form-control" name="username" placeholder="Gebruikersnaam" type="text" value="<?php echo set_value('username'); ?>" /></td><br/>
                                                        <td><span class="text-danger"><?php echo form_error('username'); ?></span></td>
						</tr>
						<tr>
                                                    <td><input class="form-control" name="password" placeholder="Wachtwoord" type="password" /></td><br/>
                                                        <td><span class="text-danger"><?php echo form_error('password'); ?></span></td>
						</tr>
						<tr>
							<td><button type="submit" name="btn-signup">Registreer</button></td>
						</tr>
						<tr>
                                                    <td><a href="login" id="linkhomepagina"><img src="https://image.freepik.com/free-icon/home_318-42210.png"width="30" height="30"/>&nbsp;Home Pagina</a></td>
						</tr>
					</table>
				</form>
			</div>
		</center>
	</body>
</html>

