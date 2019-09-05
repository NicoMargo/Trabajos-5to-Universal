<?php 
    session_start();
    ?>
<!doctype html>
<html lang="es">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
  <link rel="stylesheet" href="./Res/CSS/MySite.css">
  <script src="./Res/JS/Script.js" ></script>
  <style>
    .carousel-image{
      height:500px;
      margin:auto;
    }
  </style>

  <title>Diario Animes</title>
</head>

<body>


<?php 
    if(empty($_SESSION["username"])){
        echo '<section class="sticky-top" id="myHeader">
          <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-danger border-bottom shadow-sm">
            <div class="bg-white mr-md-auto my-0 rounded">
              <button id="buttonIndex" class=" btn btn-outline-danger">Flechin-Sama</button>
            </div>            
            <div class="bg-white rounded mr-3">
              <a class="btn btn-outline-primary" href="Signup.php">Sign Up</a>
            </div>
    
          <div class="bg-white rounded">
              <a class="btn btn-outline-primary" href="LogIn.php">Log in</a>
          </div>
          
        </div>
      </section>';
    }else{
      echo '<section class="sticky-top" id="myHeader">
      <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-danger border-bottom shadow-sm">
        <div class="bg-white mr-md-auto my-0 rounded">
          <button id="buttonIndex" class=" btn btn-outline-danger">Flechin-Sama</button>
        </div>       
        <div class="bg-white rounded mr-3">
          <a class="btn btn-outline-primary" href="BackOffice.php">BackOffice</a>
        </div>
        <div class="bg-white rounded">
          <a class="btn btn-outline-success" >'.$_SESSION["username"].'</a>
        </div>
        <div class="bg-white rounded ml-3">
          <a class="btn btn-outline-primary" href="Logout.php">Log Out</a>
        </div>      
    </div>
  </section>';
    }
    ?>

