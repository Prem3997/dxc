import React, { Component } from 'react';
import ProductDisplay from './ProductDisplay';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import ProductDetails from './ProductDetails';
class stockUpdate extends Component {
    constructor(props) {
        super(props)
        this.state = {
            errors:{
                quantity:''
            },
            productList: [
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
        }
        this.doValidation=this.doValidation.bind(this)
    }
    doValidation=(e)=>{
        e.preventDefault()
        const{name,value}=e.target
        let errors=this.state.errors;
    
           if(value < 0)
           errors.quantity='Quantity cant be negative';
         
       else if((value.length == 0))
       errors.quantity='Quantity cant be empty';
       
       else
       errors.quantity='';
    
    this.setState({
        errors,[name]:value
    })
    }
    updateStock = (e) => {
        e.preventDefault()
        let productList = this.state.productList
        let toUpdateProductId = this.refs.productId.value
        let toUpdateQuantityOnHand = this.refs.quantityOnHand.value
        console.log(toUpdateQuantityOnHand)
        let updateProduct
        let updateIndex
        productList.map((product,index) => {
            if (product.productId == toUpdateProductId) {
                updateProduct = this.state.productList[index]
                console.log(updateProduct.quantityOnHand)
                updateIndex=index
                //updateProduct.quantityOnHand = toUpdateQuantityOnHand
            }
        }
        )
        this.updateProductMethod(updateIndex, toUpdateQuantityOnHand)

    }

    updateProductMethod(updateIndex, toUpdateQuantityOnHand) 
    {
        var arr = this.state.productList
        arr[updateIndex].quantityOnHand = toUpdateQuantityOnHand
        this.setState({
            productList: arr
        })
    }


    render() {
        let productList = this.state.productList
        return (
            <div>
                <form>
                    <h2>
                        Enter Product Id:<input type="text" ref="productId" ></input><br></br>
                    </h2>
                    <h2>
                        Enter Quantity :<input type="text"  name="quantityOnHand" ref="quantityOnHand"onChange={this.doValidation}></input>
                    </h2>
                    <span>{this.state.errors.quantity}</span>
                    <button onClick={(e) => this.updateStock(e)}>Update Stock</button>
                </form>
                {this.state.productList.map((product, index) =>
                    <Link to={`${this.props.match.url}/` + product.productName}>
                        <ProductDisplay render={({ match }) => match = { match }}
                            nn={index}
                            key={product.productId}
                            product={product}
                        ></ProductDisplay>
                    </Link>

                )}
                <Route path={`${this.props.match.path}/:productName`}
                    render={({ match }) => match = { match }}
                    component={ProductDetails} />
            </div>

        );
    }
}
export default stockUpdate;
