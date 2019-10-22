import React, { Component } from 'react';

class ProductDisplay extends Component {
    
    render() {
        const {nn,product} = this.props
        return (
            <div>
                
                <h3>
                    Product Id :  {product.productId} &nbsp; &nbsp;
                    Product Name :    {product.productName} &nbsp; &nbsp;
                    QuantityOnHand : {product.quantityOnHand} &nbsp; &nbsp;
                    Price : {product.price}</h3> 
                    
            </div>
        );
    }
}

export default ProductDisplay;