package com.dxc.model;

import javax.persistence.Embeddable;

@Embeddable
public class BillAmount {
	private int billNumber;
	private int cgst;
	private int sgst;
	private int actualAmount;
	public BillAmount() {
		// TODO Auto-generated constructor stub
	}
	public BillAmount(int billNumber, int cgst, int sgst, int actualAmount) {
		super();
		this.billNumber = billNumber;
		this.cgst = cgst;
		this.sgst = sgst;
		this.actualAmount = actualAmount;
	}
	public int getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public int getCgst() {
		return cgst;
	}
	public void setCgst(int cgst) {
		this.cgst = cgst;
	}
	public int getSgst() {
		return sgst;
	}
	public void setSgst(int sgst) {
		this.sgst = sgst;
	}
	public int getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(int actualAmount) {
		this.actualAmount = actualAmount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actualAmount;
		result = prime * result + billNumber;
		result = prime * result + cgst;
		result = prime * result + sgst;
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
		BillAmount other = (BillAmount) obj;
		if (actualAmount != other.actualAmount)
			return false;
		if (billNumber != other.billNumber)
			return false;
		if (cgst != other.cgst)
			return false;
		if (sgst != other.sgst)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BillAmount [billNumber=" + billNumber + ", cgst=" + cgst + ", sgst=" + sgst + ", actualAmount="
				+ actualAmount + "]";
	}
	
}
