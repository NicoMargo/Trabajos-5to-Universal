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
							'<modificar><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg">Modificar</button></modificar>'+
							'<borrar><button type="button" class="btn btn-danger ml-3" data-toggle="modal" data-target=".bd-example-modal-lg">Borrar</button></borrar>'+
						'</div>'+
					'</div>'+
				'</div>'
				);	
			}			
		},
		error: function () {
			alert("ERROR");
		}
	});

});