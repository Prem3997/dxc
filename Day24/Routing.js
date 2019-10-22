import React from 'react'
import { BrowserRouter as Router, Route, Link } from 'react-router-dom'
export default function HomePage() {
    return (
        <Router>
            <div>
                <ul>
                    <li>
                        <Link to='/'>Home</Link>
                    </li>
                    <li>
                        <Link to='/about'>About</Link>
                    </li>
                    <li>
                        <Link to='/products'>Products</Link>
                    </li>
                </ul>
                <hr></hr>
                <Route exact path='/' component={Home}></Route>
                <Route path="/about" component={About}></Route>
                <Route path='/products' component={Products}></Route>
            </div>
        </Router>
    )
}
function Home(){
    return(
        <div>
            <h2>Home</h2>
        </div>
    )
}
function About(){
    return(
        <div>
            <h2>About</h2>
        </div>
    )
}
function Products({match}){
    return(
        <div>
            <ul>
                <li>
                    <Link to={`${match.url}/1001`}>Bottle</Link>
                </li>
                <li>
                    <Link to={`${match.url}/1002`}>Laptop</Link>
                </li>
                <li>
                    <Link to={`${match.url}/1003`}>OnePlusMobile</Link>
                </li>
            </ul>
            <Route path={`${match.path}/:ProductId`} component={ProductDetails}></Route>
        </div>
    )
}
function ProductDetails({match}){
    return(
        <div>
            <h3>{match.params.ProductId}</h3>
        </div>
    )
} 