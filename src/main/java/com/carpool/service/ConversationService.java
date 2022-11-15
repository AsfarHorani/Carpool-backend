package com.carpool.service;

import com.carpool.model.Conversation;

public interface ConversationService{
   
	public Conversation createConversation(Conversation converstion);
	public void deleteConversation(long converstionId);
    
}
