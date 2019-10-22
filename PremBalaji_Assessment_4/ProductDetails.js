import React, { Component } from 'react';

class ProductDetails extends Component {

    constructor(props) {
        super(props);
    }
    render() {
        return (
            <div>
                    <h1>Your product details comes here</h1>
                    <h2>You have clicked on :  <h3>{this.props.match.params.productName}</h3></h2>
            </div>
        );
    }
}

export default ProductDetails;