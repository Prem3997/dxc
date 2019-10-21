import React, { Component } from 'react';

class DestructuringProps extends Component {
    
    render() {
        const {userName}=this.props
        return (
            <div>
                <h1>Your Name is {userName}</h1>
            </div>
        );
    }
}

export default DestructuringProps;