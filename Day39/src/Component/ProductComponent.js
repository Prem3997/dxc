import React, { Component } from 'react';
import ProductDataService from '../Service/ProductDataService'
import { Formik, Form,Field, ErrorMessage } from 'formik';



class ProductComponent extends Component {
    constructor(props){
        super(props)
        this.state=({
            productId: this.props.match.params.productId,
            productName:"",
            quantityOnHand:"",
            price:""
        })
        this.onSubmit=this.onSubmit.bind(this)
    }
    componentWillMount(){
        if(this.state.productId===-1)
            return -1
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
    onSubmit(product){
        console.log(product)
        console.log(this.state.productId)
        console.log(product.productId)
        if(this.state.productId==='-1'){
            ProductDataService.addProduct(product).then(()=>this.props.history.push('/products'))
        }
        else{
            ProductDataService.updateProduct(product).then(()=>this.props.history.push('/products'))
        }  
    }
    validProductForm(values){
        let error={}
        if(!values.productId){
            error.productId="Enter Product Id"
        }
        if(!values.productName){
            error.productName="Enter Product Name"
        }
        if(!values.quantityOnHand){
            error.quantityOnHand="Enter Product Quantity"
        }
        if(!values.price){
            error.price="Enter Product Price"
        }
        console.log(error)
        return error
    }
    render() {
        let {
            productId,productName,quantityOnHand,price
        }=this.state
        let Field1,Button1
        if(productId<0){
            Field1=<Field className="form-control" type="text" name="productId" ></Field>
            Button1=<button className="btn btn-success" type="submit">Add</button>
        }
        if(productId>0){
            Field1=<Field className="form-control" type="text" name="productId" disabled></Field>
            Button1=<button className="btn btn-success" type="submit">Save</button>
        }
        return (
            <div align>
                <h1 align="center">To ADD/UPDATE The Product</h1>
                <Formik
                initialValues={{productId,productName,quantityOnHand,price}} enableReinitialize={true}
                onSubmit={this.onSubmit}
                validateOnChange={false}
                validateOnBlur={false}
                validate={this.validProductForm}>
                    <Form>
                        <fieldset className="form-group">
                            <label>Product Id</label>
                            {Field1}
                        </fieldset>
                        <fieldset className="form-group">
                            <label>Product Name</label>
                            <Field className="form-control" type="text" name="productName"></Field>
                        </fieldset>
                        <fieldset className="form-group">
                            <label>Product Quantity</label>
                            <Field className="form-control" type="text" name="quantityOnHand"></Field>
                        </fieldset>
                        <fieldset className="form-group">
                            <label>Product Price</label>
                            <Field className="form-control" type="text" name="price"></Field>
                        </fieldset>
                        <ErrorMessage name="productName" component="div" className="alert alert-warning"/>
                        <ErrorMessage name="quantityOnHand" component="div" className="alert alert-warning"/>
                        <ErrorMessage name="price" component="div" className="alert alert-warning"/>
                        
                        {Button1}
                    </Form>
                </Formik>
            </div>
        );
    }
}

export default ProductComponent;