<?php require("helpers.php");?>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <?php
    $r = "<br>";    
    $Notas = $_POST["notas"];
    $CantBajas = algunaBaja($Notas);
    if($CantBajas>0){
        echo "Tiene ".$CantBajas." bajas".$r;
    }
    else{
        echo "No tiene bajas, Que crack!".$r;
    }
    echo "El promedio de las notas es de ".promedio($Notas).$r;
    echo "El promedio de las notas aprobadas es es de ".promedioAprobadas($Notas).$r;
    $Subjects[mayorNota($Notas)];
    echo "La mayor nota es ".$Subjects[mayorNota($Notas)]." : ".$Notas[$SubjAbreviations[mayorNota($Notas)]].$r;
    echo "La menor nota es ".$Subjects[menorNota($Notas)]." : ".$Notas[$SubjAbreviations[menorNota($Notas)]].$r;
    ?>
</body>
</html>