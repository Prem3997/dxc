
import React, { Component } from 'react';

class App extends Component {
  constructor(props){
    super(props)
    this.state=({
      message:''
    })
  }
  callApi(){
    //fetch("http://localhost:5001/router")
    fetch("http://10.231.139.106:5001/names")
    .then(res=>res.text())
    .then(res=>this.setState({
      message:res
    }))
  }
  componentWillMount(){
    this.callApi()
  }
  render() {
    return (
      <div>
        <h1>Message Received From Node:{this.state.message}</h1>
      </div>
    );
  }
}
export default App