import React from 'react';
function App() {
  return (
    <div id="carouselExampleIndicators" className="carousel slide" data-ride="carousel">
    <ol className="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" className="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div className="carousel-inner" style={{height: "100%"}}>
        <div className="carousel-item active" style={{height: "100%"}}>
            <img className="d-block w-100" src="../res/img/banner6.jpg" alt="First slide"></img>
            <div className="carousel-caption d-none d-md-block"></div>
        </div>        
    </div>
    <div className="carousel-item" style={{height: "100%"}}>
        <img className="d-block w-100" src="../res/img/banner5.JPG" alt="Second slide"></img>
            <div className="carousel-caption d-none d-md-block"></div>
    </div>
        <div className="carousel-item" style={{height: "100%"}}>
            <img className="d-block w-100" src="../res/img/banner4.JPG" alt="Third slide"></img>
            <div className="carousel-caption d-none d-md-block"></div>
        </div>
    

    <a className="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
        <span className="sr-only">Anterior</span>
    </a>
    <a className="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span className="carousel-control-next-icon" aria-hidden="true"></span>
        <span className="sr-only">Después</span>
    </a>    
</div>);
}
export default App;
