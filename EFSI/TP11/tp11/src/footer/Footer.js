import React from 'react';
function App() {
  return (
    <div>
        <div className="jumbotron mt-12 bg-primary bg-primary text-white rounded-0" style={{clear:'left'}}>
	        <div className="container">
	            <div>
                    <p className="lead">Marcas con las que trabajamos:</p> 
                    <img src="../res/img/Marca Rondi.png" style={{width: "100px"}} className="mr-2" alt="Rondi"/>
                    <img src="../res/img/Marca Ruibal.jpg" style={{width: "85px"}} className="mr-2" alt="Ruibal"/>
                    <img src="../res/img/Marca HotWheels.png" style={{width: "100px"}} className="mr-2" alt="HotWheels"/>
                    <img src="../res/img/Marca Barbie.png" style={{width: "100px"}} className="mr-2" alt="Barbie"/>
                    <img src="../res/img/Welly_b.png" style={{width: "100px"}} className="mr-2" alt="Welly"/>		
                    <img src="../res/img/Marca Mattel.png" style={{width: "85px"}} className="mr-2" alt="Mattel"/>
                    <img src="../res/img/Marca Hasbro.png"  style={{width: "85px"}} className="mr-2" alt="Hasbro"/>
                    <img src="../res/img/Marca Kinsmart.png" style={{width: "100px"}} className="mr-2" alt="Kinsmart"/>
                    <img src="../res/img/Marca Playmobil.png" style={{width: "100px"}} className="mr-2" alt="Playmobil"/>
                    <img src="../res/img/Marca Juliana.png" style={{width: "100px"}} className="mr-2" alt="Juliana"/>
			    </div>
		        <hr className="my-4"/>
			    <div className="d-flex justify-content-between align-items-center">
                    <p>© 2018 Alex Todos los derechos reservados</p>
                    <p>Sarmiento 2401</p>
                    <p>(011) 4951-9648</p>
                    <a  href="https://www.facebook.com/jugueteriaalexx/"><img src="../res/img/facebook.svg" height="40" width="40" alt="Facebook"/></a>  
			    </div>
		    </div>
        </div>        
    </div>);
}
export default App;
