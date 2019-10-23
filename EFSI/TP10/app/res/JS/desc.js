var modelId;
$(document).ready(function () {
	$.ajax({
		type: "GET",
		dataType:"JSON",
		url: "../../../../TP10/api/controller/productoController.php?action=todos",
		success: function (Producto) {	
					
			for(var i = 0; i< Producto.length;i++){				
				$("#cardGroup").append(
				'<div class="card mb-3 mr-3 col-md-3"><div style="height: 250px;">'+
					'<img class="card-img-top" src="../res/img/'+Producto[i].foto+'.jpg" alt="Card image cap">'+
				'</div>'+
				'<div class="card-body">'+
					'<div class="d-flex">'+
					'<h5 class="card-title mr-auto">'+Producto[i].nombre+'</h5>'+
						'<div class="text-success font-weight-bold">$'+Producto[i].precio+'</div>'+
					'</div>'+
						'<div class="d-flex justify-content-between">'+
							'<button action="modificar" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modifModal" modelId="'+Producto[i].id +'">Modificar</button>'+
							'<button action="borrar" type="button" class="btn btn-danger ml-3" data-toggle="modal" data-target="#borrarModal" modelId="'+Producto[i].id +'">Borrar</button>'+
						'</div>'+
					'</div>'+
				'</div>'
				);	
			}			
			
			$("[action='modificar']").click(
				function(){
					$.ajax({
						type: "POST",
						url: "../../../../TP10/api/controller/productoController.php",
						data: { 
							action: "Bjuguete",
							id: modelId 
						},
						success: function () {
							location.reload();
						},
						error: function () {
							CreateModal("Error", "Hubo un error al eliminar al producto");
						}
					});
				}
			);
			$("[action='borrar']").click(
				function(){
				modelId = $(this).attr("modelId");
			});
		},
		error: function () {
			alert("ERROR");
		}
	});
	$("#confirm").click(function () {
		$.ajax({
			type: "POST",
			url: "../../../../TP10/api/controller/productoController.php",
			data: { 
				action: "Bjuguete",
				id: modelId 
			},
			success: function () {
				location.reload();
			},
			error: function () {
				CreateModal("Error", "Hubo un error al eliminar al producto");
			}
		});
	});
	$("#add").click(function () {
		$.ajax({
			type: "POST",
			url: "../../../../TP10/api/controller/productoController.php",
			data: { 
				action: "Ajuguete",
				producto: {
					id:9,
					nombre:"a",
					descripcion:"a",
					precio: 1,
					foto: "a",
					stock: 1
				} 
			},
			success: function () {
				location.reload();
			},
			error: function () {
				alert("Error", "Hubo un error al eliminar al producto");
			}
		});
	});
});