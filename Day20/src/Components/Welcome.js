import React from 'react'
function Welcome(){
    return <h1>We Welcome You</h1>
}
const unlike=(props)=>{
    return React.createElement(
        "div",
        {
            id:"myUnlikeDiv1",
            className:"myDiv100"},
            React.createElement("h1",null,"HelloDxc"));

        }

export default Welcome;