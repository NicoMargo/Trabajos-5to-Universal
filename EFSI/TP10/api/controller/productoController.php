<?php
include_once('../dao/productoDao.php');
$action = isset($_POST['action']) ? $_POST['action'] : $_GET['action'];
switch($action){
    case 'todos':
        $productos = ProductoDao::ObtenerTodos();
        print(json_encode($productos));
        break;    
    case 'Mjuguete':

        break;
    case 'Ajuguete':

        break;
    case 'Bjuguete':

         break;
        //http://localhost/TP10/api/controller/personController.php?action=new
}
?>