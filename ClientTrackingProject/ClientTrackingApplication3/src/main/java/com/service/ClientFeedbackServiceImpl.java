package com.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ClientFeedbackDAO;
import com.model.ClientFeedback;
import com.model.ClientVisit;

@Service
public class ClientFeedbackServiceImpl implements ClientFeedbackService {
	@Autowired
	ClientFeedbackDAO feedbackDAO;

	@Override
	public boolean addFeedback(String visitId, ClientFeedback feedback) {
		// TODO Auto-generated method stub
		return feedbackDAO.addFeedback(visitId, feedback);
	}

	@Override
	public boolean deleteFeedback(String visitId, String feedBackId) {
		// TODO Auto-generated method stub
		return feedbackDAO.deleteFeedback(visitId, feedBackId);
	}

	@Override
	public boolean updateFeedback(String visitId, ClientFeedback feedback) {
		// TODO Auto-generated method stub
		return feedbackDAO.updateFeedback(visitId, feedback);
	}

	@Override
	public boolean isFeedbackExists(String feedBackId) {
		// TODO Auto-generated method stub
		return feedbackDAO.isFeedbackExists(feedBackId);
	}

	@Override
	public ClientFeedback getFeedback(String visitId, String feedBackId) {
		// TODO Auto-generated method stub
		return feedbackDAO.getFeedback(visitId, feedBackId);
	}

	@Override
	public Set<ClientFeedback> getFeedbacks(String visitId) {
		// TODO Auto-generated method stub
		return feedbackDAO.getFeedbacks(visitId);
	}

	@Override
	public String getVisitId(String feedBackId) {
		// TODO Auto-generated method stub
		return feedbackDAO.getVisitId(feedBackId);
	}

	@Override
	public List<ClientFeedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return feedbackDAO.getAllFeedbacks();
	}

	@Override
	public List<ClientVisit> getVisit(String feedBackId) {
		// TODO Auto-generated method stub
		return feedbackDAO.getVisit(feedBackId);
	}

}
