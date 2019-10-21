import React, { Component } from 'react';
import ProductDisplay from './ProductDisplay';

class ProductList extends Component {

    render() {
        const ProductList = [
            {
                productId: 1001,
                productName: 'OnePlusMobile',
                quantityOnHand: 20,
                price: 55000
            },
            {
                productId: 1002,
                productName: 'OnePlusTV',
                quantityOnHand: 14,
                price: 68000
            }
        ]
        return (
            <div>
                {ProductList.map((product,index) =>
                    <ProductDisplay keyIndex={index} product={product}></ProductDisplay>
                )}
            </div>
        );
    }
}

export default ProductList;