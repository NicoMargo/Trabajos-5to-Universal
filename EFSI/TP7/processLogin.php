<?php
    include('helpers.php');
    $User = login($_POST['username'],$_POST['password']);
    print_r($User) ;
?>