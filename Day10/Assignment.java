import java.util.Scanner;

public class Assignment {
	private int productId;
	private String productName;
	private int quantityOrdered;
	private int price;
	public static int pid;
	Scanner sc=new Scanner(System.in);
	public Assignment() {
		super();
		productName="Product Not available";
	}
	public Assignment(int productId, String productName, int quantityOrdered, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantityOrdered = quantityOrdered;
		this.price = price;
	}
	public void getProduct() {
		System.out.println("Enter Product Id");
		productId=sc.nextInt();
		while(productId<0){
			System.out.println("Enter Only Positive Id");
			productId=sc.nextInt();
		}
		System.out.println("Enter Product Name");
		productName=sc.next();
		System.out.println("Enter Quantity");
		quantityOrdered=sc.nextInt();
		while(quantityOrdered<0) {
			System.out.println("Negative number quantity is entered");
		}
		System.out.println("Enter Price Amount");
		price=sc.nextInt();
		while(price<0) {
			System.out.println("Enter Price Amount in Postive");
		}
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		Assignment assignment[]=new Assignment[5];
		for(int i=0;i<5;i++) {
			assignment[i]=new Assignment();
			assignment[i].getProduct();	
		}
		System.out.println("The Entered Products are:");
		for(int i=0;i<5;i++) {
			System.out.println(assignment[i]);
		}
		Assignment product[] =new Assignment[5];
		product[0]=new Assignment(1001, "Alexa", 10, 3000);
		product[1]=new Assignment(1002, "GoogleHome", 12, 4300);
		product[2]=new Assignment(1003, "BluerayPlayer", 2, 43040);
		product[3]=new Assignment(1004, "OLED TV", 1, 500000);
		product[4]=new Assignment(1005, "Speakers", 12, 10000);
		int choice=0;
		int productFound=0;
		do {
			System.out.println("Enter Product id");
			int pid=s.nextInt();
			for(int i=0;i<5;i++) {
				if(product[i].getProductId()==pid) {
					System.out.println(product[i]);
					productFound=1;
					break;
				}
			}
			if(productFound!=1) {
				System.out.println("Enter Valid Product");
			}
			productFound=0;
			System.out.println("Enter 1 to continue 0 to break!");
			choice=s.nextInt();
		}while(choice!=0);
		System.out.println("Program Exits");
	}
}
