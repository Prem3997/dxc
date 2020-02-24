package com.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.model.ClientFeedback;
import com.model.ClientVisit;
import com.service.ClientFeedbackService;
import com.service.ClientService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class ClientVisitDAOImpl implements ClientVisitDAO {
	@Autowired
	MongoTemplate template;
	@Autowired
	ClientFeedbackService clientFeedbackService;
	@Autowired
	ClientService clientService;
	@Override
	public boolean addVisitDetails(String clientId,ClientVisit clientVisit) {
		System.out.println("addVisit Called");
		template.save(clientVisit);
		return false;
	}

	@Override
	public List<ClientVisit> getAllVisitDetails() {
		return template.findAll(ClientVisit.class);
	}

	@Override
	public ClientVisit getVisitDetail(String visitId) {
		return template.findById(visitId, ClientVisit.class, "clientVisit");
	}

	@Override
	public boolean deleteVisitDetails(String visitId) {
		ClientVisit VisitDetail = new ClientVisit();
		VisitDetail = template.findById(visitId, ClientVisit.class, "clientVisit");
		Set<ClientFeedback> ClientFeedback = VisitDetail.getClientFeedbacks();

		for (ClientFeedback j : ClientFeedback) {
			template.remove(j);
		}
		template.save(VisitDetail, "CancelledVisits");
		DeleteResult writeResult = template.remove(VisitDetail);
		System.out.println(writeResult);
		int rowsAffected = (int) writeResult.getDeletedCount();
		if (rowsAffected == 0) {
			return false;
		} else

			return true;
	}

	@Override
	public boolean updateVisitDetails(ClientVisit clientVisit) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(clientVisit.getVisitId()));
		Update update = new Update();
		update.set("dateOfVisit", clientVisit.getDateOfVisit());
		UpdateResult writeResult = template.updateFirst(query, update, ClientVisit.class);
		System.out.println(writeResult);
		int rowsAffected = (int) writeResult.getModifiedCount();
		if (rowsAffected == 0) {
			return false;
		} else
			return true;
	}
	@Override
	public boolean isVisitDetailExists(String visitId) {
		ClientVisit VisitDetail = getVisitDetail(visitId);
		if (VisitDetail == null)
			return false;
		else
			return true;
	}
	@Override
	public List<ClientVisit> getVisitsInDescendingOrder() {
		List<ClientVisit> AllVisits = template.findAll(ClientVisit.class, "clientVisit");
		Collections.sort(AllVisits, Collections.reverseOrder());
		List<ClientVisit> upcomingVisit = new ArrayList<ClientVisit>();
		for (int i = 0; i < 5; i++) {
			upcomingVisit.add(AllVisits.get(i));
		}
		return upcomingVisit;
	}
	@Override
	public List<ClientVisit> searchVisitDetailByDate(Date startDate, Date endDate) {
		System.out.println("DAO CALLED");
		Query query = new Query().addCriteria(Criteria.where("dateOfVisit").gt(startDate).lte(endDate));
		System.out.println(startDate);
		System.out.println(endDate);
		return template.find(query, ClientVisit.class);
	}
	@Override
	public List<ClientVisit> getAllCancelled() {

		return template.findAll(ClientVisit.class, "CancelledVisits");
	}
	@Override
	public List<ClientVisit> getUpComingVisits() {
		// TODO Auto-generated method stub
		Date today=new Date();
		Query query=new Query().addCriteria(Criteria.where("dateOfVisit").gte(today));
		return template.find(query, ClientVisit.class);
	}
	@Override
	public List<ClientVisit> getClientVisitByChapter() {
		// TODO Auto-generated method stub		
		return null;
	}
}
