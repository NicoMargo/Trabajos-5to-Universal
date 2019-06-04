<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Tp 4</title>
  </head>
  <body>
    <h1 class="text-center mb-5 mt-4">Formulario</h1>
  
  
    <form class="offset-md-3" action="process.php" method="POST">
    <div class="container">
      <div class="row">
        <div class="col-md-4 form-group">
          <label for="name">Nombre</label>
          <input type="text" class="form-control" id="Name" name="Name" placeholder="Nombre">
          <small class="form-text text-muted">Ingresar el nombre</small>
        </div>
        <div class="col-md-4 form-group">
          <label for="apellido">Apellido</label>
          <input type="text" class="form-control" id="surname" name="surname" placeholder="Apellido">
          <small class="form-text text-muted">Ingresar el apellido</small>
        </div> <br>      
      </div>
      <div class="row">
          <div class="col-md-4 form-group">
            <label for="age">Edad</label>
            <input type="number" class="form-control" id="age" name="age" placeholder="Edad">
            <small class="form-text text-muted">Ingresar la edad</small>
          </div>  
          <div class="col-md-4 form-group">
            <label for="school">Escuela</label>
            <input type="text" class="form-control" id="school" name="school" placeholder="Escuela">
            <small class="form-text text-muted">Ingresar la escuela</small>
          </div>  
      </div>
      <div class="row">
        <div class="col-md-8 form-group">
          <label for="quant">Cantidad de veces que quiero mostrar el mensaje</label>
          <input type="number" class="form-control" id="quant" name="quant" placeholder="Cantidad">
        </div>    
      </div>
    </div>
    <button type="submit" class="btn btn-primary offset-md-7">Enviar</button>
  </form>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>