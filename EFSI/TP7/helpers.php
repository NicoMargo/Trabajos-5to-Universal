<?php
    require("noticia.php");
    function conectar(){
        $mysqlCon = new mysqli("localhost","root","","flechin");
        if($mysqlCon->connect_errno){
            echo "fallo la conexión: (".$mysqlCon->connect_errno.") " . $mysqlCon->connect_error;

        }
        return $mysqlCon;
    }

    //devuelve un array con los indices "idUsuarios","Nombre","Clave","Correo"
    function login($nombre,$clave){
        $sqlConnection = conectar();
        if (!($resultado = $sqlConnection->query("call loguear('".$nombre."','".$clave."');"))) {
            echo "Falló SELECT: (" . $sqlConnection->errno . ") " . $sqlConnection->error;
        }
        return $resultado->fetch_assoc();
    }

    function registrar($nombre,$clave,$correo){
        $sqlConnection = conectar();
        if (!($resultado = $sqlConnection->query("call Registrar('".$nombre."','".$clave."','".$correo."');"))) {
            echo "Falló SELECT: (" . $sqlConnection->errno . ") " . $sqlConnection->error;
        }
        return $resultado->fetch_row();
    }

    function traerNoticias(){
        $sqlConnection = conectar();
        $noticias = array();
        if (!($resultado = $sqlConnection->query("call TraerNoticias();"))) {
            echo "Falló SELECT: (" . $sqlConnection->errno . ") " . $sqlConnection->error;
        }
        else{
            while($n = $resultado->fetch_object()){
               $noticias[] = $n;
            }
        }
        return $noticias;
    }

    function traerUnaNoticia($id){
        $sqlConnection = conectar();
        $noticia = null;
        if (!($resultado = $sqlConnection->query("call TraerUnaNoticia($id);"))) {
            echo "Falló SELECT: (" . $sqlConnection->errno . ") " . $sqlConnection->error;
        }
        return $resultado->fetch_object();
    }




    $Usuario = login("Nombre","Contra");
    echo $Usuario["idUsuarios"];
    $registro = registrar("Nombre","Contra","Correo");
    echo $registro[0];
    echo var_dump(traerNoticias());
    echo var_dump(traerUnaNoticia(1));
?>