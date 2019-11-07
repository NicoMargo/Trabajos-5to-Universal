import React from 'react';
function App() {
  return (
      <div>
    <div className="sticky-top">
      <nav className="navbar navbar-dark encabezado navbar-expand-sm ">	  		  
        <div className="collapse navbar-collapse" id="navbarTogglerDemo01">
          <div className="navbar-nav ml-auto mr-auto text-center">
            <img src="../res/img/Logo Alex.png" width="100" height="40" className="mx-auto" alt="Logo Alex"></img>
          </div>
        </div>        
      </nav>
       <nav className="navbar navbar-dark navegadorEncabezado navbar-expand-sm ">		  
        <div className="collapse navbar-collapse" id="navbarTogglerDemo01">
          <div className="navbar-nav ml-auto mr-auto text-center">
            <a className="navegador active ml-5 pl-5" href="index.html">Inicio</a>											
            <a className="navegador" href="#juguetes">Juguetes</a>
            <a className="navegador" href="Contacto.html">Contacto</a>
          </div>	
        </div>
      </nav>
    </div>
    </div>
  );
}
export default App;
