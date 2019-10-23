import React, { Component } from 'react';
import ProductDisplay from './ProductDisplay';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import ProductDetails from './ProductDetails';
class ProductList extends Component {
    constructor(props)
    {
        super(props)
        
    }
    render() {
        const productList = [
            {
                productId: 1001,
                productName: 'Watch',
                quantityOnHand: 2000,
                price: 10000
            },
            {
                productId: 1002,
                productName: 'Mouse',
                quantityOnHand: 29,
                price: 180000
            },
            {
                productId: 1003,
                productName: 'Laptop',
                quantityOnHand: 29,
                price: 122
            },
            {
                productId: 10113,
                productName: 'Presenter',
                quantityOnHand: 29,
                price: 122
            },

            {
                productId: 111003,
                productName: 'Marker',
                quantityOnHand: 29,
                price: 122
            },
        ]
        return (
            <div>
                {productList.map((product, index) =>
                    <Link to={`${this.props.match.url}/`+product.productName}>
                        <ProductDisplay render={({ match }) => match={match}}
                            nn={index}
                            key={index}
                            product={product}
                        ></ProductDisplay>
                    </Link>

                )}

                <Route path={`${this.props.match.path}/:productName`}
                    render={({ match }) => match={match}} 
                    component={ProductDetails} />
            </div>

        );
    }
}
export default ProductList;
