import React, { Component } from 'react'
import axios from 'axios'
class Restful extends Component {
    constructor() {
        super()
        this.state = {
            username: ''
        }
        this.handleClick = this.handleClick.bind(this)
    }
    handleClick() {
        console.log("handleClick Called")
        axios.get('https://api.github.com/users/smohit02')
            .then(response => this.setState({ username: response.data.login }))
    }
    render() {
        return (
            <div>
                Get User Name :<input type="text" name="getUserName"></input>
                <button className='button' onClick={this.handleClick}>Click Me</button>
                <p>{this.state.username}</p>
            </div>
        )
    }
}
export default Restful