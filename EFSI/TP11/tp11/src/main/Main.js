import React from 'react';
import Product from './Product'
function App() {
  return (
    <div>
		<div id="juguetes" className="mb-5"></div>
		<div  style={{width: "100%;"}}></div>			
		<p className="PalabraDestacados">.</p>
		<div className="col-4 mx-auto mt-5">
			<h3 className="text-uppercase text-center">Juguetes</h3><br/>
		</div>
		<hr/>
		<section className="container mt-1 pt-2">			
			<div  className="card-group">    
				<button action="agregar"  id="btnAgregModal" className="btn btn-success offset-md-2 col-md-8 mb-2" data-toggle="modal" data-target="#agregModal">Agregar Juguete</button><br/>
				<div id="cardGroup" className="row offset-md-2"></div>
			</div> 
			<Product></Product>	
		</section>
		</div>);
}
export default App;
