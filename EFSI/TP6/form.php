<html lang="es">
    <?php
        $Subjects = array("Matematica","Lengua","Historia","Química","Ed Física","Historia Judía","Fuentes","Programación","Proyecto","Redes","EFSI", "TI","Inglés","Filosofía");
        $SubjAbreviations = array("Math","Lang","Hstr","Chemistry","PE","JH","JCulture","Prog","Proyects","Networks","EFSI", "ETI","Eng","Phylosophy");
        $QuantColumns = 3;
    ?>
    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TP 6</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <h1 class="form-control">Ingrese notas:</h1>
    <form action="results.php" method="post">
        <div class="form-group">
            <table class="table table-striped table-bordered col-md-8 offset-md-2">
                <?php
                    for($i = 0; $i < sizeof($Subjects);){
                        echo "<tr>";
                        for($j = 0; $j < $QuantColumns && $i < sizeof($Subjects); $j++,$i++){
                            $thisSubject = $Subjects[$i];
                            $thisSubjAbreviation = $SubjAbreviations[$i];
                            echo"<td >
                                <span class='mr-4'>
                                    <div>$thisSubject</div>
                                    <input class='form-control' id=$thisSubjAbreviation name='notas[$thisSubjAbreviation]' type='number' required placeholder='Nota:' min='1' max='10' />
                                </span>
                            </td>"; 
                        }
                        echo "</tr>";
                    }  
                ?>
            </table><br>
        <input type="submit" class="form-control col-md-4 offset-md-4 btn btn-success"  value="Ingresar"/>
        </div>
    </form>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>