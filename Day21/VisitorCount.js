import React, { Component } from 'react';

class VisitorCount extends Component {
    constructor(props){
        super(props)
        this.state={
            noOfUsers:0
        }
    }
    addVisitor(){
        /* this.setState({
            noOfUsers:this.state.noOfUsers+1
        },()=>console.log("### async clicking of the button:"+this.state.noOfUsers)) */
        this.setState(prevState=>({
            noOfUsers:prevState.noOfUsers+1
        }),()=>console.log("### async clicking of the button:"+this.state.noOfUsers))
        
    }
    addVisitorThrice(){
        this.addVisitor()
        this.addVisitor()
        this.addVisitor()
    }
    render() {
        return (
            <div>
                <h1>Number Of Visitors:{this.state.noOfUsers}</h1>
                <button onClick={()=>this.addVisitorThrice()}>Go</button>
            </div>
        );
    }
}

export default VisitorCount;