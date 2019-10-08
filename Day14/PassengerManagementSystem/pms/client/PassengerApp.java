package com.dxc.pms.client;

import java.util.Scanner;

import com.dxc.pms.dao.PassengerDAO;
import com.dxc.pms.dao.PassengerDAOImpl;
import com.dxc.pms.model.Passenger;

public class PassengerApp {
	Scanner scanner=new Scanner(System.in);
	Passenger passenger;
	PassengerDAO passengerDAO;
	String pnrNumber;
	String passengerName;
	String source;
	String Destination;
	int fare;
	int choice=0;

	public PassengerApp() {
		// TODO Auto-generated constructor stub
		this.passengerDAO=new PassengerDAOImpl();
	}
	private Passenger takePassengerInput() {
		System.out.println("Enter Product Id, Product Name, Product Quantity, Product Price");
		pnrNumber=scanner.next();
		passengerName=scanner.next();
		source=scanner.next();
		Destination=scanner.next();
		fare=scanner.nextInt();
		Passenger passenger=new Passenger(pnrNumber, passengerName, source, Destination, fare);
		return passenger;
	}
	public void launchApp() {
		while(true) {
			System.out.println("Menu");
			System.out.println("1.Add Passenger");
			System.out.println("2.Get All Passengers");
			System.out.println("3.Search Product using PNR Number");
			System.out.println("4.Delete the Passenger using Product Id");
			System.out.println("5.Update The Passenger Details");
			System.out.println("6.Exit");
			System.out.println("Enter the Choice");
			choice=scanner.nextInt();
			switch(choice) {
			case 1:
				passenger = takePassengerInput();
				if(!passengerDAO.isProductExists(passenger.getPnrNumber()))
					passengerDAO.addPassenger(passenger);
				else
					System.out.println("Passenger Already Exists");
				break;
			case 2:
				System.out.println("The list of Passenger");
				System.out.println(passengerDAO.getAllPassengers());
				break;
			case 3:
				System.out.println("Enter Product Id to search");
				pnrNumber=scanner.next();
				if (passengerDAO.isProductExists(passenger.getPnrNumber())) {
					Passenger searchPassenger = passengerDAO.getPassenger(pnrNumber);
					System.out.println(searchPassenger);
				}
				else {
					System.out.println("Passenger Not exists");
				}
				break;
			case 4:
				System.out.println("Enter Product Id");
				pnrNumber=scanner.next();
				passengerDAO.deletePassenger(pnrNumber);
				System.out.println("Passenger Deleted Succesfully");
				break;
			case 5:
				System.out.println("To update the Product");
				Passenger productToUpdate=takePassengerInput();
				passengerDAO.updatePassenger(productToUpdate);
				System.out.println("Passenger Updated Successfully");
				break;
			case 6:	
				System.exit(0);
				break;
			}
		}	
	}

}
