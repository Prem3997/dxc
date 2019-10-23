import React, { Component } from 'react';

class AgeCalculator extends Component {
    constructor(props){
        super(props)
        this.state={
            dob1:"",
            age1:""
        }
        this.handleChange=this.handleChange.bind(this)
    }
    handleChange=(e)=>{
        console.log(e.target.value)
        this.setState({
            dob1:e.target.value
        },()=>{
            console.log(this.state.dob1)
        })
        var currentAge={
            currentAge:this.calculateAge(e.target.value)
        }
        console.log(currentAge)
        this.setState({
            age1:this.state.age1
        },()=>{
            console.log(this.state.age1)
        })
    }
    calculateAge=(dob1)=>{
        var today=new Date()
        var birthDate=new Date(dob1)
        var ageCurrent=today.getFullYear()-birthDate.getFullYear()
        var m=today.getMonth()-birthDate.getMonth()
        if(m<0||(m===0 && today.getDate()<birthDate.getDate())){
            ageCurrent--;
        }
        console.log(ageCurrent)
        return ageCurrent
    }
    render() {
        let age=this.state.age1
        return (
            <div>
                <h1>
                    Enter Your BirthDate:<input type="date" name="dateOfBirth" onChange={this.handleChange}></input>
                </h1>
                <h2>Age:{age}</h2>
            </div>
        );
    }
}

export default AgeCalculator;