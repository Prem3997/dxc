package com.cms.dxc.model;

import com.cms.dxc.exception.InvalidBillAmountException;
import com.cms.dxc.exception.InvalidCustomerIdException;

public class Customer implements Comparable<Customer>{
	private int customerId;
	private String cutomerName;
	private String customerAddress;
	private int billAmount;
	public Customer() {
		super();
	}
	public Customer(int customerId, String cutomerName, String customerAddress, int billAmount) {
		super();
		checkCustomerId(customerId);
		this.cutomerName = cutomerName;
		this.customerAddress = customerAddress;
		checkBillAmount(billAmount);
	}
	private void checkBillAmount(int billAmount) {
		if (billAmount<0) {
			throw new InvalidBillAmountException("Bill Amount Cannot be Negative");
		}
		else {
			this.billAmount = billAmount;
		}
	}
	private void checkCustomerId(int customerId) {
		if (customerId<0) {
			throw new InvalidCustomerIdException("Customer Id Cannot be Negative");
		}
		else {
			this.customerId = customerId;
		}
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		checkCustomerId(customerId);
	}
	public String getCutomerName() {
		return cutomerName;
	}
	public void setCutomerName(String cutomerName) {
		this.cutomerName = cutomerName;
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
		checkBillAmount(billAmount);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + billAmount;
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((cutomerName == null) ? 0 : cutomerName.hashCode());
		return result;
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
		if (billAmount != other.billAmount)
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerId != other.customerId)
			return false;
		if (cutomerName == null) {
			if (other.cutomerName != null)
				return false;
		} else if (!cutomerName.equals(other.cutomerName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", cutomerName=" + cutomerName + ", customerAddress="
				+ customerAddress + ", billAmount=" + billAmount + "]";
	}
	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		if(this.cutomerName.compareTo(o.cutomerName)<0)
			return 0;
		else
			return -1;
	}
	
}
