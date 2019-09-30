package vehicle;

public class Vehicle {
	private String color;
	private int manufacturingYear;
	private int noOfWheels;
	public Vehicle() {
		// TODO Auto-generated constructor stub
		color="Black";
		manufacturingYear=2019;
		noOfWheels=4;
	}
	public Vehicle(String color, int manufacturingYear, int noOfWheels) {
		super();
		this.color = color;
		this.manufacturingYear = manufacturingYear;
		this.noOfWheels = noOfWheels;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getManufacturingYear() {
		return manufacturingYear;
	}
	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}
	public int getNoOfWheels() {
		return noOfWheels;
	}
	public void setNoOfWheels(int noOfWheels) {
		this.noOfWheels = noOfWheels;
	}
	@Override
	public String toString() {
		return "Vehicle [color=" + color + ", manufacturingYear=" + manufacturingYear + ", noOfWheels=" + noOfWheels
				+ "]";
	}

}
