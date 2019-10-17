import React from 'react';

const Display = () => {
    function display(){
        console.log("Display Called")
    }
    return (
        <div>
            <button onClick={display}>Display</button>
        </div>
    );
};

export default Display;