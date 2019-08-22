<?php
class noticia{
    private $id;
    private $titulo; 
    private $fecha;
    private $copete;
    private $cuerpo;
    private $img;
    
    public function __construct($id, $titulo, $fecha, $imagen,$copete,$cuerpo){
        $this->$id = $id;
        $this->$titulo = $titulo;
        $this->$fecha = $fecha;
        $this->$img = $imagen;
        $this->$copete = $copete;
        $this->$copete = $cuerpo;
    }

    public function Id(){ return $this->$id; }
    public function Titulo(){return $this->$titulo;} 
    public function Fecha(){return $this->$fecha;} 
    public function Imagen(){return $this->$img;}
    public function Copete(){return $this->$copete;}
    public function Cuerpo(){return $this->$cuerpo;}

}


?>