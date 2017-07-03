
function showSelect(select){
	var gekozenSelect = document.getElementById(select);
        var gekozenTitel = document.getElementById(''+select+'Titel');
	gekozenSelect.style.display = 'block';
        gekozenTitel.style.display = 'block';
}


//var maandSelect = document.getElementById('maandSelect');
//
//maandSelect.addEventListener("change", function(){
//	document.getElementById('dagSelect').style.display = 'block';	
//});
//
//function userChoice(str) {
//    if (str == "") {
//        document.getElementById("txtHint").innerHTML = "";
//        return;
//    } else { 
//        if (window.XMLHttpRequest) {
//            // code for IE7+, Firefox, Chrome, Opera, Safari
//            xmlhttp = new XMLHttpRequest();
//        } else {
//            // code for IE6, IE5
//            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
//        }
//        xmlhttp.onreadystatechange = function() {
//            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//                document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
//            }
//        };
//        xmlhttp.open("GET","ajaxdemo.php?q="+str,true);
//        xmlhttp.send();
//    }
//}