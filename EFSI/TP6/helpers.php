<?php
    $Subjects = array("Mate","Lengua","Historia","Química","Ed Física","Historia Judía","Cultura Judía","Programación","Proyecto","Redes","EFSI", "TEI","Inglés","Filosofía");
    $SubjAbreviations = array("Math","Lang","Hstr","Chemistry","PE","JH","JCulture","Prog","Proyects","Networks","EFSI", "ETI","Eng","Phylosophy");
    $QuantColumns = 3;


    function algunaBaja($notas){
        
        $CantBajas = 0;
        for($i = 0;count($notas)>$i;$i++){
            if($notas[$GLOBALS['SubjAbreviations'][$i]]<6){
                $CantBajas++;
            }
        }
        return $CantBajas;
    }

    function promedio($notas){
        $total = 0.0;
        foreach($notas as $nota){
            $total += $nota;
        }
        return $total/count($notas);
    }

    function promedioAprobadas($notas){
        $total = 0.0;
        foreach($notas as $nota){
            if($nota>5){
                $total += $nota;
            }
        }
        return $total/count($notas);
    }

    function mayorNota($notas){
        $mayorValor = 1;
        $mayorPosicion = 0;
        $i = 0;
        while(count($notas)>$i && $mayorValor<10){
            $nota = $notas[$GLOBALS['SubjAbreviations'][$i]];
            if($nota>$mayorValor){
                $mayorValor = $nota;
                $mayorPosicion = $i;
            }
            $i++;
        }
        return $mayorPosicion;
    }

    function menorNota($notas){
        $menorValor = 10;
        $menorPosicion = 0;
        $i = 0;
        while(count($notas)>$i && $menorValor>1){
            $nota = $notas[$GLOBALS['SubjAbreviations'][$i]];
            if($nota<$menorValor){
                $menorValor = $nota;
                $menorPosicion = $i;
            }
            $i++;
        }
        return $menorPosicion;
    }
    
?>