<?php
include_once('../dao/productoDao.php');
$action = isset($_POST['action']) ? $_POST['action'] : $_GET['action'];
switch($action){
    case 'todos':
        $productos = ProductoDao::ObtenerTodos();
        print(json_encode($productos));
        break;    
    case 'Mjuguete':
        $producto = $_POST['producto'];
        ProductoDao::Modificar($producto);
        break;
    case 'Ajuguete':
        $producto = json_decode($_POST['producto']);
        ProductoDao::Agregar($producto);
        break;
    case 'Bjuguete':
        echo "borrar";
        $id = $_POST['id'];
        ProductoDao::Borrar($id);
        break;
}
?>