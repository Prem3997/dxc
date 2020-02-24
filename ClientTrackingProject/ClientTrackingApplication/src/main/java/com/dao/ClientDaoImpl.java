package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.model.Client;
import com.mongodb.client.result.UpdateResult;
@Repository
public class ClientDaoImpl implements ClientDao {
	@Autowired
	MongoTemplate template;
	@Override
	public boolean addClient(Client client) {
		// TODO Auto-generated method stub
		if(isClientExists(client.getClientId())) {
			return false;
		}
		else {
			template.save(client);
			return true;
		}
	}
	@Override
	public Client getClient(String clientId) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("clientId").is(clientId));
		return template.findOne(query, Client.class,"client");
	}
	@Override
	public boolean isClientExists(String clientId) {
		// TODO Auto-generated method stub
		Client client=getClient(clientId);
		if(client==null) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean deleteClient(String clientId) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("clientId").is(clientId));
		Client clientToBeDeleted=template.findAndRemove(query, Client.class,"client");
		if(clientToBeDeleted==null){ 
			return true; 
		}
		else{ 
			return false; 
		}
		 
	}
	@Override
	public boolean updateClient(Client client) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("clientId").is(client.getClientId()));
		Update update=new Update();
		update.set("clientName",client.getClientName());
		update.set("clientCompanyName",client.getClientCompanyName());
		update.set("location",client.getLocation());
		update.set("mobileNumber",client.getMobileNumber());
		update.set("emailAddress",client.getEmailAddress());
		UpdateResult writeResult=template.updateFirst(query, update, Client.class);
		long rowsAffected=writeResult.getModifiedCount();
		if(rowsAffected==0) {
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public List<Client> getClients() {
		// TODO Auto-generated method stub
		return template.findAll(Client.class);
	}
	@Override
	public Client getClientByName(String clientName) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("clientName").is(clientName));
		return template.findOne(query, Client.class,"client");
	}

}
