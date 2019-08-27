<?php
require("helpers.php");
$id = $_POST['id'];
$titulo = $_POST['titulo'];
$copete = $_POST['copete'];
$cuerpo = $_POST['cuerpo'];
$imagen = $_POST['imagen'];
$fecha =  $_POST['fecha'];
modificarNoticia($id, $titulo, $copete, $cuerpo, $imagen, $fecha);
?>