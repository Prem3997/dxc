package com.service;

import java.util.Date;
import java.util.List;

import com.model.ClientVisit;

public interface ClientVisitService {
	public boolean addVisitDetails(String clientId, ClientVisit clientVisit);

	public boolean deleteVisitDetails(String visitId);

	public boolean updateVisitDetails(ClientVisit clientVisit);

	public ClientVisit getVisitDetail(String visitId);

	public List<ClientVisit> getAllVisitDetails();

	public boolean isVisitDetailExists(String visitId);

	// for searching visit between dates
	public List<ClientVisit> searchVisitDetailByDate(Date startDate, Date endDate);

	// for getting cancelled visits
	public List<ClientVisit> getAllCancelled();

	public List<ClientVisit> getUpComingVisits();

	public boolean addProjectForVisit(String visitId, String projectId);

	public List<ClientVisit> getClientVisitByChapter(String chapterToWhichBelongs);

	public List<ClientVisit> getCompletedVisits();

}
