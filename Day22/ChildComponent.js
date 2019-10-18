import React, { Component } from 'react';

class ChildComponent extends Component {
    render() {
        return (
            <div>
                <h1>ChildData:{this.props.myNameProp}</h1>
                <button onClick={this.props.updateName}>Click To Change Name via ChildComponent</button><br/>
                <h1>Comment Data:{this.props.myCommentProp}</h1>
                <button onClick={this.props.myCommentEdit}>Edit</button>
                
            </div>
        );
    }
}

export default ChildComponent;