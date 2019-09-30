package vehicle;

public class Road {

	public Road() {
		// TODO Auto-generated constructor stub
	}
	public static void displayBus(Bus b) {
		System.out.println("The Details of Vehicle are:");
		System.out.println("Bus");
		System.out.println("Bus Type : "+b.getBusType());
		System.out.println("Bus Color : "+b.getColor());
		System.out.println("No of Axles : "+b.getNoOfAxles());
		System.out.println("No of Wheels : "+b.getNoOfWheels());
		System.out.println("Manufacturing Year : "+b.getManufacturingYear());
	}
	public static void displayCar(Car b) {
		System.out.println("The Details of Vehicle are:");
		System.out.println("Car");
		System.out.println("Car Type : "+b.getBodytype());
		System.out.println("Car Color : "+b.getColor());
		System.out.println("ABS OR NOT : "+b.getAbs());
		System.out.println("No of Wheels : "+b.getNoOfWheels());
		System.out.println("Manufacturing Year : "+b.getManufacturingYear());
	}
	public static void displayTruck(Truck b) {
		System.out.println("The Details of Vehicle are:");
		System.out.println("Truck");
		System.out.println("Truck Type : "+b.getTruckType());
		System.out.println("Truck Color : "+b.getColor());
		System.out.println("Capacity in kg : "+b.getCapacity());
		System.out.println("No of Wheels : "+b.getNoOfWheels());
		System.out.println("Manufacturing Year : "+b.getManufacturingYear());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bus b=new Bus(4, "AC");
		Car c=new Car("ABS", "Sedan");
		c.setColor("Red");
		Truck t=new Truck("beverage", 6000);
		t.setNoOfWheels(6);
		t.setManufacturingYear(2018);
		displayBus(b);
		displayCar(c);
		displayTruck(t);
	}

}
