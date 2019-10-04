package com.cms.dxc.client;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.cms.dxc.exception.InvalidBillAmountException;
import com.cms.dxc.exception.InvalidCustomerIdException;
import com.cms.dxc.model.Customer;

public class Main {
	public static void main(String[] args) {
		List<Customer> customerList = customerData();
		displayCustomer("Before Sorting",customerList);
		Collections.sort(customerList);
		displayCustomer("After Sorting",customerList);
		
	}

	private static void displayCustomer(String message,List<Customer> customerList) {
		System.out.println(message);
		Iterator<Customer> iterator=customerList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	private static List<Customer> customerData() {
		Customer customer1=null;
		Customer customer2=null;
		Customer customer3=null;
		Customer customer4=null;
		Customer customer5=null;
		try {
			customer1 = new Customer(1002, "Prem", "Coimbatore", 1200);
			customer2 = new Customer(1003, "Revathy", "Pune", 12200);
			customer3 = new Customer(1005, "Raaj", "Chennai", 15200);
			customer4 = new Customer(1004, "Naga", "Bangalore", 120);
			customer5 = new Customer(1001, "Balaji", "Krishnagiri", 12400);
		} catch (InvalidBillAmountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (InvalidCustomerIdException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		List<Customer> customerList=new ArrayList<Customer>();
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		customerList.add(customer4);
		customerList.add(customer5);
		return customerList;
	}
}
