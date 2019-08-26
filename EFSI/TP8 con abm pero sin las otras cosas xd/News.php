<?php 
          include('Nav.php');
          require('HelpersB.php');
          include('process.php');
          if (!isset($_SESSION['username'])) {  
            if($_SESSION['quant'] > 0){        
                     $_SESSION['quant'] = $_SESSION['quant'] -1;  
                }
            }

            if($_SESSION['quant'] <= 0){
               header('location: index.php');
            }

?>
<span class="ml-4 text-secondary">17/5/2019</span>
<hr>
<div class="margin-auto offset-md-4">
    <h5 class="text-danger">Anime</h5>
    <h1 >Este es mi super titulo!</h1>
</div>
<div class="col-md-8 offset-md-2">
    <p class="mt-4 text-secondary">este es mi super copeteeste es mi super copeteeste es mi super copeteeste es mi super copeteeste es mi super copeteeste es mi super copeteeste es mi super copeteeste es mi super copeteeste es mi super copeteeste es mi super copeteeste es mi super copeteeste es mi super copete</p>
    <div class="mt-5">
        <img class="w-100" src="./Res/img/1.jpg" alt="">
        <p class="mt-5 bodysize">Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  Este es mi super body  </p>
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