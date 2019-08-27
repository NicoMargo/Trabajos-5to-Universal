<?php 
        include('Nav.php');
        require('helpers.php');
        $news = traerUnaNoticia($_GET["noticiaId"]);  
?>
<span class="ml-4 text-secondary"><?php print($news->Fecha) ?></span>
<hr>
<div class="col-md-8 offset-md-2">
    <h5 class="text-danger">Anime</h5>
    <h1><?php print($news->Titulo) ?></h1>
</div>
<div class="col-md-8 offset-md-2">
    <p class="mt-4 text-secondary"><?php print($news->Copete) ?></p>
    <div class="mt-5">
        <img class="w-100" src="./Res/img/<?php echo($news->Imagen) ?>">
        <p class="mt-5 bodysize"><?php print($news->Cuerpo) ?></p>
    </div>
</div>

</form>
<?php 
          include('Footer.php');
      ?>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>