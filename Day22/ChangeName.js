import React, { Component } from 'react';
import ChildComponent from './ChildComponent';

class ChangeName extends Component {
    constructor(props) {
        super(props);
        this.state={
            name: "Prem",
            validUser:false,
            toggleButtonName:'LogIn',
            loginCount:0,
            loggedInCount:0,
            commentMessage:'Comment'
        }
        this.ChangeName=this.ChangeName.bind(this)
        this.toggleButton=this.toggleButton.bind(this)
        this.changeComment=this.changeComment.bind(this)
    }
    ChangeName(){
            this.setState({
                name:"Balaji"
            })
        }
    changeName2=()=>{
        this.setState({
            name:"Balaji"
        })
    }
    changeComment(){
        this.setState({
            commentMessage:"CommentEdited"
        })
    }
    toggleButton(){
        if(this.state.validUser===true){
            this.setState({
                validUser:false,
                toggleButtonName:'LogIn',
                loggedInCount:this.state.loggedInCount+1,
            })
        }
        else{
            this.setState({
                validUser:true,
                toggleButtonName:'LoggedIn',
                loginCount:this.state.loginCount+1
            })
        }
    }

    componentWillMount() {

    }

    componentDidMount() {

    }

    componentWillReceiveProps(nextProps) {

    }

    shouldComponentUpdate(nextProps, nextState) {
        return true

    }

    componentWillUpdate(nextProps, nextState) {
        
    }

    componentDidUpdate(prevProps, prevState) {

    }

    componentWillUnmount() {

    }

    render() {
        let message
        if(this.state.validUser){
                message=<div>
                <h1>The Name is {this.state.name}</h1>
                <h1>LoggedInTimes: {this.state.loggedInCount}</h1>
                <button className="btn-link"onClick={()=>this.ChangeName()}>ChangeNameArrowFunction</button>
                <button className="btn-danger"onClick={this.ChangeName.bind(this)}>ChangeNameBind</button>
                <button className="btn-warning"onClick={this.ChangeName}>ChangeNameInBindConstructor</button>
                <button className="btn-success"onClick={this.changeName2}>ArrowBindingFunctionChangeName</button><br/>
                <button className="btn-primary"onClick={this.toggleButton}>{this.state.toggleButtonName}</button>
            </div>
        }
        else{
            message=<div>
                <h1>Not a Valid User!!!!</h1>
                <h1>LoginTimes: {this.state.loginCount}</h1>
                <button className="btn-info" onClick={this.toggleButton}>{this.state.toggleButtonName}</button>
            </div>
        }
        return <div>{message}<ChildComponent  myNameProp={this.state.name} updateName={this.ChangeName} myCommentProp={this.state.commentMessage} myCommentEdit={this.changeComment} ></ChildComponent></div>
    }
}


export default ChangeName;