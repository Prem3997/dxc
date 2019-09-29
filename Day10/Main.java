
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			CustomerDetails d1=new CustomerDetails(1,"PremBalaji","Krishnagiri",4000);
			CustomerDetails d2=new CustomerDetails(2,"RoshanThomas","Coimbatore",4450);
			CustomerDetails d3=new CustomerDetails();
			CustomerDetails d4=new CustomerDetails(4,"Jishnu","Hyderabad");
			CustomerDetails d5=new CustomerDetails(5,300);
			d1.displayCustomerDetails();
			d2.displayCustomerDetails();
			d3.displayCustomerDetails();
			d4.displayCustomerDetails();
			d5.displayCustomerDetails();
			System.out.println("Customer 1 name is "+d1.getCustomerName());
			d5.setCustomerName("VVS");
			System.out.println("Customer 5 name is "+d5.getCustomerName());
			Product product[]=new Product[5];
			for (int i = 0; i < product.length; i++) {
				product[i] = new Product();
			}	
	}
}
