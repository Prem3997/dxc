import axios from 'axios';

const BASE_URL = 'http://localhost:5000';

export function getProducts() {
	return axios.get(`${BASE_URL}/api/products`)
		.then(response => response.data);
}

export function getCartProducts(cart) {
	return axios.post(`${BASE_URL}/api/products`, {cart})
		.then(response => response.data);
}

export function login (data) {
	return axios.post(`${BASE_URL}/api/auth`, { name: data.name, password: data.password })
		.then(response => {
			return response.data
		})
		.catch(err => Promise.reject('Authentication Failed!'));
}

export function isAuthenticated(){
	return false
}
