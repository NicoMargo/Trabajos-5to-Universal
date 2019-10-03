<?php
include_once('../model/producto.php');
include_once('../db.php');
class ProductoDao{
    public static function ObtenerTodos(){
        $pdo = DB::Conectar();
        $resultado = $pdo->query("call spTraerJuguetes();");
        $productos = $resultado->fetchAll(PDO::FETCH_CLASS, 'Producto');        
        return $productos;
    }
    public static function Agregar($producto){
        $pdo = DB::Conectar();
        $resultado = $pdo->query("call spTraerJuguetes();");
        $productos = $resultado->fetchAll(PDO::FETCH_CLASS, 'Producto');        
        return $productos;
    }
    public static function Borrar($id){
        $pdo = DB::Conectar();
        $resultado = $pdo->query("call spBorrarJuguete('$id');"); //falta hacer sp
    }
    public static function Modificar($producto){
        $pdo = DB::Conectar();
        $resultado = $pdo->query("call spModificarUnJuguetes();");
        $productos = $resultado->fetchAll(PDO::FETCH_CLASS, 'Producto');        
        return $productos;
    }

};