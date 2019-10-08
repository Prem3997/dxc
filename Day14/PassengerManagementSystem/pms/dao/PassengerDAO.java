package com.dxc.pms.dao;

import java.util.List;

import com.dxc.pms.model.Passenger;


public interface PassengerDAO {
	public Passenger getPassenger(String pnrNumber);
	public List<Passenger>getAllPassengers();
	public void addPassenger(Passenger passenger);
	public void deletePassenger(String pnrNumber);
	public void updatePassenger(Passenger passenger);
	public boolean isProductExists(String pnrNumber);
}
