import React, { Component } from 'react';


class Comments extends Component {
    constructor(props) {
        super(props);
        this.state=({
            commentsText:this.props.commentsText
        })

    }

    componentWillMount() {
        this.setState({
            commentsText:"Lets start the Session"
        })
    }

    componentDidMount() {
        this.setState({
            commentsText:"Lets Start For Lunch"
        })
    }

    componentWillReceiveProps(nextProps) {

    }

    shouldComponentUpdate(nextProps, nextState) {

    }

    componentWillUpdate(nextProps, nextState) {

    }

    componentDidUpdate(prevProps, prevState) {

    }

    componentWillUnmount() {

    }

    render() {
        return (
            <div>
                <h1>
                    Your Comment is {this.state.commentsText}
                </h1>

            </div>
        );
    }
}

Comments.propTypes = {

};

export default Comments;