  <?php 
          include('Nav.php');
          require('helpers.php');        
          $AllNews =traerNoticias();
      ?>
  <section>
      <div class="bd-example">
          <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
              <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <?php
                $i = 0;
                  if(count($AllNews)>0){
                  echo'
                  <div class="carousel-item active">
                    <a href="News.php?noticiaId='.$AllNews[$i]->idNoticias.'">
                      <img src="'.$AllNews[$i]->Imagen.'" class="d-block carousel-image"/>
                      <div class="carousel-caption d-none d-md-block">
                        <h5>'.$AllNews[$i]->Titulo.'</h5>                  
                      </div>
                    </a>
                  </div>
                  ';
                  $i++;
                }
                while($i<count($AllNews) && $i<3){
                  echo'
                  <div class="carousel-item">
                    <a href="News.php?noticiaId='.$AllNews[$i]->idNoticias.'">
                      <img src="'.$AllNews[$i]->Imagen.'" class="d-block carousel-image"/>
                      <div class="carousel-caption d-none d-md-block">
                        <h5>'.$AllNews[$i]->Titulo.'</h5>                  
                      </div>
                    </a>
                  </div>
                  ';
                  $i++;
                }
              ?>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
        </div>
  </section> <br><br>
  <main>
    <aside class="float-right height-100">
    <img class="add2" src="./Res/Img/ads/add2.jpg" alt="add2">
    <?php
      if(count($AllNews)>6){
      echo '<img class="add2" src="./Res/Img/ads/add3.jpg" alt="add2">';
      }
    ?>
    </aside>
    <div class="ml-5 col-md-9">
      <div class="row float-right">
        <?php foreach($AllNews as $OneNews) {?>
          <div class="col-md-4">        
            <div class="cardheight card border-dark mb-3 " style="max-width: 18rem;">
              <div class="card-header"><span class="text-secondary"><?php print $OneNews->fecha; ?></span></div>
                <a href="News.php?noticiaId=<?php echo $OneNews->idNoticias; ?>">
                  <div class="card-body ">            
                    <h5 class="card-title"><?php echo $OneNews->Titulo;?></h5>
                    <hr size="50" />
                    <img class="card-img-top hoverImg" src="<?php echo $OneNews->Imagen;?>">              
                  </div>
                </a> 
              </div>   
            </div>
          <?php  } ?>            
        </div>        
        
      </div>
      
        <img class="add1 w-5" src="./Res/Img/ads/add1.jpg" alt="add1">   
  </main>

  <?php 
          include('Footer.php');
      ?>

  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <script src="./Res/JS/Script.js"></script>
</body>

</html>