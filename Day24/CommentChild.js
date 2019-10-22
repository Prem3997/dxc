import React, { Component } from 'react'
class CommentChild extends Component
{
    render()
    {
        var createItem = function(itemText) {
            return <li>{itemText}</li>;
        };
    return <ol>{this.props.comments.map(createItem)}</ol>;
  }
}
export default CommentChild;