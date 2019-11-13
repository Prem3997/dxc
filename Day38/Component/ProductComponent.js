import React, { Component } from 'react';
import ProductDataService from '../Service/ProductDataService';

class ProductComponent extends Component {
    constructor(props){
        super(props)
        this.state=({
            productId: this.props.match.params.productId,
            productName:"",
            quantityOnHand:"",
            price:""
        })
    }
    componentWillMount(){
        ProductDataService.getProduct(this.state.productId).then(
            response=>{
                this.setState({
                    productName:response.data.productName,
                    quantityOnHand:response.data.quantityOnHand,
                    price:response.data.price
                })
            }
        )
    }
    render() {
        let {
            productId,productName,quantityOnHand,price
        }=this.state
        return (
            <div align="center">
                <h1>To ADD/UPDATE The Product</h1>
                <h2>
                    Product Id:{productId}<br/>
                    Product Name:{productName}<br/>
                    Product Quantity:{quantityOnHand}<br/>
                    Product Price:{price}<br/>
                </h2>
            </div>
        );
    }
}

export default ProductComponent;