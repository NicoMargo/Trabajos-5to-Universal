$(document).ready(function () {
    $(".btnModificar").click(function () {
        let Index = $(this).attr("position");
        $.ajax({
            type: "POST",
            url: "./TraerUnaNoticia.php",
            data: { pos: Index },
            success: function (DataJsonClient) {
                var Data = JSON.parse(DataJsonClient);
                $("#mdfTitulo").val(Data.Surname);
                $("#mdfCopete").val(Data.Name);
                $("#mdfCuerpo").val(validInt(Data.Dni));
                $("#mdfImagen").val(Data.Email);
                $("#mdfFecha").val(validInt(Data.Telephone));
            },
            error: function () {
                alert("ERROR");
            }
        });
    });

    $("#createClient").click(function () {
    });

    $("#SubirModificacion").click(function () {
        $.ajax({
            type: "POST",
            url: "/ModificarNoticia.php",
            data: {
                Titulo: $("#mdfTitulo").val(),
                Copete: $("#mdfCopete").val(),
                Cuerpo: $("#mdfCuerpo").val(),
                Imagen: $("#mdfImagen").val(),
                Fecha: $("#mdfFecha").val()
            },
            success: function () {
                location.reload();
                $("#modificarNoticia").modal("toggle");
            },
            error: function () {
                alert("ERROR");
            }
        });
        
    });

    $("deleteButton").click(function () {
        let Index = $(this).attr("position");
         $("#confirm").click(function () {
            $.ajax({
                type: "DELETE",
                url: "./BorrarNoticia.php",
                data: { id: Index },
                success: function () {
                    location.reload();
                },
                error: function () {
                    alert("ERROR");
                }
            });
        });
    });

    $("#nuevaNoticia").click(function () {
        $.ajax({
            type: "POST",
            url: "./AgregarNoticia.php",
            data: {
                Titulo: $("#crtTitulo").val(),
                Copete: $("#crtCopete").val(),
                Cuerpo: $("#crtCuerpo").val(),
                Imagen: $("#crtImagen").val(),
                Fecha: $("#crtFecha").val()
            },
            success: function () {
                location.reload();
                $("#crearNoticia").modal("toggle");
            },
            error: function () {
                alert("ERROR");
            }
        });
        
    });
});