package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Client;
import com.model.ClientFeedback;
import com.model.ClientVisit;
import com.service.ClientFeedbackService;
import com.service.ClientService;
import com.service.ClientVisitService;
import com.service.ProjectService;

@RestController
@RequestMapping("/ClientTrackingApplication/clientvisit/")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class ClientVisitController {
	@Autowired
	ClientVisitService clientVisitService;
	@Autowired
	ClientFeedbackService clientFeedbackService;
	@Autowired
	ClientService clientService;
	@Autowired
	ProjectService projectService;

	// CRUD//

	// Adding new ClientDetail
	@PostMapping("/{clientId}/")
	public ResponseEntity<ClientVisit> saveDetails(@PathVariable String clientId,@RequestBody ClientVisit clientVisit) {
		System.out.println("Add clientVisit called");
		System.out.println(clientVisit);
		Client client=clientService.getClient(clientId);
		//Project project=projectService.getProject(projectId);
		clientVisit.setClient(client);
		System.out.println(clientVisit);
		if (clientVisitService.isVisitDetailExists(clientVisit.getVisitId())) {
			return new ResponseEntity<ClientVisit>(clientVisit, HttpStatus.CONFLICT);
		} else {
			clientVisitService.addVisitDetails(clientId,clientVisit);
			return new ResponseEntity<ClientVisit>(clientVisit, HttpStatus.CREATED);
		}

	}
	@PostMapping("/addproject/{visitId}/{projectId}/")
	public ResponseEntity<ClientVisit> addProject(@PathVariable("visitId") String visitId,@PathVariable("projectId")String projectId) {
		clientVisitService.addProjectForVisit(visitId, projectId);
		return new ResponseEntity<ClientVisit>(HttpStatus.OK);
	}

	// getting a AllVisitdetail
	@GetMapping
	public ResponseEntity<List<ClientVisit>> getAllVisitDetails() {
		System.out.println("Get AllVisitDetails called");
		List<ClientVisit> allVisitDetails = clientVisitService.getAllVisitDetails();
		return new ResponseEntity<List<ClientVisit>>(allVisitDetails, HttpStatus.OK);
	}

	// getting a single Visitdetail
	@GetMapping("/{visitId}/")
	public ResponseEntity<ClientVisit> getClientVisitDetail(@PathVariable("visitId") String visitId) {
		System.out.println("Get VisitDetail called" + visitId);
		ClientVisit clientVisit = new ClientVisit();
		if (clientVisitService.isVisitDetailExists(visitId)) {
			clientVisit = clientVisitService.getVisitDetail(visitId);
			return new ResponseEntity<ClientVisit>(clientVisit, HttpStatus.OK);
		} else {
			return new ResponseEntity<ClientVisit>(clientVisit, HttpStatus.NO_CONTENT);
		}

	}

	// deleting Visitdetail
	@DeleteMapping("/{visitId}/")
	public ResponseEntity<ClientVisit> deleteVisitdetail(@PathVariable("visitId") String visitId) {
		System.out.println("Delete Visitdetail called" + visitId);
		if (clientVisitService.isVisitDetailExists(visitId)) {
			clientVisitService.deleteVisitDetails(visitId);
			return new ResponseEntity<ClientVisit>(HttpStatus.OK);
		} else {
			return new ResponseEntity<ClientVisit>(HttpStatus.NO_CONTENT);
		}

	}

	// Update Visit details
	@PutMapping
	public ResponseEntity<ClientVisit> updateVisitDetails(@RequestBody ClientVisit clientVisit) {
		System.out.println("Update VisitDetail called");
		System.out.println(clientVisit);
		if (clientVisitService.isVisitDetailExists(clientVisit.getVisitId())) {
			clientVisitService.updateVisitDetails(clientVisit);
			return new ResponseEntity<ClientVisit>(clientVisit, HttpStatus.OK);
		} else {
			return new ResponseEntity<ClientVisit>(clientVisit, HttpStatus.NO_CONTENT);
		}
	}
	// Adding Feedback
	@PostMapping("/{visitId}/feedback/")
	public void saveFeedback(@PathVariable("visitId") String visitId, @RequestBody ClientFeedback feedback) {
		System.out.println("in controller" + feedback);
		clientFeedbackService.addFeedback(visitId, feedback);
		System.out.println(feedback);
	}
	// Deleting Feedback
	@DeleteMapping("/{visitId}/feedback/{feedBackId}/")
	public ResponseEntity<ClientVisit> deleteClientFeedback(@PathVariable("visitId") String visitId,
			@PathVariable("feedBackId") String feedBackId) {
		System.out.println("Delete ClientFeedback called" + feedBackId);
		clientFeedbackService.deleteFeedback(visitId, feedBackId);
		return new ResponseEntity<ClientVisit>(HttpStatus.NO_CONTENT);
	}
	// getting a specific feedback
	@GetMapping("/{visitId}/feedback/{feedBackId}/")
	public ResponseEntity<ClientFeedback> getFeedBack(@PathVariable("visitId") String visitId,
			@PathVariable("feedBackId") String feedBackId) {
		System.out.println("Get feedback called");
		ClientFeedback feedback = new ClientFeedback();
		feedback = clientFeedbackService.getFeedback(visitId, feedBackId);
		return new ResponseEntity<ClientFeedback>(feedback, HttpStatus.OK);
	}
	// Get all feedbacks
	@GetMapping("/{visitId}/feedback/")
	public ResponseEntity<Set<ClientFeedback>> getAllfeedbacks(@PathVariable("visitId") String visitId) {
		System.out.println("Get All feedbacks called");
		Set<ClientFeedback> allfeedbacks = clientFeedbackService.getFeedbacks(visitId);
		return new ResponseEntity<Set<ClientFeedback>>(allfeedbacks, HttpStatus.OK);
	}
	// Update feedback
	@PutMapping("/{visitId}/feedback/")
	public ResponseEntity<ClientFeedback> updatefeedback(@PathVariable("visitId") String visitId,
			@RequestBody ClientFeedback feedback) {
		System.out.println("update feedback called");
		clientFeedbackService.updateFeedback(visitId, feedback);
		return new ResponseEntity<ClientFeedback>(feedback, HttpStatus.OK);

	}
	// SPECIAL MAPPINGS//
	// get visitId From FeedbackId
	@GetMapping("/feedback/{feedBackId}/")
	public ResponseEntity<String> getDetails(@PathVariable("feedBackId") String feedBackId) {
		ClientVisit clientVisit = new ClientVisit();
		String VisitId = clientVisit.getVisitId();
		VisitId = clientFeedbackService.getVisitId(feedBackId);
		return new ResponseEntity<String>(VisitId, HttpStatus.OK);
	}
	@GetMapping("/feedback/")
	public ResponseEntity<List<ClientFeedback>> getAllfeedbacks() {
		System.out.println("Get All feedbacks froms Database called");
		List<ClientFeedback> allfeedbacks = clientFeedbackService.getAllFeedbacks();
		return new ResponseEntity<List<ClientFeedback>>(allfeedbacks, HttpStatus.OK);
	}
	// to get VISITSDetails in descending order of dates
	@GetMapping("/InOrder/")
	public ResponseEntity<List<ClientVisit>> getVisitsInDescending() {
		System.out.println("Get VisitsInDescending Order of Dates called");
		List<ClientVisit> allVisits = clientVisitService.getVisitsInDescendingOrder();
		return new ResponseEntity<List<ClientVisit>>(allVisits, HttpStatus.OK);
	}
	// get visitId From FeedbackId
	@GetMapping("/visitdetails/{feedBackId}/")
	public ResponseEntity<List<ClientVisit>> getVisitDetails(@PathVariable("feedBackId") String feedBackId) {
		List<ClientVisit> allClientVisit = clientFeedbackService.getVisit(feedBackId);
		return new ResponseEntity<List<ClientVisit>>(allClientVisit, HttpStatus.OK);
	}
	// get list Searched Dates
	@GetMapping("/date/{start}/{end}/")
	public ResponseEntity<List<ClientVisit>> getVisitDetailsBetweenDate(@PathVariable("start") String start,
			@PathVariable("end") String end) throws ParseException {
		Date startDate = new SimpleDateFormat("dd-MM-yyyy").parse(start);
		Date endDate = new SimpleDateFormat("dd-MM-yyyy").parse(end);
		List<ClientVisit> allClientVisit = clientVisitService.searchVisitDetailByDate(startDate, endDate);
		return new ResponseEntity<List<ClientVisit>>(allClientVisit, HttpStatus.OK);
	}
	// get All cancelled visits
	@GetMapping("/cancelled/")
	public ResponseEntity<List<ClientVisit>> getAllCancelled() {
		System.out.println("Get Cancelled called");
		List<ClientVisit> allVisitDetails = clientVisitService.getAllCancelled();
		return new ResponseEntity<List<ClientVisit>>(allVisitDetails, HttpStatus.OK);
	}
	@GetMapping("/upcomingvisits/")
	public ResponseEntity<List<ClientVisit>>getUpComingVisits(){
		System.out.println("UpcomingVisit Controller Called");
		List<ClientVisit> upComingClientVisits=clientVisitService.getUpComingVisits();
		return new ResponseEntity<List<ClientVisit>>(upComingClientVisits,HttpStatus.OK);
	}
	
	@GetMapping("/SearchByChapter/{chapterName}")
	public ResponseEntity<List<ClientVisit>>getVistsByChapter(@PathVariable("chapterName") String chapterToWhichBelongs){
		System.out.println("Search Vists by CHapter Called");
		List<ClientVisit> clientVisitsByChapter=clientVisitService.getClientVisitByChapter(chapterToWhichBelongs);
		return new ResponseEntity<List<ClientVisit>>(clientVisitsByChapter,HttpStatus.OK);
	}
	
}
