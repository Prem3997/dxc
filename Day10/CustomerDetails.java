
public class CustomerDetails {
	private int customerId;
	private String customerName;
	private String customerAddress;
	private int billAmount;
	static int count=0;
	public CustomerDetails() {
		customerId=0;
		customerName="Not Available";
		customerAddress="Address Not Available";
		billAmount=100;
		
	}
	public CustomerDetails(int customerId,String customerName,String customerAddress,int billAmount) {
		this.customerId=customerId;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		this.billAmount=billAmount;
	}
	public CustomerDetails(int customerId, String customerName, String customerAddress) {
		this();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}
	
	public CustomerDetails(int customerId, int billAmount) {
		this();
		this.customerId = customerId;
		this.billAmount = billAmount;
	}
	public CustomerDetails(String customerName, int billAmount) {
		this();
		this.customerName = customerName;
		this.billAmount = billAmount;
	}
	public CustomerDetails(int customerId, String customerAddress, int billAmount) {
		this();
		this.customerId = customerId;
		this.customerAddress = customerAddress;
		this.billAmount = billAmount;
	}
	public CustomerDetails(String customerName, String customerAddress, int billAmount) {
		this();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.billAmount = billAmount;
	}
	public void displayCustomerDetails() {
		System.out.println("Customer "+(++count)+" Details");
		System.out.println("Customer id: "+customerId);
		System.out.println("Customer Name: "+customerName);
		System.out.println("Customer Address: "+customerAddress);
		System.out.println("Bill Amount : "+billAmount);
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	public int getCustomerId() {
		return customerId;
	}
}
