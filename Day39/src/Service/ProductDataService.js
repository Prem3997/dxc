import axios from "axios"
const PRODUCT_API_URL ="http://localhost:8001/product"
//const PRODUCT_API_URL ="http://10.231.139.35:8001/product"
class ProductDataService{
    getAllProduct(){
        return axios.get(`${PRODUCT_API_URL}`)
    }
    deleteProduct(productId){
        return axios.delete(`${PRODUCT_API_URL}/${productId}`)
    }
    getProduct(productId){
        return axios.get(`${PRODUCT_API_URL}/${productId}`)
    }
    updateProduct(product){
        return axios.put(`${PRODUCT_API_URL}`,product)
    }
    addProduct(product){
        return axios.post(`${PRODUCT_API_URL}`,product)
    }
}   
export default new ProductDataService()