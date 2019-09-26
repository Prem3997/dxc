import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';


function Welcomefunction(props){
    return (<div><h1>Hello,{props.name}</h1><h2>{props.id}</h2></div>)
}
const element=<Welcomefunction name="Prem" id="11576718"/>   
ReactDOM.render(element,document.getElementById("nameWelcome"))

class Welcomeclass extends React.Component{
    render(){
        return <h1>Hello {this.props.name} from Class</h1>
    }
}
ReactDOM.render(<Welcomeclass name="Balaji"></Welcomeclass>,document.getElementById("nameClass"))

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
