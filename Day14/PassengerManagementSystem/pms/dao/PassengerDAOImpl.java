package com.dxc.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pms.dbconn.DbConnection;
import com.dxc.pms.model.Passenger;


public class PassengerDAOImpl implements PassengerDAO{
	Connection connection=DbConnection.getConnection();
	private static final String FETCH_PASSENGER_ALL="select * from passenger";
	private static final String FETCH_PASSENGER_BY_PNRNUMBER="select  from passenger where pnrNumber=?";
	private static final String Insert_PASSENGER="Insert into product values(?,?,?,?,?)";
	private static final String DELETE_PASSENGER="Delete from passenger where pnrNumber=?";
	private static final String UPDATE_PASSENGER="Update passenger set passengerName=?,source=?,destination=?,fare=? where pnrNumber=?";
	private Passenger passenger;

	@Override
	public Passenger getPassenger(String pnrNumber) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		passenger = null;
		try {
			statement = connection.prepareStatement(FETCH_PASSENGER_BY_PNRNUMBER);
			statement.setString(1, pnrNumber);
			ResultSet resultSet=statement.executeQuery();
			resultSet.next();
			passenger.setPnrNumber(resultSet.getString(1));
			passenger.setPassengerName(resultSet.getString(2));
			passenger.setSource(resultSet.getString(3));
			passenger.setDestination(resultSet.getString(4));
			passenger.setFare(resultSet.getInt(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return passenger;
	}

	@Override
	public List<Passenger> getAllPassengers() {
		// TODO Auto-generated method stub
		List<Passenger> allPassengers=new ArrayList<Passenger>();
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(FETCH_PASSENGER_ALL);
			while(resultSet.next()) {
				Passenger passenger=new Passenger();
				passenger.setPnrNumber(resultSet.getString(1));
				passenger.setPassengerName(resultSet.getString(2));
				passenger.setSource(resultSet.getString(3));
				passenger.setDestination(resultSet.getString(4));
				passenger.setFare(resultSet.getInt(5));
				allPassengers.add(passenger);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allPassengers;
	}

	@Override
	public void addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(Insert_PASSENGER);
			preparedStatement.setString(1, passenger.getPnrNumber());
			preparedStatement.setString(2, passenger.getPassengerName());
			preparedStatement.setString(3, passenger.getSource());
			preparedStatement.setString(4, passenger.getDestination());
			preparedStatement.setInt(4, passenger.getFare());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletePassenger(String pnrNumber) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_PASSENGER);
			preparedStatement.setString(1, passenger.getPnrNumber());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(UPDATE_PASSENGER);
			preparedStatement.setString(5, passenger.getPnrNumber());
			preparedStatement.setString(1, passenger.getPassengerName());
			preparedStatement.setString(2, passenger.getSource());
			preparedStatement.setString(3, passenger.getDestination());
			preparedStatement.setInt(4, passenger.getFare());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean isProductExists(String pnrNumber) {
		// TODO Auto-generated method stub
		boolean passengerExists=false;
		PreparedStatement preparedStatement;
		try {
			preparedStatement=connection.prepareStatement(FETCH_PASSENGER_BY_PNRNUMBER);
			preparedStatement.setString(1, pnrNumber);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
				passengerExists=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passengerExists;
	}


}
