package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ClientDAO;
import com.model.Client;
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientDAO clientDao;
	@Override
	public boolean addClient(Client client) {
		// TODO Auto-generated method stub
		return clientDao.addClient(client);
	}

	@Override
	public Client getClient(String clientId) {
		// TODO Auto-generated method stub
		return clientDao.getClient(clientId);
	}

	@Override
	public boolean isClientExists(String clientId) {
		// TODO Auto-generated method stub
		return clientDao.isClientExists(clientId);
	}

	@Override
	public boolean deleteClient(String clientId) {
		// TODO Auto-generated method stub
		return clientDao.deleteClient(clientId);
	}

	@Override
	public boolean updateClient(Client client) {
		// TODO Auto-generated method stub
		return clientDao.updateClient(client);
	}

	@Override
	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return clientDao.getClients();
	}

	@Override
	public Client getClientByName(String clientName) {
		// TODO Auto-generated method stub
		return clientDao.getClientByName(clientName);
	}


}
