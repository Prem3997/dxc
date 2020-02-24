package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
//import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import org.springframework.data.annotation.Id;
@Document
//@Entity
public class Client {
	@Id
	private String clientId;
	private String clientCompanyName;
	private String clientName;
	private String location;
	private String mobileNumber;
	private String emailAddress;
	
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
	private Set<Project> clientProjects=new HashSet<Project>();
	public Client() {
	}

	public Client(String clientId, String clientCompanyName, String clientName, String location, String mobileNumber,
			String emailAddress, Set<Project> clientProjects) {
		super();
		this.clientId = clientId;
		this.clientCompanyName = clientCompanyName;
		this.clientName = clientName;
		this.location = location;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.clientProjects = clientProjects;
	}

	public String getClientId() {
		// TODO Auto-generated method stub
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientCompanyName() {
		return clientCompanyName;
	}
	public void setClientCompanyName(String clientCompanyName) {
		this.clientCompanyName = clientCompanyName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Set<Project> getClientProjects() {
		return clientProjects;
	}
	public void setClientProjects(Set<Project> clientProjects) {
		this.clientProjects = clientProjects;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientCompanyName == null) ? 0 : clientCompanyName.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + ((clientProjects == null) ? 0 : clientProjects.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
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
		Client other = (Client) obj;
		if (clientCompanyName == null) {
			if (other.clientCompanyName != null)
				return false;
		} else if (!clientCompanyName.equals(other.clientCompanyName))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (clientProjects == null) {
			if (other.clientProjects != null)
				return false;
		} else if (!clientProjects.equals(other.clientProjects))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientCompanyName=" + clientCompanyName + ", clientName="
				+ clientName + ", location=" + location + ", mobileNumber=" + mobileNumber + ", emailAddress="
				+ emailAddress + ", clientProjects=" + clientProjects + "]";
	}
}
