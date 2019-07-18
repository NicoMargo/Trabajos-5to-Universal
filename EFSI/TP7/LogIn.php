
    <?php 
          include('Nav.php');
          include('helpers.php');
    ?>

        <div class=" row">
                <img class="wimglogin" src="./Res/img/loginMob" alt="Mob">
            <div class="col-md-3 pl-4">
                <form action="processLogin.php" method="POST" class="bg-white ml-4 h-100">
                    <div class="text-center">
                     <h4> Iniciar sesion</h4> <hr><br>
                    </div>
                    
                     <button type="button" class="btn-primary col-md-12 btn" ><img class="w-5 d-inline-block float-left" src="./Res/Img/g-1" alt=""> <span class="pt-5">Ingresá con Google</span> </button>
                     <button type="button" class="mt-4 col-md-12 btn" style="background-color: #4267b2; color: white;" ><img class="w-5 d-inline-block float-left" src="./Res/Img/f-1" alt=""> <span class="pt-5">Ingresá con Facebook</span> </button>
                    <label class="pt-5"  for="userName"> Nombre de Usuario</label><br>
                    <input type="text" id="userName"name="username" class="md-4 form-control"><br>
                    <label for="clave"> Contraseña</label><br>
                    <input type="password" id="clave" name="password" class="md-4 form-control"><br> <hr>
                    <input type="submit" class="btn btn-primary" value="Login" /> <br>
                    <label>¿No tienes cuenta ?</label> <a href="">Registrate!</a><hr>
                    <small class="small-font">Al crear la cuenta confirmo que he leído y <a href="#">aceptado los términos</a>  y <a href="#"> política de privacidad</a></small>
                </form>
             </div>           
        </div>   

    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>