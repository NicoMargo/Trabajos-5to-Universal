
<html lang="en">
    <?php
        $Subjects = array("Math","Language","History","Chemestry","Physical Education","Jewish History","Jewish Culture","Programming","Production Proyects","Networks","Functional Strutures & Information Systems", "Exponential Technologies of Information","English","Phylosophy");
        $SubjAbreviations = array("Math","Lang","Hstr","Chemistry","PE","JH","JCulture","Prog","Proyects","Networks","FSIS", "ETI","Eng","Phylosophy");
    ?>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>Ingrese notas</h1>
    <?php
        for($i = 0; $i < sizeof($Subjects);$i++){
            $thisSubject = $Subjects[$i];
            $thisSubjAbreviation = $SubjAbreviations[$i];
            echo"<div>
                <div>$thisSubject</div>
                <input id=$thisSubjAbreviation name=$thisSubjAbreviation/>
            </div>"."<br>"; 
        }  
    ?>
    
</body>
</html>