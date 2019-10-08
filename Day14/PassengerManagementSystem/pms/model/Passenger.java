package com.dxc.pms.model;

public class Passenger {
	private String pnrNumber;
	private String passengerName;
	private String source;
	private String Destination;
	private int fare;
	public Passenger() {
		super();
	}
	public Passenger(String pnrNumber, String passengerName, String source, String destination, int fare) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.source = source;
		this.Destination = destination;
		this.fare = fare;
	}
	public String getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Destination == null) ? 0 : Destination.hashCode());
		result = prime * result + fare;
		result = prime * result + ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result + ((pnrNumber == null) ? 0 : pnrNumber.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
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
		Passenger other = (Passenger) obj;
		if (Destination == null) {
			if (other.Destination != null)
				return false;
		} else if (!Destination.equals(other.Destination))
			return false;
		if (fare != other.fare)
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (pnrNumber == null) {
			if (other.pnrNumber != null)
				return false;
		} else if (!pnrNumber.equals(other.pnrNumber))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Passenger [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", source=" + source
				+ ", Destination=" + Destination + ", fare=" + fare + "]";
	}
	

}
