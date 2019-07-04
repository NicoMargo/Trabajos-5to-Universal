
<html lang="en">
    <?php
        $Subjects = array("Mate","Lengua","Historia","Química","Ed Física","Historia Judía","Cultura Judía","Programación","Proyecto","Redes","EFSI", "TEI","Inglés","Filosofía");
        $SubjAbreviations = array("Math","Lang","Hstr","Chemistry","PE","JH","JCulture","Prog","Proyects","Networks","EFSI", "ETI","Eng","Phylosophy");
        $QuantColumns = 3;
    ?>
    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Ingrese notas</h1>
    <form action="results.php" method="post">
        <div class="form-group">
            <table>
                <?php
                    for($i = 0; $i < sizeof($Subjects);){
                        echo "<tr>";
                        for($j = 0; $j < $QuantColumns && $i < sizeof($Subjects); $j++,$i++){
                            $thisSubject = $Subjects[$i];
                            $thisSubjAbreviation = $SubjAbreviations[$i];
                            echo"<td>
                                <span class='markInput'>
                                    <div>$thisSubject</div>
                                    <input class='form-control' id=$thisSubjAbreviation name='notas[$thisSubjAbreviation]' type='number' min='1' max='10' value='0'/>
                                </span>
                            </td>"; 
                        }
                        echo "</tr>";
                    }  
                ?>
            </table><br>
        <input type="submit" value="Ingresar"/>
        </div>
    </form>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>