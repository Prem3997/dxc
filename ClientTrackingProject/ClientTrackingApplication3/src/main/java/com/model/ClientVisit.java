package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class ClientVisit implements Comparable<ClientVisit> {

	@Id
	private String visitId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateOfVisit;

	private Client client;
	private List<Project> projectToVisit=new ArrayList<Project>();

	private Set<ClientFeedback> clientFeedbacks = new HashSet<ClientFeedback>();

	public ClientVisit() {
		super();
	}

	

	public List<Project> getProjectToVisit() {
		return projectToVisit;
	}



	public void setProjectToVisit(List<Project> projectToVisit) {
		this.projectToVisit = projectToVisit;
	}



	public ClientVisit(String visitId, Date dateOfVisit, Client client, List<Project> projectToVisit,
			Set<ClientFeedback> clientFeedbacks) {
		super();
		this.visitId = visitId;
		this.dateOfVisit = dateOfVisit;
		this.client = client;
		this.projectToVisit = projectToVisit;
		this.clientFeedbacks = clientFeedbacks;
	}



	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((clientFeedbacks == null) ? 0 : clientFeedbacks.hashCode());
		result = prime * result + ((dateOfVisit == null) ? 0 : dateOfVisit.hashCode());
		result = prime * result + ((projectToVisit == null) ? 0 : projectToVisit.hashCode());
		result = prime * result + ((visitId == null) ? 0 : visitId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientVisit other = (ClientVisit) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (clientFeedbacks == null) {
			if (other.clientFeedbacks != null)
				return false;
		} else if (!clientFeedbacks.equals(other.clientFeedbacks))
			return false;
		if (dateOfVisit == null) {
			if (other.dateOfVisit != null)
				return false;
		} else if (!dateOfVisit.equals(other.dateOfVisit))
			return false;
		if (projectToVisit == null) {
			if (other.projectToVisit != null)
				return false;
		} else if (!projectToVisit.equals(other.projectToVisit))
			return false;
		if (visitId == null) {
			if (other.visitId != null)
				return false;
		} else if (!visitId.equals(other.visitId))
			return false;
		return true;
	}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public Set<ClientFeedback> getClientFeedbacks() {
		return clientFeedbacks;
	}

	public void setClientFeedbacks(Set<ClientFeedback> clientFeedbacks) {
		this.clientFeedbacks = clientFeedbacks;
	}

	public int compareTo(ClientVisit clientVisit) {
		return getDateOfVisit().compareTo(clientVisit.getDateOfVisit());
	}

	@Override
	public String toString() {
		return "ClientVisit [visitId=" + visitId + ", dateOfVisit=" + dateOfVisit + ", client=" + client
				+ ", projectToVisit=" + projectToVisit + ", clientFeedbacks=" + clientFeedbacks + "]";
	}
}
