import React, { Component } from 'react';

class Bye extends Component {
    render() {
        const {name,designation}=this.props
        return (
            <div>
                <h1>Thanks for visiting my website {name}--{designation}</h1>
            </div>
        );
    }
}

export default Bye;