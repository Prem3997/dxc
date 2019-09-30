package vehicle;

public class Car extends Vehicle {
	private String abs;
	private String bodytype;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String abs, String bodytype) {
		super();
		this.abs = abs;
		this.bodytype = bodytype;
	}

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	public String getBodytype() {
		return bodytype;
	}

	public void setBodytype(String bodytype) {
		this.bodytype = bodytype;
	}

	@Override
	public String toString() {
		return "Car [abs=" + abs + ", bodytype=" + bodytype + ", getColor()=" + getColor() + ", getManufacturingYear()="
				+ getManufacturingYear() + ", getNoOfWheels()=" + getNoOfWheels() + "]";
	}
	
}
