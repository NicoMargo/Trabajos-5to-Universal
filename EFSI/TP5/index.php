<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Tp 5 Margossian y Liu</title>
  </head>
  <body>
    <h1>Hello, world!</h1>

    <?php
        $br = "<br>";
        $variable = "Mi Variable";
        $otravariable = "Valor2";
        $varDump = "var_dump muestra muestra el contenido de la variable, el tipo de dato y su longitud si es un String";
        $arrayDump = array("ejemplo con un array",true,array("Muestra todo su contenido","Grande Flecha","Sos un Idolo","Maestro de maestros"), "Y realiza var_dump con todos sus elementos");
        $posString;
      
        echo '<input type="button" class="btn btn-primary ml-3" id="echo" value="Click echo"> <br>';
        echo '<div id="0" style="display: none">';         
        echo "echo: Sirve para mostrar texto".$br; 
        echo "echo con variable: mostrar texto con una variable $variable";
        echo ' </div>';


        echo '<input type="button" class="btn btn-primary mt-3 ml-3" id="varDump" value="Var Dump"><br>';
        echo '<div id="1" style="display: none">'; 
        var_dump($varDump);
        var_dump($arrayDump);        
        echo '</div>';
       


        echo "strlen retorna la longitud de un string (si se ingresa un tipo de dato numerico lo convierte a string). Ejemplo con 'hola' : ".strlen("hola").$br;

        echo "strpos retorna la posicion en que se encuentra un substring en un string. Ejemplo con el texto '".$variable."' y el char 'i': ". strpos($variable, "i")." (si no se encontro el char devuelve false)".$br;
        
        echo $br;
        
        $varStrStr = "strstr devuelve una subcadena de una cadena String, siendo el primer parametro la cadena completa, el segundo la subcadena donde se empieza o termina la extraccion y un parametro opcional booleano para indicar si se toma la subcadena previa o posterior al segundo argumento. Ej: Grande Flechoide;";
        $varSubStrStr = "Ej";
        echo "\$varStrStr = \"".$varStrStr."\"; <br>";
        echo "\$varSubStrStr = \"".$varSubStrStr."\"; <br>";
        echo "strstr(\$varStrStr,\$varSubStrStr): ";
        echo strstr($varStrStr,$varSubStrStr).$br.$br;
        echo "strstr(\$varStrStr,\$varSubStrStr,true): ";
        echo strstr($varStrStr,$varSubStrStr,true);
        echo $br.$br;
        echo "substr retorna una subcadena a partir de una cadena, tiene como parametros la cadena completa, la primera posición desde donde sacar la subcadena y la longitud que tendrá la subcadena(si no se indica esta última, no tendrá límite)".$br.$br;
        $varString = "Bokita el ma Grande Flecha";
        echo "substr(\"bokita el ma Grande Flecha\",14):".substr($varString,13).$br.$br;        
        echo "el str_replace remplaza los caracteres de una variable o Array por otra cosa. Ejemplo con texto 'Mi Variable' remplazando 'i' por 'x': ". str_replace("i","x",$variable);
        echo $br.$br;
        echo "isset retorna un false si la varible no esta definida (si es null) y un true si pasa lo contrario. Ejemplo con la variable \$variable que contiene 'Mi variable' (devuelve 1 (true)): " .isset($variable);
        echo $br.$br;
        echo "count devuelve la cantidad de elementos de un arreglo, o un objeto que sea contable.";
        echo "count(array(1,2,3,5,6,7,8,9)) : ".count(array(1,2,3,5,6,7,8,9));
        echo $br.$br;
        echo "el strtotime convierte texto de tiempo (10 September 2000) a fecha Unix (segundos trascurridos desde el 1 de enero de 1970): ".strtotime("10 September 2000").$br.$br;
        echo "date devuelve en String información sobre una fecha ingresada, como primer parametro la letra clave para qué dato retornar, y como segundo parametro la fecha".$br.$br;
        echo "date(\"l\"(clave para indicar que día de la semana es),mktime(0,0,0,13,6,2019)): ";
        echo date("l",mktime(0,0,0,13,6,2019)).$br.$br;
        echo "checkdate retorna un boolean si la validez de una fecha formada por los argumentos es correcta.El mes entre 1 y 12 ,El día que está dentro del número de días del mes month dado, Los años bisiestos son tomados en consideración, El año entre 1 y 32767 inclusive. Ejemplo con '2, 5, 2002: ' ". checkdate(2, 5, 2002).$br;
        echo ".".trim("           trim devuelve un string resultado de otro string extrayendole los espacios, y su segundo argumento puede indicar que espacios saca           ").".".$br;
        echo ".".ltrim("           ltrim devuelve un string resultado de otro string extrayendole los espacios del inicio (hasta encontrar otro caracter), y su segundo argumento puede indicar que espacios saca           ").".".$br;
        echo ".".rtrim("           rtrim devuelve un string resultado de otro string extrayendole los espacios del final (una vez no haya mas caracteres), y su segundo argumento puede indicar que espacios saca          ").".".$br.$br;
        echo "el header te cambia la pagina, un ejemplo de sintaxis es: header('Location: http://www.example.com/');";
    ?>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="MyScript.js"></script>
  </body>
</html>