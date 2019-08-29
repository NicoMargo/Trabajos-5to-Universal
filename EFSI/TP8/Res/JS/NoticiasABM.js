$(document).ready(function () {
    var Index;
    $(".btnModificar").click(function () {
        Index = $(this).attr("position");
        $.ajax({
            type: "POST",
            url: "./TraerUnaNoticia.php",
            data: { id: Index },
            success: function (DataJsonClient) {
                var Data = JSON.parse(DataJsonClient);
                $("#mdfTitulo").val(Data.Titulo);
                $("#mdfCopete").val(Data.Copete);
                $("#mdfCuerpo").val(Data.Cuerpo);
                $("#mdfImagen").val(Data.Imagen);
                $("#mdfFecha").val(Data.Fecha);
            },
            error: function () {
                alert("ERROR");
            }
        });
    });

    $("#SubirModificacion").click(function () {
        $.ajax({
            type: "POST",
            url: "./ModificarNoticia.php",
            data: {
                id: Index,
                titulo: $("#mdfTitulo").val(),
                copete: $("#mdfCopete").val(),
                cuerpo: $("#mdfCuerpo").val(),
                imagen: $("#mdfImagen").val(),
                fecha: $("#mdfFecha").val()
            },
            success: function () {
                location.reload();
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
                type: "POST",
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
                titulo: $("#crtTitulo").val(),
                copete: $("#crtCopete").val(),
                cuerpo: $("#crtCuerpo").val(),
                imagen: $("#crtImagen").val(),
                fecha: $("#crtFecha").val()
            },
            success: function () {
                location.reload();
            },
            error: function () {
                alert("ERROR");
            }
        });
        
    });
});