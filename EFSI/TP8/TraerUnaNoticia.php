<?php
require("helpers.php");
$id =$_POST["id"];
$noticia = traerUnaNoticia($id);
$JsonObject = json_encode($noticia);
echo $JsonObject;
?>