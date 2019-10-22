import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './App.css'
import Customer from './Customer'
import ProductList from './ProductList'
import Home from './Home';
import About from './About';
import stockUpdate from './stockUpdate';

class Appl extends Component {
    render() {
        return (


            <div className="mydiv">

                <Router>
                    <div>
                        <Link to="/">Home</Link>
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        <Link to="/about" >About</Link>
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        <Link to="/customers">Customers</Link>
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        <Link to="/products">Products</Link>
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        <Link to="/stockUpdate">Stock Update</Link>
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        <hr />
                        <Route exact path="/" component={Home} />
                        <Route path="/customers" component={Customer} />
                        <Route path="/about" component={About} />
                        <Route path="/products" 
                        render={({ match }) => match={match}} 
                        component={ProductList} />
                        <Route path="/stockUpdate" 
                        render={({ match }) => match={match}} 
                        component={stockUpdate} />
                    </div>
                </Router>
            </div>
        )
    }
}
export default Appl 
