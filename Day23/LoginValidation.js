import React, { Component } from 'react';
import './LoginValidation.css'

class LoginValidation extends Component {
    constructor(props) {
        super(props)
        this.state = ({
            fullName: '',
            password:'',
            errors: {
                fullName: '',
                password:''
            }
        })
    }
    doValidation = (event) => {
        event.preventDefault()
        const {
            name, value
        } = event.target;
        let errors = this.state.errors
        switch (name) {
            case 'fullName':
                errors.fullName = value.length < 3 ? "Full Name must be atleast 3 characters" :''
                break
                case 'password':
                    errors.password=value.length<3? "Password must be atleast 3 characters":""
                    break;
            default:
                break;

        }
        this.setState({
            errors, [name]: value
        })

    }
    render() {
        return (
            <div>
                <div className='wrapper'>
                    <div className='form-wrapper'>
                        <h2>Enter Details</h2>
                        <form onSubmit={this.doValidation}>
                            <div className='fullName'>
                                <label htmlFor="fullName">Full Name</label><input type="text" name="fullName" onChange={this.doValidation} />
                            </div>
                            <span className="error">{this.state.errors.fullName}</span>
                            <div className='password'>
                                <label htmlFor="password">Password</label><input type="password" name="password" onChange={this.doValidation}></input>
                            </div>
                            <span className="error">{this.state.errors.password}</span>
                            <div className='submit'>
                                <input type="submit" />
                            </div>
                        </form>
                    </div>
                </div>


            </div>
        );
    }
}

export default LoginValidation;