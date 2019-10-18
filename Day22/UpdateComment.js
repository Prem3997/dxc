import React,{Component} from 'react'
import Assignmentchild from './Assignmentchild';
class Assignment extends Component{
    constructor(){
        super()
this.state=({
    comment:'',
    name:'Add',
    listofcomments:[]

})
this.collect=this.collect.bind(this)
this.display=this.display.bind(this)
    }
    collect(e){
        this.setState({
            comment:e.target.value,
        })
       
    }
    display(e){
        e.preventDefault();
        //  var alist=this.state.listofcomments.concat([this.state.comment]),
        
        this.setState({
            // listofcomments:alist,
            name:'Edit'

        })
    }
    render(){
       if(this.state.comment.length==0){
        return(
            <div>
                <h1>{this.state.comment}</h1>
                <form onSubmit={this.display}>
                    Comment:<input type="text" onChange={this.collect}/>
                    <button>Add</button>
                </form>
                {/* <Assignmentchild listofcomments={this.state.listofcomments}/> */}
            </div>
        )
    }
    else{ return(
        <div>
            <h1>{this.state.comment}</h1>
            <form onSubmit={this.display}>
                Comment:<input type="text" onChange={this.collect}/>
                <button>{this.state.name}</button>
            </form>
        </div>
    )

    }
}
}
export default Assignment
