package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ClientFeedback {
	@Id
	private String feedBackId;
	private String expectation;
	private String improvement;
	
	public ClientFeedback() {
		super();
	}

	public ClientFeedback(String feedBackId, String expectation, String improvement) {
		super();
		this.feedBackId = feedBackId;
		this.expectation = expectation;
		this.improvement = improvement;
	}

	public String getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(String feedBackId) {
		this.feedBackId = feedBackId;
	}

	public String getExpectation() {
		return expectation;
	}

	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}

	public String getImprovement() {
		return improvement;
	}

	public void setImprovement(String improvement) {
		this.improvement = improvement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expectation == null) ? 0 : expectation.hashCode());
		result = prime * result + ((feedBackId == null) ? 0 : feedBackId.hashCode());
		result = prime * result + ((improvement == null) ? 0 : improvement.hashCode());
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
		ClientFeedback other = (ClientFeedback) obj;
		if (expectation == null) {
			if (other.expectation != null)
				return false;
		} else if (!expectation.equals(other.expectation))
			return false;
		if (feedBackId == null) {
			if (other.feedBackId != null)
				return false;
		} else if (!feedBackId.equals(other.feedBackId))
			return false;
		if (improvement == null) {
			if (other.improvement != null)
				return false;
		} else if (!improvement.equals(other.improvement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientFeedback [feedBackId=" + feedBackId + ", expectation=" + expectation + ", improvement="
				+ improvement + "]";
	}


}
