package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Client;
import com.service.ClientService;

@RestController
@RequestMapping("ClientTrackingApplication/client")
@CrossOrigin(origins = { "http://localhost:3000" })
public class ClientController {
	@Autowired
	ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> getClients() {
		List<Client> allClients = clientService.getClients();
		return new ResponseEntity<List<Client>>(allClients, HttpStatus.OK);
	}

	@GetMapping("/{clientId}/")
	public ResponseEntity<Client> getClient(@PathVariable("clientId") String clientId) {
		if (clientService.isClientExists(clientId)) {
			Client client = clientService.getClient(clientId);
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		} else {
			return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/{clientId}/")
	public ResponseEntity<Client> deleteClient(@PathVariable("clientId") String clientId) {
		System.out.println("Controller Called");
		if (clientService.isClientExists(clientId)) {
			clientService.deleteClient(clientId);
			return new ResponseEntity<Client>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping
	public ResponseEntity<Client> addClient(@RequestBody Client client) {
		if (clientService.isClientExists(client.getClientId())) {
			return new ResponseEntity<Client>(client, HttpStatus.CONFLICT);
		} else {
			clientService.addClient(client);
			return new ResponseEntity<Client>(client, HttpStatus.CREATED);
		}
	}

	@PutMapping
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		if (clientService.isClientExists(client.getClientId())) {
			clientService.updateClient(client);
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		} else {
			return new ResponseEntity<Client>(client, HttpStatus.NO_CONTENT);
		}
	}

}
