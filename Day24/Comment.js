import React, {Component} from 'react';
export default class Comment extends Component
{
    render()
    {
        return <h1>Welcome {this.props.commentsText}</h1>
    }
}