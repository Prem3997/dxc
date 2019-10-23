import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
export default function MyPage() {
    return (
        <Router>
            <div>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/about" >About</Link>
                    </li>
                    <li>
                        <Link to="/customers">Customers</Link>
                    </li>
                </ul>
                <hr />
                <Route exact path="/" component={Home} />
                <Route path="/about" component={About} />
                <Route path="/customers" component={Customers} />
            </div>
        </Router>
    );
}

function Home() {
    return (
        <div>
            <h2>Home</h2>
        </div>
    );
}
function About() {
    return (
        <div>
            <h2>About</h2>
        </div>
    );
}
function Customers({ match }) {
    return (
        <div>
            <h2>Customers</h2>
            <ul>
                <li>
                    <Link to={`${match.url}/1009`}>Rahul</Link>
                </li>
                <li>
                    <Link to={`${match.url}/3009`}>Neha</Link>
                </li>
                <li>
                    <Link to={`${match.url}/5678`}>Pooja</Link>
                </li>
            </ul>
            <Route path={`${match.path}/:customerId`} 
                component={CustomerDetails} />
        </div>
    );
}
function CustomerDetails({ match }) {
    return (
        <div>
            <h3>{match.params.customerId}</h3>
        </div>
    );
}
