<?php
require("helpers.php");
$titulo = $_POST['titulo'];
$copete = $_POST['copete'];
$cuerpo = $_POST['cuerpo'];
$imagen = $_POST['imagen'];
$fecha =  $_POST['fecha'];
agregarNoticia($titulo, $copete, $cuerpo, $imagen, $fecha);
?>