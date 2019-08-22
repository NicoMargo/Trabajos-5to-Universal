<?php
    include('helpers.php');
    session_start();
    $User = registrar($_POST['username'],$_POST['password'],$_POST['email']);
    if($User == 0){
        header('Location: Signup.php');
    }else{
        $_SESSION["username"] = $_POST['username'];
        if(empty($_SESSION['SaveNewsId'])){
            header('Location: index.php');            
        }else{
            header('Location: News.php?noticiaId='.$_SESSION['SaveNewsId']);  
        }
    }

   
?>