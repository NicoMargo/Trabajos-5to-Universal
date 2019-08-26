<?php
class noticia{
    private $id;
    private $titulo; 
    private $fecha; 
    private $img;
    
    public function __construct($id, $titulo, $fecha, $imagen){
        $this->$id = $id;
        $this->$titulo = $titulo;
        $this->$fecha = $fecha;
        $this->$img = $imagen;
    }

    public function Id(){ return $this->$id; }
    public function Titulo(){return $this->$titulo;} 
    public function Fecha(){return $this->$fecha;} 
    public function Imagen(){return $this->$img;}

}


?>