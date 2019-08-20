<?php
    include('helpers.php');
    session_start();
    $User = login($_POST['username'],$_POST['password']);
    if(empty($User)){
        header('Location: LogIn.php');
    }else{
        header('Location: index.php');
        $_SESSION["username"] = $_POST['username'];
    }

   
?>