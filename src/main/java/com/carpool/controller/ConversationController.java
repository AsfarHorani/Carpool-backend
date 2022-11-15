package com.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.carpool.model.Conversation;
import com.carpool.model.Customer;
import com.carpool.model.Rider;
import com.carpool.repository.ConversationRepository;
import com.carpool.reqDto.AddConvReqDto;
import com.carpool.service.ConversationService;
import com.carpool.service.CustomerService;
import com.carpool.service.RiderService;

@RestController
public class ConversationController {
	
@Autowired
private ConversationService convService;
@Autowired 
private CustomerService cusSer;
@Autowired
private RiderService rideServ;

   //create conversation
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/createConversation/")
	public ResponseEntity<Conversation> createConversation(@RequestBody AddConvReqDto reqBody){
		long riderId = reqBody.getRiderId();
		long customerId = reqBody.getCustomerId();
		Customer customer = cusSer.getCustomer(customerId);
		Rider rider = rideServ.getRider(riderId);
		Conversation conversation = new Conversation();
		conversation.setCustomer(customer);
		conversation.setRider(rider);
		convService.createConversation(conversation);
		return new ResponseEntity<>(conversation, HttpStatus.OK);
	}
}
