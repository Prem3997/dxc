import React, { Component } from 'react'
import CommentChild from './CommentChild';

class CommentParent extends Component
{
    constructor(props) 
    {
        super(props);
        this.state = {
            comments: [],
            text: ''
            
        }
        this.onChange=this.onChange.bind(this)
        this.handleSubmit=this.handleSubmit.bind(this)
    }

    onChange(e) {
        this.setState({text: e.target.value})
    }

    handleSubmit(e) 
    {
        e.preventDefault();
        var nextComments = this.state.comments.concat([this.state.text]);
        var nextText = '';
        this.setState({comments: nextComments, text: nextText});
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
        <div>
            
            
           
                <input onChange={this.onChange} value={this.state.text} />
                <button>{'Add #' + (this.state.comments.length + 1)}</button>
                <h3>Comments</h3>
                <CommentChild comments={this.state.comments} />
            
        </div>
        </form>
        );
    }
}
export default CommentParent