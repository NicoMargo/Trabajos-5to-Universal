<?php
include_once('../dao/personDao.php');
$action = isset($_POST['action']) ? $_POST['action'] : $_GET['action'];
switch($action){
    case 'new':
            return 5;
        break;
    case 'getById':

        break;
    case 'edit':

        break;

        //http://localhost/TP10/api/controller/personController.php?action=new
}
?>