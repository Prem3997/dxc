import React,{Component} from 'react'
class TagPeope extends Component{
    constructor(){
        super()
        console.log("Cons Called")
        this.state={
            message:"Hi Welcome to the TagPage"
        }
    }
    tagMe(){
        console.log("uyt")
        this.setState({
            message:"Your Friend Is Tagged",
            qoute: "Good Pic!!!"
        })
    }
    render(){
        console.log("Tag People Render Called")
        return <div>
            <h1>Tag {this.props.friendName} and Notify Them.</h1>
            <h1>
                Message is :{this.state.message}<br/>
                {this.state.qoute}<br/>
                <button onClick={() =>this.tagMe()}>Tag</button>
            </h1>
        </div>
    }
}
export default TagPeope;