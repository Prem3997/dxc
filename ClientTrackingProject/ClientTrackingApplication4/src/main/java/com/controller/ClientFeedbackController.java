package com.controller;

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

import com.model.ClientFeedback;
import com.model.ClientVisit;
import com.service.ClientFeedbackService;
import com.service.ClientService;
import com.service.ClientVisitService;
import com.service.ProjectService;

@RestController
@RequestMapping("/ClientTrackingApplication/clientFeedback")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class ClientFeedbackController {
	@Autowired
	ClientVisitService clientVisitService;
	@Autowired
	ClientFeedbackService clientFeedbackService;
	@Autowired
	ClientService clientService;
	@Autowired
	ProjectService projectService;

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

	// getting all feedbacks for a specific visit
	@GetMapping("/{visitId}/feedback/")
	public ResponseEntity<Set<ClientFeedback>> getAllfeedbacks(@PathVariable("visitId") String visitId) {
		System.out.println("Get All feedbacks called");
		Set<ClientFeedback> allfeedbacks = clientFeedbackService.getFeedbacks(visitId);
		return new ResponseEntity<Set<ClientFeedback>>(allfeedbacks, HttpStatus.OK);
	}

	// For Updating feedback
	@PutMapping("/{visitId}/feedback/")
	public ResponseEntity<ClientFeedback> updatefeedback(@PathVariable("visitId") String visitId,
			@RequestBody ClientFeedback feedback) {
		System.out.println("update feedback called");
		clientFeedbackService.updateFeedback(visitId, feedback);
		return new ResponseEntity<ClientFeedback>(feedback, HttpStatus.OK);

	}

	// getting all the feedbacks from the db
	@GetMapping("/feedback/")
	public ResponseEntity<List<ClientFeedback>> getAllfeedbacks() {
		System.out.println("Get All feedbacks froms Database called");
		List<ClientFeedback> allfeedbacks = clientFeedbackService.getAllFeedbacks();
		return new ResponseEntity<List<ClientFeedback>>(allfeedbacks, HttpStatus.OK);
	}
}
