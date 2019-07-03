
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
        <table>
            <?php
                for($i = 0; $i < sizeof($Subjects);$i++){
                    echo "<tr>";
                    for($j = 0; $j < $QuantColumns && $i < sizeof($Subjects); $j++,$i++){
                        $thisSubject = $Subjects[$i];
                        $thisSubjAbreviation = $SubjAbreviations[$i];
                        echo"<td>
                            <span class='markInput'>
                                <div>$thisSubject</div>
                                <input  id=$thisSubjAbreviation name='notas[$thisSubjAbreviation]' type='number' min='1' max='10' value='0'/>
                            </span>
                        </td>"; 
                    }
                    echo "</tr>";
                }  
            ?>
        </table><br>
        <input type="submit" value="Ingresar"/>
    </form>
    
</body>
</html>