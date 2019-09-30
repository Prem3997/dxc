package vehicle;

public class Bus extends Vehicle {
	private int noOfAxles;
	private String busType;

	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public Bus(int noOfAxles, String busType) {
		super();
		this.noOfAxles = noOfAxles;
		this.busType = busType;
	}

	public int getNoOfAxles() {
		return noOfAxles;
	}

	public void setNoOfAxles(int noOfAxles) {
		this.noOfAxles = noOfAxles;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	@Override
	public String toString() {
		return "Bus [noOfAxles=" + noOfAxles + ", busType=" + busType + ", getColor()=" + getColor()
				+ ", getManufacturingYear()=" + getManufacturingYear() + ", getNoOfWheels()=" + getNoOfWheels() + "]";
	}
	

}
