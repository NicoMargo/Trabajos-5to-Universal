import React from 'react';
import './App.css';
import Menu from './menu/Menu.js';
import Slides from './menu/Slides';
import Main from './main/Main';
import Footer from './footer/Footer';

function App() {
  return (
    <div className="App">
      <Menu></Menu>
      <Slides></Slides>
      <Main></Main>
      <Footer></Footer>
    </div>
  );
}

export default App;
