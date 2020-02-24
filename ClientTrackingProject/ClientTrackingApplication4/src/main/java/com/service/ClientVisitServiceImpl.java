package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ClientVisitDAO;
import com.model.ClientVisit;
@Service
public class ClientVisitServiceImpl implements ClientVisitService {
	@Autowired
	ClientVisitDAO clientVisitDAO;

	@Override
	public boolean addVisitDetails(String clientId,ClientVisit clientVisit) {
		clientVisitDAO.addVisitDetails(clientId,clientVisit);
		return false;
	}

	@Override
	public ClientVisit getVisitDetail(String visitId) {
		// TODO Auto-generated method stub
		return clientVisitDAO.getVisitDetail(visitId);
	}

	@Override
	public List<ClientVisit> getAllVisitDetails() {
		// TODO Auto-generated method stub
		return clientVisitDAO.getAllVisitDetails();
	}

	@Override
	public boolean deleteVisitDetails(String visitId) {
		// TODO Auto-generated method stub
		return clientVisitDAO.deleteVisitDetails(visitId);
	}

	@Override
	public boolean updateVisitDetails(ClientVisit clientVisit) {
		// TODO Auto-generated method stub
		return clientVisitDAO.updateVisitDetails(clientVisit);
	}

	@Override
	public boolean isVisitDetailExists(String visitId) {
		// TODO Auto-generated method stub
		return clientVisitDAO.isVisitDetailExists(visitId);
	}

	@Override
	public List<ClientVisit> searchVisitDetailByDate(Date startDate,Date endDate) {
		// TODO Auto-generated method stub
		return clientVisitDAO.searchVisitDetailByDate(startDate,endDate);
	}

	@Override
	public List<ClientVisit> getAllCancelled() {
		// TODO Auto-generated method stub
		return clientVisitDAO.getAllCancelled();
	}

	@Override
	public List<ClientVisit> getUpComingVisits() {
		// TODO Auto-generated method stub
		return clientVisitDAO.getUpComingVisits();
	}

	@Override
	public boolean addProjectForVisit(String visitId, String projectId) {
		// TODO Auto-generated method stub
		return clientVisitDAO.addProjectForVisit(visitId, projectId);
	}

	@Override
	public List<ClientVisit> getClientVisitByChapter(String chapterToWhichBelongs) {
		// TODO Auto-generated method stub
		return clientVisitDAO.getClientVisitByChapter(chapterToWhichBelongs);
	}

	@Override
	public List<ClientVisit> getCompletedVisits() {
		// TODO Auto-generated method stub
		return clientVisitDAO.getCompletedVisits();
	}


}
