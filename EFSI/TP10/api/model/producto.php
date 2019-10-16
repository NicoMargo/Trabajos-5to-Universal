<?php
class Producto{
    public $id;
    public $nombre;
    public $descripcion;
    public $precio;
    public $stock;
    public $foto;
    function __construct($id,$nombre,$descripcion,$precio,$stock,$foto){
        $this->id = $id;
        $this->nombre = $nombre;
        $this->descripcion = $descripcion;
        $this->precio = $precio;
        $this->stock = $stock;
        $this->foto = $foto;
    }
};
?>