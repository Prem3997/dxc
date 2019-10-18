import React, { Component } from 'react';

class LoginForm extends Component {
    constructor(props){
        super(props)
        this.state={
            userValue:"Enter Your UserName",
            message:""
        }
        this.handleChange=this.handleChange.bind(this)
        this.takeInputData=this.takeInputData.bind(this)
    }
    handleChange(userData){
        this.setState({
            userValue:userData.target.value
        })
    }
    takeInputData(userData){
        this.setState({
            message: "Welcome: "+this.state.userValue
        
        })
        userData.preventDefault();
        
    }
    render() {
        return (
            <div>
                <form className="form-group" onSubmit={this.takeInputData}>
                    <label>
                        UserName:<input type="text" className="form-control" value={this.state.userValue} onChange={this.handleChange}></input>
                    </label>
                    <input type ="submit" value="Submit"></input>
                </form>
                <h1>{this.state.message}</h1>
            </div>
        );
    }
}

export default LoginForm;