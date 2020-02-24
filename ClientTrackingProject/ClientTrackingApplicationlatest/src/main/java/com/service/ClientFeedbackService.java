package com.service;

import java.util.List;
import java.util.Set;

import com.model.ClientFeedback;
import com.model.ClientVisit;

public interface ClientFeedbackService {

	public boolean addFeedback(String visitId, ClientFeedback feedback);

	public boolean deleteFeedback(String visitId, String feedBackId);

	public boolean updateFeedback(String visitId, ClientFeedback feedback);

	public boolean isFeedbackExists(String feedBackId);

	public ClientFeedback getFeedback(String visitId, String feedBackId);

	public Set<ClientFeedback> getFeedbacks(String visitId);

	// to get the visitid when a feedback is clicked
	public String getVisitId(String feedBackId);

	// to get the visitdetail when a feedback is clicked
	public List<ClientVisit> getVisit(String feedBackId);

	// to get all the feedbacks from the feedback collection
	public List<ClientFeedback> getAllFeedbacks();
}
