
import React, { Component } from 'react';
import ListProductComponent from './Component/ListProductComponent';
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import {Switch, Route} from 'react-router-dom'
import {BrowserRouter as Router} from 'react-router-dom'
import ProductComponent from './Component/ProductComponent';

class App extends Component {
  render() {
    return (
      <div>
        <h1><center>Product Application</center></h1>
        <Router>
          <Switch>
            <Route exact path="/" component={ListProductComponent}></Route>
            <Route exact path="/products" component={ListProductComponent}></Route>
            <Route exact path="/productsAdd/:productId" component={ProductComponent}></Route>
            <Route exact path="/productsAdd" component={ProductComponent}></Route>
          </Switch>
        </Router>
      </div>
    );
  }
}

export default App;