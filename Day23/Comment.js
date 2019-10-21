class Comment extends React.Component 
{
	constructor(props){
		super(props)
    this.edit = this.edit.bind(this)
    this.save = this.save.bind(this)
    this.remove = this.remove.bind(this)
    this.state = {editing: false}
  }
  edit(e){
    this.setState({editing:true})
    e.preventDefault()
  }
  remove(e){
    this.props.remove(this.props.index)
    e.preventDefault()
  }
  save(e) {
     this.setState({editing:false})
     this.props.update(this.refs.newValue.value, this.props.index)
    e.preventDefault()
  }
   renderNormal(){
    return(
        <div>
          <h1>{this.props.children}</h1>
          <button onClick={this.edit}>Edit</button>
	<button onClick={this.remove}>Remove</button>
        </div>
      )
  }
  renderForm(){
    return(
        <div>
          <textarea ref="newValue" defaultValue={this.props.children}></textarea>
          <button onClick={this.save}>Save</button>
          
        </div>
      )
  }
  render(){
   if (this.state.editing)
    	return this.renderForm()
    return this.renderNormal()
  }
}
class Board extends React.Component {
	constructor(props){
  	super(props)
    this.updateComment = this.updateComment.bind(this)
    this.removeComment = this.removeComment.bind(this)
		this.addButton = this.addButton.bind(this)
    this.state = {
    	comments: [
      'Default Comment 1 !', 'Default Comment 2 !', 'Default Comment 3 !'
      ]
    }
  }
  removeComment(i){
     console.log("Removing Comment " + i)
    var arr = this.state.comments
    arr.splice(i, 1)
    this.setState({comments:arr})
  }

  updateComment(newtext, i){
  console.log('updating ' + i)
  	var arr = this.state.comments
		arr[i] = newtext
    this.setState({comments:arr})
  }

	addButton(e){
		this.add('Default Comment')
		e.preventDefault()
	}  

	  add(text)
	 {
		  console.log('tryin 2 add')
		   var arr = this.state.comments
		   arr.push(text)
		   this.setState({comments:arr})

	  }
	  render () {
  	return (

	    	<div>
	      	<button ref='buttonToAdd' onClick={this.addButton}>Add More Comments </button>
		      {
		        	this.state.comments.map((text, i)=>{
          	return <Comment update={this.updateComment} remove={this.removeComment} key={i} index={i} >{text}</Comment>
          })
        }
      </div>
    )
  }
}

ReactDOM.render(
<Board/>,
  document.getElementById('eventHandling')
);

###############################################################import React, { Component } from 'react';
import './styles.css'

class CompleteFormValidation extends Component {
    render() {
        return (
            <Register />
        );
    }
}
export default CompleteFormValidation

const validEmailRegex = RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i);


const validateForm = (errors) => {
    let valid = true;
    Object.values(errors).forEach(
        (val) => val.length > 0 && (valid = false)
    );
    return valid;
}

class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {AA
            fullName: null,
            email: null,
            password: null,
            errors: {
                fullName: '',
                email: '',
                password: '',
            }
        };
    }

    handleChange = (event) => {
        event.preventDefault();
        const { name, value } = event.target;
        let errors = this.state.errors;

        switch (name) {
            case 'fullName':
                errors.fullName =
                    value.length < 5
                        ? 'Full Name must be 5 characters long!'
                        : '';
                break;
            case 'email':
                errors.email =
                    validEmailRegex.test(value)
                        ? ''
                        : 'Email is not valid!';
                break;
            case 'password':
                errors.password =
                    value.length < 8
                        ? 'Password must be 8 characters long!'
                        : '';
                break;
            default:
                break;
        }


    }

    handleSubmit = (event) => {
        event.preventDefault();
      
    }

    render() {
        
        return (
            <div className='wrapper'>
                <div className='form-wrapper'>
                    <h2>Create Account</h2>
                    <form onSubmit={this.handleSubmit} noValidate>
                        <div className='fullName'>
                            <label htmlFor="fullName">Full Name</label>
                            <input type='text' name='fullName' onChange={this.handleChange} noValidate />
                            {errors.fullName.length > 0 &&
                                <span className='error'>{errors.fullName}</span>}
                        </div>
                        <div className='email'>
                            <label htmlFor="email">Email</label>
                            <input type='email' name='email' onChange={this.handleChange} noValidate />
                            {errors.email.length > 0 &&
                                <span className='error'>{errors.email}</span>}
                        </div>
                        <div className='password'>
                            <label htmlFor="password">Password</label>
                            <input type='password' name='password' onChange={this.handleChange} noValidate />
                            {errors.password.length > 0 &&
                                <span className='error'>{errors.password}</span>}
                        </div>
                        <div className='info'>
                            <small>Password must be eight characters in length.</small>
                        </div>
                        <div className='submit'>
                            <button>Create</button>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}
