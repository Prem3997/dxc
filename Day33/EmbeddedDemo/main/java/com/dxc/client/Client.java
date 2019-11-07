package com.dxc.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dxc.model.BillAmount;
import com.dxc.model.Customer;
import com.dxc.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		BillAmount billAmount1=new BillAmount(10001, 300, 304, 4959);
		BillAmount billAmount2=new BillAmount(10002, 440, 543, 4457);
		BillAmount billAmount3=new BillAmount(10003, 495, 432, 4950);
		
		Set<BillAmount> allBillAmounts =new HashSet<BillAmount>();
		allBillAmounts.add(billAmount1);
		allBillAmounts.add(billAmount2);
		allBillAmounts.add(billAmount3);
		
		Customer customer=new Customer("Prem", allBillAmounts);
		session.save(customer);
		transaction.commit();
		
		System.out.println("Bill Added to The Customer");
		
		
		
	}
}
