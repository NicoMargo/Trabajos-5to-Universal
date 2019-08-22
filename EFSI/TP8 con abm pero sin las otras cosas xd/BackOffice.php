<?php
include('Nav.php');
require('helpers.php');
include('process.php');
if (!isset($_SESSION['username'])) {  
    header('location: index.php');
}


?>
    <link rel="stylesheet" href="~/css/Table.css">

    <div class="content mt-3">
        <div class="animated fadeIn">
            <div class="card">
                <div class="card-header">
                    <strong class="card-title">Noticias</strong>
                </div>
                <div class="card-body">
                    <button type="button" id="crearNoticia" class="btn btn-primary w-100" data-toggle="modal" data-target=".bd-example-modal-xl">
                        Agregar Noticia
                    </button>

                    <table id="myTable">
                        <tr class="header">
                            <th style="width:25%;">Titulo</th>
                            <th style="width:35%;">Imagen</th>
                            <th style="width:20%;">Fecha</th>
                            <th style="width:10%;">Modificar</th>
                            <th style="width:10%;">Eliminar</th>
                        </tr>
                        <?php
                            $noticias = traerNoticias();    
                            for ($i = 0; $i < count(traerNoticias()); $i++)
                            {
                                echo
                                '<tr>
                                    <td>'.$noticias[$i]->Titulo.'</td>
                                    <td><img style="height: 100px;" src="./Res/img/'.$noticias[$i]->Imagen.'"/></td>
                                    <td>'.strval($noticias[$i]->fecha).'</td>
                                    <td><a data-toggle="modal" data-target="#modificarNoticia"><img position="@i" class="btnModificar" src="./Res/img/edit.png" style="width: 30%" /></a></td>
                                    <td><a data-toggle="modal" data-target="#confirmationModal"><deleteButton position="@i"><img class="w-50" src="./Res/img/delete.png" style="width: 30%" /></deleteButton></a></td>
                                </tr>';
                            }
                        ?>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Create Beg-->
    <div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <h5 class="modal-title" id="confirmationModal">Esta seguro que quiere eliminar al cliente?</h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" id="confirm" class="btn btn-primary">Confirmar</button>
                </div>
            </div>
        </div>
    </div>



    <!-- Extra large modal Create-->
    <div class="modal fade bd-example-modal-xl" id="crearNoticia" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Crear Noticia</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body">

                    <div class="row">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Título</span></strong>
                            </div>
                            <input id="crtTitulo" class="form-control text-center" type="text">
                            <!--<div class="validation_msg hidden text-center" id="msgCreateSurname">Ingrese un apellido válido</div>-->
                        </div>                        
                    </div>
                    <div class="row mt-3">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Ruta de Imagen</span></strong>
                            </div>
                            <input id="crtImagen" class="form-control text-center" type="text">
                            <!--<div class="validation_msg hidden text-center" id="msgCreateSurname">Ingrese un apellido válido</div>-->
                        </div>                        
                    </div>
                    <div class="row mt-4">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Copete</span></strong>
                            </div>
                            <textArea  id="crtCopete" class="form-control" rows="3" cols="70"></textArea>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Cuerpo</span></strong>
                            </div>
                            <textArea  id="crtCuerpo" class="form-control" rows="7" cols="130"></textArea>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Fecha</span></strong>
                            </div>
                            <input id="crtFecha" class="form-control text-center" type="date">                        
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secundary" id="createCancel" data-dismiss="modal">Cerrar</button>
                    <button class="btn btn-primary" id="nuevaNoticia">Crear</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal Create END-->
    <!-- Modal Update Beginning-->
    <div class="modal fade bd-example-modal-xl" id="modificarNoticia" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modificar Noticia</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body">

                    <div class="row">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Título</span></strong>
                            </div>
                            <input id="mdfTitulo" class="form-control text-center" type="text">
                            <!--<div class="validation_msg hidden text-center" id="msgCreateSurname">Ingrese un apellido válido</div>-->
                        </div>                        
                    </div>
                    <div class="row mt-3">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Ruta de Imagen</span></strong>
                            </div>
                            <input id="mdfImagen" class="form-control text-center" type="text">
                            <!--<div class="validation_msg hidden text-center" id="msgCreateSurname">Ingrese un apellido válido</div>-->
                        </div>                        
                    </div>
                    <div class="row mt-4">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Copete</span></strong>
                            </div>
                            <textArea  id="mdfCopete" class="form-control" rows="3" cols="70"></textArea>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Cuerpo</span></strong>
                            </div>
                            <textArea  id="mdfCuerpo" class="form-control" rows="7" cols="130"></textArea>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="offset-md-1">
                            <div class="">
                                <strong><span>Fecha</span></strong>
                            </div>
                            <input id="mdfFecha" class="form-control text-center" type="date">                        
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secundary" id="createCancel" data-dismiss="modal">Cerrar</button>
                    <button class="btn btn-primary" id="SubirModificacion">Modificar</button>
                </div>
            </div>
        </div>
    </div>
    <!--Modal Update END-->
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> 
    <script src="./NoticiasABM.js"></script>
    </body>
</html>