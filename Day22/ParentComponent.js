import React, { Component } from 'react';
import Childedit from './Childedit';

class ParentComponent extends Component {
   constructor(props) {
       super(props);
       this.state={
           comment:"Good"
       }
       this.parentChange=this.parentChange.bind(this)
   };
   parentChange()
   {
       this.setState({
        comment:"Awesome"
       })
   } 

render() {
    return (
        <div>
            <Childedit myDataProp={this.state.comment}
            updateStateProp={this.parentChange}
            ></Childedit>
        </div>
    );
}
}
export default ParentComponent;