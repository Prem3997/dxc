package com.model;


import org.springframework.data.annotation.Id;




public class Client {
	@Id
	private String clientId;
	private String clientCompanyName;
	private String representativeName;
	private String location;
	private String mobileNumber;
	private String emailAddress;
	public Client() {
		// TODO Auto-generated constructor stub
	}




	public Client(String clientId, String clientCompanyName, String representativeName, String location,
			String mobileNumber, String emailAddress) {
		super();
		this.clientId = clientId;
		this.clientCompanyName = clientCompanyName;
		this.representativeName = representativeName;
		this.location = location;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
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
	public String getRepresentativeName() {
		return representativeName;
	}

	public void setRepresentativeName(String representativeName) {
		this.representativeName = representativeName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientCompanyName == null) ? 0 : clientCompanyName.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((representativeName == null) ? 0 : representativeName.hashCode());
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
		if (representativeName == null) {
			if (other.representativeName != null)
				return false;
		} else if (!representativeName.equals(other.representativeName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientCompanyName=" + clientCompanyName + ", representativeName="
				+ representativeName + ", location=" + location + ", mobileNumber=" + mobileNumber + ", emailAddress="
				+ emailAddress + "]";
	}

	
}
