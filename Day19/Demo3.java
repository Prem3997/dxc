

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Demo3 {

	private static Scanner sc;

	public static void main(String[] args) {

		List<Customer> customers = customerData();

		printCustomerData("Before sorting ",customers);

		sc = new Scanner(System.in);
		System.out.println("Enter sorting columns 1) Sort By Name 2) Sort by Address 3) Sort by BillAmount ");
		int choice = sc.nextInt();
		
		if(choice==1)
		{
			//using anomymous classes
			Collections.sort(customers,new Comparator<Customer>() {
					@Override
					public int compare(Customer o1, Customer o2) {
						if (o1.getCustomerName().compareTo(o2.getCustomerName()) < 0)
						{
							return -1;
						} else {
							return 0;
						}
					}
			});
		}
		if(choice==2)
		{//using comparable
			Collections.sort(customers);
		}
		if(choice==3)
		{
			//using comparator
			Collections.sort(customers,new BilAmountComparator());
		}
		

		printCustomerData("After sorting ", customers);
	}

	private static void printCustomerData(String message, List<Customer> customers) {
		System.out.println(message);

		System.out.println(customers);
	}

	private static List<Customer> customerData() {
		Customer customer1 = new Customer(1, "Tufail", "Bangalore", 9777);
		Customer customer2 = new Customer(2, "Jaya", "Chennai", 97);
		Customer customer3 = new Customer(3, "Arun", "Bangalore", 2377);
		Customer customer4 = new Customer(4, "Mohit", "Bangalore", 33777);
		Customer customer5 = new Customer(5, "Vaibhav", "Raipur", 6000);

		List<Customer> customers = new ArrayList<Customer>();

		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
		customers.add(customer5);
		customers.add(new Customer(1000, "Roshan", "TamilNadu", 2300));
		return customers;
	}

}
