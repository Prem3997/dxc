import React, { Component } from 'react';

class ProductDisplay extends Component {
    render() {
        const {product,keyIndex}=this.props
        return (
            <div>
                <h2>
                    ProductId: {product.productId}{' '}
                    ProductName: {product.productName}{' '}
                    Quantity: {product.quantityOnHand}{' '}
                    Price: {product.price}
                </h2>
            </div>
        );
    }
}

export default ProductDisplay;