package com.dxc.model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.IndexedEmbedded;
@Entity
@Table(name = "CustomerDetails")
public class Customer {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid",strategy = "uuid2")
	private String customerId;
	private String customerName;
	@ElementCollection
	@IndexedEmbedded
	private Set<BillAmount> billAmount;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String customerName, Set<BillAmount> billAmount) {
		super();
		this.customerName = customerName;
		this.billAmount = billAmount;
	}

	public Customer(String customerId, String customerName, Set<BillAmount> billAmount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.billAmount = billAmount;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Set<BillAmount> getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Set<BillAmount> billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (billAmount == null) {
			if (other.billAmount != null)
				return false;
		} else if (!billAmount.equals(other.billAmount))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", billAmount=" + billAmount
				+ "]";
	}
}
