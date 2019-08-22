<?php
function AllNews() {
    $News = array(
        array(
            'id' => 1,
            'title' => 'Doraemon 1',
            'date' => '21/5/2019'
        ),
        array(
            'id' => 2,
            'title' => 'Doraemon 2',
            'date' => '3/3/2016'
        ),
        array(
            'id' => 3,
            'title' => 'Doraemon 3',
            'date' => '3/3/2016'
        ),
        array(
            'id' => 4,
            'title' => 'Doraemon 4',
            'date' => '3/3/2016'
        ),
        array(
            'id' => 2,
            'title' => 'Doraemon 2',
            'date' => '3/3/2016'
        ),
        array(
            'id' => 2,
            'title' => 'Doraemon 2',
            'date' => '3/3/2016'
        ),
        array(
            'id' => 2,
            'title' => 'Doraemon 2',
            'date' => '3/3/2016'
        ),
        array(
            'id' => 2,
            'title' => 'Doraemon 2',
            'date' => '3/3/2016'
        ),
        array(
            'id' => 2,
            'title' => 'Doraemon 2',
            'date' => '3/3/2016'
        ),
    );    
    return $News;
}
function OneNews(){
    $noticiaId = $_GET['noticiaId'];
    header('Location: news.php?noticiaId=' . $noticiaId);
}
?>