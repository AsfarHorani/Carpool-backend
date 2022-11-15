package com.carpool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.carpool.exceptionHandler.GeneralException;
import com.carpool.model.Conversation;
import com.carpool.repository.*;
@Service
public class ConversationServiceImp implements ConversationService {

	 @Autowired
	 ConversationRepository convRepository;
	
	@Override
	public Conversation createConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		convRepository.save(conversation);
		return conversation;
	}

	@Override
	public void deleteConversation(long converstionId) {
		// TODO Auto-generated method stub
		Conversation conv = convRepository.findById(converstionId).orElseThrow(()-> new GeneralException("Conversation with id "+converstionId+" not found",HttpStatus.NOT_FOUND));

		convRepository.delete(conv);
	}
    
}
