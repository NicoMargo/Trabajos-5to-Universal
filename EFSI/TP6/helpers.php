<?php
    $Subjects = array("Mate","Lengua","Historia","Química","Ed Física","Historia Judía","Cultura Judía","Programación","Proyecto","Redes","EFSI", "TEI","Inglés","Filosofía");
    $SubjAbreviations = array("Math","Lang","Hstr","Chemistry","PE","JH","JCulture","Prog","Proyects","Networks","EFSI", "ETI","Eng","Phylosophy");
    $QuantColumns = 3;


    function algunaBaja($notas){
        $i = 0;
        $tieneBaja = false;
        while(count($notas)>$i && !$tieneBaja){
            if($notas[$SubjAbreviations[$i]]<6){
                $tieneBaja = true;
            }
            else{ $i++; }
        }
    }
?>