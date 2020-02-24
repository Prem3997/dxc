package com.service;

import java.util.List;

import com.model.Client;

public interface ClientService {
	public boolean addClient(Client client);

	public Client getClient(String clientId);

	public boolean isClientExists(String clientId);

	public boolean deleteClient(String clientId);

	public boolean updateClient(Client client);

	public List<Client> getClients();

	public Client getClientByName(String clientName);

}
