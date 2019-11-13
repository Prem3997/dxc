import React, { Component } from 'react';
import ProductDataService from '../Service/ProductDataService';

class ListProductComponent extends Component {
    constructor(props){
        super(props)
        this.refreshProduct=this.refreshProduct.bind(this)
        this.deleteButtonClicked=this.deleteButtonClicked.bind(this)
        this.updateButtonClicked=this.updateButtonClicked.bind(this)
        this.addButtonClicked=this.addButtonClicked.bind(this)
        this.state=({
            products:[],
            message:''
        })
    }
    componentWillMount(){
        this.refreshProduct()
    }
    refreshProduct(){
        ProductDataService.getAllProduct().then(
            response=>{
                this.setState({
                    products:response.data
                })
            }
        )
    }
    deleteButtonClicked(productIdToDelete){
        ProductDataService.deleteProduct(productIdToDelete).then(respone=>{
            this.setState({
                message:'Product Deleted'
            })
            this.refreshProduct()
        })
    }
    addButtonClicked(){

    }
    updateButtonClicked(productId){
        this.props.history.push(`/productsAdd/${productId}`)
        
    }
    render() {
        return (
            <div>
                <h2 align="center">Products in the Shop</h2>
                <div className="container">
                    <h3><center>Product Details</center></h3>
                    <div className="container">
                        <table className="table">
                            <thead>
                                <tr>
                                    <th>Product ID</th>
                                    <th>Product Name</th>
                                    <th>Product Quantity</th>
                                    <th>Product Price</th>
                                    <th>Update Operation</th>
                                    <th>Delete Operation</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.products.map(product=>
                                        <tr key={product.productId}>
                                            <td>{product.productId}</td>
                                            <td>{product.productName}</td>
                                            <td>{product.quantityOnHand}</td>
                                            <td>{product.price}</td>
                                            <td>
                                            <button className="btn btn-info" onClick={()=>this.updateButtonClicked(product.productId)}>Update</button>
                                            </td>
                                            <td>
                                                <button className="btn btn-danger" onClick={()=>this.deleteButtonClicked(product.productId)}>Delete</button>
                                            </td>
                                        </tr>
                                   )
                                }
                            </tbody>
                        </table>
                        <button className="btn btn-primary">Add Product</button>
                        {
                            this.state.message&&
                            <div className="alert alert-success">{this.state.message}
                            </div>
                        }
                    </div>
                </div>
            </div>
        );
    }
}

export default ListProductComponent;