<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?><!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Database Error</title>
<style type="text/css">

::selection { background-color: #E13300; color: white; }
::-moz-selection { background-color: #E13300; color: white; }

body {
	background-color: #fff;
	margin: 40px;
	font: 13px/20px normal Helvetica, Arial, sans-serif;
	color: #4F5155;
}

a {
	color: #003399;
	background-color: transparent;
	font-weight: normal;
}

h1 {
	color: #444;
	background-color: transparent;
	border-bottom: 1px solid #D0D0D0;
	font-size: 19px;
	font-weight: normal;
	margin: 0 0 14px 0;
	padding: 14px 15px 10px 15px;
}

code {
	font-family: Consolas, Monaco, Courier New, Courier, monospace;
	font-size: 12px;
	background-color: #f9f9f9;
	border: 1px solid #D0D0D0;
	color: #002166;
	display: block;
	margin: 14px 0 14px 0;
	padding: 12px 10px 12px 10px;
}

#container {
	margin: 10px;
	border: 1px solid #D0D0D0;
	box-shadow: 0 0 8px #D0D0D0;
}

p {
	margin: 12px 15px 12px 15px;
}
</style>
</head>
<body>
	<div id="container">
            <h2> &nbsp;Er heeft zich een algemene database fout voorgedaan! dit kan ontstaan uit de volgende problemen: </h2>
            <ul>
                <li>De gebruiker die u wenst te registreren bestaat al in onze database</li>
                <li>De afspraak die u wenst te maken is al bezet</li>
                <li>U heeft uw profiel nog niet volledig aangevuld: <u><a href='<?php echo site_url('profielUser'); ?>'/>Ga naar mijn profiel</u></li>
            </ul>
            
            <!--<p><a href="<?php echo site_url('login'); ?>"><img border="0" alt="Toevoegen" src="https://cdn2.iconfinder.com/data/icons/windows-8-metro-style/512/left_round.png" width="50" height="50"></a></p>-->
            
            <table align='center'>
                <tr>
                    <td><center><a href="<?php echo site_url('login'); ?>"><img border="0" alt="Toevoegen" src="https://cdn2.iconfinder.com/data/icons/windows-8-metro-style/512/left_round.png" width="50" height="50"></a></center></td>
                    <td><center><a href="<?php echo site_url('afspraakUser'); ?>"><img border="0" alt="Toevoegen" src="https://cdn2.iconfinder.com/data/icons/windows-8-metro-style/512/right_round.png" width="50" height="50"></a></center></td>
                </tr>
                <tr>
                    <td><center>Homepagina</center></td>
                    <td><center>Afspraakpagina</center></td>
                </tr>
            </table>
	</div>
</body>
</html>