<?php
    include('helpers.php');
    session_start();
    $User = login($_POST['username'],$_POST['password']);
    if(empty($User)){
        header('Location: LogIn.php');
    }else{
        $_SESSION["username"] = $_POST['username'];
        if(empty($_SESSION['SaveNewsId'])){
            header('Location: index.php');            
        }else{
            header('Location: News.php?noticiaId='.$_SESSION['SaveNewsId']);  
        }
    }

   
?>