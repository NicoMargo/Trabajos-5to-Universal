<!doctype html>
<html lang="es">
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
    <form class="offset-md-3" id="flechaForm" action="process.php" method="POST">
      <div class="container">
        <div class="row">
          <div class="col-md-4 form-group">
            <label for="name">Nombre</label>
            <input type="text" class="form-control" id="Name" name="Name" placeholder="Nombre">
            <small class="form-text text-muted" id="errorName">Ingresar el nombre</small>
          </div>
          <div class="col-md-4 form-group">
            <label for="apellido">Apellido</label>
            <input type="text" class="form-control" id="surname" name="surname" placeholder="Apellido">
            <small class="form-text text-muted" id="errorsurname">Ingresar el apellido</small>
          </div> <br>      
        </div>
        <div class="row">
          <div class="col-md-4 form-group">
            <label for="age">Edad</label>
            <input type="number" class="form-control" id="age" name="age" placeholder="Edad">
            <small class="form-text text-muted" id="errorage">Ingresar la edad</small>
          </div>  
          <div class="col-md-4 form-group">
            <label>Escuela</label> <br>
            <select class="custom-select" name="school" id="school">
              <option selected></option>
              <option value="Ort">Ort</option>
              <option value="San Cirano">San Cirano</option>
              <option value="America del Sur">America del Sur</option>
              <option value="Pelegrini">Pelegrini</option>
              <option value="Sudamericano">Sudamericano</option>
            </select> 
            <small class="form-text text-muted" id="errorschool">Ingresar la Escuela</small>
          </div>  
        </div>
        <div class="row">
          <div class="col-md-8 form-group">
            <label for="quant">Cantidad de veces que quiero mostrar el mensaje</label>
            <input type="number" value="1" class="form-control" id="quant" name="quant" placeholder="Cantidad">
            <small class="form-text text-muted" id="errorquant">Ingresar la Cantidad de veces que quiere repetir este mensaje</small>
          </div>    
        </div>
      </div>
      <button type="submit" id="btnSubmit" class="btn btn-primary offset-md-7">Enviar</button>
    </form>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script>
        function validateNumber(id){    
          let stateNumber = false;      
          if(($("#"+id).val() < 0) || ($("#"+id).val().length < 1)){
            $("#"+id).css("border-color", "#FF0000");
            $("#error"+id ).removeClass("text-muted");
            $("#error"+id ).css("color", "red");
          } else {
            $("#"+id).css("border-color", "#ced4da");
            $("#error"+id ).addClass("text-muted");
            stateNumber = true;
          }   
          return stateNumber;     
        }

        function validate(id) {
          let State = false;
          if ($("#"+id).val().length < 1) {
              $("#"+id).css("border-color", "#FF0000");
              $("#error"+id ).removeClass("text-muted");
              $("#error"+id ).css("color", "red");
          }else {
              $("#"+id).css("border-color", "#ced4da");
              $("#error"+id ).addClass("text-muted");
              State = true;
          }       
          return State;
        }
        $(document).ready(function() {
            $("#btnSubmit").click(function (e) {
                e.preventDefault();
                var bool = validate("Name");
                bool = bool & validate("surname");
                bool = bool & validateNumber("age");
                bool = bool & validate("school");
                bool = bool & validateNumber("quant");
                if(bool){
                $("#flechaForm").submit();
                }
            });
        });
    </script>
  </body>
</html>