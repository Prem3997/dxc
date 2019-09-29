
public class Product {
	private int productId;
	private String productName;
	private int quantityOrdered;
	private int price;
	public Product() {
		super();
		productName="Product Not available";
	}
	public Product(int productId, String productName, int quantityOrdered, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantityOrdered = quantityOrdered;
		this.price = price;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantityOrdered="
				+ quantityOrdered + ", price=" + price + "]";
	}
}
