<?php
include_once('../model/person.php');
include_once('../db.php');
class PersonDao{
    public static function GetAll(){
        $pdo = DB::Connect();
        $query = $pdo->prepare("SELECT * FROM persons");
        $query->execute();
        $arr = $query->fetchAll(PDO::FETCH_CLASS, 'Person');
        return $arr;
    }
};