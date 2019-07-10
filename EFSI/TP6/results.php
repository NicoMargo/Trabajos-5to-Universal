<?php require("helpers.php");?>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TP 6</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<?php
    $r = "<br>";    
    $Notas = $_POST["notas"];
    $CantBajas = algunaBaja($Notas);
    $Subjects[mayorNota($Notas)];
    ?>

  <div class="mt-5 offset-md-1">
        <div class="row">
        <div class="card border-primary col-md-2 mb-3" style="max-width: 18rem;">
  <div class="card-body text-primary">
    <h5 class="card-title">Cantidad de Bajas: <?php echo $CantBajas?></h5>
   </div>
</div>
<div class="card border-success ml-3 col-md-2 mb-3" style="max-width: 18rem;">
  <div class="card-body text-success">
    <h5 class="card-title">Promedio de notas: <?php echo promedio($Notas);?></h5>
    </div>
</div>
<div class="card border-danger ml-3 col-md-2 mb-3" style="max-width: 18rem;">
  <div class="card-body text-danger">
    <h5 class="card-title">Promedio de aprobadas: <?php echo promedioAprobadas($Notas); ?></h5>
  </div>
</div>
<div class="card border-warning ml-3 col-md-2 mb-3" style="max-width: 18rem;">
  <div class="card-body text-warning">
    <h5 class="card-title">Mayor Nota: <?php echo $Subjects[mayorNota($Notas)]." : ".$Notas[$SubjAbreviations[mayorNota($Notas)]]; ?> </h5>
  </div>
</div>
<div class="card border-info ml-3 col-md-2 mb-3" style="max-width: 18rem;">
  <div class="card-body text-info">
    <h5 class="card-title">Menor Nota: <?php echo $Subjects[menorNota($Notas)]." : ".$Notas[$SubjAbreviations[menorNota($Notas)]]; ?></h5>
  </div>
</div>
        </div>
    </div>    
</body>
</html>