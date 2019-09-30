package vehicle;

public class Truck extends Vehicle {
	private String truckType;
	private int capacity;

	public Truck() {
		// TODO Auto-generated constructor stub
	}

	public Truck(String truckType, int capacity) {
		super();
		this.truckType = truckType;
		this.capacity = capacity;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Truck [truckType=" + truckType + ", capacity=" + capacity + ", getColor()=" + getColor()
				+ ", getManufacturingYear()=" + getManufacturingYear() + ", getNoOfWheels()=" + getNoOfWheels() + "]";
	}
	

}
