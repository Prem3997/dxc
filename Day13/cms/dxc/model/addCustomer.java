package com.cms.dxc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class addCustomer {
	public static void main(String[] args) {
		List customerNames=new ArrayList();
		customerNames.add("Prem");
		customerNames.add("Balaji");
		customerNames.add("Roshan");
		customerNames.add("Thomas");
		System.out.println(customerNames);
		System.out.println(customerNames.contains("Prem"));
		System.out.println(customerNames.isEmpty());
		customerNames.add(2,"Jishnu");
		customerNames.add("Revathi");
		System.out.println(customerNames);
		Iterator i = customerNames.iterator();
		System.out.println("Customer Names With R");
		while(i.hasNext()) {
			String rName=(String) i.next();
			if(rName.charAt(0)=='R') {
				System.out.println(rName);
				System.out.println(i.hasNext());
			}
			
		}
		Collections.sort(customerNames);
		System.out.println(customerNames);
		int j=Collections.binarySearch(customerNames, "Roshan");
		System.out.println(j);
		
		
	}
}
