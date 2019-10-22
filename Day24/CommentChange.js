import React, { Component } from 'react';

class LoginForm extends Component {
    constructor(props) {
        super(props);
        this.state={
            value:'',
            textButton:"Add Comment",
            validUser:true,
            text:''
        }
        this.handleChange=this.handleChange.bind(this)
        this.takeInputData=this.takeInputData.bind(this)
        this.toggleButton=this.toggleButton.bind(this)
    }
    
    handleChange(ourData)
    {
        this.setState({
            value: ourData.target.value
        })
    }
    takeInputData(ourData)
    {
       // alert(this.state.value)
       
       
            this.setState( (
                {
                   
                    text:this.state.value,
                    textButton:'Edit'
                }
            ))
        ourData.preventDefault()
            }
            toggleButton()
            {
                if(this.state.validUser==true)
                {
                   
                        this.setState( prevState =>(
                            {
                                validUser:false,
                                textButton:'Add'
                                
                            }
                        ))
                }
            }
    render() 
    {  
            return (
           
                <form className="form-group" onSubmit={this.takeInputData}>
                     <h1>Comments</h1>
               
                <div className="form-control">
                
                Comment :<  input type="text" value={this.state.value} onChange={this.handleChange} ></input>
                <button onClick={this.toggleButton}>{this.state.textButton}</button>
                <h1>{this.state.text}</h1>
                </div> 
               
            </form>
            );
        
            
            
        
    
    
    }
}

export default LoginForm;