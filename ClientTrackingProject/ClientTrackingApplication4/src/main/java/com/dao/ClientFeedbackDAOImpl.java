package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.model.ClientFeedback;
import com.model.ClientVisit;
import com.service.ClientVisitService;

@Repository
public class ClientFeedbackDAOImpl implements ClientFeedbackDAO {
	@Autowired
	MongoTemplate template;
	@Autowired
	ClientVisitService clientVisitService;

	@Override
	public boolean addFeedback(String visitId, ClientFeedback feedback) {
		System.out.println("Inside DAOImpl " + feedback);
		ClientVisit clientVisit = clientVisitService.getVisitDetail(visitId);
		System.out.println(clientVisit);
		clientVisit.getClientFeedbacks().add(feedback);
		template.save(feedback);
		template.save(clientVisit);

		return false;
	}

	@Override
	public boolean deleteFeedback(String visitId, String feedBackId) {
		ClientVisit clientVisit = clientVisitService.getVisitDetail(visitId);
		Set<ClientFeedback> allFeedbacks = (Set<ClientFeedback>) clientVisit.getClientFeedbacks();
		allFeedbacks = clientVisit.getClientFeedbacks();
		System.out.println(allFeedbacks);
		for (ClientFeedback x : allFeedbacks) {
			if (feedBackId.equals(x.getFeedBackId())) {
				System.out.println(x);
				allFeedbacks.remove(x);
				clientVisit.setClientFeedbacks(allFeedbacks);
				template.save(clientVisit, "clientVisit");

			} else {
				continue;
			}

		}
		return true;
	}

	@Override
	public boolean updateFeedback(String visitId, ClientFeedback feedback) {
		ClientVisit clientVisit = clientVisitService.getVisitDetail(visitId);
		System.out.println("updateFeedback");
		Set<ClientFeedback> allFeedbacks = (Set<ClientFeedback>) clientVisit.getClientFeedbacks();
		for (ClientFeedback x : allFeedbacks) {
			if (feedback.getFeedBackId().equals(x.getFeedBackId())) {
				System.out.println(x);
				allFeedbacks.remove(x);
				clientVisit.setClientFeedbacks(allFeedbacks);
				clientVisit.getClientFeedbacks().add(feedback);
				template.save(clientVisit, "clientVisit");
				break;
			} else {
				continue;
			}
		}

		return true;
	}

	@Override
	public boolean isFeedbackExists(String feedBackId) {
		ClientFeedback feedBack = template.findById(feedBackId, ClientFeedback.class, "clientFeedback");
		if (feedBack == null)
			return false;
		else
			return true;
	}

	@Override
	public ClientFeedback getFeedback(String visitId, String feedBackId) {
		ClientVisit clientVisit = clientVisitService.getVisitDetail(visitId);
		Set<ClientFeedback> allFeedbacks = (Set<ClientFeedback>) clientVisit.getClientFeedbacks();
		for (ClientFeedback x : allFeedbacks) {
			if (feedBackId.equals(x.getFeedBackId())) {
				return x;
			} else {
				continue;
			}
		}
		return null;
	}

	@Override
	public Set<ClientFeedback> getFeedbacks(String visitId) {
		ClientVisit clientVisit = clientVisitService.getVisitDetail(visitId);
		System.out.println(clientVisit.getClientFeedbacks());
		Set<ClientFeedback> feedbacks = clientVisit.getClientFeedbacks();
		return feedbacks;
	}

	@Override
	public String getVisitId(String feedBackId) {
		List<ClientVisit> allClientVisit = clientVisitService.getAllVisitDetails();

		for (ClientVisit i : allClientVisit) {
			Set<ClientFeedback> ClientFeedback = i.getClientFeedbacks();
			for (ClientFeedback j : ClientFeedback) {
				if (feedBackId.equals(j.getFeedBackId())) {
					String visitId = i.getVisitId();
					System.out.println("VisitID is " + visitId);
					return visitId;

				}
			}
		}
		return null;
	}

	@Override
	public List<ClientFeedback> getAllFeedbacks() {
		return template.findAll(ClientFeedback.class, "clientFeedback");
	}

	@Override

	public List<ClientVisit> getVisit(String feedBackId) {
		List<ClientVisit> allClientVisit = clientVisitService.getAllVisitDetails();
		List<ClientVisit> Visit = new ArrayList<ClientVisit>();
		for (ClientVisit i : allClientVisit) {
			Set<ClientFeedback> ClientFeedback = i.getClientFeedbacks();
			for (ClientFeedback j : ClientFeedback) {
				if (feedBackId.equals(j.getFeedBackId())) 
				{
					Visit.add(i);
				}

			}

		}

		return Visit;
	}

}
